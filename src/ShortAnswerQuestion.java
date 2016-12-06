import java.util.Scanner;


public class ShortAnswerQuestion extends EssayQuestion{

	int limit = 200;
	
	public boolean grade()
	{
		if(this.correctStringAnswer.equals(this.stringInput))
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
}
