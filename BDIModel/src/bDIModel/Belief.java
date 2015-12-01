package bDIModel;

import java.util.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
//import java.time.format.DateTimeFormatter;


/**
 * The Belief class instantiates each Belief 
 * with initDate, validatedDate and Goal associated 
 * with the Belief. The beliefValidate is the Event
 * that validates the Belief.
 * 
 * @author NandaKumar Derek Moayad
 *
 */
public class Belief {
	String name,fact;
	Date initDate,validatedDate;
	String beliefGoal;
	String beliefValidate;
	
	/**
	 * The Belief constructor instantiates a Belief object
	 * with initDate, validatedDate and Goal associated 
	 * with the Belief.
	 * @param attributes
	 */
	public Belief(String[][] attributes){
		for(int i = 0; i < attributes.length; i++){
			if(attributes[i][0].toLowerCase() == "name"){
				this.name = attributes[i][1];
			}
			else if(attributes[i][0].toLowerCase() == "beliefgoal"){
				this.beliefGoal = attributes[i][1];
			}
			else if(attributes[i][0].toLowerCase() == "beliefvalidate"){
				this.beliefValidate = attributes[i][1];
			}
			else if(attributes[i][0].toLowerCase() == "fact"){
				this.fact = attributes[i][1];
			}
			this.initDate = new Date();
			this.validatedDate = this.initDate;
		}
	}

	/**
	 * The getBeliefValidate returns the beliefValidate
	 * Event associated with this Belief.
	 * @return The Event that validates this Belief
	 */
	public String getBeliefValidate() {
		return this.beliefValidate;
	}

	/**
	 * The setBeliefValidate method takes an Event and
	 * sets that Event as beliefValidate Event
	 * of the Belief.
	 * @param event
	 */
	public void setBeliefValidate(String event) {
		this.beliefValidate=event;
	}
	/**
	 * The getname method returns the name of the Belief.
	 * @return Name of the Belief
	 */
	public String getname() {
		return this.name;
	}
	
	/**
	 * The getfact returns the fact associated with 
	 * the Belief.
	 * @return fact of the Belief
	 */
	public String getfact() {
		return this.fact;
	}
	
	/**
	 * The setfact method takes a value and sets that as
	 * the fact of this Belief.
	 * @param value
	 */
	public void setfact(String value) {
		this.fact=value;
	}

	/**
	 * The getGoal method returns the Goal associated with
	 * the Belief.
	 * @return Goal associated with the Belief
	 */
	public String getGoal() {
		return this.beliefGoal;
	}
	
	/**
	 * The setGoal method sets the Goal of the Belief.
	 * @param goal
	 */
	public void setGoal(String goal) {
		this.beliefGoal=goal;
	}
	
	
	/**
	 * The delete method deletes the fact of the Belief.
	 */
	public void delete() {
		this.fact=null;
	}
	
	/**
	 * The getVaidatedDate method returns the validatedDate 
	 * of the Belief.
	 * @return validatedDate of the Belief
	 */
	public Date getVaidatedDate() {
		return this.validatedDate;
	}
	
	/**
	 * The updateValidatedDate method takes the new validatedDate
	 * and sets that to the validatedDate.
	 * @param date
	 */
	public void updateValidatedDate(Date date) {
		this.validatedDate=date;
	}
	
	/**
	 * The getDate method returns the current Date and Time
	 * of the System.
	 * @return Date and Time
	 */
	public Date getDate() {
		DateFormat df = new SimpleDateFormat("dd/MM/yy HH:mm:ss");
	    Date dateobj = new Date();
	    String date= df.format(dateobj);
	    return dateobj;
	}
	
	/**
	 * The validateBelief method validates the belief
	 * by checking the fact and returns whether the 
	 * Belief validity as true or false.
	 * @return validity of Belief as true or false
	 */
	public boolean validateBelief() {
		String fact=this.getfact();
		Date date=this.getDate();
		if(valid(fact)) {
			this.updateValidatedDate(date);
			return true;
		} else {
			this.deleteBelief();
			return false;
		}
	}
	
	/**
	 * The valid method takes a fact and executes
	 * the beliefValidate event associated with the 
	 * Belief and returns validity as true or false.
	 * @param fact
	 * @return validity as true or false
	 */
	private boolean valid(String fact) {
		if(this.beliefValidate.execute()) {
			return true;
		} else {
			return false;
		}
		
	}
	
	/**
	 * The updateBelief method updates the 
	 * Belief with the new fact.
	 * @param value
	 */
	public void updateBelief(String value) {
		this.setfact(value);
	}
	
	/**
	 * The deleteBelief method deletes the Belief.
	 */
	public void deleteBelief() {
		this.delete();
	}
	
	/**
	 * The isValid method checks the validity of the
	 * Belief based on the difference between the 
	 * validatedDate and the current date.
	 * @return validity as true or false
	 */
	public boolean isValid() {
		
		Date dateString=this.validatedDate;
		Date day=this.getDate();
		Date date=null,today=null;
		//Date formattedDate=null;
		DateFormat df = new SimpleDateFormat("dd/MM/yy HH:mm:ss");
		//DateTimeFormatter df = DateTimeFormat.forPattern("dd/MM/yy HH:mm:ss");
		try {
			date = dateString;
			//formattedDate = df.format(date);
			today=day;
			long diff = today.getTime() - date.getTime();
			long diffHours = diff / (60 * 60 * 1000);
			if (diffHours > 24) {
				return false;
			} else {
				return true;
			}
			
		} catch (Exception e) {
			//e.printStackTrace();
			return false;
		}
		
	}
}
