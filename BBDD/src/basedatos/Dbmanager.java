package basedatos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Dbmanager {
	// Conexión a la base de datos
    public static Connection conn = null;

    // Configuración de la conexión a la base de datos
    private static final String DB_HOST = "localhost";
    private static final String DB_PORT = "3306";
    private static final String DB_NAME = "dam";
    private static final String DB_URL = "jdbc:mysql://" + DB_HOST + ":" + DB_PORT + "/" + DB_NAME + "?serverTimezone=UTC";
    private static final String DB_USER = "mario";
    private static final String DB_PASS = "mario";
    private static final String DB_MSQ_CONN_OK = "CONEXIÓN CORRECTA";
    private static final String DB_MSQ_CONN_NO = "ERROR EN LA CONEXIÓN";

    // Configuración de la tabla Clientes
    private static final String DB_CLI = "clientes";
    private static final String DB_VEN = "ventas";
    private static final String DB_PRO = "productos";
    private static final String DB_CLI_SELECT = "SELECT * FROM ";
    private static final String DB_CLI_ID = "id";
    private static final String DB_CLI_NOM = "nombre";
    private static final String DB_CLI_DIR = "direccion";
    
    
    
    /**
     * Intenta cargar el JDBC driver.
     * @return true si pudo cargar el driver, false en caso contrario
     */
    public static boolean loadDriver() {
        try {
            System.out.print("Cargando Driver...");
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("OK!");
            return true;
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
            return false;
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }
 
    /**
     * Intenta conectar con la base de datos.
     *
     * @return true si pudo conectarse, false en caso contrario
     */
     public static boolean connect() {
        try {
            System.out.print("Conectando a la base de datos...");
            conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS);
            System.out.println("OK!");
            return true;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }
    
     /**
      * Comprueba la conexión y muestra su estado por pantalla
      *
      * @return true si la conexión existe y es válida, false en caso contrario
      */
     public static boolean isConnected() {
         // Comprobamos estado de la conexión
         try {
             if (conn != null && conn.isValid(0)) {
                 System.out.println(DB_MSQ_CONN_OK);
                 return true;
             } else {
                 return false;
             }
         } catch (SQLException ex) {
             System.out.println(DB_MSQ_CONN_NO);
             ex.printStackTrace();
             return false;
         }
     }

     /**
      * Cierra la conexión con la base de datos
      */
     public static void close() {
         try {
             System.out.print("Cerrando la conexión...");
             conn.close();
             System.out.println("OK!");
         } catch (SQLException ex) {
             ex.printStackTrace();
         }
     }
   
    
    
    
    
    
    
}
