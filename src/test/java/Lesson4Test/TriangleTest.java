package Lesson4Test;

import Lesson4.Triangle;
import com.sun.org.apache.xpath.internal.operations.Equals;
import net.jodah.failsafe.internal.util.Assert;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

public class TriangleTest {

    @Test
    @DisplayName("Египетский треугольник")
    public void contPerimeterEgyptTriangleSuccessTest() {

        Triangle t = new Triangle(3, 4, 5, Triangle.Color.BLUE);
        int perimeter = t.countPerimeter();
        assertEquals(12, perimeter);
    }

    @Test
    @DisplayName("Равносторонний треугольник")
    public void contPerimeterEqualSidesSuccessTest() {

        Triangle t = new Triangle(3, 3, 3, Triangle.Color.BLUE);
        int perimeter = t.countPerimeter();
        assertEquals(9, perimeter);
    }

    public static Stream<Arguments> trianglesPerimeter() {
        return Stream.of(Arguments.of(new Triangle(3, 4, 5, Triangle.Color.BLUE), 12),
                Arguments.of(new Triangle(3, 3, 3, Triangle.Color.BLUE), 9),
                Arguments.of(new Triangle(3, 4, 6, Triangle.Color.BLUE), 13)
        );
    }

    @ParameterizedTest(name = "Периметр треугольника {0} равен {1}")
    @MethodSource("trianglesPerimeter")
    public void countPerimeterTriangleTest(Triangle triangle, int expectedPerimeter) {
        int perimeter = triangle.countPerimeter();
        assertEquals(expectedPerimeter, perimeter);
    }

    @Test
    public void perimeterInvalidTriangleNegativeSideTest() {
        Triangle triangle = new Triangle(-3, 4, 6, Triangle.Color.BLUE);
        IllegalArgumentException illegalArgumentException = assertThrows(IllegalArgumentException.class, triangle::countPerimeter);
        assertEquals("Triangle sides must be positive", illegalArgumentException.getMessage());
    }

    @Test
    public void perimeterInvalidTriangleInvalidSideTest() {
        Triangle triangle = new Triangle(1, 1, 15, Triangle.Color.BLUE);
        IllegalArgumentException illegalArgumentException = assertThrows(IllegalArgumentException.class, triangle::countPerimeter);
        assertEquals("Triangle sides must be valid", illegalArgumentException.getMessage());
    }

    public static Stream<Arguments> trianglesArea() {
        return Stream.of(Arguments.of(new Triangle(3, 4, 5, Triangle.Color.BLUE), 6),
                Arguments.of(new Triangle(3, 3, 3, Triangle.Color.BLUE), 3.897114317029974),
                Arguments.of(new Triangle(3, 4, 6, Triangle.Color.BLUE), 5.332682251925386)
        );
    }

    @ParameterizedTest(name = "Площадь треугольника {0} равна {1}")
    @MethodSource("trianglesArea")
    public void countAreaTriangleTest(Triangle triangle, double expectedArea) {
        double area = triangle.countArea();
        assertEquals(expectedArea, area);
    }
}
