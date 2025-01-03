package com.company.sample;

import static org.junit.Assert.assertNotNull;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.log;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import lombok.Getter;
import lombok.ToString;
import lombok.extern.log4j.Log4j;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Component
@ToString
@Getter
@Log4j
public class HotelTest {

	@Autowired
	private SampleHotel hotel;

	@Test
	public void testExist() {
		
		assertNotNull(hotel);
		log.info(hotel);
		log.info("------------------");
		log.info(hotel.getChef());
	}
}
