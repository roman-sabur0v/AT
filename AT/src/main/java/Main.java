import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        /*System.setProperty("webdriver.chrome.driver", "D:\\drivers\\chromedriver_win32\\chromedriver.exe");
        WebDriver wd = new ChromeDriver(); //создание драйвера
        wd.get("https://www.avito.ru/"); //запуск сайта по URL
        wd.manage().window().maximize(); //открытие окна в полноэкранном режиме
        wd.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); //время максимального ожидания получения элементов
        wd.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS); //время максимального ожидаения загрузки страницы

        wd.navigate().to("https://www.google.com/"); //аналог get
        System.out.println(wd.getPageSource()); //возвращает исходную разметку страницы (html документ в виде строки)
       */
        /*
        System.setProperty("webdriver.chrome.driver", "D:\\drivers\\chromedriver_win32\\chromedriver.exe");
        WebDriver wd = new ChromeDriver(); //создание драйвера
        wd.manage().window().maximize(); //открытие окна в полноэкранном режиме
        wd.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); //время максимального ожидания получения элементов
        //wd.manage().timeouts().pageLoadTimeout(15, TimeUnit.SECONDS); //время максимального ожидаения загрузки страницы
        wd.navigate().to("https://www.kinopoisk.ru/");
        WebElement searchParamsButton = wd.findElement(By.xpath("//a[@class='_1dp226jcDt_jum2k1IGKC_']"));
        searchParamsButton.click();
        wd.findElement(By.xpath("//input[@id='find_film']")).sendKeys("Назад в будущее");
        Select yearSelector = new Select(wd.findElement(By.xpath("//select[@id='to_year']")));
        yearSelector.selectByValue("1986");

        Select genreSelect = new Select(wd.findElement(By.xpath("//select[@id='m_act[genre]']")));
        List<WebElement> options = genreSelect.getOptions();
        for (int i=0; i<options.size(); i++) {
            System.out.println("Value = "+options.get(i).getAttribute("value") + " Text = " + options.get(i).getText());
        }
        genreSelect.selectByVisibleText("фантастика");
        genreSelect.selectByVisibleText("приключения");
        genreSelect.selectByValue("6");
        WebElement genreCheckbox = wd.findElement(By.xpath("//input[@id='m_act[genre_and]']"));
        if (!genreCheckbox.isSelected()) {
            genreCheckbox.click();
        }
        wd.findElement(By.xpath("//input[@class='el_18 submit nice_button']")).click();

        WebElement blockWithResults = wd.findElement(By.xpath("//div[@class='search_results search_results_last']"));
        List<WebElement> results = blockWithResults.findElements(By.xpath("./div[@class='element']"));
        for (int i=0; i<results.size(); i++) {
            try {
                System.out.println(results.get(i).findElement(By.xpath(".//div[@class='rating  ratingGreenBG']")).getText());
            }
            catch (NoSuchElementException e) {
                System.out.println("No rating for this film");
            }
        }
        //wd.quit();
         */
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
        Thread.sleep(2000); //аналогичная ситуация с задержкой и тут. P.s. работает раз через раз, не знаю почему
        WebElement deliveryCheckbox = wd.findElement(By.xpath("//label[@data-marker='delivery-filter']"));
        //клики производятся в рандомные точки поэтому нет никаких гарантий что попадется в чекбокс
        if (!deliveryCheckbox.isSelected()) {
           deliveryCheckbox.click();
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
    }
}
