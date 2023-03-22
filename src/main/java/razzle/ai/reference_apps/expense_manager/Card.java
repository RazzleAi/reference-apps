package razzle.ai.reference_apps.expense_manager;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * created by Julian Duru on 04/03/2023
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Card {


    private String id;

    private String employeeId;

    private String cardNumber;

    private boolean active;


}
