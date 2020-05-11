
/**
 * Write a description of CaesarCipherTwo here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class CaesarCipherTwo {
    private String alphabet;
    private String shiftedAlphabetKey1;
    private String shiftedAlphabetKey2;
    
    public CaesarCipherTwo (int key1, int key2){
         alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
         shiftedAlphabetKey1 = alphabet.substring(key1) +  alphabet.substring(0,key1);
         shiftedAlphabetKey2 = alphabet.substring(key2) +  alphabet.substring(0,key2);
        
    }
    
    public String encrypt(String input){
        
    StringBuilder encrypted = new StringBuilder(input);

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
    
    public String decrypt(String encrypted){
         
            StringBuilder message = new StringBuilder(encrypted);
            
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
    
}
