package aichan.task;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Test;

import aichan.AiChanException;

/**
 * Tests the Event class.
 */
public class EventTest {
    /**
     * Checks the error thrown with invalid input.
     */
    @Test
    public void testInvaildDate() {
        String[] arr = {"meeting", "13-12-2019 1200", "13-12-2019 1400"};
        try {
            Event event = new Event(arr);
            fail(); // the test should not reach this line
        } catch (AiChanException e) {
            assertEquals("Please enter the date and time with this format: 25/12/2019 1800", e.getMessage());
        }

    }

    /**
     * Checks whether the string representation for user is correct format.
     */
    @Test
    public void testToString() {
        String[] arr = {"meeting", "13/12/2019 1200", "13/12/2019 1400"};
        String result;
        try {
            Event event = new Event(arr);
            result = event.toString();
        } catch (AiChanException e) {
            result = e.getMessage();
        }
        assertEquals("[E][ ] meeting (from: Dec 13 2019 1200 to: Dec 13 2019 1400)", result);
    }

    /**
     * Checks whether the string representation for storing in line is correct format.
     */
    @Test
    public void testToFileLine() {
        String[] arr = {"meeting", "13/12/2019 1200", "13/12/2019 1400"};
        String result;
        try {
            Event event = new Event(arr);
            result = event.toFileLine();
        } catch (AiChanException e) {
            result = e.getMessage();
        }
        assertEquals("E | 0 | meeting | 13/12/2019 1200 - 13/12/2019 1400", result);
    }
}
