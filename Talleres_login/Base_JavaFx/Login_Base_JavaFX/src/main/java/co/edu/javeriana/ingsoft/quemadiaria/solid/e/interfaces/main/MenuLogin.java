package co.edu.javeriana.ingsoft.quemadiaria.solid.e.interfaces.main;

import co.edu.javeriana.ingsoft.quemadiaria.solid.c.servicios.dto.LoginDTO;
import co.edu.javeriana.ingsoft.quemadiaria.solid.c.servicios.dto.ResponseDTO;
import co.edu.javeriana.ingsoft.quemadiaria.solid.c.servicios.facade.AutenticacionFacade;
import co.edu.javeriana.ingsoft.quemadiaria.solid.c.servicios.facade.SeguridadFacade;

public class MenuLogin {

    AutenticacionFacade seguridadFacade = new SeguridadFacade();

    public void login() {
        LoginDTO loginDTO = new LoginDTO();
        loginDTO.setUsername("a.barrera");
        loginDTO.setPassword("123456789");

        ResponseDTO<String> respuesta = seguridadFacade.login(loginDTO);
        //seguridadFacade.
        System.out.println(respuesta.getCodigo()==ResponseDTO.OK?"Login exitoso":"Login fallido");

        //seguridadFacade
    }

    public static void main(String[] args) {
        System.out.println("Menu Login");
        MenuLogin menuLogin = new MenuLogin();
        System.out.println("here");
        menuLogin.login();
        System.out.println("here2");
    }
}
