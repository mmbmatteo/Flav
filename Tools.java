import java.util.*;
import java.text.*;


public class Tools {
	static Scanner sc = new Scanner(System.in);
	
	public static String getDateTime(){
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Date date = new Date();
		return dateFormat.format(date);
	}
	
	public static String getMainSelector(){
		String sel = Tools.getAndCheckInputString("login|newuser|showposts|searchposts|contact|help|exit|1|2|3|4|5|6|7");
		if (sel.matches("1|2|3|4|5|6|7")){
			int intSel = Integer.parseInt(sel);
			switch(intSel){
				case 1 : sel = "login"; 		break;
				case 2 : sel = "newuser"; 		break;
				case 3 : sel = "showposts"; 	break;
				case 4 : sel = "searchposts"; 	break;
				case 5 : sel = "contact"; 		break;
				case 6 : sel = "help"; 			break;
				case 7 : sel = "exit"; 			break;
			}
		}
		return sel;
	}
	
	//getAndCheckInputString METHOD OVERLOAD
	public static String getAndCheckInputString(String pattern, String invalidMessage){
			String toCheck;
				do {
					toCheck=sc.nextLine();
					toCheck = toCheck.toLowerCase();
					if(!toCheck.matches(pattern)){
						System.out.println(toCheck + " " + invalidMessage + "\n");
					}
				}while (!toCheck.matches(pattern));
				return toCheck;
	}
	
	public static String getAndCheckInputString(String pattern){
		String toCheck;
			do {
				toCheck=sc.nextLine();
				toCheck = toCheck.toLowerCase();
				if(!toCheck.matches(pattern)){
					System.out.println(toCheck + " IS AN INVALID INPUT! TRY AGAIN\n");
				}
			}while (!toCheck.matches(pattern));
			return toCheck;
	}
	//END getAndCheckInputString METHOD OVERLOAD
	
	//printPosts METHOD OVERLOAD
	public static void printPosts(ArrayList<Post> posts){
		int count = 1;
		String risp = "zero";
		for (Post p : posts) {
			if (!p.hasAnswers()){
				System.out.println(Integer.toString(count++) + "\t" + p.getTitle() + " ||| " + p.getDescription() + " ||| Price: " + p.getPrice() + "\n\n");
			} else{
				System.out.println(Integer.toString(count++) + "\t" + p.getTitle() + " ||| " + p.getDescription() + " ||| Price: " + p.getPrice() + "");
				if (p.answersNum() == 1){risp = " answer\n";}else{risp = " answers\n";}
				System.out.println("\t" + p.answersNum() + risp); 
			}
		}
	}
	
	public static void printPosts(String category){
		printPosts(PostDB.getPosts(category));
	}
	//END printPosts METHOD OVERLOAD
	
}