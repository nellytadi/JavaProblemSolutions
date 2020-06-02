import edu.duke.*;
/**
 * Write a description of Tester here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Tester {
    
    public void testCaesarCipher(){
        FileResource rs = new FileResource();
        CaesarCipher crypt = new CaesarCipher(2);
        
        String encrypted = crypt.encrypt(rs.asString());
        System.out.println(encrypted);
       
        String decrypted = crypt.decrypt(encrypted);
        System.out.println(decrypted);
    }
    
    public void testCaesarCracker(){
        
         FileResource rs = new FileResource();
         CaesarCracker cracker = new CaesarCracker();
         System.out.println(cracker.decrypt(rs.asString()));
    }
    
    public void testVigenereCipher(){
        FileResource rs = new FileResource();
        
        int a[]=new int[4];
        a[0]=17;
        a[1]=14;  
        a[2]=12;  
        a[3]=4;  
       
        
        VigenereCipher vig = new VigenereCipher(a);
        String encrypted = vig.encrypt(rs.asString());
        System.out.println(encrypted);
        
        String decrypted = vig.decrypt(encrypted);
        System.out.println(decrypted);
    }
    
    public void testVigenereBreaker(){
        //FileResource rs = new FileResource();    
        VigenereBreaker vb = new VigenereBreaker();
        
        String result = vb.sliceString("abcdefghijklm", 1, 3);
        System.out.println(result);
        
        FileResource rs = new FileResource();
        
        String key = "flut";
        System.out.println(vb.tryKeyLength(rs.asString(),key.length(),'e'));
    }

}
