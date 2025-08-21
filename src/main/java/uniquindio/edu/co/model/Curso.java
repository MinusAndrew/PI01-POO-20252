package uniquindio.edu.co.model;

import java.util.ArrayList;
import java.util.List;

public class Curso {

    private String nombre;
    private int id;
    public List<Estudiante> listEstudiante;

    public boolean verificarStudent(Estudiante estudiante){
        // sentinel or flag
        boolean flag = false;
        for (Estudiante student : listEstudiante){
            if (student.getId().equals(estudiante.getId())){
                flag = true; // ya existe con la misma id
            }
        }
        return flag;
    }

    public Curso(String nombre, int id){
        this.id = id;
        this.nombre = nombre;
        this.listEstudiante = new ArrayList<>(); // crear lista para almacenar estudiantes
    }

    public void agregarEstudiante(Estudiante estudiante){
        if (!verificarStudent(estudiante)){

        }
        listEstudiante.add(estudiante); // añadir estudiante a la lista
    }

    @Override
    public String toString() {
        return "Curso{" +
                "nombre='" + nombre + '\'' +
                ", id=" + id +
                ", listEstudiante=" + listEstudiante +
                '}';
    }
}
