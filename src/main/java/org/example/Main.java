package org.example;

import org.example.controller.AlumnoDAO;
import org.example.model.Alumno;

import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        var alumnoDAO = new AlumnoDAO();

        var alumno1 = new Alumno("Juana Serrano", "726369361", "juana_serrano721@gmail.com", 6.57, 2.19);

        alumnoDAO.insertarAlumno(alumno1);
        System.out.println("");
        alumnoDAO.listarTodo();
        System.out.println("");
        alumnoDAO.listarSuspensos();
        System.out.println("");
        alumnoDAO.estadisticas();
    }
}