import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class ExcelReader {

    public static void main(String[] args) throws IOException {

        // Specify the path of the Excel file
        FileInputStream fis = new FileInputStream(new File("employees.xlsx"));

        // Create Workbook instance that refers to .xlsx file
        Workbook workbook = new XSSFWorkbook(fis);

        // Get the first sheet from the workbook
        Sheet sheet = workbook.getSheetAt(0);

        // Iterate through the rows of the sheet (start from row 1 to skip header)
        for (int i = 1; i <= sheet.getPhysicalNumberOfRows(); i++) {
            Row row = sheet.getRow(i); // Get the current row

            // Get the values from each cell in the row
            String empNo = row.getCell(0).getStringCellValue();
            String empName = row.getCell(1).getStringCellValue();
            String empDesignation = row.getCell(2).getStringCellValue();
            double empSalary = row.getCell(3).getNumericCellValue();
            String empDepartment = row.getCell(4).getStringCellValue();

            // Print the data in the console
            System.out.println("EMP No: " + empNo + ", EMP Name: " + empName +
                    ", EMP Designation: " + empDesignation +
                    ", EMP Salary: " + empSalary + ", EMP Department: " + empDepartment);
        }

        // Close the workbook and file input stream
        workbook.close();
        fis.close();
    }
}
