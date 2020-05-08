
/**
 * Write a description of Part2 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Part2 {
    public int howMany(String stringa,String stringb){
        int len = stringb.length();
        int firstTime = stringa.indexOf(stringb);
        int count = 1;
        while (firstTime != -1){
            int next = stringa.indexOf(stringb,firstTime + len);
            if(next == -1){
                 break;  
            }
            else{
               firstTime = next;
                count++;
            }
        }
        
        return count;
    }
    public void testHowMany(){
         
          int count = howMany("aaaaaaa","aa");
          System.out.println(count);
          
          int count1 = howMany("ATGAACGAATTGAATC","GAA");
          System.out.println(count1);
          
        
          
          
    }
}
