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
import principal.Medico;

/**
 *
 * @author Frankz
 */
public class MedicosPersistencia {
    private File file;
    
    public MedicosPersistencia() {
        this.file = new File("db/medicos.txt");
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
    public Medico obtenerMedico(String cedula) {        
        FileReader fileReader =  null;
        BufferedReader br = null;
        Medico medico = null;
        try {
            fileReader =new FileReader(this.file);
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
        return medico;
    }
    
    public void registrarMedico(Medico medico) {
        FileWriter fileWriter = null;
        BufferedWriter bw = null;
        String linea = medico.toString();
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
