/**
 * Write a description of class Post here.
 * Flav request
 * @mmb (your name) 
 * @1 (a version number or a date)
 */
import java.util.*;

public class Post
{
    private     long        postIdNumber;
	private		String		requestOrOffer;
    private     String      type;
    private     String      category;
    private     String      title;       //maybe add more items
    private     String      description;
    private     float       price;
    private     float       latitude;
    private     float       longitude;
    private     String      status;
    private     Date        date;
    //private     pic     jpg;
    public Post     newPost(String type, String category, String title, String description, float price);
    public Post     updatePost(Post);
    public boolean  deletePost(Post);
    public User     flagPost(Post);
}