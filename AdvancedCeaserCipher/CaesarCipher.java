
/**
 * Write a description of CaesarCipher here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class CaesarCipher {
    
    private String alphabet; 
    private String shiftedAlphabet;
    private int mainKey;
    
    public CaesarCipher(int key){
        mainKey = key;
        alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        shiftedAlphabet = alphabet.substring(key) +  alphabet.substring(0,key);
        
    }
    
    public String encrypt(String message){
       
        StringBuilder encrypted = new StringBuilder(message);
       
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
    
    public String decrypt(String message){
            
        CaesarCipher cc = new CaesarCipher(26 - mainKey); 
        message = cc.encrypt(message);
        return message.toString();
            
    }
}
