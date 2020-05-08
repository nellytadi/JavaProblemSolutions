
/**
 * Write a description of Part3 here.
 * 
 * @author (Nelly Tadi) 
 * @version (a version number or a date)
 */
public class Part3 {
    //stringb is main string
    //stringa is string to check for
    public String twoOccurrences (String stringb, String stringa){
        int length = stringa.length();
        int firstChk = stringb.indexOf(stringa);
        if(firstChk != -1){
            int secondChk = stringb.indexOf(stringa,firstChk + length);
            if (secondChk != -1){
                return "true";
            }
            return "false";
        }
        return "false";
    }
    //stringb is main string
    //stringa is string to check for
    public String lastPart(String stringb, String stringa){
        int length = stringb.length();
        int firstChk = stringb.indexOf(stringa);
        if (firstChk != -1){
         String finalResult = stringb.substring(firstChk,length);
         return finalResult;   
        }
        else{
            return stringb;
        }
        
    } 
    public void testing(){
        String firstChk = twoOccurrences("This method returns true if stringa appears at least twice in stringb","stringb");
        String secondChk = twoOccurrences("A story by Abby Long","by");
        String thirdChk = lastPart("A story by Abby Long","by");
        String fourthChk = lastPart("Forest","zoo");
        System.out.println(firstChk);
        System.out.println(secondChk);
        System.out.println(thirdChk);
        System.out.println(fourthChk);
    }
}
