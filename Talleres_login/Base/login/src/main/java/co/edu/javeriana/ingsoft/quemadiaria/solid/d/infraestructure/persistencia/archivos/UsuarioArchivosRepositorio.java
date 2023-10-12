package co.edu.javeriana.ingsoft.quemadiaria.solid.d.infraestructure.persistencia.archivos;

import co.edu.javeriana.ingsoft.quemadiaria.solid.a.dominio.entidades.Usuario;
import co.edu.javeriana.ingsoft.quemadiaria.solid.a.dominio.excepciones.QuemaDiariaException;
import co.edu.javeriana.ingsoft.quemadiaria.solid.b.usecases.persistencia.UsuarioRepositorio;
import co.edu.javeriana.ingsoft.quemadiaria.solid.d.infraestructure.persistencia.archivos.adapter.ListaUsuariosJson;
import com.google.gson.*;
import com.google.gson.reflect.TypeToken;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;

import java.io.IOException;
import java.lang.reflect.Type;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * UsuarioArchivosRepositorio es una clase que implementa la interfaz UsuarioRepositorio para gestionar un usuario
 * en un archivo json
 */
public class UsuarioArchivosRepositorio implements UsuarioRepositorio {

    @Override
    public void guardarUsuario(Usuario usuario) {



        try {

            List<Usuario> usuarioList = consultarListaUsuarios();
            System.out.println("Registrando usuario: " + usuario);
            usuarioList.add(usuario);
            FileWriter fileWriter = new FileWriter("Usuarios.json");
            Gson gson = new GsonBuilder()
                    .setPrettyPrinting()
                    .create();
            gson.toJson(usuarioList, fileWriter);
            fileWriter.close();
            System.out.println("Informacion guardada correctamente");
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Error al gestionar el archivo", e);
        }

    }

    @Override
    public List<Usuario> consultarListaUsuarios() {


        Gson gson = new Gson();
        try {
            Path filePath = Path.of("Usuarios.json");
            String content = Files.readString(filePath);
            List<Usuario> usersList = new ArrayList<>();
            try {
                Usuario[] users = gson.fromJson(content, Usuario[].class);
                if(users == null)
                    return new ArrayList<>();
                return new ArrayList<>(List.of(users));
            } catch (JsonSyntaxException e) {
                if (e.getMessage().equals(
                        "Expected BEGIN_OBJECT but was BEGIN_ARRAY")) {
                    JsonArray jsonArray = new JsonParser()
                            .parse(content)
                            .getAsJsonArray();
                    for (int i = 0; i < jsonArray.size(); i++) {
                        Usuario user = gson.fromJson(jsonArray.get(i), Usuario.class);
                        usersList.add(user);
                    }
                    return usersList;
                } else {
                    // Handle other JSON parsing errors
                    e.printStackTrace();
                    throw new RuntimeException("Error al gestionar el archivo", e);
                }
            }

        }
        catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("Error al gestionar el archivo", e);
        }

    }

    @Override
    public Usuario consultarUsuarioPorUserName(String userName) {

        return consultarListaUsuarios().
                stream().
                filter(usuario -> usuario.getCredenciales().getNombreUsuario().equals(userName)).
                findFirst().
                orElseThrow(()->new QuemaDiariaException(QuemaDiariaException.ERROR_USUARIO_NO_ENCONTRADO, "Usuario no encontrado: " + userName));
    }

}
