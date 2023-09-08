import Pages.CoreClass;
import Pages.MainPage.MainPage;
import Pages.OrderPage.OrderPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Objects;
import java.util.concurrent.TimeUnit;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(Parameterized.class)
public class OrderPageTest {
        private final String name;
        private final String surname;
        private final String address;
        private final String station;
        private final String phone;
        private final String date;
        private final String period;
        private final String colour;
        private final String comment;

        public OrderPageTest(String name, String surname,
                                    String address, String station, String phone,
                                    String date, String period, String colour, String comment) {
            this.name = name;
            this.surname = surname;
            this.address = address;
            this.station = station;
            this.phone = phone;
            this.date = date;
            this.period = period;
            this.colour = colour;
            this.comment = comment;
        }

        @Parameterized.Parameters
        public static Object[][] getQuest()
        {
            return new Object[][]
                    {
                    {"Иван", "Иванов", "Москва, Тверская 1",
                            "Сокольники", "89856906969", "05.09.2023", "сутки", "черный", "позвоните на телефон"},
                    {"Мария", "Петрова", "Новосибирск, Ленина 1",
                            "Тверская", "89070906923", "06.09.2023", "двое суток", "серый", "позвоните в домофон"}
            };
        }

    @Test
    public void OrderTest()
    {
        coreFunc.clickElement(mainPage.getLocatorsToOrder()[0]);

        coreFunc.setText(orderPage.getNameLocate(), name);
        coreFunc.setText(orderPage.getSurNameLocate(), surname);
        coreFunc.setText(orderPage.getAddressLocate(), address);
        coreFunc.setText(orderPage.getPhoneLocate(), phone);
        orderPage.setStationMetro(station);


        coreFunc.clickElement(orderPage.getNextButton());
        coreFunc.waitLoadinglement(orderPage.getDateLocate());

        coreFunc.setText(orderPage.getDateLocate(), date);
        orderPage.setScooterColour(colour);
        coreFunc.setText(orderPage.getComment(), comment);
        orderPage.setPeriod(period);

        coreFunc.clickElement(orderPage.getOrderFinalButton());

        coreFunc.waitLoadinglement(orderPage.getYesButton());
        coreFunc.clickElement(orderPage.getYesButton());

        chDriver.findElement(orderPage.getOrderSuccess());


    }

        private WebDriver chDriver;
        private OrderPage orderPage;
        private MainPage mainPage;
        private CoreClass coreFunc;
        private String mainPageUrl = "https://qa-scooter.praktikum-services.ru/";

    @Before
    public void precondition()
    {
        WebDriverManager.chromedriver().setup();
        chDriver = new ChromeDriver();
        mainPage = new MainPage(chDriver);
        orderPage = new OrderPage(chDriver);
        coreFunc = new CoreClass(chDriver);
        chDriver.get(mainPageUrl);
        orderPage = new OrderPage(chDriver);
        chDriver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
    }
    @After
    public void tearDown()
    {
        chDriver.quit();
    }
}
