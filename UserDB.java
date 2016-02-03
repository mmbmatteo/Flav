import java.util.*;

public class UserDB {
	static ArrayList<User> usersList = Demo.getUsers();
	static HashMap<String, User> allCredentials = new HashMap();
	static HashMap<String, User> allEmails = new HashMap();
	
	static void init() {
		for (User u : usersList) {
				allCredentials.put(u.getCredentials(), u);
				allEmails.put(u.getEmail(), u);
		}
	}
	
	static User loginCheck(String loginEmail, String loginPassword){
		String credentials = loginEmail + " " + loginPassword;
		if (allCredentials.containsKey(credentials)){
			System.out.println("\n\t\tWELCOME " + allCredentials.get(credentials).getEmail() + "!\n");
			return allCredentials.get(credentials);
		} else {
			System.out.println("\n\t\tUSER NOT RECOGNIZED! @UserDB.loginCheck\n");
			return null;
		}
	}
	
	static boolean exist(String loginEmail, String loginPassword){
		String credentials = loginEmail + " " + loginPassword;
		return (allCredentials.containsKey(credentials));
	}
	
	static boolean emailExist(String email){
		return (allCredentials.containsKey(email));
	}
	
	static void saveNew(String loginEmail, String loginPassword){
		User newUser = new User(loginEmail, loginPassword);
		usersList.add(newUser);
		allCredentials.put(newUser.getCredentials(), newUser);
		init();
	}
	
	static void printAllUsers(){
		System.out.println("printAllUsers");
		for (User u : usersList){
			System.out.println(u.getCredentials());
		}
	}
}

	
/* 	static User getUser(String loginEmail, String loginPassword){
		String credentials = loginEmail + " " + loginPassword;
		if (allCredentials.containsKey(credentials)){
			return allCredentials.get(credentials);
		} else {System.out.println("\n\t\tUSER NOT RECOGNIZED! @UserDB.getusers\n");}
	} */
	
	// Access methods
   /*  public static ArrayList<Post> getPosts() {
		return posts; 	
	}

    public static ArrayList<Post> getPosts(String category) {
		return allCatPosts.get(category);
    }
	
	public static Post answerPost(Post post, String answerBody) {
		Post answer = post.clone();
		answer.setDescription(answerBody);
		answer.setType("answer");
	return answer;
    }
	
	public static void addPost(Post post){
		posts.add(post);
		allCatPosts.get(post.getCategory()).add(post);
	}
	
	public static HashMap getPostsHashMap(){
		return allCatPosts;
	}
	
	public static void printCategories(){
	System.out.println(Arrays.toString(PostDB.getPostsHashMap().keySet().toArray()));
	}

//    abstract Post     updatePost(Post post);
//    abstract boolean  deletePost(Post post);
//    abstract User     flagPost(Post post); */