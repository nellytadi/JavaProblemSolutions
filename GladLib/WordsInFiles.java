import edu.duke.*;
import java.util.*;
import java.io.File;

/**
 * Write a description of WordsInFiles here.
 * 
 * @author Nelly Tadi 
 * @version (a version number or a date)
 */
public class WordsInFiles {
    private HashMap <String,ArrayList> map;
    
    public WordsInFiles(){
        map = new HashMap <String,ArrayList>();
    }
    
    private void addWordsFromFile(File f){
        FileResource fr = new FileResource(f);
        for (String word : fr.words()){
          
            if (!map.containsKey(word)){
               ArrayList<String> lists = new ArrayList<String>();
               lists.add(f.getName());
               map.put(word, lists);
            }
           else {
               
               ArrayList<String> lists = new ArrayList<String>();
               lists = map.get(word);
               if ( !lists.contains(f.getName())) {
                        lists.add(f.getName());
                  }
           }
        }
    }
    
        
    
    
    public void buildWordFileMap(){
        map.clear();
        DirectoryResource dr = new DirectoryResource();
        for(File f : dr.selectedFiles()){
            addWordsFromFile(f);
        }
    }
    
    public int maxNumber(){
        int max = 0;
        
        for(String w : map.keySet()){
            ArrayList <String> list = map.get(w);
            if(list.size() > max){
                max = list.size();
            }
        }
        return max;
    }
    
    public ArrayList wordsInNumFiles(int number){
        ArrayList <String> mainList = new ArrayList <String> ();
        
        for(String w : map.keySet()){
            ArrayList <String> list = map.get(w);
            if(list.size() == number){
                for(String s : list){
                    if(!mainList.contains(w)){
                        mainList.add(w);
                    }
                   
                }
                
            }
        }
        
        return mainList;
    }
    
    public void printFilesIn(String word){
        word = word.toLowerCase();
        for(String w : map.keySet()){
            w = w.toLowerCase();
            if(w.equals(word)){
                
                ArrayList <String> list = map.get(w);
                for(String s : list){
                    System.out.println(s);
                }
               
            }
        }
    }
    
    public void tester(){
        
       buildWordFileMap();
       //System.out.println("maximum number of files any word is in: \t " + maxNumber());
       printFilesIn("tree");
       
       ArrayList <String> words = wordsInNumFiles(4);
       
       int total = 0;
       for(String w : words){
          // System.out.println(w);
           total++;
       }
       //System.out.println(total);
    }
   
}
