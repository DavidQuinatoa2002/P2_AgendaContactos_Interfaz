import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Menu menu = new Menu();
        Scanner scanner = menu.getScanner();

        while (true) {
            menu.mostrarMenu();
            int opcion = Integer.parseInt(scanner.next());
            menu.ejecutarOpcion(opcion);
        }
    }
}
