package pay2park.controller.login;

import net.minidev.json.JSONObject;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import pay2park.model.login.MerchantEmployeeRequestLoginData;
import pay2park.service.login.MerchantEmployeeLoginService;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

//@SpringBootApplication
//@RunWith(SpringRunner.class)
//@SpringBootTest(classes = MerchantEmployeeLoginController.class)
@WebMvcTest(MerchantEmployeeLoginController.class)
@ContextConfiguration(locations = "/test-context.xml")
@Timeout(3)
class MerchantEmployeeLoginControllerTest {
    @Autowired
    @Qualifier("merchantEmployeeLoginService")
    private MerchantEmployeeLoginService loginService;
    @Autowired
    MockMvc mockMvc;


    @Test
    public void loginTest() throws Exception {
        MerchantEmployeeRequestLoginData req =
                new MerchantEmployeeRequestLoginData("0987654321", "tienthanh", "12345678");
        JSONObject reqJson = new JSONObject();
        reqJson.put("phone", req.getPhone());
        reqJson.put("userName", req.getUserName());
        reqJson.put("password", req.getPassword());
        mockMvc.perform( MockMvcRequestBuilders
                        .post("/api/loginmerchant/")
                        .content(String.valueOf(reqJson))
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated())
                .andExpect(MockMvcResultMatchers.jsonPath("$.phone").exists());
    }
    /*
    private ObjectMapper mapper;
    @LocalServerPort
    private int localServerPort;
    @Autowired
    private MerchantEmployeeLoginService loginService;
    @Autowired
    private TestRestTemplate testRestTemplate;
    private MockMvc mockMvc;
    @Autowired
    private WebApplicationContext webApplicationContext;
    @Mock
    private MerchantEmployeeLoginService loginService;

    @BeforeEach
    public void setUp() throws Exception {
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }

    @Test
    public void givenWac_whenServletContext_thenItProvidesGreetController() {
        ServletContext servletContext = webApplicationContext.getServletContext();

        assertNotNull(servletContext);
        assertTrue(servletContext instanceof MockServletContext);
        assertNotNull(webApplicationContext.getBean("greetController"));
    }

    /*@Test
    void temp() {
        // GIVEN
        MerchantEmployeeRequestLoginData req =
                new MerchantEmployeeRequestLoginData("0987654321", "tienthanh", "12345678");
        JSONObject reqJson = new JSONObject();
        reqJson.put("phone", req.getPhone());
        reqJson.put("userName", req.getUserName());
        reqJson.put("password", req.getPassword());

        // WHEN
        mvc.perform(post("api/loginmerchant"))
                .andExpect(HttpStatus.OK)
                .andExpect(content().string("hello"));
        RequestBuilder request = MockMvcRequestBuilders
                .post("/api/loginmerchant")
                .accept(MediaType.APPLICATION_JSON)
                .content(String.valueOf(reqJson))
                .contentType(MediaType.APPLICATION_JSON);

        try {
            MvcResult result = mvc.perform(request)
                    .andExpect(status().isOk()).andReturn();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    void catchNewLoginMerchant() {
        // GIVEN
        MerchantEmployeeRequestLoginData req =
                new MerchantEmployeeRequestLoginData("0987654321", "tienthanh", "12345678");
        JSONObject reqJson = new JSONObject();
        reqJson.put("phone", req.getPhone());
        reqJson.put("userName", req.getUserName());
        reqJson.put("password", req.getPassword());

        ResponseObject expectedRes = loginService.login(req);
        JSONObject expectedResJson = new JSONObject();
        expectedResJson.put("status", expectedRes.getStatus());
        expectedResJson.put("message", expectedRes.getMessage());
        expectedResJson.put("data", expectedRes.getData());

        // WHEN
        RequestBuilder requestBuilder = MockMvcRequestBuilders
                .post("http://localhost:" + localServerPort + "/api/loginmerchant/")
                .accept(MediaType.APPLICATION_JSON)
                .content(String.valueOf(reqJson))
                .contentType(MediaType.APPLICATION_JSON);

        MvcResult res;
        try {
            res = mvc.perform(requestBuilder).andReturn();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        System.out.println(res);

        // THEN
        try {
            assertEquals(mapper.readTree(String.valueOf(expectedResJson)), mapper.readTree(String.valueOf(res)));
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }*/
}