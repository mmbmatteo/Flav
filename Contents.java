import java.util.*;
import java.text.*;


public class Contents {
	
	public static void printHome(){
		System.out.println("\n\t\t***************************************************************");
		System.out.println("  \t\t** FLAV WILL HELP YOU BUILD A BETTER LIFE AND A BETTER WORLD **");
		System.out.println("  \t\t***************************************************************");
	}
	
	public static void printMainMenu(){
		System.out.println("\n\t\t\t\t\t***************");
		System.out.println("  \t\t\t\t\t** HOME PAGE **");
		System.out.println("  \t\t\t\t\t***************");	
		if (Session.getStatus()){System.out.println("\tHi " + Session.getCurrentAccountEmail());}
		//System.out.print("\n\n\tLogin\n\tNewUser\n\tShowPosts\n\tSearchPosts\n\tContact\n\tHelp\n\tExit\n\nSelect Function:\t");
	}
	
	public static void printPostsIntro(){
		System.out.println("****************************************************************************");
		System.out.print("Enter the category you are interested in (type: 'all' for showing all posts)\t");
	}
}