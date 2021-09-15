package view;

import java.io.Serializable;

import controller.oopcontroller;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class ooptab1 extends Tab implements Serializable{
		
	public ooptab1(controller.oopcontroller control) {
		   setText("Register Contact");
			
			// textbox for tab1
			Text actiontarget = new Text();
			
			// Asking user for information using text fields
			
			Text sceneTitle = new Text("------Contacts-----");
			
			Label fName = new Label("Enter First Name:");
			
			TextField fnameTextField = new TextField();
			
			Label lName = new Label("Enter Last Name:");
			
			TextField lnameTextField = new TextField();
			
			Label ID = new Label("Enter User ID:");
			
			TextField IDTextField = new TextField();
			
			Label Phone = new Label("Enter Phone Number:");
			
			TextField PhoneTextField = new TextField();
			
			//Buttons to modify data
			
			Button addbtn = new Button("Add");
			Button removebtn = new Button("Remove");
			Button Listbtn = new Button("List");
			
			HBox firsthbBtn = new HBox(10);
			firsthbBtn.setAlignment(Pos.BOTTOM_LEFT);
			firsthbBtn.getChildren().addAll(addbtn,removebtn,Listbtn);
			
			
			// TextArea underneath buttons
			
			TextArea PeopleTextField = new TextArea("People in the Application");
			PeopleTextField.setPrefWidth(300);
			PeopleTextField.setPrefHeight(100);
			
			// Buttons underneath text field
			
			Button loadbtn = new Button("Load");
			Button savebtn = new Button("Save");
			
			HBox secondhbBtn = new HBox(10);
			secondhbBtn.setAlignment(Pos.BOTTOM_LEFT);
			secondhbBtn.getChildren().addAll(loadbtn, savebtn);
		
			// adding all into tab 1
			GridPane grid1 = new GridPane();
			grid1.setAlignment(Pos.CENTER);
			grid1.setHgap(10);
			grid1.setVgap(10);
			grid1.setPadding(new Insets(25,25,25,25));
			setClosable(false);
			grid1.add(sceneTitle, 0, 0, 2, 1);
			grid1.add(fName, 0, 1);
			grid1.add(fnameTextField, 1, 1);
			grid1.add(lName, 0, 2);
			grid1.add(lnameTextField, 1, 2);
			grid1.add(ID, 0, 3);
			grid1.add(IDTextField, 1, 3);
			grid1.add(Phone, 0, 4);
			grid1.add(PhoneTextField, 1, 4);
			grid1.add(firsthbBtn, 0, 5);
			grid1.add(PeopleTextField, 0, 6);
			grid1.add(secondhbBtn, 0, 7);
			grid1.add(actiontarget, 0, 8);
			setContent(grid1);
			// Action for add button
			
			addbtn.setOnAction(e -> 
				control.addcontact(fnameTextField.getText(), lnameTextField.getText(),IDTextField.getText(), PhoneTextField.getText(), actiontarget, fnameTextField, lnameTextField, IDTextField, PhoneTextField)
				);

			// Action for remove
			
			removebtn.setOnAction(e ->
			control.removecontact(fnameTextField.getText(), lnameTextField.getText(), IDTextField.getText(), PhoneTextField.getText(), actiontarget, fnameTextField, lnameTextField, IDTextField, PhoneTextField)
				);
			
			// Action for list
			
			Listbtn.setOnAction(e ->
			control.listcontact(fnameTextField.getText(), lnameTextField.getText(), IDTextField.getText(), PhoneTextField.getText(), actiontarget, PeopleTextField, fnameTextField, lnameTextField, IDTextField, PhoneTextField)
				);
				
			// Action for load
			
			loadbtn.setOnAction(e ->
			control.loadcontact(actiontarget, PeopleTextField, fnameTextField, lnameTextField, IDTextField, PhoneTextField)
				);
			
			// Action for save
			
			savebtn.setOnAction(e ->
			control.savecontact(actiontarget, PeopleTextField, fnameTextField, lnameTextField, IDTextField, PhoneTextField)
				);
	}
}
