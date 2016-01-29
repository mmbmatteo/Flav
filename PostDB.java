import java.util.*;

public class PostDB {
	static ArrayList<Post> posts = Demo.getPosts();
	static HashMap<String, ArrayList> allCatPosts = new HashMap();
	
	static void init() {
		for (Post p : posts) {
			if (!allCatPosts.containsKey(p.getCategory())) {
				ArrayList<Post> catList = new ArrayList<Post>(); 
				allCatPosts.put(p.getCategory(), catList);
			}
			allCatPosts.get(p.getCategory()).add(p);
		}
	}
	
	// Access methods
    public static ArrayList<Post> getPosts(String category) {
		if (category.equals("all")) {
			return posts;
		} else {
		return allCatPosts.get(category);
		}
	}
	
	public static int getCategorySize(String category){
		if (category.equals("all")){
			return posts.size();
		}else{
		int size = allCatPosts.get(category).size();
		return size;
		}
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
//    abstract User     flagPost(Post post);
}