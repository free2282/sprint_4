package PageObject.MainPage;

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
//текст ответов на вопросы о важном
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
    public void clickElement(By element)
    {
        chDriver.findElement(element).click();
    }
}
