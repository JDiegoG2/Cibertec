package com.tuempresa;

import domain.Empleado;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

import java.sql.Date;
import java.util.List;

public class App {
    static EntityManagerFactory factory = null;
    static EntityManager manager = null;
    static EntityTransaction tx = null;

    public static void main(String[] args) {
        factory = Persistence.createEntityManagerFactory("default");
        manager = factory.createEntityManager();
        tx = manager.getTransaction();

        crear();
        listar();
        Empleado empleado = buscar(1l);
        modificar(empleado);
        listar();
        eliminar(empleado);
        listar();

        manager.close();
        factory.close();
    }

    private static Empleado eliminar(Empleado empleado) {
        System.out.println("**** ELIMINAR REGISTRO ****");

        System.out.println("Eliminando registro Id = " +empleado.getId() );
        tx.begin();
        manager.remove(empleado);

        tx.commit();

        System.out.println("**** REGISTRO ELMINADO ****");
        return empleado;
    }

    private static Empleado buscar(Long id) {
        System.out.println("**** BUSQUEDA REGISTRO ****");

        Empleado empleado = manager.find(Empleado.class, id);
        System.out.println("Id = " +id );
        System.out.println("Empleado buscado Id = " + empleado);
        System.out.println("**** BUSQUEDA REGISTRO ****");
        return empleado;
    }


    private static void modificar(Empleado empleado) {

        tx.begin();

        System.out.println("**** MODIFICANDO REGISTRO ****");
        empleado
                .setNombres("Alexis David")
                .setNroHijos(2)
                .setSueldo(10500.00);
        System.out.println("Modificando registro Id = " +empleado.getId() );

        tx.commit();

        System.out.println("**** MODIFICACION DE REGISTROS****");
    }


    private static void crear() {
        tx.begin();

        System.out.println("**** CREAR REGISTRO ****");
        Empleado empleado = new Empleado()
                .setNombres("Diego")
                .setApellidoPaterno("Gatica")
                .setApellidoMaterno("Capa")
                .setFechaNacimiento(Date.valueOf("2020-03-16"))
                .setNroHijos(1)
                .setSueldo(800.00);
        Empleado empleado2 = new Empleado()
                .setNombres("Justina ")
                .setApellidoPaterno("Capa")
                .setApellidoMaterno("Sicce")
                .setFechaNacimiento(Date.valueOf("1987-10-04"))
                .setNroHijos(1)
                .setSueldo(1400.00);
        Empleado empleado3 = new Empleado()
                .setNombres("Juan")
                .setApellidoPaterno("Gatica")
                .setApellidoMaterno("Paredes")
                .setFechaNacimiento(Date.valueOf("1983-09-22"))
                .setNroHijos(3)
                .setSueldo(1300.00);
        Empleado empleado4 = new Empleado()
                .setNombres("Luisa")
                .setApellidoPaterno("Perez")
                .setApellidoMaterno("zavaleta")
                .setFechaNacimiento(Date.valueOf("1983-10-29"))
                .setNroHijos(4)
                .setSueldo(1500.00);

        manager.persist(empleado);
        manager.persist(empleado2);
        manager.persist(empleado3);
        manager.persist(empleado4);

        tx.commit();
        System.out.println("**** CREACION DE REGISTROS ****");
    }


    private static void listar() {
        System.out.println("------ LISTA --------");
        List<Empleado> lista = manager.createQuery("from Emple", Empleado.class).getResultList();
        for (Empleado departamento : lista) {
            System.out.println(departamento);
        }
        System.out.println("------ LISTA --------");
    }
}
