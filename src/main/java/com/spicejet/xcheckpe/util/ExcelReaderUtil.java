package com.spicejet.xcheckpe.util;

import com.spicejet.xcheckpe.model.InputBook;
import com.spicejet.xcheckpe.model.OutputBook;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class ExcelReaderUtil {
    private static final int ZERO_INDEX = 0;

    public static void createHeader(List<OutputBook> outputBooks) {
        OutputBook header = new OutputBook();
        header.setTempA("Temp A");
        header.setTempB("Temp B");
        header.setTempC("Temp C");
        header.setTempD("Temp D");
        header.setTempE("Temp E");
        header.setTempF("Temp F");
        header.setCheckType("CHECK-TYPE");
        header.setAircraft("AIRCRAFT");
        header.setThresholdUsed("THRESHOLD-USED");
        header.setControlDim1("CONTROL-DIM-1");
        header.setDueAmount1("DUE-AMOUNT-1");
        header.setControlDim2("CONTROL-DIM-2");
        header.setDueAmount2("DUE-AMOUNT-2");
        header.setControlDim3("CONTROL-DIM-3");
        header.setDueAmount3("DUE-AMOUNT-3");

        outputBooks.add(0, header);
    }

    public static int writeRows(XSSFSheet sheet, int rowNum, OutputBook book) {
        int num = rowNum;
        Row row = sheet.createRow(num++);
        int colNum = 0;

        Cell cell = row.createCell(colNum++);
        cell.setCellValue(book.getTempA());
        cell = row.createCell(colNum++);
        cell.setCellValue(book.getTempB());
        cell = row.createCell(colNum++);
        cell.setCellValue(book.getTempC());
        cell = row.createCell(colNum++);
        cell.setCellValue(book.getTempD());
        cell = row.createCell(colNum++);
        cell.setCellValue(book.getTempE());
        cell = row.createCell(colNum++);
        cell.setCellValue(book.getTempF());
        cell = row.createCell(colNum++);
        cell.setCellValue(book.getCheckType());
        cell = row.createCell(colNum++);
        cell.setCellValue(book.getAircraft());
        cell = row.createCell(colNum++);
        cell.setCellValue(book.getThresholdUsed());
        cell = row.createCell(colNum++);
        cell.setCellValue(book.getControlDim1());
        cell = row.createCell(colNum++);
        cell.setCellValue(book.getDueAmount1());
        cell = row.createCell(colNum++);
        cell.setCellValue(book.getControlDim2());
        cell = row.createCell(colNum++);
        cell.setCellValue(book.getDueAmount2());
        cell = row.createCell(colNum++);
        cell.setCellValue(book.getControlDim3());
        cell = row.createCell(colNum++);
        cell.setCellValue(book.getDueAmount3());

        return num;
    }

    public Set<InputBook> readBooksFromExcelFile(String excelFilePath) throws Exception {
        Set<InputBook> bookSet = new HashSet<>();
        FileInputStream inputStream = new FileInputStream(new File(excelFilePath));
        Workbook workbook = new XSSFWorkbook(inputStream);
        Sheet firstSheet = workbook.getSheetAt(ZERO_INDEX);
        int rowCount = 2;

        for (Row nextRow : firstSheet) {
            if (nextRow.getRowNum() == ZERO_INDEX) {
                continue;
            }

            Iterator<Cell> cellIterator = nextRow.cellIterator();
            InputBook inputBook = new InputBook();

            while (cellIterator.hasNext()) {
                readRow(cellIterator, inputBook);
            }

            inputBook.setRowCount(rowCount++);
            bookSet.add(inputBook);
        }

        workbook.close();
        inputStream.close();
        return bookSet;
    }

    private void readRow(Iterator<Cell> cellIterator, InputBook inputBook) {
        Cell nextCell = cellIterator.next();
        int columnIndex = nextCell.getColumnIndex();
        switch (columnIndex) {
            case ZERO_INDEX:
                inputBook.setTempA(getCellValue(nextCell));
                break;
            case 1:
                inputBook.setTempB(getCellValue(nextCell));
                break;
            case 2:
                inputBook.setTempC(getCellValue(nextCell));
                break;
            case 3:
                inputBook.setTempD(getCellValue(nextCell));
                break;
            case 4:
                inputBook.setTempE(getCellValue(nextCell));
                break;
            case 5:
                inputBook.setTempF(getCellValue(nextCell));
                break;
            case 6:
                inputBook.setCheckName(getCellValue(nextCell));
                break;
            case 7:
                inputBook.setAircraft(getCellValue(nextCell));
                break;
            case 8:
                inputBook.setThresholdUsed(getCellValue(nextCell));
                break;
            case 9:
                inputBook.setHours(getCellValue(nextCell));
                break;
            case 10:
                inputBook.setCycles(getCellValue(nextCell));
                break;
            case 11:
                inputBook.setDate(getCellValue(nextCell));
                break;
            case 12:
                inputBook.setE(getCellValue(nextCell));
                break;
            case 13:
                inputBook.setM(getCellValue(nextCell));
                break;
            case 14:
                inputBook.setD(getCellValue(nextCell));
                break;
            case 15:
                inputBook.setI(getCellValue(nextCell));
                break;
            case 16:
                inputBook.setS(getCellValue(nextCell));
                break;
            case 17:
                inputBook.setV(getCellValue(nextCell));
                break;
            case 18:
                inputBook.setThrBase(getCellValue(nextCell));
                break;
            case 19:
                inputBook.setThrBaseDim(getCellValue(nextCell));
                break;
            case 20:
                inputBook.setThrBaseAmount(getCellValue(nextCell));
                break;
            case 21:
                inputBook.setTDim1(getCellValue(nextCell));
                break;
            case 22:
                inputBook.setTAmount1(getCellValue(nextCell));
                break;
            case 23:
                inputBook.setTDim2(getCellValue(nextCell));
                break;
            case 24:
                inputBook.setTAmount2(getCellValue(nextCell));
                break;
            case 25:
                inputBook.setTDim3(getCellValue(nextCell));
                break;
            case 26:
                inputBook.setTAmount3(getCellValue(nextCell));
                break;
            case 27:
                inputBook.setIDim1(getCellValue(nextCell));
                break;
            case 28:
                inputBook.setIAmount1(getCellValue(nextCell));
                break;
            case 29:
                inputBook.setIDim2(getCellValue(nextCell));
                break;
            case 30:
                inputBook.setIAmount2(getCellValue(nextCell));
                break;
            case 31:
                inputBook.setIDim3(getCellValue(nextCell));
                break;
            case 32:
                inputBook.setIAmount3(getCellValue(nextCell));
                break;
            default:
                // do nothing
        }
    }

    private String getCellValue(Cell cell) {
        cell.setCellType(Cell.CELL_TYPE_STRING);

        if (cell.getStringCellValue() != null && cell.getStringCellValue().length() > ZERO_INDEX) {
            return cell.getStringCellValue();
        }

        return "";
    }
}
