package org.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;

class LoginTodoTest {

    @Test
    void testLoginInvalidUser() {
        // Prepare input for the test
        String input = "login\nInvalidUser\n";
        InputStream inputStream = new ByteArrayInputStream(input.getBytes(StandardCharsets.UTF_8));
        System.setIn(inputStream);

        // Redirect System.out to capture the output
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        // Run the login method
        String result = loginTODO.login();

        // Restore System.in and System.out
        System.setIn(System.in);
        System.setOut(System.out);

        // Assertions
        assertNull(result);
    }

}

