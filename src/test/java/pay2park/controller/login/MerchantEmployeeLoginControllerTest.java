//package pay2park.controller.login;
//
//import com.fasterxml.jackson.databind.ObjectMapper;
//import net.minidev.json.JSONObject;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.Timeout;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
//import org.springframework.http.MediaType;
//import org.springframework.test.web.servlet.MockMvc;
//import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
//import pay2park.IntegrationTest;
//import pay2park.model.ResponseObject;
//import pay2park.model.login.MerchantEmployeeRequestLoginData;
//import pay2park.service.login.MerchantEmployeeLoginService;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//
//
//@IntegrationTest
//@AutoConfigureMockMvc
//@Timeout(3)
//class MerchantEmployeeLoginControllerTest {
//    private ObjectMapper mapper;
//    @Autowired
//    private MerchantEmployeeLoginService loginService;
//    @Autowired
//    MockMvc mockMvc;
//
//    @BeforeEach
//    void setUp() {
//        mapper = new ObjectMapper();
//    }
//    @Test
//    public void loginTest() throws Exception {
//        // GIVEN
//        MerchantEmployeeRequestLoginData req =
//                new MerchantEmployeeRequestLoginData("0987654321", "tienthanh", "12345678");
//        JSONObject reqJson = new JSONObject();
//        reqJson.put("phone", req.getPhone());
//        reqJson.put("userName", req.getUserName());
//        reqJson.put("password", req.getPassword());
//
//        ResponseObject expectedRes = loginService.login(req);
//        JSONObject expected = new JSONObject();
//        expected.put("status", expectedRes.getStatus());
//        expected.put("message", expectedRes.getMessage());
//        expected.put("data", expectedRes.getData());
//
//        // WHEN
//        String res = mockMvc.perform( MockMvcRequestBuilders
//                .post("/api/loginmerchant/")
//                .content(String.valueOf(reqJson))
//                .contentType(MediaType.APPLICATION_JSON)
//                .accept(MediaType.APPLICATION_JSON))
//            .andReturn().getResponse().getContentAsString();
//
//        // THEN
//        assertEquals(mapper.readTree(String.valueOf(expected)), mapper.readTree(res));
//    }
//}