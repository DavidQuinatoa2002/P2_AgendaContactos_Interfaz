public class ContactoVIP extends Contacto {
    private String email;

    public ContactoVIP(String nombre, String telefono, String email) {
        super(nombre, telefono);
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
