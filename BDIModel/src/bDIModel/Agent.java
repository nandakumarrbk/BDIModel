package bDIModel;

import java.util.ArrayList;

//import com.sun.xml.internal.bind.v2.runtime.unmarshaller.XsiNilLoader.Array;


/**
 * The Agent class objects have a ArrayList of 
 * Belief, Plan, Goal, Event and Import of the Agent.
 * The set and get methods are used to set and get 
 * the elements of each ArrayList.
 * 
 * @author NandaKumar Derek Moayad
 *
 */
public class Agent {
	private ArrayList<Belief> Beliefs;
	private ArrayList<Plan> Plans;
	private ArrayList<Goal> Goals;
	private ArrayList<Event> Events;
	private ArrayList<Import> Imports;
	
	private String agentName;
	//private String imports;
	
	/**
	 * The Agent constructor takes an XMLmodel input model and
	 * parses through the model and instantiates the Beliefs,
	 * Plans, Goals, Events and Imports for the Agent.
	 * @param inputmodel
	 * @see Belief 
	 * @see Plan 
	 * @see Goal 
	 * @see Event
	 */
	public Agent(XMLmodel inputmodel) {
		
		/*
		String name=inputmodel.getname();
		String imports=inputmodel.getImports();
		ArrayList<Event> events=inputmodel.getEvents();
		ArrayList<Belief> beliefs=inputmodel.getBeliefs();
		ArrayList<Plan> plans=inputmodel.getPlans();
		ArrayList<Goal> goals=inputmodel.getGoals(); 
		
		agentName=inputmodel.getname();
		Imports=inputmodel.getImports();
		Events=inputmodel.getEvents();
		Beliefs=inputmodel.getBeliefs();
		Plans=inputmodel.getPlans();
		Goals=inputmodel.getGoals(); */
	
		
		String name=inputmodel.getname();
		ArrayList<Import> imports=inputmodel.getImports();
		ArrayList<Event> events=inputmodel.getEvents();
		ArrayList<Belief> beliefs=inputmodel.getBeliefs();
		ArrayList<Plan> plans=inputmodel.getPlans();
		ArrayList<Goal> goals=inputmodel.getGoals(); 
		
		setAgentName(name);
		
		for (Import imp : imports) {
			Import tempimport = new Import(imp);
			Imports.add(tempimport);
		}
		
		for (Event event : events) {
			Event tempevent = new Event(event); 
			Events.add(tempevent);
		}
		
		for (Belief belief : beliefs) {
			Belief tempbelief = new Belief(belief);
			Beliefs.add(tempbelief);
		}
		
		for (Plan plan : plans) {
			Plan tempplan = new Plan(plan);
			Plans.add(tempplan);
		}
		
		for (Goal goal : goals) {
			Goal tempgoal = new Goal(goal);
			Goals.add(tempgoal);
		}
		
	}

	/**
	 * The getBeliefs method returns the Beliefs of the Agent.
	 * @return ArrayList of Belief
	 */
	public ArrayList<Belief> getBeliefs() {
		return this.Beliefs;
	}
	
	/**
	 * The getPlans method returns the Plans of the Agent.
	 * @return ArrayList of Plan
	 */
	public ArrayList<Plan> getPlans(){
		return this.Plans;
	}
	
	/**
	 * The getGoals method returns the Goals of the Agent.
	 * @return ArrayList of Goal
	 */
	public ArrayList<Goal> getGoals(){
		return this.Goals;
	}
	
	/**
	 * The getEvents method returns the Events of the Agent.
	 * @return ArrayList of Event
	 */
	public ArrayList<Event> getEvents(){
		return this.Events;
	}
	
	
/*	private void importFiles(String imports) {
		//import files
	}
*/
	/**
	 * The getAgentName method returns the name of the Agent.
	 * @return Name of the Agent
	 */
	public String getAgentName() {
		return agentName;
	}

	/**
	 * The setAgentName method sets the name of the Agent.
	 * @param agentName
	 */
	public void setAgentName(String agentName) {
		this.agentName = agentName;
	}
	
	
	
}
