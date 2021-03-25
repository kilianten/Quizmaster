package thequizmaster.questions;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

import org.json.simple.JSONObject;

public class Question {
	
	private String question;
	private Long difficulty;
	private ArrayList<String> options;
	private ArrayList<String> answers;
	private ArrayList<String> categories;
	
	private static Random random = new Random();
	
	public Question(JSONObject question) {
		this.question = (String) question.get("question");
		this.difficulty = (Long) question.get("difficulty");
		this.answers = (ArrayList) question.get("answers");
		this.options = (ArrayList) question.get("options");
		this.categories = (ArrayList) question.get("categories");
	}

	public String getQuestion() {
		return question;
	}

	public Long getDifficulty() {
		return difficulty;
	}

	public ArrayList<String> getOptions() {
		
		return options;
	}

	public ArrayList<String> getAnswers() {
		return answers;
	}

	public ArrayList<String> getCategories() {
		return categories;
	}
	
	public ArrayList<String> getOptionsAnswer(){
		ArrayList<String> finalOptions = new ArrayList<>();
		int randomSelection = random.nextInt(answers.size());
		finalOptions.add(answers.get(randomSelection));
		Collections.shuffle(options);
		if(options.size() == 1) {
			finalOptions.add(options.get(0));
		} else {
			for(int i = 0; i < 3; i++) {
				finalOptions.add(options.get(i));
			}
		}
		Collections.shuffle(finalOptions);
		return finalOptions;	
	}
	
}
