package bDIModel;

import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import java.io.File;
import java.io.IOException;

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
	 * The Agent constructor takes a Filename as input and
	 * parses through the file and instantiates the Beliefs,
	 * Plans, Goals, Events and Imports for the Agent.
	 * @param filename
	 * @see Belief 
	 * @see Plan 
	 * @see Goal 
	 * @see Event
	 */
	public Agent(String filename) throws ParserConfigurationException {
		ReadXMLFile(filename);
	}
	
	/**
	 * The ReadXMLFile reads the XML input file and parses it.
	 * It Initializes Agents with Beliefs, plans, Goals and 
	 * Events which are specified in the XML file.
	 * @param filename
	 * @throws ParserConfigurationException
	 */
	private void ReadXMLFile(String filename) throws ParserConfigurationException{
		File fxmlFile = new File(filename);
		DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
		Document doc = null;
		try{
			doc = dBuilder.parse(fxmlFile);
		} catch (SAXException e){
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		doc.getDocumentElement().normalize();
		//------------------Initialize Objects--------------------//
		NodeList nList = doc.getElementsByTagName("Agent");
		for(int i = 0; i < nList.getLength(); i++){
			Node nNode = nList.item(i);
			if(nNode.getNodeType() == Node.ELEMENT_NODE){
				Element eElement = (Element) nNode;
				//Create Belief Object with the string parameter
				if(eElement.getNodeName() == "belief"){
					String[][] attributes = generateAttributeArray(eElement); 
					Belief newBelief = new Belief(attributes);
					this.Beliefs.add(newBelief);
				}
				if(eElement.getNodeName() == "plan"){
					String[][] attributes = generateAttributeArray(eElement);
					Plan newPlan = new Plan(attributes);
					this.Plans.add(newPlan);
				}
				if(eElement.getNodeName() == "goal"){
					String[][] attributes = generateAttributeArray(eElement);
					Goal newGoal = new Goal(attributes);
					this.Goals.add(newGoal);
				}
				if(eElement.getNodeName() == "event"){
					String[][] attributes = generateAttributeArray(eElement);
					Event newEvent = new Event(attributes);
					this.Events.add(newEvent);
				}
			}
		}
	}

	/**
	 * The generateAttributeArray function generates Attribute Array from
	 * the input DOM element. It creates a two dimensional array with
	 * name at index 0 and value at index 1. 
	 * @param element
	 * @return attributes array
	 */
	public static String[][] generateAttributeArray(Element element){
		String[][] attributes = null;
		NamedNodeMap attrib = element.getAttributes();
		int numAttr = attrib.getLength();
		for(int i = 0; i < numAttr; i++){
			Attr attr = (Attr) attrib.item(i);
			String attrName = attr.getNodeName();
			String attrValue = attr.getNodeValue();
			attributes[i][0] = attrName;
			attributes[i][1] = attrValue;
		}
		return attributes;
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
	
	/**
	 * The getGoalObject takes the Goal name as input and 
	 * returns the Goal object with that name. It parses 
	 * through all the Goals of the agent to find a match.
	 * If match is found it returns the Goal object or else
	 * it returns null. 
	 * @param name
	 * @return Goal or null 
	 */
	public Goal getGoalObject(String name) {
		for (Goal goal : Goals) {
			if (goal.getName()==name) {
				return goal;
			}
		}
		return null;
	}
	
	/**
	 * The getPlanObject takes the Plan name as input and 
	 * returns the Plan object with that name. It parses 
	 * through all the Plans of the agent to find a match.
	 * If match is found it returns the Plan object or else
	 * it returns null.
	 * @param name
	 * @return Plan or null
	 */
	public Plan getPlanObject(String name) {
		for (Plan plan : Plans) {
			if (plan.getname()==name) {
				return plan;
			}
		}
		return null;
	}
	
	/**
	 * The getEventObject takes the Event name as input and 
	 * returns the Event object with that name. It parses 
	 * through all the Events of the agent to find a match.
	 * If match is found it returns the Event object or else
	 * it returns null.
	 * @param name
	 * @return Event or null
	 */
	public Event getEventObject(String name) {
		for (Event event : Events) {
			if (event.getname()==name) {
				return event;
			}
		}
		return null;
	}
	
}
