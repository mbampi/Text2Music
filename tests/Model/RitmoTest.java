package Model;

import org.junit.Assert;
import org.junit.Test;

public class RitmoTest {

    @Test
    public void getBPM() {
        Assert.assertEquals("T120", Ritmo.getRitmoToken(120));
    }

    @Test
    public void getBPMmin() {
        Assert.assertEquals("T40", Ritmo.getRitmoToken(40));
    }

    @Test
    public void getBPMmax() {
        Assert.assertEquals("T220", Ritmo.getRitmoToken(220));
    }

    @Test
    public void getBPMabaixoMin() {
        Assert.assertEquals("", Ritmo.getRitmoToken(20));
    }

    @Test
    public void getBPMacimaMax() {
        Assert.assertEquals("", Ritmo.getRitmoToken(240));
    }
}