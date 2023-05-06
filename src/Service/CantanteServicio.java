package Service;

import entidades.Cantante;


import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;

public class CantanteServicio {
    private Scanner sc = new Scanner(System.in).useDelimiter("\n");
    public void cargarCantante(HashSet<Cantante> cantantes) {
        cantantes.add(crearCantante());
    }

    public Cantante crearCantante(){
        char op;
        HashMap<String, Integer> mapDiscos = new HashMap<>();
        System.out.println("\tIngrese nombre del Artista: ");
        String nom = sc.next();
        do{
            System.out.println("\tIngrese nombre del Disco: ");
            String disc =sc.next();
            System.out.println("\tIngrese cantidad de Discos vendidos: ");
            Integer cant =sc.nextInt();
            mapDiscos.put(disc,cant);
            System.out.println("Desea ingresar otro disco?? (y/n)");
            op = sc.next().charAt(0);
        }while(op!='n');
        return new Cantante(nom, mapDiscos);
    }
    public void mostrarCantantes (HashSet<Cantante> cantantes){
        System.out.println("\t--- Lista de cantantes y discos vendidos ---");
        for (Cantante musico: cantantes) {
            System.out.println(musico);
        }
    }


    public void menu(HashSet<Cantante> cantantes) {
        int opcion = 0;
        while (opcion != 5) {
            System.out.println("\tMENU:");
            System.out.println("1. Alta de musico");
            System.out.println("2. Modificar ventas de discos");
            System.out.println("3. Baja de Musico");
            System.out.println("4. Mostrar Musicos");
            System.out.println("5. Salir");
            System.out.print("> Ingrese Opcion: ");
            opcion = sc.nextInt();

            switch (opcion) {
                case 1 -> cargarCantante(cantantes);
                case 2 -> modificarVenta(cantantes);
                case 3 -> bajaMusico(cantantes);
                case 4 -> mostrarCantantes(cantantes);
                case 5 -> System.out.println("Exit.....");
                default -> System.out.println("Ingrese opcion valida");
            }
        }
    }
    public void modificarVenta(HashSet<Cantante> cantantes) {
        boolean flag = false;
        System.out.println("\t>MODIFICACION DE VENTAS DE DISCO");
        System.out.println("> Ingrese nombre del músico:");
        String nombuscar = sc.next();
        for (Cantante musico: cantantes) {
            if(musico.getNombre().equalsIgnoreCase(nombuscar)){
                System.out.println("> Musico encontrado!!!");
                System.out.println(musico.getDiscos());
                System.out.println("Ingrese el disco a modificar ");
                String nomdisc = sc.next();
                System.out.println("Ingrese la nueva cantidad de discos vendidos total");
                Integer nuevacantidad = sc.nextInt();
                HashMap<String, Integer> aux = musico.getDiscos();
                for (Map.Entry<String, Integer> entry: aux.entrySet()) {
                    if(entry.getKey().equalsIgnoreCase(nomdisc)){
                        System.out.println("> Disco encontrado");
                        aux.put(nomdisc, nuevacantidad);
                        musico.setDiscos(aux);
                    }
                }
                flag=true;
                break;
            }

        }
        if(!flag){
            System.out.println("El musico ingresado, no se encuentra en la lista.. :(");
        }

    }
    public void bajaMusico(HashSet<Cantante> cantantes){
        boolean flag = false;
        System.out.println("\t>BAJA DE MUSICO");
        System.out.println("> Ingrese nombre del músico:");
        String nombuscar = sc.next();
        for (Cantante musico: cantantes) {
            if(musico.getNombre().equalsIgnoreCase(nombuscar)){
                System.out.println("> Musico encontrado, se procede a dar de baja !!!");
                cantantes.remove(musico);
                flag=true;
                break;
            }

        }
        if(!flag){
            System.out.println("El musico ingresado, no se encuentra en la lista.. :(");
        }
        System.out.println("\t>---- Lista actualizada ----->");
        mostrarCantantes(cantantes);
    }
}



