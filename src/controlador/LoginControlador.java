package controlador;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import modelo.*;
import vista.*;

public class LoginControlador  implements ActionListener {
    
    private Usuario modelo;    
    private Consultas modeloConsultas;
    private Login loguearse;
    private IngresoGastos ingreso;
    
    
    public LoginControlador(Usuario modelo, Consultas modeloConsultas, Login loguearse, IngresoGastos ingreso){
        this.modelo = modelo;
        this.modeloConsultas = modeloConsultas;
        this.loguearse = loguearse;
        this.ingreso = ingreso;
        this.loguearse.btnLogin.addActionListener(this);
          
    }    
     public void iniciar() {
        loguearse.setTitle("Login");
        loguearse.setLocationRelativeTo(null);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
          if (e.getSource() == loguearse.btnLogin) {
              try {
                  modelo.setUsuario(loguearse.txtUsuario.getText());
                  modelo.setContraseña(loguearse.txtPassword.getText());
                  
                  if ( modelo.getUsuario().isEmpty() || modelo.getContraseña().isEmpty() ) {
                      JOptionPane.showMessageDialog(null, "Debes completar todos los campos");
                  } else if (modeloConsultas.Login(modelo)) {
                      JOptionPane.showMessageDialog(null, "Bienvenido!!!");
                      limpiar();
                        loguearse.setVisible(false);
                        ingreso.setVisible(true);
                  } else {
                      JOptionPane.showMessageDialog(null, "Usuario o contraseña incorrectos");
                      limpiar();
                  }
              } catch (ClassNotFoundException ex) {
                  Logger.getLogger(LoginControlador.class.getName()).log(Level.SEVERE, null, ex);
              }
          }
        
    }
    
    public void limpiar() {
        loguearse.txtUsuario.setText(null);
        loguearse.txtPassword.setText(null);
    }

}