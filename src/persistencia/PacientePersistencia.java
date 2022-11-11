/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import principal.Paciente;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

/**
 *
 * @author Frankz
 */
public class PacientePersistencia {
    private File file;
    
    public PacientePersistencia() {
        this.file = new File("db/pacientes.txt");
        if (!this.file.exists()) {
            try {
                this.file.createNewFile();
            } catch(IOException ioe) {
                ioe.printStackTrace();
                System.exit(0);
            }
        }             
    }
    
    // retorna paciente o null, si es null no se encuentra el paciente
    public Paciente obtenerPaciente(String cedula) {        
        FileReader fileReader =  null;
        BufferedReader br = null;
        Paciente paciente = null;
        try {
            fileReader =new FileReader(this.file);
            br = new BufferedReader(fileReader);
            String linea = br.readLine();
            while (linea != null) {
                String cedulaEncontrada = linea.split(",")[0];
                if (cedulaEncontrada.equals(cedula)) {
                    String[] datosPaciente = linea.split(",");
                    paciente = new Paciente(datosPaciente[0], datosPaciente[1], Integer.parseInt(datosPaciente[2]), datosPaciente[3]);
                    return paciente;
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
            } catch(IOException ioe) {
                ioe.printStackTrace();
            } catch(Exception e) {
                e.printStackTrace();
            }                                 
        }
        return paciente;
    }
    
    public void registrarPaciente(Paciente paciente) {
        FileWriter fileWriter = null;
        BufferedWriter bw = null;
        String linea = paciente.toString();
        try {
            fileWriter = new FileWriter(this.file, true);
            bw = new BufferedWriter(fileWriter);
            
            bw.write(linea);
            bw.newLine();
            bw.close();
            
        } catch(IOException ioe) {
            ioe.printStackTrace();
        } catch(Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (fileWriter != null) {
                    fileWriter.close();
                }
                if (bw != null) {
                    bw.close();   
                }                
            } catch(Exception e2){
                e2.printStackTrace();
            }            
        }   
    }
    
}
