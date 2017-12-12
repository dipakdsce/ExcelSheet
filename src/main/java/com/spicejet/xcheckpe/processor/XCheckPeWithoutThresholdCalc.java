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
        if ((StringUtils.isNotEmpty(inputBook.getHours()) && StringUtils.isNotEmpty(inputBook.getTAmount1())) && ("H".equalsIgnoreCase(inputBook.getTDim1().trim()) || "AH".equalsIgnoreCase(inputBook.getTDim1().trim()))) {
            flag = true;

            outputBook.setControlDim1(inputBook.getTDim1().trim());
            int dueAmount1 = Integer.parseInt(inputBook.getHours());
            outputBook.setDueAmount1(String.valueOf(dueAmount1).trim());

            if (("C".equalsIgnoreCase(inputBook.getTDim2().trim()) || "AC".equalsIgnoreCase(inputBook.getTDim2().trim())) && StringUtils.isNotEmpty(inputBook.getTAmount2())) {
                outputBook.setControlDim2(inputBook.getTDim2().trim());
                int dueAmount2 = Integer.parseInt(inputBook.getCycles());
                outputBook.setDueAmount2(String.valueOf(dueAmount2).trim());

                if (StringUtils.isNotEmpty(inputBook.getTDim3()) && StringUtils.isNotEmpty(inputBook.getTAmount3()) && !("").equals(inputBook.getTDim3())) {
                    String temp = inputBook.getTDim3();
                    temp = temp.trim().replaceAll("\\s+", "");
                    if(!"".equals(temp)) {
                        outputBook.setControlDim3(inputBook.getTDim3().trim());
                        String dueAmount3 = getDueDate(inputBook);
                        outputBook.setDueAmount3(dueAmount3.trim());
                    }
                }
            } else if ((StringUtils.isNotEmpty(inputBook.getHours()) && StringUtils.isNotEmpty(inputBook.getTAmount2())) && ("H".equalsIgnoreCase(inputBook.getTDim1().trim()) || "AH".equalsIgnoreCase(inputBook.getTDim1().trim()))) {
                    outputBook.setControlDim2(inputBook.getTDim2().trim());
                    int dueAmount2 = Integer.parseInt(inputBook.getHours());
                    outputBook.setDueAmount2(String.valueOf(dueAmount2).trim());

                if (StringUtils.isNotEmpty(inputBook.getTDim3()) && StringUtils.isNotEmpty(inputBook.getTAmount3()) && !("").equals(inputBook.getTDim3())) {
                    String temp = inputBook.getTDim3();
                    temp = temp.trim().replaceAll("\\s+", "");
                    if(!"".equals(temp)) {
                        outputBook.setControlDim3(inputBook.getTDim3().trim());
                        String dueAmount3 = getDueDate(inputBook);
                        outputBook.setDueAmount3(dueAmount3.trim());
                    }
                }
            } else if (StringUtils.isNotEmpty(inputBook.getTDim3()) && StringUtils.isNotEmpty(inputBook.getTAmount3()) && !("").equals(inputBook.getTDim3())) {
                String temp = inputBook.getTDim3();
                temp = temp.trim().replaceAll("\\s+", "");
                if(!"".equals(temp)) {
                    outputBook.setControlDim2(inputBook.getTDim3().trim());
                    String dueAmount3 = getDueDate(inputBook);
                    outputBook.setDueAmount2(dueAmount3.trim());
                }
            }
        } else if (StringUtils.isNotEmpty(inputBook.getTAmount1()) && ("C".equalsIgnoreCase(inputBook.getTDim1().trim()) || "AC".equalsIgnoreCase(inputBook.getTDim1().trim()))) {
            flag = true;

            outputBook.setControlDim1(inputBook.getTDim1().trim());
            int dueAmount1 = Integer.parseInt(inputBook.getCycles());
            outputBook.setDueAmount1(String.valueOf(dueAmount1).trim());

            if (("H".equalsIgnoreCase(inputBook.getTDim2().trim()) || "AH".equalsIgnoreCase(inputBook.getTDim2().trim())) && (StringUtils.isNotEmpty(inputBook.getHours()) && StringUtils.isNotEmpty(inputBook.getTAmount2()))) {
                outputBook.setControlDim2(inputBook.getTDim2().trim());
                int dueAmount2 = Integer.parseInt(inputBook.getHours());
                outputBook.setDueAmount2(String.valueOf(dueAmount2).trim());

                if (StringUtils.isNotEmpty(inputBook.getTDim3()) && StringUtils.isNotEmpty(inputBook.getTAmount3()) && !("").equals(inputBook.getTDim3())) {
                    String temp = inputBook.getTDim3();
                    temp = temp.trim().replaceAll("\\s+", "");
                    if(!"".equals(temp)) {
                        outputBook.setControlDim3(inputBook.getTDim3().trim());
                        String dueAmount3 = getDueDate(inputBook);
                        outputBook.setDueAmount3(dueAmount3.trim());
                    }
                }
            } else if (StringUtils.isNotEmpty(inputBook.getTAmount2()) && ("C".equalsIgnoreCase(inputBook.getTDim2().trim()) || "AC".equalsIgnoreCase(inputBook.getTDim2().trim()))) {
                outputBook.setControlDim2(inputBook.getTDim2().trim());
                int dueAmount2 = Integer.parseInt(inputBook.getCycles());
                outputBook.setDueAmount2(String.valueOf(dueAmount2).trim());

                if (StringUtils.isNotEmpty(inputBook.getTDim3()) && StringUtils.isNotEmpty(inputBook.getTAmount3()) && !("").equals(inputBook.getTDim3())) {
                    String temp = inputBook.getTDim3();
                    temp = temp.trim().replaceAll("\\s+", "");
                    if(!"".equals(temp)) {
                        outputBook.setControlDim3(inputBook.getTDim3().trim());
                        String dueAmount3 = getDueDate(inputBook);
                        outputBook.setDueAmount3(dueAmount3.trim());
                    }
                }


            } else if (StringUtils.isNotEmpty(inputBook.getTDim3()) && StringUtils.isNotEmpty(inputBook.getTAmount3()) && !("").equals(inputBook.getTDim3())) {
                String temp = inputBook.getTDim3();
                temp = temp.trim().replaceAll("\\s+", "");
                if(!"".equals(temp)) {
                    outputBook.setControlDim2(inputBook.getTDim3().trim());
                    String dueAmount3 = getDueDate(inputBook);
                    outputBook.setDueAmount2(dueAmount3.trim());
                }
            }
        } else if (StringUtils.isNotEmpty(inputBook.getTAmount2()) && ("C".equalsIgnoreCase(inputBook.getTDim2().trim()) || "AC".equalsIgnoreCase(inputBook.getTDim2().trim()))) {
            flag = true;
            outputBook.setControlDim1(inputBook.getTDim2().trim());
            int dueAmount2 = Integer.parseInt(inputBook.getCycles());
            outputBook.setDueAmount1(String.valueOf(dueAmount2).trim());

            if (StringUtils.isNotEmpty(inputBook.getTDim3()) && StringUtils.isNotEmpty(inputBook.getTAmount3()) && !("").equals(inputBook.getTDim3())) {
                String temp = inputBook.getTDim3();
                temp = temp.trim().replaceAll("\\s+", "");
                if(!"".equals(temp)) {
                    outputBook.setControlDim2(inputBook.getTDim3().trim());
                    String dueAmount3 = getDueDate(inputBook);
                    outputBook.setDueAmount2(dueAmount3.trim());
                }
            }
        } else if ((StringUtils.isNotEmpty(inputBook.getHours()) && StringUtils.isNotEmpty(inputBook.getTAmount2())) && ("H".equalsIgnoreCase(inputBook.getTDim1().trim()) || "AH".equalsIgnoreCase(inputBook.getTDim1().trim()))) {
            flag = true;
            outputBook.setControlDim1(inputBook.getTDim2().trim());
            int dueAmount2 = Integer.parseInt(inputBook.getHours());
            outputBook.setDueAmount1(String.valueOf(dueAmount2).trim());

            if (StringUtils.isNotEmpty(inputBook.getTDim3()) && StringUtils.isNotEmpty(inputBook.getTAmount3()) && !("").equals(inputBook.getTDim3())) {
                String temp = inputBook.getTDim3();
                temp = temp.trim().replaceAll("\\s+", "");
                if(!"".equals(temp)) {
                    outputBook.setControlDim2(inputBook.getTDim3().trim());
                    String dueAmount3 = getDueDate(inputBook);
                    outputBook.setDueAmount2(dueAmount3.trim());
                }
            }

        } else if(StringUtils.isNotEmpty(inputBook.getTDim3())&&StringUtils.isNotEmpty(inputBook.getTAmount3()) && !("").equals(inputBook.getTDim3())) {
            String temp = inputBook.getTDim3();
            temp = temp.trim().replaceAll("\\s+", "");
            if(!"".equals(temp)) {
                flag = true;
                outputBook.setControlDim1(inputBook.getTDim3().trim());

                String dueAmount1 = getDueDate(inputBook);
                outputBook.setDueAmount1(dueAmount1.trim());
            }
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
