import edu.duke.*;
// Package where you can access the CSVParser class
import org.apache.commons.csv.*;
/**
 * Write a description of CountriesExport here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class CountriesExport {
    public void listExporters(CSVParser parser, String exportOfInterest){
        for (CSVRecord record : parser){
            String export = record.get("Exports");
            if(export.contains(exportOfInterest)){
                String country = record.get("Country");
                System.out.println(country);
            }
        }
        
    }
    
    public void testListExporters(){
        FileResource fr = new FileResource();
        CSVParser parser = fr.getCSVParser();
        
        listExporters(parser, "coffee");
    }
}
