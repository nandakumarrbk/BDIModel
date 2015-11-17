package bDIModel;

//import java.text.DateFormat;
//import java.text.SimpleDateFormat;
import java.util.ArrayList;
//import java.util.Date;

import javax.xml.parsers.ParserConfigurationException;

/**
 * The BDIModel class instantiates the list of Agents
 * declared for each XMLmodel and then initializes each 
 * Agent behavior.
 * 
 * @author NandaKumar Derek Moayad
 *
 */
public class BDIModel {
	/**
	 * An ArrayList to hold all the Agents of the BDI Model.
	 * @see Agent
	 */
	ArrayList<Agent> AgentList;
	/**
	 * The BDI Model constructor takes XMLmodels as parameters and
	 * parses through each XMLModel and creates the agents for each XMLModel.
	 * @param XMLmodels
	 * @throws ParserConfigurationException 
	 */
	public BDIModel(ArrayList<String> Filenames) throws ParserConfigurationException{
		/*int size = XMLmodels.size();
		for(int i = 0; i < size; i++){
			Agent myAgent = new Agent(XMLmodels.get(i));
			AgentList.add(myAgent);
		} */
		for (String file : Filenames) {
			Agent myAgent = new Agent(file);
			AgentList.add(myAgent);
		}
		Step();
	}
	
	/**
	 * The Step function handles the behavior of the Agents 
	 * after their instantiation by the BDI Model constructor.
	 */
	public void Step(){
		int size = AgentList.size();
		for(int a = 0; a < size; a++){
			Agent tempAgent = AgentList.get(a);
			
			ArrayList<Belief> beliefs = tempAgent.getBeliefs();
			/*ArrayList<Plan> Plans = tempAgent.getPlans();
			ArrayList<Goal> Goals = tempAgent.getGoals();
			ArrayList<Event> Events = tempAgent.getEvents(); */
			
			for (Belief belief : beliefs) {
				
				if(belief.validateBelief()) {
					//log belief validation
					//Event event = belief.getBeliefValidate();
					String fact=belief.getfact();
					String date=belief.getDate();
					Goal goal = belief.getGoal();
					if (goal.checkcondition()) {
						//log goal condition met
						Plan plan = goal.getPlan();
						Event event=plan.getevent();
						event.execute();
					} else {
					//log goal check condition failed
						String newFact="Fact learnt from environment";
						belief.updateBelief(newFact);
					}
				} else {
					//handle deleting/updating belief in XMLmodel
				}
				
			}
			
			revalidateBeliefs();
			
			Action(tempAgent);
		}
	}
	
	/**
	 * The revalidateBeliefs function revalidates the beliefs
	 * of each agent in the AgentList of the BDI Model.
	 */
	private void revalidateBeliefs() {
		int size = AgentList.size();
		for(int a = 0; a < size; a++){
			Agent tempAgent = AgentList.get(a);
			
			ArrayList<Belief> beliefs = tempAgent.getBeliefs();
			
			for (Belief belief : beliefs) {
				if (belief.isValid()) {
					//log belief is valid
				} else {
					//Revalidate belief
					if (belief.validateBelief()) {
						//validate the belief
					} else {
						//delete the belief from XMLModel
					}
				}
			}
		}
	}

	/**
	 * The Action function checks for the viable plans of the 
	 * Agent and sorts the plans according to their priority value.
	 * @param agent
	 */
	private void Action(Agent agent){
		//Check the belief's of the Agent
		ArrayList<Belief> beliefs = agent.getBeliefs();
		//get the agent's plans
		ArrayList<Plan> plans = agent.getPlans();
		//get the agent's goals
		ArrayList<Goal> goals = agent.getGoals();
		//Logically Weed out Plans and Goals using Beliefs
		ArrayList<Plan> viable = LogicFunction(beliefs,plans,goals);
		//Prioritize plans based on PriorityValue
		viable = sortPlans(viable);
	}
	
	/**
	 * @param list
	 * @return ArrayList of sorted Plan
	 */
	private ArrayList<Plan> sortPlans(ArrayList<Plan> list){
		int size = list.size();
		int max = list.get(0).getPriorityValue();
		for(int a = 0; a < size; a++){
			//Sort the list
		}
		return list;
	}
	
	/**
	 * The LogicFunction returns the viable plans for the
	 * Agent based on their beliefs, plans and goals.
	 * @param beliefs
	 * @param plans
	 * @param goals
	 * @return ArrayList of sorted viable Plan
	 */
	private ArrayList<Plan> LogicFunction(ArrayList<Belief> beliefs, ArrayList<Plan> plans, ArrayList<Goal> goals) {
		ArrayList<Plan> viableplans = null;
			//If plans and goals use the existing beliefs add them to viableplans
		return viableplans;
		//	
	}
	
}

