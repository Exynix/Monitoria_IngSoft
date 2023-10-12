package co.edu.javeriana.ingsoft.quemadiaria.solid.d.infraestructure.persistencia.archivos.adapter;

import co.edu.javeriana.ingsoft.quemadiaria.solid.a.dominio.entidades.Usuario;
import lombok.Data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Data
public class ListaUsuariosJson implements Serializable {

    //private List<Usuario> listaUsuarios;

    private String nombreArchivo = "usuarios.json";

    public ListaUsuariosJson() {
        //this.listaUsuarios = new ArrayList<>();
    }

    @Override
    public String toString() {
        return "ListaUsuariosJson{" +
                "nombreArchivo='" + nombreArchivo + '\'' +
                '}';
    }

}
