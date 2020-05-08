import edu.duke.*;
/**
 * Write a description of Part3 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Part3 {
    public void processGenes(StorageResource sr){
        int countLong =0;
        int countHigh = 0;
        int length = 0;
        
      for (String gene : sr.data()){
         
            if(gene.length() > 60){
                countLong++;
                System.out.println("Strings in sr that are longer than 60 characters: " + gene);
            }
            if(cgRatio(gene) > 0.35){
                countHigh++;
                System.out.println("Strings in sr whose C-G-ratio is higher than 0.35: " + gene);
            }
            if(gene.length() > length){
                length = gene.length();
            }
      }
      System.out.println("Number of Strings in sr that are longer than 60 characters: " + countLong);
      System.out.println("Number of strings in sr whose C-G-ratio is higher than 0.35: " + countHigh);
    }
    public void testProcessGenes(){
        //StorageResource sr = new StorageResource();
        //sr.add("ATGCCCGGGCGCTTTTAG");
        //sr.add("ATGCGCTAG");
        //sr.add("ATGTCG");
        //sr.add("ATGCCATAG");
        //sr.add("ATGTACATAG");
        
        FileResource fr = new FileResource("brca1line.fa");
        String dna = fr.asString();
        
        StorageResource sr = new StorageResource();
        sr.add(dna);
        
        processGenes(sr);
    }
    public float cgRatio(String dna){
        
        int c = dna.indexOf("C");
        int g = dna.indexOf("G");
        int countc = 0;
        int countg = 0;
       
            while(true){
                if(c == -1){
                    break;
                }
                countc++;
                c = dna.indexOf("C",c + 1);
                
            }
        
            while(true){
                if(g == -1){
                    break;
                }
                countg++;
                g = dna.indexOf("G",g + 1);
                
            }
        
        float result = countc + countg;
        result = result / dna.length();
        return result;
    }
}
