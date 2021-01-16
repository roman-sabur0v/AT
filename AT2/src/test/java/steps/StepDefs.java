package steps;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.ParameterType;
import io.cucumber.java.ru.И;
import io.cucumber.java.ru.Пусть;
import io.cucumber.java.ru.Тогда;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StepDefs {

    private static WebDriver wd;

    @Пусть("открыт ресурс авито")
    public static void openAvito() {
        System.setProperty("webdriver.chrome.driver", "D:\\drivers\\chromedriver_win32\\chromedriver.exe");
        wd = new ChromeDriver();
        wd.manage().window().maximize(); //открытие окна в полноэкранном режиме
        wd.get("https://www.avito.ru/");
    }

    @ParameterType(".*")
    public Categories categories(String category) {
        return Categories.returnCategoryByName(category);
    }
    @И("в выпадающем списке категорий выбрана {categories}")
    public static void choseCategories(Categories category) {
        Select categoryToSelect = new Select(wd.findElement(By.xpath("//select[@id='category']")));
        categoryToSelect.selectByValue(category.getId());
    }

    @И("в поле поиска введено значение {word}")
    public static void writeValue(String text) {
        wd.findElement(By.xpath("//input[@id='search']")).sendKeys(text);
    }

    @Тогда("кликнуть по выпадающему списку региона")
    public static void clickRegion() {
        wd.findElement(By.xpath("//div[@class='main-locationWrapper-3C0pT']")).click();
    }

    @Тогда("в поле регион введено значение {word}")
    public static void writeRegion(String region) throws InterruptedException {
        wd.findElement(By.xpath("//input[@class='suggest-input-3p8yi']")).sendKeys(region);
        Thread.sleep(1000);
        wd.findElement(By.xpath("//span[@class='suggest-suggest-content-KQ__w']")).click();
    }

    @И("нажата кнопка показать объявления")
    public static void clickButton() {
        wd.findElement(By.xpath("//button[@class='button-button-2Fo5k button-size-m-7jtw4 button-primary-1RhOG']")).click();
    }

    @Тогда("открылась страница результаты по запросу {word}")
    public static void checkPage(String text) throws IncorrectParameterException {
        String title = wd.findElement(By.xpath("//h1[@class='page-title-text-WxwN3 page-title-inline-2v2CW']")).getText();
        Pattern pattern = Pattern.compile(text);
        Matcher matcher = pattern.matcher(title);
        if (!matcher.find())
            throw new IncorrectParameterException("Некорректный предмет поиска, ожидалось: " + text);
    }

    @И("активирован чекбокс только с фотографией")
    public static void checkCheckbox() {
        WebElement imagesOnlyCheckbox = wd.findElement(By.xpath("//input[@name='withImagesOnly']"));
        //клики производятся в рандомные точки поэтому нет никаких гарантий что попадется чекбокс
        //поэтому из данной ситуации хороший выход - использование JSExecutor-а.
        if (!imagesOnlyCheckbox.isSelected()) {
            JavascriptExecutor jse = (JavascriptExecutor)wd;
            jse.executeScript("arguments[0].click()", imagesOnlyCheckbox);
        }
    }

    @ParameterType(".*")
    public Sorts sorts(String sort) {
        return Sorts.valueOf(sort);
    }
    @И("в выпадающем списке сортировка выбрано значение {sorts}")
    public static void choseSort(Sorts sort) {
        wd.findElement(By.xpath("//button[@data-marker='search-filters/submit-button']")).click();
        Select sorter = new Select(wd.findElement(By.xpath("//div[@class='sort-select-3QxXG select-select-box-3LBfK " +
                "select-size-s-2gvAy']/select[@class='select-select-3CHiM']")));
        sorter.selectByValue(sort.getValue());
    }

    @И("в консоль выведено значение названия и цены {int} первых товаров")
    public static void print(int count) {
        WebElement blockWithResults = wd.findElement(By.xpath("//div[@data-marker='catalog-serp']"));
        List<WebElement> catalog = blockWithResults.findElements(By.xpath("//div[@data-marker='catalog-serp']/div[@data-marker='item']"));
        for (int i = 0; i < count; i++) {
            System.out.println(catalog.get(i).findElement(By.xpath(".//span[@itemprop='name']")).getText() + " " +
                    catalog.get(i).findElement(By.xpath(".//span[@data-marker='item-price']")).getText() + " руб.");
        }
    }
}
