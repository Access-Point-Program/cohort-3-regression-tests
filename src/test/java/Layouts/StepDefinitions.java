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

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class StepDefinitions {

    private WebDriver driver;
    
    @After
    public void after(){
        driver.quit();
    }
   

    //  Page loads on <driver>

    private WebDriver decideDriver(String browser){
        switch (browser) {
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


    // Add new Layouts

    @Given("the layout grid loads")
    public void page_loads(){
        driver = decideDriver("chrome");
        driver.get("http://localhost:9003/");
    }

    @When("the user makes all nessesary inputs and clicks Save")
    public void edit_page() throws InterruptedException{

        /*  class index. 
        container 
            -> row(s) {forEach} 
                -> type-picker(s) {forEach} 
                    -> dropdown-center 
                        -> button(collor checking), dropdown-menu 
                            -> a(3) -> respective divs. open, wall, robot, end.
        */

        List<WebElement> grid = driver.findElements(By.className("container"));

        System.out.println(grid.size());
        // random positions: make sure they are all unique
        HashMap<Integer, Integer> exceptions = new HashMap<>();

        // add a robot (if possible at a random position.)

        // add an end (if possible at a random position.)

        // add multiple walls. (random positions if possible)

        // type a name

        // click "save"



    }

    @Then("the layout should be saved in the database")
    public void saved_in_database(){

    }


    private HashMap<Integer, Integer> selectFromGrid(List<WebElement> grid, String type, HashMap<Integer, Integer> exceptions) throws InterruptedException{

        // Random algorithm, with accounting for algorithm.
        HashMap<Integer, Integer> values = new HashMap<>();
        while(values.isEmpty()){
            Integer f = (int)(Math.random() * 10) % 10;
        }
        grid.get(0).click();

        Thread.sleep(1000);
        
        grid.get(0).findElement(By.className(type)).click();
        
        // System.out.println(grid.get(0).findElement(By.tagName("button")).getAttribute("class"));

        assertTrue(grid.get(0).findElement(By.tagName("button")).getAttribute("class").contains(type));

        return exceptions;
    }




    // TODO: Figure out where the data convertions are happening and then run a get to the API then compare?

    // Idea 2: Fixture file.

    // Idea 3: Manual.
      
}