import edu.duke.*;

/**
 * Write a description of TestCaesarCipher here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class TestCaesarCipher {
    
    
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
    

    public int getKey(String s){
        int[] freq = countLetters(s);
        int maxDex = maxIndex(freq);
        
        int dkey = maxDex -4;
        if (maxDex < 4){
            dkey = 26 - (4-maxDex);
        }
        return dkey;
    }
    
    public String breakCaesarCipher(String input){
        
        
        int key = getKey(input);
        System.out.println("key is " + key);
        
        CaesarCipher cc = new CaesarCipher(key);
        
        String decrypt = cc.encrypt(input);
        return decrypt;
        
    }
    
    public void simpleTests(){
        FileResource file = new FileResource();
        String message = file.asString();
        
        CaesarCipher cc = new CaesarCipher(15);
        String encrypt = cc.encrypt(message);
        
        String decrypt = cc.decrypt(encrypt);
        
        System.out.println(encrypt);
        System.out.println(decrypt);
        
        
        
        System.out.println("Decrypted message with no key - " + breakCaesarCipher(encrypt));
        
    }
    
    

}
