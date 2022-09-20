package Week5.Day19;

class Account {
    int accno;
    static int balance = 500;

    void DisplayBalance() {
        System.out.println("*******"
                + ""
                + "****** ACCOUNT BALANCE *************");
        System.out.println("Account Current balance is::" + balance);
    }

    synchronized void Withdraw(int amt)//500
    {
        System.out.println("***************** WITHDRAW ****************");
        System.out.println("Withdrawn amount is::" + amt);
        if (balance < 1000) {
            System.out.println("SORRY!!! Insufficient balance ::" + balance
                    + "\twaiting for deposit...");

            try {
                wait();
            } catch (Exception e) {
            }
        }
        balance = balance - amt;

        System.out.println("Withdraw Completed...Account Balance::" + balance);//4500
    }

    synchronized void Deposit(int amt)//2000
    {
        System.out.println("**************** DEPOSIT ******************");

        balance = balance + amt;

        System.out.println("Deposited amount is::" + amt);
        System.out.println("Deposit Completely...Account Balance::" + balance);
        notify();

        //500+2000=>2500

    }
}

class Deposit extends Thread {

    AccountSynBlock acc;

    Deposit(AccountSynBlock acc) {
        this.acc = acc;
    }

    public void run() {
        acc.Deposit(2000);
    }
}

class Withdraw1 extends Thread {
    AccountSynBlock acc;

    Withdraw1(AccountSynBlock acc) {
        this.acc = acc;
    }

    public void run() {
        acc.Withdraw(500);
    }
}

public class BankSynchronizedMethod {

    public static void main(String[] args) {
        AccountSynBlock a = new AccountSynBlock();
        a.DisplayBalance();//500
        DepositSynBlock d = new DepositSynBlock(a);//
        Withdraw1SynBlock w = new Withdraw1SynBlock(a);

        w.start();
        d.start();

    }

}

/*

************* ACCOUNT BALANCE *************
Account Current balance is::500
***************** WITHDRAW ****************
**************** DEPOSIT ******************
Withdrawn amount is::500
Deposited amount is::2000
Deposit Completely...Account Balance::2500
Withdraw Completed...Account Balance::2000


* */