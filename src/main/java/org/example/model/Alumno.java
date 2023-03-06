package org.example.model;


import javax.persistence.Entity;

@Entity
public class Alumno {

    String nombre;
    String telefono;
    String email;
    Double notaAD;
    Double notaDI;

    public Alumno(String nombre, String telefono, String email, Double notaAD, Double notaDI) {
        this.nombre = nombre;
        this.telefono = telefono;
        this.email = email;
        this.notaAD = notaAD;
        this.notaDI = notaDI;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Double getNotaAD() {
        return notaAD;
    }

    public void setNotaAD(Double notaAD) {
        this.notaAD = notaAD;
    }

    public Double getNotaDI() {
        return notaDI;
    }

    public void setNotaDI(Double notaDI) {
        this.notaDI = notaDI;
    }

    @Override
    public String toString() {
        return "Alumno{" +
                "nombre='" + nombre + '\'' +
                ", telefono='" + telefono + '\'' +
                ", email='" + email + '\'' +
                ", notaAD=" + notaAD +
                ", notaDI=" + notaDI +
                '}';
    }
}
