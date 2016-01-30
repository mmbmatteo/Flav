
import java.util.*;


public class Demo {
	
	static ArrayList<User> users = new ArrayList<User>();
	static ArrayList<Post> posts = new ArrayList<Post>();
	
	static void init(){
		generateUsers();
		generatePosts();
		assignPosts();
	}
	
	
	static public void generateUsers() {
		users.add(new User("test", "test"));
		users.add(new User("matteo@m.com", "password"));
		users.add(new User("freeman@m.com", "password"));
		users.add(new User("vaibav@m.com", "password"));
		users.add(new User("dheeraj@m.com", "password"));
    }

    static public void generatePosts() {
		posts.add(new Post("goods", "vehicles", "1995 van for sale", "van blahn blah balh", 2500));
		posts.add(new Post("goods", "vehicles", "1987 BMW Convertible", "high miles awesome car", 5000));
		posts.add(new Post("goods", "vehicles", "electric unicycle", "SBU 3rd generation", 900));
		posts.add(new Post("services", "lessons", "coding lessons", "I've been coding for 20 years", 40));
		posts.add(new Post("services", "lessons", "yoga teacher", "yoga lessons every weekend", 15));
		posts.add(new Post("services", "lessons", "farm workshop", "3 days on a farm with eat healthy", 200));
	}
	
	static public void assignPosts() {
		int count = 0;
		for (Post p : posts){
			p.setOwner(users.get(count));
			p.addAnswer("default answer", users.get(users.size() - count - 1));
			users.get(count).uploadPost(p);
			count++;
		if (count >= users.size()){count = 0;}
		}
	}	
	
    static public ArrayList<User> getUsers() {
		return users;
    }

    static public ArrayList<Post> getPosts() {
		return posts;
    }
}

 
