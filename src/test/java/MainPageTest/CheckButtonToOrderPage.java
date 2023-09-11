package MainPageTest;

import Pages.MainPage.MainPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.concurrent.TimeUnit;
import static org.junit.Assert.assertEquals;
public class CheckButtonToOrderPage
{
    private WebDriver chDriver;
    private MainPage mainPage;
    private String mainPageUrl = "https://qa-scooter.praktikum-services.ru/";
    private String orderUrl = "https://qa-scooter.praktikum-services.ru/order";
    @Before
    public void precondition()
    {
        WebDriverManager.chromedriver().setup();
        chDriver = new ChromeDriver();
        chDriver.get(mainPageUrl);
        mainPage = new MainPage(chDriver);
        chDriver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        mainPage.clickElement(mainPage.getLocatorCoockie());//кликаем на куки, чтобы оно не мешало
    }


    @Test
    public void checkEnabledButtonsToOrder()
    {
        chDriver.findElement(mainPage.getLocatorsToOrderPage()[0]).click();
        assertEquals(orderUrl, chDriver.getCurrentUrl());

        chDriver.navigate().back();

        chDriver.findElement(mainPage.getLocatorsToOrderPage()[1]).click();
        assertEquals(orderUrl, chDriver.getCurrentUrl());
    }

    @After
    public void tearDown()
    {
        chDriver.quit();
    }
}
