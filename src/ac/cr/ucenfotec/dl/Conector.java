package ac.cr.ucenfotec.dl;

public class Conector {

    private static AccesoBD conectorBD = null;

    private static final String URL_MYSQL = "jdbc:mysql://localhost/universidad?useSSL=false";
    private static final String URL_SQLSERVER = "jdbc:sqlserver://localhost;databaseName=universidad";

    public static  AccesoBD getConnector() throws Exception{
        if(conectorBD == null) {
            conectorBD = new AccesoBD("com.mysql.jdbc.Driver", URL_MYSQL,"prueba", "1qaz2wsx3edc");
        }
        return conectorBD;
    }
}
