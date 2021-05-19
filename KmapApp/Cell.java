package jbbellot.ysu.KmapApp;

public class Cell {
    private int cellValue = 0;
    private Boolean inUse = false;
    private String inputA;
    private String inputB;
    private String inputC;
    private String inputD;



    public void setCellValue(int cellValue) {
        this.cellValue = cellValue;
    }

    public int getCellValue() {
        return cellValue;
    }

    public String getInputA() {
        return inputA;
    }

    public void setInputA(String inputA) {
        this.inputA = inputA;
    }

    public String getInputB() {
        return inputB;
    }

    public void setInputB(String inputB) {
        this.inputB = inputB;
    }

    public String getInputC() {
        return inputC;
    }

    public void setInputC(String inputC) {
        this.inputC = inputC;
    }

    public String getInputD() {
        return inputD;
    }

    public void setInputD(String inputD) {
        this.inputD = inputD;
    }

    public Boolean getInUse() {
        return inUse;
    }

    public void setInUse(Boolean inUse) {
        this.inUse = inUse;
    }

    public String logicalExpression(){
        return inputA + inputB + inputC + inputD;



    }


}

