/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package principal;

import persistencia.MedicosPersistencia;

/**
 *
 * @author Frankz
 */
public class Login {
    
    private String usuario; // El usuario sera la cedula
    private String contrasenia;
    private String tipoUsuario;
    
    private MedicosPersistencia medicoPersistencia = new MedicosPersistencia();        

      
    public void validarCredenciales(){
        if(usuario.equals("") || contrasenia.equals("")){
            System.out.println("Credenciales erroneas");
        }else{
            if(tipoUsuario.equals("")){
                System.out.println("Eliga el tipo de usuario");
            }else{
                /*if(usuario.equals(medicoPersistencia.nombreUsuario) && contrasenia.equals(medicoPersistencia.contrasenia)){
                    System.out.println("Acceso Exitoso");
                }else{
                    System.out.println("Acceso Denegado");
                }*/
            }
        }
    }
    
    
    
}
