package com.spicejet.xcheckpe.processor;

import com.spicejet.xcheckpe.constant.Constants;
import com.spicejet.xcheckpe.model.OutputBook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import static com.spicejet.xcheckpe.constant.Constants.OUT_PUT_SHEET_NAME;
import static com.spicejet.xcheckpe.util.ExcelReaderUtil.createHeader;
import static com.spicejet.xcheckpe.util.ExcelReaderUtil.writeRows;

public class XCheckPeFileWriter {

    public void writeFile(List<OutputBook> outputBooks, String fileName) throws IOException {
        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet sheet = workbook.createSheet(OUT_PUT_SHEET_NAME);

        AtomicInteger rownum = new AtomicInteger(0);
        createHeader(outputBooks);

        outputBooks.forEach(outputBook -> {
            writeRows(sheet, rownum.get(), outputBook);
            rownum.getAndIncrement();
        });

        String directory =  Constants.OUTPUT_DIR;

        File dir = new File(directory);
        if(!dir.exists()) {
            dir.mkdir();
        }

        int index = fileName.lastIndexOf('.');

        String baseName  =  fileName.substring(0, index);
        String outputExcelFilePath = Constants.OUTPUT_DIR + Constants.SEPARATOR + baseName + Constants.EXCEL_FILE_TYPE;

//        String outputExcelFilePath = Constants.OUTPUT_DIR + Constants.SEPARATOR + fileName;

        File f =  new File(outputExcelFilePath);

        f.createNewFile();
        FileOutputStream out = new FileOutputStream(f);

        workbook.write(out);
        out.close();

    }


}
