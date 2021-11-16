package thequizmaster.questions;

import java.awt.FontMetrics;
import java.awt.image.BufferStrategy;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

import org.json.simple.JSONObject;

import thequizmaster.Constants;
import thequizmaster.Game;

public class Question {
	
	private String question;
	private Long difficulty;
	private ArrayList<String> options;
	private ArrayList<String> answers;
	private ArrayList<String> categories;
	private String answer;
	public int numberOfOptions = 4;
	
	private static Random random = new Random();
	
	public Question(JSONObject question) {
		this.question = (String) question.get("question");
		this.difficulty = (Long) question.get("difficulty");
		answers = (ArrayList) question.get("answers");
		options = (ArrayList) question.get("options");
		categories = (ArrayList) question.get("categories");
		if(options.size() >= 3){
			numberOfOptions = 4;
		} else {
			numberOfOptions = options.size() + 1;
		}
	}

	public String[] getQuestion() {
		String[] splitQuestion = question.split(" ");
		int numberOfStrings = question.length() / Constants.splitQuestionRows + 1;
		int index = 0;
		String[] finalString = new String[numberOfStrings];
		for(int i = 0; i < numberOfStrings; i++)
		{
			String newString = "";
			while(newString.length() <= Constants.splitQuestionRows && index < splitQuestion.length) {
				newString += splitQuestion[index] + " ";
				index++;
			}
			finalString[i] = newString;
		}
		return finalString;
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
	
	public String getAnswer() {
		System.out.println(answer);
		return answer;
	}

	public ArrayList<String> getCategories() {
		return categories;
	}
	
	public ArrayList<String> getOptionsAnswer(){
		ArrayList<String> finalOptions = new ArrayList<>();
		int randomSelection = random.nextInt(answers.size());
		answer = answers.get(randomSelection);
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
