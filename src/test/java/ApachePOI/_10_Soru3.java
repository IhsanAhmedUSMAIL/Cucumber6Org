package ApachePOI;


import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileOutputStream;
import java.io.IOException;

/**
 * TODO:
 *  Ekrandaki gibi bir Excel Çarpım tablosunu
 *  YENİ bir excel dosyasına
 *  1 den 10 kadar çarpımları YAN YANA yapınız.
 *  (ipucu önce sadece 1 leri yapınız sonra
 *  diğerlerini)
 */

public class _10_Soru3 {

    public static void main(String[] args) throws IOException {

        //hafızada workbook oluştur, içinde hafızada sheet oluştur
        XSSFWorkbook workbook = new XSSFWorkbook(); //  XSSFWorkbook, bu workbook hafızada oluşturma workbook u
        XSSFSheet sheet = workbook.createSheet("Sayfa1");

        int yeniAcilacakSatirIndexi = 0; //sheet.getPhysicalNumberOfRows(); (0 verirsen hep baştan başlar)

        for (int k = 1; k <= 10 ; k++) {

            for (int i = 1; i <= 10 ; i++) {

                // ++ her bir işlemi yeni bir satıra yaz demek
                Row satir= sheet.createRow(yeniAcilacakSatirIndexi++);

                Cell hucre1 = satir.createCell(0); hucre1.setCellValue(k);
                Cell hucre2 = satir.createCell(1); hucre2.setCellValue("x");
                Cell hucre3 = satir.createCell(2); hucre3.setCellValue(i);
                Cell hucre4 = satir.createCell(3); hucre4.setCellValue("=");
                Cell hucre5 = satir.createCell(4); hucre5.setCellValue(k*i);

            }

            Row bosSatir= sheet.createRow(yeniAcilacakSatirIndexi++); // \n gibi görev yapıyor
        }



        // Kaydet
        String path = "src/test/java/ApachePOI/resource/YeniCarpimTablosu2.xlsx";
        FileOutputStream outputStream = new FileOutputStream(path);
        workbook.write(outputStream);
        workbook.close();
        outputStream.close();

        System.out.println("işlem tamamlandı");



    }


}
