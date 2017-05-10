package edu.matc.entity;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by David on 5/4/17.
 */
public class CollectorRoleTest {
    Collectors collectors = new Collectors();
    String testEmail = "test@collectors.com";

    @Before
    public void setUp() throws Exception {
        collectors.setEmail(testEmail);
        collectors.setPassword("test");
    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void getEmail() throws Exception {
        assertEquals("wrong email", testEmail, collectors.getEmail());
    }

    @Test
    public void setEmail() throws Exception {
        Collectors setCollectorEmail = new Collectors();
        setCollectorEmail.setEmail("setting@email.com");


        assertEquals("set email failed", "setting@email.com", setCollectorEmail.getEmail());
    }
}