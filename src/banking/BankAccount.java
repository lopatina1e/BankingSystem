package banking;

public class BankAccount {

    long id;
    String ownerName;
    String currency;
    private double balance;
    static int totalAccounts = 0;

    BankAccount(String ownerName, String currency, double initialAmount) {
        totalAccounts++;
        id=totalAccounts;
        this.ownerName = ownerName;
        this.currency = currency;
        this.balance = initialAmount;
    }
    
    BankAccount(String ownerName, String currency) {
        this(ownerName, currency, 0);
    }

    void deposit(double amount) {
        balance += amount;
        System.out.println("Пополнено: " + amount + " " + currency + ". Текущий баланс: " + balance);
    }

    void withdraw(double amount) {
        if (amount > balance) {
            System.out.println("❌ Ошибка: Недостаточно средств! Вы пытаетесь снять " + amount + ", а на счете " + balance);
        }
        else {
            balance -= amount;
            System.out.println("✅ Снято: " + amount + " " + currency + ". Остаток: " + balance);
        }
    }

    public double getBalance() {
        return balance;
    }

    void showInfo() {
        System.out.println("Счет №" + id + ", Владелец: " + ownerName + ", Баланс: " + balance + " " + currency);
    }
}
class BankTest {
    public static void main(String[] args) {
BankAccount myAccount = new BankAccount("Alena", "USD", 100);
    myAccount.showInfo();

    BankAccount secondAccount = new BankAccount("Ivan", "EUR", 500);
    secondAccount.showInfo();
    
    System.out.println("Всего клиентов в банке: " + BankAccount.totalAccounts);
    }
}