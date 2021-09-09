package portsim.port;

import org.junit.Before;
import org.junit.Test;
import portsim.ship.BulkCarrier;
import portsim.ship.NauticalFlag;

import static org.junit.Assert.*;

public class BulkQuayTest {
    private BulkQuay sut;

    @Before
    public void setup() {
        sut = new BulkQuay(0, 500);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCtorNegativeId() {
        new BulkQuay(-1, 500);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCtorNegativeTonnage() {
        new BulkQuay(0, -10);
    }

    @Test
    public void getMaxTonnage() {
        assertEquals(sut.getMaxTonnage(), 500);
    }

    @Test
    public void testToString() {
        assertEquals(sut.toString(), "BulkQuay 0 [Ship: None] - 500");

        BulkCarrier ship = new BulkCarrier(3141592, "ApplePie", "Australia", NauticalFlag.WHISKY, 100);
        sut.shipArrives(ship);

        assertEquals(sut.toString(), "BulkQuay 0 [Ship: 3141592] - 500");
    }
}