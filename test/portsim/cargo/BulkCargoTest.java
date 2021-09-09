package portsim.cargo;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class BulkCargoTest {
    private BulkCargo sut;

    @Before
    public void setup() {
        sut = new BulkCargo(0, "Australia", 100, BulkCargoType.COAL);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCtor() {
        new BulkCargo(-1, "Australia", 100, BulkCargoType.COAL);
    }

    @Test
    public void testGetTonnage() {
        assertEquals(sut.getTonnage(), 100);
    }

    @Test
    public void testGetType() {
        assertEquals(sut.getType(), BulkCargoType.COAL);
    }

    @Test
    public void testToString() {
        assertEquals(sut.toString(), "BulkCargo 0 to Australia [COAL - 100]");
    }
}