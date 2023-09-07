package ru.yandex.practicum.Locators;
import org.openqa.selenium.*;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
public class LocatorsMainPage
{

    private By[] locatorsHeaderQuestionAboutImportant =
            {
                    By.xpath(".//div[@aria-controls='accordion__panel-0']"),By.xpath(".//div[@aria-controls='accordion__panel-1']"),
                    By.xpath(".//div[@aria-controls='accordion__panel-2']"), By.xpath(".//div[@aria-controls='accordion__panel-3']"),
                    By.xpath(".//div[@aria-controls='accordion__panel-4']"),By.xpath(".//div[@aria-controls='accordion__panel-5']"),
                    By.xpath(".//div[@aria-controls='accordion__panel-6']"), By.xpath(".//div[@aria-controls='accordion__panel-7']")
            }; // массив локаторов кнопок с вопросами, от 0 до 7
    private By[] locatorsBodyQuestionAboutImportant =
            {
                    By.xpath(".//div[@aria-labelledby='accordion__heading-0']/p"), By.xpath(".//div[@aria-labelledby='accordion__heading-1']/p"),
                    By.xpath(".//div[@aria-labelledby='accordion__heading-2']/p"), By.xpath(".//div[@aria-labelledby='accordion__heading-3']/p"),
                    By.xpath(".//div[@aria-labelledby='accordion__heading-4']/p"), By.xpath(".//div[@aria-labelledby='accordion__heading-5']/p"),
                    By.xpath(".//div[@aria-labelledby='accordion__heading-6']/p"), By.xpath(".//div[@aria-labelledby='accordion__heading-7']/p")
            }; //массив локаторов текста под вопросами от 0 до 7
    private By[] LocatorsButtonOnMainPage =
            {
                    By.xpath(".//div[@class='Header_Nav__AGCXC'] /button[@class='Button_Button__ra12g']"),//кнопка закаазть сверху основной страницы
                    By.xpath(".//div[@class='Home_RoadMap__2tal_'] /div/button[@class='Button_Button__ra12g Button_Middle__1CSJM']") //нопка заказать снизу страницы
            }; // массив локаторов кнопок перехода на страницу заказа на основной странице

    private By coockie = By.xpath(".//button[@class='App_CookieButton__3cvqF']");//локатор кнопки куки
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
    public By[] getLocateButtonOnPageOrder()
    {
        return locateButtonOnPageOrder;
    }
    public By[] getLocatorsHeaderQuestionAboutImportant()
    {
        return locatorsHeaderQuestionAboutImportant;
    }
    public By[] getLocatorsBodyQuestionAboutImportant()
    {
        return locatorsBodyQuestionAboutImportant;
    }
    public By[] getLocatorsButtonMainPage()
    {
        return LocatorsButtonOnMainPage;
    }
    public By getLocatorCoockie()
    {
        return coockie;
    }
    public By[] getInputLocateTextOfOrder()
    {
        return inputLocateTextOfOrder;
    }
    public By getLocateTextOfOrdering()
    {
        return locateTextOfOrdering;
    }
}
