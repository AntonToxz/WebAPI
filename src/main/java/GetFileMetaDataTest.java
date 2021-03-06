import com.jayway.restassured.RestAssured;
import com.jayway.restassured.response.Response;
import org.json.JSONObject;
import org.testng.annotations.Test;

import java.awt.image.Kernel;
import java.io.File;

public class GetFileMetaDataTest {
    private final String token = "T_HHsYQ_bv4AAAAAAAAAAU2mw48OB2EfjFEEm-vlkcdUi1nGt3ygT9AvP-GNKSGT";

    @Test
    public void getMetaDataTest() {
        String filename = "FeelsDankMan.png";
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("path", "/test/" + filename);

        Response response = RestAssured.given()
                .header("Authorization", "Bearer " + token)
                .contentType("application/json")
                .body(jsonObject.toString())
                .post("https://api.dropboxapi.com/2/files/get_metadata")
                .thenReturn();

        response.prettyPeek();
    }
}
