package com.spicejet.xcheckpe.processor;

import com.spicejet.xcheckpe.model.InputBook;
import com.spicejet.xcheckpe.model.OutputBook;
import org.apache.commons.lang3.StringUtils;

import java.text.ParseException;
import java.util.List;

import static com.spicejet.xcheckpe.util.CommonUtil.addToCalender;

public class XCheckPeWithoutThresholdCalc implements ICalculation {

    @Override
    public void execute(InputBook inputBook, OutputBook outputBook, List<OutputBook> outputBooks) throws ParseException {
        if (StringUtils.isNotEmpty(inputBook.getTDim1()) && StringUtils.isNotEmpty(inputBook.getTAmount1())) {
            outputBook.setControlDim1(inputBook.getTDim1());
            int dueAmount1;
            if("C".equalsIgnoreCase(inputBook.getTDim1()) || "AC".equalsIgnoreCase(inputBook.getTDim1())) {
                dueAmount1 =  Integer.parseInt(inputBook.getCycles());
            } else {
                dueAmount1 =  Integer.parseInt(inputBook.getHours());
            }
            //int dueAmount1 = Integer.parseInt(inputBook.getTAmount1());
            outputBook.setDueAmount1(String.valueOf(dueAmount1));
            outputBooks.add(outputBook);

            if (StringUtils.isNotEmpty(inputBook.getTDim2()) && StringUtils.isNotEmpty(inputBook.getTAmount2())) {
                OutputBook newOutputBook = outputBook.clone();
                newOutputBook.setControlDim1(inputBook.getTDim2());
                int dueAmount2;
                if("C".equalsIgnoreCase(inputBook.getTDim2()) || "AC".equalsIgnoreCase(inputBook.getTDim2())) {
                    dueAmount2 =  Integer.parseInt(inputBook.getCycles());
                } else {
                    dueAmount2 =  Integer.parseInt(inputBook.getHours());
                }
//                int dueAmount2 = Integer.parseInt(inputBook.getTAmount2());
                newOutputBook.setDueAmount1(String.valueOf(dueAmount2));
                outputBooks.add(newOutputBook);

                if (StringUtils.isNotEmpty(inputBook.getTDim3()) && StringUtils.isNotEmpty(inputBook.getTAmount3())) {
                    OutputBook outputBook1 = outputBook.clone();
                    outputBook1.setControlDim1(inputBook.getTDim3());
                    String dueAmount3 = getDueDate(inputBook);
                    outputBook1.setDueAmount1(dueAmount3);
                    outputBooks.add(outputBook1);
                }
            } else if (StringUtils.isNotEmpty(inputBook.getTDim3()) && StringUtils.isNotEmpty(inputBook.getTAmount3())) {
                OutputBook outputBook1 = outputBook.clone();
                outputBook1.setControlDim1(inputBook.getTDim3());
                String dueAmount3 = getDueDate(inputBook);
                outputBook1.setDueAmount1(dueAmount3);
                outputBooks.add(outputBook1);
            }
        } else if (StringUtils.isNotEmpty(inputBook.getTDim2()) && StringUtils.isNotEmpty(inputBook.getTAmount2())) {
            OutputBook outputBook1 = outputBook.clone();
            outputBook1.setControlDim1(inputBook.getTDim2());
            int dueAmount2;
            if("C".equalsIgnoreCase(inputBook.getTDim2()) || "AC".equalsIgnoreCase(inputBook.getTDim2())) {
                dueAmount2 =  Integer.parseInt(inputBook.getCycles());
            } else {
                dueAmount2 =  Integer.parseInt(inputBook.getHours());
            }
            outputBook1.setDueAmount1(String.valueOf(dueAmount2));
            outputBooks.add(outputBook1);

            if (StringUtils.isNotEmpty(inputBook.getTDim3()) && StringUtils.isNotEmpty(inputBook.getTAmount3())) {
                OutputBook outputBook2 = outputBook.clone();
                outputBook2.setControlDim1(inputBook.getTDim3());
                String dueAmount3 = getDueDate(inputBook);
                outputBook2.setDueAmount1(dueAmount3);
                outputBooks.add(outputBook2);
            }
        } else if (StringUtils.isNotEmpty(inputBook.getTDim3()) && StringUtils.isNotEmpty(inputBook.getTAmount3())) {
            OutputBook outputBook1 = outputBook.clone();
            outputBook1.setControlDim1(inputBook.getTDim3());

            String dueAmount1 = getDueDate(inputBook);
            outputBook1.setDueAmount1(dueAmount1);
            outputBooks.add(outputBook1);
        }
    }


    private String getDueDate(InputBook inputBook) throws ParseException {
        if ("DT".equalsIgnoreCase(inputBook.getTDim3().trim()))
            return inputBook.getTAmount3();

        //String iAmount3 = inputBook.getTAmount3();

        return addToCalender(inputBook.getDate(), 0, inputBook.getIDim3().trim());
    }

}
