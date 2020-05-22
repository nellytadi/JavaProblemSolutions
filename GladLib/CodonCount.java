import java.util.*;
import edu.duke.*;

/**
 * Write a description of CodonCount here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class CodonCount {
    
    private HashMap <String, Integer> map;
    
    public CodonCount(){
        map = new HashMap <String,Integer>();
    }
    
    public void buildCodonMap(int start, String dna){
        map.clear();
        
        String main = dna.substring(start,dna.length() - 1);
    
        for(int i = 0; i < main.length();i++){
            if(i != 0 && i%3 == 0){
              
                String s = main.substring(i-3,i);
                
                if(map.keySet().contains(s)){
                    map.put(s,map.get(s)+1);
                }
                else{
                    map.put(s,1);
                }
                
            }
        }
        
        System.out.println(main);
        
        for(String w : map.keySet()){
            System.out.println(w+ " \t " + map.get(w));
            
        }
        
    }
    
    public String getMostCommonCodon(){
        int highest =0;
        String common = "";
        for(String w : map.keySet()){
            
            
            if(highest < map.get(w)){
                
                highest = map.get(w);
                common = w;
            }
        }
        
        return common + " with count " + highest;
    }
    
    
    public void printCodonCounts(int start, int end){
        System.out.println("Codons between " + start + " and " + end);
        
        for(String w : map.keySet()){
            
            
            if( map.get(w) >= start && map.get(w) <= end){ 
               System.out.println(w + "\t" + map.get(w));
            }
        }
    }
    
    public void tester(){
        FileResource resource = new FileResource();
        buildCodonMap(0,resource.asString().toUpperCase().trim());
        printCodonCounts(1,5);
        System.out.println("The most common codon is " + getMostCommonCodon());
    }
    
}
