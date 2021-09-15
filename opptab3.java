package view;


import java.util.ArrayList;

import carsort_example.Car;
import controller.oopcontroller;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TextArea;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import model.closecontact;

public class opptab3 extends Tab {
	
	public opptab3(controller.oopcontroller control)
	{
	setText("Close Contacts");
	// tab 3
	ArrayList<closecontact> closecontact;
	
	//showing close contacts
	Label contactlabel = new Label("Contact List");
	TextArea contactarea = control.gettable();
	
	Button sortName = new Button("Sort Name");
	Button sortDate = new Button("Sort Date");
	
	GridPane gridpane3 = new GridPane();
	gridpane3.setAlignment(Pos.CENTER);
	gridpane3.setHgap(10);
	gridpane3.setVgap(10);
	gridpane3.setPadding(new Insets(25,25,25,25));
	setClosable(false);
	gridpane3.add(contactlabel, 0, 0);
	gridpane3.add(contactarea, 0, 1);
	gridpane3.add(sortName, 0, 2);
	gridpane3.add(sortDate, 0, 3);
	setContent(gridpane3);
	
	sortName.setOnAction(e ->
	control.sortByName()
		);
	
	sortDate.setOnAction(e ->
	control.sortByDate()
		);
	}
	
}
