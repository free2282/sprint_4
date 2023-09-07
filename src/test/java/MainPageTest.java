import ru.yandex.practicum.Locators.LocatorsMainPage;
import ru.yandex.practicum.PageObject.MainPage.MainPage;
import ru.yandex.practicum.PageObject.OrderPage.OrderPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
public class MainPageTest
{
    private WebDriver chDriver;
    private LocatorsMainPage locatorsMainPage;
    private MainPage TestMainPage;
    private OrderPage TestOrderPage;
    private String mainPageUrl = "https://qa-scooter.praktikum-services.ru/";
    private String orderUrl = "https://qa-scooter.praktikum-services.ru/order";



    @Test
    public void checkTextAboutImportant()
    //Первый тест кейс
    {
        String[] arrOfActualHeader = new String[8];
        String[] arrOfActualBody = new String[8];
        for (int i = 0; i< locatorsMainPage.getLocatorsBodyQuestionAboutImportant().length; i++)
        {
            arrOfActualHeader[i] = TestMainPage.getTextOfElement(locatorsMainPage.getLocatorsHeaderQuestionAboutImportant()[i]);
            TestMainPage.clickElement(locatorsMainPage.getLocatorsHeaderQuestionAboutImportant()[i]);
            TestMainPage.waitLoadingElement(locatorsMainPage.getLocatorsBodyQuestionAboutImportant()[i]);
            arrOfActualBody[i] = TestMainPage.getTextOfElement(locatorsMainPage.getLocatorsBodyQuestionAboutImportant()[i]);

        }
        Assert.assertArrayEquals(arrOfActualHeader, TestMainPage.getExpectedHeaderTextsQuestionAboutImportant());
        Assert.assertArrayEquals(arrOfActualBody, TestMainPage.getExpectedBodyTextsQuestionAboutImportant());
    }
    @Test
    public void checkEnabledButtonsToOrder()
    {
        chDriver.findElement(locatorsMainPage.getLocatorsButtonMainPage()[0]).click();
        assertEquals(orderUrl, chDriver.getCurrentUrl());

        chDriver.navigate().back();

        chDriver.findElement(locatorsMainPage.getLocatorsButtonMainPage()[1]).click();
        assertEquals(orderUrl, chDriver.getCurrentUrl());
    }
    @Before
    public void precondition()
    {
        WebDriverManager.chromedriver().setup();
        chDriver = new ChromeDriver();
        chDriver.get(mainPageUrl);
        locatorsMainPage = new LocatorsMainPage();
        TestMainPage = new MainPage(chDriver);
        TestOrderPage = new OrderPage(chDriver);
        chDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        TestMainPage.clickElement(locatorsMainPage.getLocatorCoockie());//кликаем на куки, чтобы оно не мешало

    }
    @After
    public void tearDown()
    {
        chDriver.quit();
    }
}
