import java.util.ArrayList;
import java.util.Scanner;
public class RankingQuestion extends Question{
	ArrayList<String> stringsToBeRanked = new ArrayList<String>();
	public ArrayList<Integer> intRankings = new ArrayList<Integer>();
	public ArrayList<Integer> correctIntRankings = new ArrayList<Integer>();

	
	public boolean grade()
	{
		for(int i=0;i<this.stringsToBeRanked.size();i++)
		{
			if (correctIntRankings.get(i) != intRankings.get(i))
			{
				return false;
			}
		}
		return true;
	}
	
	public void create()
	{
		Scanner scan = new Scanner(System.in);

		System.out.println("Enter question title: ");
		this.questionTitle = scan.nextLine();
		boolean isAddingOptions = true;
		
		while(isAddingOptions)
		{
			System.out.println("Enter item to be ranked or type 0 to finish");
			String option = scan.nextLine();
			if (option.equals("0"))
			{
				isAddingOptions = false;
				break;
			}
			
			this.stringsToBeRanked.add(option);
			
			System.out.println("enter ranking number");
			option = scan.nextLine();
			if(this.isInt(option))
			{
				correctIntRankings.add(Integer.parseInt(option));
			}
			else 
			{
				System.out.println("Not a number...");
				stringsToBeRanked.remove(stringsToBeRanked.size()-1);
				break;
			}
		}
	}
	
	public void take()
	{
		for(String toRank:this.stringsToBeRanked)
		{
			System.out.println(toRank);
		}
		for(int i = 0; i < correctIntRankings.size(); i++)
		{
			Scanner scan = new Scanner(System.in);
			String choice = scan.nextLine();
			intRankings.add(Integer.parseInt(choice));
		}
	}
	
	public void edit()
	{
		Scanner scan = new Scanner(System.in);

		for (String rank: this.stringsToBeRanked)
		{
			System.out.println(rank);
		}
		
		System.out.println("edit these choices? y/n");
		String choice = scan.nextLine();
		
		if(choice.equals("y"))
		{
			boolean isAddingOptions = true;
			
			while(isAddingOptions)
			{
				System.out.println("Enter item to be ranked or type 0 to finish");
				String option = scan.nextLine();
				if (option.equals("0"))
				{
					isAddingOptions = false;
					break;
				}
				
				this.stringsToBeRanked.add(option);
				
				System.out.println("enter ranking number");
				option = scan.nextLine();
				if(this.isInt(option))
				{
					correctIntRankings.add(Integer.parseInt(option));
				}
				else 
				{
					System.out.println("Not a number...");
					stringsToBeRanked.remove(stringsToBeRanked.size()-1);
					break;
				}
			}
		}
	}
}
