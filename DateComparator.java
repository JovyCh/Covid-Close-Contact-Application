package model;

import java.time.LocalDate;
import java.util.Comparator;

public class DateComparator implements Comparator<closecontact>{
	 
	public int compare (closecontact c1, closecontact c2) {
		  LocalDate id1 = c1.getdate();
		  LocalDate id2 = c2.getdate();
		  return id1.compareTo(id2); // date compareTo()
	  }
}
