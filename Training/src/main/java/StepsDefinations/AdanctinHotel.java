package StepsDefinations;

import io.cucumber.java.en.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

public class AdanctinHotel {
    String url = "https://adactinhotelapp.com/index.php";
    WebDriver driver;

    @Given("Navigate to the adactin driving innovation website and login")
    public void navigate_to_the_adactin_driving_innovation_website_and_login() {

        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        driver= new ChromeDriver(options);
        driver.get(url);
        driver.manage().window().maximize();
    }
    @When("^User enter correct (.*) and (.*)$")
    public void user_enter_correct_autotestb_and_w858oz(String Username, String Password) {

        WebElement username = driver.findElement(By.id("username"));
        WebElement password = driver.findElement(By.id("password"));

        username.sendKeys(Username);
        password.sendKeys(Password);
    }
    @When("click login buton")
    public void click_login_buton() {
        WebElement loginBtn = driver.findElement(By.id("login"));
        loginBtn.click();
    }
    @When("^Navigate to (.*) and select London$")
    public void navigate_to_london_and_select_london(String location) {
        WebElement locationDrpdwn = driver.findElement(By.id("location"));
        Select drpdwn = new Select(locationDrpdwn);
        drpdwn.deselectByValue(location);
    }
    @When("Click search button")
    public void click_search_button() {
        WebElement searchbtn = driver.findElement(By.id("Submit"));
        searchbtn.click();
    }
    @When("Validate if there is a list of hotels returned")
    public void validate_if_there_is_a_list_of_hotels_returned() {
        WebElement locations =  driver.findElement(By.id("location_1"));

        Assert.assertTrue(locations.isDisplayed());
    }
    @Then("Click logout and close the browser")
    public void click_logout_and_close_the_browser() {
        WebElement logout = driver.findElement(By.linkText("Logout"));
        logout.click();
        driver.close();
    }

}
