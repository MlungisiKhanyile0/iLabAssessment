import PageObjects.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.*;

import java.io.*;
import java.util.Properties;

public class WholeWebsite {
    WebDriver driver;
    Manubar manuCls = new Manubar();
    CareerPage carpg = new CareerPage();
    ReadPropertyFile raedFile = new ReadPropertyFile();

    private final String propertyFilePath = "C://Users//Mlungisi Khanyile//IdeaProjects//iLabAssessment//src//test//java//Utility//config.properties";

    public WholeWebsite() throws FileNotFoundException {
    }
    @Parameters({"browser"})

   @BeforeTest

    public void connectWebdriver(String browser) throws Exception {

        Properties properties =new  Properties();
        InputStream is = new FileInputStream(propertyFilePath);
        properties.load(is);
        is.close();

        String url = properties.getProperty("URLlabel");;
        if (browser.equalsIgnoreCase("chrome")) {
            String driverPath = properties.getProperty("chromedriverPath");
            // Reading Property files
            System.setProperty("webdriver.chrome.driver",driverPath);
            driver = new ChromeDriver();
          }
        else if (browser.equalsIgnoreCase("Firefox")) {
            String driverPath = properties.getProperty("FireDriverPath");
            // Reading Property files
            System.setProperty("webdriver.gecko.driver",driverPath);
            driver = new FirefoxDriver();
        }
        else if (browser.equalsIgnoreCase("IE")) {
            String driverPath = properties.getProperty("IEDriverPath");
            // Reading Property files
            System.setProperty("webdriver.ie.driver",driverPath);
            driver = new InternetExplorerDriver();
        }

        driver.get(url);
        // con.webdriverCon(driver);
        driver.manage().window().maximize();
}

    // click career button button
    @Test(priority = 1)
    public void CareerAplication() throws IOException {
        // click career button button
        manuCls.CloseIframe(driver);
        manuCls.clickCareerBtn(driver);

        //Career page
        carpg.choosLink(driver);
        carpg.jobselect(driver);

        //apply online
        carpg.setApplybtn(driver);
        carpg.setApplycantName(driver, "Mlungisi");
        carpg.setApplycantEmail(driver, "automationAssessment@iLABQuality.com");

        //enter cellnumber
        carpg.createRandomInteger(driver, 9);
        //click submit application button

        carpg.submitbtn(driver);
        //Test verification

        carpg.testValidation(driver);
    }
   /* @AfterClass
        public void teardown()
        {
     // Go to home page
        manuCls.clickLogo(driver);
        this.driver.quit();
        }*/
    }


