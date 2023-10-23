package demo;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;


public class TestCases {
    ChromeDriver driver;
    public TestCases()
    {
        System.out.println("Constructor: TestCases");
        WebDriverManager.chromedriver().timeout(30).setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

    }

    public void endTest()
    {
        System.out.println("End Test: TestCases");
        driver.close();
        driver.quit();

    }

    
    public  void testCase01() throws InterruptedException{
          System.out.println("Start Test case: testCase01");

        // Navigate to https://in.bookmyshow.com/explore/home/chennai  using driver.get()
        driver.get("https://in.bookmyshow.com/explore/home/chennai ");
        driver.findElement(By.xpath("//div[@class='sc-133848s-1 sc-lnhrs7-6 sc-lnhrs7-8 fQuapp']")).click();
        Thread.sleep(2000);
        // Find all the image elements of recommende sctoin  Using Locator "XPath" //div[@class='commonStyles__FullWidgetWrapper-sc-133848s-4 iUlTEb']//img[@src]
        List<WebElement> images = driver.findElements(By.xpath("//div[@class='commonStyles__FullWidgetWrapper-sc-133848s-4 iUlTEb']//img[@src]"));
        Thread.sleep(2000);
        // Iterate over each element   Use getAttribute("src") to get links and print it
        for(WebElement image: images){
            String url = image.getAttribute("src");
            System.out.println("\n");
            System.out.println("Printing URL of Image: "+url);
            
        }
        
        //Below part of code doesnt work as BookMyshow dont load whole page when opened by Selenium
        // Find all the names and store it in list Using Locator "XPath" Use getAttribute("src") to get links and print it

        //  List<WebElement> names = driver.findElements(By.xpath("//div[@class='sc-7o7nez-0 zDfcI']"));
        //  String name = names.get(1).getText();
        //  System.out.println("Second Movie name is "+name);

        // Iterate over list and print second name using GetText()  
        // Find all Languages and stoer it in list Using Locator "Class" Name sc-7o7nez-0 veMGd
        // Iterate over list and print second languageusing GetText()  
        
        // List<WebElement> languages = driver.findElements(By.xpath("//div[@class='sc-7o7nez-0 veMGd']"));
        //  String language = languages.get(1).getText();
        //  System.out.println("Second Movie language is "+language);


        System.out.println("End Test case: testCase01");
    }


}
