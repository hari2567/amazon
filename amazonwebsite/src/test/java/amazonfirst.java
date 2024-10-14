import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import javax.imageio.IIOException;
import java.io.File;
import java.io.IOException;
import java.time.Duration;

public class amazonfirst {
  WebDriver driver;

  @Test
  public void setup() {

    System.setProperty("webdriver.chrome.driver", "C:\\Users\\91850\\Downloads\\chromedriver-win64 (3)\\chromedriver-win64\\chromedriver.exe");
    driver = new ChromeDriver();
    driver.get("https://www.amazon.in/");
    driver.manage().window().maximize();
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    WebElement accountsign=driver.findElement(By.xpath("//span[text()='Account & Lists']"));
    Actions a1=new Actions(driver);
    a1.moveToElement(accountsign).perform();
    WebElement button= driver.findElement(By.xpath("//span[text()='Sign in']"));
    button.click();
    JavascriptExecutor js=(JavascriptExecutor) driver;
    js.executeScript("window.scrollTo(0,500);");
    WebElement username= driver.findElement(By.xpath("//input[@id='ap_email']"));
    username.sendKeys("chandana@123");
    WebElement button2= driver.findElement(By.xpath("//input[@id='continue']"));
    button2.click();
    File srcFile=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
    try{
      FileUtils.copyFile(srcFile,new File("Sc1.png"));
    }catch (IOException e){
      e.printStackTrace();
    }
    driver.quit();
  }
}
