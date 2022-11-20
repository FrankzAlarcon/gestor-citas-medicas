/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package principal;

import gestores.GestorCitasMedicas;
import gestores.GestorMedicos;
import persistencia.PacientesPersistencia;
import gestores.GestorPacientes;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;
import javax.crypto.AEADBadTagException;

/**
 *
 * @author Frankz
 */
public class main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("=============================================");
        System.out.println("-------SISTEMA GESTOR DE CITAS MEDICAS-------");
        System.out.println("=============================================");
        Administrador admin = new Administrador("1234567890", "admin", 20, "admin@epn.edu.ec", "admin");        
        Login login = new Login(admin.getCedula(), admin.getContrasenia());
        if (login.validarCredenciales()) {            
            GestorCitasMedicas gCitas = new GestorCitasMedicas();
            GestorMedicos gMedicos = new GestorMedicos();
            GestorPacientes gPacientes = new GestorPacientes();

            System.out.println("-------BIENVENIDO AL SISTEMA-------");
            System.out.println("1. AGENDAR CITA");
            System.out.println("2. CANCELAR CITA");
            System.out.println("3. GESTION MEDICOS");
            System.out.println("4. GESTION PACIENTES");
            System.out.println("5. SALIR");
            int opc = Integer.parseInt(in.nextLine());
            switch (opc) {
                case 1:
                    // Refactor a admin.accederGestorCitas.regitrarCita
                    // Agregar -> Consultar historial de citas medicas
                    // En los gestores -> Separar la logica de recoger datos en una funcion aparte (hecho en citas, medico)
                    // Quiza usar Introduce Explaining Variable en los condicionales (login especialmente)
                    // Cambiar de asociacion entre gestor medicos y gestor citas medicas a solo una dependencia y usar el medoto listar todas las citas
                    gCitas.registrarCita();
                    break;
                case 2:
                    System.out.println("INGRESE EL ID DE LA CITA A ELIMINAR");
                    String id = in.nextLine();
                    System.out.println(gCitas.eliminarCita(id));
                    break;
                case 3:
                    System.out.println("-------GESTION DE MEDICOS-------");
                    System.out.println("1. AÑADIR MEDICO");
                    System.out.println("2. ELIMINAR MEDICO");
                    System.out.println("3. MODIFICAR MEDICO");
                    System.out.println("4. SALIR");
                    int opcMed = in.nextInt();
                    switch (opcMed) {
                        case 1:
                            gMedicos.registrarMedico();
                            break;
                        case 2:
                            System.out.println("INGRESE LA CEDULA DEL MEDICO A ELIMINAR");
                            String cedMed = in.nextLine();
                            gMedicos.eliminarMedico(cedMed);
                            break;
                        case 3:
                            gMedicos.modificarMedico();
                            break;
                        case 4:
                            System.out.println("Saliendo del sistema...");
                            break;
                        default:
                            System.out.println("Saliendo del sistema...");
                            break;
                    }
                    break;
                case 4:
                    System.out.println("-------GESTION DE PACIENTES-------");
                    System.out.println("1. AÑADIR PACIENTE");
                    System.out.println("2. MODIFICAR PACIENTE");
                    System.out.println("3. ELIMINAR PACIENTE");
                    System.out.println("4. SALIR");
                    int opcPac = in.nextInt();
                    switch (opcPac) {
                        case 1:
                            gPacientes.registrarPaciente();
                            break;
                        case 2:
                            gPacientes.modificarMedico();
                            break;
                        case 3:
                            System.out.println("INGRESE LA CEDULA DEL PACIENTE A ELIMINAR");
                            String cedPac = in.nextLine();
                            gPacientes.eliminarPaciente(cedPac);
                            break;
                        case 4:
                            System.out.println("Saliendo del sistema...");
                            break;
                        default:
                            System.out.println("Saliendo del sistema...");
                            break;
                    }
                    break;
                case 5:
                    System.out.println("Saliendo del sistema...");
                    break;
                default:
                    System.out.println("Saliendo del sistema...");
                    break;
            }
        }

    }

}
