package com.nttdata.screens;

import io.appium.java_client.pagefactory.AndroidFindBy;
import net.serenitybdd.core.pages.PageObject;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class ProductDetailScreen extends PageObject {

    @AndroidFindBy(id = "com.saucelabs.mydemoapp.android:id/plusIV")
    private WebElement addQuantityButton;

    @AndroidFindBy(id = "com.saucelabs.mydemoapp.android:id/noTV")
    private WebElement quantityProducts;

    @AndroidFindBy(id = "com.saucelabs.mydemoapp.android:id/cartBt")
    private WebElement addProductToCartButton;

    @AndroidFindBy(id = "com.saucelabs.mydemoapp.android:id/cartIV")
    private WebElement shoppingCartButton;

    public void seleccionarCantidadProducto(int quantity) {
        WebDriverWait wait = new WebDriverWait(getDriver(), 10);

        // Obtener cantidad actual
        WebElement currentQuantityElement = wait.until(ExpectedConditions.visibilityOf(quantityProducts));
        int currentQuantity = Integer.parseInt(currentQuantityElement.getText().trim());

        // Verificar que la cantidad actual sea igual a la cantidad esperada
        if(currentQuantity == quantity) {
            System.out.println("La cantidad de productos ya es la esperada.");
            return;
        }
        else{
            for (int i = currentQuantity; i < quantity; i++) {
                WebElement addProductButton = wait.until(ExpectedConditions.visibilityOf(addQuantityButton));
                addProductButton.click();
            }
            WebElement updatedQuantityElement = wait.until(ExpectedConditions.visibilityOf(quantityProducts));
            int updatedQuantity = Integer.parseInt(updatedQuantityElement.getText().trim());
            Assert.assertEquals("La cantidad de productos no coincide con la cantidad esperada.", quantity, updatedQuantity);
        }
    }

    public void agregarProductoAlCarrito() {
        addProductToCartButton.click();
    }

    public void navegarAlCarrito() {
        WebDriverWait wait = new WebDriverWait(getDriver(), 10);
        shoppingCartButton.click();
    }
}
