/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package principal;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import persistencia.AdministradorPersistencia;

/**
 *
 * @author Frankz
 */
public class Login {

    private String usuario; // El usuario sera la cedula
    private String contrasenia;
    private String tipoUsuario;

    private AdministradorPersistencia adminPersistencia = new AdministradorPersistencia();
    

    public Login(String usuario, String contrasenia) {
        this.usuario = usuario;
        this.contrasenia = contrasenia;
    }

    public boolean validarCredenciales() {
        if (usuario.equals("") || contrasenia.equals("")) {
            System.out.println("Credenciales erroneas");
            return false;
        } else {
            Administrador admin = adminPersistencia.obtenerAdministrador(usuario);
            if (admin == null) {
                System.out.println("Acceso Denegado");
                return false;
            }
            if (admin.getCedula().equals(usuario) && admin.getContrasenia().equals(contrasenia)) {
                System.out.println("Acceso Exitoso");
                return true;
            } else {
                System.out.println("Acceso Denegado");
                return false;
            }
        }
    }

}
