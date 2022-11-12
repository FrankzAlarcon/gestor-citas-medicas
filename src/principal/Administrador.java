/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package principal;

import gestores.GestorCitasMedicas;
import gestores.GestorMedicos;
import gestores.GestorPacientes;

/**
 *
 * @author Frankz
 */
public class Administrador {
    
    private String nombre;
    private String nombreUsuario;
    private int ID;
    private String correoElectronico;
    private String contrasenia;

    private GestorMedicos gestorMedicos;
    private GestorCitasMedicas gestorCitas;
    private GestorPacientes gestorPacientes;
   

    public Administrador(String nombre, String nombreUsuario, int ID, String correoElectronico, String contrasenia) {
        this.nombre = nombre;
        this.nombreUsuario = nombreUsuario;
        this.ID = ID;
        this.correoElectronico = correoElectronico;
        this.contrasenia = contrasenia;
        
    }

    public void accederGestorMedicos(){
        this.gestorMedicos = new GestorMedicos();
    }
    
    public void accederGestorCitasMedicas(){
        this.gestorCitas = new GestorCitasMedicas();
    }
    
    public void accederGestorPacientes(){
        this.gestorPacientes = new GestorPacientes();
    }

    
    
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }

    

    public String toString() {
        return "nombre=" + nombre + ", nombreUsuario=" + nombreUsuario + ", ID=" + ID + ", correoElectronico=" + correoElectronico + ", contrasenia=" + contrasenia + '}';
    }

    

    
    
    
}
