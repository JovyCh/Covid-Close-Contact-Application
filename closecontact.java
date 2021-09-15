package model;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.chrono.ChronoLocalDate;

import javafx.collections.ObservableList;

public class closecontact implements Comparable<closecontact>{

    private ObservableList<String> Name1 = null;
    private ObservableList<String> Name2 = null;
    private LocalDate date;
    private LocalTime time;
    private String name1;
    private String name2;

    public closecontact(ObservableList<String> Name1, ObservableList<String> Name2, LocalDate date, int hour, int minute, String name1, String name2) {
        this.Name1 = Name1;
        this.Name2 = Name2;
        this.name1 = name1;
        this.name2 = name2;
        this.date = date;
        this.time = LocalTime.of(hour, minute);
    }


	public ObservableList<String> getName1() {
        return Name1;
    }

    public void setName1(ObservableList<String> Name1) {
        this.Name1 = Name1;
    }

    public ObservableList<String> getName2() {
        return Name2;
    }

    public void setName2(ObservableList<String> Name2) {
        this.Name2 = Name2;
    }
	
    public String getname1() {
        return name1;
    }

    public void setname1(String name1) {
        this.name1 = name1;
    }

    public String getname2() {
        return name2;
    }

    public void setname2(String name2) {
        this.name2 = name2;
    }
    
    public LocalDate getdate() {
        return date;
    }

    public void Setdate(LocalDate value){
        this.date = value;
    }
    
    public LocalTime gettime() {
        return time;
    }

    public void settime(int hour, int minute) {
        this.time = LocalTime.of(hour, minute);
    }
    

    public String toString() {
    	return "\nName1:\t\t" + name1 + "\nName2:\t\t" + name2 + "\nDate:\t\t" + date + "\nTime:\t\t" + time 
		+ "\n\n";
    }
    
	public int compareTo(closecontact n){
		// we compare to another contact
	
	   int lastCmp = ((closecontact) this.Name1).compareTo((closecontact) n.getName1()); // compare to 
	   if (lastCmp != 0)
		  
		   return lastCmp;
	   else
	       return  ((closecontact) Name1).compareTo((closecontact) n.getName1()); // compare to 
	   
	}
}


