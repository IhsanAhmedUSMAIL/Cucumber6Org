package Utilities;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;

public class ExcelUtility {


    public static ArrayList<ArrayList<String>> getData(String path, String sheetName, int sutunSayisi) {
        ArrayList<ArrayList<String>> tablo=new ArrayList<>();

        Sheet sheet=null;
        try {
            FileInputStream inputStream = new FileInputStream(path);
            Workbook workbook = WorkbookFactory.create(inputStream);
            sheet= workbook.getSheet(sheetName);
        } catch (IOException e) {
            System.out.println("e = " + e);
        }

        for (int i = 0; i < sheet.getPhysicalNumberOfRows(); i++) { // her bir satırı

            ArrayList<String> satir=new ArrayList<>();
            for (int j = 0; j < sutunSayisi; j++) { // sutun sayısı kadar dolaş
                satir.add(sheet.getRow(i).getCell(j).toString());
            }

            tablo.add(satir);
        }
        return tablo;

    }
}
