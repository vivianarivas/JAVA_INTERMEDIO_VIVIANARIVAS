package com.tf_vivianarivas;

import com.tf_vivianarivas.controller.EquipoController;
import static com.tf_vivianarivas.controller.EquipoTemplate.updateEquipo;

import java.util.Scanner;

public class Main{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcion;

        do {
            menu();
            System.out.print("Elija una opción: ");
            opcion = scanner.nextInt();
            manejarOpcion(opcion);
        } while (opcion != 0);
        scanner.close();
    }

    public static void menu() {
        System.out.println("");
        System.out.println("------ Menú ------");
        System.out.println("Seleccione la operacioón a realizar");
        System.out.println("1: Mostrar Equipos");
        System.out.println("2: Agregar Equipo");
        System.out.println("3: Borrar Equipo");
        System.out.println("4: Actualizar Equipo");
        System.out.println("0: Salir");
        System.out.println("------------------");
    }

    public static void manejarOpcion(int opcion) {
        switch (opcion) {
            case 1:
                System.out.println("Mostrar Equipos - Opción 1");
                EquipoController.mostrarEquipos();
                break;
            case 2:
                System.out.println("Agregar Equipo - Opción 2");
                EquipoController.insertEquipo();
                break;
            case 3:
                System.out.println("Borrar Equipo - Opción 3");
                EquipoController.deleteEquipo();
                break;
            case 4:
                System.out.println("Actualizar Equipo - Opción 4");
                EquipoController.updateEquipo();
                break;
            case 0:
                System.out.println("Cerrando la aplicacion - Opción 5");
                break;
            default:
                System.out.println("Opción Incorrecta. Por favor, elija una opción válida (1 al 5.");
                break;
        }
    }
}
