package _JDBC.Gun1;

import _JDBC.Gun2.JDBCParent;
import org.testng.annotations.Test;

import java.sql.ResultSet;
import java.sql.SQLException;

public class _03_NextPrevAbsRel extends JDBCParent {

    @Test
    public void test1() throws SQLException {
        ResultSet rs= sorguEkrani.executeQuery("select * from language");

        rs.next(); // bir adım ileri gidiyor
        System.out.println("1.Satir="+ rs.getNString(2)); // 2.Column index değil // 2 yerine kolonun adı "name" yazabilirsin
        // ing

        rs.next(); // bir adım ileri gidiyor
        System.out.println("2.Satir="+ rs.getNString(2)); // 2.Column index değil
        // ital

        rs.previous(); // bir adım geri geliyor
        System.out.println("1.Satir="+ rs.getNString(2)); // 2.Column index değil
        // ing


    }

    @Test
    public void test2() throws SQLException {
        ResultSet rs= sorguEkrani.executeQuery("select * from film");

        // nokta atışı
        rs.absolute(10); // 10 satıra direk git
        System.out.println("10.Satır title=" + rs.getString("title")); // alaaddin

        rs.absolute(5); // 5 satıra direk git
        System.out.println("5.Satır title=" + rs.getString("title")); // african

        // bulunduğun yerden itibaren git
        rs.relative(5); // en son nerdeysen, ordan itibaren 5 git.
        System.out.println("10.Satır title="+ rs.getString("title")); // alaaddin

        rs.next(); // 11 e gider
    }

    // rs.next() : sonraki satır
    // rs.previous : önceki satır
    // rs.absolute(10) : baştan itibaren 10.satıra ileri gider.
    // rs.relative(10) : bulunduğu yerden 10.satıra ileri gider.
    // rs.absolute(-10) : - (eksi) sondan demektir, sondan 10.satır
    // rs.relative(-5) :  - (eksi) bulundu yerden 5 satır geri


}
