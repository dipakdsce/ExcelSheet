package com.spicejet.xcheckpe.processor;

import com.spicejet.xcheckpe.model.InputBook;
import com.spicejet.xcheckpe.model.OutputBook;
import org.apache.commons.lang3.StringUtils;

import java.text.ParseException;

import static com.spicejet.xcheckpe.util.CommonUtil.addToCalender;

public class XCheckPeWithThresholdCal implements ICalculation {

    @Override
    public boolean execute(InputBook inputBook, OutputBook outputBook) throws ParseException {
        boolean flag = false;
        if (StringUtils.isNotEmpty(inputBook.getIAmount1()) && "C".equalsIgnoreCase(inputBook.getIDim1().trim())) {
            flag = true;
            outputBook.setControlDim1(inputBook.getIDim1().trim());
            int dueAmount = Integer.parseInt(inputBook.getCycles());
            outputBook.setDueAmount1(String.valueOf(dueAmount).trim());

            if (StringUtils.isNotEmpty(inputBook.getIAmount2()) && "C".equalsIgnoreCase(inputBook.getIDim2().trim())) {

                int dueAmount2;
                outputBook.setControlDim2(inputBook.getIDim2().trim());
                dueAmount2 = Integer.parseInt(inputBook.getCycles());
                outputBook.setDueAmount2(String.valueOf(dueAmount2).trim());

                if (StringUtils.isNotEmpty(inputBook.getIDim3()) && StringUtils.isNotEmpty(inputBook.getIAmount3()) && !("").equals(inputBook.getIDim3())) {
                    String temp = inputBook.getIDim3();
                    temp = temp.trim().replaceAll("\\s+", "");
                    if(!"".equals(temp)) {
                        outputBook.setControlDim3(inputBook.getIDim3().trim());
                        String dueAmount3 = getDueDate(inputBook);
                        outputBook.setDueAmount3(dueAmount3.trim());
                    }
                }
            } else if ((StringUtils.isNotEmpty(inputBook.getHours()) && StringUtils.isNotEmpty(inputBook.getIAmount2())) && "H".equalsIgnoreCase(inputBook.getIDim1().trim())) {
                outputBook.setControlDim2(inputBook.getIDim2().trim());
                int dueAmount2 = Integer.parseInt(inputBook.getHours());
                outputBook.setDueAmount2(String.valueOf(dueAmount2).trim());

                if (StringUtils.isNotEmpty(inputBook.getIDim3()) && StringUtils.isNotEmpty(inputBook.getIAmount3()) && !("").equals(inputBook.getIDim3())) {
                    String temp = inputBook.getIDim3();
                    temp = temp.trim().replaceAll("\\s+", "");
                    if(!"".equals(temp)) {
                        outputBook.setControlDim3(inputBook.getIDim3().trim());
                        String dueAmount3 = getDueDate(inputBook);
                        outputBook.setDueAmount3(dueAmount3.trim());
                    }
                }
            } else if (StringUtils.isNotEmpty(inputBook.getIDim3()) && StringUtils.isNotEmpty(inputBook.getIAmount3()) && !("").equals(inputBook.getIDim3())) {
                String temp = inputBook.getIDim3();
                temp = temp.trim().replaceAll("\\s+", "");
                if(!"".equals(temp)) {
                    outputBook.setControlDim2(inputBook.getIDim3().trim());
                    String dueAmount3 = getDueDate(inputBook);
                    outputBook.setDueAmount2(dueAmount3.trim());
                }
            }
        } else if((inputBook.getHours()!=null && StringUtils.isNotEmpty(inputBook.getIAmount1())) && "H".equalsIgnoreCase(inputBook.getIDim1().trim())) {
            flag = true;
            outputBook.setControlDim1(inputBook.getIDim1().trim());
            int dueAmount = Integer.parseInt(inputBook.getHours());
            outputBook.setDueAmount1(String.valueOf(dueAmount).trim());

            if ("C".equalsIgnoreCase(inputBook.getIDim2()) && StringUtils.isNotEmpty(inputBook.getIAmount2().trim())) {
                outputBook.setControlDim2(inputBook.getIDim2().trim());

                int dueAmount2;
                dueAmount2 = Integer.parseInt(inputBook.getCycles());
                outputBook.setDueAmount2(String.valueOf(dueAmount2).trim());

                if (StringUtils.isNotEmpty(inputBook.getIDim3()) && StringUtils.isNotEmpty(inputBook.getIAmount3()) && !("").equals(inputBook.getIDim3())) {
                    String temp = inputBook.getIDim3();
                    temp = temp.trim().replaceAll("\\s+", "");
                    if(!"".equals(temp)) {
                        outputBook.setControlDim3(inputBook.getIDim3().trim());
                        String dueAmount3 = getDueDate(inputBook);
                        outputBook.setDueAmount3(dueAmount3.trim());
                    }
                }
            } else if ((StringUtils.isNotEmpty(inputBook.getHours()) && StringUtils.isNotEmpty(inputBook.getIAmount2())) && "H".equalsIgnoreCase(inputBook.getIDim2().trim())) {
                outputBook.setControlDim2(inputBook.getIDim2().trim());

                int dueAmount2;
                dueAmount2 = Integer.parseInt(inputBook.getHours());
                outputBook.setDueAmount2(String.valueOf(dueAmount2).trim());

                if (StringUtils.isNotEmpty(inputBook.getIDim3()) && StringUtils.isNotEmpty(inputBook.getIAmount3()) && !("").equals(inputBook.getIDim3())) {
                    String temp = inputBook.getIDim3();
                    temp = temp.trim().replaceAll("\\s+", "");
                    if(!"".equals(temp)) {
                        outputBook.setControlDim3(inputBook.getIDim3().trim());
                        String dueAmount3 = getDueDate(inputBook);
                        outputBook.setDueAmount3(dueAmount3.trim());
                    }
                }
            } else if (StringUtils.isNotEmpty(inputBook.getIDim3()) && StringUtils.isNotEmpty(inputBook.getIAmount3()) && !("").equals(inputBook.getIDim3())) {
                String temp = inputBook.getIDim3();
                temp = temp.trim().replaceAll("\\s+", "");
                if(!"".equals(temp)) {
                    outputBook.setControlDim2(inputBook.getIDim3().trim());
                    String dueAmount3 = getDueDate(inputBook);
                    outputBook.setDueAmount2(dueAmount3.trim());
                }
            }

        } else if(StringUtils.isNotEmpty(inputBook.getIAmount2()) && ("C".equalsIgnoreCase(inputBook.getIDim2().trim()))){
            int dueAmount2;
            flag=true;
            outputBook.setControlDim1(inputBook.getIDim2().trim());
            dueAmount2=Integer.parseInt(inputBook.getCycles());
            outputBook.setDueAmount1(String.valueOf(dueAmount2).trim());

            if(StringUtils.isNotEmpty(inputBook.getIDim3())&&StringUtils.isNotEmpty(inputBook.getIAmount3()) && !("").equals(inputBook.getIDim3())){
                String temp = inputBook.getIDim3();
                temp = temp.trim().replaceAll("\\s+", "");
                if(!"".equals(temp)) {
                    outputBook.setControlDim2(inputBook.getIDim3().trim());
                    String dueAmount3 = getDueDate(inputBook);
                    outputBook.setDueAmount2(dueAmount3.trim());
                }
            }
        }else if((StringUtils.isNotEmpty(inputBook.getHours()) && StringUtils.isNotEmpty(inputBook.getIAmount2())) && "H".equalsIgnoreCase(inputBook.getIDim2().trim())){
            flag=true;
            outputBook.setControlDim1(inputBook.getIDim2().trim());
            int dueAmount2=Integer.parseInt(inputBook.getHours());
            outputBook.setDueAmount1(String.valueOf(dueAmount2).trim());

            if(StringUtils.isNotEmpty(inputBook.getIDim3())&&StringUtils.isNotEmpty(inputBook.getIAmount3()) && !("").equals(inputBook.getIDim3())){
                String temp = inputBook.getIDim3();
                temp = temp.trim().replaceAll("\\s+", "");
                if(!"".equals(temp)) {
                    outputBook.setControlDim2(inputBook.getIDim3().trim());
                    String dueAmount3 = getDueDate(inputBook);
                    outputBook.setDueAmount2(dueAmount3.trim());
                }
            }
        }else if(StringUtils.isNotEmpty(inputBook.getIDim3())&&StringUtils.isNotEmpty(inputBook.getIAmount3()) && !("").equals(inputBook.getIDim3())){
            String temp = inputBook.getIDim3();
            temp = temp.trim().replaceAll("\\s+", "");
            if(!"".equals(temp)) {
                flag = true;
                outputBook.setControlDim1(inputBook.getIDim3().trim());
                String dueAmount3 = getDueDate(inputBook);
                outputBook.setDueAmount1(dueAmount3.trim());
            }
        }

        return flag;
    }


private String getDueDate(InputBook inputBook)throws ParseException{
        if("DT".equalsIgnoreCase(inputBook.getIDim3().trim()))
        return inputBook.getIAmount3();


        return addToCalender(inputBook.getDate(),0,inputBook.getIDim3().trim());
    }
}
