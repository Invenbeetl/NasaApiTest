package util;

import static com.jayway.restassured.RestAssured.get;

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
