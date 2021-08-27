package thequizmaster.questions;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Random;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class QuestionHandler {
	
	private JSONArray allQuestions;
	private ArrayList<Question> levelOneQuestions;
	private ArrayList<Question> levelTwoQuestions;
	private ArrayList<Question> levelThreeQuestions;
	private ArrayList<Question> levelFourQuestions;
	private ArrayList<Question> levelFiveQuestions;
	
	private Random random;
	
	public QuestionHandler() {
		 JSONParser parser = new JSONParser();
		    try
		    {
		        Object object = parser
		                .parse(new FileReader("./res/questions.json"));
	
		        allQuestions = (JSONArray) object;
		       System.out.println("Number of questions: " + allQuestions.size());
		    }
		    catch(FileNotFoundException fe)

		    {
		        fe.printStackTrace();
		    }
		    catch(Exception e)
		    {
		        e.printStackTrace();
		    }
		    
		    levelOneQuestions = new ArrayList<>();
		    levelTwoQuestions = new ArrayList<>();
		    levelThreeQuestions = new ArrayList<>();
		    levelFourQuestions = new ArrayList<>();
		    levelFiveQuestions = new ArrayList<>();
		    random = new Random();
		    organizeQuestions();
	}


	private void organizeQuestions() {
		for(int i = 0; i < allQuestions.size(); i++) {
			JSONObject JSONQuestion = (JSONObject) allQuestions.get(i);
			Question question = new Question(JSONQuestion);
			
			
			Long difficulty = question.getDifficulty();
			if(difficulty == 1) levelOneQuestions.add(question);
			else if(difficulty == 2) levelTwoQuestions.add(question);
			else if(difficulty == 3) levelThreeQuestions.add(question);
			else if(difficulty == 4) levelFourQuestions.add(question);
			else if(difficulty == 5) levelFiveQuestions.add(question);
		}
		
	}
	
	public Question getQuestion(int difficulty) {
		if(difficulty == 1) return getLevelOneQuestion(); 
		if(difficulty == 2) return getLevelTwoQuestion(); 
		if(difficulty == 3) return getLevelThreeQuestion(); 
		if(difficulty == 4) return getLevelFourQuestion(); 
		if(difficulty == 5) return getLevelFiveQuestion(); 
		return null;
	}
	
	public Question getLevelOneQuestion() {
		int randomNum = random.nextInt(levelOneQuestions.size());
		return levelOneQuestions.get(randomNum);
	}
	
	public Question getLevelTwoQuestion() {
		int randomNum = random.nextInt(levelTwoQuestions.size());
		return levelTwoQuestions.get(randomNum);
	}
	
	public Question getLevelThreeQuestion() {
		int randomNum = random.nextInt(levelThreeQuestions.size());
		return levelThreeQuestions.get(randomNum);
	}
	
	public Question getLevelFourQuestion() {
		int randomNum = random.nextInt(levelFourQuestions.size());
		return levelFourQuestions.get(randomNum);
	}
	
	public Question getLevelFiveQuestion() {
		int randomNum = random.nextInt(levelFiveQuestions.size());
		return levelFiveQuestions.get(randomNum);
	}
	
}
