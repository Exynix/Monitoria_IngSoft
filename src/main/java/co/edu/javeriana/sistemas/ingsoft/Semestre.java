package co.edu.javeriana.sistemas.ingsoft;

import java.util.ArrayList;

public class Semestre {

// Atributos

    public static final int CANTIDAD_MINIMA_CREDITOS = 6;
    public static final int CANTIDAD_MAXIMA_CREDITOS = 24;

// Constructores


// Métodos

    public int calcularTotalCreditos(ArrayList<Asignatura> asignaturas){

        if(asignaturas.isEmpty()){
            throw new RuntimeException();
        }


        return 0;
    }

// Gets y sets



}
