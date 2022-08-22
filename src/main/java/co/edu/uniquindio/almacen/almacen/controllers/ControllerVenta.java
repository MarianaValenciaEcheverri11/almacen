package co.edu.uniquindio.almacen.almacen.controllers;

import co.edu.uniquindio.almacen.almacen.models.Cliente;
import co.edu.uniquindio.almacen.almacen.models.Detalle;
import co.edu.uniquindio.almacen.almacen.models.Producto;
import co.edu.uniquindio.almacen.almacen.models.Venta;
import javafx.collections.ObservableList;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

import java.time.LocalDate;
import java.util.ArrayList;

public class ControllerVenta {

    public ControllerVenta(){

    }
    public void agregarProducto(Producto productoNuevo, ObservableList<Producto> listaProductosCarrito, TableView<Producto> tablaProductosCarrito){
        listaProductosCarrito.add(productoNuevo);
        tablaProductosCarrito.setItems(listaProductosCarrito);

    }
    public boolean vender(TextField txtCodigoVenta, ComboBox<String> comboClienteVenta, TextField txtIvaVenta, ObservableList<Producto> listaProductos, ObservableList<Venta> listaVentas, TableView<Venta> tablaVentas, ObservableList<Cliente> listaClientes){
        if(validarDatos(txtCodigoVenta, comboClienteVenta, txtIvaVenta, listaProductos)){
            double subtotal = 0.0;
            ArrayList<Detalle> listaDetalles = new ArrayList<>();
            Cliente cliente = new Cliente();
            double total = 0.0;
            for(Cliente cliente1: listaClientes){
                if(cliente1.getNombre().equals(comboClienteVenta.getValue())){
                    cliente = cliente1;
                }
            }
            for(Producto producto : listaProductos){
                subtotal= subtotal+ producto.getValorUnitario();
                Detalle detalle = new Detalle(producto.getCantidadExistente(), subtotal,producto);
                listaDetalles.add(detalle);

            }
            total = subtotal* Float.parseFloat(txtIvaVenta.getText()) + subtotal;
            Venta venta = new Venta(txtCodigoVenta.getText(), LocalDate.now(),listaDetalles,
                    cliente, total, Float.parseFloat(txtIvaVenta.getText()));
            listaVentas.add(venta);
            tablaVentas.setItems(listaVentas);
           return true;

        }else{
            return  false;
        }


    }
    public boolean validarDatos(TextField txtCodigoVenta, ComboBox<String> comboClienteVenta, TextField txtIvaVenta, ObservableList<Producto> listaProductos){
        if(txtCodigoVenta.getText()!= ""&& comboClienteVenta.getValue()!=null&&
                txtIvaVenta.getText()!="" && listaProductos.size()>0){
            return true;
        }
        return false;
    }
    public void mostrarMensaje(String titulo, String header, String contenido, Alert.AlertType alertType) {
        // TODO Auto-generated method stub
        Alert alert = new Alert(alertType);

        alert.setTitle(titulo);
        alert.setHeaderText(header);
        alert.setContentText(contenido);
        alert.showAndWait();

    }


    public void eliminarVenta(Venta ventaSeleccionada, ObservableList<Venta> listaVentas, TableView<Venta> tablaVentas) {
        listaVentas.remove(ventaSeleccionada);
        tablaVentas.setItems(listaVentas);
        mostrarMensaje("Notificación", "", "Venta eliminada con éxito", Alert.AlertType.CONFIRMATION);


    }
}
