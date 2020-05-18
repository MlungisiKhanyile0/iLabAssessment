package PageObjects;


import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.concurrent.TimeUnit;

public class Manubar {
   WebDriver driver;
   private By framename = By.id("popmake-3738");

   private By careebtnLocatore = By.linkText("CAREERS");

   private By closePopup = By.xpath("//*[@id=\"popmake-3738\"]/button");

// closing popup window
    public void CloseIframe(WebDriver driver)
    {
    this.driver= driver;
    driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
    WebElement closeAlert = driver.findElement(closePopup);
    closeAlert.click();
    }
    public void clickCareerBtn(WebDriver driver)
    {
        this.driver= driver;
        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("scroll(250, 0)");
        js.executeScript("scroll(0, 250)");

        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        WebElement careered = driver.findElement(careebtnLocatore);
        careered.click();
    }

    public void clickLogo(WebDriver driver)
     {
      this.driver= driver;
      driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
      WebElement logo = driver.findElement(By.xpath("//header[@id='header']//div//div//div//a//img"));
      logo.click();
      }

}
