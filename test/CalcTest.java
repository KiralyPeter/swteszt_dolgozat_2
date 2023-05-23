
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CalcTest {
    MainFrame mainFrame;

    @BeforeEach
    public void initEach() {
        this.mainFrame = new MainFrame();
    }

    @Test
    public void testCalcTime1(){
        double actual = this.mainFrame.calcTime(20, 2, 20);
        double expected = 0.5;
        assertEquals(expected, actual, 0.1);
    }

    @Test
    public void testCalcTime2(){
        double actual = this.mainFrame.calcTime(1, 1, 1);
        double expected = 1;
        assertEquals(expected, actual, 0.1);
    }

    @Test
    public void testCalcTime3(){
        double actual = this.mainFrame.calcTime(100, 100, 100);
        double expected = 0.01;
        assertEquals(expected, actual, 0.1);
    }

    
}
