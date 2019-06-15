import Code.Ritmo;
import org.junit.Assert;
import org.junit.Test;

public class RitmoTest {

    @Test
    public void getBPM() {
        Assert.assertEquals("T120", Ritmo.getBPM(120));
    }

    @Test
    public void getBPMmin() {
        Assert.assertEquals("T40", Ritmo.getBPM(40));
    }

    @Test
    public void getBPMmax() {
        Assert.assertEquals("T220", Ritmo.getBPM(220));
    }

    @Test
    public void getBPMabaixoMin() {
        Assert.assertEquals("", Ritmo.getBPM(20));
    }

    @Test
    public void getBPMacimaMax() {
        Assert.assertEquals("", Ritmo.getBPM(240));
    }
}