import java.util.*;

public class AnswerDB {
	
	static ArrayList<Post> posts = Demo.getPosts();
	
	public void printAnswers(){
		
	}
}


/*  	public static void printAnswers(User user){
		System.out.println("printAnswers method, you chose " + user.getEmail());
		ArrayList<Post>	posts = user.getMyPosts();
		System.out.println("Postst loading"); int x = 1;
		for (Post p : posts){
		System.out.println("il post " + x++ + "ha risposte?");
			if (p.hasAnswers()){
				System.out.println("si");
				ArrayList<Post>	answers = p.getAnswers();
				for (Post a : answers){
					System.out.println(a.getOwner() + "\t" + a.getDescription());
				}	
			}else{System.out.println("no");}		
		}
	} */