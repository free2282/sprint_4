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
    private MainPage mainPage;
    private String mainPageUrl = "https://qa-scooter.praktikum-services.ru/";
    private String orderUrl = "https://qa-scooter.praktikum-services.ru/order";



    @Test
    public void checkTextAboutImportant()
    //Первый тест кейс
    {
        String[] arrOfActualHeader = new String[8];
        String[] arrOfActualBody = new String[8];
        for (int i = 0; i< mainPage.getLocatorsBodyQuestionAboutImportant().length; i++)
        {
            arrOfActualHeader[i] = mainPage.getText(mainPage.getLocatorsHeaderQuestionAboutImportant()[i]);
            mainPage.clickElement(mainPage.getLocatorsHeaderQuestionAboutImportant()[i]);
            mainPage.waitLoadinglement(mainPage.getLocatorsBodyQuestionAboutImportant()[i]);
            arrOfActualBody[i] = mainPage.getText(mainPage.getLocatorsBodyQuestionAboutImportant()[i]);
        }
        Assert.assertArrayEquals(arrOfActualHeader, mainPage.getExpectedHeaderTextsQuestionAboutImportant());
        Assert.assertArrayEquals(arrOfActualBody, mainPage.getExpectedBodyTextsQuestionAboutImportant());
    }
    @Test
    public void checkEnabledButtonsToOrder()
    {
        chDriver.findElement(mainPage.getLocatorsToOrder()[0]).click();
        assertEquals(orderUrl, chDriver.getCurrentUrl());

        chDriver.navigate().back();

        chDriver.findElement(mainPage.getLocatorsToOrder()[1]).click();
        assertEquals(orderUrl, chDriver.getCurrentUrl());
    }
    @Before
    public void precondition()
    {
        WebDriverManager.chromedriver().setup();
        chDriver = new ChromeDriver();
        chDriver.get(mainPageUrl);
        mainPage = new MainPage(chDriver);
        chDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        mainPage.clickElement(mainPage.getLocatorCoockie());//кликаем на куки, чтобы оно не мешало

    }
    @After
    public void tearDown()
    {
        chDriver.quit();
    }
}
