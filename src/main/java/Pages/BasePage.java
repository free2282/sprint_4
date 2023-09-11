package Pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
public abstract class BasePage
{
    private WebDriver chDriver;
    public BasePage(WebDriver driver)
    {
        this.chDriver = driver;
    }

    public void clickElement(By path)
    {
        chDriver.findElement(path).click();
    }
    public void setText(By path, String text)
    {
        chDriver.findElement(path).sendKeys(text);
    }
    public void waitLoadinglement(By path)
    {
        new WebDriverWait(chDriver, 4).until(ExpectedConditions.visibilityOfElementLocated(path));
    }
    public String getText(By path)
    {
        return chDriver.findElement(path).getText();
    }
}
