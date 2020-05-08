import edu.duke.*;
import java.io.File;

/**
 * Write a description of GrayScaleConverter here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class GrayScaleConverter {
    public ImageResource makeGray(ImageResource inImage){
        //create a blank image of the same size as the inImage
        ImageResource outImage = new ImageResource(inImage.getWidth(), inImage.getHeight());
        
        for(Pixel pixel : outImage.pixels()){
                //look at corresponding pixel in inImage
            Pixel inPixel = inImage.getPixel(pixel.getX(), pixel.getY()); 
            //compute pixels and find average
            int average = (inPixel.getRed() + inPixel.getBlue() + inPixel.getGreen()) / 3;
            // set all to average
            pixel.setRed(average);
            pixel.setBlue(average);
            pixel.setGreen(average);
        }
        return outImage;
    }
    
    public void testMakeGray(){
       ImageResource ir = new ImageResource();
       
       ImageResource gray = makeGray(ir);
       
       gray.draw();
    }
    
    public void selectAndConvert(){
        DirectoryResource dr = new DirectoryResource();
        
        for (File f : dr.selectedFiles()){
            ImageResource inFile = new ImageResource(f);
            ImageResource gray = makeGray(inFile);
            gray.draw();
        }
    }
}
