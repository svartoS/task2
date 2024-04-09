import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "chromedriver_win32/chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.get("https://wildberries.ru/");

        WebElement searchInput = driver.findElement(By.id(("searchInput")));
        searchInput.sendKeys("транспортир");
        searchInput.sendKeys(Keys.ENTER);

        Thread.sleep(1000);

        WebElement sortingItem1 = driver.findElement(By.className("sorter-mobile__btn"));
        sortingItem1.click();

        Thread.sleep(1000);

        WebElement sortingItem2 = driver.findElement(By.cssSelector("li[data-sorting-value='priceup']"));
        sortingItem2.click();

        Thread.sleep(1000);

        List<WebElement> products = driver.findElements(By.className("product-card__middle-wrap"));
        for (int i = 0; i < 10 && i < products.size(); i++) {
            WebElement product = products.get(i);
            String productName = product.findElement(By.className("product-card__name")).getText();
            String productPrice = product.findElement(By.tagName("del")).getText();
            System.out.println( i+1 +") Товар: " + productName + " Цена: " + productPrice);
        }

        Thread.sleep(1000);

        driver.quit();
    }
}