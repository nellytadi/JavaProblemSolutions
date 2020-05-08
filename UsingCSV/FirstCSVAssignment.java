import edu.duke.*;
import org.apache.commons.csv.*;
/**
 * Write a description of FirstCSVAssignment here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class FirstCSVAssignment {
    
    public void countryInfo(CSVParser parser, String country){
        int count = 0;
        for (CSVRecord record : parser){
            
            String name = record.get("Country");
            if(name.equals(country)){
                String export = record.get("Exports");
                String amount = record.get("Value (dollars)");
                
                System.out.println(name + " : " + export + " : " + amount);
                count++;
            }
            
            
        }
        if (count == 0){
            System.out.println("NOT FOUND !");
        }
        
    }
    
    public void listExportersTwoProducts(CSVParser parser,String exportItem1,String exportItem2){
        int count = 0;
        for (CSVRecord record : parser){
            
            
            String export = record.get("Exports");
           
            
            if (export.contains(exportItem1) && export.contains(exportItem2)){
                String name = record.get("Country");
                System.out.println(name +" exports "+exportItem1 + " and " + exportItem2);
                count++;
            }
           
        }
        if (count == 0){
            System.out.println("NOT FOUND !");
        }
    }
    
    public void numberOfExporters(CSVParser parser, String exportItem){
    int count = 0;
        for (CSVRecord record : parser){
            
            
            String export = record.get("Exports");
           
            
            if (export.contains(exportItem)){
                
                count++;
            }
           
        }
        if (count == 0){
            System.out.println("NOT FOUND !");
        }else{
             System.out.println(count + " countries export " + exportItem );
        }
    }
    
    public void bigExporters (CSVParser parser, String amount){
        
        int count = 0;
        for (CSVRecord record : parser){
            
            String name = record.get("Country");
            String rec_amount = record.get("Value (dollars)");
                
            if(rec_amount.length() > amount.length()){
               
                System.out.println(name + " " + rec_amount);
                count++;
            }
            
            
        }
        if (count == 0){
            System.out.println("NOT FOUND !");
        }
        
    }
    
    public void tester(){
        FileResource fr = new FileResource();
        CSVParser parser = fr.getCSVParser();
        
        //countryInfo(parser, "Germany");
        //countryInfo(parser, "Nauru");
        
        //CSVParser parser1 = fr.getCSVParser();
        //listExportersTwoProducts(parser1,"gold","diamonds");
        //listExportersTwoProducts(parser1,"cotton","flowers");
        
        //CSVParser parser2 = fr.getCSVParser();
        //numberOfExporters(parser2,"cocoa");
        
        CSVParser parser3 = fr.getCSVParser();
        bigExporters(parser3,"$999,999,999,999");
    }
}
