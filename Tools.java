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
	
	
}