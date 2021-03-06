package datosestudiante;

import java.sql.SQLException;
import java.util.Scanner;

/**
 *
 * @author Giovanni López
 */
public class Delete {
    Delete() throws SQLException{
        Scanner leer = new Scanner(System.in);
        ConexionCRUD utilerias = new ConexionCRUD();
        System.out.println("<< ELIMINAR REGISTROS >>");
        
        System.out.println("Ingresar el id del registro: ");
        String idContactoEliminar = leer.next();
        
        String tabla = "tb_estudiante";
        String campos = "*";
        String condicion  = "id_estudiante = " +  idContactoEliminar;
        utilerias.desplegarRegistros(tabla, campos, condicion);
        
        System.out.println("Preciona << Y >> para confirmar: ");
        String confirmarBorrar = leer.next();
        
        if("Y".equals(confirmarBorrar)){
            String valoresCamposNuevos = "";
            
            utilerias.actualizarEliminarRegistro(tabla, valoresCamposNuevos, condicion);
            System.out.println("Registro borrado satifactoriamente!");            
        }
        MenuPrincipal.desplegarMenu();
    }
}
