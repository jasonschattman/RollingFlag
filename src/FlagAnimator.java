
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JPanel;


public class FlagAnimator extends Animator {
    String imageFile;
    BufferedImage flagImage;
    
    public FlagAnimator(JPanel jp, int nr, int nc, double dcx, double dcy, double rad, double sqr, int timeToStart, String imageFile) {
        super(jp, nr, nc, dcx, dcy, rad, sqr, timeToStart, false);
        this.imageFile = imageFile;        
        readImage();
        recalculateValues();
    }
    
    public void readImage() {
        try {
            File f = new File(imageFile);
            flagImage = ImageIO.read(f);          
        }
        catch( IOException e) {            
        }        
    }
    
    public void recalculateValues() {
       Color particleColour;
       int rgb;
       double xCentre, yCentre, phaseShift, xFlag, yFlag;
       
       double alpha = (double)((drawingPanel.getWidth()-200))/flagImage.getWidth();
       //double beta = (double)((drawingPanel.getHeight()-200))/flagImage.getHeight();
       
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
            yFlag = (yCentre-100)/alpha;
                        
            for (int j = 0; j < numColumns; j++) {
                xCentre = 100 + j*spacing;
                xFlag = (xCentre-100)/alpha;
                
                rgb = flagImage.getRGB((int)xFlag, (int)yFlag);                
                particleColour = new Color(rgb); 
                
                particles[i][j] = new Particle( xCentre, yCentre, phaseShift, particleColour );
                
                phaseShift += deltaCx;               
            }            
        }        
    } 
    
    public Image createScreenImage() {
       BufferedImage bi = new BufferedImage(1200,1200,BufferedImage.TYPE_INT_RGB);       
       Graphics2D g = (Graphics2D) bi.getGraphics();
       double x, y;
       g.setColor(Color.black);
       g.fillRect(0,0,1200,1200);
        
        for (int i = 0; i < numRows; i++) 
            for (int j = 0; j < numColumns; j++) {  
                Particle p = particles[i][j];
                x = p.xyHistory[time%Particle.numPoints][0];
                y = p.xyHistory[time%Particle.numPoints][1];
                g.setColor(p.color);
                g.fillRect((int)x, (int)y, Particle.size, Particle.size);    
           }
                    
        return bi;
    }
}
