package UcobetAPP.Dominio;

public class Usuario {
    private int id;
    private String Nombre;
    private String correo;
    private String celular;

    public Usuario(int id, String nombre, String correo, String celular) {
        this.id = id;
        this.Nombre = nombre;
        this.correo = correo;
        this.celular = celular;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }
}
