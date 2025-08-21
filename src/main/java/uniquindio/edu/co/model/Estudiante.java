package uniquindio.edu.co.model;

public class Estudiante {
    private String id,nombre,apellido,email,telefono;
    private int edad;
    public Estudiante (String nombre, String apellido, String email, String telefono, String id, int edad) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.telefono = telefono;
        this.edad = edad;
        this.id = id;
    }


    @Override
    public String toString() {
        return "Estudiante{" +
                "id='" + id + '\'' +
                ", nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", email='" + email + '\'' +
                ", telefono='" + telefono + '\'' +
                ", edad=" + edad +
                '}';
    }

    public String getId(){
        return id;
    }
}
