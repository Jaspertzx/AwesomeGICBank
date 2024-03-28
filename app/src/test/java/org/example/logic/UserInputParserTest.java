package org.example.logic;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

/**
 * Tests the DepositCommandParser class.
 */
public class UserInputParserTest {
    @Test
    public void validCashValue_zeroAmount_successful() throws Exception {
        assertTrue(UserInputParser.validCashValue("0.00"));
    }
    @Test
    public void validCashValue_positiveAmount_successful() throws Exception {
        assertTrue(UserInputParser.validCashValue("5.00"));
    }
    @Test
    public void validCashValue_positiveIntegerAmount_successful() throws Exception {
        assertTrue(UserInputParser.validCashValue("5"));
    }
    @Test
    public void validCashValue_negativeIntegerAmount_failure() throws Exception {
        assertFalse(UserInputParser.validCashValue("-5"));
    }
    @Test
    public void validCashValue_negativeAmount_failure() throws Exception {
        assertFalse(UserInputParser.validCashValue("-5.00"));
    }
    @Test
    public void validCashValue_stringAmount_failure() throws Exception {
        assertFalse(UserInputParser.validCashValue("one"));
    }
    @Test
    public void validCashValue_moreThanTwoDecimalPlacesAmount_failure() throws Exception {
        assertFalse(UserInputParser.validCashValue("5.001"));
    }
}
