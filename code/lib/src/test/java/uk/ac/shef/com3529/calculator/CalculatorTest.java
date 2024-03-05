package uk.ac.shef.com3529.calculator;

import org.junit.jupiter.api.Test;
import uk.ac.shef.com3529.bankaccount.BankAccountDatabaseConnection;
import uk.ac.shef.com3529.connect4.Connect4;
import uk.ac.shef.com3529.connect4.Piece;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.mockito.Mockito.*;

public class CalculatorTest {

    @Test
    public void shouldAddTwoNumbers() {
        // Setup the mock, including to return 2 numbers and the addition symbol
        Reader mock = mock();
        when(mock.readDouble()).thenReturn(2.0, 4.0);
        when(mock.readWord()).thenReturn("+");

        // Setup mock writer to detect output
        Writer writer = mock();

        // Create the calculator with mock reader
        Calculator calculator = new Calculator(mock, writer);

        // Trigger calculate
        calculator.calculate();

        // Then it's YELLOW's turn next
        verify(writer).write("2.0 + 4.0 = 6.0");
    }
}
