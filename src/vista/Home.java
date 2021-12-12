package vista;

import controlador.LoginControlador;
import controlador.UsuarioControlador;
import java.awt.Color;
import java.awt.Graphics;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import modelo.Consultas;
import modelo.Usuario;

public class Home extends javax.swing.JFrame {

    public Home() {
        this.setContentPane(new ImagenFondo());
        initComponents();
        this.setLocationRelativeTo(null);
        this.setTitle("Calculate (beta)");    }

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Home().setVisible(true);
            }
        });
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnLoginHome = new javax.swing.JButton();
        btnregistrarse = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setAlwaysOnTop(true);
        setIconImages(null);

        btnLoginHome.setBackground(new java.awt.Color(153, 51, 255));
        btnLoginHome.setFont(new java.awt.Font("Comic Sans MS", 0, 11)); // NOI18N
        btnLoginHome.setText("LOGIN");
        btnLoginHome.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnLoginHomeMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnLoginHomeMouseExited(evt);
            }
        });
        btnLoginHome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoginHomeActionPerformed(evt);
            }
        });

        btnregistrarse.setBackground(new java.awt.Color(153, 51, 255));
        btnregistrarse.setFont(new java.awt.Font("Comic Sans MS", 0, 11)); // NOI18N
        btnregistrarse.setText("REGISTRARSE");
        btnregistrarse.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnregistrarseMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnregistrarseMouseExited(evt);
            }
        });
        btnregistrarse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnregistrarseActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addComponent(btnregistrarse, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 41, Short.MAX_VALUE)
                .addComponent(btnLoginHome, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(71, 71, 71))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(340, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnLoginHome)
                    .addComponent(btnregistrarse))
                .addGap(35, 35, 35))
        );

        getAccessibleContext().setAccessibleDescription("");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /*
    private void btnRegistrarseActionPerformed(java.awt.event.ActionEvent evt) {                                               
            Singin registro = new Singin();
            registro.setVisible(true);
            this.setVisible(false);
    }   
     */

    private void btnLoginHomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoginHomeActionPerformed

        Login loguearse = new Login();
        Usuario modelo = new Usuario();
        Consultas modeloConsultas = new Consultas();
        IngresoGastos ingreso = new IngresoGastos();
        LoginControlador controlador = new LoginControlador(modelo, modeloConsultas,loguearse, ingreso);
        controlador.iniciar();
       
        loguearse.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btnLoginHomeActionPerformed

    private void btnregistrarseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnregistrarseActionPerformed
        Usuario modelo = new Usuario();
        Consultas modeloConsultas = new Consultas();
        Singin registrarse = new Singin();
        UsuarioControlador controlador = new UsuarioControlador(modelo, modeloConsultas, registrarse);
        controlador.iniciar();
        registrarse.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btnregistrarseActionPerformed

    private void btnregistrarseMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnregistrarseMouseEntered
        btnregistrarse.setBackground(Color.green);
    }//GEN-LAST:event_btnregistrarseMouseEntered

    private void btnregistrarseMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnregistrarseMouseExited
        btnregistrarse.setBackground(new java.awt.Color(153, 51, 255));
    }//GEN-LAST:event_btnregistrarseMouseExited

    private void btnLoginHomeMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnLoginHomeMouseEntered
        btnLoginHome.setBackground(Color.green);
    }//GEN-LAST:event_btnLoginHomeMouseEntered

    private void btnLoginHomeMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnLoginHomeMouseExited
        btnLoginHome.setBackground(new java.awt.Color(153, 51, 255));
    }//GEN-LAST:event_btnLoginHomeMouseExited

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnLoginHome;
    private javax.swing.JButton btnregistrarse;
    // End of variables declaration//GEN-END:variables

    public class ImagenFondo extends JPanel {

        @Override
        public void paint(Graphics g) {
            ImageIcon imagen = new ImageIcon(getClass().getResource("/imagenes/calculador.png"));
            g.drawImage(imagen.getImage(), 0, 0, getWidth(), getHeight(), this);
            setOpaque(false);
            super.paint(g);
        }
    }
}
