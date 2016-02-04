package practdev;  
import org.junit.After;  
import org.junit.AfterClass;  
import org.junit.Before;  
import org.junit.BeforeClass;  
import org.junit.Test;  
import org.junit.runner.RunWith;  
import org.junit.runners.JUnit4;  
import org.openqa.selenium.By;  
import org.openqa.selenium.WebDriver;  
import org.openqa.selenium.WebElement;  
import org.openqa.selenium.firefox.FirefoxDriver;  
import static org.junit.Assert.*;
@RunWith(JUnit4.class)  
public class UserManagerSeleniumTest {  
    private static WebDriver webDriver = null;       
    @BeforeClass  
    public static void beforeClass(){
        //This starts FireFox
        webDriver = new FirefoxDriver();     
    }  
    @Before  
    public void beforeTestCaseMethod() throws InterruptedException{
        //This points FireFox to the usermanager example,
        // for this to work the sample needs to run first
        webDriver.get("http://localhost:3000/useradd"); 
        Thread.sleep(3000);  
    }  
    @Test  
    public void testUserAdd() throws InterruptedException{
        //Now we find the name and surname boxes
        WebElement nameBox = webDriver.findElement(By.xpath("//input[@name='name']"));
        WebElement surnameBox = webDriver.findElement(By.xpath("//input[@name='surname']"));          
        //Now we submit our query
        nameBox.sendKeys("Alan");
        surnameBox.sendKeys("Turing");
        surnameBox.submit();//submit the form
        nameBox = webDriver.findElement(By.xpath("//div[@name='name']"));
        surnameBox = webDriver.findElement(By.xpath("//div[@name='surname']"));          
        System.out.println(nameBox.getText() + " " + surnameBox.getText());
        assertEquals(nameBox.getText() + " " + surnameBox.getText(), "Alan Turing");
        Thread.sleep(5000);  
    }  

    @After  
    public void afterTestCaseMethod() throws InterruptedException{  
        Thread.sleep(2000);  
    }  

    @AfterClass  
    public static void afterClass(){
        //clean up
        webDriver.quit();       
    }  
}  
