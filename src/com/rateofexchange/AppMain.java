package com.rateofexchange;

import java.util.ArrayList;
import java.util.Arrays;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import com.rateofexchange.model.Currency;
import com.rateofexchange.model.CurrencyList;
import com.rateofexchange.parser.CurrencyParser;
import com.rateofexchange.parser.vendors.CBRVendor;
import com.rateofexchange.parser.vendors.Vendor;

public class AppMain extends Application {

	@Override
	public void start(Stage stage) throws Exception {		
		
		tField = new TextField("");
		btn_click = new Button("Receive rate");
		lb_text = new Label("");
		comboBox = new ComboBox<>();
		Vendor cbr = new CBRVendor();
		CurrencyParser parser = new CurrencyParser(cbr);
		CurrencyList list = parser.parse();
		for (Currency cur : list) {
			comboBox.getItems().addAll(cur.getCharCode());	
		}
		
		comboBox.setPromptText("Choose currency");
		
		lb_text.getStyleClass().add("myCustomLabel");
		tField.getStyleClass().add("myCustomField");
		comboBox.getStyleClass().add("myCustomComboBox");
		
		btn_click.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
				String args;
				//args=tField.getText();
				args=comboBox.getValue();
				Vendor cbr = new CBRVendor();
				CurrencyParser parser = new CurrencyParser(cbr);
				ArrayList<String> selectedCurrs = new ArrayList<String>(Arrays.asList(args));
				CurrencyList list = parser.parse();
				if (list == null)
					return;
				for (Currency cur : list) {
					if (selectedCurrs.contains(cur.getCharCode())) {	
						args=cur.getDisplayName() + " (" + cur.getCharCode() + ")\t" + cur.getCurRate();
						lb_text.setText(args);
					}
				}
			}
		});
		
		VBox root = new VBox();
		root.getChildren().addAll(comboBox,lb_text,btn_click);

		Scene scene = new Scene(root,800,400);
		stage.setScene(scene);
		
		scene.getStylesheets().add(AppMain.class.getResource("Style.css").toExternalForm());
		
		stage.show();
		
	}

	Label lb_text;
	Button btn_click;
	TextField tField;
	ComboBox<String> comboBox;
	
	public static void main(String[] args) {
		launch(args);
	}
}
