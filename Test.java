
/**
 * Write a description of class flav here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

import java.util.*;

public class Test {

	static Scanner 			sc = new Scanner(System.in);
	static String 			sel = "IN";

	public static void main(String[] args) {
	
	String[] testMenu = {"primo","Secondo","terzo"};
	String[] testMenu2 ={"login", "NewUser", "ShowPosts", "SearchPosts", "Contact", "Help", "exit"};

	String sel = Tools.launchMenu(testMenu, "stai attento");
	String sel2 = Tools.launchMenu(testMenu2, "stai attento");
	}
}       