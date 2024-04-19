package pages;

import dev.failsafe.internal.util.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class HomePage extends BasePage {

    SearchBox searchBox ;
    By product_Price=By.xpath("//div[@class=\"a-section a-spacing-mini\"]");
    By cartCountLocator = By.id("nav-cart-count");
    By cartContainerLocator = By.id("nav-cart-count-container");
    By acceptCookiesLocator = By.id("sp-cc-accept");
    By productİncrease=By.id("a-autoid-0-announce");
    By quantity_number=By.id("quantity_10");
    By total_price=By.id("sc-subtotal-amount-buybox");

    public HomePage(WebDriver driver) {
        super(driver);
        searchBox = new SearchBox(driver);
    }

    public SearchBox searchBox(){
        return this.searchBox;
    }

    public boolean isProductCountUp() {
        return getCartCount() > 0 ;
    }

    public void goToCart() {
        clickElement(cartContainerLocator);
    }

    private int getCartCount(){
        String count = find(cartCountLocator).getText();
        return Integer.parseInt(count);
    }



    public void acceptCookies(){
        if (isDisplayed(acceptCookiesLocator)){
            clickElement(acceptCookiesLocator);
        }
    }

}