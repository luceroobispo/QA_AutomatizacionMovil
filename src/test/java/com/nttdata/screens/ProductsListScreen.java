package com.nttdata.screens;

import io.appium.java_client.pagefactory.AndroidFindBy;
import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.core.pages.PageObject;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class ProductsListScreen extends PageObject {

    @AndroidFindBy(id = "com.saucelabs.mydemoapp.android:id/productTV")
    private WebElement productsListPageTitle;

    @AndroidFindBy(id = "com.saucelabs.mydemoapp.android:id/productRV")
    private WebElement productsGallery;

    public void validarPantallaProductos() {
        WebDriverWait wait = new WebDriverWait(getDriver(), 15);
        wait.until(ExpectedConditions.visibilityOf(productsListPageTitle));
    }

    public void verificarVisibilidadDeProductosEnGaleria() {
        WebDriverWait wait = new WebDriverWait(getDriver(), 5);

        // Esperar a que la galería de productos sea visible
        WebElement galleryElement = wait.until(ExpectedConditions.visibilityOf(productsGallery));

        // Obtener la lista de productos dentro de la galería
        List<WebElement> products = galleryElement.findElements(By.className("android.view.ViewGroup"));

        // Verificar que la lista de productos no esté vacía
        if (products.isEmpty()) {
            throw new AssertionError("No se encontraron productos en la galería.");
        }

        // Verificar que cada producto en la galería sea visible
        for (WebElement product : products) {
            if (!product.isDisplayed()) {
                throw new AssertionError("Un producto en la galería no es visible.");
            }
        }
    }

    public void seleccionarProducto(String nombreProducto) {
        WebDriverWait wait = new WebDriverWait(getDriver(), 10);
        String xpath = String.format("//android.widget.ImageView[@content-desc='%s']", nombreProducto);
        WebElement productImage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
        productImage.click();
    }
}
