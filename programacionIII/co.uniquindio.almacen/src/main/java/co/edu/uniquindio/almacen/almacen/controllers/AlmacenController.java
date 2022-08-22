package co.edu.uniquindio.almacen.almacen.controllers;

import java.net.URL;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.ResourceBundle;

import co.edu.uniquindio.almacen.almacen.models.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.text.Text;

public class AlmacenController {
    private ObservableList<Venta> listaVentas = FXCollections.observableArrayList();
    private ObservableList<Producto> listaProductos = FXCollections.observableArrayList();
    private ObservableList<Cliente> listaClientes = FXCollections.observableArrayList();
    private ObservableList<Pais> listaPaises = FXCollections.observableArrayList();
    private ObservableList<String> listaNombresCliente = FXCollections.observableArrayList();
    private ObservableList<Producto> listaProductosCarrito = FXCollections.observableArrayList();


    Cliente clienteSeleccionado;
    Venta ventaSeleccionada;
    ControllerCliente controllerCliente = new ControllerCliente();
    ControllerVenta controllerVenta = new ControllerVenta();
    ControllerProducto controllerProducto = new ControllerProducto();
    Producto productoSeleccionado;
    Producto productoSeleccionadoVenta;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TableView<Cliente> tablaClientes;

    @FXML
    private RadioButton checkPersonaNatural;

    @FXML
    private TableColumn<Producto, String> columnValorUnitarioProducto;

    @FXML
    private TextField txtCodigoVenta;

    @FXML
    private TableColumn<Cliente, String> columnIdentificacionCliente;

    @FXML
    private TableColumn<Cliente, String> columnDireccionCliente;

    @FXML
    private DatePicker dateFechaNacimientoCliente;

    @FXML
    private TableColumn<Producto, String> columnCantidadProducto;

    @FXML
    private Button btnEditarProducto;

    @FXML
    private Button btnMenos;

    @FXML
    private TextField txtApellidoCliente;

    @FXML
    private Button btnAgregarCliente;
    @FXML
    private Button btnLimpiarCarrito;

    @FXML
    private TextField txtPesoEnvaseProducto;

    @FXML
    private TextField txtEmailCliente;

    @FXML
    private ComboBox<String> comboClienteVenta;

    @FXML
    private Button btnVender;

    @FXML
    private TableColumn<Producto, String> columnDescripcionProducto;

    @FXML
    private TableColumn<Venta, Detalle> columnSubtotalVenta;

    @FXML
    private TableColumn<Venta, String> columnIvaVenta;

    @FXML
    private TextField txtIdentificacionCliente;

    @FXML
    private Button btnMas;

    @FXML
    private Button btnEliminarCliente;

    @FXML
    private RadioButton checkProductoPerecedero;

    @FXML
    private RadioButton checkPersonaJuridica;

    @FXML
    private TextField txtCodigoProducto;

    @FXML
    private TableColumn<Cliente, String> columnApellidoCliente;

    @FXML
    private TextField txtIvaVenta;

    @FXML
    private TableColumn<Venta, Detalle> columnCantidadVenta;

    @FXML
    private TableColumn<Venta, String> columnCodigoVenta;

    @FXML
    private TextField txtCodigoAprobacionOCA;

    @FXML
    private Button btnEliminarVenta;

    @FXML
    private TextField txtNombreProducto;

    @FXML
    private TextField txtDireccionCliente;

    @FXML
    private TableColumn<Venta, LocalDate> columnFechaVenta;

    @FXML
    private TableColumn<Cliente, String> columnNombreCliente;

    @FXML
    private DatePicker dateFechaEnvasado;

    @FXML
    private Button btnEditarCliente;

    @FXML
    private DatePicker dateFechaVencimientoProducto;

    @FXML
    private Button btnAgregarProducto;

    @FXML
    private TextField txtNombreCliente;

    @FXML
    private Button btnAgregarProductoVenta;

    @FXML
    private TableView<Producto> tablaProductos;

    @FXML
    private TableColumn<Producto, String> columnCodigoProducto;

    @FXML
    private TableView<Producto> tablaProductosVenta;

    @FXML
    private RadioButton checkProductoEnvasado;

    @FXML
    private TextField txtCantidadProducto;
    @FXML
    private TextField txtTemperaturaRecomendada;

    @FXML
    private TextField txtValorUnitarioProducto;

    @FXML
    private TextField txtTelefonoCliente;

    @FXML
    private RadioButton checkProductoRefrigerado;

    @FXML
    private TableColumn<Producto, String> columnNombreProducto;

    @FXML
    private Button btnEditarVenta;

    @FXML
    private Label labelCantidadVenta;

    @FXML
    private TextField txtNitCliente;

    @FXML
    private TableColumn<Cliente, String> columnTelefonoCliente;

    @FXML
    private TextField txtDescripcionProducto;

    @FXML
    private Button btnEliminarProducto;

    @FXML
    private TableColumn<Venta, String> columnTotalVenta;

    @FXML
    private TableView<Venta> tablaVentas;

    @FXML
    private TableColumn<Venta, Detalle> columnProductosVenta;

    @FXML
    private TableColumn<Venta, Cliente> columnClienteVenta;

    @FXML
    private ComboBox<Pais> comboPaisOrigen;

    @FXML
    private TableView<Producto> tablaProductosCarrito;
    @FXML
    private TableColumn<Producto, String> columnCodigoCarrito;
    @FXML
    private TableColumn<Producto, String> columnNombreCarrito;
    @FXML
    private TableColumn<Producto,String > columnCantidadCarrito;
    @FXML
    private TableColumn<
            Producto, String> columnValorCarrito;

    @FXML
    void agregarCliente(ActionEvent event) {
        try{
            TipoCliente tipoCliente;
            Cliente cliente = new Cliente(txtNombreCliente.getText(), txtApellidoCliente.getText(),
                    txtIdentificacionCliente.getText(), txtDireccionCliente.getText(), txtTelefonoCliente.getText());
            agregarClienteCombo(cliente);
            if(checkPersonaJuridica.isSelected()){
                 tipoCliente = new TipoCliente(new PersonaJuridica(txtNitCliente.getText()));
                 cliente.setTipoCliente(tipoCliente);

            }else if (checkPersonaNatural.isSelected()){
                tipoCliente = new TipoCliente(new PersonaNatural(txtEmailCliente.getText(),
                        dateFechaNacimientoCliente.getValue()));
                cliente.setTipoCliente(tipoCliente);
            }
   controllerCliente.agregarCliente(cliente, listaClientes, tablaClientes);

                limpiarCamposCliente();



        }catch (Exception e){
            mostrarMensaje("Notificación", "", "Por favor ingrese todos los datos para efectuar el registro", Alert.AlertType.ERROR);

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
    public void limpiarCamposCliente(
    ) {
        txtNitCliente.setDisable(true);
        txtEmailCliente.setDisable(true);
        dateFechaNacimientoCliente.setDisable(true);
        txtNombreCliente.setText("");
        txtApellidoCliente.setText("");
        txtIdentificacionCliente.setText("");
        txtDireccionCliente.setText("");
        txtTelefonoCliente.setText("");
        txtEmailCliente.setText("");
        txtNitCliente.setText("");
        txtEmailCliente.setText("");
        dateFechaNacimientoCliente.setValue(null);
        checkPersonaNatural.setSelected(false);
        checkPersonaJuridica.setSelected(false);

    }


    @FXML
    void eliminarCliente(ActionEvent event) {
        controllerCliente.eliminarCliente(listaClientes, tablaClientes);
        limpiarCamposCliente();

    }
    @FXML
    void limpiarCarrito(ActionEvent event) {
        listaProductosCarrito.clear();

    }

    @FXML
    void agregarProducto(ActionEvent event) {
        try{
        Producto producto = new Producto(txtCodigoProducto.getText(), txtNombreProducto.getText(),
                txtDescripcionProducto.getText(), Double.parseDouble(txtValorUnitarioProducto.getText()),
                Integer.parseInt(txtCantidadProducto.getText()));
        TipoProducto tipoProducto;
        if(checkProductoRefrigerado.isSelected()){
            ProductoRefrigerado productoRefrigerado= new ProductoRefrigerado(txtCodigoAprobacionOCA.getText(), Double.parseDouble(txtTemperaturaRecomendada.getText()));
            tipoProducto= new TipoProducto(productoRefrigerado);
            producto.setTipoProducto(tipoProducto);
        }if (checkProductoPerecedero.isSelected()){
            tipoProducto = new TipoProducto( new ProductoPerecedero(dateFechaVencimientoProducto.getValue()));
                producto.setTipoProducto(tipoProducto);
        }else{
            tipoProducto = new TipoProducto( new ProductoEnvasado(dateFechaEnvasado.getValue(),
                    Double.parseDouble(txtPesoEnvaseProducto.getText()), comboPaisOrigen.getValue()));
                producto.setTipoProducto(tipoProducto);
        }
        controllerProducto.agregarProducto(producto, listaProductos, tablaProductos);
        limpiarCamposProducto();
        }catch (Exception e) {
            System.out.print(e.toString());
            mostrarMensaje("Notificación", "", "Por favor ingrese todos los datos para efectuar el registro", Alert.AlertType.ERROR);

        }
    }
    public void limpiarCamposProducto(){
        txtCodigoProducto.setText("");
        txtNombreProducto.setText("");
        txtDescripcionProducto.setText("");
        txtValorUnitarioProducto.setText("");
        txtCantidadProducto.setText("");
        txtPesoEnvaseProducto.setText("");
        comboPaisOrigen.setValue(null);
        dateFechaEnvasado.setValue(null);
        dateFechaVencimientoProducto.setValue(null);
        txtTemperaturaRecomendada.setText("");
        txtCodigoAprobacionOCA.setText("");
        checkProductoPerecedero.setSelected(false);
        checkProductoRefrigerado.setSelected(false);
        checkProductoEnvasado.setSelected(false);
        txtPesoEnvaseProducto.setDisable(true);
        comboPaisOrigen.setDisable(true);
        dateFechaNacimientoCliente.setDisable(true);
        txtCodigoAprobacionOCA.setDisable(true);
        dateFechaEnvasado.setDisable(true);
        txtTemperaturaRecomendada.setDisable(true);
        dateFechaVencimientoProducto.setDisable(true);



    }

    @FXML
    void editarProducto(ActionEvent event) {
        try{
        Producto productoNuevo = new Producto(txtCodigoProducto.getText(), txtNombreProducto.getText(),
                txtDescripcionProducto.getText(), Double.parseDouble(txtValorUnitarioProducto.getText()),
                Integer.parseInt(txtCantidadProducto.getText()));
        TipoProducto tipoProducto;
        if(checkProductoRefrigerado.isSelected()){
            ProductoRefrigerado productoRefrigerado= new ProductoRefrigerado(txtCodigoAprobacionOCA.getText(), Double.parseDouble(txtTemperaturaRecomendada.getText()));
            tipoProducto= new TipoProducto(productoRefrigerado);
            productoNuevo.setTipoProducto(tipoProducto);
        }if (checkProductoPerecedero.isSelected()){
            tipoProducto = new TipoProducto( new ProductoPerecedero(dateFechaVencimientoProducto.getValue()));
            productoNuevo.setTipoProducto(tipoProducto);
        }else if (checkProductoEnvasado.isSelected()){
            tipoProducto = new TipoProducto( new ProductoEnvasado(dateFechaEnvasado.getValue(),
                    Double.parseDouble(txtPesoEnvaseProducto.getText()), comboPaisOrigen.getValue()));
            productoNuevo.setTipoProducto(tipoProducto);
        }
        controllerProducto.editarProducto(productoNuevo, productoSeleccionado, listaProductos, tablaProductos);
        limpiarCamposProducto();
        }catch (Exception e ){
            mostrarMensaje("Notificación", "", "Por favor ingrese los datos para editar", Alert.AlertType.ERROR);

        }

    }

    @FXML
    void eliminarProducto(ActionEvent event) {
        controllerProducto.eliminarProducto(listaProductos, tablaProductos);
        limpiarCamposProducto();


    }
    public void agregarClienteCombo(Cliente cliente){
        if(listaNombresCliente.contains(cliente.getNombre())== false){
                listaNombresCliente.add(cliente.getNombre());
        comboClienteVenta.setItems(listaNombresCliente);
        }
    }
    @FXML
    void editarCliente(ActionEvent event) {
        Cliente nuevoCliente = new Cliente(txtNombreCliente.getText(), txtApellidoCliente.getText(),
                txtIdentificacionCliente.getText(), txtDireccionCliente.getText(), txtTelefonoCliente.getText());
        agregarClienteCombo(nuevoCliente);
        TipoCliente tipoCliente;
        if(checkPersonaJuridica.isSelected()){
            tipoCliente = new TipoCliente(new PersonaJuridica(txtNitCliente.getText()));
            nuevoCliente.setTipoCliente(tipoCliente);

        }else if (checkPersonaNatural.isSelected()){
            tipoCliente = new TipoCliente(new PersonaNatural(txtEmailCliente.getText(),
                    dateFechaNacimientoCliente.getValue()));
            nuevoCliente.setTipoCliente(tipoCliente);
        }

        controllerCliente.editarCliente(clienteSeleccionado, nuevoCliente, listaClientes);
        limpiarCamposCliente();


    }



    @FXML
    void seleccionarJuridica(ActionEvent event) {
       checkPersonaNatural.setSelected(false);
       txtEmailCliente.setDisable(true);
       dateFechaNacimientoCliente.setDisable(true);
       txtNitCliente.setDisable(false);



    }
    @FXML
    void seleccionarRefrigerado(ActionEvent event) {
      checkProductoEnvasado.setSelected(false);
      checkProductoPerecedero.setSelected(false);
      txtCodigoAprobacionOCA.setDisable(false);
      txtTemperaturaRecomendada.setDisable(false);
        dateFechaEnvasado.setDisable(true);
        txtPesoEnvaseProducto.setDisable(true);
        comboPaisOrigen.setDisable(true);
        dateFechaVencimientoProducto.setDisable(true);





    }
    @FXML
    void seleccionarEnvasado(ActionEvent event) {
        checkProductoPerecedero.setSelected(false);
    checkProductoRefrigerado.setSelected(false);
    dateFechaEnvasado.setDisable(false);
    comboPaisOrigen.setDisable(false);
    txtPesoEnvaseProducto.setDisable(false);
    txtCodigoAprobacionOCA.setDisable(true);
    txtTemperaturaRecomendada.setDisable(true);
    dateFechaVencimientoProducto.setDisable(true);





    }
    @FXML
    void seleccionarPerecedero(ActionEvent event) {
        checkProductoEnvasado.setSelected(false);
        checkProductoRefrigerado.setSelected(false);
        dateFechaVencimientoProducto.setDisable(false);
        txtCodigoAprobacionOCA.setDisable(true);
        txtTemperaturaRecomendada.setDisable(true);
        dateFechaEnvasado.setDisable(true);
        txtPesoEnvaseProducto.setDisable(true);
        comboPaisOrigen.setDisable(true);



    }
    @FXML
    void seleccionarNatural(ActionEvent event) {
        checkPersonaJuridica.setSelected(false);
        txtNitCliente.setDisable(true);
        txtEmailCliente.setDisable(false);
        dateFechaNacimientoCliente.setDisable(false);


    }

    @FXML
    void agregarProductoVenta(ActionEvent event) {
        if(productoSeleccionadoVenta!= null){

        int cantidad = productoSeleccionadoVenta.getCantidadExistente();


            Producto producto = productoSeleccionadoVenta;
            producto.setCantidadExistente(Integer.parseInt(labelCantidadVenta.getText()));
        controllerVenta.agregarProducto(producto, listaProductosCarrito, tablaProductosCarrito);


        }
    }

    @FXML
    void sumarCantidadProducto(ActionEvent event) {
       int cantidad= Integer.parseInt(labelCantidadVenta.getText());
       cantidad = cantidad+1;
       labelCantidadVenta.setText(cantidad+"");
    }

    @FXML
    void restarCantidadProducto(ActionEvent event) {
        int cantidad= Integer.parseInt(labelCantidadVenta.getText());
        if(cantidad > 0) {
        cantidad = cantidad-1;
        labelCantidadVenta.setText(cantidad+"");
        }

    }

    @FXML
    void vender(ActionEvent event) {
        try {
            boolean estadoVenta = controllerVenta.vender(txtCodigoVenta, comboClienteVenta, txtIvaVenta, listaProductosCarrito,
                    listaVentas, tablaVentas, listaClientes);
            if( estadoVenta){
                mostrarMensaje("Notificación", "", "Venta registrada con éxito", Alert.AlertType.CONFIRMATION);
                limpiarCamposVenta();
            }else{
                mostrarMensaje("Notificación", "", "Por favor ingrese todos los datos", Alert.AlertType.ERROR);

            }
        }catch (Exception e){
            mostrarMensaje("Notificación", "", "Error al registrar la venta", Alert.AlertType.ERROR);


        }

    }
    public void limpiarCamposVenta(){
        txtCodigoVenta.setText("");
        comboClienteVenta.setValue(null);
        txtIvaVenta.setText("");
        listaProductosCarrito.clear();
        labelCantidadVenta.setText("1");
    }


    @FXML
    void editarVenta(ActionEvent event) {
        try{
        listaVentas.remove(ventaSeleccionada);
        boolean estadoVenta = controllerVenta.vender(txtCodigoVenta, comboClienteVenta, txtIvaVenta, listaProductosCarrito,
                listaVentas, tablaVentas, listaClientes);
        if (estadoVenta) {
            mostrarMensaje("Notificación", "", "Venta editada con éxito", Alert.AlertType.CONFIRMATION);
        }
           limpiarCamposVenta();
        }catch (Exception e) {
            mostrarMensaje("Notificación", "", "Error al editar la venta", Alert.AlertType.ERROR);

        }


    }

    @FXML
    void eliminarVenta(ActionEvent event) {
        controllerVenta.eliminarVenta(ventaSeleccionada, listaVentas, tablaVentas);
        limpiarCamposVenta();

    }
    @FXML
    private TableColumn<Producto, String> columnNombreProductoDisponible;
    @FXML
    private TableColumn<Producto, String> columnCodigoProductoDisponible;
    @FXML
    private TableColumn<Producto, String> columnCantidadProdutoDisponible;
    @FXML
    private TableColumn<Producto, String> columnValorProductoDisponible;



public void mostrarInformacionVenta(Venta venta){
    txtCodigoVenta.setText(venta.getCodigo());
    comboClienteVenta.setValue(venta.getCliente().getNombre());
    txtIvaVenta.setText(venta.getIva()+"");
    for( Detalle detalle : venta.getDetalles()){
        listaProductosCarrito.add(detalle.getProducto());
    }


}
    @FXML
    void initialize() {
        //datos iniciales

        listaPaises.addAll(Pais.values());
       comboPaisOrigen.setItems(listaPaises);
        txtNitCliente.setDisable(true);
        txtEmailCliente.setDisable(true);
        dateFechaNacimientoCliente.setDisable(true);
        ArrayList<Detalle> listaDetalles = new   ArrayList<>();
        Producto producto = new Producto("21231", "Leche", "Bolsa de leche x 1000lt", 80000, 4,
                new TipoProducto(new ProductoRefrigerado("213213", 22)));
        Detalle detalle = new Detalle(12, 123.3, producto);
        listaDetalles.add(detalle);
        Cliente cliente = new Cliente("Mariana", "Valencia", "1095550323", "Barrio Lindaraja", "3054027349",
                new TipoCliente(new PersonaNatural("marianavalencia", LocalDate.now())));
        listaNombresCliente.add(cliente.getNombre());
        comboClienteVenta.setItems(listaNombresCliente);
        agregarClienteCombo(cliente);
        //ventas
        Venta venta = new Venta ("12321", LocalDate.now(), listaDetalles, cliente, 200000, 19 );
        columnCodigoVenta.setCellValueFactory(new PropertyValueFactory<Venta, String>("codigo"));
        columnFechaVenta.setCellValueFactory(new PropertyValueFactory<Venta, LocalDate>("fecha"));
        columnClienteVenta.setCellValueFactory(new PropertyValueFactory<Venta, Cliente >("cliente"));
        columnCantidadVenta.setCellValueFactory(new PropertyValueFactory<Venta, Detalle>("detalles"));
        columnProductosVenta.setCellValueFactory(new PropertyValueFactory<Venta, Detalle>("detalles"));
        columnSubtotalVenta.setCellValueFactory(new PropertyValueFactory<Venta,Detalle >("detalles"));
        columnIvaVenta.setCellValueFactory(new PropertyValueFactory<Venta, String>("iva"));
        columnTotalVenta.setCellValueFactory(new PropertyValueFactory<Venta, String>("total"));
        tablaVentas.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
            ventaSeleccionada = newSelection ;
            mostrarInformacionVenta(ventaSeleccionada);

        });
        //producto
        columnCodigoProducto.setCellValueFactory(new PropertyValueFactory<Producto, String>("codigo"));
        columnNombreProducto.setCellValueFactory(new PropertyValueFactory<Producto, String>("nombre"));
        columnDescripcionProducto.setCellValueFactory(new PropertyValueFactory<Producto, String>("descripcion"));
        columnValorUnitarioProducto.setCellValueFactory(new PropertyValueFactory<Producto, String>("valorUnitario"));
        columnCantidadProducto.setCellValueFactory(new PropertyValueFactory<Producto, String>("cantidadExistente"));
        //cliente
        columnNombreCliente.setCellValueFactory(new PropertyValueFactory<Cliente, String>("nombre"));
        columnApellidoCliente.setCellValueFactory(new PropertyValueFactory<Cliente, String>("apellido"));
        columnIdentificacionCliente.setCellValueFactory(new PropertyValueFactory<Cliente, String>("identificacion"));
        columnDireccionCliente.setCellValueFactory(new PropertyValueFactory<Cliente, String>("direccion"));
        columnTelefonoCliente.setCellValueFactory(new PropertyValueFactory<Cliente, String>("telefono"));
        //tablas
        listaVentas.add(venta);
        listaClientes.add(cliente);
        tablaClientes.setItems(listaClientes);
        tablaVentas.setItems(listaVentas);
        listaProductos.add(producto);
        tablaProductos.setItems(listaProductos);
        tablaClientes.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
             clienteSeleccionado = newSelection ;
            mostrarInformacionCliente(clienteSeleccionado);

        });
        tablaProductosVenta.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
            productoSeleccionadoVenta = newSelection ;
        });
        txtPesoEnvaseProducto.setDisable(true);
        comboPaisOrigen.setDisable(true);
        dateFechaNacimientoCliente.setDisable(true);
        txtCodigoAprobacionOCA.setDisable(true);
        dateFechaEnvasado.setDisable(true);
        txtTemperaturaRecomendada.setDisable(true);
        dateFechaVencimientoProducto.setDisable(true);
        //producto seleccionado
        tablaProductos.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
            productoSeleccionado = newSelection ;
            mostrarInformacionProducto(productoSeleccionado);

        });
        //tablas venta productos disponibles
        columnCodigoProductoDisponible.setCellValueFactory(new PropertyValueFactory<Producto, String>("codigo"));
        columnNombreProductoDisponible.setCellValueFactory(new PropertyValueFactory<Producto, String>("nombre"));
        columnCantidadProdutoDisponible.setCellValueFactory(new PropertyValueFactory<Producto, String>("cantidadExistente"));
        columnValorProductoDisponible.setCellValueFactory(new  PropertyValueFactory<Producto, String>("valorUnitario"));
        tablaProductosVenta.setItems(listaProductos);
        //tablas venta productos en carrito
        columnCodigoCarrito.setCellValueFactory(new PropertyValueFactory<Producto, String>("codigo"));
        columnNombreCarrito.setCellValueFactory(new PropertyValueFactory<Producto, String>("nombre"));
        columnCantidadCarrito.setCellValueFactory(new PropertyValueFactory<Producto, String>("cantidadExistente"));
        columnValorCarrito.setCellValueFactory(new  PropertyValueFactory<Producto, String>("valorUnitario"));
        tablaProductosCarrito.setItems(listaProductosCarrito);





    }
    private void mostrarInformacionProducto(Producto producto) {
        txtCodigoProducto.setText(producto.getCodigo());
        txtNombreProducto.setText(producto.getNombre());
        txtDescripcionProducto.setText(producto.getDescripcion());
        txtValorUnitarioProducto.setText(producto.getValorUnitario()+"");
        txtCantidadProducto.setText(producto.getCantidadExistente()+"");
        if(producto.getTipoProducto().getProductoEnvasado()!= null) {
            checkProductoEnvasado.setSelected(true);
            checkProductoEnvasado.setSelected(true);
            checkProductoPerecedero.setSelected(false);
            checkProductoRefrigerado.setSelected(false);
            dateFechaEnvasado.setDisable(false);
            comboPaisOrigen.setDisable(false);
            txtPesoEnvaseProducto.setDisable(false);
            txtCodigoAprobacionOCA.setDisable(true);
            txtTemperaturaRecomendada.setDisable(true);
            dateFechaVencimientoProducto.setDisable(true);
            dateFechaEnvasado.setValue(producto.getTipoProducto().getProductoEnvasado().getFechaEnvasado());
            txtPesoEnvaseProducto.setText(producto.getTipoProducto().getProductoEnvasado().getPesoEnvase()+"");
            comboPaisOrigen.setValue(producto.getTipoProducto().getProductoEnvasado().getPaisOrigen());
        }
        if(producto.getTipoProducto().getProductoPerecedero()!=null) {
            checkProductoPerecedero.setSelected(true);
            checkProductoEnvasado.setSelected(false);
            checkProductoRefrigerado.setSelected(false);
            dateFechaVencimientoProducto.setDisable(false);
            txtCodigoAprobacionOCA.setDisable(true);
            txtTemperaturaRecomendada.setDisable(true);
            dateFechaEnvasado.setDisable(true);
            txtPesoEnvaseProducto.setDisable(true);
            comboPaisOrigen.setDisable(true);
            dateFechaVencimientoProducto.setValue(producto.getTipoProducto().getProductoPerecedero().getFechaVencimiento());
        }if(producto.getTipoProducto().getProductoRefrigerado()!=null) {
            checkProductoRefrigerado.setSelected(true);
            checkProductoEnvasado.setSelected(false);
            checkProductoPerecedero.setSelected(false);
            txtCodigoAprobacionOCA.setDisable(false);
            txtTemperaturaRecomendada.setDisable(false);
            dateFechaEnvasado.setDisable(true);
            txtPesoEnvaseProducto.setDisable(true);
            comboPaisOrigen.setDisable(true);
            dateFechaVencimientoProducto.setDisable(true);
            txtCodigoAprobacionOCA.setText(producto.getTipoProducto().getProductoRefrigerado().getCodigoControlOrganismoControl());
            txtTemperaturaRecomendada.setText(producto.getTipoProducto().getProductoRefrigerado().getTemperaturaRefrigeracionRecomendada()+ "");

        }

    }
    private void mostrarInformacionCliente(Cliente clienteSeleccionado) {


        if(clienteSeleccionado != null){
           txtNombreCliente.setText(clienteSeleccionado.getNombre());
           txtApellidoCliente.setText(clienteSeleccionado.getApellido());
           txtIdentificacionCliente.setText(clienteSeleccionado.getIdentificacion());
           txtDireccionCliente.setText(clienteSeleccionado.getDireccion());
           txtTelefonoCliente.setText(clienteSeleccionado.getTelefono());
           if(clienteSeleccionado.getTipoCliente().getPersonaNatural()!=null){
               checkPersonaNatural.setSelected(true);
               txtEmailCliente.setDisable(false);
               txtEmailCliente.setText(clienteSeleccionado.getTipoCliente().getPersonaNatural().getEmail());
               dateFechaNacimientoCliente.setDisable(false);
               dateFechaNacimientoCliente.setValue(clienteSeleccionado.getTipoCliente().getPersonaNatural().getFechaNacimiento());
           }else{
               checkPersonaJuridica.setSelected(true);
               txtNitCliente.setDisable(false);
               txtNitCliente.setText(clienteSeleccionado.getTipoCliente().getPersonaJuridica().getNit());

           }
        }

    }
}
