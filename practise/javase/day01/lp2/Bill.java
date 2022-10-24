package javase.day01.lp2;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Bill {
    private int billNo;
    private LocalDate billTime;
    private float billAmount;
    private String billOwner;

    public Bill(int billNo, LocalDate billTime, float billAmount, String billOwner){
        this.billAmount = billAmount;
        this.billNo = billNo;
        this.billOwner = billOwner;
        this.billTime = billTime;
    }

    public void setBillAmount(float billAmount) {
        this.billAmount = billAmount;
    }

    public void setBillNo(int billNo) {
        this.billNo = billNo;
    }

    public void setBillOwner(String billOwner) {
        this.billOwner = billOwner;
    }

    public void setBillTime(LocalDate billTime) {
        this.billTime = billTime;
    }

    public float getBillAmount() {
        System.out.println(billAmount);
        return billAmount;
    }

    public int getBillNo() {
        System.out.println(billNo);
        return billNo;
    }

    public LocalDate getBillTime() {
        System.out.println(billTime);
        return billTime;
    }

    public String getBillOwner() {
        System.out.println(billOwner);
        return billOwner;
    }
}
