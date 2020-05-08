
/**
 * Write a description of Part1 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Part1 {
    public int findStopCodon(String dna, int startIndex, String stopCodon){
        //ATGxxxTAG
        int stopIndex = dna.indexOf(stopCodon,startIndex + 3);
        if(stopIndex != -1 && (stopIndex - startIndex) % 3 == 0){
            return stopIndex;
        }
        return -1;
    }
    
    public String findGene(String dna,int where){
        int startIndex = dna.indexOf("ATG",where);
        if (startIndex == -1){
            return ""; 
        }
        int taaIndex = findStopCodon(dna,startIndex,"TAA");
        int tagIndex = findStopCodon(dna,startIndex,"TAG");
        int tgaIndex = findStopCodon(dna,startIndex,"TGA");
      
       // int minIndex = Math.min(taaIndex,Math.min(tagIndex,tgaIndex));
        int minIndex = 0;
        if(taaIndex == -1 || (tgaIndex != -1 && tgaIndex < taaIndex)){
            minIndex = tgaIndex;
        }
        else{
            minIndex = taaIndex;
        }
        
        if(minIndex == -1 || (tagIndex !=-1 && tagIndex < minIndex)){
            minIndex = tagIndex;
        }
        if(minIndex == -1){
            return "";
        }
        return dna.substring(startIndex,minIndex + 3);
    }
    
     public void printAllGenes(String dna){
        int startIndex = 0;
        
        while(true){
            String currentGene = findGene(dna,startIndex);
            if(currentGene.isEmpty()){
                break;
            }
            System.out.println(currentGene);
            startIndex = dna.indexOf(currentGene,startIndex) + currentGene.length();
        }
    }
    
     public void testprintAllGenes(){
        printAllGenes("AATGCTAACTAGCTGACTAAT");
     }
    
    public void testFindStopCodon(){
        
        String dna = "xxATGxxyyxyTAGaaavvvdfcew";
        System.out.println(findStopCodon(dna,0,"TAG"));
        
        String dna1 = "xxATGxxyyxyaaavvvdfcew";
        System.out.println(findStopCodon(dna1,0,"TAA"));
        
        String dna2 = "xxATGxxyyxyaaavvvdfcewTGAaa";
        System.out.println(findStopCodon(dna2,0,"TGA"));
    }
    
    public void testFindGene(){
        String dna = "xxAAAxxyyxyTAGaaavvvdfcew";
        System.out.println("DNA with no start ATG " + findGene(dna,0));
        
        String dna1 = "xxATGxxyyxyTAGaaavvvdfcew";
        System.out.println("DNA with start codon ATG and with stop Codon TAG " + findGene(dna1,0));
        
        String dna2 = "xxATGxxyyxyTAAaaaTGAxxxTAGaaavvvdfcew";
        System.out.println("DNA with multiple stop codons " + findGene(dna2,0));
        
        String dna3 = "xxATGxxyyxyaaavvvdfcew";
        System.out.println("DNA with no stop codon "+ findGene(dna3,0));
        
        String dna4 = "xxATGxxyxyTAGaaavvvdfcew";
        System.out.println("DNA with no multiple of 3 "+findGene(dna4,0));
    }
}
