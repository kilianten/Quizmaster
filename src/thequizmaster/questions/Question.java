package thequizmaster.questions;

import java.util.ArrayList;

import org.json.simple.JSONObject;

public class Question {
	
	private String question;
	private Long difficulty;
	private ArrayList<String> options;
	private ArrayList<String> answers;
	private ArrayList<String> categories;
	
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
	
}
