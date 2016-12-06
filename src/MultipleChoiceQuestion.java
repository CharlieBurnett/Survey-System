import java.util.ArrayList;
import java.util.Scanner;


public class MultipleChoiceQuestion extends Question{
	
	ArrayList<String> Choices = new ArrayList<String>();
	
	public boolean grade()
	{
		if (this.input == this.correctAnswer)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	public void create()
	{
		Scanner scan = new Scanner(System.in);

		System.out.println("Enter question title: ");
		this.questionTitle = scan.nextLine();
		boolean addingChoices = true;
		while(addingChoices)
		{
			System.out.println("Add a possible choice for the question or type 0 to finish adding: ");
			String option = scan.nextLine();
			if (option.equals("0"))
			{
				addingChoices = false;
			}
			else
			{
				this.Choices.add(option);
			}
		}
	}
	
	public void take()
	{
		for(String choice:this.Choices)
		{
			System.out.println(choice);
		}
		this.getInput();
	}
	
	public void edit()
	{
		Scanner scan = new Scanner(System.in);

		System.out.println("Enter new question title");
		this.questionTitle = scan.nextLine();
		
		for(String mcChoice: this.Choices)
		{
			System.out.println(mcChoice);
		}
		
		System.out.println("edit these choices? y/n");
		String choice = scan.nextLine();
		
		if(choice.equals("y"))
		{
			System.out.println("Enter new choices in order");
			for(int i = 0; i < this.Choices.size(); i++)
			{
				String newChoice = scan.nextLine();
				this.Choices.set(i,newChoice);
			}
		}
	}

}
