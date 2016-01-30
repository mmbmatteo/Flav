/**
 * Write a description of class Post here.
 * Flav request
 * @mmb (your name) 
 * @1 (a version number or a date)
 */
import java.util.*;

public class Post{    
	
	private     long        	postIdNumber;
	private		String			owner;
    private		String			type; //can be offer request or answer
    private     String      	goodsOrServices;
    private     String      	category;
    private     String      	title;       //maybe add more items
    private     String      	description;
    private     float       	price;
	private		ArrayList<Post>	answers;
    private     float       	latitude;
    private     float       	longitude;
    private     String      	status;
    private     Date        	date;
    //private     pic     jpg;

    public Post(String goodsOrServices, String category, String title, String description, float price) {
	this.goodsOrServices = goodsOrServices;
	this.category = category;
	this.title = title;
	this.description = description;
	this.price = price;
	answers = new ArrayList<Post>();
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
    
    public String getOwner() {
		return owner;
    }
	
	public String getPrice() {
		return String.valueOf(price);
    }
	
	public ArrayList<Post> getAnswers() {
		return answers;
    }
	
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	public void setOwner(User user) {
		owner = user.getEmail();
	}
	
	public void setType(String type) {
		this.type = type;
	}
	
	public Post clone() {
		return new Post(goodsOrServices, category, title, description, price);
	}
	
	public void addAnswer(String answerBody, User user){
		Post answer = clone();
		answer.setOwner(user);
		answer.setDescription(answerBody);
		answer.setType("answer");
		answers.add(answer);
		
	}
	
	public boolean hasAnswers(){
		return !answers.isEmpty();
	}
	
	public int answersNum(){
		return answers.size();
	}
}
