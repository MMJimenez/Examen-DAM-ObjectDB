package org.example.controller;

import org.example.model.Alumno;
import org.example.util.ObjectDBUtils;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.List;

public class AlumnoDAO {

    public AlumnoDAO() {
    }

    public void insertarAlumno(Alumno alumno) {
        EntityManagerFactory emf = ObjectDBUtils.getEntityManagerFactory();
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(alumno);
        em.getTransaction().commit();
        em.close();
        emf.close();

        System.out.println("insertarAlumno() resultados:");
        System.out.println(alumno.toString());
    }

    public void listarTodo() {
        EntityManagerFactory emf = ObjectDBUtils.getEntityManagerFactory();
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        TypedQuery<Alumno> query = em.createQuery("SELECT a FROM Alumno a", Alumno.class);
        List<Alumno> results = query.getResultList();
        em.close();
        emf.close();

        System.out.println("listarTodo() resultados:");
        for (Alumno alumno : results) {
            System.out.println(alumno.toString());
        }
    }

    public void listarSuspensos() {
        EntityManagerFactory emf = ObjectDBUtils.getEntityManagerFactory();
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        TypedQuery<Alumno> query = em.createQuery("SELECT a FROM Alumno a WHERE a.notaAD < 5 OR a.notaDI < 5", Alumno.class);
        List<Alumno> results = query.getResultList();
        em.close();
        emf.close();
        System.out.println("listarSuspensos() resultados:");
        for (Alumno alumno : results) {
            System.out.println(alumno.toString());
        }
    }

    public void estadisticas() {
        EntityManagerFactory emf = ObjectDBUtils.getEntityManagerFactory();
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        Query queryMediaAD = em.createQuery("SELECT AVG(a.notaAD) FROM Alumno a");
        Double mediaAD = (Double) queryMediaAD.getSingleResult();
        Query queryMediaDI = em.createQuery("SELECT AVG(a.notaDI) FROM Alumno a");
        Double mediaDI = (Double) queryMediaDI.getSingleResult();
        Query queryCount = em.createQuery("SELECT COUNT(a) FROM Alumno a");
        Long numAlumnos = (Long) queryCount.getSingleResult();
        Query queryCountSuspensos = em.createQuery("SELECT COUNT(a) FROM Alumno a WHERE a.notaAD < 5 OR a.notaDI < 5");
        Long numAlumnosSuspensos = (Long) queryCountSuspensos.getSingleResult();
        double ratio = (double)(numAlumnos - numAlumnosSuspensos) / numAlumnos;

        System.out.println("estadisticas() resultados:");
        System.out.println("Media AD: " + String.format("%.2f", mediaAD));
        System.out.println("Media DI: " + String.format("%.2f", mediaDI));
        System.out.println("Número de alumnos sin suspensos: " + (numAlumnos - numAlumnosSuspensos));
        System.out.println("Número de total de alumnos alumnos: " + numAlumnos);
        System.out.println("Ratio de aprobados: " + String.format("%.2f", ratio));
    }

}
