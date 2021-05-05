package datosestudiante;

import java.sql.SQLException;
import java.util.Scanner;

/**
 *
 * @author Giovanni López
 */
public class Update {
    Update() throws SQLException{
        Scanner leer = new Scanner(System.in);
        Estudiantes est = new Estudiantes();
        ConexionCRUD utilerias = new ConexionCRUD();
        
        System.out.println("<< ACTUALIZAR REGISTROS >>");
        
        System.out.println("Ingresar id del registro a modificar: ");
        est.setId_estudiante(leer.nextInt());
        
        String tablaBuscar = "tb_estudiante";
        String camposBuscar = "id_estudiante, carnet_estudiante, nom_estudiante, ape_estudiante, edad_estudiante";
        String condicionBuscar = "id_estudiante = " + est.getId_estudiante();
        utilerias.desplegarRegistros(tablaBuscar, camposBuscar, condicionBuscar);
        
        System.out.println("Carnet: ");
        est.setCarnet_estudiante(leer.next());
        
        System.out.println("Nombres: ");
        est.setNom_estudiante(leer.next());
        
        System.out.println("Apellidos: ");
        est.setApe_estudiante(leer.next());
        
        System.out.println("Edad: ");
        est.setEdad_estudiante(leer.nextInt());
        
        String tabla = "tb_estudiante";
        String camposValoresNuevos = "carnet_estudiante = '" + est.getCarnet_estudiante() + "', nom_estudiante= '" + est.getNom_estudiante() 
                                    + "', ape_estudiante = '" + est.getApe_estudiante() + "', edad_estudiante= '" + est.getEdad_estudiante() + "'";
        
        utilerias.actualizarEliminarRegistro(tabla, camposValoresNuevos, condicionBuscar);
        System.out.println("Modificado correctamente!");
        MenuPrincipal.desplegarMenu();        
    }
}
