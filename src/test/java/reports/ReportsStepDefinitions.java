package reports;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

public class ReportsStepDefinitions {
    private final WebDriver driver = new FirefoxDriver();

    public int convert_to_index(String input) {
        switch (input) {
            case "first":
                return 0;
            case "second":
                return 1;
            case "third" :
                return 2;
        }
        return 0;
    }

    @Given("The reports page is loaded")
    public void create_page_loaded() {
        driver.get("http://localhost:9005");
    }

    @When("I read the title")
    public void i_read_the_title() {
    }

    @Then("The title is {string}")
    public void the_title_should_be(String expectedAnswer) {
        String pageTitle = driver.getTitle();
        assertEquals(expectedAnswer, pageTitle);
    }

    WebElement dropdownStuff;

    @When("I click on the {string} dropdown")
    public void i_click_the_dropdown_dropdown(String dropdownOption) throws InterruptedException {
        Thread.sleep(500);
        WebElement dropdown = driver.findElement(By.xpath("//button[text()=' " + dropdownOption + " ']"));
        this.dropdownStuff = dropdown;
        dropdown.click();
    }

    WebElement selected;
    String selectedText;

    @When("I click on the {string} option")
    public void i_click_on_the_dropdown_option_option(String dropdownOption) throws InterruptedException {
        Thread.sleep(500);
        Integer dropdownOptionConverted = convert_to_index(dropdownOption);
        List<WebElement> dropdownOptions = driver.findElements(By.className("dropdown-menu"));
        List<WebElement> dropdownItems = dropdownOptions.get(0).findElements(By.className("dropdown-item")); // need to change to be able to access both dropdowns, maybe using dropdownStuff global var?
        System.out.println(dropdownItems);
        System.out.println(dropdownOptions.get(0));
        this.selectedText = dropdownItems.get(dropdownOptionConverted).getText();
        System.out.println(this.selectedText);
        dropdownItems.get(dropdownOptionConverted).click();
//        System.out.println(dropdownOptions.get(0).getClass());
//        System.out.println(dropdownOptions.get(0).getLocation());
//        System.out.println(dropdownOptions.get(0).findElements(By.className("dropdown-item")));
    }

    @Then("I should see the {string} selected")
    public void i_should_see_the_dropdown_option_selected(String dropdownSelected) throws InterruptedException {
        assertEquals(this.dropdownStuff.getText(), this.selectedText);
    }
}
