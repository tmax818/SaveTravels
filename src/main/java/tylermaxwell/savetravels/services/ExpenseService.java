package tylermaxwell.savetravels.services;


import org.springframework.stereotype.Service;
import tylermaxwell.savetravels.models.Expense;
import tylermaxwell.savetravels.repositories.ExpenseRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ExpenseService {

    private final ExpenseRepository repo;

    public ExpenseService(ExpenseRepository repo){this.repo = repo;}

    // CREATE: create an expense
    public Expense createExpense(Expense expense){return repo.save(expense);}

    // READ ALL: return all expenses:

    public List<Expense> allExpenses(){return repo.findAll();}

    // READ ONE: retrieve one expense
    public Expense findExpense(Long id){
        Optional<Expense> optionalExpense = repo.findById(id);
        return optionalExpense.orElse(null);
    }
}
