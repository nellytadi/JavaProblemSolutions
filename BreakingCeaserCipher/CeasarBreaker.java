import edu.duke.*;
/**
 * Write a description of CeasarBreaker here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class CeasarBreaker {
    public String decrypt(String encrypted, int key){
            StringBuilder message = new StringBuilder(encrypted);
            
            String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
            String shiftedAlphabet =  alphabet.substring(key) + alphabet.substring(0,key)  ;
            //System.out.println(shiftedAlphabet);
            for(int i = 0;i < message.length(); i++){
                char currChar = message.charAt(i);
                int idx = shiftedAlphabet.indexOf(Character.toUpperCase(currChar));
                
                if(idx != -1){
                
                    char newChar = alphabet.charAt(idx);
                    if(Character.isUpperCase(currChar)){
                        message.setCharAt(i,Character.toUpperCase(newChar));
                    }
                    else{
                        message.setCharAt(i,Character.toLowerCase(newChar));
                    }
                    
                
                }
                
            }
            return message.toString();
            
        }
        public String decryptTwoKeys(String encrypted, int key1, int key2){
            
            StringBuilder message = new StringBuilder(encrypted);
            String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
            String shiftedAlphabetKey1 = alphabet.substring(key1) +  alphabet.substring(0,key1);
            String shiftedAlphabetKey2 = alphabet.substring(key2) +  alphabet.substring(0,key2);
            
            for (int i = 0; i < message.length(); i++){
                char currChar = message.charAt(i);
               
              
                if (i % 2 == 0){
                        //even number
                    int idx = shiftedAlphabetKey1.indexOf(Character.toUpperCase(currChar));
                    if(idx != -1){
                        
                        char newChar = alphabet.charAt(idx);
                        if(Character.isUpperCase(currChar)){
                            message.setCharAt(i,Character.toUpperCase(newChar));
                        }
                        else{
                             message.setCharAt(i,Character.toLowerCase(newChar));
                        }
                    }
                }
                else{
                    
                    //odd number
                    int idx = shiftedAlphabetKey2.indexOf(Character.toUpperCase(currChar));
                    if(idx != -1){
                        char newChar = alphabet.charAt(idx);
                        if(Character.isUpperCase(currChar)){
                            message.setCharAt(i,Character.toUpperCase(newChar));
                        }
                        else{
                             message.setCharAt(i,Character.toLowerCase(newChar));
                        }
                    }
                    
                }
                    
                    
                
            }
              
        return message.toString();
    }
    public void decryptNoKeys(String message){
        
        for(int i = 1; i <= 26; i++){
            for(int k = 1; k <= 26; k++){
                System.out.println(decryptTwoKeys(message,i,k) + " \t key " + i + " and " + k);
            }
        }
        
        
    }
    public void testDecrypt(){
        CeasarCipher cipher = new CeasarCipher();
        System.out.println(decrypt(cipher.encrypt("At noon be in the conference room with your hat on for a surprise party. YELL LOUD!",15),15));
    }
    
    public void testDecryptTwoKeys(){
       // CeasarCipher cipher = new CeasarCipher();
        //String encrypt = cipher.encryptTwoKeys("At noon be in the conference room with your hat on for a surprise party. YELL LOUD!",8,21);
        System.out.println(decryptTwoKeys("Top ncmy qkff vi vguv vbg ycpx",2,20));
       
    }
    public void testDecryptNoKeys(){
        //decryptNoKeys("Aal uttx hm aal Qtct Fhljha pl Wbdl. Pvxvxlx!");
        FileResource resource = new FileResource();
        decryptNoKeys(resource.asString());
    }
    
    public String halfOfString(String message, int start){
        
        StringBuilder value = new StringBuilder(message);
        String result = "";
        
        for (int i = 0; i < message.length(); i ++){
            if(start == 0){
                //odd number
                if(i % 2 == 0){
                    char ch = value.charAt(i);
                    result=result + ch;
                }
                
            }
            else if(start == 1){
                //even number
                if(i % 2 != 0){
                    char ch = value.charAt(i);
                    result=result + ch;
                }
            }
        }
        
        return result;
    }
    
    public int getKey(String s){
        int [] freqArray = countLetters(s);
        int key = maxIndex(freqArray);
        return key;
    }
    
    public int[] countLetters(String message){
       
        String alpha = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        int count[] = new int[alpha.length()];
        
        for(int i = 0;i < message.length(); i++){
            char ch = Character.toUpperCase(message.charAt(i));
            int index = alpha.indexOf(ch);
            if(index != -1){
                count[index] += 1;
            }
        }
        
        for(int i = 0; i < count.length; i++){
            System.out.println(alpha.charAt(i)+"\t"+count[i]);
        }
        
        return count;
    }
   
    
    public int maxIndex(int [] values){
        int max = 0;
        for(int i = 0; i < values.length ; i++){
            if(values[i] > max){
                max = values[i];
            }
        }
        return max;
    }
    public void testCountLetters(){
        System.out.println(getKey("aabbcceeee"));
    }
    public void testHalfOfString(String s){
        
        System.out.println(halfOfString("Qbkm Zgis",0));
        System.out.println(halfOfString("Qbkm Zgis",1));
        
    }
}
