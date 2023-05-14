package api.functions;

import api.common.CommonApi;
import api.common.SpecBuilder;
import api.model.CommentModel;
import api.model.PostModel;
import api.model.TodoModel;
import api.model.UserModel;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

import static api.common.Constants.*;

public class GoRestService {

    public static UserModel createUser(int statusCode, String jsonBody){
        RequestSpecification specification = SpecBuilder
                .requestSpecificationBuilder(CREATE_USER, jsonBody);
        return CommonApi.post(specification)
                .then()
                .statusCode(statusCode)
                .extract()
                .response()
                .as(UserModel.class);
    }

    public static PostModel createPost(int statusCode, String jsonBody, String userId){
        RequestSpecification specification = SpecBuilder
                .requestSpecificationBuilder(CREATE_POST, jsonBody, "userId", userId);
        return CommonApi.post(specification)
                .then()
                .statusCode(statusCode)
                .extract()
                .response()
                .as(PostModel.class);
    }

    public static CommentModel createComment(int statusCode, String jsonBody, String postId){
        RequestSpecification specification = SpecBuilder
                .requestSpecificationBuilder(CREATE_COMMENT, jsonBody, "postId", postId);
        return CommonApi.post(specification)
                .then()
                .statusCode(statusCode)
                .extract()
                .response()
                .as(CommentModel.class);
    }

    public static TodoModel createTodo(int statusCode, String jsonBody, String userId){
        RequestSpecification specification = SpecBuilder
                .requestSpecificationBuilder(CREATE_TODO, jsonBody, "userId", userId);
        return CommonApi.post(specification)
                .then()
                .statusCode(statusCode)
                .extract()
                .response()
                .as(TodoModel.class);
    }


    public static JsonPath createRequestWithMissingFields(String url, int statusCode, String jsonBody){
        RequestSpecification specification = SpecBuilder
                .requestSpecificationBuilder(url, jsonBody);
        return CommonApi.post(specification)
                .then()
                .statusCode(statusCode)
                .extract()
                .body()
                .jsonPath();
    }

    public static JsonPath createRequestWithMissingFieldsWithPathParam(String url, int statusCode, String jsonBody, String pathParam, String paramValue){
        RequestSpecification specification = SpecBuilder
                .requestSpecificationBuilder(url, jsonBody, pathParam, paramValue);
        return CommonApi.post(specification)
                .then()
                .statusCode(statusCode)
                .extract()
                .body()
                .jsonPath();
    }

    public static JsonPath createCommonRequest(String url, int statusCode, String jsonBody, String pathParam, String paramValue){
        RequestSpecification specification;
        if(pathParam.isEmpty()){
            specification = SpecBuilder
                    .requestSpecificationBuilder(url, jsonBody);
        }else{
            specification = SpecBuilder
                    .requestSpecificationBuilder(url, jsonBody, pathParam, paramValue);
        }
        return CommonApi.post(specification)
                .then()
                .statusCode(statusCode)
                .extract()
                .body()
                .jsonPath();
    }

    public static ValidatableResponse deleteUser(int statusCode, int id){
        RequestSpecification specification = SpecBuilder
                .requestSpecificationBuilder(GET_USER, "", "userId", String.valueOf(id));
        return CommonApi.delete(specification)
                .then()
                .statusCode(statusCode);
    }
}
