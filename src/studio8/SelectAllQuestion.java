package studio8;

public class SelectAllQuestion extends MultipleChoiceQuestion {

	public SelectAllQuestion(String prompt, String answer, int points, String[] choices) {
		//Hint: 1 point per choice
		super(prompt, answer, points, choices);

	}
	public int counter;
	
	public int checkAnswer(String givenAnswer) {
		if(givenAnswer.contains(getAnswer())) { 
			counter=  this.getPoints();
		} 
		else if (givenAnswer.contains('1' + "")|| givenAnswer.contains ('3' + "" ) && !givenAnswer.contains('2' + "") && !givenAnswer.contains('4'+ "")) {
			counter = 3;
		}
		else if (givenAnswer.contains('1' + "")|| givenAnswer.contains('3' + "") && !givenAnswer.contains('2' + "") || !givenAnswer.contains('4' + "")) {
			counter = 2;
		}
		else if (givenAnswer.contains('1' + "")|| givenAnswer.contains('3' + "")) {
			counter = 1;
		}
		else {
			return 0;
		}
		return counter;
	}


	public static void main(String[] args) {
		String[] choices = {"instance variables", "git", "methods", "eclipse"};
		Question selectAll = new SelectAllQuestion("Select all of the following that can be found within a class:", "13", 4,  choices);
		selectAll.displayPrompt();
		System.out.println(selectAll.checkAnswer("hi")); //no credit
		System.out.println(selectAll.checkAnswer("13")); //full credit
		System.out.println(selectAll.checkAnswer("31")); //full credit
		System.out.println(selectAll.checkAnswer("1")); //3 points
		System.out.println(selectAll.checkAnswer("3")); //3 points
		System.out.println(selectAll.checkAnswer("23")); //2 points
		System.out.println(selectAll.checkAnswer("34")); //2 points
		System.out.println(selectAll.checkAnswer("4")); //1 point
		System.out.println(selectAll.checkAnswer("124")); //1 point
		System.out.println(selectAll.checkAnswer("24")); //0 points

	}
}
