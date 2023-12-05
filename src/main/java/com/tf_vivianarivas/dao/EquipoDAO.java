package com.tf_vivianarivas.dao;

import static com.tf_vivianarivas.controller.EquipoTemplate.updateEquipo;
import com.tf_vivianarivas.model.Equipo;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

import java.util.List;

public class EquipoDAO {

    private final EntityManagerFactory entityManagerFactory;
    public EquipoDAO() {
        entityManagerFactory = Persistence.createEntityManagerFactory("campeonato");
    }

    public List<Equipo> obtenerTodosLosEquipos(){
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        List<Equipo> equipos = null;

        try {
            equipos = entityManager.createQuery("SELECT e FROM Equipo e", Equipo.class).getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            entityManager.close();
        }
        return equipos;
    }

    public void guardarEquipo(Equipo nuevoEquipo) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = null;

        try {
            transaction = entityManager.getTransaction();
            transaction.begin();

            entityManager.persist(nuevoEquipo);

            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            entityManager.close();
        }
    }

    public boolean deleteEquipo(int id) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = null;

        try {
            transaction = entityManager.getTransaction();
            transaction.begin();

            Equipo equipoABorrar = entityManager.find(Equipo.class, id);

            if (equipoABorrar != null) {
                entityManager.remove(equipoABorrar);
                transaction.commit();
                return true;
            } else {
                return false; // No se encontró el equipo con el ID proporcionado
            }
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
            return false;
        } finally {
            entityManager.close();
        }
    }

    public Equipo obtenerEquipoPorId(int id) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        Equipo equipo = null;

        try {
            equipo = entityManager.find(Equipo.class, id);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            entityManager.close();
        }
        return equipo;
    }

    public void updateEquipo(Equipo equipo) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = null;

        try {
            transaction = entityManager.getTransaction();
            transaction.begin();

            entityManager.merge(equipo);

            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            entityManager.close();
        }
    }
}
