import java.util.*;
import edu.duke.*;
/**
 * Write a description of WordFrequencies here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class WordFrequencies {
    private HashMap <String, Integer> map;
    
    public void countWords(){
        
        FileResource resource = new FileResource();
        map = new HashMap <String, Integer>();
        
        for(String s : resource.words()){
            
            s = s.toLowerCase();
            
            if(map.keySet().contains(s)){
                map.put(s,map.get(s)+1);
            }
            else{
                map.put(s,1);
            }
            
        }
        
        for(String w : map.keySet()){
            int occurence = map.get(w);
            
            if(occurence > 100){
                System.out.println(w+ " \t " + occurence);
            }
        }
    }
}
