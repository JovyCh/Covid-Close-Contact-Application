package controller;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Optional;

import javafx.collections.ObservableList;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import model.DateComparator;
import model.closecontact;
import model.contact;
import javafx.scene.control.Alert.AlertType;

public class oopcontroller implements Serializable{
	
	// arraylist
	private static ArrayList<contact> contacts = new ArrayList<contact>();
	private static ArrayList<closecontact> closecontacts = new ArrayList<closecontact>();

	ListView<String> listview1 = new ListView<String>();
	ListView<String> listview2 = new ListView<String>();
	
	TextArea table = new TextArea();
	
	public void addcontact(String fname, String lname, String id, String phone, Text actiontarget, TextField fnamet, TextField lnamet, TextField idt, TextField phonet) {
		
		if (fname.isEmpty() || lname.isEmpty() || id.isEmpty() || phone.isEmpty()) {
			actiontarget.setText("Please fill out all required information");
		}
		else {
			try {
			// attributes changing id and phone to int
			int idint = Integer.parseInt(id);
			int phoneint = Integer.parseInt(phone);
			contacts.add(new contact(fname,lname,idint,phoneint));
			actiontarget.setText("Data has been added.");
			System.out.println("Thank you " + fname + " " + lname + " " + id + " " + phone);	
			
			}catch (NumberFormatException nfe) {
				actiontarget.setText("Please enter a valid number for phone and id");
				System.out.println("Please enter a valid number for phone and id");
			}

		}
		fnamet.clear();
		lnamet.clear();
		idt.clear();
		phonet.clear();
	};
	
	public void removecontact(String fname, String lname, String id, String phone, Text actiontarget, TextField fnamet, TextField lnamet, TextField idt, TextField phonet) {
		
		
		if (fname.isEmpty() || lname.isEmpty() || id.isEmpty() || phone.isEmpty()) {
			actiontarget.setText("Please enter valid contact information.");
		}
		else {
			try {
		// attributes changing id and phone to int
			int idint = Integer.parseInt(id);
			int phoneint = Integer.parseInt(phone);

			for(int i = 0; i <= contacts.size(); i++) {
				contact removecontact = contacts.get(i);
				String rfname = removecontact.getFirstName();
				String rlname = removecontact.getLastName();
				int rid = removecontact.getid();
				int rphone = removecontact.getphone();
				if (rfname.equals(fname) && rlname.equals(lname) && (rid == idint) && (rphone == phoneint)) {
					contacts.remove(removecontact);
					}
				else {
					actiontarget.setText("Please enter valid contact information.");
				}
				};
			}catch (NumberFormatException nfe) {
				actiontarget.setText("Please enter a valid number for phone and id");
				System.out.println("Please enter a valid number for phone and id");
			}
		}
		fnamet.clear();
		lnamet.clear();
		idt.clear();
		phonet.clear();
	}
	
	public void listcontact(String fname, String lname, String id, String phone, Text actiontarget, TextArea textarea, TextField fnamet, TextField lnamet, TextField idt, TextField phonet) {
		
		String display = "";
		
		textarea.clear();
		for (int i = 0; i < contacts.size(); i++) {
			contact currentcontact = contacts.get(i);
			display = display + "Contact " + (i + 1) + currentcontact.toString();
		}
		
		textarea.appendText(display);
		
		fnamet.clear();
		lnamet.clear();
		idt.clear();
		phonet.clear();
	}
		
	
	public void loadcontact(Text actiontarget, TextArea textarea, TextField fnamet, TextField lnamet, TextField idt, TextField phonet) {
//		try {
//			FileReader ContactRead = new FileReader("contact.txt"); // change this too where the contact file would be placed
//			BufferedReader inputfile = new BufferedReader(ContactRead);
//			String contactfile = inputfile.readLine();
//			
//			textarea.clear();
//			
//			contacts.clear();
//			while(contactfile != null) {
//				String[] objects = contactfile.split(",");
//				contacts.add(new contact(objects[0],objects[1],Integer.parseInt(objects[2]),Integer.parseInt(objects[3])));
//				contactfile = inputfile.readLine();
//				}
//				textarea.appendText(list(contacts));
//				inputfile.close();
//				actiontarget.setText("Data has been loaded.");
//				for(int i = 0; i < contacts.size(); i++) {
//					contact currentcontact = contacts.get(i);
//					listview1.getItems().add(currentcontact.getFirstName() + "\t\t" + currentcontact.getLastName());
//					listview2.getItems().add(currentcontact.getFirstName() + "\t\t" + currentcontact.getLastName());
//				}
//
//		} catch (FileNotFoundException e1) {
//			System.out.println("File hasn't been found.");;
//		} catch (IOException e1) {
//			System.out.println("Io error.");
//		}
//	}
		  {
			  try
			   {
				textarea.clear();
				  FileInputStream fs = new FileInputStream("contact.txt");
			     ObjectInputStream is = new ObjectInputStream(fs);  
			     contacts = (ArrayList<contact>) is.readObject();
			     System.out.print(contacts.toString());
			     textarea.appendText(contacts.toString());
			     actiontarget.setText("File has been loaded!");
			     is.close() ;  
					for(int i = 0; i < contacts.size(); i++) {
						contact currentcontact = contacts.get(i);
						listview1.getItems().add(currentcontact.getFirstName() + "\t\t" + currentcontact.getLastName());
						listview2.getItems().add(currentcontact.getFirstName() + "\t\t" + currentcontact.getLastName());
					}
			   } 
			   catch (Exception ex) {
			     System.out.println("could not load");
			     actiontarget.setText("File is unable to load!");
			     ex.printStackTrace();
			   }
			      }
			fnamet.clear();
			lnamet.clear();
			idt.clear();
			phonet.clear();
	}
		
	public void savecontact(Text actiontarget, TextArea textarea, TextField fnamet, TextField lnamet, TextField idt, TextField phonet) {
//		try {
//			String displayfile = "";
//			FileWriter contactfile = new FileWriter("contact.txt");
//
//			for (int i = 0; i < contacts.size(); i++) {
//				contact currentcontact = contacts.get(i);
//				displayfile = displayfile + currentcontact.getFirstName() + "," + currentcontact.getLastName() + "," + currentcontact.getid() + "," + currentcontact.getphone() + "\n";
//			} 
//			contactfile.write(displayfile);
//			contactfile.close();
//			actiontarget.setText("Data has been saved.");
//		}catch(Exception e1) {
//			System.out.print("There has been a error!");
//		}
//		fnamet.clear();
//		lnamet.clear();
//		idt.clear();
//		phonet.clear();
//	}
		  {
			  try
			   {
				FileOutputStream fs = new FileOutputStream("contact.txt");
			    ObjectOutputStream os = new ObjectOutputStream(fs);
			    os.writeObject(contacts);
			    os.close();
			    } catch (Exception ex) {
			     System.out.println("could not save");
			     ex.printStackTrace();
			   }
			  
		}
		fnamet.clear();
		lnamet.clear();
		idt.clear();
		phonet.clear();
	}
	
	public void exit(Stage primaryStage) {
		
		Alert alert = new Alert(AlertType.CONFIRMATION);
		alert.setTitle("Would you like to save before you exit?");
		ButtonType save_exit = new ButtonType("Save and Exit");
		ButtonType just_exit = new ButtonType("Don't save and Exit");
		
		alert.getButtonTypes().setAll(save_exit, just_exit);
		
		Optional<ButtonType> result = alert.showAndWait();
		if (result.get() == save_exit) {
			save(contacts);
			primaryStage.close();
		}
		else {
			primaryStage.close();
		}
	}
	public void windowclose(Stage primaryStage) {
		
		Alert alert = new Alert(AlertType.CONFIRMATION);
		alert.setTitle("Would you like to save before you exit?");
		ButtonType save_exit = new ButtonType("Save and Exit");
		ButtonType just_exit = new ButtonType("Don't save and Exit");
		
		alert.getButtonTypes().setAll(save_exit, just_exit);
		
		Optional<ButtonType> result = alert.showAndWait();
		if (result.get() == save_exit) {
			  try
			   {
				FileOutputStream fs = new FileOutputStream("contact.txt");
			    ObjectOutputStream os = new ObjectOutputStream(fs);
			    os.writeObject(contacts);
			    os.close();
			    primaryStage.close();
			    } catch (Exception ex) {
			     System.out.println("could not save");
			     ex.printStackTrace();
			   }

		}
		else {
			primaryStage.close();
		}
	}
//	public void load(TextArea PeopleTextField) {
//		try {
//			FileReader ContactRead = new FileReader("contact.txt");
//			BufferedReader inputfile = new BufferedReader(ContactRead);
//			String contactfile = inputfile.readLine();
//			
//			PeopleTextField.clear();
//			
//			while(contactfile != null) {
//				String[] objects = contactfile.split(",");
//				contacts.add(new contact(objects[0],objects[1],Integer.parseInt(objects[2]),Integer.parseInt(objects[3])));
//				contactfile = inputfile.readLine();
//				}
//			PeopleTextField.appendText(list(contacts));
//				inputfile.close();
//				
//		} catch (FileNotFoundException e1) {
//			System.out.println("File hasn't been found.");;
//		} catch (IOException e1) {
//			System.out.println("Io error.");
//		}
	public String list(ArrayList<contact> contacts) {
		String display = "";
		for (int i = 0; i < contacts.size(); i++) {
			contact currentcontact = contacts.get(i);
			display = display + "Contact " + (i + 1) + currentcontact.toString();
		}
		return display;
	}
	
	public void save(ArrayList<contact> contacts) {
		try {
			String displayfile = "";
			FileWriter contactfile = new FileWriter("contact.txt");

			for (int i = 0; i < contacts.size(); i++) {
				contact currentcontact = contacts.get(i);
				displayfile = displayfile + currentcontact.getFirstName() + "," + currentcontact.getLastName() + "," + currentcontact.getid() + "," + currentcontact.getphone() + "\n";
			} 
			contactfile.write(displayfile);
			contactfile.close();
		}catch(Exception e1) {
			System.out.print("There has been a error!");
		}
	}
	
	public static ArrayList<contact> addcontactlist() {
		return contacts;
	}
	
	public static ArrayList<closecontact> getCloseContact() {;
		return closecontacts;
	}
	
	public void addclosecontact( ListView<String> list1,ListView<String> list2, DatePicker date, ComboBox<Integer> hour, ComboBox<Integer> minute, Text message) {

		ObservableList<String> name1;
        name1 = list1.getSelectionModel().getSelectedItems();
		ObservableList<String> name2;
        name2 = list2.getSelectionModel().getSelectedItems();
        String display = "";
        table.clear();
        if (name1.isEmpty() || name2.isEmpty() || date.getValue() == null || hour.getValue() == null|| minute.getValue() == null) {
			message.setText("Please fill out all required information");
		}
        
        else if (name1.equals(name2)) {
        	message.setText("You cannot select the same person.");
        }
		else {

			System.out.println(name1);
			System.out.println(name2);
			closecontact closecont = new closecontact(name1, name2, date.getValue(), hour.getValue(), minute.getValue(), list1.getSelectionModel().getSelectedItem(), list2.getSelectionModel().getSelectedItem());
	        closecontacts.add(closecont);
	        
			message.setText("Data has been added.");
		}
        for(int i = 0; i < closecontacts.size(); i++) {
				closecontact currentclose = closecontacts.get(i);
				display = display + "Close Contact " + (i + 1) + currentclose.toString();
				System.out.println(closecontacts.get(i));
			}
        

		table.appendText(display);
		
        list1.getSelectionModel().clearSelection();
        list2.getSelectionModel().clearSelection();
        hour.setValue(null);
        minute.setValue(null);
        date.setValue(null);
	};
	
	public ListView<String> getList1() {
		return listview1;
	}
	public ListView<String> getList2() {
		return listview2;
	}
	public TextArea gettable() {
		return table;
	}
	
	
	public void sortByName() {
		String list = "";
		Collections.sort(closecontacts); 
		table.clear();
		for (closecontact c : closecontacts)
		{
			list += "\nName1:\t\t" + c.getname1() + "\nName2:\t\t" + c.getname2() + "\nDate:\t\t" + c.getdate() + "\nTime:\t\t" + c.gettime() 
					+ "\n\n"; ;
		}
		table.appendText(list);
	
	}
	public void sortByDate() {	
		String list = "";
		DateComparator DateComparator = new DateComparator();
		Collections.sort(closecontacts, DateComparator);
		table.clear();
		for (closecontact c : closecontacts)
			
		{
			list += "\nName1:\t\t" + c.getname1() + "\nName2:\t\t" + c.getname2() + "\nDate:\t\t" + c.getdate() + "\nTime:\t\t" + c.gettime() 
					+ "\n\n"; ;
		}
		table.appendText(list);
	}
	
	
}