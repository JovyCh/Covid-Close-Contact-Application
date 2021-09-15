package view;

import controller.oopcontroller;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class Main extends Application {
	private static oopcontroller oopcontrol = new oopcontroller();
	@Override
	public void start(Stage primaryStage) {
		try {
		BorderPane mainPane = new BorderPane();	
		
		Button exitbtn = new Button("Exit");
		
		HBox exithbbtn = new HBox(10);
		exithbbtn.setAlignment(Pos.BOTTOM_RIGHT);
		exithbbtn.getChildren().add(exitbtn);
		exithbbtn.setPadding(new Insets(0,20,20,0));

	      TabPane tp = new TabPane();
	      tp.getTabs().add (new ooptab1(oopcontrol));
	      tp.getTabs().add (new ooptab2(oopcontrol));
	      tp.getTabs().add (new opptab3(oopcontrol));
	      
		  mainPane.setTop(tp);
		  mainPane.setBottom(exithbbtn);
	      	
		primaryStage.setScene(new Scene(mainPane, 500, 500));
		
		primaryStage.show();
		// Action for exit
		exitbtn.setOnAction(e ->
		oopcontrol.exit(primaryStage)
		);
		primaryStage.setOnCloseRequest(e ->
		oopcontrol.windowclose(primaryStage)
		);
		
		} catch(Exception e) {
			e.printStackTrace();
		}
	}


	public static void main(String[] args) {
		launch(args);
	}
}
