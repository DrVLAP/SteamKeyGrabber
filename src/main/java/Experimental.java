import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

/**
 * Created by First on 14.06.2016.
 */


public class Experimental {

    public WebDriver driver;
    public String loginword;
    public Integer botindex;
    public String botname;
    public String botlastname;
    Random random = new Random();
    JavascriptExecutor jse;
    public String passChars = "abcdefghijklmnopqrstuvwxyz1234567890";
    String password;

    @BeforeMethod
    public void setUp(){
        driver = new FirefoxDriver();
        jse = (JavascriptExecutor) driver;
        driver.manage().window();
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
    }

    public void registerclient() throws InterruptedException {
        nameSelect();
        lastnameSelect();
        passwordGen();
        System.out.println(password);
        driver.get("https://accounts.google.com/SignUp?service=accountsettings");
        driver.findElement(By.id("FirstName")).sendKeys(botname);
        System.out.println("Client's name - "+ botname);
        driver.findElement(By.id("LastName")).sendKeys(botlastname);
        System.out.println("Client's lastname - "+ botlastname);
        //driver.findElement(By.id("GmailAddress")).sendKeys(botname, botlastname);
        driver.findElement(By.id("GmailAddress")).sendKeys("dr.vlap");
        Thread.sleep(3000);

        driver.findElement(By.id("Passwd")).click();
        //jse.executeScript("document.getElementById('username-suggestions').focus();");
        Thread.sleep(3000);
        //Boolean suggestionshow = driver.findElements(By.id("username-suggestions")).size()>0;
        //Boolean suggestionshow = driver.findElements(By.id("username-suggestions")).;
        /*if (suggestionshow == true)*/
        System.out.println ("Поиск элемента предложенных email на подъезде");
        if (driver.findElement(By.id("username-suggestions")).isDisplayed())
            {
                /*System.out.println ("Объект найден, поиск ");
                List<WebElement> suggestions = driver.findElements(By.id("username-suggestions")).;
                String email = suggestions.get(0).getAttribute("href");*/
                WebElement email = driver.findElement(By.xpath(".//*[@id='username-suggestions']/a[1]"));
                //System.out.println (email.getAttribute("a"));
                System.out.println(String.valueOf("Client's email - " + driver.findElement(By.xpath(".//*[@id='username-suggestions']/a[1]")).getText()) + "@gmail.com");
                //System.out.println("Client's email - " + suggestions.get(0).getAttribute("href") + "@gmail.com");
                Thread.sleep(3000);
                email.click();
                //suggestions.get(0).click();
            }
            else {
            System.out.println("Client's email - " + botname + botlastname + "@gmail.com");
        }
        driver.findElement(By.id("Passwd")).sendKeys(password);
        System.out.println(password);
        driver.findElement(By.id("PasswdAgain")).sendKeys(password);
        System.out.println(password);
        //driver.get("http://steamunlock.com/index.php?do=register");

    }

    @Test
    public void testRun () throws InterruptedException {

        registerclient();

    }

    public void nameSelect(){
        botname = name.get(random.nextInt(name.size()-1));
    }

    public void lastnameSelect(){
        botlastname = lastname.get(random.nextInt(name.size()-1));
    }

    public void passwordGen(){
        StringBuilder strBuilder = new StringBuilder();

        for (int i = 0; i<6; i++) {
            int number = random.nextInt(passChars.length());
            char ch = passChars.charAt(number);
            strBuilder.append(ch);
        }
        password = strBuilder.toString();
    }

    public List<String> getname() {
        List<String> namelist = new ArrayList<String>();
            namelist.add("Arkadiy");
        namelist.add("Artem");
        namelist.add("Andrey");
        namelist.add("Boris");
        namelist.add("Bedlam");
        namelist.add("Vasiliy");
        namelist.add("Vladimir");
        namelist.add("Vyacheslav");
        namelist.add("Lukas");
        namelist.add("Larry");
        namelist.add("John");
        namelist.add("Konstantin");
        namelist.add("Mark");
        namelist.add("Ludvig");
        namelist.add("Laurence");
        namelist.add("German");
        namelist.add("Michael");
        namelist.add("Baklajan");
        namelist.add("Birobidjan");
        namelist.add("Oleg");
        namelist.add("Pyotr");
        namelist.add("Pavel");
        namelist.add("Philip");
        namelist.add("Piter");
        namelist.add("Naidjin");
        namelist.add("Maul");
        namelist.add("Grunt");
        return namelist;
    }

    public List<String> name = getname();

    public List<String> getlastname() {
        List<String> lastnamelist = new ArrayList<String>();
        lastnamelist.add("Marmont");
        lastnamelist.add("Snow");
        lastnamelist.add("Lanister");
        lastnamelist.add("Targarien");
        lastnamelist.add("Tirell");
        lastnamelist.add("Martell");
        lastnamelist.add("Stark");
        lastnamelist.add("Petrov");
        lastnamelist.add("Lukas");
        lastnamelist.add("Page");
        lastnamelist.add("Beilish");
        lastnamelist.add("Kartusov");
        lastnamelist.add("Lokutov");
        lastnamelist.add("Frey");
        lastnamelist.add("Tart");
        lastnamelist.add("German");
        lastnamelist.add("Shumakher");
        lastnamelist.add("Raikonen");
        lastnamelist.add("Burundukov");
        lastnamelist.add("Konovalov");
        lastnamelist.add("Parishnikov");
        lastnamelist.add("Klyaksin");
        lastnamelist.add("Mendel");
        lastnamelist.add("Loskutov");
        lastnamelist.add("Mamakolev");
        lastnamelist.add("Soulev");
        lastnamelist.add("Vasyutin");
        return lastnamelist;
    }

    public List<String> lastname = getlastname();

}
