package kr.co.aegis.util;

public class DateUtil {

	private DateUtil() {}
    public static String getDateString() {
        java.text.SimpleDateFormat formatter =
            new java.text.SimpleDateFormat("yyyy-MM-dd", java.util.Locale.KOREA);
        return formatter.format(new java.util.Date());
    }
    public static int getNumberByPattern(String pattern) {
        java.text.SimpleDateFormat formatter =
            new java.text.SimpleDateFormat (pattern, java.util.Locale.KOREA);
        String dateString = formatter.format(new java.util.Date());
        return Integer.parseInt(dateString);
    }
    public static String getStringByPattern(String pattern) {
        java.text.SimpleDateFormat formatter =
            new java.text.SimpleDateFormat (pattern, java.util.Locale.KOREA);
        return formatter.format(new java.util.Date());
    }
    public static String getCurrentTimeToString() {
        java.text.SimpleDateFormat formatter =
            new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss", java.util.Locale.KOREA);
        return formatter.format(new java.util.Date());
    }
    public static String getDateTimeToString() {
        java.text.SimpleDateFormat formatter =
            new java.text.SimpleDateFormat("yyyyMMddHHmmss", java.util.Locale.KOREA);
        return formatter.format(new java.util.Date());
    }
}
