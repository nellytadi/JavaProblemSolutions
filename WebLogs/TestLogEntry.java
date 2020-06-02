import java.util.*;
/**
 * Write a description of TestLogEntry here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class TestLogEntry {
    
    public void test(){
        LogEntry log = new LogEntry("198.0.0.1",new Date(), "Example request", 200,500);
        System.out.println(log);
    
    } 

}
