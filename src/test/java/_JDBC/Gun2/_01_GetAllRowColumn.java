package _JDBC.Gun2;

import org.testng.annotations.Test;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class _01_GetAllRowColumn extends JDBCParent {

    @Test
    public void test1() throws SQLException {
        ResultSet rs = sorguEkrani.executeQuery("select city_id, city, country_id from city");

        rs.last(); // son satıra gittim

        String id= rs.getString(1); // 1.Kolon city_id
        System.out.println("id = " + id);

        // Eğer field ın tipi uyuyor ise ilgili dönüşü ile alınabilir.
        // ama istersen hepsini String ile alabilirsin, onda bir engel yok.
        int intId = rs.getInt(1);
        System.out.println("intId = " + intId);

    }

    // kolon isimlerini almak için (getMetaData tipi ResultSetMetaData)

    @Test
    public void test2() throws SQLException {
        ResultSet rs = sorguEkrani.executeQuery("select * from city");

        ResultSetMetaData rsmd = rs.getMetaData(); // veri harici diğer bilgiler
        // meta = görünenin haricindeki diğer bilgiler manasında

        int columnCount = rsmd.getColumnCount();

        rs.next(); // ilk satıra gittim
        for (int i = 1; i <= columnCount ; i++) {  // kaç tane kolon varsa hepsindeki bilgileri yazdırabilirim.
            System.out.print(rs.getString(i)+" ");
        }

        System.out.println();

        for (int i = 1; i < columnCount; i++) {
            System.out.print(rsmd.getColumnName(i) +"\t"+rsmd.getColumnTypeName(i)+" ");

        }

    }

    @Test
    public void test3() throws SQLException {

        // language tablosundaki tüm satırları ve tüm sütunları yazdırınız
        // aynı mysql sonuç ekranında olduğu gibi

        ResultSet rs = sorguEkrani.executeQuery("select * from language");
        ResultSetMetaData rsmd=rs.getMetaData();

        for (int i = 1; i < rsmd.getColumnCount(); i++) {
            System.out.print(rsmd.getColumnName(i)+"\t");
        }

        System.out.println();

        while (rs.next()){

            for (int i = 1; i <= rsmd.getColumnCount() ; i++) {
                System.out.print(rs.getString(i)+"\t");
            }

            System.out.println();
        }

    }

    @Test
    public void test3_2() throws SQLException {

        // language tablosundaki tüm satırları ve tüm sütunları yazdırınız
        // aynı mysql sonuç ekranında olduğu gibi, daha düzenli hali

        ResultSet rs = sorguEkrani.executeQuery("select * from language");
        ResultSetMetaData rsmd=rs.getMetaData();

        for (int i = 1; i < rsmd.getColumnCount(); i++) {
            System.out.printf("%-20s",rsmd.getColumnName(i)+"\t"); // sola dayalı yaz 20 hane kullan
        }

        System.out.println();

        while (rs.next()){

            for (int i = 1; i <= rsmd.getColumnCount() ; i++) {
                System.out.printf("%-20s",rs.getString(i)+"\t");
            }

            System.out.println();
        }

        // % : değişkenin değerini işaret eder
        // - : sola dayalı yazdırır, default sağa dayalı
        // 20: kaç hane kullanılacak herzaman onun bilgisi
        // s : string değerler içis , sayısal değerler için d kullanılır
        // "%5.2f" : sayı için 5 hane kullan, ondalıklı kısım için 2 hane

    }

    @Test
    public void test4() {

        // bir metoda sorguyu ("select * from language) gönderiniz,
        // metod size sorgunun datasını bir ArrayList olarak döndürsün

        String sorgu = "select * from language";
        List<List<String>>  donenList = getListData(sorgu);
        System.out.println("donenList = " + donenList);

    }

    public List<List<String>> getListData(String sorgu) {
        List<List<String>> tablo = new ArrayList<>();

        try {
            ResultSet rs = sorguEkrani.executeQuery(sorgu);
            ResultSetMetaData rsmd=rs.getMetaData();

            while (rs.next()) {
                List<String> satir = new ArrayList<>();
                for (int i = 1; i <= rsmd.getColumnCount() ; i++) {
                    satir.add(rs.getString(i));
                }

                tablo.add(satir);
            }

        } catch (Exception ex) {
            System.out.println(ex.getMessage());

        }

        return tablo;

    }

    // TODO: DB den Customer tablosunu okuyarak, yani bir EXCEL e yazdırınız.

}
