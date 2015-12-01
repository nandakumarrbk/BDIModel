package bDIModel;

/**
 * The Goal class instantiates Goal with 
 * name, condition, goalType and the Goalplan 
 * associated with it.
 * 
 * @author NandaKumar Derek Moayad
 *
 */
public class Goal {
	
	private String goalType, name, condition;
	String Goalplan;
	
	/**
	 * The Goal constructor initializes the Goal
	 * with name, condition, goalType and the Goalplan 
	 * associated with it.
	 * @param goal
	 */
	public Goal(String[][] attributes){
		for(int i = 0; i < attributes.length; i++){
			if(attributes[i][0].toLowerCase() == "name"){
				this.name = attributes[i][1];
			}
			else if(attributes[i][0].toLowerCase() == "goaltype"){
				this.goalType = attributes[i][1];
			}
			else if(attributes[i][0].toLowerCase() == "condition"){
				this.condition = attributes[i][1];
			}
			else if(attributes[i][0].toLowerCase() == "goalplan"){
				this.Goalplan = attributes[i][1];
			}
		}
	}
	
	/**
	 * The getGoalType method return the goalType of
	 * the Goal.
	 * @return goalType of the Goal
	 */
	public String getGoalType() {
		return goalType;
	}
	/**
	 * The setGoalType method sets the goalType of
	 * the Goal.
	 * @param goalType
	 */
	public void setGoalType(String goalType) {
		this.goalType = goalType;
	}
	/**
	 * The getName method returns the name of the Goal.
	 * @return Name of the Goal
	 */
	public String getName() {
		return name;
	}
	/**
	 * The setName method sets the name of the Goal.
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * The getCondition method returns the condition of
	 * the Goal.
	 * @return condition of the Goal
	 */
	public String getCondition() {
		return condition;
	}
	/**
	 * The setCondition method sets the condition of
	 * the Goal.
	 * @param condition
	 */
	public void setCondition(String condition) {
		this.condition = condition;
	}
	/**
	 * The getPlan method returns the Goalplan
	 * associated with the Goal.
	 * @return Goalplan of the Goal
	 */
	public String getPlan() {
		return this.Goalplan;
	}
	/**
	 * The setPlan method sets the Goalplan of the Goal.
	 * @param plan
	 */
	public void setPlan(String plan) {
		this.Goalplan=plan;
	}
	/**
	 * The checkcondition method validates the Goal condition.
	 * @return validity as true or false
	 */
	public boolean checkcondition() {
		String condition=this.getCondition();
		if (validate(condition)) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * The validate method validates the condition.
	 * @param condition
	 * @return validity as true or false
	 */
	private boolean validate(String condition) {
		if (condition=="valid") {
			return true;
		} else {
			return false;
		}
	}
	
}
