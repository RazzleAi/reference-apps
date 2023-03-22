package razzle.ai.reference_apps.todos;

import org.springframework.stereotype.Component;
import razzle.ai.annotation.Action;
import razzle.ai.annotation.ActionParam;
import razzle.ai.api.widget.RazzleResponse;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * created by Julian Duru on 03/03/2023
 */
@Component
public class TodosHandler {


    private Map<String, Todo> todoMap = new HashMap<>();


    @Action(name = "addTodo", description = "Add a new Todo")
    public RazzleResponse addTodo(@ActionParam String title, @ActionParam String description) {
        var todo = Todo.builder()
            .id(String.valueOf(todoMap.size() + 1))
            .title(title)
            .description(description)
            .done(false)
            .build();

        todoMap.put(todo.getId(), todo);

        return RazzleResponse.text("Todo added successfully");
    }


    @Action(name = "getTodos", description = "Get all Todos")
    public RazzleResponse getTodos() {
        var columns = List.of("Id", "Title", "Description", "Done");

        var todos = todoMap.values();
        var data = todos.stream()
            .map(todo -> new String[] {
                todo.getId(),
                todo.getTitle(),
                todo.getDescription(),
                String.valueOf(todo.isDone())
            })
            .toArray(String[][]::new);

        return RazzleResponse.table(columns, data);
    }


    @Action(name = "markTodoAsDone", description = "Mark a Todo as done")
    public RazzleResponse markTodoAsDone(@ActionParam String id) {
        var todo = todoMap.get(id);
        if (todo == null) {
            return RazzleResponse.text("Todo not found");
        }

        todo.setDone(true);
        return RazzleResponse.text("Todo marked as done");
    }


    @Action(name = "deleteTodo", description = "Delete a Todo")
    public RazzleResponse deleteTodo(@ActionParam String id) {
        var todo = todoMap.get(id);
        if (todo == null) {
            return RazzleResponse.text("Todo not found");
        }

        todoMap.remove(id);
        return RazzleResponse.text("Todo deleted successfully");
    }


}


