
import java.util.*;


public class Demo {
    static public ArrayList getUsers() {
	ArrayList users = new ArrayList();
	users.add(new User("matteo@m.com", "password"));
	users.add(new User("freeman@m.com", "password"));
	users.add(new User("vaibav@m.com", "password"));
	users.add(new User("dheeraj@m.com", "password"));
	users.add(new User("test", "test"));

	return users;
    }

    static public ArrayList<Post> getPosts() {
	ArrayList<Post> posts = new ArrayList<Post>();
	posts.add(new Post("goods", "vehicles", "1995 van for sale", "van blahn blah balh", 2500));
	posts.add(new Post("goods", "vehicles", "1987 BMW Convertible", "high miles awesome car", 5000));
	posts.add(new Post("goods", "vehicles", "electric unicycle", "SBU 3rd generation", 900));
	posts.add(new Post("services", "lessons", "coding lessons", "I've been coding for 20 years", 40));
	posts.add(new Post("services", "lessons", "yoga teacher", "yoga lessons every weekend", 15));
	posts.add(new Post("services", "lessons", "farm workshop", "3 days on a farm with eat healthy", 200));

	return posts;
    }
}

 
