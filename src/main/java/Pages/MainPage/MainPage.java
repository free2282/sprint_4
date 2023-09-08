package Pages.MainPage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MainPage
{
    private WebDriver chDriver;
    public MainPage(WebDriver chDriver)
    {
        this.chDriver = chDriver;
    }
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
    private By[] locatorsToOrder=
            {
                    By.xpath(".//div[@class='Header_Nav__AGCXC'] /button[@class='Button_Button__ra12g']"),//кнопка закаазть сверху основной страницы
                    By.xpath(".//div[@class='Home_RoadMap__2tal_'] /div/button[@class='Button_Button__ra12g Button_Middle__1CSJM']") //нопка заказать снизу страницы
            }; // массив локаторов кнопок перехода на страницу заказа на основной странице

    private By coockie = By.xpath(".//button[@class='App_CookieButton__3cvqF']");//локатор кнопки куки
    private String[] expectedHeaderTextsQuestionAboutImportant=
            {
                    "Сколько это стоит? И как оплатить?",
                    "Хочу сразу несколько самокатов! Так можно?",
                    "Как рассчитывается время аренды?",
                    "Можно ли заказать самокат прямо на сегодня?", "Можно ли продлить заказ или вернуть самокат раньше?",
                    "Вы привозите зарядку вместе с самокатом?", "Можно ли отменить заказ?", "Я жизу за МКАДом, привезёте?"
            }; //текст заголовков вопросов о ваджжном
    private String[] expectedBodyTextsQuestionAboutImportant={"Сутки — 400 рублей. Оплата курьеру — наличными или картой.",
            "Пока что у нас так: один заказ — один самокат. Если хотите покататься с друзьями, можете просто сделать несколько заказов — один за другим.",
            "Допустим, вы оформляете заказ на 8 мая. Мы привозим самокат 8 мая в течение дня. Отсчёт времени аренды начинается с момента, когда вы оплатите заказ курьеру. Если мы привезли самокат 8 мая в 20:30, суточная аренда закончится 9 мая в 20:30.",
            "Только начиная с завтрашнего дня. Но скоро станем расторопнее.", "Пока что нет! Но если что-то срочное — всегда можно позвонить в поддержку по красивому номеру 1010.",
            "Самокат приезжает к вам с полной зарядкой. Этого хватает на восемь суток — даже если будете кататься без передышек и во сне. Зарядка не понадобится.",
            "Да, пока самокат не привезли. Штрафа не будет, объяснительной записки тоже не попросим. Все же свои.", "Да, обязательно. Всем самокатов! И Москве, и Московской области."};


    public String[] getExpectedHeaderTextsQuestionAboutImportant()
    {
        return expectedHeaderTextsQuestionAboutImportant;
    }
    public String[] getExpectedBodyTextsQuestionAboutImportant()
    {
        return expectedBodyTextsQuestionAboutImportant;
    }
    public void waitLoadingElement(By element)
    {
        new WebDriverWait(chDriver, 4).until(ExpectedConditions.visibilityOfElementLocated(element));
    }
    public String getTextOfElement(By element)
    {
        return chDriver.findElement(element).getText();
    }
    public By[] getLocatorsHeaderQuestionAboutImportant()
    {
        return locatorsHeaderQuestionAboutImportant;
    }
    public By[] getLocatorsBodyQuestionAboutImportant()
    {
        return locatorsBodyQuestionAboutImportant;
    }
    public By[] getLocatorsToOrder()
    {
        return locatorsToOrder;
    }
    public By getLocatorCoockie()
    {
        return coockie;
    }
}
