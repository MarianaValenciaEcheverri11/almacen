module co.edu.uniquindio.almacen.almacen {
    requires javafx.controls;
    requires javafx.fxml;


    opens co.edu.uniquindio.almacen.almacen to javafx.fxml;
    exports co.edu.uniquindio.almacen.almacen;
    exports co.edu.uniquindio.almacen.almacen.controllers;
    opens co.edu.uniquindio.almacen.almacen.controllers to javafx.fxml;
    opens co.edu.uniquindio.almacen.almacen.models to javafx.base ;
}