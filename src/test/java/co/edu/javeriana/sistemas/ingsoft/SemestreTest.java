package co.edu.javeriana.sistemas.ingsoft;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Array;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class SemestreTest {

    Semestre semestrePrueba;
    ArrayList<Asignatura> listaAsignaturasPrueba;

    @BeforeEach
    void setUp() {
        Semestre semestrePrueba = new Semestre();
        listaAsignaturasPrueba= new ArrayList<>();

    }


    @Test
    void calcularTotalCreditos_ListaVacia(){

    }
}