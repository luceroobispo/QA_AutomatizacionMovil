package com.nttdata.screens;

import io.appium.java_client.pagefactory.AndroidFindBy;
import net.serenitybdd.core.pages.PageObject;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ShoppingCartScreen extends PageObject {

    @AndroidFindBy(id = "com.saucelabs.mydemoapp.android:id/titleTV")
    private WebElement shoppingCartPageTitle;

    @AndroidFindBy(id = "com.saucelabs.mydemoapp.android:id/noTV")
    private WebElement quantityProducts;

    @AndroidFindBy(id = "com.saucelabs.mydemoapp.android:id/totalPriceTV")
    private WebElement totalPrice;

    @AndroidFindBy(id = "com.saucelabs.mydemoapp.android:id/priceTV")
    private WebElement productPrice;

    public void validarProductoEnCarrito(String nombreProducto) {
        WebDriverWait wait = new WebDriverWait(getDriver(), 10);
        wait.until(ExpectedConditions.visibilityOf(shoppingCartPageTitle));
        Assert.assertEquals("El producto no se agregó al carrito.", nombreProducto, shoppingCartPageTitle.getText());
    }

    public void validarCantidadDeProductosEnCarrito(int cantidadProductos) {
        WebDriverWait wait = new WebDriverWait(getDriver(), 10);
        wait.until(ExpectedConditions.visibilityOf(quantityProducts));
        Assert.assertEquals("La cantidad de productos en el carrito no es la esperada.", cantidadProductos, Integer.parseInt(quantityProducts.getText().trim()));
    }

    public float parsePriceText(String priceText) {
        String numericText = priceText.replaceAll("[^\\d.]", "");
        return Float.parseFloat(numericText);
    }

    public void calcularPrecioTotalProductos() {
        float totalPriceElement = parsePriceText(totalPrice.getText().trim());
        float quantityProductsElement = parsePriceText(quantityProducts.getText().trim());
        float productPriceElement = parsePriceText(productPrice.getText().trim());

        Assert.assertEquals("El precio total de los productos no es el esperado.",
                quantityProductsElement * productPriceElement,
                totalPriceElement,
                0.01);
    }

}
