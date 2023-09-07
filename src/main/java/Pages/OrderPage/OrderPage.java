package Pages.OrderPage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class OrderPage
{
    private WebDriver chDriver;

    public OrderPage(WebDriver chDriver)
    {
        this.chDriver = chDriver;
    }

    private String[][] dataForOrderTest =
            {
            {
                    "Иван",
                    "Сидоров",
                    "Улица Есенина, д.24, кв 75",
                    "+79295553099",
                    "Красносельская",
                    "30.08.2023",
                    "Позвоните на домофон",
            },
            {
                    "Тимофей",
                    "Шибаев",
                    "Улица Пушкина, д.24, кв 75",
                    "+79209411897",
                    "Красносельская",
                    "30.08.2023",
                    "Позвоните на домофон"
            }
            };
    private By locatorButtonToOrder = By.xpath(".//div[@class='Header_Nav__AGCXC'] /button[@class='Button_Button__ra12g']");
    //кнопка закаазть сверху основной страницы};
    private By[] inputLocateTextOfOrder=
            {
                    By.xpath(".//input[@placeholder='* Имя']"), //имЯ
                    By.xpath(".//input[@placeholder='* Фамилия']"), //фамилия
                    By.xpath(".//input[@placeholder='* Адрес: куда привезти заказ']"), //адресс
                    By.xpath(".//input[@placeholder='* Телефон: на него позвонит курьер']"),  // телефон
                    By.xpath(".//input[@placeholder='* Станция метро']"),//локатор input метро
                    By.xpath(".//input[@placeholder='* Когда привезти самокат']"), //дата
                    By.xpath(".//input[@placeholder='Комментарий для курьера']"), //комментарий
                    By.xpath(".//*[contains(text(),'Красносельская')]"),//локатор конкретного объекта, станции метро
                    By.className("Dropdown-arrow"), //срок аренды выбор элемента
                    By.xpath(".//input[@id='grey']"), // кнопка цвета
                    By.xpath(".//input[@id='black']"), // кнопка цвета
                    By.xpath(".//div[text()='сутки']")
            };// локаторы полей заполнения при заказе
    private By locateTextOfOrdering = By.className("Order_Modal__YZ-d3"); //локатор текста заказа - удостоверения оформления заказа
    private By[] locateButtonOnPageOrder =
            {
                    By.xpath(".//div[@class='Order_Content__bmtHS']/div[@class='Order_Buttons__1xGrp']/button[text()='Заказать']"), //кнопка заказать на странице заказа, чтобы оформить и "послать" данные на сервер, не перейти на страницу заказа
                    By.xpath(".//button[text()='Далее']"), //локатор для кнопки далее при заказе
                    By.xpath(".//div[@class='Order_Content__bmtHS']/div[@class='Order_Modal__YZ-d3']/div[@class ='Order_Buttons__1xGrp']/button[text()='Да']")//кнокпа да, подтверждение заказа
            }; // локаторы кнопок на стадии заказа
    public String[][] getDataForOrderTest()
    {
        return dataForOrderTest;
    }

    public void waitLoadingElement(By element)
    {
        new WebDriverWait(chDriver, 4).until(ExpectedConditions.visibilityOfElementLocated(element));
    }
    public void setTextToInput(By element, String text)
    {
         chDriver.findElement(element).sendKeys(text);
    }
    public void clickElement(By element)
    {
        chDriver.findElement(element).click();
    }
    public By[] getLocateButtonOnPageOrder()
    {
        return locateButtonOnPageOrder;
    }
    public By[] getInputLocateTextOfOrder()
    {
        return inputLocateTextOfOrder;
    }
    public By getLocateTextOfOrdering()
    {
        return locateTextOfOrdering;
    }
    public By getLocatorsButtonToOrder()
    {
        return locatorButtonToOrder;
    }
}
