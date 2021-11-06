package start;

import controlador.UserController;
import logic.UserLogic;
import modelo.User;
import vista.*;

public class Start {
     public static void main(String args[]) {

                //Registrarse resgitrarseVista=new Registrarse();
                Home homeVista = new Home();
                User usermodel=new User();
                //resgitrarseVista.setVisible(true);
                homeVista.setVisible(true);
                UserLogic userLogic=new UserLogic();
                
                UserController userController= new UserController(usermodel, userLogic, homeVista);
                userController.iniciar();
    }
}
