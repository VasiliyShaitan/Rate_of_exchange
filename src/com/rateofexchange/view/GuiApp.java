package com.rateofexchange.view;

import com.sun.imageio.plugins.common.LZWStringTable;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.effect.DropShadow;
import javafx.scene.effect.Reflection;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class GuiApp extends Application {

	@Override
	public void start(Stage stage) throws Exception {
		
		/*DropShadow ds = new DropShadow();
		ds.setOffsetY(5.0);
		ds.setOffsetX(5.0);
		ds.setColor(Color.GRAY);*/
		
		/*Reflection reflection = new Reflection();
		reflection.setFraction(0.8);
		reflection.setTopOffset(-20);*/
		
		lb_text = new Label("Here some text");
		btn_click = new Button("Click it");
		tField = new TextField("D");
		
		//btn_click.setEffect(ds);
		//lb_text.setEffect(reflection);
		
		//lb_text.getStyleClass().add("myCustomLabel");
		
		btn_click.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
				//lb_text.setText("New Text");
				String s;
				s=tField.getText();
				lb_text.setText(s);
			}
		});
		
		VBox root = new VBox();
		root.getChildren().addAll(lb_text,btn_click,tField);

		Scene scene = new Scene(root,500,500);
		stage.setScene(scene);
		
		//scene.getStylesheets().add(GuiApp.class.getResource("myStyle.css").toExternalForm());
		
		stage.show();
	}

	Label lb_text;
	Button btn_click;
	TextField tField;
	
	public static void main(String[] args) {
		launch(args);
	}
}
