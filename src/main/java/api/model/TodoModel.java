package api.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
@AllArgsConstructor
public class TodoModel {
    public TodoModel(){}

    private int id;
    private int user_id;
    private String title;
    private String due_on;
    private String status;
}
