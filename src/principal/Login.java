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
import persistencia.MedicosPersistencia;

/**
 *
 * @author Frankz
 */
public class Login {

    private String usuario; // El usuario sera la cedula
    private String contrasenia;
    private String tipoUsuario;
    private File archivo;

    //private MedicosPersistencia medicoPersistencia;

    public Login(String usuario, String contrasenia) {
        this.usuario = usuario;
        this.contrasenia = contrasenia;
    }

    public boolean validarCredenciales() {
        if (usuario.equals("") || contrasenia.equals("")) {
            System.out.println("Credenciales erroneas");
            return false;
        } else {
            Administrador admin = obtenerAdmin(usuario);
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

    public Administrador obtenerAdmin(String cedula) {
        this.archivo = new File("db/admins.txt");
        if (!this.archivo.exists()) {
            try {
                this.archivo.createNewFile();
            } catch (IOException ioe) {
                ioe.printStackTrace();
                System.exit(0);
            }
        }
        FileReader fileReader = null;
        BufferedReader br = null;
        Administrador admin = null;
        try {
            fileReader = new FileReader(this.archivo);
            br = new BufferedReader(fileReader);
            String linea = br.readLine();
            while (linea != null) {
                String cedulaEncontrada = linea.split(",")[0];
                if (cedulaEncontrada.equals(cedula)) {
                    String[] datosAdmin = linea.split(",");
                    admin = new Administrador(datosAdmin[0], datosAdmin[1], Integer.parseInt(datosAdmin[2]), datosAdmin[3], datosAdmin[4]);
                    return admin;
                }
                linea = br.readLine();
            }
        } catch (IOException ioe) {
            ioe.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (fileReader != null) {
                    fileReader.close();
                }
                if (br != null) {
                    br.close();
                }
            } catch (IOException ioe) {
                ioe.printStackTrace();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return admin;
    }
}
