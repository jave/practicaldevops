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
 @RunWith(JUnit4.class)  
 public class HelloSeleniumTest {  
      private static WebDriver webDriver = null;       
      @BeforeClass  
      public static void beforeClass(){
          //This starts FireFox
           webDriver = new FirefoxDriver();     
      }  
      @Before  
      public void beforeTestCaseMethod() throws InterruptedException{
          //This points FireFox to google
           webDriver.get("http://www.google.com"); 
           Thread.sleep(3000);  
      }  
      @Test  
      public void testHelloWorldSearch() throws InterruptedException{
          //Now we find the search box
          WebElement googleSearchBox = webDriver.findElement(By.xpath("//input[@name='q']"));
          //Now we submit our query
           googleSearchBox.sendKeys("Hello World\n");
           googleSearchBox.submit();
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
