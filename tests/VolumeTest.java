import org.junit.Test;

import static org.junit.Assert.*;

public class VolumeTest {

    @Test
    public void aumentaVolume10porCento() {
        assertEquals(110, Volume.aumentaVolume10porCento(100));
    }

    @Test
    public void dobraVolume() {
        assertEquals(200, Volume.dobraVolume(100));
    }

    @Test
    public void getVolume() {
        assertEquals("X[Volume]=100", Volume.getVolume(100));
    }
}