package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import logic.UserLogic;
import modelo.User;
import vista.Login;
import vista.Registrarse;

public class UserController implements ActionListener{
    
    private UserLogic userLogic;
    private User userModel;
    private Registrarse registrarseVista;
    
    public UserController( User userModel, UserLogic userLogic, Registrarse registrarseVista){
        this.userModel=userModel;
        this.registrarseVista=registrarseVista;
        this.userLogic=userLogic;
        this.registrarseVista.btnRegistrarse.addActionListener(this);
    }
    
    public void iniciar(){
        this.registrarseVista.setLocationRelativeTo(null);
        this.registrarseVista.setTitle("Calculate (beta)");
//        boolean result=userLogic.RegisterUser(this.userModel);
//        System.out.println("result");
    }
   
    @Override
    public void actionPerformed(ActionEvent e) {
                if(e.getSource()==registrarseVista.btnRegistrarse){
                            userModel.setUser_name(registrarseVista.txtUser.getText());
                            userModel.setPassword((registrarseVista.txtPassword.getText()));
                        }
                if(userLogic.RegisterUser(this.userModel)==true){
                    JOptionPane.showMessageDialog(null, "Registro Guardado");
                    System.out.println("aca controller");
                }else{
                    JOptionPane.showMessageDialog(null, "NOOOOOO");
                }
    }
}
