import Pages.MainPage.MainPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.concurrent.TimeUnit;
import static org.junit.Assert.assertEquals;
public class MainPageTest
{
    private WebDriver chDriver;
    private MainPage TestMainPage;
    private String mainPageUrl = "https://qa-scooter.praktikum-services.ru/";
    private String orderUrl = "https://qa-scooter.praktikum-services.ru/order";



    @Test
    public void checkTextAboutImportant()
    //Первый тест кейс
    {
        String[] arrOfActualHeader = new String[8];
        String[] arrOfActualBody = new String[8];
        for (int i = 0; i< TestMainPage.getLocatorsBodyQuestionAboutImportant().length; i++)
        {
            arrOfActualHeader[i] = TestMainPage.getTextOfElement(TestMainPage.getLocatorsHeaderQuestionAboutImportant()[i]);
            TestMainPage.clickElement(TestMainPage.getLocatorsHeaderQuestionAboutImportant()[i]);
            TestMainPage.waitLoadingElement(TestMainPage.getLocatorsBodyQuestionAboutImportant()[i]);
            arrOfActualBody[i] = TestMainPage.getTextOfElement(TestMainPage.getLocatorsBodyQuestionAboutImportant()[i]);

        }
        Assert.assertArrayEquals(arrOfActualHeader, TestMainPage.getExpectedHeaderTextsQuestionAboutImportant());
        Assert.assertArrayEquals(arrOfActualBody, TestMainPage.getExpectedBodyTextsQuestionAboutImportant());
    }
    @Test
    public void checkEnabledButtonsToOrder()
    {
        chDriver.findElement(TestMainPage.getLocatorsButtonMainPage()[0]).click();
        assertEquals(orderUrl, chDriver.getCurrentUrl());

        chDriver.navigate().back();

        chDriver.findElement(TestMainPage.getLocatorsButtonMainPage()[1]).click();
        assertEquals(orderUrl, chDriver.getCurrentUrl());
    }
    @Before
    public void precondition()
    {
        WebDriverManager.chromedriver().setup();
        chDriver = new ChromeDriver();
        chDriver.get(mainPageUrl);
        TestMainPage = new MainPage(chDriver);
        chDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        TestMainPage.clickElement(TestMainPage.getLocatorCoockie());//кликаем на куки, чтобы оно не мешало

    }
    @After
    public void tearDown()
    {
        chDriver.quit();
    }
}
