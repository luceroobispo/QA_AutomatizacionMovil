package com.nttdata.steps;

import com.nttdata.screens.ProductDetailScreen;
import com.nttdata.screens.ProductsListScreen;
import com.nttdata.screens.ShoppingCartScreen;
import org.junit.Assert;

public class SuaceLabsSteps {
    ProductsListScreen productsScreen;
    ProductDetailScreen productDetailScreen;
    ShoppingCartScreen shoppingCartScreen;

    public void validarPantallaProductos() {
        productsScreen.validarPantallaProductos();
    }

    public void verificarVisibilidadDeProductosEnGaleria() {
        productsScreen.verificarVisibilidadDeProductosEnGaleria();
    }

    public void agregarProductoAlCarrito(int cantidad, String nombreProducto) {
        productsScreen.seleccionarProducto(nombreProducto);
        productDetailScreen.seleccionarCantidadProducto(cantidad);
        productDetailScreen.agregarProductoAlCarrito();
    }

    public void validarProductoEnCarrito(String nombreProducto) {
        productDetailScreen.navegarAlCarrito();
        shoppingCartScreen.validarProductoEnCarrito(nombreProducto);
    }

    public void validarCantidadDeProductosEnCarrito(int cantidadProductos) {
        shoppingCartScreen.validarCantidadDeProductosEnCarrito(cantidadProductos);
    }

    public void calcularPrecioTotalProductos() {
        shoppingCartScreen.calcularPrecioTotalProductos();
    }
}
