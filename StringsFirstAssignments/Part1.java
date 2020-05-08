
/**
 * Write a description of Part1 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Part1 {
    public String findSimpleGene (String dna){
        String result = "";
        int count = 3;
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
        //test case with ATG and TAA
        String first = "ATGCAATTDGTATAACTA";
        String firstResult = findSimpleGene(first);
        //test case no ATG with TAA
        String second = "TGCACCAATDDATAATACTA";
        String secondResult = findSimpleGene(second);
         //test case with ATG no TAA
        String third = "CAATGATGTACTA";
        String thirdResult = findSimpleGene(third);
        // test case no ATG no TAA
        String fourth = "AGGTDDTDTACTA";
        String fourthResult = findSimpleGene(fourth);
        // test case not a multiple of 3
        String fifth = "ATGTAACAATTTAACTA";
        String fifthResult = findSimpleGene(fifth);
        
        
        System.out.println("The Gene for " + first+ " is "+ firstResult);
        System.out.println("The Gene for " + second+ " is "+ secondResult);
        System.out.println("The Gene for " + third+ " is "+ thirdResult);
        System.out.println("The Gene for " + fourth+ " is "+ fourthResult);
        System.out.println("The Gene for " + fifth+ " is "+ fifthResult);
        
    }
}
