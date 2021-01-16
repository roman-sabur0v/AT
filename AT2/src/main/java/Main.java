import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Main {

    //public static void main(String[] args) throws InterruptedException {
        /*
        System.setProperty("webdriver.chrome.driver", "D:\\drivers\\chromedriver_win32\\chromedriver.exe");
        WebDriver wd = new ChromeDriver(); //создание драйвера
        wd.manage().window().maximize(); //открытие окна в полноэкранном режиме
        wd.get("https://www.avito.ru/");
        Select category = new Select(wd.findElement(By.xpath("//select[@id='category']")));
        category.selectByValue("99");
        wd.findElement(By.xpath("//input[@id='search']")).sendKeys("Принтер");
        wd.findElement(By.xpath("//div[@class='main-locationWrapper-3C0pT']")).click();
        wd.findElement(By.xpath("//input[@class='suggest-input-3p8yi']")).sendKeys("Владивосток");
        Thread.sleep(500); //из-за задержек на сайте иногда нажимается республика Чувашия, необходимо выдержать паузу
        wd.findElement(By.xpath("//span[@class='suggest-suggest-content-KQ__w']")).click();
        wd.findElement(By.xpath("//button[@class='button-button-2Fo5k button-size-m-7jtw4 button-primary-1RhOG']")).click();

        WebElement deliveryCheckbox = wd.findElement(By.xpath("//label[@data-marker='delivery-filter']"));
        //клики производятся в рандомные точки поэтому нет никаких гарантий что попадется чекбокс
        //поэтому из данной ситуации хороший выход - использование JSExecutor-а.
        if (!deliveryCheckbox.isSelected()) {
            JavascriptExecutor jse = (JavascriptExecutor)wd;
            jse.executeScript("arguments[0].click()", deliveryCheckbox);
        }
        wd.findElement(By.xpath("//button[@data-marker='search-filters/submit-button']")).click();
        Select sort = new Select(wd.findElement(By.xpath("//div[@class='sort-select-3QxXG select-select-box-3LBfK " +
                        "select-size-s-2gvAy']/select[@class='select-select-3CHiM']")));
        sort.selectByValue("2");
        WebElement blockWithResults = wd.findElement(By.xpath("//div[@data-marker='catalog-serp']"));
        List<WebElement> catalog = blockWithResults.findElements(By.xpath("//div[@data-marker='catalog-serp']/div[@data-marker='item']"));
        for (int i = 0; i < 3; i++) {
            System.out.println(catalog.get(i).findElement(By.xpath(".//span[@itemprop='name']")).getText() + " " +
                    catalog.get(i).findElement(By.xpath(".//span[@data-marker='item-price']")).getText() + " руб.");
        }
         */

   // }
}
