package ac.cr.ucenfotec.ui;

import ac.cr.ucenfotec.tl.PersonaController;
import java.io.*;


public class MainUI {

    static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    static PrintStream   out = System.out;
    static PersonaController personaController = new PersonaController();

    public static void main (String args[]){
        try {
            mostrarMenu();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    public static void mostrarMenu() throws IOException {
        int opcion;
        opcion = -1;
        do{
            out.println("1. Listar Personas");
            out.println("2. Registrar Persona");
            out.println("3. Modificar Persona ");
            out.println("4. Eliminar Persona ");
            out.println("0. Salir");
            out.print("Digite la opción que desee: ");
            opcion = Integer.parseInt(in.readLine());
            procesarOpcion(opcion);
        }while(opcion != 0);
    }
    //Rutina para procesar la opción seleccionada por el usuario
    public static void procesarOpcion(int pOpcion)
            throws IOException{
        switch(pOpcion){
            case 1:
                listar();
                break;
            case 2:
                registrar();
                break;
            case 3:
                modificar();
                break;
            case 4:
                eliminar();
                break;
            case 0:
                out.println("Adiós");
                break;
            default:
                out.println("Opción inválida");
        }
    }

    private static void modificar() throws IOException {
        System.out.print("Ingrese la cedula de la persona a modificar: ");
        String cedula = in.readLine();
        System.out.print("Ingrese el nuevo nombre: ");
        String nombre = in.readLine();
        System.out.print("Ingrese el nuevo apellido: ");
        String apellido = in.readLine();

        personaController.modificarPersona(cedula,nombre,apellido);
    }

    private static void eliminar() throws IOException {
        System.out.print("Ingrese la cedula de la persona a eliminar: ");
        String cedula = in.readLine();
        personaController.eliminarPersona(cedula);
    }

    private static void listar() {
       String[]lista = personaController.ListarPersonas();
        for (String personaInfo:lista) {
            System.out.println(personaInfo.toString());
        }
    }

    public  static void registrar()
    {
        try {
            System.out.print("Ingrese la cedula:");
            String cedula = in.readLine();
            System.out.print("Ingrese el nombre:");
            String nombre = in.readLine();
            System.out.print("Ingrese el apellido:");
            String apellido = in.readLine();

            personaController.insertarPersona(cedula,nombre,apellido);

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

}
