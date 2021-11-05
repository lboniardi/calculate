package start;

import controlador.UserController;
import logic.UserLogic;
import modelo.User;
import vista.Registrarse;

public class Start {
     public static void main(String args[]) {

                Registrarse resgitrarseVista=new Registrarse();
                User usermodel=new User();
                resgitrarseVista.setVisible(true);
                UserLogic userLogic=new UserLogic();
                
                UserController userController= new UserController(usermodel, userLogic, resgitrarseVista);
                userController.iniciar();
                resgitrarseVista.setVisible(true);
    }
}
