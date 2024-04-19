package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;



public class ProductDetailPage extends BasePage{

    By addToCartButtonLocator = By.id("add-to-cart-button");
    By priceElement= (By.xpath("//div[@class=\"sc-badge-price-to-pay\"]"));

    String priceString = priceElement.getText().replaceAll("[^0-9]", "");
    int price = Integer.parseInt(priceString);
    int quantity = 2;
    int totalPrice = price * quantity;
    By totalPriceElement = (By.xpath("//span[@id=\"sc-subtotal-amount-buybox\"]"));
    String totalPriceString = totalPriceElement.getText().replaceAll("[^0-9]", ""); // Sadece sayıları al
    int expectedTotalPrice = Integer.parseInt(totalPriceString);
    public ProductDetailPage(WebDriver driver) {
        super(driver);
    }

    public boolean isOnProductDetailPage() {
        return isDisplayed(addToCartButtonLocator);
    }

    public void addToCart() {
        clickElement(addToCartButtonLocator);
    }

    public void priceControl(){
        if (totalPrice == expectedTotalPrice) {
            System.out.println("Doğru! Ödeme toplamı, fiyat ile adet çarpımının sonucuna eşit.");
        } else {
            System.out.println("Hata! Ödeme toplamı, fiyat ile adet çarpımının sonucuna eşit değil.");
        }
    }
}