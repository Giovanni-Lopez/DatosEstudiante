package datosestudiante;

import java.sql.*;

/**
 *
 * @author Giovanni López
 */
public class ConexionCRUD {
    
    private final String servidor = "jdbc:mysql://127.0.0.1:3308/base_institucion";
    
    private final String usuario = "root";
    
    private final String clave = "";
    
    private final String driverConector = "com.mysql.jdbc.Driver";
    
    private static Connection conexion;
    
    public ConexionCRUD(){
        try{
            Class.forName(driverConector);
            
            conexion = DriverManager.getConnection(servidor, usuario, clave); 
            
        }catch(ClassNotFoundException | SQLException e){
            System.out.println("Conexion fallida! Error: " + e.getMessage());
        }
    }
    
    public Connection getConnetion(){
        return conexion;
    }
    
    public void guardarRegistros(String tabla, String camposTabla, String valoresCampos){
        ConexionCRUD conectar = new ConexionCRUD();
        Connection cone = conectar.getConnetion();
        try{
            String sqlQueryStmt = "INSERT INTO " + tabla + " (" + camposTabla + ") VALUES (" + valoresCampos + ");";
            
            Statement stmt;
            stmt = cone.createStatement();
            stmt.executeUpdate(sqlQueryStmt);
            
            stmt.close();
            cone.close();
            
            System.out.println("Registro guardado correctamente!");
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        
    }
    
    public void actualizarEliminarRegistro(String tabla, String valoresCamposNuevos, String condicion){
        ConexionCRUD conectar = new ConexionCRUD();
        Connection cone = conectar.getConnetion();
        try{
            Statement stmt;
            String sqlQueryStmt;
            
            if(valoresCamposNuevos.isEmpty()){
                sqlQueryStmt= "DELETE FROM " + tabla + " WHERE " + condicion + ";";                
            }else{
                sqlQueryStmt = "UPDATE " + tabla + " SET " + valoresCamposNuevos + " WHERE " + condicion + ";";
            }
            stmt = cone.createStatement();
            stmt.executeUpdate(sqlQueryStmt);
            stmt.close();
            cone.close();
        }catch(SQLException ex){
            System.out.println("Ha ocurrido el siguiente error: " + ex.getMessage());            
        }
    }
    
    public void desplegarRegistros(String tablaBuscar, String camposBuscar, String condicionBuscar) throws SQLException{
        ConexionCRUD conectar = new ConexionCRUD();
        Connection cone = conectar.getConnetion();
        
        try {
            Statement stmt;
            String sqlQueryStmt;
            if(condicionBuscar.equals("")){
                sqlQueryStmt = "SELECT " + camposBuscar + " FROM " + tablaBuscar + ";";
            }else{
                sqlQueryStmt = "SELECT " + camposBuscar + " FROM " + tablaBuscar + " WHERE " + condicionBuscar;
            }
            stmt = cone.createStatement();
            stmt.executeQuery(sqlQueryStmt);
            
            try (ResultSet miResultSet = stmt.executeQuery(sqlQueryStmt)){
                if(miResultSet.next()){
                    ResultSetMetaData metaData = miResultSet.getMetaData();
                    int numColumnas = metaData.getColumnCount();
                    System.out.println("<< REGISTROS ALMACENADOS >>");
                    System.out.println();
                    
                    for (int i = 1; i <= numColumnas; i++) {
                        System.out.printf("%-20s\t", metaData.getColumnName(i));
                    }
                    System.out.println();
                    do {                        
                        for (int i = 1; i <= numColumnas; i++) {
                            System.out.printf("%-20s\t", miResultSet.getObject(i));
                        }
                        System.out.println();
                    } while (miResultSet.next());
                    System.out.println();
                }else{
                    System.out.println("No se han encontrado registros");
                }
                miResultSet.close();                                
            }finally {
                stmt.close();
                cone.close();
            }
        } catch (SQLException ex) {
            System.out.println("Ha ocurrido el siguiente error: " + ex.getMessage());
        }
    }                    
}   

