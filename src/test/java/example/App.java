package example;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class  App
{
    @Test
    public void SuccessLogin(){
        //Başarılı login işlemi kontrolü - şifre maskeli olarak görüntülenmesi kontrolü

        WebDriver driver = new ChromeDriver();
        driver.get("https://student.openenglish.com/login.html?logout=true");
        driver.findElement(By.name("email")).sendKeys("temircinb@gmail.com");
        driver.findElement(By.cssSelector("[placeholder='Şifre']")).sendKeys("XVUga274");
        driver.findElement(By.id("login-submit")).click();
        //String metin = driver.findElement(By.xpath("//*[@id=\"index-holder\"]/lp2-study-bundle/div/lp2-referral-page-banner/div/div/a[1]")).getText();
        //System.out.println(metin);
        //Assert.assertEquals(" Arkadaşlarını davet et ",metin);

        driver.quit();

    }

    @Test
    public void SıfreNoneData(){
        //Parola alanı boş gönderiliyor.

        WebDriver driver = new ChromeDriver();
        driver.get("https://student.openenglish.com/login.html?logout=true");
        driver.findElement(By.name("email")).sendKeys("temircinb@gmail.com");
        driver.findElement(By.cssSelector("[placeholder='Şifre']")).sendKeys("");
        driver.findElement(By.id("login-submit")).click();

        driver.quit();

    }

    @Test
    public void NoneData(){
        //E posta ve sifre alanı boş gönderiliyor.

        WebDriver driver = new ChromeDriver();
        driver.get("https://student.openenglish.com/login.html?logout=true");
        driver.findElement(By.name("email")).sendKeys("");
        driver.findElement(By.cssSelector("[placeholder='Şifre']")).sendKeys("");
        driver.findElement(By.id("login-submit")).click();

        driver.quit();

    }

    @Test
    public void MinChar(){
        //E posta ve sifre alanı için min karakter girişi yapılıyor. (fail)

        WebDriver driver = new ChromeDriver();
        driver.get("https://student.openenglish.com/login.html?logout=true");
        driver.findElement(By.name("email")).sendKeys("a");
        driver.findElement(By.cssSelector("[placeholder='Şifre']")).sendKeys("1234");
        driver.findElement(By.id("login-submit")).click();
        String hataText = driver.findElement(By.className("form-text error")).getText();
        System.out.println(hataText);
        Assert.assertEquals("Kullanıcı veya şifre yanlış. Lütfen tekrar deneyin.", hataText);
        driver.quit();

    }

    @Test
    public void FailLogin(){
        //E posta adresi yanlış olarak giriliyor.(fail)

        WebDriver driver = new ChromeDriver();
        driver.get("https://student.openenglish.com/login.html?logout=true");
        driver.findElement(By.name("email")).sendKeys("termir@gmail.com");
        driver.findElement(By.cssSelector("[placeholder='Şifre']")).sendKeys("XVUga274");
        driver.findElement(By.id("login-submit")).click();
        String hataText = driver.findElement(By.xpath("//*[@id=\"login-holder\"]/lp2-login-page/lp2-login-box/div/div/div/div/form/div[2]/small")).getText();
        System.out.println(hataText);
        Assert.assertEquals("Kullanıcı veya şifre yanlış. Lütfen tekrar deneyin.", hataText);
        driver.quit();

    }

    @Test
    public void ForgetPassword(){
        //Şifremi unuttum butonunun doğru çalışmasının kontrolü

        WebDriver driver = new ChromeDriver();
        driver.get("https://student.openenglish.com/login.html?logout=true");
        driver.findElement(By.cssSelector("[href=\"/recovery.html\"]")).click();
        driver.quit();

    }

    @Test
    public void GonderButon(){
        //Sifre sıfırlama işlemi başarılı bir şekilde oluyor mu?

        WebDriver driver = new ChromeDriver();
        driver.get("https://student.openenglish.com/login.html?logout=true");
        driver.findElement(By.cssSelector("[href=\"/recovery.html\"]")).click();
        driver.findElement(By.cssSelector("[placeholder=\"E-posta\"]")).sendKeys("temircinb@gmail.com");
        driver.findElement(By.id("recovery-submit")).click();
        driver.quit();

    }

    @Test
    public void LoginPage(){
        //Sifre sıfırlandıktan sonra Login sayfasına yönlendirme kontrolü

        WebDriver driver = new ChromeDriver();
        driver.get("https://student.openenglish.com/login.html?logout=true");
        driver.findElement(By.cssSelector("[href=\"/recovery.html\"]")).click();
        driver.findElement(By.cssSelector("[placeholder=\"E-posta\"]")).sendKeys("temircinb@gmail.com");
        driver.findElement(By.id("recovery-submit")).click();
        driver.findElement(By.id("login-return")).click();
        driver.quit();

    }




}
