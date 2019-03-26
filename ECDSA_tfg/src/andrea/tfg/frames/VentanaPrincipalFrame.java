/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package andrea.tfg.frames;

import andrea.tfg.panels.PanelPredeterminado;
import andrea.tfg.panels.PanelAvanzado;
import andrea.tfg.panels.PanelMezcla;
import java.awt.BorderLayout;
import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.JFrame;

/**
 *
 * @author Andrea
 */
public class VentanaPrincipalFrame extends javax.swing.JFrame {

    /**
     * Creates new form VentanaPrincipal
     */
    public VentanaPrincipalFrame() {
        initComponents();
        
        //Para conseguir que se abra en ventana completa la aplicación.
        this.setExtendedState(MAXIMIZED_BOTH);   
        
        //Intentando poner una imagen de fondo en el JFrame.
        //panelPrincipal.createToolTip().getToolkit().createImage("andrea/tfg/resources/blockchain.png");
        
        this.setTitle("MECDSA");

    }
    
    // Método para cambiar el icono de la ventana.
    @Override
    public Image getIconImage() {
        Image retValue = Toolkit.getDefaultToolkit().
                getImage(ClassLoader.getSystemResource("andrea/tfg/resources/blockchain.png"));
        return retValue;
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelPrincipal = new javax.swing.JPanel();
        FondoFrame = new javax.swing.JLabel();
        jMenuBar2 = new javax.swing.JMenuBar();
        Modo = new javax.swing.JMenu();
        menuModoPredeterminado = new javax.swing.JMenuItem();
        menuModoAvanzado = new javax.swing.JMenuItem();
        menuModoMezcla = new javax.swing.JMenuItem();
        Fichero = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        Ayuda = new javax.swing.JMenu();
        ayudaUsoBoton = new javax.swing.JMenuItem();
        autores = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setIconImage(getIconImage());
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panelPrincipal.setPreferredSize(new java.awt.Dimension(1329, 1127));

        FondoFrame.setBackground(new java.awt.Color(83, 239, 240));
        FondoFrame.setIcon(new javax.swing.ImageIcon(getClass().getResource("/andrea/tfg/resources/bitcoin.png"))); // NOI18N

        javax.swing.GroupLayout panelPrincipalLayout = new javax.swing.GroupLayout(panelPrincipal);
        panelPrincipal.setLayout(panelPrincipalLayout);
        panelPrincipalLayout.setHorizontalGroup(
            panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelPrincipalLayout.createSequentialGroup()
                .addContainerGap(174, Short.MAX_VALUE)
                .addComponent(FondoFrame, javax.swing.GroupLayout.PREFERRED_SIZE, 1072, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(94, 94, 94))
        );
        panelPrincipalLayout.setVerticalGroup(
            panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelPrincipalLayout.createSequentialGroup()
                .addComponent(FondoFrame, javax.swing.GroupLayout.PREFERRED_SIZE, 662, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 424, Short.MAX_VALUE))
        );

        getContentPane().add(panelPrincipal, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 11, 1340, 1086));

        Modo.setText("Modo");

        menuModoPredeterminado.setText("Predeterminado");
        menuModoPredeterminado.addContainerListener(new java.awt.event.ContainerAdapter() {
            public void componentAdded(java.awt.event.ContainerEvent evt) {
                menuModoPredeterminadoComponentAdded(evt);
            }
        });
        menuModoPredeterminado.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                menuModoPredeterminadoMousePressed(evt);
            }
        });
        menuModoPredeterminado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuModoPredeterminadoActionPerformed(evt);
            }
        });
        Modo.add(menuModoPredeterminado);

        menuModoAvanzado.setText("Avanzado");
        menuModoAvanzado.setPreferredSize(new java.awt.Dimension(75, 22));
        menuModoAvanzado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuModoAvanzadoActionPerformed(evt);
            }
        });
        Modo.add(menuModoAvanzado);

        menuModoMezcla.setText("Mezcla");
        menuModoMezcla.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuModoMezclaActionPerformed(evt);
            }
        });
        Modo.add(menuModoMezcla);

        jMenuBar2.add(Modo);

        Fichero.setText("Fichero");

        jMenuItem1.setText("Descargar firma");
        Fichero.add(jMenuItem1);

        jMenuItem2.setText("Descargar mensaje");
        Fichero.add(jMenuItem2);

        jMenuItem3.setText("Descargar firma y mensaje");
        Fichero.add(jMenuItem3);

        jMenuBar2.add(Fichero);

        Ayuda.setText("Ayuda");

        ayudaUsoBoton.setText("Manual");
        ayudaUsoBoton.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                ayudaUsoBotonAncestorAdded(evt);
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });
        ayudaUsoBoton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ayudaUsoBotonMouseClicked(evt);
            }
        });
        ayudaUsoBoton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ayudaUsoBotonActionPerformed(evt);
            }
        });
        Ayuda.add(ayudaUsoBoton);

        autores.setText("Autores");
        autores.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                autoresActionPerformed(evt);
            }
        });
        Ayuda.add(autores);

        jMenuBar2.add(Ayuda);

        setJMenuBar(jMenuBar2);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void menuModoAvanzadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuModoAvanzadoActionPerformed
        // TODO add your handling code here:
        PanelAvanzado p1 = new PanelAvanzado();
        
        // Para poder poner los JPanel a pantalla completa cogemos el tamaño del frame VentanaPrincipal.
        VentanaPrincipalFrame v = new VentanaPrincipalFrame();
        p1.setBounds(v.getBounds());
        
        panelPrincipal.removeAll();       
        panelPrincipal.add(p1, BorderLayout.CENTER);
        panelPrincipal.revalidate();
        panelPrincipal.repaint();
        
        // Utilizar estas lineas para cambiar el título dependiendo del modo en el que estemos.
        if (menuModoAvanzado.isArmed()) {
            this.setTitle("MECDSA   Avanzado");
        }
    }//GEN-LAST:event_menuModoAvanzadoActionPerformed

    // Método que realiza una accion sobre el botón ayuda uso del menú Ayuda.
    private void ayudaUsoBotonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ayudaUsoBotonActionPerformed
        // TODO add your handling code here:
        AyudaUsoFrame auf = new AyudaUsoFrame();
        auf.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        auf.setVisible(true);
        auf.setTitle("Ayuda usuario");
    }//GEN-LAST:event_ayudaUsoBotonActionPerformed

    private void menuModoPredeterminadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuModoPredeterminadoActionPerformed

        PanelPredeterminado p1 = new PanelPredeterminado();
        
        // Para poder poner los JPanel a pantalla completa cogemos el tamaño del frame VentanaPrincipal.
        VentanaPrincipalFrame v = new VentanaPrincipalFrame();
        p1.setBounds(v.getBounds());              
        
        // Con esto podemos añadir el JPanel.
        panelPrincipal.removeAll();       
        panelPrincipal.add(p1, BorderLayout.CENTER);
        panelPrincipal.revalidate();
        panelPrincipal.repaint();
        
        // Utilizar estas lineas para cambiar el título dependiendo del modo en el que estemos.
        if (menuModoPredeterminado.isArmed()) {
            this.setTitle("MECDSA   Predeterminado");
        }       
    }//GEN-LAST:event_menuModoPredeterminadoActionPerformed

    private void ayudaUsoBotonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ayudaUsoBotonMouseClicked
        // TODO add your handling code here:
         
    }//GEN-LAST:event_ayudaUsoBotonMouseClicked

    private void ayudaUsoBotonAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_ayudaUsoBotonAncestorAdded
        // TODO add your handling code here:
    }//GEN-LAST:event_ayudaUsoBotonAncestorAdded

    private void autoresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_autoresActionPerformed
        // TODO add your handling code here:
        AutoresFrame auf = new AutoresFrame();
        auf.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        auf.setVisible(true);
        auf.setTitle("Sobre los autores");
    }//GEN-LAST:event_autoresActionPerformed

    private void menuModoPredeterminadoMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menuModoPredeterminadoMousePressed
        // TODO add your handling code here:
        PanelPredeterminado pP = new PanelPredeterminado();
        pP.setVisible(true);
    }//GEN-LAST:event_menuModoPredeterminadoMousePressed

    private void menuModoPredeterminadoComponentAdded(java.awt.event.ContainerEvent evt) {//GEN-FIRST:event_menuModoPredeterminadoComponentAdded
        // TODO add your handling code here:
        PanelPredeterminado pP = new PanelPredeterminado();
        pP.setVisible(true);
    }//GEN-LAST:event_menuModoPredeterminadoComponentAdded

    private void menuModoMezclaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuModoMezclaActionPerformed
        // TODO add your handling code here:
        PanelMezcla p1 = new PanelMezcla();
        
        // Para poder poner los JPanel a pantalla completa cogemos el tamaño del frame VentanaPrincipal.
        VentanaPrincipalFrame v = new VentanaPrincipalFrame();
        p1.setBounds(v.getBounds());
        
        // Con esto podemos añadir el JPanel.
        panelPrincipal.removeAll();       
        panelPrincipal.add(p1, BorderLayout.CENTER);
        panelPrincipal.revalidate();
        panelPrincipal.repaint();
        
        // Utilizar estas lineas para cambiar el título dependiendo del modo en el que estemos.
        if (menuModoMezcla.isArmed()) {
            this.setTitle("MECDSA   Mezcla");
        }
    }//GEN-LAST:event_menuModoMezclaActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) 
    {
        
        /* Set the Nimbus look and feel */
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
            java.util.logging.Logger.getLogger(VentanaPrincipalFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VentanaPrincipalFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VentanaPrincipalFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VentanaPrincipalFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VentanaPrincipalFrame().setVisible(true);                             
            }
        });         
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu Ayuda;
    private javax.swing.JMenu Fichero;
    private javax.swing.JLabel FondoFrame;
    private javax.swing.JMenu Modo;
    private javax.swing.JMenuItem autores;
    private javax.swing.JMenuItem ayudaUsoBoton;
    private javax.swing.JMenuBar jMenuBar2;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem menuModoAvanzado;
    private javax.swing.JMenuItem menuModoMezcla;
    private javax.swing.JMenuItem menuModoPredeterminado;
    private javax.swing.JPanel panelPrincipal;
    // End of variables declaration//GEN-END:variables
}
