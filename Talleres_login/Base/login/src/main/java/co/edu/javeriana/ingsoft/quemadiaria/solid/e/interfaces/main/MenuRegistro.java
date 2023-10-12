package co.edu.javeriana.ingsoft.quemadiaria.solid.e.interfaces.main;

import co.edu.javeriana.ingsoft.quemadiaria.solid.c.servicios.dto.RegistroUsuarioDTO;
import co.edu.javeriana.ingsoft.quemadiaria.solid.c.servicios.facade.AutenticacionFacade;
import co.edu.javeriana.ingsoft.quemadiaria.solid.c.servicios.facade.RegistroFacade;
import co.edu.javeriana.ingsoft.quemadiaria.solid.c.servicios.facade.SeguridadFacade;

public class MenuRegistro {

    RegistroFacade seguridadFacade = new SeguridadFacade();

    public void registrarUsuario() {
        RegistroUsuarioDTO registroUsuarioDTO = new RegistroUsuarioDTO();
        //registroUsuarioDTO.setNumeroDocumento("123456789");

        seguridadFacade.registrarUsuario(registroUsuarioDTO);
        //seguridadFacade.
    }

    public static void main(String[] args) {
        System.out.println("Menu Registro");
    }
}
