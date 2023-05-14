package api.common;

import api.config.Config;

import java.util.TreeMap;

public class Constants {

    private Constants() {
    }

    public static final String BASE_URL = Config.getProperty("base.url");
    public static final String TOKEN = Config.getProperty("bearer.token");
    public static final String CREATE_USER = "/public/v2/users";
    public static final String CREATE_POST = "/public/v2/users/{userId}/posts";
    public static final String CREATE_COMMENT = "/public/v2/posts/{postId}/comments";
    public static final String CREATE_TODO = "/public/v2/users/{userId}/todos";
    public static final String GET_USER = "/public/v2/users/{userId}";
    public static final String GET_POST = "/public/v2/users/{userId}/posts";
    public static final String GET_COMMENT = "/public/v2/posts/{postId}/comments";
    public static final String GET_TODO = "/public/v2/users/{userId}/todos";

    //Data - User
    public static final String EMAIL = Config.getDataProperty("email");
    public static final String NAME = Config.getDataProperty("name");
    public static final String GENDER = Config.getDataProperty("gender");
    public static final String STATUS = Config.getDataProperty("status");

    //Data - Post
    public static final String POST_TITLE = Config.getDataProperty("postTitle");
    public static final String POST_BODY = Config.getDataProperty("postBody");

    //Data - Comment
    public static final String COMMENT_BODY = Config.getDataProperty("commentBody");

    //Data - To-do
    public static final String TODO_TITLE = Config.getDataProperty("todoTitle");
    public static final String TODO_DUEON = Config.getDataProperty("dueOn");
    public static final String TODO_STATUS = Config.getDataProperty("todoStatus");

    //Data - Error Validations
    public static final String EMAIL_EMPTY_ERROR = Config.getDataProperty("emailEmptyError");
    public static final String NAME_EMPTY_ERROR = Config.getDataProperty("nameEmptyError");
    public static final String GENDER_EMPTY_ERROR = Config.getDataProperty("genderEmptyError");
    public static final String STATUS_EMPTY_ERROR = Config.getDataProperty("statusEmptyError");
    public static final String TITLE_EMPTY_ERROR = Config.getDataProperty("titleEmptyError");
    public static final String BODY_EMPTY_ERROR = Config.getDataProperty("bodyEmptyError");
    public static final String EMAIL_INVALID_ERROR = Config.getDataProperty("emailInvalidError");
    public static final String STATUS_INVALID_ERROR = Config.getDataProperty("statusInvalidError");
    public static final String EMAIL_EXISTS_ERROR = Config.getDataProperty("emailExistError");
    public static final String EMAIL_FORMAT_ERROR = Config.getDataProperty("emailFormatError");

}
