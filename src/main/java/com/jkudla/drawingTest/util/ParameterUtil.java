package com.jkudla.drawingTest.util;

public class ParameterUtil {

    public static boolean isIntegerOfSize(String parameter, int sizeMin, int sizeMax) {
        if (!isInteger(parameter)) {
            return false;
        }

        int param = Integer.parseInt(parameter);
        if (param < sizeMin || param > sizeMax) {
            return false;
        }
        return true;
    }

    public static boolean isInteger(String s) {
        try {
            Integer.parseInt(s);
        } catch (NumberFormatException e) {
            return false;
        } catch (NullPointerException e) {
            return false;
        }
        return true;
    }
}
