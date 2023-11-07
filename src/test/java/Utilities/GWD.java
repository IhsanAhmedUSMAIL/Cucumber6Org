package Utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.safari.SafariDriver;

import java.time.Duration;
import java.util.Locale;

public class GWD {

    private static ThreadLocal<WebDriver> threadDriver=new ThreadLocal<>();
    public static ThreadLocal<String> threadBrowserName=new ThreadLocal<>();

    //threadDriver.get() -> bulunduğum thread deki driverı ver.
    //threadDriver.set(driver) -> bulunduğum threade driver set et
    public static WebDriver getDriver() {

        //extend report türkçe bilgi çalışmaması sebebiyle eklendi
        Locale.setDefault(new Locale("EN"));
        System.setProperty("user.language", "EN");

        if(threadBrowserName.get() == null) // xml den çalıştırılmayan diğer bölümler
            threadBrowserName.set("chrome");

        if(threadDriver.get() == null) {// ilk kez bir defa çalışsın

            switch (threadBrowserName.get()){
                case "firefox":
                    threadDriver.set(new FirefoxDriver());
                break; // ilgili threade bir driver set ettim

                case "safari":
                    threadDriver.set(new SafariDriver());
                    break; // ilgili threade bir driver set ettim

                case "edge":
                    threadDriver.set(new EdgeDriver());
                    break; // ilgili threade bir driver set ettim

                default:
                    FirefoxOptions options= new FirefoxOptions();
                    options.addArguments("--headless", "--no-sandbox", "--disable-dev-shm-usage", "--disable-gpu", "--window-size=1400,2400");
                    threadDriver.set(new FirefoxDriver(options));

                    threadDriver.set(new FirefoxDriver());

                    //threadDriver.set(new ChromeDriver()); // ilgili threade bir driver set ettim
            }
        }

        // gelen browser ismine göre chrome, edge, firefox switch üretip set edeceğim
        //threadDriver.set(new ChromeDriver()); // ilgili hata (threade) bir driver set ettim

        threadDriver.get().manage().window().maximize();
        threadDriver.get().manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
        return threadDriver.get(); // bulunduğum threade driver ver

    }

    public static void quitDriver() {
        // test sonucu ekranı bir miktar beklesin diye
        try {
            Thread.sleep(5000);
        }catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        //driver kapat
        if (threadDriver.get()!=null) { //driver var ise
            threadDriver.get().quit();

            WebDriver driver=threadDriver.get(); // direk eşitleme yapmadığım için, içindekini al
            driver=null; // null a eşitle

            threadDriver.set(driver); // kendisine null olarak ver, bu hatta bir dolu driver yok

        }
    }

}
