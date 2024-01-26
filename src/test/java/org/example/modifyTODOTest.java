package org.example;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class ModifyTODOTest {

    @Test
    void ändraNamn() {
        ArrayList<String> mockÄrenden = new ArrayList<>();
        mockÄrenden.add("Task 1 | When: MONDAY | Priority: Low");

        modifyTODO.ändraNamn(0, "New Task", mockÄrenden);

        assertEquals("New Task | When: MONDAY | Priority: Low", mockÄrenden.get(0));
    }

    @Test
    void ändraDatum() {
        ArrayList<String> mockÄrenden = new ArrayList<>();
        mockÄrenden.add("Task 1 | When: MONDAY | Priority: Low");

        modifyTODO.ändraDatum(0, "TUESDAY", mockÄrenden);

        assertEquals("Task 1 | When: TUESDAY | Priority: Low", mockÄrenden.get(0));
    }

    @Test
    void ändraPrioritet() {
        ArrayList<String> mockÄrenden = new ArrayList<>();
        mockÄrenden.add("Task 1 | When: MONDAY | Priority: Low");

        modifyTODO.ändraPrioritet(0, "High", mockÄrenden);

        assertEquals("Task 1 | When: MONDAY | Priority: High", mockÄrenden.get(0));
    }

    @Test
    void valtÄrende_validIndex() {
        ArrayList<String> mockÄrenden = new ArrayList<>();
        mockÄrenden.add("Task 1");

        assertTrue(modifyTODO.valtÄrende("1", mockÄrenden));
    }

    @Test
    void valtÄrende_invalidIndex() {
        ArrayList<String> mockÄrenden = new ArrayList<>();
        mockÄrenden.add("Task 1");

        assertFalse(modifyTODO.valtÄrende("2", mockÄrenden));
    }
}
