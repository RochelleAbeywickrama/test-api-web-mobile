package api.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
@AllArgsConstructor
public class CommentModel {
    public CommentModel(){}
    private int id;
    private int post_id;
    private String name;
    private String email;
    private String body;
}
