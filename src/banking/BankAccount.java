package banking;

public class BankAccount {

    long id;
    String ownerName;
    String currency;
    private double balance;

    BankAccount(long id, String ownerName, String currency) {
        this.id = id;
        this.ownerName = ownerName;
        this.currency = currency;
        this.balance = 0;
    }

    // Конструктор 2: С начальной суммой
    BankAccount(long id, String ownerName, String currency, double initialAmount) {
        this.id = id;
        this.ownerName = ownerName;
        this.currency = currency;
        this.balance = initialAmount;
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
        BankAccount myAccount = new BankAccount(1, "Alena", "USD", 100);

        myAccount.showInfo();
        myAccount.withdraw(50);
        myAccount.withdraw(1000);
        myAccount.showInfo();
    }
}