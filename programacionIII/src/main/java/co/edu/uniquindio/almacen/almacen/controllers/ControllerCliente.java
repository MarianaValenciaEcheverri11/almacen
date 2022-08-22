package co.edu.uniquindio.almacen.almacen.controllers;

import co.edu.uniquindio.almacen.almacen.models.Cliente;
import co.edu.uniquindio.almacen.almacen.models.PersonaNatural;
import co.edu.uniquindio.almacen.almacen.models.TipoCliente;
import javafx.collections.ObservableList;
import javafx.scene.control.*;
import javafx.scene.text.Text;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;

public class ControllerCliente {
    public ControllerCliente(){

    }

    private boolean validarDatosCliente(Cliente cliente,  ObservableList<Cliente> listaClientes){
        boolean isCamposLlenos = false;
        if (cliente.getNombre() !="" && cliente.getApellido()!= ""
                && cliente.getDireccion()!= ""  &&  cliente.getTelefono()!= ""
                && cliente.getIdentificacion()!= "" && (cliente.getTipoCliente().getPersonaJuridica()!= null
                || cliente.getTipoCliente().getPersonaNatural()!= null )){
            isCamposLlenos = true;
        }
        return isCamposLlenos;
    }
    public  boolean validarClienteEnLista(ObservableList<Cliente> listaClientes, Cliente cliente){
        ArrayList<String> listaIdentificaciones = new ArrayList<>();
                  for(Cliente cliente1 : listaClientes){
                      if(cliente1.getIdentificacion().equals(cliente.getIdentificacion())){
                         listaIdentificaciones.add(cliente.getIdentificacion());
                      }
                  }
                 if(listaIdentificaciones.contains(cliente.getIdentificacion())== true){
                     return  false;
                 }else{

                     return true;
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


    public void  agregarCliente( Cliente cliente, ObservableList<Cliente> listaClientes,
                        TableView tablaClientes) {
        if(  validarClienteEnLista(listaClientes, cliente) == false){
            mostrarMensaje("Notificación","Error", "El cliente ya está registrado", Alert.AlertType.ERROR);

        }else{
            if(cliente.getTipoCliente().getPersonaNatural()!= null){
                if(cliente.getTipoCliente().getPersonaNatural().getEmail().contains("@"))
                {
                    if(validarDatosCliente(cliente, listaClientes)== true ){
                        listaClientes.add(cliente);
                        tablaClientes.setItems(listaClientes);
                        mostrarMensaje("Notificación","Cliente registrado", "Se ha registrado exitosamente", Alert.AlertType.CONFIRMATION);

                    }else{
                        mostrarMensaje("Notificación","Error", "Por favor ingrese todos los datos para efectuar el registro", Alert.AlertType.ERROR);

                    }
                }
                else{
                    mostrarMensaje("Notificación","Error", "Por favor ingrese un correo electrónico válido", Alert.AlertType.ERROR);

                }
            }else
            {
                if(validarDatosCliente(cliente, listaClientes)== true ){
                    listaClientes.add(cliente);
                    tablaClientes.setItems(listaClientes);
                    mostrarMensaje("Notificación","Cliente registrado", "Se ha registrado exitosamente", Alert.AlertType.CONFIRMATION);

                }else{
                    mostrarMensaje("Notificación","Error", "Por favor ingrese todos los datos para efectuar el registro", Alert.AlertType.ERROR);

                }

            }

        }
    }





    public void editarCliente(Cliente clienteSeleccionado, Cliente nuevoCliente,
                              ObservableList<Cliente> listaClientes){
        try {
            if(clienteSeleccionado.getIdentificacion().equals(nuevoCliente.getIdentificacion())){
                listaClientes.remove(clienteSeleccionado);
                listaClientes.add(nuevoCliente);
                mostrarMensaje("Notificación cliente", "Cliente editado", "El cliente se ha editado con éxito.",
                        Alert.AlertType.CONFIRMATION);


            }

        }catch (Exception e) {
            mostrarMensaje("Notificación cliente", "Error", "Seleccione un cliente para editar",
                    Alert.AlertType.ERROR);

        }


}
public void eliminarCliente( ObservableList<Cliente> listaClientes,
                             TableView tablaClientes){
        if(listaClientes.contains(tablaClientes.getSelectionModel().getSelectedItem())){
    listaClientes.remove(tablaClientes.getSelectionModel().getSelectedItem());

    mostrarMensaje("Notificación cliente", "Cliente eliminado", "El cliente se ha eliminado con éxito.",
                   Alert.AlertType.CONFIRMATION);
        }
        else{
            mostrarMensaje("Notificación cliente", "Error", "Seleccione un cliente",
                    Alert.AlertType.ERROR);
        }

        }
}




