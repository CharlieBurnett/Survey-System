import java.util.ArrayList;
import java.util.Scanner;

public class mainUI {
	public static ArrayList<String> options = new ArrayList<String>();
	public static Survey survey;
	public static Test test;
	public static boolean isExit = false;
	public static int intChoice;
	
	public static void main(String args[])
	{
		System.out.println("Welcome to the Drexel Survey System.");
		while(isExit==false)
		{
		System.out.println("1) Create a new Survey");
		System.out.println("2) Create a new Test");
		System.out.println("3) Display a Survey");
		System.out.println("4) Display a Test");
		System.out.println("5) Load a Survey");
		System.out.println("6) Load a Test");
		System.out.println("7) Save a Survey");
		System.out.println("8) Save a Test");
		System.out.println("9) Take Survey");
		System.out.println("10) Take Test");
		System.out.println("11) Edit Survey");
		System.out.println("12) Edit Test");
		System.out.println("13) Grade Test");
		System.out.println("14) Tabulate Survey");
		System.out.println("15) Tabulate Test");
		System.out.println("16) Exit");

		
		
		Scanner scan = new Scanner(System.in);
		String choice = scan.nextLine();
		if(isInt(choice))
		{
			intChoice = Integer.parseInt(choice);
		}
		else
		{
			intChoice = -99999;
		}
		FileSerialHandler fsh = new FileSerialHandler();

		switch (intChoice) {
		case 1:
		{
			Survey createdSurvey = new Survey();
			survey = createdSurvey;
			
			System.out.println("Enter Survey Name: ");
			survey.surveyName = scan.nextLine();
			System.out.println(survey.surveyName + " initialized");
			
			boolean isCreate = true;
			while(isCreate)
			{	
			System.out.println("1) Add a new T/F question");
			System.out.println("2) Add a new multiple choice question");
			System.out.println("3) Add a new short answer question");
			System.out.println("4) Add a new essay question");
			System.out.println("5) Add a new ranking question");
			System.out.println("6) Add a new matching question");
			System.out.println("7) exit create session");

			choice = scan.nextLine();
			if(isInt(choice))
			{
				intChoice = Integer.parseInt(choice);
			}
			else
			{
				intChoice = -99999;
			}

			switch (intChoice)
			{
				case 1:
				{
					TrueFalseQuestion tfq = new TrueFalseQuestion();
					tfq.create();
					survey.questions.add(tfq);
					break;
				}
				case 2:
				{
					MultipleChoiceQuestion mcq = new MultipleChoiceQuestion();
					mcq.create();
					survey.questions.add(mcq);
					break;
				}
				case 3:
				{
					ShortAnswerQuestion saq = new ShortAnswerQuestion();
					saq.create();
					survey.questions.add(saq);
					break;
				}
				case 4:
				{
					EssayQuestion eq = new EssayQuestion();
					eq.create();
					survey.questions.add(eq);
					break;
				}
				case 5:
				{
					RankingQuestion rq = new RankingQuestion();
					rq.create();
					survey.questions.add(rq);
					break;
					
				}
				case 6:
				{
					MatchingQuestion mq = new MatchingQuestion();
					mq.create();
					survey.questions.add(mq);
					break;
					
				}
				case 7:
				{
					isCreate = false;
				}
					
			}
			}
			
			
			break;
		}
		case 2:
		{
			Test createdTest = new Test();
			test = createdTest;
			
			System.out.println("Enter Test Name: ");
			test.surveyName = scan.nextLine();
			System.out.println(test.surveyName + " initialized");
			
			boolean isCreate = true;
			while(isCreate)
			{	
			System.out.println("1) Add a new T/F question");
			System.out.println("2) Add a new multiple choice question");
			System.out.println("3) Add a new short answer question");
			System.out.println("4) Add a new essay question");
			System.out.println("5) Add a new ranking question");
			System.out.println("6) Add a new matching question");
			System.out.println("7) exit create session");

			choice = scan.nextLine();
			if(isInt(choice))
			{
				intChoice = Integer.parseInt(choice);
			}
			else
			{
				intChoice = -99999;
			}

			switch (intChoice)
			{
				case 1:
				{
					TrueFalseQuestion tfq = new TrueFalseQuestion();
					tfq.create();
					System.out.println("Enter correct answer (type \"true\" or \"false\"): ");
					String tOrF = scan.nextLine();
					if(!(tOrF.equals("true")||(tOrF.equals("false"))))
					{
						System.out.println("invalid answer, retry...");
						break;
					}
					tfq.correctStringAnswer = tOrF;
					test.questions.add(tfq);
					break;
				}
				case 2:
				{
					MultipleChoiceQuestion mcq = new MultipleChoiceQuestion();
					mcq.create();
					System.out.println("Enter correct answer (indicate which number it is): ");
					String answer = scan.nextLine();
					if(isInt(answer))
					{
						mcq.correctAnswer = Integer.parseInt(answer);
					}
					else
					{
						System.out.println("Invalid answer, try again...");
						break;
					}
					
					test.questions.add(mcq);
					break;
				}
				case 3:
				{
					ShortAnswerQuestion saq = new ShortAnswerQuestion();
					saq.create();
					System.out.println("Enter answer: ");
					saq.correctStringAnswer = scan.nextLine();
					test.questions.add(saq);
					break;
				}
				case 4:
				{
					EssayQuestion eq = new EssayQuestion();
					eq.create();
					test.questions.add(eq);
					break;
				}
				case 5:
				{
					RankingQuestion rq = new RankingQuestion();
					rq.create();
					test.questions.add(rq);
					break;					
				}
				case 6:
				{
					MatchingQuestion mq = new MatchingQuestion();
					mq.create();
					test.questions.add(mq);
					break;			
				}
				case 7:
				{
					isCreate = false;
				}			
			}
			}			
			break;
		}
		case 3:
		{
			if(survey==null)
			{
				System.out.println("No survey loaded.");
			}
			else
			{
				survey.display();
			}
			break;
		}
		case 4:
		{
			if(test==null)
			{
				System.out.println("No test loaded.");
			}
			else
			{
				test.display();
			}
			break;
		}
		case 5:
		{
			System.out.println("Enter survey name to load: ");
			choice = scan.nextLine();
			survey = fsh.load(choice);
			System.out.println(survey.surveyName + " loaded.");
			break;
		}
		case 6:
		{
			System.out.println("Enter test name to load: ");
			choice = scan.nextLine();
			test = fsh.loadTest(choice);
			System.out.println(test.surveyName + " loaded.");
			break;
		}
		case 7:
		{
			if(survey==null)
			{
				System.out.println("No survey to save.");
			}
			else
			{
				fsh.save(survey);
				System.out.println(survey.surveyName + " saved.");
			}
			break;
		}
		
		case 8:
		{
			if(test==null)
			{
				System.out.println("No test to save.");
			}
			else
			{
				fsh.saveTest(test);
				System.out.println(test.surveyName + " saved.");
			}
			break;
		}
		case 9:
		{
			if(survey==null)
			{
				System.out.println("No survey to take, try loading one.");
			}
			else
			{
				survey.take();
			}
			break;
		}
		case 10:
		{
			if(test==null)
			{
				System.out.println("No test to take, try loading one.");
			}
			else
			{
				test.take();
			}
			break;
		}
		case 11:
		{
			if(survey==null)
			{
				System.out.println("No survey to edit, try loading one.");
			}
			else
			{
				survey.edit();
			}
			break;
		}
		case 12:
		{
			if(test==null)
			{
				System.out.println("No test to edit, try loading one.");
			}
			else
			{
				test.edit();
			}
			break;
		}
		case 13:
		{
			if(test==null)
			{
				System.out.println("No test to grade, try loading one.");
			}
			else
			{
				float grade = test.grade();
				System.out.println(grade);
			}
			break;
		}
		case 14:
		{
			if(survey==null)
			{
				System.out.println("No surveys to edit, try loading one.");
			}
			else
			{
				
			}
			break;
		}
		case 15:
		{
			if(survey==null)
			{
				System.out.println("No tests to tabulate, try loading one.");
			}
			else
			{
				
			}
			
			break;
		}
		case 16:
		{
			isExit = true;
			break;
		}
		default:
		{
			System.out.println("Invalid Choice. Please start over.");
			break;
		}
		}
		}
	}
	
	private static boolean isInt(String str) {
	    try { 
	        Integer.parseInt(str); 
	    } 
	    catch(NumberFormatException e) { 
	        return false; 
	    }
	    return true;
	}
	
}
