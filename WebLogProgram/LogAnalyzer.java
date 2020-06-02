
/**
 * Write a description of class LogAnalyzer here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

import java.util.*;
import edu.duke.*;

public class LogAnalyzer
{
     private ArrayList<LogEntry> records;
     
     public LogAnalyzer() {
         // complete constructor
         records = new ArrayList<LogEntry> ();
     }
        
     public void readFile(String filename) {
         // complete method
         FileResource resource = new FileResource(filename);
         
         for(String line : resource.lines()){
             LogEntry log = WebLogParser.parseEntry(line);
             records.add(log);
             
         }
     }
        
     public HashMap<String,Integer> countVisitsPerIp(){
        HashMap<String,Integer> counts = new HashMap<String,Integer>();
        
        for(LogEntry le : records){
            String ip =le.getIpAddress();
            if(!counts.containsKey(ip)){
                counts.put(ip,1);
            }
            else{
                counts.put(ip,counts.get(ip) + 1);
            
            }
        
        }
        return counts;
    }
    
    public int mostNumberVisitsByIP(HashMap<String,Integer> counts){
        int maxNo = 0;
        for(String s : counts.keySet()){
            if(counts.get(s) > maxNo){
                maxNo = counts.get(s);
            }
        }
        
        return maxNo;
    }
    
    public ArrayList<String> iPsMostVisits(HashMap<String,Integer> counts){
        ArrayList<String> ips = new ArrayList<String>();
        int maxNo = mostNumberVisitsByIP(counts);
        for(String s : counts.keySet()){
            if(counts.get(s) == maxNo){
                ips.add(s);
            }
        }
        
        return ips;
    }
    
    public HashMap<String, ArrayList<String>> iPsForDays(){
        HashMap<String,ArrayList<String>> counts = new HashMap<String,ArrayList<String>>();
        
        for(LogEntry log : records){
            Date d = log.getAccessTime();
            String dates = d.toString();
            dates = dates.substring(4,10);
            String ipadd = log.getIpAddress();
            if(!counts.containsKey(dates)){
                ArrayList <String> ips = new ArrayList<String>();
                ips.add(ipadd);
                counts.put(dates,ips);
            }
            else{
                ArrayList <String> ips = counts.get(dates);
                
                ips.add(ipadd);
                counts.put(dates,ips);
                
                
            
            }
            
            
            
         }
         
         return counts;
    }
    
    public String dayWithMostIPVisits(HashMap<String, ArrayList<String>> myMap){
        
        String visits = "";
        int size = 0;
        for(String day : myMap.keySet()){
            ArrayList<String> chk = myMap.get(day);
            if(chk.size() > size){
                visits = day;
                size = chk.size();
            }
        }
        
        return visits;
    }
    
    public ArrayList<String> iPsWithMostVisitsOnDay(HashMap<String, ArrayList<String>> dates, String day){
         
         //Make an ArrayList with the ip addresses that occur on your day parameter in the HashMap
         ArrayList<String> visitsOnDay = dates.get(day);
         
         //Make a NEW HashMap to hold the unique IP addresses and the number of times they occur
         HashMap<String, Integer> ipCounts = new HashMap<String, Integer>();
         
         //Now fill this HashMap using the same algorithm we've been using for the previous few assignments
         for(String ip : visitsOnDay){
             if(!ipCounts.containsKey(ip)){
                 ipCounts.put(ip, 1);
             }
             else{
                 ipCounts.put(ip, ipCounts.get(ip) + 1);
             }
         }
         
         //Now, the answer is as simple as calling iPsMostVisits (which returns an ArrayList<String>) on the HashMap you just made!
         return iPsMostVisits(ipCounts);
     }
    
    public int countUniqueIps(){
         ArrayList <String> uniqueIps = new ArrayList <String>();
         
         for(LogEntry log : records){
             String ip = log.getIpAddress();
             
             if(!uniqueIps.contains(ip)){
                uniqueIps.add(ip);
             }
            
         }
        return uniqueIps.size();
     }
     
     public void printAllHigherThanNum(int num){
       
         
         for(LogEntry log : records){
             int status = log.getStatusCode();
             
             if(status > num){
                System.out.println(log);
             }
            
         }
        
     }
     
     public int uniqueIPVisitsOnDay (String someday){
        ArrayList <String> uniqueLogs = new ArrayList <String>();
        
        for(LogEntry log : records){
             Date dates = log.getAccessTime();
             String ip = log.getIpAddress();
             String dts = dates.toString();
             
             if (dts.indexOf(someday) != -1 ){
                 if(!uniqueLogs.contains(ip)){
                    uniqueLogs.add(ip);
                }
             }
            
         }
        return uniqueLogs.size();
     }
     
     public int countUniqueIPsInRange(int low,int high){
         
        ArrayList <String> uniqueIps = new ArrayList <String>();
         
        for(LogEntry log : records){
             int status = log.getStatusCode();
             String ip = log.getIpAddress();
             if(status >= low && status <= high){
                 if(!uniqueIps.contains(ip)){
                     uniqueIps.add(ip);
                 }
             }
            
         }
         return uniqueIps.size();
     }
     public void printAll() {
         for (LogEntry le : records) {
             System.out.println(le.getIpAddress());
         }
     }
     
     
}
