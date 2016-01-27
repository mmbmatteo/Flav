
/**
 * Write a description of class flav here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

import java.util.*;

public class Flav {

	static Scanner sc = new Scanner(System.in);
	static String sel = "IN";
	static String sel2 = "IN";
	static String category = "IN";
	static List<Post> posts = PostDB.getPosts();
	

	public static void main(String[] args) {
		PostDB.init();
		printWelcome();
		
		while (!sel.equals("exit")) {	
		printMainMenu();
		sel = Tools.getAndCheckInputString("login|newuser|showposts|searchposts|contact|help|exit");
			
/* 			case 1:	login();
					break;
		
			case 2:	newUser();
					break; */

 			if (sel.equals("showposts")){	
				showPosts();
					menuShowPosts();
			}

//			case 4:	searchPosts();
//					break;		
			
/* 			case 5: contact();
					break;*/
					
			if (sel.equals("exit")){
				System.out.println("\nBYE BYE!");
				break;
			}
		}			
	}
	
	//****°°°°##### ACCESS METHODS #####°°°°°*****
	
	public static void showPosts() {		
		System.out.print("\nEnter the category you are interested in (no input for showing all posts):\t");
		category = Tools.getAndCheckInputString("^$|lessons|vehicles", " category does not exist!");
		System.out.print("\n");
		//System.out.print("category is " + category);
			if (category.length() == 0) {
					printPosts(posts);
			} else {
					printPosts(category);
			}
	}   
	
	public static void printWelcome(){
		System.out.println("\n\t\t***************************************************************");
		System.out.println("  \t\t** FLAV WILL HELP YOU BUILD A BETTER LIFE AND A BETTER WORLD **");
		System.out.println("  \t\t***************************************************************");
	}
	
	public static void printMainMenu(){
		System.out.print("\n\n\tLogin\n\tNewUser\n\tShowPosts\n\tSearchPosts\n\tContact\n\tHelp\n\tExit\n\nSelect Function:\t");
	}
	
	public static void printPosts(List<Post> posts){
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
	
	public static void menuShowPosts() {
 			
			while (!sel2.equals("back")) {
				System.out.print("\n\n\tReplyPost[int]\n\tBack\n\nSelect Function:\t");
				sel2 = Tools.getAndCheckInputString("replypost\\d+|back", "ERROR! INPUT EXAMPLE: replypost1");
				
				
					if (sel2.substring(0, sel2.length() - 1).equals("replypost")){
						replyPost(sel2);
					}
			}
			sel2 = "IN";
	}
	
	public static void replyPost(String input) {
	int replyNum = Integer.parseInt(input.replaceAll("[\\D]", ""));
	System.out.println(replyNum + "Insert reply content: ");
	String answerBody = sc.nextLine();
	posts.get(replyNum-1).addAnswer(answerBody);
	}
	
	public static void newUser(){
		System.out.print("Sign Up\nInsert your email: ");
		String newEmail = Tools.getAndCheckInputString("\\S+@\\S+.\\S+", "is not a valid email adress. Try again!\n");
		System.out.print("\nChoose a Password: ");
		String newPassword = Tools.getAndCheckInputString("^(?=.*[0-9])(?=.*[a-z])(?=\\S+$).{8,}$", "Password must be 8 characters long and contain at least one number. Try again!\n");
		User user = new User(newEmail, newPassword);
		user.saveNew();	
	}
	
	public static void login(){
		System.out.print("\nInsert login email: ");
		String loginEmail=sc.next();
		System.out.print("\nInsert Password: ");
		String loginPassword=sc.next();
		//CHECK EMAIL AND PASSWORD
	}
	
	public static void contact(){
	  System.out.print("\nInsert your email adress, we will be back to you ASAP :)\n");
	}
	
}       
