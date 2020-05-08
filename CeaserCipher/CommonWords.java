import edu.duke.*;
/**
 * Write a description of CommonWords here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class CommonWords {
    public String [] getCommon(){
        FileResource resource = new FileResource("CommonWordsData/common.txt");
        String [] common = new String [20];
        
        int index = 0;
        
        for(String s : resource.words()){
            common[index] = s;
            index++;
        }
        return common;
    }
    public int indexOf(String [] common, String word){
        for(int k = 0;k < common.length ; k++){
            if(common[k].equals(word)){
                return k;
            }
        }
        return -1;
    }
    public void countWords(FileResource resource,String [] common,int [] counts){
        for(String word : resource.words()){
            word = word.toLowerCase();
            int index = indexOf(common,word);
            if(index != -1){
                counts[index] ++;
            }
        }
    }
    public void countShakespear(){
        String [] plays = {"caesar.txt","errors.txt","hamlet.txt","likeit.txt","macbeth.txt","romeo.txt"};
        //returns an array of strings of all the most common words in the common.txt file
        String [] common = getCommon();
        int [] counts = new int [common.length];
        
        for(int k = 0; k < plays.length; k++){
            FileResource resource = new FileResource("CommonWordsData/"+ plays[k]);
            countWords(resource,common,counts);
            System.out.println("done with " + plays[k] );
        }
        
        for(int k = 0; k < common.length; k++){
            System.out.println(common[k] + " appears " + counts[k] + " times ");
        }
    }
}
