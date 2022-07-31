package pay2park.controller.login;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import net.minidev.json.JSONObject;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import pay2park.IntegrationTest;
import pay2park.model.ResponseObject;
import pay2park.model.login.EndUserLoginData;
import pay2park.service.login.EndUserLoginService;

import static org.junit.jupiter.api.Assertions.assertEquals;

@IntegrationTest
@AutoConfigureMockMvc
@Timeout(3)
class EndUserLoginControllerTest {
    private ObjectMapper mapper;
    @Autowired
    MockMvc mockMvc;
    @Autowired
    private EndUserLoginService loginService;

    @BeforeEach
    void setUp() {
        mapper = new ObjectMapper();
    }

    @Test
    void loginTest() {
        // GIVEN
        String zalopayID = "93jfkd092f2fs4";
        EndUserLoginData req = new EndUserLoginData(zalopayID);
        ResponseObject expectedRes = loginService.login(req);

        JSONObject expected = new JSONObject();
        expected.put("status", expectedRes.getStatus());
        expected.put("message", expectedRes.getMessage());
        expected.put("data", expectedRes.getData());

        // WHEN
        String actual;
        try {
            actual = mockMvc.perform( MockMvcRequestBuilders
                            .get("/api/loginenduser?zlpId=" + zalopayID)
                            .contentType(MediaType.APPLICATION_JSON)
                            .accept(MediaType.APPLICATION_JSON))
                    .andReturn().getResponse().getContentAsString();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        // THEN
        try {
            assertEquals(mapper.readTree(String.valueOf(expected)), mapper.readTree(actual));
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}