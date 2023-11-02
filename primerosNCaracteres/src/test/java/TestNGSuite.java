import org.testng.Assert;
import org.testng.annotations.*;

import java.util.Random;

public class TestNGSuite {

    CharsClass charsclass = new CharsClass();

    @Test
    public void nullTest() {
        String[] result = charsclass.firstAndLast(null, 2);
        Assert.assertNull(result);
    }

    @Test
    public void emptyStrTest() {
        String[] result = charsclass.firstAndLast("", 4);
        String[] expectedResult = {"", ""};
        Assert.assertEquals(result, expectedResult);
    }

    @Test
    public void oneCharTest() {
        String[] result = charsclass.firstAndLast("a", 1);
        String[] expectedResult = {"a", "a"};
        Assert.assertEquals(result, expectedResult);
    }

    @Test
    public void twoCharTest() {
        String[] result = charsclass.firstAndLast("ab", 1);
        String[] expectedResult = {"a", "b"};
        Assert.assertEquals(result, expectedResult);
    }

    @Test
    public void threeCharTest() {
        String[] result = charsclass.firstAndLast("abc", 2);
        String[] expectedResult = {"ab", "bc"};
        Assert.assertEquals(result, expectedResult);
    }

    @Test
    public void nZeroTest() {
        String[] result = charsclass.firstAndLast("vehículo", 0);
        String[] expectedResult = {"", ""};
        Assert.assertEquals(result, expectedResult);
    }

    @Test
    public void nOneTest() {
        String[] result = charsclass.firstAndLast("vehículo", 1);
        String[] expectedResult = {"v", "o"};
        Assert.assertEquals(result, expectedResult);
    }

    @Test
    public void nTwoTest() {
        String[] result = charsclass.firstAndLast("vehículo", 2);
        String[] expectedResult = {"ve", "lo"};
        Assert.assertEquals(result, expectedResult);
    }

    @Test
    public void nThreeTest() {
        String[] result = charsclass.firstAndLast("vehículo", 3);
        String[] expectedResult = {"veh", "ulo"};
        Assert.assertEquals(result, expectedResult);
    }

    @Test
    public void nFourTest() {
        String[] result = charsclass.firstAndLast("vehículo", 4);
        String[] expectedResult = {"vehí", "culo"};
        Assert.assertEquals(result, expectedResult);
    }

    @Test
    public void nFiveTest() {
        String[] result = charsclass.firstAndLast("vehículo", 5);
        String[] expectedResult = {"vehíc", "ículo"};
        Assert.assertEquals(result, expectedResult);
    }

    @Test
    public void nSixTest() {
        String[] result = charsclass.firstAndLast("vehículo", 6);
        String[] expectedResult = {"vehícu", "hículo"};
        Assert.assertEquals(result, expectedResult);
    }

    @Test
    public void nSevenTest() {
        String[] result = charsclass.firstAndLast("vehículo", 7);
        String[] expectedResult = {"vehícul", "ehículo"};
        Assert.assertEquals(result, expectedResult);
    }

    @Test
    public void nEqualToLengthTest() {
        String[] result = charsclass.firstAndLast("vehículo", 8);
        String[] expectedResult = {"vehículo", "vehículo"};
        Assert.assertEquals(result, expectedResult);
    }

    @Test
    public void nGreaterThanLengthTest() {
        String[] result = charsclass.firstAndLast("vehículo", 15);
        String[] expectedResult = {"vehículo", "vehículo"};
        Assert.assertEquals(result, expectedResult);
    }

    @Test
    public void nZeroTest2() {
        String[] result = charsclass.firstAndLast("carrera", 0);
        String[] expectedResult = {"", ""};
        Assert.assertEquals(result, expectedResult);
    }

    @Test
    public void nOneTest2() {
        String[] result = charsclass.firstAndLast("carrera", 1);
        String[] expectedResult = {"c", "a"};
        Assert.assertEquals(result, expectedResult);
    }

    @Test
    public void nTwoTest2() {
        String[] result = charsclass.firstAndLast("carrera", 2);
        String[] expectedResult = {"ca", "ra"};
        Assert.assertEquals(result, expectedResult);
    }

    @Test
    public void nThreeTest2() {
        String[] result = charsclass.firstAndLast("carrera", 3);
        String[] expectedResult = {"car", "era"};
        Assert.assertEquals(result, expectedResult);
    }

    @Test
    public void nFourTest2() {
        String[] result = charsclass.firstAndLast("carrera", 4);
        String[] expectedResult = {"carr", "rera"};
        Assert.assertEquals(result, expectedResult);
    }

    @Test
    public void nFiveTest2() {
        String[] result = charsclass.firstAndLast("carrera", 5);
        String[] expectedResult = {"carre", "rrera"};
        Assert.assertEquals(result, expectedResult);
    }

    @Test
    public void nSixTest2() {
        String[] result = charsclass.firstAndLast("carrera", 6);
        String[] expectedResult = {"carrer", "arrera"};
        Assert.assertEquals(result, expectedResult);
    }

    @Test
    public void nEqualToLengthTest2() {
        String[] result = charsclass.firstAndLast("carrera", 7);
        String[] expectedResult = {"carrera", "carrera"};
        Assert.assertEquals(result, expectedResult);
    }

    @Test
    public void nGreaterThanLengthTest2() {
        String[] result = charsclass.firstAndLast("carrera", 12);
        String[] expectedResult = {"carrera", "carrera"};
        Assert.assertEquals(result, expectedResult);
    }

}
