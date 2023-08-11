package co.edu.javeriana.sistemas.ingsoft;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AsignaturaTest {


    private Asignatura asignatura;

    @BeforeEach
    void setUp(){
        asignatura = new Asignatura();
    }


    @Test
    void asignarCreditosAsignatura_MenorAUno() {

        // Set
        final int numeroCreditos = 0;
        // Arrange

        // Assert
        assertThrowsExactly(RuntimeException.class, ()->asignatura.asignarCreditos(numeroCreditos));
    }

    @Test
    void asignarCreditosAsignatura_MayorA10() {

        // Set
        final int numeroCreditos = 11;
        // Arrange

        // Assert
        assertThrowsExactly(RuntimeException.class, ()->asignatura.asignarCreditos(numeroCreditos));
    }

    @Test
    void asignarCreditosAsignatura_EntreUnoYDiez() {

        // Set
        final int numeroCreditos = 5;
        // Arrange
        asignatura.asignarCreditos(numeroCreditos);
        // Assert
        assertEquals(numeroCreditos, asignatura.getNumeroCreditos());
    }


    @Test
    void asignarNota_Menor0(){

        // Set
        float notaPrueba = -0.1f;
        // Arrange

        // Assert
        assertThrowsExactly(RuntimeException.class, ()-> asignatura.asignarNota(notaPrueba));
    }

    @Test
    void asignarNota_Mayor5(){

        // Set
        float notaPrueba = 7.5f;
        // Arrange

        // Assert
        assertThrowsExactly(RuntimeException.class, ()-> asignatura.asignarNota(notaPrueba));
    }

    // El rango válido es entre 0 y 5.
    @Test
    void asignarNota_RangoValido(){

        // Set
        float notaPrueba = 3.4f;
        // Arrange
        asignatura.asignarNota(notaPrueba);
        // Assert
        assertEquals(notaPrueba, asignatura.getNota());

    }

}