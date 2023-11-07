package ApachePOI;

/*
   Main den bir metod çağırmak süretiyle, henüz oluşturulmamış
   path i verilen excel için, program her çalıştıkça içine "Merhaba Dünya"
    yazısını ekleyen metodu yazınız.
    Yani dosya yoksa oluştur ilk satıra yaz, sonra dosya oluşturacağı için
    dosya varsa en son satırın altına yaz
 */

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.internal.EclipseInterface;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class _12_Soru {
    public static void main(String[] args) {
        String path="src/test/java/ApachePOI/resource/SenaryoSonuclari.xlsx";
        String bilgi="test passed";

        writeToExcel(path,bilgi); // excel create
        writeToExcel(path,bilgi); // dosya artık var alttakiler çalışacak
        writeToExcel(path,bilgi);
        writeToExcel(path,bilgi);
    }

    public static void writeToExcel(String path, String bilgi) {

        File file=new File(path);

        if (!file.exists()) // dosya yok ise, ilk kez ve bir kez çalışıyor sonra alttakiler çalışıyor
        {
            //hafzada worbook oluştur, içinde hafızada sheet oluştur
            XSSFWorkbook workbook=new XSSFWorkbook();
            XSSFSheet sheet=workbook.createSheet("Sayfa1");

            //hafızada işlemlerini yap
            Row yeniSatir= sheet.createRow(0);
            Cell hucre= yeniSatir.createCell(0);
            hucre.setCellValue(bilgi+ " create oldu");

            //kaydet
            try {
                FileOutputStream outputStream = new FileOutputStream(path);
                workbook.write(outputStream);
                workbook.close();
                outputStream.close();
            } catch (Exception ex) {
                System.out.println("ex.getMessage() = " + ex.getMessage());
            }

        }
        else
        {
            FileInputStream inputStream = null;
            Workbook workbook= null;
            Sheet sheet=null;
            try {
                inputStream = new FileInputStream(path);
                workbook = WorkbookFactory.create(inputStream);
                sheet = workbook.getSheetAt(0);
            }catch (Exception ex) {
                System.out.println("ex.getMessage() = " + ex.getMessage());
            }
            
            int sonSatirIndex = sheet.getPhysicalNumberOfRows();
            Row yeniSatir = sheet.createRow(sonSatirIndex);
            Cell yeniHucre = yeniSatir.createCell(0);
            yeniHucre.setCellValue(bilgi);

            try {

            inputStream.close();

            //dosyay kaydetmeye geçiyorum
            // bunun için dosyayı yazma yönünd eaç
            FileOutputStream outputStream=new FileOutputStream(path);
            workbook.write(outputStream);
            workbook.close(); // hafızayı boşalt
            outputStream.close(); // yazma kanalını kapat

            }
            catch (Exception ex){
                System.out.println("ex.getMessage() = " + ex.getMessage());
            }
        }
    }
}
