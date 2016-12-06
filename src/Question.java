import java.util.Scanner;
public abstract class Question implements java.io.Serializable{
	
	public String questionTitle;
	public String stringInput;
	public String correctStringAnswer;
	public int input = -9999;
	public int correctAnswer;

	public void getInput()
	{
		Scanner sc = new Scanner(System.in);
		String s = sc.nextLine();
		if (isInt(s))
		{
			this.input = Integer.parseInt(s);
		}
		else
		{
			this.stringInput = s;
		}
	}
	public abstract boolean grade();
	public abstract void create();
	public abstract void edit();
	public abstract void take();
	
	protected boolean isInt(String str) {
	    try { 
	        Integer.parseInt(str); 
	    } 
	    catch(NumberFormatException e) { 
	        return false; 
	    }
	    return true;
	}
	
}
