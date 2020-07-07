package com.wh.stream.sender;

import com.wh.dto.Order;
import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * MessageSender Tester.
 *
 * @author <Authors name>
 * @version 1.0
 * @since <pre>07/07/2020</pre>
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class MessageSenderTest {

    @Autowired
    private MessageSender messageSender;

    @Before
    public void before() throws Exception {
    }

    @After
    public void after() throws Exception {
    }

    /**
     * Method: send(T message)
     */
    @Test
    public void testSend() throws Exception {
        for (int i = 0; i < 100; i++) {
            // messageSender.send("Spring CLoud Stream Message!");
            Order order = new Order();
            order.setOrderNo((long) i);
            order.setConsumer("Joker");
            order.setConsumerId(1874L);
            messageSender.send(order);
        }
    }


} 
