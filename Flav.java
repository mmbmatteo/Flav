
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
	static int				listSize;
	static ArrayList<String> replyMenu = new ArrayList<String>();
	static ArrayList<String> mainMenu = new ArrayList<String>();
	static String			answerBody;
	static int				replyNumSel;
	
	public static void main(String[] args) {
		Demo.init();
		PostDB.init();
		UserDB.init();
		Contents.printHome();
		
		while (!sel.equals("exit")) {	
			Contents.printMainMenu();
			
			if (Session.getStatus()){
				mainMenu = new ArrayList<String>(Arrays.asList("Logout","MyProfile", "ShowPosts", "SearchPosts", "Contact", "Exit", "Debug"));
			}else{
				mainMenu = new ArrayList<String>(Arrays.asList("Login", "NewUser", "ShowPosts", "SearchPosts", "Contact", "Exit", "Debug"));
			}
			sel = Tools.launchMenu(mainMenu, "Invalid Input");

 			if (sel.equals("login")){	
				login();
				sel = "IN";
			}
			
			if (sel.equals("logout")){	
				Session.logout();
				sel = "IN";
			}
			
			if (sel.equals("myprofile")){	
				myProfile();
			}
		
			 if (sel.equals("newuser")){	
				newUser();
			}

 			if (sel.equals("showposts")){	
				showPosts();
					menuShowPosts();
			}

//			case 4:	searchPosts();
//					break;		
			
 			if (sel.equals("contact")){
				System.out.println("mail@matteombianchini.com");
			}
					
			if (sel.equals("exit")){
				System.out.println("\nBYE BYE!");
				break;
			}
			
			if (sel.equals("debug")){	
				UserDB.printAllUsers();
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
	
	public static void myProfile(){
		ArrayList<String> myProfileMenu = new ArrayList<String>(Arrays.asList(""));
		System.out.println("Hi " + Session.getCurrentAccount().getEmail() + ", this is your profile.");
		Tools.printMyPosts(Session.getCurrentAccount());
		sel = "IN";
	}
	
	public static void newUser(){
		System.out.print("Sign Up\nInsert your email: ");
		String newEmail = Tools.getAndCheckInputString("\\S+@\\S+.\\S+", "is not a valid email adress. Try again!\n");
		System.out.print("Choose a Password: ");
		String newPassword = Tools.getAndCheckInputString("^(?=.*[0-9])(?=.*[a-z])(?=\\S+$).{8,}$", "Password must be 8 characters long and contain at least one number. Try again!\n");
		UserDB.saveNew(newEmail, newPassword);	
	}
	
	public static void showPosts() {		
		Contents.printPostsIntro();
		ArrayList<String> categoryMenu = new ArrayList<String>(Arrays.asList("all", "lessons", "vehicles"));
		category = Tools.launchMenu(categoryMenu, " category does not exist!");
		System.out.println("****************************************************************************");
		Tools.printPosts(category);
		listSize = PostDB.getCategorySize(category);
		replyMenu = Tools.itemSelectionMenu(listSize);
		}
   
	
	public static void menuShowPosts() {	
		while (!sel2.equals("back")) {
			ArrayList<String> menuShow = new ArrayList<String>(Arrays.asList("AcceptPost", "ReplyPost", "Back"));
			sel2 = Tools.launchMenu(menuShow, "invalid input");
			
			if (sel2.equals("replypost")){
				if (Session.getStatus()){
					replyNumSel = Integer.parseInt(Tools.launchMenuNoPrint(replyMenu,"Select post number" ,"invalid input"));
					replyPost(replyNumSel, category);
				} else {
					if(login()){ 
					replyNumSel = Integer.parseInt(Tools.launchMenuNoPrint(replyMenu,"Select post number" ,"invalid input"));
					replyPost(replyNumSel, category);
					}
				}
			}
			
			if (sel2.equals("acceptpost")){
				
			}
		}
		if(sel2.equals("back")){sel2 = "IN";}
	}
	
	public static void replyPost(int input, String category) {
	if(sc.hasNextLine()){
		sc.nextLine();
	}
	System.out.println("Reply to post number " + input + ": ");
	answerBody = sc.nextLine();
	posts = PostDB.getPosts(category);
	posts.get(input-1).addAnswer(answerBody, Session.getCurrentAccount());
	}
		
	public static void contact(){
	  System.out.print("\nInsert your email adress, we will be back to you ASAP :)\n");
	}
	
}       