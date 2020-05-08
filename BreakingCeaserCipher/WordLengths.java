import edu.duke.*;
/**
 * Write a description of WordLengths here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class WordLengths {
    
    public void countWordLengths (FileResource resource,int [] counts){
           
       
        for(String word : resource.words()){
            
            for (int k = 0; k < counts.length ; k++){
                if(k == word.length() ){
                    counts[k] = word.length();
                }
            }
    
        }
        for(int i = 0; i < counts.length; i++){
            System.out.println("There are " + counts[i] + " words with length " + i);
        }
    }
    
    public void testCountWordLengths(){
        FileResource resource = new FileResource("CommonWordsData/small.txt");
        int [] counts = new int [13];
        countWordLengths(resource,counts);
    }
}
