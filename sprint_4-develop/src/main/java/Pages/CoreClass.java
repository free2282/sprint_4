package Pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
public abstract class CoreClass
{
    private WebDriver driver;
    public CoreClass(WebDriver driver)
    {
        this.driver = driver;
    }

    public void clickElement(By path)
    {
        driver.findElement(path).click();
    }
    public void setText(By path, String text)
    {
        driver.findElement(path).sendKeys(text);
    }
    public void waitLoadinglement(By path)
    {
        new WebDriverWait(driver, 4).until(ExpectedConditions.visibilityOfElementLocated(path));
    }
    public String getText(By path)
    {
        return driver.findElement(path).getText();
    }
}
