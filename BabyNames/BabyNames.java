import edu.duke.*;
import java.io.File;
import org.apache.commons.csv.*;
/**
 * Write a description of BabyNames here.
 * 
 * @author (your name) x
 * @version (a version number or a date)
 */
public class BabyNames {
    public void totalNames(){
     FileResource fr = new FileResource();
        CSVParser parser = fr.getCSVParser(false);
        int totalBoys = 0;
        int totalGirls = 0;
        for (CSVRecord record : parser){
            String gender = record.get(1);
            
            if(gender.equals("M")){
                totalBoys ++;
            }
            else if(gender.equals("F")){
                totalGirls ++;
            }
        }
        
        System.out.println("Total number of boy names is "+ totalBoys);
        System.out.println("Total number of girl names is "+ totalGirls);
    
    }
    public void totalBirths(){
        FileResource fr = new FileResource();
        CSVParser parser = fr.getCSVParser(false);
        int totalBoys = 0;
        int totalGirls = 0;
        for (CSVRecord record : parser){
            String gender = record.get(1);
            int total = Integer.parseInt(record.get(2));
            if(gender.equals("M")){
                totalBoys += total;
            }
            else if(gender.equals("F")){
                totalGirls += total;
            }
        }
        
        System.out.println("Total number of boys is "+ totalBoys);
        System.out.println("Total number of girls is "+ totalGirls);
    }
    
    public int getRank(CSVParser parser, int year, String name, String gender){
       
        int rank = 0;
        for (CSVRecord record : parser){
            if(record.get(1).equals(gender)){
               
                rank++;
                
                if(record.get(0).equals(name)){
                    return rank;
                }
            }
        }
        
        return -1;
        //return 3;
    }
    
    
    public String getName(int year, int rank, String gender){
        FileResource fr = new FileResource();
        CSVParser parser = fr.getCSVParser(false);
        int count = 0;
        for (CSVRecord record : parser){
            if(record.get(1).equals(gender)){
                count++;
                if(count == rank){
                    return record.get(0);
                }
            }
        }
        
        return "No name";
     
    }
    
    public double getAverageRank(String name, String gender){
        DirectoryResource dr = new DirectoryResource();
        double sum = 0;
        int count = 0;
        
        for(File f : dr.selectedFiles()){
            
            FileResource fr = new FileResource(f);
            CSVParser parser = fr.getCSVParser(false);
            String filename = f.getName();
            int year = Integer.parseInt(filename.substring(3,7));
            int rank = getRank(parser,year,name,gender);
            
            if (rank != -1){
                sum += rank;
                count++;
            }
        }
        
        double average = sum / count;
        return average; 
    }
    
    public int getTotalBirthsRankedHigher(int year, String name, String gender){
         
        FileResource fr = new FileResource("us_babynames/us_babynames_by_year/yob"+year+".csv");
        
        CSVParser parser = fr.getCSVParser(false);
        int rank = getRank(parser,year,name,gender);
        
        CSVParser parser1 = fr.getCSVParser(false);
        
        int totalBirth = 0;
        int tempRank = 1;
        
        for (CSVRecord record : parser1){
           
            if(record.get(1).equals(gender)){
                
                
               if(tempRank < rank){
                   
                   totalBirth += Integer.parseInt(record.get(2));
                   tempRank++;
                   
               }
               
            }
        
        }
        
        return totalBirth;
    }
    public void testGetTotalBirthsRankedHigher(){
        String name = "Emily";
        String gender = "F";
        int year = 1990;
        int totalBirth = getTotalBirthsRankedHigher(year,name,gender);
        System.out.println("Total births ranked higher than " + name + " is "+ totalBirth);
    }
    public void yearOfHighestRank(String name, String gender){
        DirectoryResource dr = new DirectoryResource();
        int rank = 0;
        int mainYear = 0;
        for(File f : dr.selectedFiles()){
            
            FileResource fr = new FileResource(f);
            CSVParser parser = fr.getCSVParser(false);
            
            String filename = f.getName();
            int year = Integer.parseInt(filename.substring(3,7));
            
            int returnRank = getRank(parser,year,name,gender);
            if (rank == 0 && returnRank != -1){
                rank = returnRank;
                mainYear = year;
            }
            else {
                if (rank > returnRank && returnRank != -1){
                    rank = returnRank;
                    mainYear = year;
                }
            }
        }
        
        System.out.println(name + " was most popular in " + mainYear);
    }
    
    
    
    public void whatIsNameInYear(String name, int year, int newyear, String gender){
        FileResource fr = new FileResource("us_babynames/us_babynames_by_year/yob"+year+".csv");
        CSVParser parser = fr.getCSVParser(false);
        int rank = getRank(parser,year,name,gender);
        
        FileResource fr2 = new FileResource("us_babynames/us_babynames_by_year/yob"+newyear+".csv");
        CSVParser parser2 = fr2.getCSVParser(false);
        int count = 0;
        CSVRecord main = null;
        
        for(CSVRecord record : parser2){
          
            if(record.get(1).equals(gender)){
                count++;
                if(count == rank){
                    main = record;
                    break;
                }
            }
        }
        
        System.out.println(name + " born in " + year + " would be " + main.get(0) + " if she was born in 2014.");
        
    }
    
    public void testGetAverageRank(){
        String name = "Susan";
        String gender = "F";
        double rank = getAverageRank(name, gender);
        System.out.println(rank);
    }
    
    
    public void testYearOfHighestRank(){
       // yearOfHighestRank("Genevieve","F");
        yearOfHighestRank("Mich","M");
    }
    
    public void testWhatIsNameInYear(){
        whatIsNameInYear("Susan",1972,2014,"F");
    }
    public void testGetRank(){
        FileResource fr = new FileResource();
        CSVParser parser = fr.getCSVParser(false);
        
        int value = getRank(parser,1960,"Emily","F");
        System.out.println(value);
        
    }
    
    public void testGetName(){
       String name = getName(1980,350,"F");
       System.out.println("3rd Male Name is : " + name);
    }
}
