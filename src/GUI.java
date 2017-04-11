
import java.io.IOException;


public class GUI extends javax.swing.JFrame {
    Animator rollingSurfaceAnimator;
    String mode;
    
    public GUI() {
        initComponents();
        this.mode = "normal";
        restartAnimation(0);
    }
    
    public void reset()  {
        rollingSurfaceAnimator.runner = null;
        int timeWhereWeLeftOff = rollingSurfaceAnimator.time;
        restartAnimation( timeWhereWeLeftOff );
    }
    
    public void resetRowsToFlagScale() {
        int numColumns = this.columnsSlider.getValue();
        
        if (numColumns%2==1) {
            numColumns++;
            this.columnsSlider.setValue(numColumns);
        }
 
        int numRowsRescaled = numColumns/2;        
        this.rowsSlider.setValue(numRowsRescaled);
    }

    public void restartAnimation( int timeStart )  {
        int numRows = this.rowsSlider.getValue();;
        int numColumns = this.columnsSlider.getValue();
        double deltaCx = (double) (this.deltaCxSlider.getValue()) / 100.0;
        double deltaCy = (double) (this.deltaCySlider.getValue()) / 100.0;
        Particle.b = (double) (this.frequencySlider.getValue()) / 1000.0;
        double radiusRatio = (double) (this.radiusSlider.getValue()) / 100.0;
        double sizeRatio = (double) (this.sizeSlider.getValue()) / 100.0;
        
        if (mode.equals("normal")) {
            //numRows = 
            rollingSurfaceAnimator = new Animator( drawingPanel, numRows, numColumns, deltaCx, deltaCy, radiusRatio, sizeRatio, timeStart, true );                
        }
        
        else if (mode.equals("flag")) {        
            //numRows = this.rowsSlider.getValue();
            rollingSurfaceAnimator = new FlagAnimator( drawingPanel, numRows, numColumns, deltaCx, deltaCy, radiusRatio, sizeRatio, timeStart, "Canadian flag.png" );                     
        }
        rollingSurfaceAnimator.runner = new Thread( rollingSurfaceAnimator );
        rollingSurfaceAnimator.runner.start();        
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        drawingPanel = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        columnsSlider = new javax.swing.JSlider();
        jLabel2 = new javax.swing.JLabel();
        rowsSlider = new javax.swing.JSlider();
        jLabel3 = new javax.swing.JLabel();
        deltaCxSlider = new javax.swing.JSlider();
        jLabel4 = new javax.swing.JLabel();
        deltaCySlider = new javax.swing.JSlider();
        jLabel5 = new javax.swing.JLabel();
        frequencySlider = new javax.swing.JSlider();
        jLabel6 = new javax.swing.JLabel();
        radiusSlider = new javax.swing.JSlider();
        jLabel7 = new javax.swing.JLabel();
        sizeSlider = new javax.swing.JSlider();
        modeButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        drawingPanel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        drawingPanel.setPreferredSize(new java.awt.Dimension(1050, 950));

        javax.swing.GroupLayout drawingPanelLayout = new javax.swing.GroupLayout(drawingPanel);
        drawingPanel.setLayout(drawingPanelLayout);
        drawingPanelLayout.setHorizontalGroup(
            drawingPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1048, Short.MAX_VALUE)
        );
        drawingPanelLayout.setVerticalGroup(
            drawingPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 948, Short.MAX_VALUE)
        );

        jLabel1.setText("Number of rows");

        columnsSlider.setMajorTickSpacing(10);
        columnsSlider.setMinorTickSpacing(5);
        columnsSlider.setPaintLabels(true);
        columnsSlider.setPaintTicks(true);
        columnsSlider.setValue(80);
        columnsSlider.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                columnsSliderChanged(evt);
            }
        });

        jLabel2.setText("Number of columns");

        rowsSlider.setMajorTickSpacing(10);
        rowsSlider.setMinorTickSpacing(5);
        rowsSlider.setPaintLabels(true);
        rowsSlider.setPaintTicks(true);
        rowsSlider.setValue(40);
        rowsSlider.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                rowSliderChanged(evt);
            }
        });

        jLabel3.setText("Horizontal phase shift per particle");

        deltaCxSlider.setMaximum(1000);
        deltaCxSlider.setValue(0);
        deltaCxSlider.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                deltaCxSliderChanged(evt);
            }
        });

        jLabel4.setText("Vertical phase shift per particle");

        deltaCySlider.setMaximum(1000);
        deltaCySlider.setValue(0);
        deltaCySlider.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                deltaCySliderChanged(evt);
            }
        });

        jLabel5.setText("Frequency");

        frequencySlider.setMaximum(250);
        frequencySlider.setValue(100);
        frequencySlider.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                frequencySliderChanged(evt);
            }
        });

        jLabel6.setText("Radius of each particle's motion");

        radiusSlider.setMaximum(250);
        radiusSlider.setValue(70);
        radiusSlider.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                radiusSliderChanged(evt);
            }
        });

        jLabel7.setText("Particle size");

        sizeSlider.setMaximum(120);
        sizeSlider.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                sizeSliderChanged(evt);
            }
        });

        modeButton.setText("Animate flag");
        modeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                modeButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(drawingPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(rowsSlider, javax.swing.GroupLayout.DEFAULT_SIZE, 363, Short.MAX_VALUE)
                    .addComponent(columnsSlider, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(deltaCxSlider, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(deltaCySlider, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(frequencySlider, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(radiusSlider, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(sizeSlider, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6)
                            .addComponent(jLabel7)
                            .addComponent(modeButton))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(drawingPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 50, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rowsSlider, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(columnsSlider, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(deltaCxSlider, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(deltaCySlider, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(frequencySlider, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(radiusSlider, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(sizeSlider, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(modeButton)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void rowSliderChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_rowSliderChanged
        if (mode.equals("normal")) 
            reset();
    }//GEN-LAST:event_rowSliderChanged

    private void columnsSliderChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_columnsSliderChanged
        if( this.mode.equals("flag") ) 
            resetRowsToFlagScale();
        
        reset();
    }//GEN-LAST:event_columnsSliderChanged

    private void deltaCxSliderChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_deltaCxSliderChanged
        reset();
    }//GEN-LAST:event_deltaCxSliderChanged

    private void deltaCySliderChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_deltaCySliderChanged
        reset();
    }//GEN-LAST:event_deltaCySliderChanged

    private void frequencySliderChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_frequencySliderChanged
        reset();
    }//GEN-LAST:event_frequencySliderChanged

    private void radiusSliderChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_radiusSliderChanged
        reset();
    }//GEN-LAST:event_radiusSliderChanged

    private void sizeSliderChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_sizeSliderChanged
        reset();
    }//GEN-LAST:event_sizeSliderChanged

    private void modeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_modeButtonActionPerformed
        if(this.mode.equals("flag")) {  //changing to normal mode
            this.mode = "normal";
            this.rowsSlider.setEnabled(true);
            this.modeButton.setText("Animate flag");           
        }
            
        else { //changing to flag mode
            this.mode = "flag";
            resetRowsToFlagScale();
            this.rowsSlider.setEnabled(false);
            this.modeButton.setText("Animate plain squares");           
        }
        reset();
           
    }//GEN-LAST:event_modeButtonActionPerformed

    
    public static void main(String args[]) {
        
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JSlider columnsSlider;
    private javax.swing.JSlider deltaCxSlider;
    private javax.swing.JSlider deltaCySlider;
    private javax.swing.JPanel drawingPanel;
    private javax.swing.JSlider frequencySlider;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JButton modeButton;
    private javax.swing.JSlider radiusSlider;
    private javax.swing.JSlider rowsSlider;
    private javax.swing.JSlider sizeSlider;
    // End of variables declaration//GEN-END:variables
}
