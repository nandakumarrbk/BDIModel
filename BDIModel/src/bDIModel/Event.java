package bDIModel;

/**
 * The Event class instantiates an Event
 * with name and code.
 * 
 * @author NandaKumar Derek Moayad
 *
 */
public class Event {
	String name,code;
	
	/**
	 * The Event constructor initializes the
	 * Event name and code.
	 * @param event
	 */
	public Event(Event event) {
		name=event.getname();
		code=event.getcode();
	}
	/**
	 * The execute method executes the code
	 * associated with the Event. It returns the 
	 * Event result. 
	 * @return result as true or false
	 */
	public boolean execute() {
		//handle code execution here
		return false;
	}
	/**
	 * The getname method returns the name of the Event.
	 * @return Name of the Event
	 */
	public String getname() {
		return this.name;
	}
	
	/**
	 * The getcode returns the code associated with 
	 * the Event.
	 * @return code of the Event
	 */
	public String getcode() {
		return this.code;
	}
}
