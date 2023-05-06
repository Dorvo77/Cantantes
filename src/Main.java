import Service.CantanteServicio;
import entidades.Cantante;

import java.util.HashSet;

public class Main {
    public static void main(String[] args) {

        System.out.println("Hello Welcome to Disk Sistem ");
        HashSet<Cantante> cantantes = new HashSet<>();
        CantanteServicio cs = new CantanteServicio();
        for (int i = 0; i < 2; i++) {
            cs.cargarCantante(cantantes);
        }
        cs.mostrarCantantes(cantantes);
        cs.menu(cantantes);
    }
}