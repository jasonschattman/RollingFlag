import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import static java.awt.image.BufferedImage.TYPE_INT_ARGB;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JPanel;


public class Animator implements Runnable {
    Thread runner;
    JPanel drawingPanel;
    int numRows;
    int numColumns;
    double deltaCx;
    double deltaCy;
    double radiusToSpacingRatio;
    double squareSizeToSpacingRatio;
    Particle[][] particles;
    int time;
    int delayBetweenFrames = 20; //in milliseconds
        
    
    public Animator( JPanel jp, int nr, int nc, double dcx, double dcy, double rad, double sqr, int timeToStart, boolean recalculate)  {
        this.drawingPanel = jp;
        this.numRows = nr;
        this.numColumns = nc;
        this.deltaCx = dcx;
        this.deltaCy = dcy;
        this.radiusToSpacingRatio = rad;
        this.squareSizeToSpacingRatio = sqr;
        this.time = timeToStart;
        
        if (recalculate==true)
            recalculateValues();
    }
    
        
    public void recalculateValues() {      
       double xCentre, yCentre, phaseShift;
       
       particles = new Particle[numRows][numColumns];
       
       double xSpacing = (drawingPanel.getWidth()-200)/numColumns;
       double ySpacing = (drawingPanel.getHeight()-200)/numRows;
       double spacing = Math.min( xSpacing, ySpacing );
        
       Particle.r = spacing * radiusToSpacingRatio;
       Particle.size = (int) Math.max(2, spacing * squareSizeToSpacingRatio);
       Particle.numPoints = (int) (2*Math.PI/Particle.b);
       
       for (int i = 0; i < numRows; i++) {
            phaseShift = deltaCy * i;            
            yCentre = 100 + i*spacing;
                                   
            for (int j = 0; j < numColumns; j++) {
                xCentre = 100 + j*spacing;                
                particles[i][j] = new Particle( xCentre, yCentre, phaseShift );
                phaseShift += deltaCx;               
            }            
        }        
    }
    
    
    public void sleep( int numMilliseconds ) {
        try {
            Thread.sleep( numMilliseconds );
        }         
        catch (Exception e) {
        }
    }
    
    
    public void drawScreen() {
        Image img = createScreenImage();
        Graphics g = drawingPanel.getGraphics();
        g.drawImage(img, 0, 0 , drawingPanel);
    }
    
    
    public Image createScreenImage() {
        BufferedImage bi = new BufferedImage(1200,1200,BufferedImage.TYPE_INT_RGB);       
        Graphics2D g = (Graphics2D) bi.getGraphics();
    
        double x, y;
        g.setColor(Color.black);
        g.fillRect(0,0,1200,1000);
        g.setColor(Color.yellow);
        for (int i = 0; i < numRows; i++) 
            for (int j = 0; j < numColumns; j++) {
                Particle p = particles[i][j];
                x = p.xyHistory[time%Particle.numPoints][0];
                y = p.xyHistory[time%Particle.numPoints][1];
                g.fillRect((int)x, (int)y, Particle.size, Particle.size);            
            }        
                    
        return bi;
    }
    
    
    public void run() {        
        while( Thread.currentThread() == runner ) {           
            drawScreen();
            sleep(delayBetweenFrames);            
            time = time + 1;             
        }
    } 
}
