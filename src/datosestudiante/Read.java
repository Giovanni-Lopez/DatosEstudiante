package datosestudiante;

import java.sql.SQLException;

/**
 *
 * @author Giovanni López
 */
public class Read {
    public Read() throws SQLException{
        System.out.println("<< CONSULTA DE REGISTROS >>");
        mostrarResultados();
    }
    private void mostrarResultados() throws SQLException{
        try {
            ConexionCRUD utileria = new ConexionCRUD();
            String tabla = "tb_estudiante";
            String camposTabla = "*";
            
            String condicionBusqueda = "";
            
            utileria.desplegarRegistros(tabla, camposTabla, condicionBusqueda);
        } catch (SQLException ex) {
            System.out.println("Ha ocurrido el siguiente error: " + ex.getMessage());
        }finally{
            MenuPrincipal.desplegarMenu();
        }
    }
}
