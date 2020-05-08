import java.io.File;
import edu.duke.*;
/**
 * Write a description of BatchInversions here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class BatchInversions {
    public ImageResource makeInversions(ImageResource inImage){
        ImageResource outImage = new ImageResource(inImage.getWidth(), inImage.getHeight());
        
        for(Pixel pixel : outImage.pixels()){
            Pixel inPixel = inImage.getPixel(pixel.getX(), pixel.getY());
            
            int blue = 255 - inPixel.getBlue();
            int red = 255 - inPixel.getRed();
            int green = 255 - inPixel.getGreen();
           
            pixel.setRed(red);
            pixel.setBlue(blue);
            pixel.setGreen(green);
        }
       
       return outImage;
    }
    
    public void selectAndConvert(){
         DirectoryResource dr = new DirectoryResource();
            
            for (File f : dr.selectedFiles()){
                ImageResource inFile = new ImageResource(f);
                
                ImageResource image = makeInversions(inFile);
               
                String filename = inFile.getFileName();
                String newName = "inverted-" + filename;
                
                image.setFileName(newName);
                image.draw();
                image.save();
            }
    }
}
