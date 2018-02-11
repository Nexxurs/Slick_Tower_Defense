package Singletons;

public class Bank {
    private static Bank ourInstance = new Bank();

    public static Bank getInstance() {
        return ourInstance;
    }

    private float balance = 0;

    private Bank() {
    }

    public void addMoney(float money){
        balance += money;
    }

    public void delMoney(float money){
        balance-=money;
    }

    public float getBalance() {
        return balance;
    }
}
