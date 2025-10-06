package uniquindio.edu.co;

import uniquindio.edu.co.model.Curso;
import uniquindio.edu.co.model.Estudiante;

public class Main {
    public static void main(String[] args) {
        Curso curso = new Curso("Programación I", 123); // Invoke Class

        Estudiante student = new Estudiante("Raul", "Rivera", "Email", "+57123", "ABD123", 20);
        Estudiante student2 = new Estudiante("Raul", "Rivera", "Email", "+57123", "ABD123", 20);
        curso.agregarEstudiante(student);
        curso.agregarEstudiante(student2);// calling a fun inside a class
        System.out.println(curso.toString());
       // System.out.println(student.toString());
        }
    }