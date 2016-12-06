import java.util.Scanner;

public class EssayQuestion extends Question{
	 
	 public boolean grade()
	 {
		return true;
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
