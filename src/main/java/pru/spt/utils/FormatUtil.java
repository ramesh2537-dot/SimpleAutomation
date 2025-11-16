package pru.spt.utils;

public class FormatUtil {

    public static String getTrimmedString(String str) {
        String s = "";
        s = str != null ? str.trim() : "";
        return s;
    }
}