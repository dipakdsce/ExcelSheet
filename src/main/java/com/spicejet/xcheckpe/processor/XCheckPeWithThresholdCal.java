package com.spicejet.xcheckpe.processor;

import com.spicejet.xcheckpe.model.InputBook;
import com.spicejet.xcheckpe.model.OutputBook;
import org.apache.commons.lang3.StringUtils;

import java.text.ParseException;
import java.util.List;

import static com.spicejet.xcheckpe.util.CommonUtil.addToCalender;

public class XCheckPeWithThresholdCal implements ICalculation {

    @Override
    public void execute(InputBook inputBook, OutputBook outputBook,List<OutputBook> outputBooks) throws ParseException {
        if (StringUtils.isNotEmpty(inputBook.getIDim1()) && StringUtils.isNotEmpty(inputBook.getIAmount1())) {
            outputBook.setControlDim1(inputBook.getIDim1());
            int dueAmount ;
            if("C".equalsIgnoreCase(inputBook.getIDim1()) ) {
                dueAmount =  Integer.parseInt(inputBook.getCycles());
            } else {
                dueAmount =  Integer.parseInt(inputBook.getHours());
            }

            outputBook.setDueAmount1(String.valueOf(dueAmount));
            outputBooks.add(outputBook);

            if (StringUtils.isNotEmpty(inputBook.getIDim2()) && StringUtils.isNotEmpty(inputBook.getIAmount2())) {
                OutputBook newOutputBook = outputBook.clone();
                newOutputBook.setControlDim1(inputBook.getIDim2());

                int dueAmount2 ;
                if("C".equalsIgnoreCase(inputBook.getIDim2())) {
                    dueAmount2 =  Integer.parseInt(inputBook.getCycles());
                } else {
                    dueAmount2 =  Integer.parseInt(inputBook.getHours());
                }

                newOutputBook.setDueAmount1(String.valueOf(dueAmount2));

                outputBooks.add(newOutputBook);

                if (StringUtils.isNotEmpty(inputBook.getIDim3()) && StringUtils.isNotEmpty(inputBook.getIAmount3())) {

                    OutputBook newOutputBook1 = outputBook.clone();
                    newOutputBook1.setControlDim1(inputBook.getIDim3());
                    String dueAmount3 = getDueDate(inputBook);

                    newOutputBook1.setDueAmount1(String.valueOf(dueAmount3));

                    outputBooks.add(newOutputBook1);
                }
            } else if (StringUtils.isNotEmpty(inputBook.getIDim3()) && StringUtils.isNotEmpty(inputBook.getIAmount3())) {
                OutputBook newOutputBook1 = outputBook.clone();
                newOutputBook1.setControlDim1(inputBook.getIDim3());
                String dueAmount3 = getDueDate(inputBook);

                newOutputBook1.setDueAmount1(String.valueOf(dueAmount3));

                outputBooks.add(newOutputBook1);
            }
        } else if (StringUtils.isNotEmpty(inputBook.getIDim2()) && StringUtils.isNotEmpty(inputBook.getIAmount2())) {
            OutputBook newOutputBook = outputBook.clone();
            newOutputBook.setControlDim1(inputBook.getIDim2());
            int dueAmount2 ;
            if("C".equalsIgnoreCase(inputBook.getIDim2())) {
                dueAmount2 =  Integer.parseInt(inputBook.getCycles());
            } else {
                dueAmount2 =  Integer.parseInt(inputBook.getHours());
            }

            newOutputBook.setDueAmount1(String.valueOf(dueAmount2));

            outputBooks.add(newOutputBook);

            if (StringUtils.isNotEmpty(inputBook.getIDim3()) && StringUtils.isNotEmpty(inputBook.getIAmount3())) {
                OutputBook newOutputBook1 = outputBook.clone();
                newOutputBook1.setControlDim1(inputBook.getIDim3());
                String dueAmount3 = getDueDate(inputBook);
                newOutputBook1.setDueAmount1(String.valueOf(dueAmount3));

                outputBooks.add(newOutputBook1);
            }
        } else if (StringUtils.isNotEmpty(inputBook.getIDim3()) && StringUtils.isNotEmpty(inputBook.getIAmount3())) {
            OutputBook newOutputBook = outputBook.clone();
            newOutputBook.setControlDim1(inputBook.getIDim3());
            String dueAmount3 = getDueDate(inputBook);

            newOutputBook.setDueAmount1(String.valueOf(dueAmount3));

            outputBooks.add(newOutputBook);
        }
    }

    private String getDueDate(InputBook inputBook) throws ParseException {
        if ("DT".equalsIgnoreCase(inputBook.getIDim3().trim()))
            return inputBook.getIAmount3();


        return addToCalender(inputBook.getDate(), 0, inputBook.getIDim3().trim());
    }

}
