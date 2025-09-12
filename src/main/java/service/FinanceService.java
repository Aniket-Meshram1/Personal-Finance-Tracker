package service;

import dao.ExpenseDAO;
import dao.IncomeDAO;
import model.Expense;
import model.Income;

import java.util.List;

public class FinanceService {
    private ExpenseDAO expenseDAO = new ExpenseDAO();
    private IncomeDAO incomeDAO = new IncomeDAO();

    public void addExpense(Expense expense) {
        expenseDAO.addExpense(expense);
    }

    public void addIncome(Income income) {
        incomeDAO.addIncome(income);
    }

    public double calculateBalance(int userId) {
        double totalIncome = incomeDAO.getIncomesByUser(userId).stream()
                .mapToDouble(Income::getAmount).sum();
        double totalExpense = expenseDAO.getExpensesByUser(userId).stream()
                .mapToDouble(Expense::getAmount).sum();
        return totalIncome - totalExpense;
    }

    public List<Expense> getExpenses(int userId) {
        return expenseDAO.getExpensesByUser(userId);
    }

    public List<Income> getIncomes(int userId) {
        return incomeDAO.getIncomesByUser(userId);
    }
}
