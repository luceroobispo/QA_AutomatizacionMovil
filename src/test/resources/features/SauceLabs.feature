@AddProductsToCart
 Feature: Gestionar el Carrito de Compras en Sauce Labs App

   @CartUpdateVerification
   Scenario Outline: Agregar productos al carrito de compras
     Given estoy en la aplicación de SauceLabs
     And valido que carguen correctamente los productos en la galeria
     When agrego <UNIDADES> del siguiente producto "<PRODUCTO>"
     Then valido que el carrito de compras actualice correctamente el producto "<PRODUCTO>"
     And valido que el carrito de compras muestre las <UNIDADES> de productos agregados
     And valido que el carrito de compras muestre el precio total de los productos agregados

     Examples:
       | PRODUCTO                  | UNIDADES |
       | Sauce Labs Backpack       | 1        |
       | Sauce Labs Bolt - T-Shirt | 1        |
       | Sauce Labs Bike Light     | 2        |
       | Sauce Labs Bolt T-Shirt   | 3        |