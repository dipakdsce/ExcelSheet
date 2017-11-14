package com.spicejet.xcheckpe.model;

import lombok.Data;

@Data
public class OutputBook implements  Cloneable{

    private String tempA;
    private String tempB;
    private String tempC;
    private String tempD;
    private String tempE;
    private String tempF;
    private String checkType;
    private String aircraft;
    private String controlDim1;
    private String dueAmount1;
    private String controlDim2;
    private String dueAmount2;
    private String controlDim3;
    private String dueAmount3;

    public OutputBook() {
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

    public String getCheckType() {
        return this.checkType;
    }

    public String getAircraft() {
        return this.aircraft;
    }

    public String getControlDim1() {
        return this.controlDim1;
    }

    public String getDueAmount1() {
        return this.dueAmount1;
    }

    public String getControlDim2() {
        return this.controlDim2;
    }

    public String getDueAmount2() {
        return this.dueAmount2;
    }

    public String getControlDim3() {
        return this.controlDim3;
    }

    public String getDueAmount3() {
        return this.dueAmount3;
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

    public void setCheckType(String checkType) {
        this.checkType = checkType;
    }

    public void setAircraft(String aircraft) {
        this.aircraft = aircraft;
    }

    public void setControlDim1(String controlDim1) {
        this.controlDim1 = controlDim1;
    }

    public void setDueAmount1(String dueAmount1) {
        this.dueAmount1 = dueAmount1;
    }


    public boolean equals(Object o) {
        if(o == this) {
            return true;
        } else if(!(o instanceof OutputBook)) {
            return false;
        } else {
            OutputBook other = (OutputBook)o;
            if(!other.canEqual(this)) {
                return false;
            } else {
                String this$tempA = this.getTempA();
                String other$tempA = other.getTempA();
                if(this$tempA == null) {
                    if(other$tempA != null) {
                        return false;
                    }
                } else if(!this$tempA.equals(other$tempA)) {
                    return false;
                }

                String this$tempB = this.getTempB();
                String other$tempB = other.getTempB();
                if(this$tempB == null) {
                    if(other$tempB != null) {
                        return false;
                    }
                } else if(!this$tempB.equals(other$tempB)) {
                    return false;
                }

                String this$tempC = this.getTempC();
                String other$tempC = other.getTempC();
                if(this$tempC == null) {
                    if(other$tempC != null) {
                        return false;
                    }
                } else if(!this$tempC.equals(other$tempC)) {
                    return false;
                }

                label158: {
                    String this$tempD = this.getTempD();
                    String other$tempD = other.getTempD();
                    if(this$tempD == null) {
                        if(other$tempD == null) {
                            break label158;
                        }
                    } else if(this$tempD.equals(other$tempD)) {
                        break label158;
                    }

                    return false;
                }

                label151: {
                    String this$tempE = this.getTempE();
                    String other$tempE = other.getTempE();
                    if(this$tempE == null) {
                        if(other$tempE == null) {
                            break label151;
                        }
                    } else if(this$tempE.equals(other$tempE)) {
                        break label151;
                    }

                    return false;
                }

                String this$tempF = this.getTempF();
                String other$tempF = other.getTempF();
                if(this$tempF == null) {
                    if(other$tempF != null) {
                        return false;
                    }
                } else if(!this$tempF.equals(other$tempF)) {
                    return false;
                }

                label137: {
                    String this$checkType = this.getCheckType();
                    String other$checkType = other.getCheckType();
                    if(this$checkType == null) {
                        if(other$checkType == null) {
                            break label137;
                        }
                    } else if(this$checkType.equals(other$checkType)) {
                        break label137;
                    }

                    return false;
                }

                label130: {
                    String this$aircraft = this.getAircraft();
                    String other$aircraft = other.getAircraft();
                    if(this$aircraft == null) {
                        if(other$aircraft == null) {
                            break label130;
                        }
                    } else if(this$aircraft.equals(other$aircraft)) {
                        break label130;
                    }

                    return false;
                }

                String this$controlDim1 = this.getControlDim1();
                String other$controlDim1 = other.getControlDim1();
                if(this$controlDim1 == null) {
                    if(other$controlDim1 != null) {
                        return false;
                    }
                } else if(!this$controlDim1.equals(other$controlDim1)) {
                    return false;
                }

                String this$dueAmount1 = this.getDueAmount1();
                String other$dueAmount1 = other.getDueAmount1();
                if(this$dueAmount1 == null) {
                    if(other$dueAmount1 != null) {
                        return false;
                    }
                } else if(!this$dueAmount1.equals(other$dueAmount1)) {
                    return false;
                }

                label109: {
                    String this$controlDim2 = this.getControlDim2();
                    String other$controlDim2 = other.getControlDim2();
                    if(this$controlDim2 == null) {
                        if(other$controlDim2 == null) {
                            break label109;
                        }
                    } else if(this$controlDim2.equals(other$controlDim2)) {
                        break label109;
                    }

                    return false;
                }

                label102: {
                    String this$dueAmount2 = this.getDueAmount2();
                    String other$dueAmount2 = other.getDueAmount2();
                    if(this$dueAmount2 == null) {
                        if(other$dueAmount2 == null) {
                            break label102;
                        }
                    } else if(this$dueAmount2.equals(other$dueAmount2)) {
                        break label102;
                    }

                    return false;
                }

                String this$controlDim3 = this.getControlDim3();
                String other$controlDim3 = other.getControlDim3();
                if(this$controlDim3 == null) {
                    if(other$controlDim3 != null) {
                        return false;
                    }
                } else if(!this$controlDim3.equals(other$controlDim3)) {
                    return false;
                }

                String this$dueAmount3 = this.getDueAmount3();
                String other$dueAmount3 = other.getDueAmount3();
                if(this$dueAmount3 == null) {
                    if(other$dueAmount3 != null) {
                        return false;
                    }
                } else if(!this$dueAmount3.equals(other$dueAmount3)) {
                    return false;
                }

                return true;
            }
        }
    }

    protected boolean canEqual(Object other) {
        return other instanceof OutputBook;
    }

    public int hashCode() {
        boolean PRIME = true;
        byte result = 1;
        String $tempA = this.getTempA();
        int result1 = result * 59 + ($tempA == null?43:$tempA.hashCode());
        String $tempB = this.getTempB();
        result1 = result1 * 59 + ($tempB == null?43:$tempB.hashCode());
        String $tempC = this.getTempC();
        result1 = result1 * 59 + ($tempC == null?43:$tempC.hashCode());
        String $tempD = this.getTempD();
        result1 = result1 * 59 + ($tempD == null?43:$tempD.hashCode());
        String $tempE = this.getTempE();
        result1 = result1 * 59 + ($tempE == null?43:$tempE.hashCode());
        String $tempF = this.getTempF();
        result1 = result1 * 59 + ($tempF == null?43:$tempF.hashCode());
        String $checkType = this.getCheckType();
        result1 = result1 * 59 + ($checkType == null?43:$checkType.hashCode());
        String $aircraft = this.getAircraft();
        result1 = result1 * 59 + ($aircraft == null?43:$aircraft.hashCode());
        String $controlDim1 = this.getControlDim1();
        result1 = result1 * 59 + ($controlDim1 == null?43:$controlDim1.hashCode());
        String $dueAmount1 = this.getDueAmount1();
        result1 = result1 * 59 + ($dueAmount1 == null?43:$dueAmount1.hashCode());
        return result1;
    }

    public String toString() {
        return "OutputBook(tempA=" + this.getTempA() + ", tempB=" + this.getTempB() + ", tempC=" + this.getTempC() + ", tempD=" + this.getTempD() + ", tempE=" + this.getTempE() + ", tempF=" + this.getTempF() + ", checkType=" + this.getCheckType() + ", aircraft=" + this.getAircraft() + ", controlDim1=" + this.getControlDim1() + ", dueAmount1=" + this.getDueAmount1() + ")";
    }

    public OutputBook clone() {
        try {
            return (OutputBook) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
            throw new RuntimeException();
        }
    }
}
