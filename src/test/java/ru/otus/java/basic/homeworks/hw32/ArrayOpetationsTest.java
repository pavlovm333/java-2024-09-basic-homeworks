package ru.otus.java.basic.homeworks.hw32;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.NullSource;

import java.util.stream.Stream;

class ArrayOpetationsTest {

    private ArrayOpetations arrayOpetations;

    @BeforeEach
    public void setUp() {
        arrayOpetations = new ArrayOpetations();
    }

    @ParameterizedTest
    @MethodSource("testArrayCuttingData")
    void testArrayCutting(int[] input, int[] expected) {
        int[] result = arrayOpetations.arrayCutting(input);

        Assertions.assertArrayEquals(expected, result);
    }

    public static Stream<Arguments> testArrayCuttingData() {
        return Stream.of(
                Arguments.of(new int[]{1,34,56,56}, new int[]{34,56,56}),
                Arguments.of(new int[]{1,34,1,56,56}, new int[]{56,56}),
                Arguments.of(new int[]{1,34,1,1,56}, new int[]{56}),
                Arguments.of(new int[]{1,34,1,34,1}, new int[]{})
        );
    }

    @Test
    public void testArrayCuttingThrowsRTE() {
        Assertions.assertThrows(RuntimeException.class, () -> {
            arrayOpetations.arrayCutting(new int[]{34,56,56});
        }, "Должно выброситься исключение RuntimeException");
    }

    @ParameterizedTest
    @NullSource
    public void testArrayCuttingThrowsNPE(int[] input) {
        Assertions.assertThrows(NullPointerException.class, () -> {
            arrayOpetations.arrayCutting(input);
        }, "Должно выброситься исключение NullPointerException");
    }

    @ParameterizedTest
    @NullSource
    void testCheckArrayElementsThrowsNPE(int[] input) {
        Assertions.assertThrows(NullPointerException.class, () -> {
            arrayOpetations.checkArrayElements(input);
        }, "Должно выброситься исключение NullPointerException");
    }

    @ParameterizedTest
    @MethodSource("testCheckArrayElementsDataTrue")
    void testCheckArrayElementsTrue(int[] input) {
        boolean result = arrayOpetations.checkArrayElements(input);

        Assertions.assertTrue(result);
    }

    public static Stream<Arguments> testCheckArrayElementsDataTrue() {
        return Stream.of(
                Arguments.of(new int[]{1,1,2,2,1}),
                Arguments.of(new int[]{1,2})
        );
    }

    @ParameterizedTest
    @MethodSource("testCheckArrayElementsDataFalse")
    void testCheckArrayElementsFalse(int[] input) {
        boolean result = arrayOpetations.checkArrayElements(input);

        Assertions.assertFalse(result);
    }

    public static Stream<Arguments> testCheckArrayElementsDataFalse() {
        return Stream.of(
                Arguments.of(new int[]{1,3,1,2,2,1}),
                Arguments.of(new int[]{1,1}),
                Arguments.of(new int[]{2}),
                Arguments.of(new int[]{45, 56}),
                Arguments.of(new int[]{})
        );
    }
}


