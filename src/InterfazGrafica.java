import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class InterfazGrafica extends JFrame {
    private JButton btnAgregarRegular, btnAgregarVIP, btnMostrar, btnEliminar, btnSalir;
    private JTextArea textArea;
    private Agenda agenda;

    public InterfazGrafica() {
        agenda = new Agenda();

        setTitle("Agenda Personal");
        setSize(1250, 980);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        btnAgregarRegular = new JButton("Agregar Contacto Regular");
        btnAgregarRegular.setBounds(20, 20, 200, 30);
        add(btnAgregarRegular);

        btnAgregarVIP = new JButton("Agregar Contacto VIP");
        btnAgregarVIP.setBounds(20, 60, 200, 30);
        add(btnAgregarVIP);

        btnMostrar = new JButton("Mostrar Contactos");
        btnMostrar.setBounds(20, 100, 200, 30);
        add(btnMostrar);

        btnEliminar = new JButton("Eliminar Contacto");
        btnEliminar.setBounds(20, 140, 200, 30);
        add(btnEliminar);

        textArea = new JTextArea();
        textArea.setBounds(250, 50, 800, 800);
        add(textArea);

        btnSalir = new JButton("Salir");
        btnSalir.setBounds(20, 180, 200, 30);
        add(btnSalir);

        btnAgregarRegular.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                btnAgregarRegular.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        String nombre = JOptionPane.showInputDialog("Ingrese nombre del contacto regular:");
                        String telefono = JOptionPane.showInputDialog("Ingrese número de teléfono:");

                        Contacto contacto = new Contacto(nombre, telefono);
                        agenda.agregarContacto(contacto);
                        JOptionPane.showMessageDialog(null, "¡Contacto regular agregado exitosamente!");
                    }
                });
            }
        });

        btnAgregarVIP.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                btnAgregarVIP.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        String nombre = JOptionPane.showInputDialog("Ingrese nombre del contacto VIP:");
                        String telefono = JOptionPane.showInputDialog("Ingrese número de teléfono:");
                        String email = JOptionPane.showInputDialog("Ingrese email del contacto VIP:");

                        ContactoVIP contactoVIP = new ContactoVIP(nombre, telefono, email);
                        agenda.agregarContacto(contactoVIP);
                        JOptionPane.showMessageDialog(null, "¡Contacto VIP agregado exitosamente!");
                    }
                });
            }
        });

        btnMostrar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                btnMostrar.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        textArea.setText(""); // Limpiar el área de texto antes de mostrar los contactos

                        ArrayList<Contacto> listaContactos = agenda.getContactos();
                        for (Contacto c : listaContactos) {
                            textArea.append("Nombre: " + c.getNombre() + ", Teléfono: " + c.getTelefono());

                            if (c instanceof ContactoVIP) {
                                ContactoVIP contactoVIP = (ContactoVIP) c;
                                textArea.append(", Email: " + contactoVIP.getEmail());
                            }

                            textArea.append("\n-------------------------------\n");
                        }
                    }
                });
            }
        });

        btnEliminar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String nombreEliminar = JOptionPane.showInputDialog("Ingrese nombre del contacto a eliminar:");

                ArrayList<Contacto> contactos = agenda.getContactos();
                boolean contactoEncontrado = false;
                for (Contacto c : contactos) {
                    if (c.getNombre().equalsIgnoreCase(nombreEliminar)) {
                        agenda.eliminarContacto(c);
                        contactoEncontrado = true;
                        JOptionPane.showMessageDialog(null, "Contacto eliminado correctamente.");
                        break;
                    }
                }

                if (!contactoEncontrado) {
                    JOptionPane.showMessageDialog(null, "Contacto no encontrado.");
                }
            }
        });

        btnSalir.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new InterfazGrafica();
            }
        });
    }
}
