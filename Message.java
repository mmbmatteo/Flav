/**
 * Write a description of class Message here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import java.util.*;

public abstract class Message
{  
    private     User        receiver;
    private     Post        post;
    private     String      body;
    private     Date        date;

    public abstract Message newMessage(User receiver, Post post, String body);
    public abstract boolean archiveMessage(User user);   
}
