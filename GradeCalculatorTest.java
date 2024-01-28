package xmf194_lab6;

import xmf194_lab6.GradeCalculator;
import static org.junit.Assert.*;
import org.junit.*;

public class GradeCalculatorTest {

    private static GradeCalculator gradeCalculator;

    @BeforeClass
    public static void setUp() {
        gradeCalculator = new GradeCalculator();
    }

    @AfterClass
    public static void tearDown() {
        gradeCalculator = null;
    }

    @Test
    public void testNegativeQuizGrade() {
        double[] components = { 0.14, 0.36, 0.20, 0.30 };
        double[] grades = { -5.0, 80.0, 90.0, 85.0 };
        assertEquals(-1.0, gradeCalculator.gradeCalc(components, grades), 0.001);
    }

    @Test
    public void testNegativeLabGrade() {
        double[] components = { 0.14, 0.36, 0.20, 0.30 };
        double[] grades = { 75.0, -90.0, 90.0, 85.0 };
        assertEquals(-1.0, gradeCalculator.gradeCalc(components, grades), 0.001);
    }

    @Test
    public void testNegativeExamGrade() {
        double[] components = { 0.14, 0.36, 0.20, 0.30 };
        double[] grades = { 75.0, 80.0, -90.0, 85.0 };
        assertEquals(-1.0, gradeCalculator.gradeCalc(components, grades), 0.001);
    }

    @Test
    public void testNonNumericInput() {
        double[] components = { 0.14, 0.36, 0.20, 0.30 };
        double[] grades = { 75.0, 80.0, 90.0, Double.parseDouble("abc") };
        assertEquals(-1.0, gradeCalculator.gradeCalc(components, grades), 0.001);
    }

    @Test
    public void testNoGradeEntered() {
        double[] components = { 0.14, 0.36, 0.20, 0.30 };
        double[] grades = { 75.0, 80.0, 90.0, 0.0 };
        assertEquals(-1.0, gradeCalculator.gradeCalc(components, grades), 0.001);
    }
}