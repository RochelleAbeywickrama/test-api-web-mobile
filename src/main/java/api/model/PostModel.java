package api.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
@AllArgsConstructor
public class PostModel {
    public PostModel(){}
    private int id;
    private int user_id;
    private String title;
    private String body;
}
