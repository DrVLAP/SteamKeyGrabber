import com.thoughtworks.selenium.webdriven.commands.Click;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

/**
 * Created by First on 14.06.2016.
 */


public class Experimental {

    private static ChromeDriverService service;
    public static WebDriver driver;


    public String botname;
    public String botlastname;
    Random random = new Random();
    JavascriptExecutor jse;
    public String passChars = "abcdefghijklmnopqrstuvwxyz1234567890";
    public String gmailMonth = "123456789abc";
    public String gmailGender = "ef";
    String password;
    public char month;
    public char gender;
    public String monthString;
    public String genderString;
    public String email;

    @BeforeMethod
    public void setUp() throws IOException {

        /*service = new ChromeDriverService.Builder()
                .usingDriverExecutable(new File("chromedriver.exe"))
                .usingAnyFreePort()
                .build();
        service.start();
        driver = new ChromeDriver(service);*/
        driver = new FirefoxDriver();

        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
    }

    @Test
    public void testRun () throws InterruptedException {
        //for (int i = 0; i<20; i++) {
//            System.out.println("Id клиента: " + (i+1));
        //googleRegisterClient();
        //steamGameSwapRegistration();
        steamGameSwapAuth();
        steamGameSwapWork();
        //steamUnlockRegistration();
        //}
    }

    public void steamGameSwapAuth()throws InterruptedException {
        driver.get("http://steamgameswap.com/user/register");
        driver.findElement(By.id("loginButton")).click();
        driver.findElement(By.id("customer_email_box")).sendKeys("vassteamunlock@gmail.com");
        driver.findElement(By.id("customer_password_box")).sendKeys("123456");
        Thread.sleep(30000);
        //driver.findElement(By.id("tutorial-gamepoints")).click();
        driver.findElement(By.id("customer_password_box")).submit();
    }

    public void steamGameSwapWork() throws InterruptedException {
        //Проверка что клиент авторизован.
        //WebElement page_is_loaded = new WebDriverWait(driver, 10).until(ExpectedConditions.presenceOfElementLocated(By.xpath(".//*[@id='top-other']/div/div/div[2]/ul/li[3]/span/a/span")));

        driver.findElement(By.id("tutorial-gamepoints")).click();
        driver.findElement(By.xpath("//*[@id='content']/div/div[1]/a[2]")).click();


    }

    public void steamGameSwapRegistration() throws InterruptedException {
        driver.get("http://steamgameswap.com/user/register");
        driver.findElement(By.id("User_nickname")).sendKeys(botname, botlastname);
        driver.findElement(By.id("User_email")).sendKeys(email);
        driver.findElement(By.id("User_repeat_email")).sendKeys(email);
        driver.findElement(By.id("User_password")).sendKeys(password);
        driver.findElement(By.id("User_repeat_password")).sendKeys(password);
        // Время чтобы ввести капчу
        Thread.sleep(15000);




    }

    public void steamUnlockRegistration() throws InterruptedException {
        driver.get("http://steamunlock.com/index.php?do=register");
        driver.findElement(By.xpath("//*[@id='registration']/div/div[2]/div[2]/input")).sendKeys(botname, botlastname);
        driver.findElement(By.xpath("//*[@id='registration']/div/div[2]/div[3]/input")).sendKeys(email);
        driver.findElement(By.xpath("//*[@id='registration']/div/div[2]/div[4]/input")).sendKeys(password);
        driver.findElement(By.xpath("//*[@id='registration']/div/div[2]/div[5]/input")).sendKeys(password);
        Thread.sleep(10000);
        System.out.println("--------------------------------------");
        System.out.println("Данные клиента в системе http://steamunlock.com");
        System.out.println("Логин клиента: " + botname + botlastname);
        System.out.println("Пароль клиента: " + password);
        System.out.println("Email клиента: " + email);
        System.out.println("--------------------------------------");
    }

    public void googleRegisterClient() throws InterruptedException {
        //Выбор имени/фамилии пользователя и генерация пароля
        genderSelect();
        nameSelect();
        lastnameSelect();
        passwordGen();
        monthSelect();

        switch (month) {
            case '1':  monthString = "Январь";
                break;
            case '2':  monthString = "Февраль";
                break;
            case '3':  monthString = "Март";
                break;
            case '4':  monthString = "Апрель";
                break;
            case '5':  monthString = "Май";
                break;
            case '6':  monthString = "Июнь";
                break;
            case '7':  monthString = "Июль";
                break;
            case '8':  monthString = "Август";
                break;
            case '9':  monthString = "Сентябрь";
                break;
            case 'a': monthString = "Октябрь";
                break;
            case 'b': monthString = "Ноябрь";
                break;
            case 'c': monthString = "Декабрь";
                break;
        }


        switch (gender){
            case 'f': genderString = "Пол клиента мужской";
                break;
            case 'e': genderString = "Пол клиента женский";
                break;
        }

        driver.get("https://accounts.google.com/SignUp?service=accountsettings");
        driver.findElement(By.id("FirstName")).sendKeys(botname);
        driver.findElement(By.id("LastName")).sendKeys(botlastname);
        driver.findElement(By.id("GmailAddress")).sendKeys(botname, botlastname);
        driver.findElement(By.id("Passwd")).click();
        Thread.sleep(100);
        //Определение занято ли имя пользователя. Если оно занято то будет предложен другой email
        if (driver.findElement(By.id("username-suggestions")).isDisplayed())
        {
            //Создание объекта email. Так сделано для удобства вывода имени пользователя если стандартный email состоящий только из имени/фамилии оказался занят
            //Если были предложены email на выбор то выбрать первый из предложенных и вывести этот email  в сообщении
            WebElement suggestedEmail = driver.findElement(By.xpath(".//*[@id='username-suggestions']/a[1]"));
            email = String.valueOf(driver.findElement(By.xpath(".//*[@id='username-suggestions']/a[1]")).getText()) + "@gmail.com";
            System.out.println("Client's email: " + email);
//                System.out.println(String.valueOf("Client's email: " + driver.findElement(By.xpath(".//*[@id='username-suggestions']/a[1]")).getText()) + "@gmail.com");
            suggestedEmail.click();

        }
        else {
            email = botname + botlastname + "@gmail.com";
            System.out.println("Email: " + email);
//            System.out.println("Email: " + botname + botlastname + "@gmail.com");

        }
        driver.findElement(By.id("Passwd")).sendKeys(password);
        System.out.println("Пароль клиента: " + password);
        driver.findElement(By.id("PasswdAgain")).sendKeys(password);
        //Введение даты рождения. Выбрано максимальное число 28, чтобы пока что не заморачиваться с разным количеством дней в месяце
        driver.findElement(By.id("BirthDay")).sendKeys(String.valueOf(random.nextInt(28)+1));
        driver.findElement(By.xpath("//*[@id='BirthMonth']/*[contains(@class,'goog-inline-block')]")).click();
        driver.findElement(By.xpath("//*[@id='BirthMonth']//*[@id=':"+month+"']")).click();
        System.out.println(genderString);
        driver.findElement(By.id("BirthYear")).sendKeys(String.valueOf(random.nextInt(45)+1950));
        driver.findElement(By.xpath("//*[@id='Gender']/*[contains(@class,'goog-inline-block')]")).click();
        Thread.sleep(100);
        driver.findElement(By.xpath("//*[@id='Gender']//*[@id=':"+gender+"']")).click();

        //driver.findElement(By.id("submitbutton")).click();
    }


    public void nameSelect(){
        if (gender == 'f') {

            botname = name.get(random.nextInt(name.size() - 1));
        }
        else
        {
            botname = femalename.get(random.nextInt(femalename.size() - 1));
        }
    }

    public void lastnameSelect(){
        if (gender == 'f') {
            botlastname = lastname.get(random.nextInt(lastname.size() - 1));
        }
        else {
            botlastname = femalelastname.get(random.nextInt(femalelastname.size() - 1));
        }
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

    public void genderSelect(){
        int number = random.nextInt(gmailGender.length());
        gender = gmailGender.charAt(number);
    }

    public void monthSelect(){
        int number = random.nextInt(gmailMonth.length());
        month = gmailMonth.charAt(number);
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

    public List<String> getfemalename() {
        List<String> namelist = new ArrayList<String>();
        namelist.add("Anna");
        namelist.add("Jane");
        namelist.add("Arya");
        namelist.add("Breana");
        namelist.add("Daenerys");
        namelist.add("Serseya");
        namelist.add("Sansa");
        namelist.add("Margery");
        namelist.add("Shaya");
        namelist.add("Katelin");
        namelist.add("Lily");
        namelist.add("Lara");
        namelist.add("Mary");
        namelist.add("Jane");

        return namelist;
    }

    public List<String> femalename = getfemalename();


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

    public List<String> getfemalelastname() {
        List<String> lastnamelist = new ArrayList<String>();
        lastnamelist.add("Marmont");
        lastnamelist.add("Snow");
        lastnamelist.add("Lanister");
        lastnamelist.add("Targarien");
        lastnamelist.add("Tirell");
        lastnamelist.add("Martell");
        lastnamelist.add("Stark");
        lastnamelist.add("Petrova");
        lastnamelist.add("Lukas");
        lastnamelist.add("Page");
        lastnamelist.add("Beilish");
        lastnamelist.add("Kartusova");
        lastnamelist.add("Lokutova");
        lastnamelist.add("Freyeva");
        lastnamelist.add("Tart");
        lastnamelist.add("German");
        lastnamelist.add("Shumakher");
        lastnamelist.add("Raikonen");
        lastnamelist.add("Burundukova");
        lastnamelist.add("Konovalova");
        lastnamelist.add("Parishnikova");
        lastnamelist.add("Klyaksina");
        lastnamelist.add("Mendel");
        lastnamelist.add("Loskutova");
        lastnamelist.add("Mamakoleva");
        lastnamelist.add("Souleva");
        lastnamelist.add("Vasyutina");
        return lastnamelist;
    }

    public List<String> femalelastname = getfemalelastname();

    public void steamgameswapWorkList(){
        driver.findElement(By.id("tutorial-gamepoints")).click();

    }

}