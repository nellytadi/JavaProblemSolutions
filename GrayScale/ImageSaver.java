import edu.duke.*;
import java.io.File;

/**
 * Write a description of ImageSaver here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ImageSaver {
    public void doSave(){
        DirectoryResource dr = new DirectoryResource();
        for(File f : dr.selectedFiles()){
            ImageResource image = new ImageResource(f);
            String filename = image.getFileName();
            String newName = "copy-" + filename;
            image.setFileName(newName);
            image.draw();
            image.save();
        }
    }
}
