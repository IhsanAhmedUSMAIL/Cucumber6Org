package ApachePOI;

import org.apache.poi.ss.usermodel.*;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class _06_WriteInTheExcel {

    public static void main(String[] args) throws IOException {

        String path = "src/test/java/ApachePOI/resource/WriteInTheExcelFile.xlsx";

        FileInputStream inputStream = new FileInputStream(path); // okuma yönünde açıldı
        Workbook workbook = WorkbookFactory.create(inputStream); // hafızaya kopyası oluşturuldu
        Sheet sheet = workbook.getSheetAt(0);

        // hafızada yazma işlemine başlıyorum
        int sonSatirIndex=sheet.getPhysicalNumberOfRows(); // son satırın indexini alıp
        Row yeniSatir = sheet.createRow(sonSatirIndex); // son boş yere satır açılıyor
        Cell yaniHucre = yeniSatir.createCell(0); // ilk hücre oluşturuldu
        yaniHucre.setCellValue("Merhaba Dünya");
        // yazma işlemi bitti
        // okuma kanalini kapat.
        inputStream.close();

        // dosya kaydetmeye geçiyorum
        // bunun için dosyayı yazma yönünde aç
        FileOutputStream outputStream = new FileOutputStream(path);
        workbook.write(outputStream);
        workbook.close(); // hafızayı boşalt
        outputStream.close();  // yazma kanalını kapat

        System.out.println("işlem bitti");

    }


}
