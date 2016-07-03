import com.thoughtworks.selenium.webdriven.commands.Click;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
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
        driver.findElement(By.id("GmailAddress")).sendKeys(botname, botlastname);
        //driver.findElement(By.id("GmailAddress")).sendKeys("dr.vlap");
        Thread.sleep(3000);

        driver.findElement(By.id("Passwd")).click();
        //jse.executeScript("document.getElementById('username-suggestions').focus();");
        Thread.sleep(3000);
        //Boolean suggestionshow = driver.findElements(By.id("username-suggestions")).size()>0;
        //Boolean suggestionshow = driver.findElements(By.id("username-suggestions")).;
        /*if (suggestionshow == true)*/
        System.out.println ("Поиск элемента предложенных email");
        if (driver.findElement(By.id("username-suggestions")).isDisplayed())
            {
                /*System.out.println ("Объект найден, поиск ");
                List<WebElement> suggestions = driver.findElements(By.id("username-suggestions")).;
                String email = suggestions.get(0).getAttribute("href");*/
                WebElement email = driver.findElement(By.xpath(".//*[@id='username-suggestions']/a[1]"));
                //System.out.println (email.getAttribute("a"));
                System.out.println(String.valueOf("Client's email: " + driver.findElement(By.xpath(".//*[@id='username-suggestions']/a[1]")).getText()) + "@gmail.com");
                //System.out.println("Client's email - " + suggestions.get(0).getAttribute("href") + "@gmail.com");
                //Thread.sleep(3000);
                email.click();
                //suggestions.get(0).click();
            }
            else {
            System.out.println("Client's email - " + botname + botlastname + "@gmail.com");
        }
        driver.findElement(By.id("Passwd")).sendKeys(password);
        System.out.println("Пароль клиента: " + password);
        driver.findElement(By.id("PasswdAgain")).sendKeys(password);
        driver.findElement(By.id("day-label")).sendKeys(String.valueOf(random.nextInt(28)+1));
        /*WebElement selectElem = driver.findElement(By.tagName("select"));
        Select select = new Select(selectElem);*/
        // следующая строка раскрывает выбор месяца рождения, она работает!
        driver.findElement(By.id(":0")).click();
        Thread.sleep(3000);
        //.//*[@id='BirthMonth']/div[@id=':8']
        //"//Select[@id='mySelectID']/option[normalize-space(text())='Option']")
       // driver.findElement(By.className("goog-menuitem")).findElement(By.xpath(".//*[@id='BirthMonth']/div[@id=':8']")).click();
        //Select listbox = new (driver.findElement(By.id(":0")));
        //driver.findElement(B"июнь");
        //driver.findElement(By.xpath(".//*[@id=':8']/div")).click();


        //   findElement(By.id(String.valueOf((random.nextInt(12)+1))));
        driver.findElement(By.id("BirthYear")).sendKeys(String.valueOf(random.nextInt(45)+1950));
        //driver.get("http://steamunlock.com/index.php?do=register");
        driver.findElement(By.id("submitbutton")).click();
    }

    @Test
    public void testRun () throws InterruptedException {

        registerclient();
       /* for (int i=1; i<100; i++) {
            System.out.println(String.valueOf(random.nextInt(45)+1950));
        }*/
    }

    public void nameSelect(){
        botname = name.get(random.nextInt(name.size()-1));
    }

    public void lastnameSelect(){
        botlastname = lastname.get(random.nextInt(name.size()-1));
    }

    public void passwordGen(){
        StringBuilder strBuilder = new StringBuilder();

        for (int i = 0; i<8; i++) {
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
