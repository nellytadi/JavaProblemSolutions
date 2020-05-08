import java.util.Random;
/**
 * Write a description of RandomSimulation here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class RandomSimulation {
    public void simulate(int rolls){
        Random rand = new Random();
        
        int [] counts = new int [13];
        
        for( int k = 0;k < rolls; k++){
            int dice1 = rand.nextInt(6) + 1;
            int dice2 = rand.nextInt(6) + 1;
            System.out.println("roll is " + dice1 + "+" + dice2);
            counts[dice1 + dice2] += 1  ;
        
        }
        for(int i = 2; i < counts.length ; i++){
            System.out.println("sum of two dice rolled is "+ i + " is gotten " + counts[i] + " times \t" + (100.0 * counts[i]) / rolls);
        }
        
        
    }
    public void simpleSimulate(int rolls){
        Random rand = new Random();
        int two =0;
        int twelve = 0;
        for( int k = 0;k < rolls; k++){
            int dice1 = rand.nextInt(6) + 1;
            int dice2 = rand.nextInt(6) + 1;
            
            if(dice1 + dice2 == 2){
                two += 1;
            }
            if(dice1 + dice2 == 12){
                twelve +=1;
            }
        
        }
        System.out.println("2's are gotten " + two + "times");
        
        System.out.println("12's are gotten " + twelve + "times");
    }
}
