import java.util.*;
import edu.duke.*;
/**
 * Write a description of CharactersInPlay here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class CharactersInPlay {
    
    private ArrayList <String> characters;
    private ArrayList <Integer> counts;
    
    public CharactersInPlay(){
        characters = new ArrayList <String>();
        counts = new ArrayList <Integer> ();
    }
    
    public void update(String person){
        // s = s.toLowerCase();
        int index = characters.indexOf(person);
        if (index == -1){
           characters.add(person);
           counts.add(1);
        }
        else{
           int value = counts.get(index);
           counts.set(index, value+1);
        }
       
    }
    
    public void findAllCharacters (){
        characters.clear();
        counts.clear();
        
        FileResource resource = new FileResource();
        
        for(String s : resource.lines()){
            s = s.toLowerCase();
            int period = s.indexOf(".");
            
            if(period != -1){
                String person = s.substring(0,period);
                update(person);
            }
            
        }
    }
    
    public void charactersWithNumParts(int num1, int num2){
        if(num1 <= num2){
            System.out.println("Start");
            for(int i =0; i < counts.size() ; i++){
                if(counts.get(i) >= num1 && counts.get(i) <= num2 ){
                    System.out.println(characters.get(i) + "\t" + counts.get(i));
                }
            }   
        }
    } 
    public void tester(){
        
        findAllCharacters();
        for(int i =0; i < counts.size() ; i++){
            if(counts.get(i) < 100 && counts.get(i) != 1){
                System.out.println(characters.get(i) + "\t" + counts.get(i));
            }
       }
        
        charactersWithNumParts(10,15);
        
        
    }
    
    
}
