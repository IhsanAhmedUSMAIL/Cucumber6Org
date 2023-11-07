package _JDBC.Gun1;

import org.testng.annotations.Test;

import java.sql.*;

public class _01_Giris {

    @Test
    public void test1() throws SQLException {

      // bir sorgunun çalışması için yapılanlar
        String HostUrl = "jdbc:mysql://db-technostudy.ckr1jisflxpv.us-east-1.rds.amazonaws.com/sakila";
        String username = "root";
        String password = "'\"-LhCB'.%k[4S]z";

      // 1- bağlantı bilgilerini girdik connection bilgileri set edildi.
        Connection baglanti = DriverManager.getConnection(HostUrl, username, password);

      // 2- db seçtik. : HostUrl ye bu bilgi eklendi , hosturl nın sonuna / sakila yazınca db secılmıs oldu

      // 3- Sorgu ekranını açtık
        Statement sorguEkrani = baglanti.createStatement(); // bağlantı üzerinden sorgu ekranını açtık

      // 4- Sorguyu Ekranına , sorguyu yazdım, çalıştırdım
        ResultSet sonucTablosu = sorguEkrani.executeQuery("select * from customer"); // sorguyu çalıştır

      // 5- altta sonuçlar gözüktü - javanın içinde ise sonuçları satır satır okuyoruz
        sonucTablosu.next(); // şu anda ilk satıra geldik

        String ad = sonucTablosu.getNString("first_name"); // istediğim bilgiye aldım
        String soyad = sonucTablosu.getNString("last_name"); // bu satırdaki istediği bilgiyi aldım
        System.out.println("ad = " + ad);
        System.out.println("soyad = " + soyad);

        sonucTablosu.next(); //2. satıra gittim

        ad = sonucTablosu.getNString("first_name"); // istediğim bilgiyi aldım
        soyad = sonucTablosu.getNString("last_name"); // bu satırdaki istediği
        System.out.println("ad = " + ad);
        System.out.println("soyad = " + soyad);

        baglanti.close();
    }

} // ms sql de manuel yaptığımız tüm işlemleri komutla yazarak SQL kodlarını yazılabilir hale getirdik şuan
