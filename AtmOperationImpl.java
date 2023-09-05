import java.util.*;

public class AtmOperationImpl implements AtmOperationInterf {

    ATM atm = new ATM();
    Map<Double, String> ministat = new LinkedHashMap<>();

    public void viewBalance() {
        System.out.println("Available Balance is : " + atm.getBalance());

    }

    public void withdrawAmount(double withdrawAmount) {
        if (withdrawAmount % 500 == 0) {
            if (withdrawAmount <= atm.getBalance()) {
                ministat.put(withdrawAmount, " Amount Withdrawn");
                System.out.println("Collect the cash " + withdrawAmount);
                atm.setBalance(atm.getBalance() - withdrawAmount);
                viewBalance();
            } else {
                System.out.println("Insufficient Balance !!");
            }
        } else {
            System.out.println("Plase enter the amount in multiple of 500");
        }

    }

    public void depositAmount(double depositAmount) {
        ministat.put(depositAmount, " Amount Deposited");
        System.out.println(depositAmount + " Deposited Successfully !!");
        atm.setBalance(atm.getBalance() + depositAmount);//updated amount
        viewBalance();
    }

    public void viewMiniStatement() {
        for (Map.Entry<Double, String> m : ministat.entrySet()) {
            System.out.println(m.getKey() + "" + m.getValue());
        }
    }
}