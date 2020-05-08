
/**
 * Write a description of Part2 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Part2 {
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
    
    public int countCTG(String dna){
        return 0;
    }
    public void testCgRatio(){
        float ratio = cgRatio("ATGCCATAG");
        System.out.println(ratio);
    }
}
