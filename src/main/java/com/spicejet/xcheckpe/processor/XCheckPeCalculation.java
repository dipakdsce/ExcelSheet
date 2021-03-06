package com.spicejet.xcheckpe.processor;

import com.spicejet.xcheckpe.exception.DataException;
import com.spicejet.xcheckpe.model.InputBook;
import com.spicejet.xcheckpe.model.OutputBook;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.function.Predicate;

import static com.spicejet.xcheckpe.util.CustomStringUtils.isNonBlank;

public class XCheckPeCalculation {

    private static Predicate<InputBook> isThresholdUsed() {
        return inputBook -> isNonBlank.test(inputBook.getThresholdUsed())
                && inputBook.getThresholdUsed().trim().equalsIgnoreCase("Y");
    }

    public List<OutputBook> calculation(Set<InputBook> inputBooks) {
        List<OutputBook> outputBooks = new ArrayList<>();

        try {
            inputBooks.stream().forEach(inputBook -> {
                try {
                    OutputBook outputBook = new OutputBook();

                    outputBook.setTempA(inputBook.getTempA());
                    outputBook.setTempB(inputBook.getTempB());
                    outputBook.setTempC(inputBook.getTempC());
                    outputBook.setTempD(inputBook.getTempD());
                    outputBook.setTempE(inputBook.getTempE());
                    outputBook.setTempF(inputBook.getTempF());
                    outputBook.setCheckType(inputBook.getCheckName());
                    outputBook.setAircraft(inputBook.getAircraft());

                    ICalculation calculation = isThresholdUsed().test(inputBook) ? new XCheckPeWithThresholdCal()
                            : new XCheckPeWithoutThresholdCalc();
                    calculation.execute(inputBook, outputBook);

                    outputBooks.add(outputBook);
                } catch (ParseException e) {
                    e.printStackTrace();
                    throw new DataException("Found error in row number " + inputBook.getRowCount());
                }
            });
        } catch (DataException ex) {
            ex.printStackTrace();
        }

        return outputBooks;
    }
}
