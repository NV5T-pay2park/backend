package pay2park.controller.login;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import net.minidev.json.JSONObject;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import pay2park.model.ResponseObject;
import pay2park.model.login.EndUserLoginData;
import pay2park.service.login.EndUserLoginService;

import static java.lang.Thread.sleep;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@Timeout(3)
class EndUserLoginControllerTest {
    private ObjectMapper mapper;
    @LocalServerPort
    private int localServerPort;
    @Autowired
    private EndUserLoginService loginService;

    @Autowired
    private TestRestTemplate testRestTemplate;

    @BeforeEach
    void setUp() {
        mapper = new ObjectMapper();
    }

    @Test
    void catchNewLoginEndUser() {
        // GIVEN
        String zalopayID = "93jfkd092f2fs4";
        EndUserLoginData req = new EndUserLoginData(zalopayID);
        ResponseObject expectedRes = loginService.login(req);

        JSONObject expectedResJson = new JSONObject();
        expectedResJson.put("status", expectedRes.getStatus());
        expectedResJson.put("message", expectedRes.getMessage());
        expectedResJson.put("data", expectedRes.getData());

        // WHEN
        JSONObject res = testRestTemplate.getForObject("http://localhost:" + localServerPort +
                "/api/loginenduser?zlpId=" + zalopayID, JSONObject.class);

        // THEN
        try {
            assertEquals(mapper.readTree(String.valueOf(expectedResJson)), mapper.readTree(String.valueOf(res)));
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}