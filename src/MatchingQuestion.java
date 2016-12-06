import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.util.Scanner;

public class MatchingQuestion extends RankingQuestion{
	//wordbank
	public ArrayList<String> stringsToMatch = new ArrayList<String>();
	//user chose
	public ArrayList<String> choicesForMatch = new ArrayList<String>();
	
	public Map<String, String> matchingMap = new HashMap<String,String>();
	public Map<String, String> potentialMatchMap = new HashMap<String,String>();

	//for question creation, have input be word, and word to be matched. Thats it.
	
	//print first word that needs a match followed by possible words to match with
	//mention that string can only be matched once
	private void generateMap()
	{
		int i = 0;
		for (String matcherString:this.stringsToBeRanked)
		{
			matchingMap.put(matcherString, stringsToMatch.get(i));
		}
	}
	
	private void generateResultMap()
	{
		int i = 0;
		for (String matcherString:this.stringsToBeRanked)
		{
			potentialMatchMap.put(matcherString, choicesForMatch.get(i));
		}
	}
	
	public boolean grade()
	{		
		generateResultMap();
		
		for(String match: this.stringsToBeRanked)
		{
			System.out.println(matchingMap.get(match));
			System.out.println(potentialMatchMap.get(match));
			
			if(!(matchingMap.get(match).equals(potentialMatchMap.get(match))))
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
			System.out.println("Enter item to be matched against or 0 to exit");
			String option = scan.nextLine();
			
			if (option.equals("0"))
			{
				System.out.println("In breaker");
				isAddingOptions = false;
				break;
			}
			
			this.stringsToBeRanked.add(option);
			
			System.out.println("Enter item to match with it");
			option = scan.nextLine();
			this.stringsToMatch.add(option);						
		}
		generateMap();
	}
	
	public void take()
	{
		for(String toRank:this.stringsToBeRanked)
		{
			System.out.println(toRank);
		}
		System.out.println("List of potential matches: ");
		for(String toRank:this.stringsToMatch)
		{
			System.out.println(toRank);
		}
		for(int i = 0; i<stringsToMatch.size(); i++)
		{
			Scanner scan = new Scanner(System.in);
			String matched = scan.nextLine();
			choicesForMatch.add(matched);
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
				System.out.println("Enter item to be matched against or 0 to exit");
				String option = scan.nextLine();
				
				if (option.equals("0"))
				{
					System.out.println("In breaker");
					isAddingOptions = false;
					break;
				}
				
				this.stringsToBeRanked.add(option);
				
				System.out.println("Enter item to match with it");
				option = scan.nextLine();
				this.stringsToMatch.add(option);						
			}
			generateMap();
		
		}
	}
}
