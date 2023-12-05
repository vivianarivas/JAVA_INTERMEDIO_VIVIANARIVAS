package com.tf_vivianarivas.controller;

import com.tf_vivianarivas.dao.EquipoDAO;
import com.tf_vivianarivas.model.Equipo;

import java.util.List;
import java.util.Scanner;

public class EquipoController extends EquipoTemplate {

    public EquipoController() {
    }


    public static void mostrarEquipos() {
        EquipoDAO equipoDAO = new EquipoDAO();
        List<com.tf_vivianarivas.model.Equipo> listaEquipos = equipoDAO.obtenerTodosLosEquipos();

        System.out.println("------------------------------------------------------------------------------------");
        System.out.println(String.format("%-2s %-23s %-9s %-9s %-20s %-6s %-8s",
                "ID", "Nombre del Equipo", "Titulares", "Suplentes", "Director Técnico", "Puntos", "Partidos"));
        System.out.println("------------------------------------------------------------------------------------");
        listaEquipos.forEach(equipo -> System.out.println(
                String.format("%-2d %-23s %-9d %-9d %-20s %-6d %-8d",
                        equipo.getIdEquipo(),
                        equipo.getNombreEquipo(),
                        equipo.getTitulares(),
                        equipo.getSuplentes(),
                        equipo.getDirectorTec(),
                        equipo.getPuntos(),
                        equipo.getPartidosJugados()
                )));
    }

    public static void insertEquipo() {

        EquipoDAO equipoDAO = new EquipoDAO();
        Equipo nuevoEquipo = new Equipo() {
            @Override
            protected int getResultado(int partido) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
        };
        Scanner scanner = new Scanner(System.in);

        System.out.print("Ingrese el nombre del equipo: ");
        String nombreEquipo = scanner.nextLine();
        nuevoEquipo.setNombreEquipo(nombreEquipo);

        System.out.print("Ingrese la cantidad de jugadores titulares: ");
        while (!scanner.hasNextInt()) {
            System.out.println("Numero inválido. Solo se permiten valores entre 0 y 11.");
            System.out.print("Ingrese la cantidad de jugadores titulares: ");
            scanner.next();
        }
        int titulares = scanner.nextInt();
        while (titulares < 0 || titulares > 11) {
            System.out.println("La cantidad de jugadores titulares pueden ser entre 0 y 11.");
            System.out.print("Ingrese la cantidad de jugadores titulares: ");

            while (!scanner.hasNextInt()) {
                System.out.println("Numero inválido. Solo se permiten valores entre 0 y 11.");
                System.out.print("Ingrese la cantidad de jugadores titulares: ");
                scanner.next();
            }
            titulares = scanner.nextInt();
        }
        nuevoEquipo.setTitulares(titulares);

        System.out.print("Ingrese la cantidad de jugadores suplentes: ");
        while (!scanner.hasNextInt()) {
            System.out.println("Numero inválido. Solo se permiten valores entre 0 y 11.");
            System.out.print("Ingrese la cantidad de jugadores suplentes: ");
            scanner.next();
        }
        int suplentes = scanner.nextInt();
        while (suplentes < 0 || suplentes > 11) {
            System.out.println("La cantidad de jugadores suplentes debe ser entre 0 y 11.");
            System.out.print("Ingrese la cantidad de jugadores suplentes: ");

            while (!scanner.hasNextInt()) {
                System.out.println("Numero inválido. Solo se permiten valores entre 0 y 11.");
                System.out.print("Ingrese la cantidad de jugadores suplentes: ");
                scanner.next();
            }
            suplentes = scanner.nextInt();
        }
        nuevoEquipo.setSuplentes(suplentes);

        System.out.print("Ingrese el nombre del director técnico del Equipo: ");
        scanner.nextLine();
        String directorTecnico = scanner.nextLine();
        nuevoEquipo.setDirectorTec(directorTecnico);

        System.out.print("Ingrese la cantidad de puntos del Equipo: ");
        while (!scanner.hasNextInt()) {
            System.out.println("Numero inválido. Por favor, ingrese un número entero.");
            System.out.print("Ingrese la cantidad de puntos del Equipo: ");
            scanner.next();
        }
        int puntos = scanner.nextInt();
        nuevoEquipo.setPuntos(puntos);

        System.out.print("Ingrese la cantidad de partidos jugados por el Equipo: ");
        while (!scanner.hasNextInt()) {
            System.out.println("Numero inválido. Por favor, ingrese un número entero.");
            System.out.print("Ingrese la cantidad de partidos jugados: ");
            scanner.next();
        }
        int partidosJugados = scanner.nextInt();
        nuevoEquipo.setPartidosJugados(partidosJugados);

        equipoDAO.guardarEquipo(nuevoEquipo);

        System.out.println("El equipo se ha guardado correctamente.");
        System.out.println("Datos del Equipo:");
        System.out.println("------------------------------------------------------------------------------------");
        System.out.println(String.format("%-2s %-23s %-9s %-9s %-20s %-6s %-8s",
                "ID", "Nombre del Equipo", "Titulares", "Suplentes", "Director Técnico", "Puntos", "Partidos"));
        System.out.println(
                String.format("%-2d %-23s %-9d %-9d %-20s %-6d %-8d",
                        nuevoEquipo.getIdEquipo(),
                        nuevoEquipo.getNombreEquipo(),
                        nuevoEquipo.getTitulares(),
                        nuevoEquipo.getSuplentes(),
                        nuevoEquipo.getDirectorTec(),
                        nuevoEquipo.getPuntos(),
                        nuevoEquipo.getPartidosJugados()
                ));
        System.out.println("------------------------------------------------------------------------------------");
    }

    public static void deleteEquipo() {
        EquipoDAO equipoDAO = new EquipoDAO();
        Scanner scanner = new Scanner(System.in);

        System.out.print("Ingrese el equipo (ID) que desea borrar: ");
        while (!scanner.hasNextInt()) {
            System.out.println("Numero inválido. Por favor, ingrese un número entero.");
            System.out.print("Ingrese el equipo (ID) que desea borrar: ");
            scanner.next();
        }
        int id = scanner.nextInt();

        boolean equipoBorrado = equipoDAO.deleteEquipo(id);

        if (equipoBorrado) {
            System.out.println("El equipo se ha borrado correctamente.");
        } else {
            System.out.println("El ID del equipo no existe en la base de datos.");
        }
    }

    public static void updateEquipo() {
        EquipoDAO equipoDAO = new EquipoDAO();
        Scanner scanner = new Scanner(System.in);

        System.out.print("Ingrese el equipo (ID) que desea actualizar: ");
        while (!scanner.hasNextInt()) {
            System.out.println("Numero inválido. Por favor, ingrese un número entero.");
            System.out.print("Ingrese el equipo (ID) que desea actualizar: ");
            scanner.next();
        }
        int id = scanner.nextInt();
        Equipo equipo = equipoDAO.obtenerEquipoPorId(id);

        if (equipo != null) {
            System.out.println("El equipo seleccionado es:");
            System.out.println("------------------------------------------------------------------------------------");
            System.out.println(String.format("%-2s %-23s %-9s %-9s %-20s %-6s %-8s",
                    "ID", "Nombre del Equipo", "Titulares", "Suplentes", "Director Técnico", "Puntos", "Partidos"));
            System.out.println("------------------------------------------------------------------------------------");
            System.out.println(
                    String.format("%-2d %-23s %-9d %-9d %-20s %-6d %-8d",
                            equipo.getIdEquipo(),
                            equipo.getNombreEquipo(),
                            equipo.getTitulares(),
                            equipo.getSuplentes(),
                            equipo.getDirectorTec(),
                            equipo.getPuntos(),
                            equipo.getPartidosJugados()
                    ));
            System.out.println("------------------------------------------------------------------------------------");
            System.out.println("¿Qué desea actualizar?");
            System.out.println("1: Nombre del equipo");
            System.out.println("2: Cantidad de titulares");
            System.out.println("3: Cantidad de suplentes");
            System.out.println("4: Nombre del director técnico");
            System.out.println("5: Cantidad de puntos");
            System.out.println("6: Cantidad de partidos jugados");
            System.out.println("0: Cancelar");
            System.out.print("Elija una opción: ");
            int opcion = scanner.nextInt();
            switch (opcion) {
                case 1:
                    System.out.print("Ingrese el nuevo nombre del equipo: ");
                    scanner.nextLine();
                    String nombreEquipo = scanner.nextLine();
                    equipo.setNombreEquipo(nombreEquipo);
                    break;
                case 2:
                    System.out.print("Ingrese la nueva cantidad de titulares: ");
                    while (!scanner.hasNextInt()) {
                        System.out.println("Entrada inválida. Por favor, ingrese un número entero entre 0 y 11.");
                        System.out.print("Ingrese la nueva cantidad de titulares: ");
                        scanner.next();
                    }
                    int titulares = scanner.nextInt();
                    while (titulares < 0 || titulares > 11) {
                        System.out.println("La cantidad de titulares debe ser entre 0 y 11.");
                        System.out.print("Ingrese la nueva cantidad de titulares: ");

                        while (!scanner.hasNextInt()) {
                            System.out.println("Entrada inválida. Por favor, ingrese un número entero entre 0 y 11.");
                            System.out.print("Ingrese la nueva cantidad de titulares: ");
                            scanner.next();
                        }
                        titulares = scanner.nextInt();
                    }
                    equipo.setTitulares(titulares);
                    break;
                case 3:
                    System.out.print("Ingrese la nueva cantidad de suplentes: ");
                    while (!scanner.hasNextInt()) {
                        System.out.println("Entrada inválida. Por favor, ingrese un número entero entre 0 y 11.");
                        System.out.print("Ingrese la nueva cantidad de suplentes: ");
                        scanner.next();
                    }
                    int suplentes = scanner.nextInt();
                    while (suplentes < 0 || suplentes > 11) {
                        System.out.println("La cantidad de suplentes debe ser entre 0 y 11.");
                        System.out.print("Ingrese la nueva cantidad de suplentes: ");

                        while (!scanner.hasNextInt()) {
                            System.out.println("Entrada inválida. Por favor, ingrese un número entero entre 0 y 11.");
                            System.out.print("Ingrese la nueva cantidad de suplentes: ");
                            scanner.next();
                        }
                        suplentes = scanner.nextInt();
                    }
                    equipo.setSuplentes(suplentes);
                    break;
                case 4:
                    System.out.print("Ingrese el nuevo nombre del director técnico: ");
                    scanner.nextLine();
                    String directorTecnico = scanner.nextLine();
                    equipo.setDirectorTec(directorTecnico);
                    break;
                case 5:
                    System.out.print("Ingrese la nueva cantidad de puntos: ");
                    while (!scanner.hasNextInt()) {
                        System.out.println("Entrada inválida. Por favor, ingrese un número entero.");
                        System.out.print("Ingrese la nueva cantidad de puntos: ");
                        scanner.next();
                    }
                    int puntos = scanner.nextInt();
                    equipo.setPuntos(puntos);
                    break;
                case 6:
                    System.out.print("Ingrese la nueva cantidad de partidos jugados: ");
                    while (!scanner.hasNextInt()) {
                        System.out.println("Entrada inválida. Por favor, ingrese un número.");
                        System.out.print("Ingrese la nueva cantidad de partidos jugados: ");
                        scanner.next();
                    }
                    int partidosJugados = scanner.nextInt();
                    equipo.setPartidosJugados(partidosJugados);
                    break;
                case 0:
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Opción inválida.");
                    break;
            }
            equipoDAO.updateEquipo(equipo);
            System.out.println("El equipo se ha actualizado correctamente.");
        } else {
            System.out.println("El equipo con el ID proporcionado no existe en la base de datos.");
        }
    }
}