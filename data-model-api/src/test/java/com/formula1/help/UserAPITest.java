package com.formula1.help;

import com.formula1.help.actor.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by alexey on 03.05.16.
 */
@Test
@ContextConfiguration(locations = {"classpath:model-api-test-config.xml"})
public class UserAPITest extends AbstractTestNGSpringContextTests {
    @Autowired
    TestUserGenerator testUserGenerator;

    @Test
    void validUserTest() {
        User validUser = testUserGenerator.getValidUser();

        Assert.assertNotNull(validUser);
        Assert.assertTrue(validUser.getID() > 0);
        Assert.assertNotNull(validUser.getEmail());
        Assert.assertTrue(validUser.getEmail().split("@").length > 0);
        Assert.assertEquals("+" + String.valueOf(validUser.getPhoneNumber()), validUser.getFullPhoneNumber());
    }

}
