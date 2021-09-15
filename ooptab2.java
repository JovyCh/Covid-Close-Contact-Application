package view;

import controller.oopcontroller;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.Tab;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import model.contact;

public class ooptab2 extends Tab{
	
	public ooptab2(controller.oopcontroller control) {
	setText("Close Contact");
	
	Button exitbtn = new Button("Exit");
	HBox exithbbtn = new HBox(10);
	exithbbtn.setAlignment(Pos.BOTTOM_RIGHT);
	exithbbtn.getChildren().add(exitbtn);
	
	// list view 
	Label person1 = new Label("Person 1");
	Label person2 = new Label("Person 2");
	ListView<String> listview1 = control.getList1();
	ListView<String> listview2 = control.getList2();
	
	// date time
	DatePicker datepicker = new DatePicker();
	ComboBox<Integer> hours = new ComboBox<Integer>();
	ComboBox<Integer> minutes = new ComboBox<Integer>();
	
	for (int i = 0; i < 24; i++) {
		hours.getItems().add(i);
	}
	
	for (int i = 0; i < 60; i++) {
		minutes.getItems().add(i);
	}

	Label date = new Label("Enter Date:");
	Label Hour = new Label("Enter Hour:");
	Label Minute = new Label("Enter Minute:");
	
	// buttons
	
	Button addbtn2 = new Button("Add");
	
	// msg for user
	Text tab2message = new Text();
	
	// grid
	GridPane grid2 = new GridPane();


	grid2.setAlignment(Pos.CENTER);
	grid2.setHgap(10);
	grid2.setVgap(10);
	grid2.setPadding(new Insets(25,25,25,25));
	setClosable(false);
	grid2.add(person1, 0, 0);
	grid2.add(person2, 1, 0);
	grid2.add(listview1, 0, 1);
	grid2.add(listview2, 1, 1);
	grid2.add(date, 0, 2);
	grid2.add(datepicker, 1, 2);
	grid2.add(Hour, 0, 4);
	grid2.add(hours, 1, 4);
	grid2.add(Minute, 0, 5);
	grid2.add(minutes, 1, 5);
	grid2.add(addbtn2, 0, 6);
	grid2.add(exithbbtn, 1, 6);
	grid2.add(tab2message, 0, 7);
	setContent(grid2);
	// Action for exit
	
//	exitbtn.setOnAction(e ->
//		oopcontrol.exit(primaryStage)
//		);
	
//	// action for add2
	addbtn2.setOnAction(e ->
			control.addclosecontact(listview1, listview2, datepicker, hours, minutes, tab2message)
			);
	}

}
