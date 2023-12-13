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
        System.out.println("1. Agregar contacto regular");
        System.out.println("2. Agregar contacto VIP");
        System.out.println("3. Eliminar contacto");
        System.out.println("4. Mostrar contactos");
        System.out.println("5. Editar contacto");
        System.out.println("6. Salir");
        System.out.println("-------------------------------");
        System.out.print("Porfavor, seleccione una opción: ");
    }

    public void ejecutarOpcion(int opcion) {
        switch (opcion) {
            case 1:
                System.out.print("Ingrese nombre del contacto regular: ");
                String nombreRegular = scanner.next();
                System.out.print("Ingrese número de teléfono: ");
                String telefonoRegular = scanner.next();
                Contacto contactoRegular = new Contacto(nombreRegular, telefonoRegular);
                agenda.agregarContacto(contactoRegular);
                System.out.println("¡Contacto regular agregado exitosamente!");
                break;
            case 2:
                System.out.print("Ingrese nombre del contacto VIP: ");
                String nombreVIP = scanner.next();
                System.out.print("Ingrese número de teléfono: ");
                String telefonoVIP = scanner.next();
                System.out.print("Ingrese email del contacto VIP: ");
                String emailVIP = scanner.next();
                ContactoVIP contactoVIP = new ContactoVIP(nombreVIP, telefonoVIP, emailVIP);
                agenda.agregarContacto(contactoVIP);
                System.out.println("¡Contacto VIP agregado exitosamente!");
                break;
            case 3:
                System.out.print("Ingrese nombre del contacto a eliminar: ");
                String nombreEliminar = scanner.next();
                ArrayList<Contacto> contactos = agenda.getContactos();
                for (Contacto c : contactos) {
                    if (c.getNombre().equals(nombreEliminar)) {
                        agenda.eliminarContacto(c);
                        System.out.println("Contacto eliminado.");
                        System.out.println("-------------------------------");
                        return;
                    }
                }
                System.out.println("Contacto no encontrado.");
                break;
            case 4:
                ArrayList<Contacto> listaContactos = agenda.getContactos();
                for (Contacto c : listaContactos) {
                    System.out.print("Nombre: " + c.getNombre() + ", Teléfono: " + c.getTelefono());
                    if (c instanceof ContactoVIP) {
                        contactoVIP = (ContactoVIP) c;
                        System.out.print(", Email: " + contactoVIP.getEmail());
                    }
                    System.out.println();
                    System.out.println("-------------------------------");
                }
                break;
            case 5:
                System.out.print("Ingrese nombre del contacto a editar: ");
                String nombreEditar = scanner.next();
                System.out.print("Ingrese nuevo número de teléfono: ");
                String nuevoTelefono = scanner.next();
                ArrayList<Contacto> contactosEditar = agenda.getContactos();
                for (Contacto c : contactosEditar) {
                    if (c.getNombre().equals(nombreEditar)) {
                        agenda.editarContacto(c, nuevoTelefono);
                        System.out.println("Contacto editado.");
                        System.out.println("-------------------------------");
                        return;
                    }
                }
                System.out.println("Contacto no encontrado.");
                break;
            case 63:
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
    public void Ejecucion() {
        while (true) {
            mostrarMenu();
            int opcion = Integer.parseInt(scanner.next());
            ejecutarOpcion(opcion);
        }
    }
}

