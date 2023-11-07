package _JDBC.Gun1;

import _JDBC.Gun2.JDBCParent;
import org.testng.annotations.Test;

import java.sql.ResultSet;
import java.sql.SQLException;

public class _04_Soru extends JDBCParent {

    // city tablosundaki tüm satırlardaki şehir isimlerini next ile yazdırınız

    @Test
    public void test1() throws SQLException {

        ResultSet rs = sorguEkrani.executeQuery("select * from city");

        while (rs.next()) // olduğu kadar gidiyor. size falan demene gerek yok ya da fori yapmana gerek yok yada while (rs.next() == True) diyede yazabilirsin
        System.out.println(rs.getString("city"));


    }

}
