package Pages.OrderPage;

import Pages.CoreClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class OrderPage extends CoreClass
{
    private WebDriver chDriver;
    public OrderPage(WebDriver chDriver)
    {
        super(chDriver);
    }


    private By name = By.xpath(".//input[@placeholder='* Имя']"); // строка ввода имени

    private By surname = By.xpath(".//input[@placeholder='* Фамилия']"); // строка ввода фамилии

    private By address = By.xpath(".//input[@placeholder='* Адрес: куда привезти заказ']"); // строка ввода адресса

    private By metroStationHead = By.xpath(".//input[@placeholder='* Станция метро']"); // строка ввода метро

    private By phone = By.xpath(".//input[@placeholder='* Телефон: на него позвонит курьер']"); //строка ввода телефона

    private By date = By.xpath(".//input[@placeholder='* Когда привезти самокат']"); // строка ввода даты

    private By comment = By.xpath(".//input[@placeholder='Комментарий для курьера']"); // строка ввода комментария

    private By rentalPeriod = By.xpath(".//div[@class='Dropdown-placeholder']"); //кнопка выпадения списка периодов аренды

    private By blackScooter = By.id("black"); //кнопк выбора чернгого самоката
    private By greyScooter = By.id("grey"); // кнопка выбора серого
    //кнопка далее
    private By nextButton = By.xpath(".//button[text()='Далее']"); //кнопка далоее
    //кнопка Заказать
    private By orderFinalButton = By.xpath(".//button[text()='Назад']/parent::div/button[text()='Заказать']"); // кнопка заказ


    private By yesButton = By.xpath(".//div[@class='Order_Content__bmtHS']/div[@class='Order_Modal__YZ-d3']/div[@class ='Order_Buttons__1xGrp']/button[text()='Да']");//кнопка Да для согласия со сделкой


    private By orderSuccess = By.className("Order_Modal__YZ-d3"); // Удостоверение в успешности заказа

    public By getNameLocate()
    {
        return name;
    }
    public By getSurNameLocate()
    {
        return surname;
    }
    public By getAddressLocate()
    {
        return address;
    }
    public By getPhoneLocate()
    {
        return phone;
    }
    public By getDateLocate()
    {
        return date;
    }
    public By getComment()
    {
        return comment;
    }
    public void setPeriod(String period)
    {
        this.clickElement(rentalPeriod);
        this.clickElement(By.xpath(".//*[contains(text(),'" + period + "')]"));
    }
    public By getBlackScooterLocate()
    {
        return blackScooter;
    }
    public By getGreyScooterLocate()
    {
        return greyScooter;
    }
    public By getNextButton()
    {
        return nextButton;
    }
    public By getOrderFinalButton()
    {
        return orderFinalButton;
    }
    public By getYesButton()
    {
        return yesButton;
    }
    public By getOrderSuccess()
    {
        return orderSuccess;
    }
    public void setScooterColour(String colour)
    {
        if (colour=="черный")
        {
            this.clickElement(getBlackScooterLocate());
        }
        else if(colour=="серый")
        {
            this.clickElement(getGreyScooterLocate());
        }
    }
    public By getMetroStationHead()
    {
        return metroStationHead;
    }
    public void setStationMetro(String station)
    {

        this.setText(getMetroStationHead(), station);
        this.waitLoadinglement(By.xpath(".//*[contains(text(),'"+station+"')]"));
        this.clickElement(By.xpath(".//*[contains(text(),'"+station+"')]"));


    }
    }



