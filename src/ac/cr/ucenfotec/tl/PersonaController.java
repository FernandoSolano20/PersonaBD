package ac.cr.ucenfotec.tl;

import ac.cr.ucenfotec.bl.Persona.IPersonaDao;
import ac.cr.ucenfotec.bl.Persona.Persona;
import ac.cr.ucenfotec.bl.factory.DaoFactory;

import java.util.ArrayList;

public class PersonaController {

    private IPersonaDao personaDao;
    private DaoFactory factory;

  public PersonaController(){
        factory    = DaoFactory.getDaoFactory(1);
        personaDao = factory.getpersonaDao();
    }

    public void insertarPersona(String cedula, String nombre, String apellido){
        try {
            Persona persona = new Persona(cedula,nombre,apellido);
            personaDao.insertar(persona);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void modificarPersona(String cedula, String nombre, String apellido){
        try {
            Persona persona = new Persona(cedula,nombre,apellido);
            personaDao.modificar(persona);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void eliminarPersona(String cedula){
        try {
            personaDao.eliminar(cedula);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String[] ListarPersonas(){
        ArrayList<Persona> lista = null;
        String[] listaDatos = null;

        try {
            lista = personaDao.listar();
            listaDatos = new String[lista.size()];

            for(int x =0; x < listaDatos.length ;x++){
                listaDatos[x] = lista.get(x).toString();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listaDatos;
    }
}
