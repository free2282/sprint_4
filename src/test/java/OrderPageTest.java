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

        private WebDriver chDriver;
        private OrderPage orderPage;
        private MainPage mainPage;
        private String mainPageUrl = "https://qa-scooter.praktikum-services.ru/";


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
        orderPage.clickElement(mainPage.getLocatorsToOrder()[0]);

        orderPage.setText(orderPage.getNameLocate(), name);
        orderPage.setText(orderPage.getSurNameLocate(), surname);
        orderPage.setText(orderPage.getAddressLocate(), address);
        orderPage.setText(orderPage.getPhoneLocate(), phone);
        orderPage.setStationMetro(station);


        orderPage.clickElement(orderPage.getNextButton());
        orderPage.waitLoadinglement(orderPage.getDateLocate());

        orderPage.setText(orderPage.getDateLocate(), date);
        orderPage.setScooterColour(colour);
        orderPage.setText(orderPage.getComment(), comment);
        orderPage.setPeriod(period);

        orderPage.clickElement(orderPage.getOrderFinalButton());

        orderPage.waitLoadinglement(orderPage.getYesButton());
        orderPage.clickElement(orderPage.getYesButton());

        chDriver.findElement(orderPage.getOrderSuccess());


    }
    @Before
    public void precondition()
    {
        WebDriverManager.chromedriver().setup();
        chDriver = new ChromeDriver();
        mainPage = new MainPage(chDriver);
        orderPage = new OrderPage(chDriver);
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
