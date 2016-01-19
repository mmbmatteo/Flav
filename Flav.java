
/**
 * Write a description of class flav here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

import java.util.*;

public class Flav {

    static Scanner sc=new Scanner(System.in);
    static List<Post> posts;

    public static void main(String[] args) {
	posts = Demo.getPosts();
// 		initUsers();
//		initPosts();
//		initMessages
//		initTransactions 
	
		
		//FIRST ACCESS
        System.out.print("\nFLAV WILL HELP YOU BUILD A BETTER LIFE AND A BETTER WORLD\n\n1\tLogin\n2\tI'm a new user\n3\tView Posts\n4\tSearch Posts\n5\tContact us\n6\tExit\n\n");
		String selector = getAndCheckInputString("1|2|3");
		int sel = Integer.parseInt(selector);
		switch (sel) {
			
			case 1:	login();
					break;
		
			case 2:	newUser();
					break;

 			case 3:	showPosts();
					break;	

//			case 4:	searchPosts();
//					break;		
			case 5: contact();
					break;
					
			case 6: break;
		}			
	}

	public static void showPosts() {
	    String category = sc.nextLine();
	    List<Post> posts = null;
	    if (category.length() == 0) {
		posts = Post.getPosts();
	    } else {
		System.out.println("Category: "+category);
		posts = Post.getPosts(category);
	    }
	    
   	    if (posts != null) {
	        for (Post p : posts) {
	    	    System.out.println("title: " + p.getTitle());
	        }
	    }
	}
	
	//TWO FUNCTIONS OVERLOAD
	public static String getAndCheckInputString(String pattern, String invalidMessage){
			String toCheck;
				do {
					toCheck=sc.next();
					if(!toCheck.matches(pattern)){
						System.out.println(toCheck + " " + invalidMessage + "\n");
					}
				}while (!toCheck.matches(pattern));
				return toCheck;
	}
	
	public static String getAndCheckInputString(String pattern){
		String toCheck;
			do {
				toCheck=sc.next();
				if(!toCheck.matches(pattern)){
					System.out.println(toCheck + " IS AN INVALID INPUT! TRY AGAIN\n");
				}
			}while (!toCheck.matches(pattern));
			return toCheck;
	}
	//END TWO FUNCTIONS OVERLOAD
	
	public static void newUser(){
		System.out.print("Sign Up\nInsert your email: ");
		String newEmail = getAndCheckInputString("\\S+@\\S+.\\S+", "is not a valid email adress. Try again!\n");
		System.out.print("\nChoose a Password: ");
		String newPassword = getAndCheckInputString("^(?=.*[0-9])(?=.*[a-z])(?=\\S+$).{8,}$", "Password must be 8 characters long and contain at least one number. Try again!\n");
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
