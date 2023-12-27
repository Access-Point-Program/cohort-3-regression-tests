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
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.safari.SafariDriver;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

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
            case "safari":
                return new SafariDriver();
            case "IE":
                return new InternetExplorerDriver();
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

        try {
          WebElement sidebarElement = driver.findElement(By.className("side-bar"));

          WebElement layoutEditorElement = driver.findElement(By.className("simulation-card"));

          WebElement settingsElement = driver.findElement(By.className("settings"));

          Integer gridLen = driver.findElements(By.className("type-picker")).size();
          
          assertTrue(sidebarElement.isDisplayed());
          assertTrue(layoutEditorElement.isDisplayed());
          assertTrue(settingsElement.isDisplayed());
          assertEquals(gridLen, 81);

        } catch (NoSuchElementException e) {
            System.out.println("No Such element Found. Error: " + e.getMessage());
            assertTrue(false);
        }
    }


    // User can add a new layout to the database

    @Given("the layout page loads")
    public void page_loads(){
        driver = decideDriver("chrome");
        driver.get("http://localhost:9003/");
    }

    @When("the user makes all nessesary inputs and clicks Save")
    public void edit_page(){

        List<WebElement> grid = driver.findElements(By.className("type-picker"));

        grid.get(0).click();
        

        System.out.println(grid.get(0).findElements(By.className("dropdown-center")).size());
    }

    @Then("the layout should be saved in the database")
    public void saved_in_database(){

    }





    // TODO: Figure out where the data convertions are happening and then run a get to the API then compare?

    // Idea 2: Fixture file.

    // Idea 3: Manual.
      
}