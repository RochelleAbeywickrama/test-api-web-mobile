package api.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
@AllArgsConstructor
public class UserModel {

    public UserModel(){}

    private int id;
    private String email;
    private String name;
    private String gender;
    private String status;
}
