package com.example.demo;

import java.io.IOException;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.repository.UserRepository;
import com.example.demo.entities.User;
import com.example.demo.entities.Phone;

@SpringBootTest
class Users1ApplicationTests {
	
    @Autowired
	private UserRepository userRepository;
	
	@Test
	
	void contextLoads() {
	}

   
	    @Test
	    public void whenGeneratingUUIDUsingNewJPAGenerationType_thenHibernateGeneratedUUID() throws IOException {
	        
	    	User user = new User();
	        user.setName("John");
	        user.setEmail("john@domain.com");
	        user.setPassword("passwoerd1");

	        Phone phone = new Phone();
	        phone.setNumber("1234556");
	        phone.setCitycode("46");
	        phone.setCountrycode("43");
	        phone.setId(user.getId());
	        phone.setUser(user);
	        user.getPhones().add(phone);
	        
	        phone = new Phone();
	        phone.setNumber("2234556");
	        phone.setCitycode("46");
	        phone.setCountrycode("43");
	        phone.setUser(user);
	        user.getPhones().add(phone);

	        User saved = userRepository.save(user);

	        Assertions.assertThat(saved).isNotNull();
	    }
	    
}
