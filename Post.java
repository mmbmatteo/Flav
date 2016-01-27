/**
 * Write a description of class Post here.
 * Flav request
 * @mmb (your name) 
 * @1 (a version number or a date)
 */
import java.util.*;

public class Post{    
	
	private     long        	postIdNumber;
    private		String			type;
    private     String      	goodsOrServices;
    private     String      	category;
    private     String      	title;       //maybe add more items
    private     String      	description;
    private     float       	price;
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
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	public void setType(String type) {
		this.type = type;
	}
	
	public Post clone() {
		return new Post(goodsOrServices, category, title, description, price);
	}


}
