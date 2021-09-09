package portsim.ship;

import org.junit.Before;
import org.junit.Test;
import portsim.cargo.*;
import portsim.port.BulkQuay;
import portsim.port.ContainerQuay;
import portsim.port.Quay;

import static org.junit.Assert.*;

public class BulkCarrierTest {
    private BulkCarrier sut;

    @Before
    public void setup() {
        sut = new BulkCarrier(3141592, "ApplePie", "Australia", NauticalFlag.WHISKEY, 100);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCtorImoTooLong() {
        new BulkCarrier(31415926, "ApplePie", "Australia", NauticalFlag.WHISKEY, 100);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCtorImoTooShort() {
        new BulkCarrier(314159, "ApplePie", "Australia", NauticalFlag.WHISKEY, 100);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCtorNegativeImo() {
        new BulkCarrier(-5, "ApplePie", "Australia", NauticalFlag.WHISKEY, 100);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCtorNegativeCapacity() {
        new BulkCarrier(3141592, "ApplePie", "Australia", NauticalFlag.WHISKEY, -2);
    }

    @Test
    public void testCanDock() {

        Quay wrongTypeQuay = new ContainerQuay(0, 100);
        Quay lightQuay = new BulkQuay(1, 70);
        Quay heavyQuay = new BulkQuay(2, 200);

        assertFalse(sut.canDock(wrongTypeQuay));
        assertTrue(sut.canDock(lightQuay));

        Cargo lightCargo = new BulkCargo(2, "Australia", 80, BulkCargoType.COAL);
        sut.loadCargo(lightCargo);

        assertTrue(sut.canDock(heavyQuay));
        assertFalse(sut.canDock(lightQuay));
    }

    @Test
    public void testCanLoad() {
        Cargo wrongTypeCargo = new Container(0, "Australia", ContainerType.STANDARD);
        Cargo wrongDestination = new Container(1, "Canada", ContainerType.STANDARD);
        Cargo heavyCargo = new BulkCargo(2, "Australia", 200, BulkCargoType.COAL);
        Cargo lightCargo = new BulkCargo(3, "Australia", 80, BulkCargoType.COAL);

        assertFalse(sut.canLoad(null));
        assertFalse(sut.canLoad(wrongTypeCargo));
        assertFalse(sut.canLoad(wrongDestination));
        assertFalse(sut.canLoad(heavyCargo));
        assertTrue(sut.canLoad(lightCargo));
    }

    @Test
    public void testLoadAndUnload() {
        Cargo lightCargo = new BulkCargo(2, "Australia", 80, BulkCargoType.COAL);
        sut.loadCargo(lightCargo);
        assertEquals(sut.getBulkCargo(), lightCargo);
    }

    @Test
    public void testToString() {
        assertEquals(sut.toString(), "BulkCarrier ApplePie from Australia [WHISKEY] carrying nothing");
        Cargo lightCargo = new BulkCargo(2, "Australia", 80, BulkCargoType.COAL);
        sut.loadCargo(lightCargo);
        assertEquals(sut.toString(), "BulkCarrier ApplePie from Australia [WHISKEY] carrying COAL");
    }
}