package org.tracker;

import dao.UserDAO;
import model.Expense;
import model.Income;
import model.User;
import service.FinanceService;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static Scanner scanner = new Scanner(System.in);
    private static UserDAO userDAO = new UserDAO();
    private static FinanceService financeService = new FinanceService();
    private static User currentUser;

    public static void main(String[] args) {
        while (true) {
            System.out.println("\n==== Personal Finance Tracker ====");
            if (currentUser == null) {
                System.out.println("1. Register");
                System.out.println("2. Login");
                System.out.println("0. Exit");
                int choice = scanner.nextInt();
                scanner.nextLine();

                switch (choice) {
                    case 1 -> register();
                    case 2 -> login();
                    case 0 -> System.exit(0);
                    default -> System.out.println("Invalid choice.");
                }
            } else {
                System.out.println("\nWelcome, " + currentUser.getUsername());
                System.out.println("1. Add Income");
                System.out.println("2. Add Expense");
                System.out.println("3. View Balance");
                System.out.println("4. View Incomes");
                System.out.println("5. View Expenses");
                System.out.println("6. Logout");
                int choice = scanner.nextInt();
                scanner.nextLine();

                switch (choice) {
                    case 1 -> addIncome();
                    case 2 -> addExpense();
                    case 3 -> viewBalance();
                    case 4 -> viewIncomes();
                    case 5 -> viewExpenses();
                    case 6 -> currentUser = null;
                    default -> System.out.println("Invalid choice.");
                }
            }
        }
    }

    private static void register() {
        System.out.print("Enter username: ");
        String username = scanner.nextLine();
        System.out.print("Enter password: ");
        String password = scanner.nextLine();

        User user = new User(username, password);
        userDAO.registerUser(user);
        System.out.println("Registration successful!");
    }

    private static void login() {
        System.out.print("Enter username: ");
        String username = scanner.nextLine();
        System.out.print("Enter password: ");
        String password = scanner.nextLine();

        currentUser = userDAO.login(username, password);
        if (currentUser != null) {
            System.out.println("Login successful!");
        } else {
            System.out.println("Invalid credentials.");
        }
    }

    private static void addIncome() {
        System.out.print("Enter amount: ");
        double amount = scanner.nextDouble();
        scanner.nextLine();
        System.out.print("Enter category: ");
        String category = scanner.nextLine();

        Income income = new Income(currentUser.getUserId(), amount, category, LocalDate.now());
        financeService.addIncome(income);
        System.out.println("Income added!");
    }

    private static void addExpense() {
        System.out.print("Enter amount: ");
        double amount = scanner.nextDouble();
        scanner.nextLine();
        System.out.print("Enter category: ");
        String category = scanner.nextLine();

        Expense expense = new Expense(currentUser.getUserId(), amount, category, LocalDate.now());
        financeService.addExpense(expense);
        System.out.println("Expense added!");
    }

    private static void viewBalance() {
        double balance = financeService.calculateBalance(currentUser.getUserId());
        System.out.println("Your current balance: $" + balance);
    }

    private static void viewIncomes() {
        List<Income> incomes = financeService.getIncomes(currentUser.getUserId());
        System.out.println("\n--- Incomes ---");
        incomes.forEach(i -> System.out.println(i.getDate() + " | " + i.getCategory() + " | $" + i.getAmount()));
    }

    private static void viewExpenses() {
        List<Expense> expenses = financeService.getExpenses(currentUser.getUserId());
        System.out.println("\n--- Expenses ---");
        expenses.forEach(e -> System.out.println(e.getDate() + " | " + e.getCategory() + " | $" + e.getAmount()));
    }
}
