
package Formularios;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;


public class MenuPrincipal extends javax.swing.JFrame {
    
    Color colorBase = new Color(255, 0, 76);
    Color colorHover = new Color(255, 51, 102);  // Un rosa más claro para hover
    Color colorPressed = new Color(204, 0, 61);  // Más oscuro para pressed

    /**
    * Configura un JInternalFrame para que tenga una apariencia limpia y fija.
    * Elimina el borde y la barra superior (north pane), además de deshabilitar
    * la capacidad de redimensionar, cerrar, minimizar o maximizar el frame.
    * 
    * @param frame El JInternalFrame a configurar.
    */
    private void configurarInternalFrame(javax.swing.JInternalFrame frame) {
    frame.setBorder(null); 
    ((javax.swing.plaf.basic.BasicInternalFrameUI) frame.getUI()).setNorthPane(null);
    frame.setResizable(false);
    frame.setClosable(false); 
    frame.setIconifiable(false); 
    frame.setMaximizable(false); 
}
    

    public MenuPrincipal() {
        initComponents();
         setResizable(false); 
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        Menu = new javax.swing.JPanel();
        botonFuncion = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        botonAdministracion = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        botonVentas = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        botonReportes = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        botonPeliculas = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        app_name = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        app_name1 = new javax.swing.JLabel();
        escritorio = new javax.swing.JDesktopPane();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setMinimumSize(new java.awt.Dimension(1350, 660));
        jPanel1.setPreferredSize(new java.awt.Dimension(1350, 660));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Menu.setBackground(new java.awt.Color(17, 9, 22));
        Menu.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        botonFuncion.setBackground(new java.awt.Color(255, 0, 76));
        botonFuncion.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        botonFuncion.setPreferredSize(new java.awt.Dimension(270, 70));
        botonFuncion.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                botonFuncionMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                botonFuncionMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                botonFuncionMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                botonFuncionMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                botonFuncionMouseReleased(evt);
            }
        });
        botonFuncion.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Funcion");
        botonFuncion.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 20, 70, 30));

        jLabel15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/imagenes/funcion.png"))); // NOI18N
        botonFuncion.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 40, 40));

        Menu.add(botonFuncion, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 350, -1, 80));

        botonAdministracion.setBackground(new java.awt.Color(255, 0, 76));
        botonAdministracion.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        botonAdministracion.setPreferredSize(new java.awt.Dimension(270, 70));
        botonAdministracion.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                botonAdministracionMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                botonAdministracionMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                botonAdministracionMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                botonAdministracionMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                botonAdministracionMouseReleased(evt);
            }
        });
        botonAdministracion.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Clientes");
        botonAdministracion.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 20, -1, 30));

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/imagenes/config 32.png"))); // NOI18N
        botonAdministracion.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 50, 50));

        Menu.add(botonAdministracion, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 430, -1, 80));

        botonVentas.setBackground(new java.awt.Color(255, 0, 76));
        botonVentas.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        botonVentas.setPreferredSize(new java.awt.Dimension(270, 70));
        botonVentas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                botonVentasMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                botonVentasMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                botonVentasMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                botonVentasMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                botonVentasMouseReleased(evt);
            }
        });
        botonVentas.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Ventas");
        botonVentas.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 20, -1, 30));

        jLabel16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/imagenes/shop 32.png"))); // NOI18N
        botonVentas.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 40, 40));

        Menu.add(botonVentas, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 510, -1, 80));

        botonReportes.setBackground(new java.awt.Color(255, 0, 76));
        botonReportes.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        botonReportes.setPreferredSize(new java.awt.Dimension(270, 70));
        botonReportes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                botonReportesMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                botonReportesMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                botonReportesMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                botonReportesMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                botonReportesMouseReleased(evt);
            }
        });
        botonReportes.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel12.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("Reportes");
        botonReportes.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 10, -1, 30));

        jLabel13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/imagenes/reportes.png"))); // NOI18N
        botonReportes.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 40, 40));

        Menu.add(botonReportes, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 590, -1, -1));

        botonPeliculas.setBackground(new java.awt.Color(255, 0, 76));
        botonPeliculas.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        botonPeliculas.setPreferredSize(new java.awt.Dimension(270, 70));
        botonPeliculas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                botonPeliculasMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                botonPeliculasMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                botonPeliculasMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                botonPeliculasMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                botonPeliculasMouseReleased(evt);
            }
        });
        botonPeliculas.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel14.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setText("Peliculas");
        botonPeliculas.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 20, 90, 30));

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/imagenes/movie 32.png"))); // NOI18N
        botonPeliculas.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 40, 40));

        Menu.add(botonPeliculas, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 270, -1, 80));

        app_name.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        app_name.setForeground(new java.awt.Color(255, 255, 255));
        app_name.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/imagenes/Cinema_Showtime_100x100.png"))); // NOI18N
        Menu.add(app_name, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 120, 100, 100));

        jSeparator1.setPreferredSize(new java.awt.Dimension(50, 5));
        Menu.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 70, 190, 10));

        app_name1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        app_name1.setForeground(new java.awt.Color(255, 255, 255));
        app_name1.setText("CINEMA SHOWTIME");
        Menu.add(app_name1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, -1, -1));

        jPanel1.add(Menu, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 660));

        escritorio.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout escritorioLayout = new javax.swing.GroupLayout(escritorio);
        escritorio.setLayout(escritorioLayout);
        escritorioLayout.setHorizontalGroup(
            escritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1130, Short.MAX_VALUE)
        );
        escritorioLayout.setVerticalGroup(
            escritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 660, Short.MAX_VALUE)
        );

        jPanel1.add(escritorio, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 0, 1130, -1));

        getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void botonPeliculasMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botonPeliculasMousePressed
            botonPeliculas.setBackground(colorPressed);
    }//GEN-LAST:event_botonPeliculasMousePressed

    private void botonPeliculasMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botonPeliculasMouseExited
            botonPeliculas.setBackground(colorBase);
    }//GEN-LAST:event_botonPeliculasMouseExited

    private void botonPeliculasMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botonPeliculasMouseEntered
        botonPeliculas.setBackground(colorHover);
    }//GEN-LAST:event_botonPeliculasMouseEntered

    private void botonPeliculasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botonPeliculasMouseClicked
        Peliculas panelPeliculas = new Peliculas();
        navegar(panelPeliculas);
    }//GEN-LAST:event_botonPeliculasMouseClicked

    private void botonReportesMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botonReportesMousePressed
            botonReportes.setBackground(colorPressed);
    }//GEN-LAST:event_botonReportesMousePressed

    private void botonReportesMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botonReportesMouseExited
            botonReportes.setBackground(colorBase);
    }//GEN-LAST:event_botonReportesMouseExited

    private void botonReportesMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botonReportesMouseEntered
           botonReportes.setBackground(colorHover);
    }//GEN-LAST:event_botonReportesMouseEntered

    private void botonReportesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botonReportesMouseClicked
        Reportes panelReportes = new Reportes();
        navegar(panelReportes);
    }//GEN-LAST:event_botonReportesMouseClicked

    private void botonVentasMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botonVentasMousePressed
            botonVentas.setBackground(colorPressed);
    }//GEN-LAST:event_botonVentasMousePressed

    private void botonVentasMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botonVentasMouseExited
            botonVentas.setBackground(colorBase);
    }//GEN-LAST:event_botonVentasMouseExited

    private void botonVentasMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botonVentasMouseEntered
            botonVentas.setBackground(colorHover);
    }//GEN-LAST:event_botonVentasMouseEntered

    private void botonVentasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botonVentasMouseClicked
        Ventas panelVentas = new Ventas();
        navegar(panelVentas);

    }//GEN-LAST:event_botonVentasMouseClicked

    private void botonAdministracionMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botonAdministracionMousePressed
            botonAdministracion.setBackground(colorPressed);
    }//GEN-LAST:event_botonAdministracionMousePressed

    private void botonAdministracionMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botonAdministracionMouseExited
        botonAdministracion.setBackground(colorBase);
    }//GEN-LAST:event_botonAdministracionMouseExited

    private void botonAdministracionMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botonAdministracionMouseEntered
            botonAdministracion.setBackground(colorHover);
    }//GEN-LAST:event_botonAdministracionMouseEntered

    private void botonFuncionMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botonFuncionMousePressed
         botonFuncion.setBackground(colorPressed);
    }//GEN-LAST:event_botonFuncionMousePressed

    private void botonFuncionMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botonFuncionMouseExited
            botonFuncion.setBackground(colorBase);
    }//GEN-LAST:event_botonFuncionMouseExited

    private void botonFuncionMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botonFuncionMouseEntered
            botonFuncion.setBackground(colorHover);
    }//GEN-LAST:event_botonFuncionMouseEntered

    private void botonFuncionMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botonFuncionMouseClicked
        Funcion panelFuncion = new Funcion();
        navegar(panelFuncion);

    }//GEN-LAST:event_botonFuncionMouseClicked

    private void botonPeliculasMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botonPeliculasMouseReleased
        if (botonPeliculas.contains(evt.getPoint())) {
            botonPeliculas.setBackground(colorHover);
        } else {
            botonPeliculas.setBackground(colorBase);
        }
    }//GEN-LAST:event_botonPeliculasMouseReleased

    private void botonFuncionMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botonFuncionMouseReleased
         if (botonFuncion.contains(evt.getPoint())) {
            botonFuncion.setBackground(colorHover);
        } else {
            botonFuncion.setBackground(colorBase);
        }
    }//GEN-LAST:event_botonFuncionMouseReleased

    private void botonAdministracionMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botonAdministracionMouseReleased
        if (botonAdministracion.contains(evt.getPoint())) {
            botonAdministracion.setBackground(colorHover);
        } else {
            botonAdministracion.setBackground(colorBase);
        }
    }//GEN-LAST:event_botonAdministracionMouseReleased

    private void botonVentasMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botonVentasMouseReleased
         if (botonVentas.contains(evt.getPoint())) {
            botonVentas.setBackground(colorHover);
        } else {
            botonVentas.setBackground(colorBase);
        }
          
    }//GEN-LAST:event_botonVentasMouseReleased

    private void botonReportesMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botonReportesMouseReleased
           if (botonReportes.contains(evt.getPoint())) {
            botonReportes.setBackground(colorHover);
        } else {
            botonReportes.setBackground(colorBase);
        }
    }//GEN-LAST:event_botonReportesMouseReleased

    private void botonAdministracionMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botonAdministracionMouseClicked
        DatosClientes fClientes = new DatosClientes();
        navegar(fClientes);
    }//GEN-LAST:event_botonAdministracionMouseClicked

    private void limpiarEscritorio() {
    for (JInternalFrame frame : escritorio.getAllFrames()) {
        frame.dispose(); 
    }
}

 /**
 * Navega mostrando el JInternalFrame seleccionado en el escritorio.
 * Limpia el escritorio, configura el frame (sin bordes ni controles),
 * lo agrega al escritorio, ajusta su tamaño y posición para que
 * no exceda el tamaño del escritorio y finalmente lo muestra.
 *
 * @param panelSeleccionado El JInternalFrame que se desea mostrar.
 */
   private void navegar(JInternalFrame panelSeleccionado) {
      limpiarEscritorio();
         configurarInternalFrame(panelSeleccionado);

    escritorio.add(panelSeleccionado);

    panelSeleccionado.pack();

    Dimension escritorioSize = escritorio.getSize();

    int ancho = Math.min(panelSeleccionado.getWidth(), escritorioSize.width);
    int alto = Math.min(panelSeleccionado.getHeight(), escritorioSize.height);

    panelSeleccionado.setSize(ancho, alto);
    panelSeleccionado.setLocation(0, 0);
    panelSeleccionado.setVisible(true);

    escritorio.revalidate();
    escritorio.repaint();
}

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
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
            java.util.logging.Logger.getLogger(MenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MenuPrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Menu;
    private javax.swing.JLabel app_name;
    private javax.swing.JLabel app_name1;
    private javax.swing.JPanel botonAdministracion;
    private javax.swing.JPanel botonFuncion;
    private javax.swing.JPanel botonPeliculas;
    private javax.swing.JPanel botonReportes;
    private javax.swing.JPanel botonVentas;
    private javax.swing.JDesktopPane escritorio;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JSeparator jSeparator1;
    // End of variables declaration//GEN-END:variables
}
