package function;

import function.Tangent;
import org.junit.Assert;
import org.junit.Test;

import static java.lang.Math.PI;
import static java.lang.Math.tan;



public class TangentTest extends Assert {
    @Test
    public void testTgZero() {
        double x = 0.0d;
        assertEquals(tan(x), Tangent.tg(x, 1E-3), 1E-2);
    }

    @Test
    public void testTgHalfPi() {
        double x = PI / 2.0d;
        assertEquals(Double.NaN, Tangent.tg(x, 1E-3), 1E-2);
    }

    @Test
    public void testTgMinusHalfPi() {
        double x = -PI / 2.0d;
        assertEquals(Double.NaN, Tangent.tg(x, 1E-3), 1E-2);
    }

    @Test
    public void testTgPiNaThree() {
        double x = PI / 3.0d;
        assertEquals(tan(x), Tangent.tg(x, 1E-3), 1E-2);
    }

    @Test
    public void testTgMinusPiNaThree() {
        double x = PI / 3.0d;
        assertEquals(tan(x), Tangent.tg(x, 1E-3), 1E-2);
    }

    @Test
    public void testTgPiNaFour() {
        double x = PI / 4.0d;
        assertEquals(tan(x), Tangent.tg(x, 1E-4), 1E-3);
    }

    @Test
    public void testTgMinusPiNaFour() {
        double x = PI / 4.0d;
        assertEquals(tan(x), Tangent.tg(x, 1E-4), 1E-3);
    }

    @Test
    public void testTgPi() {
        double x = PI;
        assertEquals(tan(x), Tangent.tg(x, 1E-4), 1E-3);
    }

    @Test
    public void testTgMinusPi() {
        double x = -PI;
        assertEquals(tan(x), Tangent.tg(x, 1E-4), 1E-3);
    }

    @Test
    public void testTgFivePiNaFour() {
        double x = PI * 1.2d;
        assertEquals(tan(x), Tangent.tg(x, 1E-4), 1E-3);
    }

    @Test
    public void testTgMinusFivePiNaFour() {
        double x = -PI * 1.2d;
        assertEquals(tan(x), Tangent.tg(x, 1E-4), 1E-3);
    }

    @Test
    public void testTgRaiseFromPiNaFourToPiNaThree() {
        double x1 = PI / 4.0;
        double x2 = PI / 3.0;
        assertTrue(Tangent.tg(x2, 1E-4) > Tangent.tg(x1, 1E-4));
    }

    @Test
    public void testTgRaiseFromMinusPiNaThreeToMinusPiNaFour() {
        double x1 = -PI / 4.0;
        double x2 = -PI / 3.0;
        assertTrue(Tangent.tg(x2, 1E-4) < Tangent.tg(x1, 1E-4));
    }

    @Test
    public void testTgRaiseFromMinusPiNaFourToPiNaFour() {
        double x1 = -PI / 4.0;
        double x2 = PI / 4.0;
        assertTrue(Tangent.tg(x2, 1E-4) > Tangent.tg(x1, 1E-4));
    }
}


