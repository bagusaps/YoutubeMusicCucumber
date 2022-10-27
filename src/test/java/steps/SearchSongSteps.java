package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SearchSongSteps {
    WebDriver driver;

    @Given("open browser")
    public void openBrowser() {
        final String dir = System.getProperty("user.dir");
        System.out.println("current dir = " + dir);
        System.setProperty("webdriver.chrome.driver", dir+"/driver/chromedriver");
        driver = new ChromeDriver();
    }
    @Given("open youtube music")
    public void openYoutubeMusic() throws InterruptedException{
        driver.get("https://music.youtube.com/");
    }

    @Then("user in youtube music page")
    public void userInYoutubeMusicPage() {
        assert driver.findElement(By.xpath("//div[@class='left-content style-scope ytmusic-nav-bar']//picture[1]//img")).isDisplayed();
    }

    @When("user click search box")
    public void userClickSearchBox() {
        driver.findElement(By.xpath("//div[@class='search-container style-scope ytmusic-search-box']//tp-yt-paper-icon-button[1]//tp-yt-iron-icon")).click();
    }

    @And("user type {string} in searh box and enter")
    public void userTypeInSearhBoxAndEnter(String songTitle) {
        driver.findElement(By.xpath("//input[@id='input']")).sendKeys(songTitle);
        driver.findElement(By.xpath("//input[@id='input']")).sendKeys(Keys.ENTER);
    }

    @Then("user can see top result section")
    public void userCanSeeTopResultSection() throws InterruptedException {
        Thread.sleep(4000);
        assert driver.findElement(By.xpath("//div[@class='style-scope ytmusic-section-list-renderer']//ytmusic-shelf-renderer[1]")).isDisplayed();
        driver.close();
        driver.quit();
    }
}
