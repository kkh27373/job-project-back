package com.job.back.common.util;

public class DatabaseJson {
    public static String arrayToString(String[] array) {

        String result = "\"[";
        for (int index = 0; index < array.length; index++) {
            result += "'" + array[index] + "'";
            if (index < array.length - 1) result += ",";
        }
        result += "]\"";
        return result;
    }

    // ! String 형태를 배열의 형태로 바꿔주는 
    public static String[] stringToArray(String string) {
        string = string.replace("\"[", "").replace("]\"", "").replace("'", "");
        return string.split(",");
    }
}
