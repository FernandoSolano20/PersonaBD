package ac.cr.ucenfotec.bl.Persona;

import java.util.ArrayList;

public interface IPersonaDao {
    public void insertar(Persona persona) throws Exception;
    public void modificar(Persona persona) throws Exception;;
    public void eliminar(String cedula)throws Exception;;
    public ArrayList<Persona> listar()throws Exception;;
}
