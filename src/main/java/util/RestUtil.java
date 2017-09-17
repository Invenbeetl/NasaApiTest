package util;

import static com.jayway.restassured.RestAssured.get;
import static com.jayway.restassured.RestAssured.given;

public class RestUtil {

    public static String sendGetRequest(String url) {
        return get(url)
                .then()
                    .statusCode(200)
                    .extract()
                    .body()
                    .asString();
    }
}
