package MainPageTest;

import Pages.MainPage.MainPage;
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
@RunWith(Parameterized.class)
public class TestCheckQuestionAboutImportant
{
    private WebDriver chDriver;
    private MainPage mainPage;
    private String mainPageUrl = "https://qa-scooter.praktikum-services.ru/";
    private String expectedHeader;
    private String expectedBody;
    private int orderOfElement;

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

    public TestCheckQuestionAboutImportant(String expectedHeader, String expectedBody, int orderOfElement)
    {
        this.expectedHeader = expectedHeader;
        this.expectedBody = expectedBody;
        this.orderOfElement = orderOfElement;
    }
    @Parameterized.Parameters
    public static Object[][] getQuest()
    {
        return new Object[][]
                {
                        {"Сколько это стоит? И как оплатить?","Сутки — 400 рублей. Оплата курьеру — наличными или картой.", 0},

                        {"Хочу сразу несколько самокатов! Так можно?","Пока что у нас так: один заказ — один самокат. Если хотите" +
                                " покататься с друзьями, можете просто сделать несколько" +
                                " заказов — один за другим.", 1},

                        {"Как рассчитывается время аренды?","Допустим, вы оформляете заказ на 8 мая. Мы привозим самокат 8 мая" +
                                " в течение дня. Отсчёт времени аренды начинается с момента," +
                                " когда вы оплатите заказ курьеру. Если мы привезли самокат" +
                                " 8 мая в 20:30, суточная аренда закончится 9 мая в 20:30.", 2},

                        { "Можно ли заказать самокат прямо на сегодня?", "Только начиная с завтрашнего дня. Но скоро станем расторопнее.", 3},

                        {"Можно ли продлить заказ или вернуть самокат раньше?", "Пока что нет! Но если что-то срочное — всегда можно позвонить" +
                                " в поддержку по красивому номеру 1010.", 4},

                        { "Вы привозите зарядку вместе с самокатом?", "Самокат приезжает к вам с полной зарядкой. Этого хватает на восемь" +
                                " суток — даже если будете кататься без передышек и во сне." +
                                " Зарядка не понадобится.", 5},

                        {"Можно ли отменить заказ?", "Да, пока самокат не привезли. Штрафа не будет, объяснительной записки" +
                                " тоже не попросим. Все же свои.", 6},

                        {"Я жизу за МКАДом, привезёте?", "Да, обязательно. Всем самокатов! И Москве, и Московской области.", 7}
                };
    }
    @Test
    public void checkQuestionAboutImportant()
    {
        String actualHeader = mainPage.getText(mainPage.getLocatorsQuestion()[orderOfElement]);
        mainPage.clickElement(mainPage.getLocatorsQuestion()[orderOfElement]);
        mainPage.waitLoadinglement(mainPage.getLocatorsAnswer()[orderOfElement]);
        String actualBody = mainPage.getText(mainPage.getLocatorsAnswer()[orderOfElement]);

        assertEquals("ошибка в " + orderOfElement + "ом элементе вопроса", expectedHeader, actualHeader);
        assertEquals("ошибка в " + orderOfElement + "ом элементе ответа", expectedBody, actualBody);
    }



    @After
    public void tearDown()
    {
        chDriver.quit();
    }
}
