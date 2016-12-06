import java.util.ArrayList;
import java.util.Scanner;

import com.sun.speech.freetts.Voice;
import com.sun.speech.freetts.VoiceManager;
public class Survey implements java.io.Serializable {

	public Survey() {
		// TODO Auto-generated constructor stub
	}
	public String surveyName;
	ArrayList<Question> questions = new ArrayList<Question>();
	public int input;
	public String stringInput;

	public void display()
	{     
		boolean shouldSpeak = false;
		System.out.println("Speak the display? y/n");
		Scanner scan = new Scanner(System.in);
		String choice = scan.nextLine();
		if(choice.equals("y"))
		{
			shouldSpeak = true;
		}
		for (Question question:questions)
		{
			textOrSpeech(question.questionTitle,shouldSpeak);
			
			if(question.stringInput!=null)
			{
				textOrSpeech(question.stringInput,shouldSpeak);
			}
			else if(question.input!=-9999)
			{
				textOrSpeech(Integer.toString(question.input), shouldSpeak);
			}
		}
	}
	
	public void take()
	{
		boolean shouldSpeak = false;
		System.out.println("Speak the display? y/n");
		Scanner scan = new Scanner(System.in);
		String choice = scan.nextLine();

		if(choice.equals("y"))
		{
			shouldSpeak = true;
		}
		for (Question question:questions)
		{
			textOrSpeech(question.questionTitle,shouldSpeak);
			question.take();
		}
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
			}	
		}
	}
	
	public void tabulate()
	{
		ArrayList<TrueFalseQuestion> tfqArray = new ArrayList<TrueFalseQuestion>();
		ArrayList<MultipleChoiceQuestion> mcqArray = new ArrayList<MultipleChoiceQuestion>();
		ArrayList<MatchingQuestion> mqArray = new ArrayList<MatchingQuestion>();
		ArrayList<RankingQuestion> rqArray = new ArrayList<RankingQuestion>();
		ArrayList<ShortAnswerQuestion> saqArray = new ArrayList<ShortAnswerQuestion>();
		ArrayList<EssayQuestion> eqArray = new ArrayList<EssayQuestion>();
		
		for(Question question:questions)
		{
			if(question instanceof TrueFalseQuestion)
			{
				tfqArray.add((TrueFalseQuestion)question);
			}
			else if(question instanceof MultipleChoiceQuestion)
			{
				mcqArray.add((MultipleChoiceQuestion)question);
			}
			else if(question instanceof MatchingQuestion)
			{
				mqArray.add((MatchingQuestion)question);
			}
			else if(question instanceof RankingQuestion)
			{
				rqArray.add((RankingQuestion)question);
			}
			else if(question instanceof ShortAnswerQuestion)
			{
				saqArray.add((ShortAnswerQuestion)question);
			}
			else if(question instanceof EssayQuestion)
			{
				eqArray.add((EssayQuestion)question);
			}
		}
		
		//true false
		int tfqTally = 0;
			
		for (TrueFalseQuestion tfq: tfqArray)
		{
			if(tfq.correctStringAnswer.equals("true"))
			{
				tfqTally++;
			}
		}
			
		System.out.println("Total true answers: " + tfqTally);
		System.out.println("Total false answers: " + (tfqArray.size() - tfqTally));
		
		//multiple choice
		ArrayList<Integer> choicesChosen = new ArrayList<Integer>();
		for (MultipleChoiceQuestion mcq: mcqArray)
		{
			if(mcq.correctAnswer > choicesChosen.size())
			{
				choicesChosen.add(mcq.correctAnswer, 1);
			}
			else
			{
				int inc = choicesChosen.get(mcq.correctAnswer);
				inc++;
				choicesChosen.remove(mcq.correctAnswer);
				choicesChosen.add(mcq.correctAnswer, inc);
			}
		}
		
		for (int i = 0; i<choicesChosen.size();i++)
		{
			System.out.println("Option " + i+1 + " Selected " + choicesChosen.get(i) + " times");
		}
		
		//Short Answer
		ArrayList<String> answers = new ArrayList<String>();
		for (ShortAnswerQuestion saq: saqArray)
		{
			if (!answers.contains(saq.correctStringAnswer))
			{
				answers.add(saq.correctStringAnswer);
			}
		}
		System.out.println("Short Answer respones");
		{
			for(String answer: answers)
			{
				System.out.println(answer);
			}
		}
		
		//Essay
		ArrayList<String> eanswers = new ArrayList<String>();
		for (EssayQuestion eq: eqArray)
		{
			if (!eanswers.contains(eq.correctStringAnswer))
			{
				eanswers.add(eq.correctStringAnswer);
			}
		}
		System.out.println("Essay respones");
		{
			for(String answer: answers)
			{
				System.out.println(answer);
			}
		}
	}	
	
	protected void textOrSpeech(String toSay, boolean shouldSpeak)
	{
		if(shouldSpeak)
		{
			String voiceName = "kevin16";
	        
	        VoiceManager voiceManager = VoiceManager.getInstance();
	        Voice voice = voiceManager.getVoice(voiceName);

	        voice.allocate();
	        voice.speak(toSay);
	        voice.deallocate();
		}
		else {
			System.out.println(toSay);
		}
	}
}
