package com.myspringboot.kafka;

import com.myspringboot.kafka.configuration.CountDownLatchHandler;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.GenericMessage;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Collections;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import static org.assertj.core.api.Assertions.assertThat;

@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
class SpringIntegrationKafkaApplicationTests {

	@Autowired
	private ApplicationContext applicationContext;
	private static String SPRING_INTEGRATION_KAFKA_TOPIC = "test";

	@Autowired
	private CountDownLatchHandler countDownLatchHandler;

	@Test
	public void testIntegration() throws Exception {
		MessageChannel producingChannel =
				applicationContext.getBean("producingChannel", MessageChannel.class);

		Map<String, Object> headers =
				Collections.singletonMap(KafkaHeaders.TOPIC, SPRING_INTEGRATION_KAFKA_TOPIC);

		//log.info("sending 10 messages");
		for (int i = 0; i < 10; i++) {
			GenericMessage<String> message =
					new GenericMessage<>("Hello Spring Integration Kafka " + i + "!", headers);
			producingChannel.send(message);
			//log.info("sent message='{}'", message);
		}
		countDownLatchHandler.getLatch().await(10000, TimeUnit.MILLISECONDS);
		assertThat(countDownLatchHandler.getLatch().getCount()).isEqualTo(0);
	}

	@Test
	void contextLoads() {
	}

}
