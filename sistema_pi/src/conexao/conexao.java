
package conexao;

    import java.sql.Connection;
    import java.sql.DriverManager;
    import java.sql.SQLException;

    public class conexao {
        public static String URL = "jdbc:mysql://localhost:3306/pi_sistema_escolar";
        public static String USUARIO ="root";
        public static String SENHA="root";

         public static Connection conectar(){
            try{
                Connection conn =
                        DriverManager.getConnection(
                        URL , USUARIO, SENHA);
                System.out.println ("Conectado!");
                return conn;
            }catch(SQLException e){
                System.out.println("Erro na coneção:  ");
                e.printStackTrace();
                return null;
            }
         }
    }