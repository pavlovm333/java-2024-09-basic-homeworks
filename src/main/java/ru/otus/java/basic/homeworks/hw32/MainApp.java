package ru.otus.java.basic.homeworks.hw32;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Arrays;

public class MainApp {
    private static final Logger LOGGER = LogManager.getLogger(MainApp.class);

    public static void main(String[] args) {
        ArrayOpetations arrayOpetations = new ArrayOpetations();
        int[] inputArray0 = {1,23,1,6,0,2,4};
        try {
            int[] subArray = arrayOpetations.arrayCutting(inputArray0);
            LOGGER.info("Исходный массив: {}", Arrays.toString(inputArray0));
            LOGGER.info("Результирующий массив после вызова метода arrayCutting: {}", Arrays.toString(subArray));
        } catch (Exception e){
            LOGGER.error("Ошибка! {}",e.getMessage());
        }

        int[] inputArray1 = {1,1};
        LOGGER.info("Исходный массив: {}", Arrays.toString(inputArray1));
        LOGGER.info("Результат вызова метода checkArrayElements: {}", arrayOpetations.checkArrayElements(inputArray1));

        int[] inputArray2 = {1,1,2,2,1};
        LOGGER.info("Исходный массив: {}", Arrays.toString(inputArray2));
        LOGGER.info("Результат вызова метода checkArrayElements: {}", arrayOpetations.checkArrayElements(inputArray2));

        int[] inputArray3 = {1,3,2,2,1};
        LOGGER.info("Исходный массив: {}", Arrays.toString(inputArray3));
        LOGGER.info("Результат вызова метода checkArrayElements: {}", arrayOpetations.checkArrayElements(inputArray3));
    }


}
