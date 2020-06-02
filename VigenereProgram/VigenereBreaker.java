import java.util.*;
import edu.duke.*;
import java.io.File;

public class VigenereBreaker {
    
    public String sliceString(String message, int whichSlice, int totalSlices) {
        
        
        String result = "";
        for(int i = whichSlice; i < message.length(); i += totalSlices){
            char r = message.charAt(i);
            result += r;
        }

        return result;
    }

    public int[] tryKeyLength(String encrypted, int klength, char mostCommon) {
        
        CaesarCracker crackers=new CaesarCracker(mostCommon);
        int[] s= new int[klength];
    
        for(int i=0;i < klength;i++){
           s[i]=crackers.getKey(sliceString(encrypted,i,klength));
           
        }       
        
        return s;
    }
    
    public HashSet<String> readDictionary(FileResource dictionary){
        HashSet<String> hs = new HashSet <String> ();
        
        for(String word : dictionary.lines()){
            word = word.toLowerCase();
           
            hs.add(word);
        }
        return hs;
    }
    
    public int countWords(String message, HashSet<String> dictionary ){
        int count = 0;
        
        for(String word : message.split("\\W+")){
            word = word.toLowerCase();
            if(dictionary.contains(word)){
                count++;
            }
        
        }
        return count;
    }
    
    public String breakForLanguage(String encrypted, HashSet<String> dictionary){
        String decrypted = "";
        int count = 0;
        int [] mainK = new int [10];
        char mostCommonChar = mostCommonCharIn(dictionary);
        for (int i = 1; i <= 100; i++){
            int [] keys = tryKeyLength(encrypted,i,mostCommonChar);
            
            VigenereCipher vc = new VigenereCipher(keys);
            String decrypt = vc.decrypt(encrypted);
            int result = countWords(decrypt,dictionary);
            if(result > count){
                count = result;
                decrypted = decrypt;
                mainK = keys;
            }
            
            
        }
        
        for(int i = 0; i < mainK.length; i++){
            System.out.println(mainK[i]);
        }
        
        System.out.println("This file contains "+count+" valid words");
        return decrypted;
    }
    
    public char mostCommonCharIn(HashSet<String> dictionary){
        
        HashMap <Character,Integer> alpha = new HashMap<Character, Integer>();

        for(String word : dictionary){
            for(int i = 0; i < word.length();i++){
                char ch = word.charAt(i);
                if(alpha.containsKey(ch)){
                    alpha.put(ch, alpha.get(ch) + 1);
                }
                else{
                    alpha.put(ch, 1);
                }
            }
        }
        
        char mChar = 0;
        int count =0;
        for(char common : alpha.keySet()){
            if(alpha.get(common) > count){
                mChar = common;
                count = alpha.get(common);
            }
        }
        
        return mChar;
    
    }
    
    public String breakForAllLangs(String encrypted, HashMap <String,HashSet<String>> languages){
        String decrypted = "";
        int count = 0;
        String mainLang = "";
        for(String lang : languages.keySet()){
           HashSet<String> dictionary= languages.get(lang);
           String decrypt = breakForLanguage(encrypted,dictionary);
           int result = countWords(decrypt,dictionary);
            if(result > count){
                count = result;
                decrypted = decrypt;
                mainLang = lang;
            }
        }
        
        System.out.println("The message was encrypted in " + mainLang);
        //System.out.println(decrypted);
        return decrypted;
    }
    
    public void breakVigenere () {
        DirectoryResource dr = new DirectoryResource();
        HashMap <String,HashSet<String>> languages = new HashMap <String,HashSet<String>> ();
        
        for(File f : dr.selectedFiles()){
            String name = f.getName();
            FileResource dict = new FileResource(f);
            HashSet<String> dictionary = readDictionary(dict);
            languages.put(name,dictionary);
        }
        FileResource rs = new FileResource("messages/secretmessage3.txt");
        System.out.println(breakForAllLangs(rs.asString(),languages));
        
    }
    
    public void breakVigenereOneFile () {
        FileResource rs = new FileResource();
        FileResource dict = new FileResource("dictionaries/English");
        HashSet<String> dictionary = readDictionary(dict);
        System.out.println(breakForLanguage(rs.asString(),dictionary));
        
    }
}
