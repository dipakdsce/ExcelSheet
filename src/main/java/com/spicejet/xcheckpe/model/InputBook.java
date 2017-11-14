package com.spicejet.xcheckpe.model;

import lombok.Data;
import org.apache.commons.lang3.StringUtils;

@Data
public class InputBook {

    private String tempA;
    private String tempB;
    private String tempC;
    private String tempD;
    private String tempE;
    private String tempF;
    private String checkName;
    private String aircraft;
    private String thresholdUsed;
    private String hours;
    private String cycles;
    private String date;
    private String e;
    private String m;
    private String d;
    private String i;
    private String s;
    private String v;
    private String thrBase;
    private String thrBaseDim;
    private String thrBaseAmount;
    private String tDim1;
    private String tAmount1;
    private String tDim2;
    private String tAmount2;
    private String tDim3;
    private String tAmount3;
    private String iDim1;
    private String iAmount1;
    private String iDim2;
    private String iAmount2;
    private String iDim3;
    private String iAmount3;
    private int rowCount;

    @Override
    public int hashCode() {
        return this.checkName.length() + this.aircraft.length();
    }

    @Override
    public boolean equals(Object obj) {
        InputBook inputBook = (InputBook) obj;

        if (this.checkName.equalsIgnoreCase(inputBook.checkName)
                && this.aircraft.equalsIgnoreCase(inputBook.aircraft)) {
            return true;
        }

        return false;
    }

    public InputBook() {
    }

    public String getTempA() {
        return this.tempA;
    }

    public String getTempB() {
        return this.tempB;
    }

    public String getTempC() {
        return this.tempC;
    }

    public String getTempD() {
        return this.tempD;
    }

    public String getTempE() {
        return this.tempE;
    }

    public String getTempF() {
        return this.tempF;
    }

    public String getCheckName() {
        return this.checkName;
    }

    public String getAircraft() {
        return this.aircraft;
    }

    public String getThresholdUsed() {
        return this.thresholdUsed;
    }

    public String getHours() {
        return this.hours;
    }

    public String getCycles() {
        return this.cycles;
    }

    public String getDate() {
        return this.date;
    }

    public String getE() {
        return this.e;
    }

    public String getM() {
        return this.m;
    }

    public String getD() {
        return this.d;
    }

    public String getI() {
        return this.i;
    }

    public String getS() {
        return this.s;
    }

    public String getV() {
        return this.v;
    }

    public String getThrBase() {
        return this.thrBase;
    }

    public String getThrBaseDim() {
        return this.thrBaseDim;
    }

    public String getThrBaseAmount() {
        return this.thrBaseAmount;
    }

    public String getTDim1() {
        return this.tDim1;
    }

    public String getTAmount1() {
        return this.tAmount1;
    }

    public String getTDim2() {
        return this.tDim2;
    }

    public String getTAmount2() {
        return this.tAmount2;
    }

    public String getTDim3() {
        return this.tDim3;
    }

    public String getTAmount3() {
        return this.tAmount3;
    }

    public String getIDim1() {
        return this.iDim1;
    }

    public String getIAmount1() {
        return this.iAmount1;
    }

    public String getIDim2() {
        return this.iDim2;
    }

    public String getIAmount2() {
        return this.iAmount2;
    }

    public String getIDim3() {
        return this.iDim3;
    }

    public String getIAmount3() {
        return this.iAmount3;
    }

    public int getRowCount() {
        return this.rowCount;
    }

    public void setTempA(String tempA) {
        this.tempA = tempA;
    }

    public void setTempB(String tempB) {
        this.tempB = tempB;
    }

    public void setTempC(String tempC) {
        this.tempC = tempC;
    }

    public void setTempD(String tempD) {
        this.tempD = tempD;
    }

    public void setTempE(String tempE) {
        this.tempE = tempE;
    }

    public void setTempF(String tempF) {
        this.tempF = tempF;
    }

    public void setCheckName(String checkName) {
        this.checkName = checkName;
    }

    public void setAircraft(String aircraft) {
        this.aircraft = aircraft;
    }

    public void setThresholdUsed(String thresholdUsed) {
        this.thresholdUsed = thresholdUsed;
    }

    public void setHours(String hours) {
        this.hours = hours;
    }

    public void setCycles(String cycles) {
        this.cycles = cycles;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setE(String e) {
        this.e = e;
    }

    public void setM(String m) {
        this.m = m;
    }

    public void setD(String d) {
        this.d = d;
    }

    public void setI(String i) {
        this.i = i;
    }

    public void setS(String s) {
        this.s = s;
    }

    public void setV(String v) {
        this.v = v;
    }

    public void setThrBase(String thrBase) {
        this.thrBase = thrBase;
    }

    public void setThrBaseDim(String thrBaseDim) {
        this.thrBaseDim = thrBaseDim;
    }

    public void setThrBaseAmount(String thrBaseAmount) {
        this.thrBaseAmount = thrBaseAmount;
    }

    public void setTDim1(String tDim1) {
        this.tDim1 = tDim1;
    }

    public void setTAmount1(String tAmount1) {
        this.tAmount1 = tAmount1;
    }

    public void setTDim2(String tDim2) {
        this.tDim2 = tDim2;
    }

    public void setTAmount2(String tAmount2) {
        this.tAmount2 = tAmount2;
    }

    public void setTDim3(String tDim3) {
        this.tDim3 = tDim3;
    }

    public void setTAmount3(String tAmount3) {
        this.tAmount3 = tAmount3;
    }

    public void setIDim1(String iDim1) {
        this.iDim1 = iDim1;
    }

    public void setIAmount1(String iAmount1) {
        this.iAmount1 = iAmount1;
    }

    public void setIDim2(String iDim2) {
        this.iDim2 = iDim2;
    }

    public void setIAmount2(String iAmount2) {
        this.iAmount2 = iAmount2;
    }

    public void setIDim3(String iDim3) {
        this.iDim3 = iDim3;
    }

    public void setIAmount3(String iAmount3) {
        this.iAmount3 = iAmount3;
    }

    public void setRowCount(int rowCount) {
        this.rowCount = rowCount;
    }

    public String toString() {
        return "InputBook(tempA=" + this.getTempA() + ", tempB=" + this.getTempB() + ", tempC=" + this.getTempC() + ", tempD=" + this.getTempD() + ", tempE=" + this.getTempE() + ", tempF=" + this.getTempF() + ", checkName=" + this.getCheckName() + ", aircraft=" + this.getAircraft() + ", thresholdUsed=" + this.getThresholdUsed() + ", hours=" + this.getHours() + ", cycles=" + this.getCycles() + ", date=" + this.getDate() + ", e=" + this.getE() + ", m=" + this.getM() + ", d=" + this.getD() + ", i=" + this.getI() + ", s=" + this.getS() + ", v=" + this.getV() + ", thrBase=" + this.getThrBase() + ", thrBaseDim=" + this.getThrBaseDim() + ", thrBaseAmount=" + this.getThrBaseAmount() + ", tDim1=" + this.getTDim1() + ", tAmount1=" + this.getTAmount1() + ", tDim2=" + this.getTDim2() + ", tAmount2=" + this.getTAmount2() + ", tDim3=" + this.getTDim3() + ", tAmount3=" + this.getTAmount3() + ", iDim1=" + this.getIDim1() + ", iAmount1=" + this.getIAmount1() + ", iDim2=" + this.getIDim2() + ", iAmount2=" + this.getIAmount2() + ", iDim3=" + this.getIDim3() + ", iAmount3=" + this.getIAmount3() + ", rowCount=" + this.getRowCount() + ")";
    }
}
