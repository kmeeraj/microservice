package com.teradata.training.orderservice.resource;

import com.teradata.training.orderservice.model.Order;
import com.teradata.training.orderservice.service.OrderService;
import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.client.MockRestServiceServer;
import org.springframework.web.client.RestTemplate;

import static org.junit.Assert.*;

import static org.springframework.test.web.client.match.MockRestRequestMatchers.method;
import static org.springframework.test.web.client.response.MockRestResponseCreators.withSuccess;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.requestTo;

@SpringBootTest
@RunWith(SpringRunner.class)
public class OrderResourceTest {

    @Autowired
    RestTemplate restTemplate;

    @Autowired
    OrderService orderService;

    MockRestServiceServer mockRestServiceServer;

    @Before
    public void setup(){
        mockRestServiceServer = MockRestServiceServer.createServer(restTemplate);
    }


    @Test
    public void shouldSaveOrder(){
        Order order = Order.builder()
                .id(1)
                .productDetail(Order.ProductDetail.builder()
                        .code(2)
                        .name("Samsung S10")
                        .description("Samsung S10+ Amoled Screen")
                        .build())
                .userId("3")
                .build();

        mockRestServiceServer.expect(requestTo("http://localhost:8081/inventory?id=" + order.getProductDetail().getCode()))
                .andExpect(method(HttpMethod.GET))
                .andRespond(withSuccess("true", MediaType.APPLICATION_JSON));

        //When
        boolean saved = orderService.createOrder(order);

        Assertions.assertThat(saved).isTrue();

        mockRestServiceServer.verify();

    }
}