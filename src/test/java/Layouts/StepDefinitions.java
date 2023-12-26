package Layouts;

import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import static org.junit.jupiter.api.Assertions.*;

public class StepDefinitions {

    private WebDriver driver;
    
    @After
    public void after(){
        driver.quit();
    }
   

    //  Page loads on <driver>

    private WebDriver decideDriver(String d){
        switch (d) {
            case "chrome":
                return new ChromeDriver();
            case "edge":
                return new EdgeDriver();
            case "firefox":
                return new FirefoxDriver();
            default:
                return new ChromeDriver();
        }
    }

    @Given("{string} browser exists")
    public void layouts_page(String browser) {
        driver = decideDriver(browser);
    }

    @When("the user goes or is redirected to {string}")
    public void is_rendered(String link) {
        try {
          driver.get(link);  
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Then("user is presented with the layouts page")
    public void on_the_browser() {
        assertEquals("React App", driver.getTitle());

        // test application
        WebElement sidebarElement;
        WebElement layoutEditorElement;
        WebElement settingsElement;
        Integer gridLen;
        try {
          sidebarElement = driver.findElement(By.className("side-bar"));

          layoutEditorElement = driver.findElement(By.className("simulation-card"));

          settingsElement = driver.findElement(By.className("settings"));

          gridLen = driver.findElements(By.className("type-picker")).size();
          


          // sidebar
          assertTrue(sidebarElement.isDisplayed());
          assertTrue(layoutEditorElement.isDisplayed());
          assertTrue(settingsElement.isDisplayed());
          assertEquals(gridLen, 81);

         


          

        } catch (NoSuchElementException e) {
            System.out.println("No Such element Found. Error: " + e.getMessage());
        }


    }
      
}