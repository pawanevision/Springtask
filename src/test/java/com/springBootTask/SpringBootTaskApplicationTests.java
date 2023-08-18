package com.springBootTask;

import com.springBootTask.entity.Order;
import com.springBootTask.repository.OrderRepository;
import com.springBootTask.services.OrderServiceImpl;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class SpringBootTaskApplicationTests {

	@Test
	void contextLoads() {
	}
	@Autowired
	private OrderServiceImpl studentService;

	@MockBean
	private OrderRepository studentRepository;

	@Test
	public void testRetrieveStudentWithMockRepository() throws Exception {
		Order o = new Order();
		o.setOrderId(1L);

		o.setOrderPersonName("Pawan");


		Optional<Order> optStudent = Optional.of(o);
		when(studentRepository.findById(1L)).thenReturn(optStudent);

		assertTrue(studentService.getOrderById(1L).getOrderPersonName().contains("Pawan"));
	}

}



