package com.spicejet.xcheckpe.processor;

import com.spicejet.xcheckpe.model.InputBook;
import com.spicejet.xcheckpe.model.OutputBook;
import org.apache.commons.lang3.StringUtils;

import java.text.ParseException;

import static com.spicejet.xcheckpe.util.CommonUtil.addToCalender;

public class XCheckPeWithThresholdCal implements ICalculation {

    @Override
    public void execute(InputBook inputBook, OutputBook outputBook) throws ParseException {
        if (StringUtils.isNotEmpty(inputBook.getIDim1()) && StringUtils.isNotEmpty(inputBook.getIAmount1())) {
            outputBook.setControlDim1(inputBook.getIDim1());
            int dueAmount ;
            if("C".equalsIgnoreCase(inputBook.getIDim1()) ) {
                dueAmount =  Integer.parseInt(inputBook.getCycles());
            } else {
                dueAmount =  Integer.parseInt(inputBook.getHours());
            }

            outputBook.setDueAmount1(String.valueOf(dueAmount));

            if (StringUtils.isNotEmpty(inputBook.getIDim2()) && StringUtils.isNotEmpty(inputBook.getIAmount2())) {
                outputBook.setControlDim2(inputBook.getIDim2());

                int dueAmount2 ;
                if("C".equalsIgnoreCase(inputBook.getIDim2())) {
                    dueAmount2 =  Integer.parseInt(inputBook.getCycles());
                } else {
                    dueAmount2 =  Integer.parseInt(inputBook.getHours());
                }
                outputBook.setDueAmount2(String.valueOf(dueAmount2));

                if (StringUtils.isNotEmpty(inputBook.getIDim3()) && StringUtils.isNotEmpty(inputBook.getIAmount3())) {
                    outputBook.setControlDim3(inputBook.getIDim3());
                    String dueAmount3 = getDueDate(inputBook);
                    outputBook.setDueAmount3(dueAmount3);
                }
            } else if (StringUtils.isNotEmpty(inputBook.getIDim3()) && StringUtils.isNotEmpty(inputBook.getIAmount3())) {
                outputBook.setControlDim2(inputBook.getIDim3());
                String dueAmount3 = getDueDate(inputBook);
                outputBook.setDueAmount2(dueAmount3);
            }
        } else if (StringUtils.isNotEmpty(inputBook.getIDim2()) && StringUtils.isNotEmpty(inputBook.getIAmount2())) {
            outputBook.setControlDim1(inputBook.getIDim2());
            int dueAmount2 ;
            if("C".equalsIgnoreCase(inputBook.getIDim2())) {
                dueAmount2 =  Integer.parseInt(inputBook.getCycles());
            } else {
                dueAmount2 =  Integer.parseInt(inputBook.getHours());
            }
            outputBook.setDueAmount1(String.valueOf(dueAmount2));

            if (StringUtils.isNotEmpty(inputBook.getIDim3()) && StringUtils.isNotEmpty(inputBook.getIAmount3())) {
                outputBook.setControlDim2(inputBook.getIDim3());
                String dueAmount3 = getDueDate(inputBook);
                outputBook.setDueAmount2(dueAmount3);
            }
        } else if (StringUtils.isNotEmpty(inputBook.getIDim3()) && StringUtils.isNotEmpty(inputBook.getIAmount3())) {
            outputBook.setControlDim1(inputBook.getIDim3());
            String dueAmount3 = getDueDate(inputBook);
            outputBook.setDueAmount1(dueAmount3);
        }
    }

    private String getDueDate(InputBook inputBook) throws ParseException {
        if ("DT".equalsIgnoreCase(inputBook.getIDim3().trim()))
            return inputBook.getIAmount3();


        return addToCalender(inputBook.getDate(), 0, inputBook.getIDim3().trim());
    }
}
