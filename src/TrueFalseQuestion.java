import java.util.Scanner;

public class TrueFalseQuestion extends MultipleChoiceQuestion{
	public boolean grade()
	{
		if(this.stringInput.equals(this.correctStringAnswer))
		{
			return true;
		}
		
		else
			return false;
	}
	
	public void create()
	{
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter question title: ");
		this.questionTitle = scan.nextLine();
	}
	
	public void take()
	{
		this.getInput();
	}
	
	public void edit()
	{
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter new question title");
		this.questionTitle = scan.nextLine();
	}
}
