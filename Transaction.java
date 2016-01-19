/**
 * Write a description of class user here.
 * Flav request
 * @mmb (your name) 
 * @1 (a version number or a date)
 */
import java.util.*;

public abstract class Transaction
{
    private     Post        post;
    private     User        buyer;
    private     Date        date;
    private     String      notes;
    //private     pic     jpg;
    public abstract Transaction newTransaction (User buyer, Post post, String notes);
}
