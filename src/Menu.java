import java.util.ArrayList;
import java.util.Scanner;

public class Menu {
    private Scanner scanner;
    private Agenda agenda;

    public Menu() {
        scanner = new Scanner(System.in);
        agenda = new Agenda();
    }

    public void mostrarMenu() {
        System.out.println("-----BIENVENDIO A SU AGENDA PERSONAL------");
        System.out.println("1. Agregar contacto");
        System.out.println("2. Eliminar contacto");
        System.out.println("3. Mostrar contactos");
        System.out.println("4. Editar contacto");
        System.out.println("5. Salir");
        System.out.print("Porfavor, seleccione una opción: ");
    }

    public void ejecutarOpcion(int opcion) {
        switch (opcion) {
            case 1:
                System.out.print("Ingrese nombre del contacto: ");
                String nombre = scanner.next();
                System.out.print("Ingrese número de teléfono: ");
                String telefono = scanner.next();
                Contacto contacto = new Contacto(nombre, telefono);
                agenda.agregarContacto(contacto);
                break;
            case 2:
                System.out.print("Ingrese nombre del contacto a eliminar: ");
                String nombreEliminar = scanner.next();
                ArrayList<Contacto> contactos = agenda.getContactos();
                for (Contacto c : contactos) {
                    if (c.getNombre().equals(nombreEliminar)) {
                        agenda.eliminarContacto(c);
                        System.out.println("Contacto eliminado.");
                        return;
                    }
                }
                System.out.println("Contacto no encontrado.");
                break;
            case 3:
                ArrayList<Contacto> listaContactos = agenda.getContactos();
                for (Contacto c : listaContactos) {
                    System.out.println("Nombre: " + c.getNombre() + ", Teléfono: " + c.getTelefono());
                    System.out.println("¡Contacto agregado exitosamente!");
                }
                break;
            case 4:
                System.out.print("Ingrese nombre del contacto a editar: ");
                String nombreEditar = scanner.next();
                System.out.print("Ingrese nuevo número de teléfono: ");
                String nuevoTelefono = scanner.next();
                ArrayList<Contacto> contactosEditar = agenda.getContactos();
                for (Contacto c : contactosEditar) {
                    if (c.getNombre().equals(nombreEditar)) {
                        agenda.editarContacto(c, nuevoTelefono);
                        System.out.println("Contacto editado.");
                        return;
                    }
                }
                System.out.println("Contacto no encontrado.");
                break;
            case 5:
                System.out.println("¡Agenda Cerrada!");
                System.exit(0);
                break;
            default:
                System.out.println("Opción no válida. Inténtelo de nuevo.");
        }
    }
    public Scanner getScanner() {
        return scanner;
    }
}

