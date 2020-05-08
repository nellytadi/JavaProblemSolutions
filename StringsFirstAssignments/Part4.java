import edu.duke.*;
import java.io.File;
/**
 * Write a description of Part4 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Part4 {
    public String getWebLinks(String url){
        URLResource ur = new URLResource(url);
        String result = "";
     
    for (String page : ur.words()) {
           String pageLower = page.toLowerCase();
            //find "youtube.com"
           int firstChk = pageLower.indexOf("youtube.com");
           if (firstChk != -1) {
               
           
                   //find index of " before it 
            int firstCm = page.lastIndexOf("\"",firstChk);
            //find index of " after it
            int lastCm = page.indexOf("\"",firstChk);
            //return string between them
            result =   page.substring(firstCm+1,lastCm);
        
           }
          
    }
        
       
     
        
        return result;
    }
    public void testWebLinks(){
        String result = getWebLinks("http://www.dukelearntoprogram.com/course2/data/manylinks.html");
        System.out.println(result);
    }
}
