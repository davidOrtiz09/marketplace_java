package model;

public class Usuario {

    public Usuario(Id<Usuario> id, String nombre, String apellido) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
    }

    public Id<Usuario> id ;
    public String nombre;
    public String apellido;

}
