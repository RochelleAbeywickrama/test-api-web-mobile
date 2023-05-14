package api.common;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

import static api.common.Constants.BASE_URL;
import static api.common.Constants.TOKEN;

public class SpecBuilder {

    public static RequestSpecification requestSpecificationBuilder() {
        RequestSpecification requestSpec = new RequestSpecBuilder()
                .setBaseUri(BASE_URL)
                .addHeader("Authorization", "Bearer " + TOKEN)
                .setAccept(ContentType.JSON)
                .build();
        return requestSpec;
    }

    public static RequestSpecification requestSpecificationBuilder(String url, String jsonBody) {
        RequestSpecification requestSpec = new RequestSpecBuilder()
                .setBaseUri(BASE_URL)
                .setBasePath(url)
                .addHeader("Authorization", "Bearer " + TOKEN)
                .setAccept(ContentType.JSON)
                .setBody(jsonBody)
                .build();
        return requestSpec;
    }

    public static RequestSpecification requestSpecificationBuilder(String url, String jsonBody, String pathParamName, String pathParam) {
        RequestSpecification requestSpec = new RequestSpecBuilder()
                .setBaseUri(BASE_URL)
                .setBasePath(url)
                .addHeader("Authorization", "Bearer " + TOKEN)
                .setAccept(ContentType.JSON)
                .setBody(jsonBody)
                .addPathParam(pathParamName, pathParam)
                .build();
        return requestSpec;
    }
}
