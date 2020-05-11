import edu.duke.*;
/**
 * Write a description of TestCaesarCipherTwo here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class TestCaesarCipherTwo {
    
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
    
    public void simpleTests(){
        
       // FileResource file = new FileResource();
       // String message = file.asString();
        
        CaesarCipherTwo cc = new CaesarCipherTwo(14,24);
        String encrypt = cc.encrypt("Hfs cpwewloj loks cd Hoto kyg Cyy.");
        
        String decrypt = cc.decrypt(encrypt);
        
        System.out.println(encrypt);
        System.out.println(decrypt);
        
    
    }
   
    
}
