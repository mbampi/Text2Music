import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class RitmoTest {

    @Test
    public void getBPM() {
        assertEquals("T120", Ritmo.getBPM(120));
    }

    @Test
    public void getBPMmin() {
        assertEquals("T40", Ritmo.getBPM(40));
    }

    @Test
    public void getBPMmax() {
        assertEquals("T220", Ritmo.getBPM(220));
    }

    @Test
    public void getBPMabaixoMin() {
        assertEquals("", Ritmo.getBPM(20));
    }

    @Test
    public void getBPMacimaMax() {
        assertEquals("", Ritmo.getBPM(240));
    }
}