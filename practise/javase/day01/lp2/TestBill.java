package javase.day01.lp2;

import java.time.LocalDate;

public class TestBill {
    public static void main(String[] args) {
        Bill bill = new Bill(123, LocalDate.of(2022,10,10),
                21,"test");

        bill.setBillAmount(34);
        bill.setBillNo(3213);
        bill.setBillOwner("tset2");
        bill.setBillTime(LocalDate.of(2022,9,23));

        bill.getBillAmount();
        bill.getBillNo();
        bill.getBillOwner();
        bill.getBillTime();
    }
}
