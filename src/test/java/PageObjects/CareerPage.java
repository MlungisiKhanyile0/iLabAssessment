package PageObjects;

import junit.framework.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.Random;
import java.util.concurrent.TimeUnit;

public class CareerPage {
    WebDriver driver;

    private By SAcareersbtn = By.linkText ("South Africa");
    private By topJob = By.xpath("//div//div//div//div//div//div//div//div//div//div//div//div//div[1]//div[2]//div[1]//a[1]");
    private By applybtn = By.xpath("//a[contains(text(),'Apply Online')]");

    private By applicantName = By.xpath("//input[@id='applicant_name']");

    private By applicantEmail= By.xpath("//input[@id='email']");

    private By cellNo= By.xpath("//input[@id='phone']");
    private By submitApplication= By.xpath("//input[@id='wpjb_submit']");
    private By validateApplication= By.xpath("//li[contains(text(),'You need to upload at least one file.')]");
    String expected= "You need to upload at least one file.";
//select country by clicking on the link
    public void choosLink(WebDriver driver)
    {
        this.driver= driver;
        driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
        WebElement salink = driver.findElement(SAcareersbtn);
        salink.click();
    }

    //select top job on the list by placeholder
    public void jobselect(WebDriver driver)
    {
        this.driver= driver;
        driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
        WebElement job = driver.findElement(topJob);
        job.click();
    }
//click apply online button
    public void setApplybtn(WebDriver driver)
    {
        this.driver= driver;
        driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
        WebElement clickapplybtn = driver.findElement(applybtn);
        clickapplybtn.click();

    }
    //Enter applicant name
    public void setApplycantName(WebDriver driver,String appname)
    {
        this.driver= driver;
        driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
        WebElement name = driver.findElement(applicantName);
        name.sendKeys(appname);
    }

    //Enter applicant email
    public void setApplycantEmail(WebDriver driver,String appEmail)
    {
        this.driver= driver;
        driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
        WebElement email = driver.findElement(applicantEmail);
        email.sendKeys(appEmail);
    }
    //create cell number
    public void createRandomInteger(WebDriver driver,long n)
    {
        long m = (int) Math.pow(10,n-1);
        long number = m + new Random().nextInt((int) (9* m));
        driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
        WebElement email = driver.findElement(cellNo);
        email.sendKeys("0"+number+" ");

       // System.out.print("0"+number+" ");

        //email.sendKeys(toString(number));
    }

    //Click submit application
    public void submitbtn(WebDriver driver)
    {
        this.driver= driver;
        driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
        WebElement subBtn = driver.findElement(submitApplication);
        subBtn.click();
    }
    //test validation
    public void testValidation(WebDriver driver)
    {
        this.driver= driver;
        driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
        String testval = driver.findElement(validateApplication).getText();
        Assert.assertEquals(expected,testval);
    }



}
