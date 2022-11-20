/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package principal;

import gestores.GestorCitasMedicas;
import java.util.ArrayList;
import java.util.Scanner;
import persistencia.MedicosPersistencia;

/**
 *
 * @author Frankz
 */
public class Medico {

    private String cedula;
    private String nombre;
    private int edad;
    private String correoElectronico;
    private String contrasenia;

    private MedicosPersistencia medicoPersistencia;

    public Medico(String cedula, String nombre, int edad, String correoElectronico, String contrasenia) {
        this.cedula = cedula;
        this.nombre = nombre;
        this.edad = edad;
        this.correoElectronico = correoElectronico;
        this.contrasenia = contrasenia;
        this.medicoPersistencia = new MedicosPersistencia();
    }

    public void registrar() {
        this.medicoPersistencia.registrarMedico(this);
    }

    public void eliminar() {
        this.medicoPersistencia.eliminarMedico(this);
    }

    public void modificar() {

        Scanner in = new Scanner(System.in);

        ArrayList<String> med = new ArrayList<String>();

        System.out.println("=== INGRESE LOS CAMBIOS ===");
        System.out.println("INGRESE NOMBRE COMPLETO:");
        med.add(in.nextLine());
        System.out.println("INGRESE SU EDAD:");
        med.add(in.nextLine());
        System.out.println("INGRESE SU CORREO ELECTRONICO:");
        med.add(in.nextLine());
        System.out.println("INGRESE SU CONTRASEÑA:");
        med.add(in.nextLine());

        Medico medico = new Medico(this.cedula, med.get(1),
                Integer.parseInt(med.get(2)),
                med.get(3), med.get(4));
        this.eliminar();
        medico.registrar();
    }

    public String getCedula() {
        return cedula;
    }

    @Override
    public String toString() {
        return cedula + "," + nombre + "," + edad + "," + correoElectronico + "," + contrasenia;
    }

}
