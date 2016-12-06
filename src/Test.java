import java.util.Scanner;

public class Test extends Survey{
	float questionsInTest;
	float questionsCorrect;
	
	public float grade(){
		questionsInTest = questions.size();
		questionsCorrect = 0;
		for(Question question: questions)
		{
			if (question.grade() == true)
			{
				questionsCorrect++;
			}
		}
		return 100*(questionsCorrect/questionsInTest);
	}
	
	public void edit()
	{
		for (Question question:questions)
		{
			System.out.println(question.questionTitle);
			System.out.println("Edit question Title? y/n");
			Scanner s = new Scanner(System.in);
			String choice = s.nextLine();
			if(choice.equals("y"))
			{
				question.edit();
				System.out.println("Enter New Answer: ");
				Scanner scan = new Scanner(System.in);
				String answer = scan.nextLine();
				
				if(isInt(answer))
				{
					question.correctAnswer = Integer.parseInt(answer);
				}
				else
				{
					question.correctStringAnswer = answer;
				}
			}	
		}
	}
	
	private boolean isInt(String str) {
	    try { 
	        Integer.parseInt(str); 
	    } 
	    catch(NumberFormatException e) { 
	        return false; 
	    }
	    return true;
	}
}
