package model;

import java.util.Comparator;

import javafx.collections.ObservableList;

public class NameComparator implements Comparator<closecontact>{
	 public int compare (closecontact c1, closecontact c2) {
		 
		  ObservableList<String> md1 = c1.getName1();
		  ObservableList<String> md2 = c2.getName2();
		  return ((closecontact) md1).compareTo((closecontact) md2);
	  }
}
