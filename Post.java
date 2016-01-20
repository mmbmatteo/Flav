/**
 * Write a description of class Post here.
 * Flav request
 * @mmb (your name) 
 * @1 (a version number or a date)
 */
import java.util.*;

public class Post
{
    private     long        	postIdNumber;
    private	String		requestOrOffer;
    private     String      	type;
    private     String      	category;
    private     String      	title;       //maybe add more items
    private     String      	description;
    private     float       	price;
    private     float       	latitude;
    private     float       	longitude;
    private     String      	status;
    private     Date        	date;
    //private     pic     jpg;

    public Post(String type, String category, String title, String description, float price) {
	this.type = type;
	this.category = category;
	this.title = title;
	this.description = description;
	this.price = price;
    }

	public String getTitle() {
	return title;
	}
    
	public String getCategory() {
	return category;
    }
    
	public String getDescription() {
	return description;
    }
    
    	public String getPrice() {
	return String.valueOf(price);
    }

// Access methods
    public static List<Post> getPosts() {
	return Demo.getPosts();
    }

    public static List<Post> getPosts(String category) {
	HashMap<String, List> allCatPosts = new HashMap();
	List<Post> posts = getPosts();

        for (Post p : posts) {
	    if (!allCatPosts.containsKey(p.getCategory())) {
		allCatPosts.put(category, new ArrayList<Post>());
	    }
	    allCatPosts.get(category).add(p);
        }
	return allCatPosts.get(allCatPosts.get(category));
    }


//    abstract Post     updatePost(Post post);
//    abstract boolean  deletePost(Post post);
//    abstract User     flagPost(Post post);
}
