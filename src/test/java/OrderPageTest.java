import Pages.OrderPage.OrderPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.concurrent.TimeUnit;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
public class OrderPageTest
{
    private WebDriver chDriver;
    private OrderPage TestOrderPage;
    private String mainPageUrl = "https://qa-scooter.praktikum-services.ru/";
    private String orderUrl = "https://qa-scooter.praktikum-services.ru/order";


    @Test
    public void checkScooterRentPositeve()
    {
        for (int i=0;i<2;i++)
        {

            TestOrderPage.clickElement(TestOrderPage.getLocatorsButtonToOrder());


            for (int j=0;j<4;j++)
            {
                TestOrderPage.setTextToInput(TestOrderPage.getInputLocateTextOfOrder()[j], TestOrderPage.getDataForOrderTest()[i][j]);
                //заполняем имя, фамилия, улица, метро, телефон.
            }
            TestOrderPage.setTextToInput(TestOrderPage.getInputLocateTextOfOrder()[4], TestOrderPage.getDataForOrderTest()[i][4]); // вставляем станцию
            TestOrderPage.waitLoadingElement(TestOrderPage.getInputLocateTextOfOrder()[7]);
            TestOrderPage.clickElement(TestOrderPage.getInputLocateTextOfOrder()[7]);

            TestOrderPage.clickElement(TestOrderPage.getLocateButtonOnPageOrder()[1]);

            for (int j=5;j<7;j++)
            {
                TestOrderPage.setTextToInput(TestOrderPage.getInputLocateTextOfOrder()[j], TestOrderPage.getDataForOrderTest()[i][j]);
                //заполнение когда привезти и комментарий
            }

            TestOrderPage.clickElement(TestOrderPage.getInputLocateTextOfOrder()[8]); // заполнение срока аренды
            TestOrderPage.waitLoadingElement(TestOrderPage.getInputLocateTextOfOrder()[11]);
            TestOrderPage.clickElement(TestOrderPage.getInputLocateTextOfOrder()[11]);

            TestOrderPage.clickElement(TestOrderPage.getInputLocateTextOfOrder()[9]);
            TestOrderPage.clickElement(TestOrderPage.getInputLocateTextOfOrder()[10]);

            TestOrderPage.clickElement(TestOrderPage.getLocateButtonOnPageOrder()[0]);//Кнопка заказать
            TestOrderPage.clickElement(TestOrderPage.getLocateButtonOnPageOrder()[2]);//Кнопка Да

            chDriver.findElement(TestOrderPage.getLocateTextOfOrdering());
            chDriver.get(mainPageUrl);
        }
    }
    
    @Before
    public void precondition()
    {
        WebDriverManager.chromedriver().setup();
        chDriver = new ChromeDriver();
        chDriver.get(mainPageUrl);
        TestOrderPage = new OrderPage(chDriver);
        chDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }
    @After
    public void tearDown()
    {
        chDriver.quit();
    }
}
