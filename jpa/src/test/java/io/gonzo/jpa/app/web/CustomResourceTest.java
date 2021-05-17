package io.gonzo.jpa.app.web;

import io.gonzo.jpa.app.service.CustomService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.client.RestClientTest;
import org.springframework.test.web.client.MockRestServiceServer;

import static org.springframework.test.web.client.match.MockRestRequestMatchers.requestTo;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;


@RestClientTest(CustomService.class)
class CustomResourceTest {

    @Autowired
    private MockRestServiceServer server;

    @Test
    @DisplayName("모든 데이터 보기")
    public void showByAll() throws Exception {
        server.expect(requestTo("/api/web/custom"));
    }

}
