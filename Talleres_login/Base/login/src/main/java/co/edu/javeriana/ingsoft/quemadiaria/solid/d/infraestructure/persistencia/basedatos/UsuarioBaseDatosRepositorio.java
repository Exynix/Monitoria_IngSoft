package co.edu.javeriana.ingsoft.quemadiaria.solid.d.infraestructure.persistencia.basedatos;

import co.edu.javeriana.ingsoft.quemadiaria.solid.a.dominio.entidades.Usuario;
import co.edu.javeriana.ingsoft.quemadiaria.solid.b.usecases.persistencia.UsuarioRepositorio;

import java.util.List;

public class UsuarioBaseDatosRepositorio implements UsuarioRepositorio {
    @Override
    public void guardarUsuario(Usuario usuario) {
        // TODO Auto-generated method stub
    }

    @Override
    public List<Usuario> consultarListaUsuarios() {
        return null;
    }

    @Override
    public Usuario consultarUsuarioPorUserName(String username) {
        return null;
    }
}
