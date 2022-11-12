/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import gestores.GestorMedicos;
import gestores.GestorPacientes;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import principal.Cita;

/**
 *
 * @author Frankz
 */
public class CitasPersistencia {

    private File file;

    public CitasPersistencia() {
        this.file = new File("db/citas.txt");
        if (!this.file.exists()) {
            try {
                this.file.createNewFile();
            } catch (IOException ioe) {
                ioe.printStackTrace();
                System.exit(0);
            }
        }
    }
    
    public ArrayList<Cita> obtenerTodasLasCitas() {
        FileReader fileReader = null;
        BufferedReader br = null;
        
        ArrayList<Cita> citas = new ArrayList<Cita>();

        GestorMedicos gestorMedicos = new GestorMedicos();
        GestorPacientes gestorPacientes = new GestorPacientes();
        try {
            fileReader = new FileReader(this.file);
            br = new BufferedReader(fileReader);
            String linea = br.readLine();
            Cita cita;
            while (linea != null) {
                String idCitaEncontrado = linea.split(",")[0];
                String[] datosCita = linea.split(",");
                cita = new Cita(datosCita[0], LocalDateTime.parse(datosCita[1]), datosCita[2], datosCita[3], gestorMedicos.obtenerMedico(datosCita[4]), gestorPacientes.obtenerPaciente(datosCita[5]));
                citas.add(cita);
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
        return citas;
    }

    // retorna paciente o null, si es null no se encuentra el paciente
    public Cita obtenerCita(String idCita) {
        FileReader fileReader = null;
        BufferedReader br = null;
        Cita cita = null;

        GestorMedicos gestorMedicos = new GestorMedicos();
        GestorPacientes gestorPacientes = new GestorPacientes();
        try {
            fileReader = new FileReader(this.file);
            br = new BufferedReader(fileReader);
            String linea = br.readLine();
            while (linea != null) {
                String idCitaEncontrado = linea.split(",")[0];
                if (idCitaEncontrado.equals(idCita)) {
                    String[] datosCita = linea.split(",");
                    cita = new Cita(datosCita[0], LocalDateTime.parse(datosCita[1]), datosCita[2], datosCita[3], gestorMedicos.obtenerMedico(datosCita[4]), gestorPacientes.obtenerPaciente(datosCita[5]));
                    return cita;
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
        return cita;
    }

    public void registrarCita(Cita cita) {
        FileWriter fileWriter = null;
        BufferedWriter bw = null;
        String linea = cita.toString();
        try {
            fileWriter = new FileWriter(this.file, true);
            bw = new BufferedWriter(fileWriter);

            bw.write(linea);
            bw.newLine();
            bw.close();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (fileWriter != null) {
                    fileWriter.close();
                }
                if (bw != null) {
                    bw.close();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    public void eliminarCita(Cita citaAEliminar) {
        FileReader fileReader = null;
        BufferedReader br = null;

        FileWriter fileWriter = null;
        BufferedWriter bw = null;

        ArrayList<Cita> citas = new ArrayList<Cita>();
        try {
            fileReader = new FileReader(this.file);
            br = new BufferedReader(fileReader);

            String linea = br.readLine();
            Cita citaEncontrada;
            String[] datosCita;
            while (linea != null) {
                datosCita = linea.split(",");
                if (!citaAEliminar.getId().equals(datosCita[0])) {
                    citaEncontrada = this.obtenerCita(datosCita[0]);
                    citas.add(citaEncontrada);
                }
                linea = br.readLine();
            }
            
            fileWriter = new FileWriter(this.file);
            bw = new BufferedWriter(fileWriter);
            
            System.out.println("Citas");
            for (Cita c: citas) {
                System.out.println(c.toString());
                bw.write(c.toString());
                bw.newLine();
            }
            bw.close();
            
        } catch (IOException ioe) {
            ioe.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (fileWriter != null) {
                    fileWriter.close();
                }
                if (bw != null) {
                    bw.close();
                }
                if (fileReader != null) {
                    fileReader.close();
                }
                if (br != null) {
                    br.close();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }
}
