
/**
 * Write a description of ReverseString here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ReverseString {
    public String reverse(String sentence, int key){
        //A man might be too soft
        sentence = sentence.toUpperCase();
        StringBuilder encrypted = new StringBuilder(sentence);
        String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String shiftedAlphabet = alphabet.substring(key) +  alphabet.substring(0,key);
        
        for(int i = 0;i < encrypted.length(); i++){
            char currChar = encrypted.charAt(i);
            int idx = alphabet.indexOf(currChar);
            if(idx != -1){
                char newChar = shiftedAlphabet.charAt(idx);
                encrypted.setCharAt(i,newChar);
            }
            
        }
        return encrypted.toString();
    }
    
    public void testReverse(){
        String message = reverse("A man might be too soft",3);
        System.out.println(message);
    }
}
