package tests.api;

import api.functions.GoRestService;
import api.model.CommentModel;
import api.model.PostModel;
import api.model.TodoModel;
import api.model.UserModel;
import api.utils.Helper;
import com.fasterxml.jackson.core.JsonProcessingException;
import io.qameta.allure.Feature;
import io.restassured.path.json.JsonPath;
import org.apache.http.HttpStatus;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import static api.common.Constants.*;
import static api.common.Constants.EMAIL;

@Feature("GoRest API")
public class Test_GoRestAPI {

    public static int userId;
    public static int postId;
    public static String USER_EMAIL = Helper.generateRandomNumber() + EMAIL;

    @Test(priority = 1, description = "Create a new user using POST request")
    public static void tc01_ValidateCreateNewUser() throws JsonProcessingException {

        String jsonBody = Helper.getObjectMapper(UserModel.builder()
                .email(USER_EMAIL)
                .name(NAME)
                .gender(GENDER)
                .status(STATUS)
                .build());
        UserModel model = GoRestService.createUser(HttpStatus.SC_CREATED, jsonBody);
        userId = model.getId();
        Assert.assertEquals(model.getEmail(), USER_EMAIL);
        Assert.assertEquals(model.getName(), NAME);
        Assert.assertEquals(model.getGender(), GENDER);
        Assert.assertEquals(model.getStatus(), STATUS);
    }

    @Test(priority = 2, description = "Create a new post using POST request")
    public static void tc02_ValidateCreateNewPost() throws JsonProcessingException {

        String jsonBody = Helper.getObjectMapper(PostModel.builder()
                .title(POST_TITLE)
                .body(POST_BODY)
                .build());
        PostModel model = GoRestService.createPost(HttpStatus.SC_CREATED, jsonBody, String.valueOf(userId));
        postId = model.getId();
        Assert.assertEquals(model.getUser_id(), userId);
        Assert.assertEquals(model.getTitle(), POST_TITLE);
        Assert.assertEquals(model.getBody(), POST_BODY);
    }


    @Test(priority = 3, description = "Create a new comment using POST request")
    public static void tc03_ValidateCreateNewComment() throws JsonProcessingException {

        String jsonBody = Helper.getObjectMapper(CommentModel.builder()
                .name(NAME)
                .email(USER_EMAIL)
                .body(COMMENT_BODY)
                .build());

        CommentModel model = GoRestService.createComment(HttpStatus.SC_CREATED, jsonBody, String.valueOf(postId));
        Assert.assertNotNull(model.getId());
        Assert.assertEquals(model.getPost_id(), postId);
        Assert.assertEquals(model.getName(), NAME);
        Assert.assertEquals(model.getEmail(), USER_EMAIL);
        Assert.assertEquals(model.getBody(), COMMENT_BODY);
    }

    @Test(priority = 4, description = "Create a new todo using POST request")
    public static void tc04_ValidateCreateNewTodo() throws JsonProcessingException {

        String jsonBody = Helper.getObjectMapper(TodoModel.builder()
                .title(TODO_TITLE)
                .due_on(TODO_DUEON)
                .status(TODO_STATUS)
                .build());
        TodoModel model = GoRestService.createTodo(HttpStatus.SC_CREATED, jsonBody, String.valueOf(userId));
        Assert.assertNotNull(model.getId());
        Assert.assertEquals(model.getUser_id(), userId);
        Assert.assertEquals(model.getTitle(), TODO_TITLE);
        Assert.assertEquals(model.getDue_on(), TODO_DUEON);
        Assert.assertEquals(model.getStatus(), TODO_STATUS);
    }

    @Test(priority = 5, description = "Create a new user using POST request without a mandatory field")
    public static void tc05_ValidateCreateNewUserWithMissingFields() throws JsonProcessingException {

        String jsonBody = Helper.getObjectMapper(UserModel.builder()
                .email("")
                .name("")
                .gender("")
                .status("")
                .build());
        JsonPath response = GoRestService.createRequestWithMissingFields(CREATE_USER, HttpStatus.SC_UNPROCESSABLE_ENTITY, jsonBody);
        Assert.assertEquals(response.get("[0].message"), EMAIL_EMPTY_ERROR);
        Assert.assertEquals(response.get("[1].message"), NAME_EMPTY_ERROR);
        Assert.assertEquals(response.get("[2].message"), GENDER_EMPTY_ERROR);
        Assert.assertEquals(response.get("[3].message"), STATUS_EMPTY_ERROR);
    }

    @Test(priority = 6, description = "Create a new post using POST request without a mandatory field")
    public static void tc06_ValidateCreateNewPostWithMissingFields() throws JsonProcessingException {

        String jsonBody = Helper.getObjectMapper(PostModel.builder()
                .title("")
                .body("")
                .build());
        JsonPath response = GoRestService.createRequestWithMissingFieldsWithPathParam(CREATE_POST, HttpStatus.SC_UNPROCESSABLE_ENTITY, jsonBody, "userId", String.valueOf(userId));
        Assert.assertEquals(response.get("[0].message"), TITLE_EMPTY_ERROR);
        Assert.assertEquals(response.get("[1].message"), BODY_EMPTY_ERROR);
    }


    @Test(priority = 7, description = "Create a new comment using POST request without a mandatory field")
    public static void tc07_ValidateCreateNewCommentWithMissingFields() throws JsonProcessingException {

        String jsonBody = Helper.getObjectMapper(CommentModel.builder()
                .name("")
                .email("")
                .body("")
                .build());
        JsonPath response = GoRestService.createRequestWithMissingFieldsWithPathParam(CREATE_COMMENT, HttpStatus.SC_UNPROCESSABLE_ENTITY, jsonBody, "postId", String.valueOf(postId));
        Assert.assertEquals(response.get("[0].message"), NAME_EMPTY_ERROR);
        Assert.assertEquals(response.get("[1].message"), EMAIL_INVALID_ERROR);
        Assert.assertEquals(response.get("[2].message"), BODY_EMPTY_ERROR);
    }

    @Test(priority = 8, description = "Create a new todo using POST request without a mandatory field")
    public static void tc08_ValidateCreateNewTodoWithMissingFields() throws JsonProcessingException {

        String jsonBody = Helper.getObjectMapper(TodoModel.builder()
                .title("")
                .due_on("")
                .status("")
                .build());
        JsonPath response = GoRestService.createRequestWithMissingFieldsWithPathParam(CREATE_TODO, HttpStatus.SC_UNPROCESSABLE_ENTITY, jsonBody, "userId", String.valueOf(userId));
        Assert.assertEquals(response.get("[0].message"), TITLE_EMPTY_ERROR);
        Assert.assertEquals(response.get("[1].message"), STATUS_INVALID_ERROR);
    }

    @Test(priority = 9, description = "Validate creation of two users with the same email address")
    public static void tc09_ValidateCreateNewUserWithExistingUserEmail() throws JsonProcessingException {

        String jsonBody = Helper.getObjectMapper(UserModel.builder()
                .email(USER_EMAIL)
                .name(NAME)
                .gender(GENDER)
                .status(STATUS)
                .build());
        JsonPath response = GoRestService.createCommonRequest(CREATE_USER, HttpStatus.SC_UNPROCESSABLE_ENTITY, jsonBody, "","");
        Assert.assertEquals(response.get("[0].message"), EMAIL_EXISTS_ERROR);
    }

    @Test(priority = 10, description = "Validate creation of new entries with invalid email address formats")
    public static void tc10_ValidateCreateNewUserWithInvalidEmailFormat() throws JsonProcessingException {

        String invalidEmail = "testemail.com";
        String jsonBody = Helper.getObjectMapper(UserModel.builder()
                .email(invalidEmail)
                .name(NAME)
                .gender(GENDER)
                .status(STATUS)
                .build());
        JsonPath response = GoRestService.createCommonRequest(CREATE_USER, HttpStatus.SC_UNPROCESSABLE_ENTITY, jsonBody, "","");
        Assert.assertEquals(response.get("[0].message"), EMAIL_FORMAT_ERROR);

    }

    @AfterTest
    public void deleteUser() {
        GoRestService.deleteUser(HttpStatus.SC_NO_CONTENT, userId);
    }
}
