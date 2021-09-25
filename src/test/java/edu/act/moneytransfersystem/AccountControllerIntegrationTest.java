package edu.act.moneytransfersystem;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@SpringBootTest
@RunWith(SpringRunner.class)
@AutoConfigureTestDatabase
@AutoConfigureMockMvc

public class AccountControllerIntegrationTest {

    private final String ACCOUNT_ENDPOINT = "/api/account/create";

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void shouldCreateAnAccountWithValidInformation() throws Exception {

        String payload = "{\n" +
                "\"firstName\": \"Abaue\",\n" +
                "  \"middleName\": \"Debasu\",\n" +
                "  \"lastName\":  \"Africa\",\n" +
                "  \"phoneNumber\": \"+2519253545791\",\n" +
                "  \"email\": \"abhghce@gmail.com\",\n" +
                "  \"dateOfBirth\": \"2000-05-02\",\n" +
                "  \"pin\": 2554\n" +
                "}";
        mockMvc.perform(
                post(ACCOUNT_ENDPOINT)
                        .contentType("application/json")
                        .content(payload)
        )
                .andDo(print())
                .andExpect(status().is(200))
                .andExpect(content().json("{\"id\":1,\"firstName\":\"Abaue\",\"middleName\":\"Debasu\",\"lastName\":\"Africa\",\"email\":\"abhghce@gmail.com\",\"phoneNumber\":\"+2519253545791\",\"dateOfBirth\":\"2000-05-02\",\"pin\":2554,\"isVerified\":true,\"balance\":0.0}"))
                .andExpect(content().contentType("application/json"));

    }
}
