import java.util.*;
import edu.duke.*;
/**
 * Write a description of WordFrequencies here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class WordFrequencies {
    private ArrayList<String> myWords;
    private ArrayList<Integer> myFreqs;
    
    
    public WordFrequencies(){
        myWords = new ArrayList<String> ();
        myFreqs = new ArrayList<Integer> ();
    }
    
    
    public void findUnique(){
        FileResource resource = new FileResource();
        
        for (String s : resource.words()){
            s = s.toLowerCase();
            int index = myWords.indexOf(s);
            
            if (index == -1){
                myWords.add(s);
                myFreqs.add(1);
            }
            else{
                int value = myFreqs.get(index);
                myFreqs.set(index, value+1);
            }
            
        }
        
    
    }
    public int findIndexOfMax (){
       int maxIndex = 0;
       int max = 0;
        for(int i = 0;i < myFreqs.size();i++ ){
           if(myFreqs.get(i) > maxIndex ){
               maxIndex = myFreqs.get(i);
               max = i;
           }
       }
       
       return max;
   }
    public void testFindUnique(){
        findUnique();
        
        System.out.println("There are " + myWords.size() + " unique words" );
        
        for(int i = 0; i < myWords.size(); i++){
            System.out.println(myFreqs.get(i)+ "\t" +myWords.get(i));
        }
        int max = findIndexOfMax();
        System.out.println("The word that occurs most often and its count are: " + myWords.get(max) + " with count "+ myFreqs.get(max));
    }
    
}
