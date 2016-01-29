
/**
 * Write a description of class flav here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

import java.util.*;

public class Flav {

	static Scanner 			sc = new Scanner(System.in);
	static String 			sel = "IN";
	static String 			sel2 = "IN";
	static String 			category = "";
	static ArrayList<Post> 	posts;

	public static void main(String[] args) {
		Demo.init();
		PostDB.init();
		UserDB.init();
		Contents.printHome();
		
		while (!sel.equals("exit")) {	
			Contents.printMainMenu();
			sel = Tools.getMainSelector();
			
 			if (sel.equals("login")){	
				login();
				sel = "IN";
			}
		
/*			case 2:	newUser();
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
	
	public static boolean login(){
		System.out.print("\nInsert login email: ");
		String loginEmail=sc.next();
		System.out.print("Insert Password: ");
		String loginPassword=sc.next();
		
		if ((UserDB.exist(loginEmail, loginPassword))){
			Session.setLoggedIn(UserDB.loginCheck(loginEmail, loginPassword));
			return true;
		} else {
			System.out.print("Invalid Credentials");
			return false;
		}		
	}
	
	public static void newUser(){
		System.out.print("Sign Up\nInsert your email: ");
		String newEmail = Tools.getAndCheckInputString("\\S+@\\S+.\\S+", "is not a valid email adress. Try again!\n");
		System.out.print("\nChoose a Password: ");
		String newPassword = Tools.getAndCheckInputString("^(?=.*[0-9])(?=.*[a-z])(?=\\S+$).{8,}$", "Password must be 8 characters long and contain at least one number. Try again!\n");
		User user = new User(newEmail, newPassword);
		user.saveNew();	
	}
	
	public static void showPosts() {		
		Contents.printPostsIntro();
		category = Tools.getAndCheckInputString("all|lessons|vehicles", " category does not exist!");
		System.out.println("****************************************************************************\n");
		Tools.printPosts(category);
		}
   
	
	public static void menuShowPosts() {	
		while (!sel2.equals("back")) {
			System.out.print("\n\tReplyPost[int]\n\tBack\n\nSelect Function:\t");
			sel2 = Tools.getAndCheckInputString("replypost\\d+|back", "ERROR! INPUT EXAMPLE: replypost1");
				
			if (sel2.substring(0, sel2.length() - 1).equals("replypost")){
				if (Session.getStatus()){
					replyPost(sel2, category);
				} else {
					if(login()){ 
					replyPost(sel2, category);
					}
				}
			System.out.println("\n\nSent Answer!\n");
			}
		}
		if(sel2.equals("back")){sel2 = "IN";}
	}
	
	public static void replyPost(String input, String category) {
	int replyNum = Integer.parseInt(input.replaceAll("[\\D]", ""));
	System.out.print("Reply to post number " + replyNum + ": ");
	String answerBody = sc.next();
	/*TEST*/System.out.println("prendo i post alla categoria " + category);
	posts = PostDB.getPosts(category);
	///*TEST*/System.out.println("ho " + posts.size() + "posts e voglio scrivere al " + replyNum + "-1");
	posts.get(replyNum-1).addAnswer(answerBody, Session.getCurrentAccount());
	}
		
	public static void contact(){
	  System.out.print("\nInsert your email adress, we will be back to you ASAP :)\n");
	}
	
}       