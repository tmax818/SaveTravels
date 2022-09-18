package tylermaxwell.savetravels.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import tylermaxwell.savetravels.models.Expense;
import tylermaxwell.savetravels.services.ExpenseService;

import javax.validation.Valid;
import java.util.List;

@Controller
public class ExpenseController {

    @Autowired
    ExpenseService service;

    @GetMapping("/expenses/new")
    public String newExpense(@ModelAttribute("expense")Expense expense){
        return "/expenses/new.jsp";
    }


    @GetMapping("/expenses")
    public String index(@ModelAttribute("expense") Expense expense, Model model){
        List<Expense> expenses = service.allExpenses();
        model.addAttribute("expenses", expenses);
        return "/expenses/index.jsp";
    }
    @PostMapping("/expenses")
    public String create(@Valid @ModelAttribute("expense") Expense expense, BindingResult result, Model model){
        if(result.hasErrors()){
            List<Expense> expenses = service.allExpenses();
            model.addAttribute("expenses", expenses);
            return "/expenses/index.jsp";
        } else {
            service.createExpense(expense);
            return "redirect:/expenses";
        }
    }


}
