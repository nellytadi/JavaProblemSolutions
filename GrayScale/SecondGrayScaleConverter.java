import java.io.File;
import edu.duke.*;

/**
 * Write a description of SecondGrayScaleConverter here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class SecondGrayScaleConverter {
    public ImageResource convertGray(ImageResource inImage){
        ImageResource outImage = new ImageResource(inImage.getWidth(), inImage.getHeight());
        
        for(Pixel pixel : outImage.pixels()){
            Pixel inPixel = inImage.getPixel(pixel.getX(), pixel.getY());
            int average = (inPixel.getBlue() + inPixel.getRed() + inPixel.getGreen())/3;
            
            pixel.setRed(average);
            pixel.setBlue(average);
            pixel.setGreen(average);
        }
       
       return outImage; 
    }
    
    
    public void testConvertGray(){
        DirectoryResource dr = new DirectoryResource();
        
        for (File f : dr.selectedFiles()){
            ImageResource inFile = new ImageResource(f);
            
            ImageResource image = convertGray(inFile);
           
            String filename = inFile.getFileName();
            String newName = "gray-" + filename;
            
            image.setFileName(newName);
            image.draw();
            image.save();
        }
    }
    
   
}
