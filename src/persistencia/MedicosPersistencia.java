/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import principal.Medico;

/**
 *
 * @author Frankz
 */
public class MedicosPersistencia {
    private File archivo;
    
    public MedicosPersistencia() {
        this.archivo = new File("db/medicos.txt");
        if (!this.archivo.exists()) {
            try {
                this.archivo.createNewFile();
            } catch(IOException ioe) {
                ioe.printStackTrace();
                System.exit(0);
            }
        }             
    }
    
    // retorna paciente o null, si es null no se encuentra el paciente
    public Medico obtenerMedico(String cedula) {        
        FileReader fileReader =  null;
        BufferedReader br = null;
        Medico medico = null;
        try {
            fileReader =new FileReader(this.archivo);
            br = new BufferedReader(fileReader);
            String linea = br.readLine();
            while (linea != null) {
                String cedulaEncontrada = linea.split(",")[0];
                if (cedulaEncontrada.equals(cedula)) {
                    String[] datosPaciente = linea.split(",");
                    medico = new Medico(datosPaciente[0], datosPaciente[1], Integer.parseInt(datosPaciente[2]), datosPaciente[3], datosPaciente[4]);
                    return medico;
                }
                linea = br.readLine();
            }            
        } catch (IOException ioe) {
            ioe.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            ControladorBuffers.cerrarBuffers(fileReader, br);
        }
        return medico;
    }
    
    public void registrarMedico(Medico medico) {
        FileWriter fileWriter = null;
        BufferedWriter bw = null;
        String linea = medico.toString();
        try {            
            fileWriter = new FileWriter(this.archivo, true);
            bw = new BufferedWriter(fileWriter);
            
            bw.write(linea);
            bw.newLine();
            bw.close();
        } catch(IOException ioe) {
            ioe.printStackTrace();
        } catch(Exception e) {
            e.printStackTrace();
        } finally {
            ControladorBuffers.cerrarBuffers(fileWriter, bw);
        }   
    }

        public void eliminarMedico(Medico medico) {
        FileReader fileReader = null;
        BufferedReader br = null;

        FileWriter fileWriter = null;
        BufferedWriter bw = null;

        ArrayList<Medico> medicos = new ArrayList<Medico>();
        try {
            fileReader = new FileReader(this.archivo);
            br = new BufferedReader(fileReader);

            String linea = br.readLine();
            Medico medicoEncontrado;
            String[] datosMedico;
            while (linea != null) {
                datosMedico = linea.split(",");
                if (!medico.getCedula().equals(datosMedico[0])) {
                    medicoEncontrado = new Medico(datosMedico[0], datosMedico[1], Integer.parseInt(datosMedico[2]), datosMedico[3], datosMedico[4]);
                    medicos.add(medicoEncontrado);
                }
                linea = br.readLine();
            }
            
            fileWriter = new FileWriter(this.archivo);
            bw = new BufferedWriter(fileWriter);
            
            for (Medico m: medicos) {
                bw.write(m.toString());
                bw.newLine();
            }
            bw.close();
            
        } catch (IOException ioe) {
            ioe.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            ControladorBuffers.cerrarBuffers(fileWriter, bw, fileReader, br);
        }
    }
}
