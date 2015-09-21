package faktura;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import javax.swing.JTable;

import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import jxl.*;
import jxl.read.biff.BiffException;
import jxl.write.Number;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class Excel {

    Customer customer1;
    WritableWorkbook workbookCopy;
    Workbook workbook;
    WritableSheet sheetCopy;
    Sheet sheet;
    File excelFile;
    File excel;

    //funkja która otrzymuje obiekt customer i zapisuje go do EXCELA:
    public void saveExcelCustomer(Customer customer) throws IOException, BiffException, WriteException {

        excelFile = new File("D:/Faktura.xls");

        workbook = Workbook.getWorkbook(excelFile);
        workbookCopy = Workbook.createWorkbook(new File("C://Users//Gosia//Desktop//Clients.xls"), workbook);

        sheetCopy = workbookCopy.getSheet(0);

        sheetCopy.addCell(new Label(1, 6, customer.getName()));
        sheetCopy.addCell(new Label(1, 7, customer.getSureName()));
        sheetCopy.addCell(new Label(1, 8, customer.getAddress()));
        sheetCopy.addCell(new Label(1, 9, customer.getFirm()));
        sheetCopy.addCell(new Label(1, 10, customer.getNIP()));

        workbookCopy.write();
        workbookCopy.close();

    }

    public void writeExcelTable(JTable t) throws IOException, BiffException, WriteException {

        excelFile = new File("D:/Faktura.xls");

        workbook = Workbook.getWorkbook(excelFile);
        workbookCopy = Workbook.createWorkbook(new File("C://Users//Gosia//Desktop//Clients.xls"), workbook);

        sheetCopy = workbookCopy.getSheet(0);
        int excelrow = 13;

        for (int x = 0; x < t.getRowCount(); x++) {

            if (t.getValueAt(x, 0) == null) {
                break;
            }
            sheetCopy.addCell(new Number(1, excelrow++, (Integer) t.getValueAt(x, 0)));

        }
        excelrow = 13;
        for (int x = 0; x < t.getRowCount(); x++) {
            if (t.getValueAt(x, 1) == null) {
                break;
            }

            sheetCopy.addCell(new Label(2, excelrow++, String.valueOf(t.getValueAt(x, 1))));
        }
        excelrow = 13;
        for (int x = 0; x < t.getRowCount(); x++) {

            if (t.getValueAt(x, 2) == null) {
                break;
            }
            sheetCopy.addCell(new Number(3, excelrow++, (Double) t.getValueAt(x, 2)));
        }
        excelrow = 13;
        for (int x = 0; x < t.getRowCount(); x++) {

            if (t.getValueAt(x, 3) == null) {
                break;
            }
            sheetCopy.addCell(new Number(4, excelrow++, (Integer) t.getValueAt(x, 3)));
        }

        workbookCopy.write();
        workbookCopy.close();
    }

    public void SaveExcel(Customer customer, JTable jtable) throws FileNotFoundException, IOException, InvalidFormatException {

        FileInputStream istream = new FileInputStream("C:\\excel.xlsx");

        org.apache.poi.ss.usermodel.Workbook wb = WorkbookFactory.create(istream);
        org.apache.poi.ss.usermodel.Sheet sheet1 = wb.getSheetAt(0);

        org.apache.poi.ss.usermodel.Cell cell1 = sheet1.createRow(6).createCell(2);
        cell1.setCellValue(customer.getName());

        cell1 = sheet1.createRow(7).createCell(2);
        cell1.setCellValue(customer.getSureName());

        cell1 = sheet1.createRow(8).createCell(2);
        cell1.setCellValue(customer.getAddress());

        cell1 = sheet1.createRow(9).createCell(2);
        cell1.setCellValue(customer.getFirm());

        cell1 = sheet1.createRow(10).createCell(2);
        cell1.setCellValue(customer.getNIP());

        org.apache.poi.ss.usermodel.Cell cellForKamName = sheet1.getRow(6).createCell(12);
        cellForKamName.setCellValue("");
        cellForKamName = sheet1.getRow(7).createCell(12);
        cellForKamName.setCellValue("");
        cellForKamName = sheet1.getRow(8).createCell(12);
        cellForKamName.setCellValue("");
        cellForKamName = sheet1.getRow(9).createCell(12);
        cellForKamName.setCellValue("");
        cellForKamName = sheet1.getRow(10).createCell(12);
        cellForKamName.setCellValue("");
<<<<<<< HEAD

=======
        
        
>>>>>>> 4c9672c9cbd613d8429217ac1148658c69c7d3cb
        int initialRow = 15;
        int cellLP = 2;
        int cellTowar = 3;
        int cellCena = 12;
        int cellRabat = 15;
        Row row;
        //int tableColumnNR = 0;
        int lpCounter = 1;

        for (int x = 0; x < jtable.getRowCount(); x++) {

            row = sheet1.createRow(initialRow++);

            row.createCell(cellLP).setCellValue(lpCounter++);
            row.createCell(cellTowar).setCellValue((String) jtable.getValueAt(x, 1));
            row.createCell(12).setCellValue((double) jtable.getValueAt(x, 2));
            row.createCell(cellRabat).setCellValue((double) jtable.getValueAt(x, 3));

        }

        istream.close();
        FileOutputStream os = new FileOutputStream("C:\\OutputExcel.xlsx");
        wb.write(os);
        os.close();

    }

}
