import java.util.*;

public class Session{    
	
	static private	boolean	loginStatus = false; //true = loggedin
	static private	User userLogged;
	
	public static void setLoggedIn(User user){
		loginStatus = true;
		userLogged = user;
	}
	
	public static void logout(){
		loginStatus = false;
		userLogged = null;
	}
	
	public static void setLoggedOut(){
		loginStatus = false;
	}
	
	public static boolean getStatus(){
		return loginStatus;
	}
	
	public static User getCurrentAccount(){
		return userLogged;
	}
	
	public static String getCurrentAccountEmail(){
		return userLogged.getEmail();
	}
	
}