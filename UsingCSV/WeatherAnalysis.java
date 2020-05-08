import edu.duke.*;
import java.io.File;
import org.apache.commons.csv.*;
/**
 * Write a description of WeatherAnalysis here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class WeatherAnalysis {
    
    public void fileWithColdestTemperature(){
       CSVRecord smallestRecordSoFar = null;
       String smallFileName = "";
       File smallTempFile = null;
       double test = 0;
       DirectoryResource dr = new DirectoryResource();
       for (File f : dr.selectedFiles()) {
           
           FileResource fr = new FileResource(f);
           CSVParser parser = fr.getCSVParser();
           //get record of smallest temperature in this file
           CSVRecord current = coldestHourInFile(parser);
           // get record of smallest temperature in all the files
           if (smallestRecordSoFar == null){
                smallestRecordSoFar = current;
           }
           else{
                double currentTemp = Double.parseDouble(current.get("TemperatureF"));
                double smallestTemp = Double.parseDouble(smallestRecordSoFar.get("TemperatureF"));
             
                if(currentTemp < smallestTemp){
                    smallestRecordSoFar = current;
                    smallFileName = f.getName();
                    smallTempFile = f;
                }  
           }
         
       }
       System.out.println("Coldest day was in " + smallFileName);
       System.out.println("The smallest temperature is " + smallestRecordSoFar.get("TemperatureF"));
       
       System.out.println("All the Temperatures on the coldest day were: ");
       FileResource fr = new FileResource(smallTempFile);
       CSVParser parser = fr.getCSVParser();
       
       for(CSVRecord record : parser){
           System.out.println(record.get("DateUTC")+ " " +record.get("TemperatureF"));
       }
       
    }
    public void testFileWithColdestTemperature(){
        fileWithColdestTemperature();
    }
    
    public CSVRecord coldestHourInFile (CSVParser parser){
        
        CSVRecord smallestRecordSoFar = null;
        
        for(CSVRecord current : parser){
           
            if(Double.parseDouble(current.get("TemperatureF")) == -9999){
                continue;
            }else{
                smallestRecordSoFar = getSmallestOfTwo(current,smallestRecordSoFar);
            }
            
 
        }
        
        return smallestRecordSoFar;
      
    }
   
    public CSVRecord getSmallestOfTwo(CSVRecord current, CSVRecord smallestRecordSoFar){
       
        if (smallestRecordSoFar == null ){
                smallestRecordSoFar = current;
        }
        else{
                double currentTemp = Double.parseDouble(current.get("TemperatureF"));
                double smallestTemp = Double.parseDouble(smallestRecordSoFar.get("TemperatureF"));
             
                if(currentTemp < smallestTemp){
                    smallestRecordSoFar = current;
                }  
            }
            
        return smallestRecordSoFar;
    }
    public double averageTemperatureWithHighHumidityInFile (CSVParser parser, int value){
        
        double sum = 0.0;
        int count = 0;
        
        for(CSVRecord record : parser){
             if (record.get("Humidity") != "NA"){
                 double humidity = Double.parseDouble(record.get("Humidity"));
                 if(humidity >= value){
                     double temperature = Double.parseDouble(record.get("TemperatureF"));
                     sum += temperature;
                     count++;
                 }
             }
         }
        double average = sum / count; 
        return average;
    }
    
    public void testAverageTemperatureWithHighHumidityInFile(){
        FileResource fr = new FileResource();
        CSVParser parser = fr.getCSVParser();
        int value = 80;
        double average = averageTemperatureWithHighHumidityInFile(parser,value);
        Double f1 = new Double(average);
        boolean res = f1.isNaN();
        
        if (res){
            System.out.println("No temperatures with that humidity");
        }
        else{
            System.out.println("Average temperature when high humidity "+value+" is "+ average);
        }
         
        
    }
    
    public double averageTemperatureInFile (CSVParser parser){
        double sum = 0.0;
        int count = 0;
        for(CSVRecord record : parser){
            
             if (record.get("TemperatureF") != " -9999"){
                
                 String current = record.get("TemperatureF");
                 double currentHumidity = Double.parseDouble(current);
                 sum += currentHumidity;
                 
                 
             }
           count ++ ;
        }
        double average = sum / count;
        return average;
    }
    public void testAverageTemperatureInFile(){
        
        FileResource fr = new FileResource();
        CSVParser parser = fr.getCSVParser();
        double average = averageTemperatureInFile(parser);
        
        System.out.println("Average temperature in file is "+ average);
        
    }
    public CSVRecord lowestHumidityInFile(CSVParser parser){
        CSVRecord lowestHumidityRecord = null;
        int count = 0;
        for (CSVRecord current : parser){
                String humidity = current.get("Humidity");
               if( humidity.equals("N/A")){
                   // if (count == 5){
                    continue;
                }
                else{
                    lowestHumidityRecord = findLowestHumidityRecord(current,lowestHumidityRecord);
                  
                }
                count ++;
                
        }
        return lowestHumidityRecord;
    }
    
    public CSVRecord lowestHumidityInManyFiles(){
        DirectoryResource dr = new DirectoryResource();
       
        CSVRecord lowestHumidityRecord = null;
        
        for(File f : dr.selectedFiles()){
            
           FileResource fr = new FileResource(f);
           CSVParser parser = fr.getCSVParser();
           CSVRecord currentRecord = lowestHumidityInFile(parser);
           
           lowestHumidityRecord = findLowestHumidityRecord(currentRecord,lowestHumidityRecord);
        }
        return lowestHumidityRecord;
    }
    public CSVRecord findLowestHumidityRecord(CSVRecord current , CSVRecord lowestHumidityRecord){
        
        if (lowestHumidityRecord == null ){
                lowestHumidityRecord = current;
            }
           
            else{
                
                        
                int currentHumidity = Integer.parseInt(current.get("Humidity"));
                int smallestHumidity = Integer.parseInt(lowestHumidityRecord.get("Humidity"));
             
                if(currentHumidity < smallestHumidity){
                    lowestHumidityRecord = current;
                }
            
            }
            
        return lowestHumidityRecord;
    
    }
    
    public CSVRecord hottestHourInFile(CSVParser parser){
        
        CSVRecord largestRecordSoFar = null;
        
        for(CSVRecord current : parser){
            
            largestRecordSoFar = getLargestOfTwo(current,largestRecordSoFar);
          
        }
        return largestRecordSoFar;
    }
    
    public CSVRecord hottestHourInManyDays(){
        CSVRecord largestRecordSoFar = null;
        DirectoryResource dr = new DirectoryResource();
        
        for (File f : dr.selectedFiles()) {
             FileResource fr = new FileResource(f);
             CSVRecord current = hottestHourInFile(fr.getCSVParser());
             
             largestRecordSoFar = getLargestOfTwo(current,largestRecordSoFar);
             
        }
        
        return largestRecordSoFar;
    }
    public CSVRecord getLargestOfTwo(CSVRecord current,CSVRecord largestRecordSoFar){
        
            if (largestRecordSoFar == null){
                largestRecordSoFar = current;
            }
            else{
                double currentTemp = Double.parseDouble(current.get("TemperatureF"));
                double largestTemp = Double.parseDouble(largestRecordSoFar.get("TemperatureF"));
             
                if(currentTemp > largestTemp){
                    largestRecordSoFar = current;
                }  
            }
            
        return largestRecordSoFar;
    }
    public void testLowestHumidityInFile(){
        
        FileResource fr = new FileResource();
        CSVParser parser = fr.getCSVParser();
        CSVRecord csv = lowestHumidityInFile(parser);
        
        System.out.println("Lowest Humidity was "+csv.get("Humidity")+" at " +  csv.get("DateUTC"));
        
    }
    public void testLowestHumidityInManyFiles(){
        CSVRecord result = lowestHumidityInManyFiles();
        
        System.out.println("Lowest Humidity was "+result.get("Humidity")+" at " +  result.get("DateUTC"));
    }
    public void testHottestInDay(){
        FileResource fr = new FileResource();
        
        CSVRecord cr = hottestHourInFile(fr.getCSVParser());
        
        System.out.println("The highest temperature is "+ cr.get("TemperatureF") +" at "+ cr.get("DateUTC"));
    }
    
    public void testHottestInManyDays(){
        CSVRecord cr = hottestHourInManyDays();
        
        System.out.println("The highest temperature is "+ cr.get("TemperatureF") +" at "+ cr.get("DateUTC"));
    }
    
    public void testColdestHourInFile(){
        FileResource fr = new FileResource();
        CSVParser parser = fr.getCSVParser();
        CSVRecord result = coldestHourInFile(parser);
        
        
       
        System.out.println("The coldest hour is "+ result.get("TemperatureF"));
        
        
    }
}
