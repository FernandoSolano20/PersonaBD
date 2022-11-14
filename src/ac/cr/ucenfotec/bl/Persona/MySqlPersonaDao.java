package ac.cr.ucenfotec.bl.Persona;

import ac.cr.ucenfotec.dl.AccesoBD;
import ac.cr.ucenfotec.dl.Conector;
import java.sql.ResultSet;
import java.util.ArrayList;

public class MySqlPersonaDao implements IPersonaDao{

    private String sql;

    public void insertar(Persona persona){
        try{
            sql = "INSERT INTO PERSONA VALUES('"+ persona.getNombre() +"','"+ persona.getApellido() +"',"+persona.getCedula()+")";
            AccesoBD acceso = Conector.getConnector();
            acceso.ejecutarSql(sql);
        }
        catch(Exception ex){
            ex.printStackTrace();
        }
    }

    public void modificar(Persona persona){
        try {
            sql = "UPDATE PERSONA SET NOMBRE='" + persona.getNombre() + "', APELLIDO='" + persona.getApellido() + "' WHERE CEDULA='" + persona.getCedula()+"'";
            Conector.getConnector().ejecutarSql(sql);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void eliminar(String cedula){
        try{
            sql="DELETE FROM PERSONA WHERE CEDULA='" + cedula +"'";
            Conector.getConnector().ejecutarSql(sql);
        }
        catch(Exception ex) {
            ex.printStackTrace();
        }
    }

    public ArrayList<Persona> listar() throws Exception {
        ArrayList<Persona> listaPersonas = new ArrayList<>();

        try{
            ResultSet rs = null;
            Persona persona = null;
            sql = "SELECT * FROM PERSONA";
            rs = Conector.getConnector().ejecutarQuery(sql);

            while(rs.next()){
                persona = new Persona(rs.getString("cedula"),
                        rs.getString("nombre"),
                        rs.getString("apellido"));
                listaPersonas.add(persona);
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return listaPersonas;
    }
}
