package com.example.simple_calculator.Database;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName="Data")
public class Data {
    @PrimaryKey(autoGenerate = true)
    public int serialNo;

    @ColumnInfo(name = "firstVariable")
    public double firstVariable;

    @ColumnInfo(name = "operator")
    public String operator;

    @ColumnInfo(name = "secondVariable")
    public double secondVariable;

    @ColumnInfo(name = "result")
    public double result;

    public Data(double firstVariable,String operator, double secondVariable, double result){
        this.firstVariable=firstVariable;
        this.operator=operator;
        this.secondVariable=secondVariable;
        this.result=result;
    }

    public int getSerialNo() {
        return serialNo;
    }

    public void setSerialNo(int serialNo) {
        this.serialNo = serialNo;
    }

    public double getFirstVariable() {
        return firstVariable;
    }

    public void setFirstVariable(double firstVariable) {
        this.firstVariable = firstVariable;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    public double getSecondVariable() {
        return secondVariable;
    }

    public void setSecondVariable(double secondVariable) {
        this.secondVariable = secondVariable;
    }

    public double getResult() {
        return result;
    }

    public void setResult(double result) {
        this.result = result;
    }
}
