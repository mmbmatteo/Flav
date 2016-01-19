/**
 * Write a description of class Message here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import java.util.*;

public class Feedback
{ 
    private     User        receiver;
    private     int         rate;
    private     String      comment;
    private     Post        post;
    private     Date        date;
    //private     pic     jpg;

    public Feedback newFeedback (User receiver, int rate, String comment, Post post);
    public Feedback updateFeedback(Feedback);
}
