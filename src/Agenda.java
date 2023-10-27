import java.util.ArrayList;

public class Agenda {
    private ArrayList<Contacto> contactos;

    public Agenda() {
        contactos = new ArrayList<>();
    }

    public void agregarContacto(Contacto contacto) {
        contactos.add(contacto);
    }

    public void eliminarContacto(Contacto contacto) {
        contactos.remove(contacto);
    }

    public ArrayList<Contacto> getContactos() {
        return contactos;
    }

    public void editarContacto(Contacto contacto, String nuevoTelefono) {
        contacto.setTelefono(nuevoTelefono);
    }
}
