
/**
 * Write a description of Part2 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Part2 {
public String findSimpleGene (String dna,String startCodon,String endCodon){
        String result = "";
        int count = 3;
       // dna = dna.toLowerCase();
        //startCodon = startCodon.toLowerCase();
        //endCodon = endCodon.toLowerCase();
        int start = dna.indexOf("ATG");
        if(start == -1){
            return result;
        }
        int end = dna.indexOf("TAA",start + count);
        if(end == -1){
            return result;
        }
        result = dna.substring(start,end + count);
        int length = result.length();
        if (length % 3 == 0){
           return result;
        }
        else{
            return "";
        }
    }
    
    
    public void testSimpleGene(){
        String startCodon = "ATG";
        String endCodon = "TAA";
        //test case with ATG and TAA
        String first = "AAATGCCCTAACTAGATTAAGAAACC";
        String firstResult = findSimpleGene(first,startCodon,endCodon);
        //test case no ATG with TAA
        String second = "gatgctataat";
        String secondResult = findSimpleGene(second,startCodon,endCodon);
         //test case with ATG no TAA
        String third = "ATGGGTTAAGTC";
        String thirdResult = findSimpleGene(third,startCodon,endCodon);
        // test case no ATG no TAA
        String fourth = "AGGTDDTDTACTA";
        String fourthResult = findSimpleGene(fourth,startCodon,endCodon);
        // test case not a multiple of 3
        String fifth = "ATGTAACAATTTAACTA";
        String fifthResult = findSimpleGene(fifth,startCodon,endCodon);
        
        
        System.out.println("The Gene for " + first+ " is "+ firstResult);
        System.out.println("The Gene for " + second+ " is "+ secondResult.toUpperCase());
        System.out.println("The Gene for " + third+ " is "+ thirdResult.toUpperCase());
        System.out.println("The Gene for " + fourth+ " is "+ fourthResult.toUpperCase());
        System.out.println("The Gene for " + fifth+ " is "+ fifthResult);
        
        if("hello" == "HELLO"){
        
        System.out.println("true");
        }
        else{
        System.out.println("false");
        }
    }
}
