package com.tf_vivianarivas.controller;

public abstract class EquipoTemplate {

    // Método Template Method
    public void metodoTemplate() {
        insertEquipo();
        viewEquipos();
        updateEquipo();
        deleteEquipo();
    }

    public static void updateEquipo() {
    }

    public static void viewEquipos() {
    }

    public static void insertEquipo() {
    }

    public static void deleteEquipo() {
    }
}