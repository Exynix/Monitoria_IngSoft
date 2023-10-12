package co.edu.javeriana.ingsoft.quemadiaria.tradicional;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.*;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

public class Login implements Serializable {

    private String numeroDocumento;

    private String nombre;
    private String apellido;
    private String correo;
    private String usuario;
    private String contrasena;

    public String getNumeroDocumento() {
        return numeroDocumento;
    }

    public void setNumeroDocumento(String numeroDocumento) {
        this.numeroDocumento = numeroDocumento;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }



    public Login(String usuario, String contrasena) {
        this.usuario = usuario;
        this.contrasena = contrasena;
    }

    public boolean validarUsuario(String usuario, String contrasena) throws FileNotFoundException {
        Login usuarioEncontrado = buscarUsuario(usuario);
        if (usuarioEncontrado != null) {
            String decodePass = new String(Base64.getDecoder().decode(usuarioEncontrado.getContrasena()));
            if (decodePass.equals(contrasena)) {
                return true;
            }
        }
        return false;
    }

    public void registrarUsuario(List<Login> listUsuarios) throws IOException {
        FileWriter fileWriter = new FileWriter("Usuarios.json");
        listUsuarios.stream().forEach(usuario -> {
            usuario.setContrasena(Base64.getEncoder().encodeToString(usuario.getContrasena().getBytes()));
        });
        Gson gson = new GsonBuilder()
                .setPrettyPrinting()
                .create();
        gson.toJson(listUsuarios, fileWriter);
        fileWriter.close();
        System.out.println("Informacion guardada correctamente");

    }

    public Login buscarUsuario(String email) throws FileNotFoundException {
        FileReader fileReader = new FileReader("Usuarios.json");
        Gson gson = new Gson();
        Login[] usuarios = gson.fromJson(fileReader, Login[].class);
        for (Login usuario: usuarios) {
            if (usuario.getCorreo().equals(email)) {
                return usuario;
            }
        }
        return null;

    }

    public String getUsuario() {
        return usuario;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    @Override
    public String toString() {
        return String.format("Usuario: %s, Contrasena: %s", this.usuario, this.contrasena);
    }

    public static void main( String[] args )
    {
        System.out.println("Bienvenido a QueMadiaria");

        String usuario = "jperez";
        String contrasena = "123456";
        Login login = new Login(usuario, contrasena);
        login.setApellido("Perez");
        login.setNombre("Juan");
        login.setCorreo("jperez@gmail.com");
        login.setNumeroDocumento("123456789");

        Login login2 = new Login("jrodriguez", "345679");
        login2.setApellido("Rodriguez");
        login2.setNombre("Juan");
        login2.setCorreo("jrodriguez@javeriana.edu.co");
        login2.setNumeroDocumento("987654321");
        ArrayList<Login> listUsuarios = new ArrayList<Login>();
        listUsuarios.add(login);
        listUsuarios.add(login2);
        try {
            login.registrarUsuario(listUsuarios);
            Login usuarioEncontrado = login.buscarUsuario("jperez@gmail.com");
            System.out.println(usuarioEncontrado);
            System.out.printf(login.validarUsuario("jrodriguez@javeriana.edu.co", "345679") ? "Usuario valido" : "Usuario invalido");
        } catch (IOException e) {
            e.printStackTrace();
        }



    }
}
