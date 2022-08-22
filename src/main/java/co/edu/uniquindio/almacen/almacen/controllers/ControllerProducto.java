package co.edu.uniquindio.almacen.almacen.controllers;

import co.edu.uniquindio.almacen.almacen.models.Cliente;
import co.edu.uniquindio.almacen.almacen.models.Producto;
import javafx.collections.ObservableList;
import javafx.scene.control.*;

public class ControllerProducto {


    public  ControllerProducto(){



    }

    private boolean validarDatosProducto(Producto producto){
        boolean isCamposLlenos = false;
        if (producto.getCodigo() !="" && producto.getValorUnitario()!= 0.0
                && producto.getDescripcion()!= ""  &&  producto.getCantidadExistente()!= 0
       ){
            isCamposLlenos = true;
        }
        return isCamposLlenos;
    }
    public void agregarProducto(Producto producto, ObservableList<Producto> listaProductos, TableView<Producto> tablaProductos){
       if(validarDatosProducto(producto)){
           listaProductos.add(producto);
           tablaProductos.setItems(listaProductos);
           mostrarMensaje("Notificación", "", "Producto agregado con éxito", Alert.AlertType.CONFIRMATION);

       }

    }
    public void mostrarMensaje(String titulo, String header, String contenido, Alert.AlertType alertType) {
        // TODO Auto-generated method stub
        Alert alert = new Alert(alertType);

        alert.setTitle(titulo);
        alert.setHeaderText(header);
        alert.setContentText(contenido);
        alert.showAndWait();

    }
    public void  editarProducto(Producto productoNuevo, Producto productoAntiguo,ObservableList<Producto> listaProductos,
    TableView<Producto> tablaProductos) {
        try {
            if(productoAntiguo.getCodigo().equals(productoNuevo.getCodigo())){
                listaProductos.remove(productoAntiguo);
                listaProductos.add(productoNuevo);
                tablaProductos.setItems(listaProductos);
                mostrarMensaje("Notificación cliente", "Cliente editado", "El cliente se ha editado con éxito.",
                        Alert.AlertType.CONFIRMATION);
            }

        }catch (Exception e) {
            mostrarMensaje("Notificación cliente", "Error", "Seleccione un cliente para editar",
                    Alert.AlertType.ERROR);

        }

    }
    public void eliminarProducto(ObservableList<Producto> listaProductos,
                                 TableView tablaProductos){
        if(listaProductos.contains(tablaProductos.getSelectionModel().getSelectedItem())){
            listaProductos.remove(tablaProductos.getSelectionModel().getSelectedItem());

            mostrarMensaje("Notificación producto", "Producto eliminado", "El producto se ha eliminado con éxito.",
                    Alert.AlertType.CONFIRMATION);
        }
        else{
            mostrarMensaje("Notificación producto", "Error", "Seleccione un producto",
                    Alert.AlertType.ERROR);
        }

    }
}
