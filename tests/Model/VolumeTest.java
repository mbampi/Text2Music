package Model;

import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class VolumeTest {

    @Test
    public void aumentaVolume10porCento() {
        assertEquals(110, Volume.aumentaDezPorCento(100));
    }

    @Test
    public void dobraVolume() {
        assertEquals(200, Volume.dobra(100));
    }

    @Test
    public void getVolume() {
        assertEquals("X[Volume]=100", Volume.getVolumeToken(100));
    }
}