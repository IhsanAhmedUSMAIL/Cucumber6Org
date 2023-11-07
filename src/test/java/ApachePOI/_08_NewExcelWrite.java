package ApachePOI;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class _08_NewExcelWrite {
    public static void main(String[] args) throws IOException {

        //hafızada workbook oluştur, içinde hafızada sheet oluştur
        XSSFWorkbook workbook = new XSSFWorkbook(); //  XSSFWorkbook, bu workbook hafızada oluşturma workbook u
        XSSFSheet sheet = workbook.createSheet("Sayfa1");

        // hafızada işlemlerini yap
        Row yeniSatir = sheet.createRow(0);
        Cell hucre = yeniSatir.createCell(0);
        hucre.setCellValue("Merhaba Dünya");

        // Kaydet
        String path = "src/test/java/ApachePOI/resource/YeniExcel.xlsx";
        FileOutputStream outputStream = new FileOutputStream(path);
        workbook.write(outputStream);
        workbook.close();
        outputStream.close();

        System.out.println("işlem tamamlandı");


    }
}
