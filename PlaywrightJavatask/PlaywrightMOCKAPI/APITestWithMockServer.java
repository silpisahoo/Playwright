package API;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.microsoft.playwright.APIRequest;
import com.microsoft.playwright.APIRequestContext;
import com.microsoft.playwright.APIResponse;
import com.microsoft.playwright.Playwright;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

public class APITestWithMockServer {
    Playwright playwright;
    APIRequestContext apiRequestContext;
    Map<String, String> headers;
    @BeforeClass
    public  void setup(){
        playwright = Playwright.create();
        headers = new HashMap<>();
    }

    @Test
    public void getCallWithDynamicRespTest() {
        apiRequestContext = playwright.request().newContext(new APIRequest.NewContextOptions()
                .setBaseURL("https://2aa08edc-409f-46ab-b3bf-1260b5622d88.mock.pstmn.io")
                .setExtraHTTPHeaders(headers));
        APIResponse resp = apiRequestContext.get("/getUsers");
        String response= resp.text();
        System.out.println("------"+response);

        JsonObject json = new Gson().fromJson(response,JsonObject.class);
        System.out.println(json.get("name"));
    }

    @AfterClass
    public  void  tearDown(){
        apiRequestContext.dispose();
       playwright.close();
    }

}
