
/**
 * Write a description of Part3 here.
 * 
 * @author nelly
 * @version (a version number or a date)
 */
public class Part3 {
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
    
    public int countGenes(String dna){
        int startIndex = 0;
        int count = 0;
        while(true){
            String currentGene = findGene(dna,startIndex);
            if(currentGene.isEmpty()){
                break;
            }
            count++;
            startIndex = dna.indexOf(currentGene,startIndex) + currentGene.length();
        }
        
        return count;
    }
    
    public void testCountGenes(){
        int count = countGenes("ATGTAAGATGCCCTAGT") ;
        System.out.println(count);
    }
}
