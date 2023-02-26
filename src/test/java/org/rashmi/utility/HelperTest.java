package org.rashmi.utility;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class HelperTest {
    @Test
    void testGetRandomNumber() {
        assertEquals(10, Helper.getRandomNumber(10).length());
        assertEquals(5, Helper.getRandomNumber(5).length());
        assertEquals(11, Helper.getRandomNumber(11).length());
    }
}
