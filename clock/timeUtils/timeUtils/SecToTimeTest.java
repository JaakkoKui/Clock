package timeUtils;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SecToTimeTest {

    @ParameterizedTest(name = "Seconds {0} should be converted to {1}")
    @CsvSource({ "0, 0:00:00", "59, 0:00:59", "60, 0:01:00", "3600, 1:00:00", "3661, 1:01:01"})
    public void testSecToTime(int seconds, String expectedTime) {
        String actualTime = TimeUtils.secToTime(seconds);
        assertEquals(expectedTime, actualTime);
    }

    @ParameterizedTest(name = "Seconds {0} should return \"-1\"")
    @CsvSource({ "-1", "32000"})
    public void testSecToTimeInvalid(int seconds) {
        String actualTime = TimeUtils.secToTime(seconds);
        assertEquals("-1", actualTime);
    }
}
