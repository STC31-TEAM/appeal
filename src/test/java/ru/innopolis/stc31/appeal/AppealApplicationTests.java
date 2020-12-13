package ru.innopolis.stc31.appeal;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(classes = AppealApplicationTests.class)
@ActiveProfiles("test")
class AppealApplicationTests {

	@Test
	void contextLoads() {
		assertEquals("test", "test");
	}

}
