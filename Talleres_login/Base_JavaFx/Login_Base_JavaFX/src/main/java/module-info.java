module co.edu.javeriana.ingsoft.quemadiaria {
    requires javafx.controls;
    requires javafx.fxml;
    requires lombok;
    requires com.google.gson;


    opens co.edu.javeriana.ingsoft.quemadiaria to javafx.fxml;
    opens co.edu.javeriana.ingsoft.quemadiaria.solid.a.dominio.entidades;
    exports co.edu.javeriana.ingsoft.quemadiaria;
}