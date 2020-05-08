import edu.duke.*;
/**
 * Write a description of CaesarCipher here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class CaesarCipher {
    public String encrypt(String input, int key){
        
       
        StringBuilder encrypted = new StringBuilder(input);
        
        String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String shiftedAlphabet = alphabet.substring(key) +  alphabet.substring(0,key);
        
        for(int i = 0;i < encrypted.length(); i++){
            char currChar = encrypted.charAt(i);
            int idx = alphabet.indexOf(Character.toUpperCase(currChar));
            
            if(idx != -1){
            
                char newChar = shiftedAlphabet.charAt(idx);
                if(Character.isUpperCase(currChar)){
                    encrypted.setCharAt(i,Character.toUpperCase(newChar));
                }
                else{
                    encrypted.setCharAt(i,Character.toLowerCase(newChar));
                }
                
            
            }
            
        }
        return encrypted.toString();
      
    }
    
    public void testEncrypt(){
      
        System.out.println("FIRST LEGION ATTACK EAST FLANK! is "+ encrypt("FIRST LEGION ATTACK EAST FLANK!", 23));
        System.out.println("First Legion at 23 is " + encrypt("First Legion", 23));
        System.out.println("First Legion at 17 is " + encrypt("First Legion", 17));
        System.out.println("At noon be in the conference room with your hat on for a surprise party. YELL LOUD!");
        
        System.out.println(encrypt("At noon be in the conference room with your hat on for a surprise party. YELL LOUD!",15));
    }
    
    public String encryptTwoKeys(String input, int key1,int key2){
        
        StringBuilder encrypted = new StringBuilder(input);
        String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String shiftedAlphabetKey1 = alphabet.substring(key1) +  alphabet.substring(0,key1);
        String shiftedAlphabetKey2 = alphabet.substring(key2) +  alphabet.substring(0,key2);
        
        for (int i = 0; i < encrypted.length(); i++){
            char currChar = encrypted.charAt(i);
            int idx = alphabet.indexOf(Character.toUpperCase(currChar));
            if(idx != -1){
                if (i % 2 == 0){
                    //even number
                    char newChar = shiftedAlphabetKey1.charAt(idx);
                    if(Character.isUpperCase(currChar)){
                        encrypted.setCharAt(i,Character.toUpperCase(newChar));
                    }
                    else{
                        encrypted.setCharAt(i,Character.toLowerCase(newChar));
                    }
                }
                else{
                    //odd number
                    char newChar = shiftedAlphabetKey2.charAt(idx);
                    if(Character.isUpperCase(currChar)){
                        encrypted.setCharAt(i,Character.toUpperCase(newChar));
                    }
                    else{
                        encrypted.setCharAt(i,Character.toLowerCase(newChar));
                    }
                
                }
                
                
            
            }
            
            
        }
        return encrypted.toString();
    }
    
    public void testEncryptTwoKeys(){
        System.out.println(encryptTwoKeys("At noon be in the conference room with your hat on for a surprise party. YELL LOUD!",8,21));
       // System.out.println(encryptTwoKeys("First Legion", 23, 17));
    }
   
}
