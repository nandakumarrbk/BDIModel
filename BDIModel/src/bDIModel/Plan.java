package bDIModel;

/**
 * The Plan class instantiates a Plan with
 * name, code, PriorityValue and the planEvent
 * associated with the Plan.
 * 
 * @author NandaKumar Derek Moayad
 *
 */
public class Plan {
	int PriorityValue;
	String name, code;
	Event planEvent;
	
	/**
	 * The Plan constructor initializes the Plan
	 * with the name, code, PriorityValue and the planEvent
	 * associated with the Plan.
	 * @param plan
	 */
	public Plan(Plan plan) {
		name=plan.getname();
		code=plan.getcode();
		planEvent=plan.getevent();
		PriorityValue=plan.getPriorityValue();
	}

	/**
	 * The getevent method returns the Event associated
	 * with this Plan.
	 * @return Event of the Plan
	 */
	public Event getevent() {
		return this.planEvent;
	}

	/**
	 * The getPriorityValue method returns the PriorityValue
	 * of the Plan.
	 * @return PriorityValue of the Plan
	 */
	public int getPriorityValue() {
		return this.PriorityValue;
	}
	
	/**
	 * The getname method returns the name of the Plan.
	 * @return name of the Plan
	 */
	public String getname() {
		return this.name;
	}
	
	/**
	 * The getcode method returns the code of the Plan.
	 * @return code of the Plan
	 */
	public String getcode() {
		return this.code;
	}

}
