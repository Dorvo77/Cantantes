package entidades;

import java.util.HashMap;

public class Cantante {
    private String nombre;  // nombre del cantante
    private HashMap<String, Integer> discos; // nombre del disco y cantidad de unidades vendidas

    public Cantante() {
    }

    public Cantante(String nombre, HashMap<String, Integer> discos) {
        this.nombre = nombre;
        this.discos = discos;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public HashMap<String, Integer> getDiscos() {
        return discos;
    }

    public void setDiscos(HashMap<String, Integer> discos) {
        this.discos = discos;
    }

    @Override
    public String toString() {
        return "Cantante{" +
                "nombre='" + nombre + '\'' +
                ", discos=" + discos +
                '}';
    }
}
