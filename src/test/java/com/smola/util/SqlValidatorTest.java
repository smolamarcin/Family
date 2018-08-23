package com.smola.util;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class SqlValidatorTest {
    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][] {
                { "1=1", "11" }, { "Drop *", "Drop" }
        });
    }

    @Parameterized.Parameter
    public  String input;

    @Parameterized.Parameter(1)
    public String expected;

    private Validator validator = new SqlValidator();
    @Test
    public void shouldValidateInput() {
        assertEquals(expected,validator.validate(input));
    }
}