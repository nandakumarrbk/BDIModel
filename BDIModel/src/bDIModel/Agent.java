package bDIModel;

import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
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
				//All the constructoors are yet to be changed based on the DOM parser
				if(eElement.getNodeName() == "belief"){
					Belief newBelief = new Belief(eElement.getAttributes());
					this.Beliefs.add(newBelief);
				}
				if(eElement.getNodeName() == "plan"){
					Plan newPlan = new Plan(eElement.getAttributes());
					this.Plans.add(newPlan);
				}
				if(eElement.getNodeName() == "goal"){
					Goal newGoal = new Goal(eElement.getAttributes());
					this.Goals.add(newGoal);
				}
				if(eElement.getNodeName() == "event"){
					Event newEvent = new Event(eElement.getAttributes());
					this.Events.add(newEvent);
				}
			}
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
