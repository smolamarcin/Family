package com.smola.util;

import org.springframework.stereotype.Component;

@Component
public class SqlValidator implements Validator<String> {

    @Override
    public String validate(String input) {
        String parsed = input.replaceAll("[^a-zA-Z0-9]",
                "");
        return parsed;
    }
}
