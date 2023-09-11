package Pages.MainPage;

import Pages.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class MainPage extends BasePage
{
    private WebDriver chDriver;
    public MainPage(WebDriver chDriver)
    {
        super(chDriver);
    }
    private By[] locatorsQuestion =
            {
                    By.xpath(".//div[@aria-controls='accordion__panel-0']"), //0ый вопрос
                    By.xpath(".//div[@aria-controls='accordion__panel-1']"), //1ой вопрос
                    By.xpath(".//div[@aria-controls='accordion__panel-2']"), //2ий вопрос
                    By.xpath(".//div[@aria-controls='accordion__panel-3']"), //3ый вопрос
                    By.xpath(".//div[@aria-controls='accordion__panel-4']"), //4ый вопрос
                    By.xpath(".//div[@aria-controls='accordion__panel-5']"), //5ой вопрос
                    By.xpath(".//div[@aria-controls='accordion__panel-6']"), //6ой вопрос
                    By.xpath(".//div[@aria-controls='accordion__panel-7']")  //7ой вопрос
            }; // массив локаторов кнопок с вопросами, от 0 до 7
    private By[] locatorsAnswer =
            {
                    By.xpath(".//div[@aria-labelledby='accordion__heading-0']/p"), //1ый ответ
                    By.xpath(".//div[@aria-labelledby='accordion__heading-1']/p"), //2ой ответ
                    By.xpath(".//div[@aria-labelledby='accordion__heading-2']/p"), //3ий ответ
                    By.xpath(".//div[@aria-labelledby='accordion__heading-3']/p"), //4ый ответ
                    By.xpath(".//div[@aria-labelledby='accordion__heading-4']/p"), //5ый ответ
                    By.xpath(".//div[@aria-labelledby='accordion__heading-5']/p"), //6ой ответ
                    By.xpath(".//div[@aria-labelledby='accordion__heading-6']/p"), //7ой ответ
                    By.xpath(".//div[@aria-labelledby='accordion__heading-7']/p")  //8ой ответ
            }; //массив локаторов ответов на вопросы от 0 до 7
    private By[] locatorsToOrderPage=
            {
                    By.xpath(".//div[@class='Header_Nav__AGCXC'] /button[@class='Button_Button__ra12g']"),//кнопка закаазть сверху основной страницы
                    By.xpath(".//div[@class='Home_RoadMap__2tal_'] /div/button[@class='Button_Button__ra12g Button_Middle__1CSJM']") //нопка заказать снизу страницы
            }; // массив локаторов кнопок перехода на страницу заказа на основной странице

    private By coockie = By.xpath(".//button[@class='App_CookieButton__3cvqF']");//локатор кнопки куки


    public By[] getLocatorsQuestion()
    {
        return locatorsQuestion;
    }
    public By[] getLocatorsAnswer()
    {
        return locatorsAnswer;
    }
    public By[] getLocatorsToOrderPage()
    {
        return locatorsToOrderPage;
    }
    public By getLocatorCoockie()
    {
        return coockie;
    }
}