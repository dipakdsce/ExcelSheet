package com.spicejet.xcheckpe.processor;

import com.spicejet.xcheckpe.model.InputBook;
import com.spicejet.xcheckpe.model.OutputBook;
import org.apache.commons.lang3.StringUtils;

import java.text.ParseException;

import static com.spicejet.xcheckpe.util.CommonUtil.addToCalender;

public class XCheckPeWithoutThresholdCalc implements ICalculation {

    @Override
    public boolean execute(InputBook inputBook, OutputBook outputBook) throws ParseException {
        boolean flag = false;
        if (StringUtils.isNotEmpty(inputBook.getTDim1()) && StringUtils.isNotEmpty(inputBook.getTAmount1())) {
            flag = true;
            outputBook.setControlDim1(inputBook.getTDim1());
            int dueAmount1;
            if("C".equalsIgnoreCase(inputBook.getTDim1()) || "AC".equalsIgnoreCase(inputBook.getTDim1())) {
                dueAmount1 =  Integer.parseInt(inputBook.getCycles());
            } else {
                dueAmount1 =  Integer.parseInt(inputBook.getHours());
            }
            //int dueAmount1 = Integer.parseInt(inputBook.getTAmount1());
            outputBook.setDueAmount1(String.valueOf(dueAmount1));

            if (StringUtils.isNotEmpty(inputBook.getTDim2()) && StringUtils.isNotEmpty(inputBook.getTAmount2())) {
                outputBook.setControlDim2(inputBook.getTDim2());
                int dueAmount2;
                if("C".equalsIgnoreCase(inputBook.getTDim2()) || "AC".equalsIgnoreCase(inputBook.getTDim2())) {
                    dueAmount2 =  Integer.parseInt(inputBook.getCycles());
                } else {
                    dueAmount2 =  Integer.parseInt(inputBook.getHours());
                }
//                int dueAmount2 = Integer.parseInt(inputBook.getTAmount2());
                outputBook.setDueAmount2(String.valueOf(dueAmount2));

                if (StringUtils.isNotEmpty(inputBook.getTDim3()) && StringUtils.isNotEmpty(inputBook.getTAmount3())) {
                    outputBook.setControlDim3(inputBook.getTDim3());
                    String dueAmount3 = getDueDate(inputBook);
                    outputBook.setDueAmount3(dueAmount3);
                }
            } else if (StringUtils.isNotEmpty(inputBook.getTDim3()) && StringUtils.isNotEmpty(inputBook.getTAmount3())) {
                outputBook.setControlDim2(inputBook.getTDim3());
                String dueAmount3 = getDueDate(inputBook);
                outputBook.setDueAmount2(dueAmount3);
            }
        } else if (StringUtils.isNotEmpty(inputBook.getTDim2()) && StringUtils.isNotEmpty(inputBook.getTAmount2())) {
            flag = true;
            outputBook.setControlDim1(inputBook.getTDim2());
            int dueAmount2;
            if("C".equalsIgnoreCase(inputBook.getTDim2()) || "AC".equalsIgnoreCase(inputBook.getTDim2())) {
                dueAmount2 =  Integer.parseInt(inputBook.getCycles());
            } else {
                dueAmount2 =  Integer.parseInt(inputBook.getHours());
            }
            outputBook.setDueAmount1(String.valueOf(dueAmount2));

            if (StringUtils.isNotEmpty(inputBook.getTDim3()) && StringUtils.isNotEmpty(inputBook.getTAmount3())) {
                outputBook.setControlDim2(inputBook.getTDim3());
                String dueAmount3 = getDueDate(inputBook);
                outputBook.setDueAmount2(dueAmount3);
            }
        } else if (StringUtils.isNotEmpty(inputBook.getTDim3()) && StringUtils.isNotEmpty(inputBook.getTAmount3())) {
            flag = true;
            outputBook.setControlDim1(inputBook.getTDim3());

            String dueAmount1 = getDueDate(inputBook);
            outputBook.setDueAmount1(dueAmount1);
        }

        return flag;
    }

    /*private String getDueDate(InputBook inputBook) throws ParseException {
        if ("DT".equalsIgnoreCase(inputBook.getTDim3().trim()))
            return inputBook.getTAmount3();

        String tDim3 = inputBook.getTDim3().trim();
        int tAmount3 = Integer.parseInt(inputBook.getTAmount3());
        String dueAmount3 = "";

        if ("E".equalsIgnoreCase(inputBook.getThrBase().trim()))
            dueAmount3 = addToCalender(inputBook.getE(), tAmount3, tDim3);
        else if ("M".equalsIgnoreCase(inputBook.getThrBase().trim()))
            dueAmount3 = addToCalender(inputBook.getM(), tAmount3, tDim3);
        else if ("D".equalsIgnoreCase(inputBook.getThrBase().trim()))
            dueAmount3 = addToCalender(inputBook.getD(), tAmount3, tDim3);
        else if ("I".equalsIgnoreCase(inputBook.getThrBase().trim()))
            dueAmount3 = addToCalender(inputBook.getI(), tAmount3, tDim3);
        else if ("S".equalsIgnoreCase(inputBook.getThrBase().trim()))
            dueAmount3 = addToCalender(inputBook.getS(), tAmount3, tDim3);
        else if ("V".equalsIgnoreCase(inputBook.getThrBase().trim()))
            dueAmount3 = addToCalender(inputBook.getV(), tAmount3, tDim3);

        return dueAmount3;
    }*/

    private String getDueDate(InputBook inputBook) throws ParseException {
        if ("DT".equalsIgnoreCase(inputBook.getTDim3().trim()))
            return inputBook.getTAmount3();

        //String iAmount3 = inputBook.getTAmount3();

        return addToCalender(inputBook.getDate(), 0, inputBook.getIDim3().trim());
    }

}
