
/**
 * Write a description of class Tester here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

import java.util.*;

public class Tester
{
    public void testLogEntry() {
        LogEntry le = new LogEntry("1.2.3.4", new Date(), "example request", 200, 500);
        System.out.println(le);
        LogEntry le2 = new LogEntry("1.2.100.4", new Date(), "example request 2", 300, 400);
        System.out.println(le2);
    }
    
    public void testLogAnalyzer() {
        // complete method
        LogAnalyzer log = new LogAnalyzer();
        log.readFile("weblog2_log");
        log.printAll();
        System.out.println("There are " + log.countUniqueIps() + " unique IP addresses");
    }
    
    public void testPrintAllHigherThanNum(){
        LogAnalyzer log = new LogAnalyzer();
        log.readFile("weblog1_log");
        log.printAllHigherThanNum(400);
    
    }
    
    public void testUniqueIPVisitsOnDay(){
        LogAnalyzer log = new LogAnalyzer();
        log.readFile("weblog2_log");
        System.out.println("unique IP Visits On Day: "+ log.uniqueIPVisitsOnDay("Sep 27"));
       // System.out.println("unique IP Visits On Day: "+ log.uniqueIPVisitsOnDay("Sep 30"));
    }
    public void testCountUniqueIPsInRange(){
        LogAnalyzer log = new LogAnalyzer();
        log.readFile("weblog2_log");
        System.out.println("unique IP Visits On Day (range): "+ log.countUniqueIPsInRange(200,299));
      //  System.out.println("unique IP Visits On Day: "+ log.countUniqueIPsInRange(300,399));
        
    }
    
    public void testCountVisitsPerIp(){
        LogAnalyzer log = new LogAnalyzer();
        log.readFile("short-test_log");
        HashMap <String, Integer> counts = log.countVisitsPerIp();
        System.out.println(counts);
        
        
    }
    
    public void testMostNumberVisitsByIP(){
        
        LogAnalyzer log = new LogAnalyzer();
        log.readFile("weblog2_log");
        HashMap <String, Integer> counts = log.countVisitsPerIp();
        
        int max = log.mostNumberVisitsByIP(counts);
        System.out.println("Most Number Visits By IP " + max);
        
    }
    
    public void testIPsMostVisits(){
        LogAnalyzer log = new LogAnalyzer();
        log.readFile("weblog2_log");
        HashMap <String, Integer> counts = log.countVisitsPerIp();
        
        ArrayList<String> ips = log.iPsMostVisits(counts);
        
        System.out.println(ips);
    }
    
    public void testIpsForDays(){
        LogAnalyzer log = new LogAnalyzer();
        log.readFile("weblog3-short_log");
        HashMap<String, ArrayList<String>> iPsForDays = log.iPsForDays();
        System.out.println(iPsForDays);
    }
    
    public void testDayWithMostIPVisits(){
        LogAnalyzer log = new LogAnalyzer();
        log.readFile("weblog2_log");
        HashMap<String, ArrayList<String>> iPsForDays = log.iPsForDays();
        
        String day = log.dayWithMostIPVisits(iPsForDays);
        System.out.println(day);
        
    }

   
   public void testIPsWithMostVisitsOnDay(){
        LogAnalyzer log = new LogAnalyzer();
        log.readFile("weblog2_log");
        HashMap<String, ArrayList<String>> iPsForDays = log.iPsForDays();
        System.out.println(log.iPsWithMostVisitsOnDay(iPsForDays,"Sep 30"));
    }
}
