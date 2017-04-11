
import java.awt.Color;

public class Particle {
    double x, y, xCentre, yCentre, phaseShift;
    double[][] xyHistory;
    Color color;
     
    static int numPoints, size;
    static double deltaT, r, b;
   
    
    public Particle( double xC, double yC, double ps, Color c) { //used for flag animation
           
        this.xCentre=xC;
        this.yCentre=yC;
        this.phaseShift=ps;
        this.color=c;
        
        calculateHistory();    
    }
    
    public Particle( double xC, double yC, double ps ) { //used for normal, non-flag animations
        
        this.phaseShift=ps;        
        this.xCentre=xC;
        this.yCentre=yC;
        this.color = Color.yellow;
        
        calculateHistory();       
    }
    
    
    public void calculateHistory(){
        
        xyHistory = new double[numPoints][2];
        double angle;
        
        for (int t = 0; t < numPoints; t++) {
            angle = b*(t-phaseShift);
            xyHistory[t][0] = xCentre + r*Math.cos(angle);
            xyHistory[t][1] = yCentre - r*Math.sin(angle);            
        }
    }
}
