package razzle.ai.reference_apps.expense_manager;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import razzle.ai.annotation.Action;
import razzle.ai.api.widget.RazzleResponse;

/**
 * created by Julian Duru on 04/03/2023
 */
@Component
@RequiredArgsConstructor
public class ExpenseManagerHandler {


    private final ExpenseManagerService expenseManagerService;


//    @Action(
//        name = "getCompanies",
//        description = "Get all companies"
//    )
//    public RazzleResponse getCompanies() {
//
//    }


}
