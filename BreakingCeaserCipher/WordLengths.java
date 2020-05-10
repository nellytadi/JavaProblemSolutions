import edu.duke.*;
/**
 * Write a description of WordLengths here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class WordLengths {
    
    public int [] countWordLengths (FileResource resource,int [] counts){
           
       for(String word : resource.words()){
            
            word = word.toLowerCase();
            int length = word.length();
            
            char start = word.charAt(0);
            char end = word.charAt(length - 1);
            
            //!Character.isLetter(word.charAt(word.length() - 1))
            if(!Character.isLetter(start) || !Character.isLetter(end)){
                length = length - 1;
            }
           //System.out.println(word +"\t"+length);
            for (int i = 0; i < counts.length ; i++){
                if(i == length){
                    counts[i] ++;
                }
            }   
    
       }
        
        for(int i = 0; i < counts.length; i++){
            System.out.println("There are " + counts[i] + " words with length " + i);
        }
        
        return counts;
    }
    public int indexOfMax (int [] values){
        int max = 0;
        for(int i = 0; i < values.length ; i++){
            if(values[i] > max){
                max = values[i];
            }
        }
        return max;
    }
    public void testCountWordLengths(){
        FileResource resource = new FileResource();
        int [] counts = new int [200];
        
        int max = indexOfMax(countWordLengths(resource,counts));
        System.out.println("The most count of words is " + max );
    }
}
