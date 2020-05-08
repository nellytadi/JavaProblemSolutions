import edu.duke.*;
import java.io.File;

public class PerimeterAssignmentRunner {
    
    public double getPerimeter (Shape s) {
        // Start with totalPerim = 0
        double totalPerim = 0.0;
        // Start wth prevPt = the last point 
        Point prevPt = s.getLastPoint();
        // For each point currPt in the shape,
        for (Point currPt : s.getPoints()) {
            // Find distance from prevPt point to currPt 
            double currDist = prevPt.distance(currPt);
            // Update totalPerim by currDist
            totalPerim = totalPerim + currDist;
            // Update prevPt to be currPt
            prevPt = currPt;
        }
        // totalPerim is the answer
        return totalPerim;
   
    }

    public int getNumPoints (Shape s) {
        // Put code here
        int count = 0;
         for (Point currPt : s.getPoints()) {
            count ++;
        }
        return count;
    }

    public double getAverageLength(Shape s) {
        // Put code here
        
        double average;
      
        Point prevPt = s.getLastPoint();
        average = getPerimeter(s) / getNumPoints(s);
        return average;
        
        
    }

    public double getLargestSide(Shape s) {
        // Put code here
        
        Point prevPt = s.getLastPoint();
        double prevDist = 0;
        double largest = 0;
        for (Point currPt: s.getPoints()) {
         
            double currDist = prevPt.distance(currPt);
            
            if (currDist > prevDist){
             
                largest = currDist;
                prevDist = prevPt.distance(currPt);
            }
           
            prevPt = currPt;
            
        }
        return largest;
    }

    public double getLargestX(Shape s) {
        // Put code here
        //Point prevPt = s.getX();
        double largeX = 0;
        double prevPoint = 0;
        
        for (Point currPt: s.getPoints()) {
         
            double currXPoint = currPt.getX();
            
            if (currXPoint > prevPoint){
             largeX = currXPoint;
            }
            prevPoint = currXPoint;
            
        }
        return largeX;
    }

    public double getLargestPerimeterMultipleFiles() {
        DirectoryResource dr = new DirectoryResource();
        double oldPerimeter = 0;
        double largePerim = 0;
        for (File f : dr.selectedFiles()) {
            FileResource fl = new FileResource(f);
            Shape s = new Shape(fl);
            double newPerimeter = getPerimeter(s);
            if (newPerimeter > oldPerimeter){
                largePerim = newPerimeter;
            }
            oldPerimeter = newPerimeter;    
            
        }
        
        return largePerim;
      
    }

     public String getFileWithLargestPerimeter() {
        // Put code here
        DirectoryResource dr = new DirectoryResource();
        double oldPerimeter = 0;
        String filename = null;
        for (File f : dr.selectedFiles()) {
            FileResource fl = new FileResource(f);
            Shape s = new Shape(fl);
            double newPerimeter = getPerimeter(s);
            if (newPerimeter > oldPerimeter){
              filename = f.getName();
            }
            oldPerimeter = newPerimeter;    
           
        }
        
      return filename;
      
    }

    public void testPerimeter () {
        FileResource fr = new FileResource();
        Shape s = new Shape(fr);
        double totalPerim = getPerimeter(s);
        System.out.println("perimeter = " + totalPerim);
        
        int count = getNumPoints(s);
        System.out.println("There are " + count + " points" );
        
        double averageLength = getAverageLength(s);
        System.out.println("The average length is " + averageLength);     
        
        double largest = getLargestSide(s);
        System.out.println("The largest side is " + largest);  
        double largesX = getLargestX(s);
        System.out.println("The largest x value is " + largesX);  
    }
    
    public void testPerimeterMultipleFiles() {
        // Put code here
        double largePerim = getLargestPerimeterMultipleFiles();
        System.out.println("The largest perimeter is " + largePerim);
    }

    public void testFileWithLargestPerimeter() {
        // Put code here
        String largeFile = getFileWithLargestPerimeter();
        System.out.println("The file with largest perimeter is " + largeFile);
    }

    // This method creates a triangle that you can use to test your other methods
    public void triangle(){
        Shape triangle = new Shape();
        triangle.addPoint(new Point(0,0));
        triangle.addPoint(new Point(6,0));
        triangle.addPoint(new Point(3,6));
        for (Point p : triangle.getPoints()){
            System.out.println(p);
        }
        double peri = getPerimeter(triangle);
        System.out.println("perimeter = "+peri);
        
 
    }

    // This method prints names of all files in a chosen folder that you can use to test your other methods
    public void printFileNames() {
        DirectoryResource dr = new DirectoryResource();
      
        for (File f : dr.selectedFiles()) {
            FileResource fl = new FileResource(f);
            System.out.println(f);
        }
        
        
        
        
        
    }

    public static void main (String[] args) {
        PerimeterAssignmentRunner pr = new PerimeterAssignmentRunner();
        pr.testPerimeter();
    }
}
