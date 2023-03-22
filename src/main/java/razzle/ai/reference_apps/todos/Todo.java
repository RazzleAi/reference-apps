package razzle.ai.reference_apps.todos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * created by Julian Duru on 03/03/2023
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Todo {


    private String id;

    private String title;

    private String description;

    private boolean done;


}
