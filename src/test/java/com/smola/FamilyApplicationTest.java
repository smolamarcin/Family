package com.smola;

import com.smola.config.H2TestProfileJPAConfig;
import com.smola.model.Customer;
import com.smola.repositories.CustomerRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {
        FamilyApplication.class,
        H2TestProfileJPAConfig.class})
@ActiveProfiles("test")
public class FamilyApplicationTest {

    @Autowired
    private CustomerRepository customerRepository;

    @Test
    public void shouldSaveToDb() {
        customerRepository.save(new Customer("Jack", "Bauer"));
        assertEquals(customerRepository.findAll().size(),1);
    }
}