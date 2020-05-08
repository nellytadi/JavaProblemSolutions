
/**
 * Write a description of WordPlay here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class WordPlay {
    
    public String emphasize(String phrase, char ch){
        ch = Character.toLowerCase(ch);
        StringBuilder newPhrase = new StringBuilder(phrase);
        
        for(int i = 0; i < newPhrase.length(); i++){
            char chk = newPhrase.charAt(i);
            chk = Character.toLowerCase(chk);
            
            if(chk == ch){
                if(i % 2 == 0){
                    newPhrase.setCharAt(i,'*');
                }
                else{
                    newPhrase.setCharAt(i,'+');
                }
            }
        }
        return newPhrase.toString();
    }
    public void testEmphasize(){
    
        System.out.println(emphasize("Mary Bella Abracadabra",'a'));
        System.out.println(emphasize("dna ctgaaactga",'a'));
    }
    public String replaceVowels(String phrase, char ch){
       
        StringBuilder replaced = new StringBuilder(phrase);
        
        for(int i = 0; i < replaced.length(); i++){
            char chk = replaced.charAt(i);
           
            if(isVowel(chk) == true){
                replaced.setCharAt(i,ch);
            }
            
        }
        
        return replaced.toString();
    }
    
    public void testReplaceVowels(){
        System.out.println(replaceVowels("Hello Africa",'*'));
    }
    
    
    public boolean isVowel(char ch){
        ch = Character.toLowerCase(ch);
        String vowels = "aeiou";
        
        if(vowels.indexOf(ch) == -1){
            return false;
        }
        else{
            return true;
        }
        
    }
    public void testIsVowel(){
        System.out.println(isVowel('f'));
        System.out.println(isVowel('a'));
    }
}
