package com.spicejet.xcheckpe.processor;

import com.spicejet.xcheckpe.constant.Constants;
import com.spicejet.xcheckpe.model.InputBook;
import com.spicejet.xcheckpe.util.ExcelReaderUtil;

import java.io.File;
import java.util.HashSet;
import java.util.Set;

public class XCheckPeFileReader {

    private String fileName;

    public Set<InputBook> readFile() {
        ExcelReaderUtil reader = new ExcelReaderUtil();
        Set<InputBook> inputBookSet = new HashSet<>();

        try {
            File directory = new File(Constants.INPUT_DIR);
            File[] fList = directory.listFiles();

            if ((fList != null) && (fList.length > 0)) {
                for (File file : fList) {
                    if (file.getName().endsWith(Constants.EXCEL_FILE_TYPE)) {
                        fileName = file.getName();
                        String inputExcelFilePath = Constants.INPUT_DIR + Constants.SEPARATOR + file.getName();
                        inputBookSet = reader.readBooksFromExcelFile(inputExcelFilePath);
                    }
                }
            }
        } catch (Exception e) {

        }

        return inputBookSet;
    }

    public String getFileName() {
        return fileName;
    }
}
