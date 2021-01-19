import static io.restassured.RestAssured.*;

import io.restassured.http.ContentType;
import org.hamcrest.Matcher;
import org.hamcrest.Matchers;

import java.time.LocalDateTime;
import java.util.*;

public class Main {

    static String uri = "https://api.trello.com";
    static String contentType = "application/json; charset=utf-8";
    static String boardID = "6005734abd10e9428f26a7eb";
    static String firstListID="60071ce018e31e63a291dd33";

    public static void main(String[] args) {
       Map<String, Object> map = new HashMap<>();
       initializeAPICard(map, firstListID);
       String cardForAPIID=given().baseUri(uri).queryParams(map).contentType(contentType)
               .when().post("/1/cards")
               .then().statusCode(200).extract().path("id");

       map.put("name", "CardForDelete");
       String cardForDeleteID=given().baseUri(uri).queryParams(map).contentType(contentType)
                .when().post("/1/cards")
                .then().statusCode(200).extract().path("id");

       Map<String, Object> updateMap = new HashMap<>();
       initializeUpdateMap(updateMap);
       given().baseUri(uri).queryParams(updateMap).contentType(contentType)
               .when().put("/1/cards/{id}", cardForAPIID)
               .then().statusCode(200);

       Map<String, Object> listMap = new HashMap<>();
       initializeListMap(listMap, boardID);
       String apiListID = given().baseUri(uri).queryParams(listMap).contentType(contentType)
               .when().post("/1/lists")
               .then().statusCode(200).extract().path("id");

       updateMap.put("idList", apiListID);
       given().baseUri(uri).queryParams(updateMap).contentType(contentType)
               .when().put("/1/cards/{id}", cardForAPIID)
               .then().statusCode(200);

       Map<String, Object> deleteCardMap = new HashMap<>();
       deleteCardMap.put("key", Tokens.key);
       deleteCardMap.put("token", Tokens.token);
       given().baseUri(uri).queryParams(deleteCardMap).contentType(contentType)
                .when().delete("/1/cards/{id}", cardForDeleteID)
                .then().statusCode(200);
    }

    static void initializeAPICard(Map<String, Object> map, String list) {
        map.put("key", Tokens.key);
        map.put("token", Tokens.token);
        map.put("name", "CardForAPI");
        map.put("idList", list);
    }

    static void initializeUpdateMap(Map<String, Object> map) {
        map.put("key", Tokens.key);
        map.put("token", Tokens.token);
        map.put("desc", "Nu eto samoe, vot tak vot");
    }

    static  void initializeListMap(Map<String, Object> map, String boardID) {
        map.put("key", Tokens.key);
        map.put("token", Tokens.token);
        map.put("name", "ApiList");
        map.put("idBoard", boardID);
    }
}
