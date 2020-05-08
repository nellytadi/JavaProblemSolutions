import edu.duke.*;
/**
 * Write a description of Part4 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Part4 {
    public void getWebLinks(String url){
       
        URLResource ur = new URLResource(url);
        //StorageResource result = new StorageResource();
        String str = "";
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
            str =   page.substring(firstCm+1,lastCm);
            System.out.println(str);
            //result.add(str);
           }
          
    }
        
       
     
        
        //return result;
    }
    public void testWebLinks(){
        getWebLinks("http://www.dukelearntoprogram.com/course2/data/manylinks.html");
        //System.out.println(result);
    }
}
