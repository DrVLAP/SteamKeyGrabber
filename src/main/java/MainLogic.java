import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Created by First on 14.06.2016.
 */


public class MainLogic {

    public WebDriver driver;
    public String loginword;
    public Integer botindex;


    @BeforeMethod
    public void setUp(){
        driver = new FirefoxDriver();

    }

    @Test
    public void gameGrabber() throws InterruptedException {
        JavascriptExecutor jse = (JavascriptExecutor)driver;
        for (String bot: login)
        {
            botindex = login.indexOf(bot);
            authorize();

            WebElement tasklistbutton;
            WebElement closedeviceselect;
            Thread.sleep(5000);

//            driver.get("http://steamunlock.com/#earnpoints");

            tasklistbutton = driver.findElement(By.className("earn"));
            tasklistbutton.click();
            Thread.sleep(3000);

            driver.get("http://steamunlock.com/#earnpoints");
            Thread.sleep(5000);
            //driver.switchTo().frame(driver.findElements(By.id("App").get(0));
           // driver.switchTo().defaultContent();
           WebElement frame = driver.findElement(By.id("gatemedia-wall"));
            driver.switchTo().frame(frame);
            /*closedeviceselect = driver.findElement(By.xpath("//*[@id='App']/div/div[4]/div/div/div[2]/div/div[2]/button"));
            closedeviceselect.click();*/
           // driver.switchTo().defaultContent();

            jse.executeScript("scroll(0, 2500);");
            Thread.sleep(10000);
            jse.executeScript("scroll(0, 250);");
            Thread.sleep(10000);
            jse.executeScript("scroll(0, 250);");
            Thread.sleep(10000);
            jse.executeScript("scroll(0, 250);");
            Thread.sleep(10000);
            jse.executeScript("scroll(0, 250);");
            Thread.sleep(10000);
            jse.executeScript("scroll(0, 250);");
            Thread.sleep(10000);
        }


    }

    private void authorize() throws InterruptedException{

        WebElement loginfield;
        WebElement passfield;
        WebElement loginbutton;
        WebElement authButton;

        driver.manage().window();
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        driver.get("http://steamunlock.com/index.php?do=login#login");
        Thread.sleep(10000);
        driver.get("http://steamunlock.com/index.php?do=login#login");
        /*loginbutton = driver.findElement(By.className("fa fa-sign-in"));
        loginbutton.click();*/

        loginfield = driver.findElement(By.name("login_name"));
        passfield = driver.findElement(By.name("login_password"));
        authButton = driver.findElement(By.xpath(".//*[@id='login']/div/div[1]/form/input[1]"));

        loginfield.clear();
        passfield.clear();

        String[] pairs = login.get(botindex).split("-");
        loginword = pairs[0];
        String password = pairs[1];

        loginfield.sendKeys(loginword);
        passfield.sendKeys(password);
        authButton.click();
        Thread.sleep(1000);
    }

   /* public List<String> maketasklist() throws InterruptedException{
        WebElement tasklistbutton;

        Thread.sleep(5000);
        tasklistbutton = driver.findElement(By.className("earn"));
        tasklistbutton.click();

                //window.scrollBy(0,50);
        //for (int t = 1; p++)

    }*/

    public List<String> login = loginpass();

    public List<String> loginpass() {
        List<String> loginlist = new ArrayList<String>();
        loginlist.add("vassteam-123456");

        return loginlist;
    }

    public void registerclient(){


    }
    //http://steamunlock.com/index.php?do=register

}
