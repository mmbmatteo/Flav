import java.util.*;
import java.text.*;


public class Tools {
	static Scanner sc = new Scanner(System.in);
	
	public static String getDateTime(){
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Date date = new Date();
		return dateFormat.format(date);
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
	public static void printPosts(ArrayList<Post> posts, boolean owner){
		int count = 1;
		String risp = "zero";
		for (Post p : posts) {
			if (owner){
				if (!p.hasAnswers()){
					System.out.println(Integer.toString(count++) + "\t" + p.getOwner());
					System.out.println(p.getTitle() + " ||| " + p.getDescription() + " ||| Price: " + p.getPrice() + "\n\n");
				} else{
					System.out.println(Integer.toString(count++) + "\t" + p.getOwner());
					System.out.println(p.getTitle() + " ||| " + p.getDescription() + " ||| Price: " + p.getPrice());
					if (p.answersNum() == 1){risp = " answer\n";}else{risp = " answers\n";}
					System.out.println("\t\t* " + p.answersNum() + risp); 
				}
			}else{
				if (!p.hasAnswers()){
					System.out.println(Integer.toString(count++) + "\t" + p.getTitle() + " ||| " + p.getDescription() + " ||| Price: " + p.getPrice() + "\n\n");
				} else{
					System.out.println(Integer.toString(count++) + "\t" + p.getTitle() + " ||| " + p.getDescription() + " ||| Price: " + p.getPrice());
					if (p.answersNum() == 1){risp = " answer\n";}else{risp = " answers\n";}
					System.out.println("\t\t* " + p.answersNum() + risp); 
				}
			}
		}
	}
	
	public static void printPosts(String category){
		printPosts(PostDB.getPosts(category), true);
	}
	//END printPosts METHOD OVERLOAD
	
/* 	public static void printMyPosts(User user){
		printPosts(user.getMyPosts(), false);
	} */
		
	public static void printMyPosts(User user){
		ArrayList<Post>	posts = user.getMyPosts();
		int count = 1;
		for (Post p : posts) {
			if (!p.hasAnswers()){
				System.out.println(Integer.toString(count++) + "\t" + p.getTitle() + " ||| " + p.getDescription() + " ||| Price: " + p.getPrice() + "\n\n");
			} else{
				System.out.println(Integer.toString(count++) + "\t" + p.getTitle() + " ||| " + p.getDescription() + " ||| Price: " + p.getPrice());
				ArrayList<Post>	answers = p.getAnswers();
				for (Post a : answers){
					System.out.println("\t" + a.getOwner() + "\t" + a.getDescription());
				}
			}
		}
	}	
	
	public static ArrayList<String> itemSelectionMenu(int size){
		ArrayList<String> replyMenu = new ArrayList<String>();
		for (int i = 0; i < size; i++){
					replyMenu.add(Integer.toString(i+1));
		}
		return replyMenu;
	}
	
	//launchMenu METHOD OVERLOAD	
	public static String launchMenu(ArrayList<String> menu, String invalidMessage){
		String pattern = "";
		int i = 0;
		ArrayList<String> patternList = new ArrayList<String>();
		System.out.println("\n");
		for (String element : menu) {
			patternList.add(element.toLowerCase().concat("|").concat(Integer.toString(i+1)));
			pattern = pattern.concat(element).concat("|").concat(Integer.toString(i+1));
			pattern = pattern.concat("|");
			System.out.println("\t" + element);
			i++;
		}
		pattern = pattern.toLowerCase().substring(0, pattern.length()-1);
		System.out.print("\nSelect function\t");
		String selection = getAndCheckInputString(pattern, invalidMessage);
		
		boolean found = false;
		i = 0;
		while (!found){
			if (selection.matches(patternList.get(i++))){
				found = true;
			}
		}
		return menu.get(i-1).toLowerCase();
	}
	
	public static String launchMenuNoPrint(ArrayList<String> menu, String printMessage, String invalidMessage){
		String pattern = "";
		int i = 0;
		ArrayList<String> patternList = new ArrayList<String>();
		System.out.println("\n");
		for (String element : menu) {
			patternList.add(element.toLowerCase().concat("|").concat(Integer.toString(i+1)));
			pattern = pattern.concat(element).concat("|").concat(Integer.toString(i+1));
			pattern = pattern.concat("|");
			i++;
		}
		pattern = pattern.toLowerCase().substring(0, pattern.length()-1);
		System.out.print(printMessage + " ");
		String selection = getAndCheckInputString(pattern, invalidMessage);
		
		boolean found = false;
		i = 0;
		while (!found){
			if (selection.matches(patternList.get(i++))){
				found = true;
			}
		}
		return menu.get(i-1).toLowerCase();
	}
	//END launchMenu METHOD OVERLOAD
	
}