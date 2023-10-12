package co.edu.javeriana.sistemas.ingsoft;

public class Asignatura {

// --------- Atributos ----------
    public String nombre;
    private int numeroCreditos;
    private float nota;

// ------ Constructores ------
    public Asignatura(){
        nombre = "";
        numeroCreditos = 0;
        nota = 0.0f;
    }


// --------- Métodos ----------------
    public void asignarCreditos(int numeroCreditos){

        if (numeroCreditos < 1){
            throw new RuntimeException(("Los créditos tienen que ser mínimo 1."));
        }
        if (numeroCreditos > 10){
            throw new RuntimeException(("Los créditos no pueden ser mayores a 10"));
        }
        this.numeroCreditos = numeroCreditos;
}

    public void asignarNota(float nota){
        if (nota < 0.0f || nota > 5.0f){
            throw new RuntimeException("La nota debe ser un valor entre 0.0 y 5.0");
        }

        this.nota = nota;
    }



// ------------ Gets y sets -----------
    public int getNumeroCreditos() {
        return numeroCreditos;
    }

    public float getNota() {
        return nota;
    }

    /*
        El número de créditos debe estar entre 1 y 10.
        Si se sale de este rango, se debería lanzar un error.
     */

}
