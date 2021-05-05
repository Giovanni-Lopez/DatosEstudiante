package datosestudiante;

import java.sql.SQLException;
import java.util.Scanner;

/**
 *
 * @author Giovanni López
 */
public class Create {
    Create() throws SQLException{
        Scanner leer = new Scanner(System.in);
        Estudiantes est = new Estudiantes();
        System.out.println("<< CREAR REGISTRO >>");
        
        System.out.println("Carnet: ");
        est.setCarnet_estudiante(leer.nextLine());
        
        System.out.println("Nombres: ");
        est.setNom_estudiante(leer.nextLine());
        
        System.out.println("Apellidos: ");
        est.setApe_estudiante(leer.nextLine());
        
        System.out.println("Edad: ");
        est.setEdad_estudiante(Integer.parseInt(leer.nextLine()));
        
        String tabla = "tb_estudiante";
        String camposTabla = "carnet_estudiante, nom_estudiante, ape_estudiante, edad_estudiante";
        String valoresCampos = "'" + est.getCarnet_estudiante() + "','" + est.getNom_estudiante() + "','" + 
                                     est.getApe_estudiante() + "','" + est.getEdad_estudiante() + "'";
        
        ConexionCRUD utilerias = new ConexionCRUD();        
        utilerias.guardarRegistros(tabla, camposTabla, valoresCampos);        
        MenuPrincipal.desplegarMenu();                
    }
}
