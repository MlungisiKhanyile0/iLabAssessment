package PageObjects;

import junit.framework.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class CareerPage {
    WebDriver driver;

    private final String propertyFilePath = "C://Users//Mlungisi Khanyile//IdeaProjects//iLabAssessment//src//test//java//Utility//config.properties";

    Properties properties =new  Properties();
    InputStream is = new FileInputStream(propertyFilePath);

    String expected= "You need to upload at least one file.";

    public CareerPage() throws FileNotFoundException {
    }
    //select country by clicking on the link
    public void choosLink(WebDriver driver) throws IOException
    {
        properties.load(is);
        is.close();

        this.driver= driver;
        driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
        By SAcareersbtn = By.linkText (properties.getProperty("country"));
        WebElement salink = driver.findElement(SAcareersbtn);
        salink.click();
    }

    //select top job on the list by placeholder
    public void jobselect(WebDriver driver) throws IOException
    {
        is.close();

        this.driver= driver;
        driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
        By topJob = By.xpath(properties.getProperty("selecttopJob"));
        WebElement selectjob = driver.findElement(topJob);
        selectjob.click();
    }
//click apply online button
    public void setApplybtn(WebDriver driver) throws IOException {

        is.close();

        this.driver= driver;
        driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
        By applybtn = By.xpath(properties.getProperty("btnApply"));
        WebElement clickapplybtn = driver.findElement(applybtn);
        clickapplybtn.click();

    }
    //Enter applicant name
    public void setApplycantName(WebDriver driver,String appname) throws IOException {

        is.close();

        this.driver= driver;
        driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
        By applicantName = By.xpath(properties.getProperty("ApplicantName"));
        WebElement name = driver.findElement(applicantName);
        name.sendKeys(appname);
    }

    //Enter applicant email
    public void setApplycantEmail(WebDriver driver,String appEmail) throws IOException {

        is.close();

        this.driver= driver;
        driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
        By applicantEmail= By.xpath(properties.getProperty("appEmail"));
        WebElement email = driver.findElement(applicantEmail);
        email.sendKeys(appEmail);
    }
    //create cell number
    public void createRandomInteger(WebDriver driver,long n) throws IOException
    {
        is.close();
        long m = (int) Math.pow(10,n-1);
        long number = m + new Random().nextInt((int) (9* m));
        driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
        By cellNo= By.xpath(properties.getProperty("appCellNo"));
        WebElement email = driver.findElement(cellNo);
        email.sendKeys("0"+number+" ");

        // System.out.print("0"+number+" ");
        //email.sendKeys(toString(number));
    }

    //Click submit application
    public void submitbtn(WebDriver driver) throws IOException
    {
        is.close();
        this.driver= driver;
        driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
        By submitApplication= By.xpath(properties.getProperty("submitApplication"));
        WebElement subBtn = driver.findElement(submitApplication);
        subBtn.click();
    }
    //test validation
    public void testValidation(WebDriver driver) throws IOException {

        is.close();
        this.driver= driver;
        driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
        By validateApplication= By.xpath(properties.getProperty("testvalid"));
        String testval = driver.findElement(validateApplication).getText();
        Assert.assertEquals(expected,testval);
    }



}
