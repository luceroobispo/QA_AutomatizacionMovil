package com.nttdata.stepsdefinitions;

import com.nttdata.steps.SuaceLabsSteps;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;

public class SauceLabsStepDef {
    @Steps
    SuaceLabsSteps products;

    @Given("estoy en la aplicación de SauceLabs")
    public void estoyEnLaAplicaciónDeSauceLabs() {
        products.validarPantallaProductos();
    }

    @And("valido que carguen correctamente los productos en la galeria")
    public void validoQueCarguenCorrectamenteLosProductosEnLaGaleria() {
        products.verificarVisibilidadDeProductosEnGaleria();
    }

    @When("agrego {int} del siguiente producto {string}")
    public void agregoDelSiguienteProducto(int cantidad, String nombreProducto) {
        products.agregarProductoAlCarrito(cantidad, nombreProducto);
    }

    @Then("valido que el carrito de compras actualice correctamente el producto {string}")
    public void validoQueElCarritoDeComprasActualiceCorrectamenteElProducto(String nombreProducto) {
        products.validarProductoEnCarrito(nombreProducto);
    }

    @And("valido que el carrito de compras muestre las {int} de productos agregados")
    public void validoQueElCarritoDeComprasMuestreLasUnidadesDeProductosAgregados(int cantidadProductos) {
        products.validarCantidadDeProductosEnCarrito(cantidadProductos);
    }

    @And("valido que el carrito de compras muestre el precio total de los productos agregados")
    public void validoQueElCarritoDeComprasMuestreElPrecioTotalDeLosProductosAgregados() {
        products.calcularPrecioTotalProductos();
    }
}
