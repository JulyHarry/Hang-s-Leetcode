package contest;

import java.util.Arrays;
import java.util.List;

class c01 {
    public static String reformatDate(String date) {
            String[] dates = date.split(" ");
            System.out.println(dates[0]);
            System.out.println(dates[1]);
            System.out.println(dates[2]);
        List<String> monthEnum = Arrays.asList(new String[]{"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"});
        int month = monthEnum.indexOf("") + 1;
        System.out.println(dates[0]);
        System.out.println(dates[1]);
        System.out.println(dates[2]);
            return "";
    }

    public static void main(String[] args) {
        reformatDate("20th Oct 2052");
    }
}