package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import modelo.Consultas;
import modelo.Usuario;
import vista.Singin;

public class UsuarioControlador implements ActionListener {

    private Usuario modelo;
    
    private Consultas modeloConsultas;
    private Singin registrarse;

    public UsuarioControlador(Usuario modelo, Consultas modeloConsultas, Singin registrarse) {
        this.modelo = modelo;
        this.modeloConsultas = modeloConsultas;
        this.registrarse = registrarse;
        this.registrarse.btnRegistrarse.addActionListener(this);
        this.registrarse.btnEditar.addActionListener(this);
        this.registrarse.btnEliminar.addActionListener(this);
        this.registrarse.btnLimpiar.addActionListener(this);
        this.registrarse.btnBuscar.addActionListener(this);
    }

    public void iniciar() {
        registrarse.setTitle("Usuarios");
        registrarse.setLocationRelativeTo(null);
        //registrarse.txtId.setVisible(false);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == registrarse.btnRegistrarse) {
            modelo.setNombre(registrarse.txtNombre.getText());
            modelo.setApellido(registrarse.txtApellido.getText());
            modelo.setUsuario(registrarse.txtUsuario.getText());
            modelo.setContraseña(registrarse.txtClave.getText());
            System.out.print("modelo !" + modelo);
            if (modeloConsultas.registrarse(modelo)) {
                JOptionPane.showMessageDialog(null, "Registro guardado");
                limpiar();
            } else {
                JOptionPane.showMessageDialog(null, "Error al guardar");
                limpiar();
            }
        }  

        //aca van todos los if/else de cada boton que ejecutan las consultas
        
        
        if (e.getSource() == registrarse.btnLimpiar) {
            limpiar();
        }
        
        if (e.getSource() == registrarse.btnBuscar) {
            
            modelo.setNombre(registrarse.txtId.getText());
            if (modeloConsultas.buscar(modelo)) {
                
                registrarse.txtNombre.setText(modelo.getNombre());
                registrarse.txtApellido.setText(modelo.getApellido());
                registrarse.txtUsuario.setText(modelo.getUsuario());
                registrarse.txtClave.setText(modelo.getContraseña());
                
                JOptionPane.showMessageDialog(null, "ok");
                
            } else {
                JOptionPane.showMessageDialog(null, "No se Encuentran registros con esos datos");
                limpiar();
            }
        }  
        
        if (e.getSource() == registrarse.btnEditar) {
            
            System.out.println("... " + modelo.getId());
            modelo.setNombre(registrarse.txtNombre.getText());
            modelo.setApellido(registrarse.txtApellido.getText());
            modelo.setUsuario(registrarse.txtUsuario.getText());
            modelo.setContraseña(registrarse.txtClave.getText());
                    
            if (modeloConsultas.editar(modelo)) {    
                JOptionPane.showMessageDialog(null, "ok Editados");
                limpiar();
                
            } else {
                JOptionPane.showMessageDialog(null, "No se Encuentran registros con esos datos");
                limpiar();
            }
        } 
        
        
    }

    public void limpiar() {
        registrarse.txtId.setText(null);
        registrarse.txtNombre.setText(null);
        registrarse.txtApellido.setText(null);
        registrarse.txtUsuario.setText(null);
        registrarse.txtClave.setText(null);
    }
    
    public void setUsuarioEncontrado(Usuario modelo){
        this.modelo=modelo;
    }
    
    public Usuario getUsuarioEncontrado(){
        return this.modelo;
    }
}
