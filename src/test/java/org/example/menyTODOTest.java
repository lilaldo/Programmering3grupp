package org.example;

import org.junit.jupiter.api.Test;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MenyTodoTest {

    @Test
    void testPrintDay() {
        // Redirect System.out to capture the output
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        // Run the printDay method
        menyTODO.printDay();

        // Restore System.out
        System.setOut(System.out);

        // Assertions
        assertNotNull(outputStream.toString());
    }
    @Test
    void testVälkomnaAnvändare() {
        // Redirect System.out to capture the output
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        // Run the välkomnaAnvändare method
        menyTODO.välkomnaAnvändare("TestUser");

        // Restore System.out
        System.setOut(System.out);

        // Assertions
        assertTrue(outputStream.toString().contains("Welcome TestUser"));
    }


}
