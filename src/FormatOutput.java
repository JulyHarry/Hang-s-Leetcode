public class FormatOutput {
    public static String leetcodeTitleFormatOutput (String title) {
        String[] titles = title.split("-");
        StringBuffer sb = new StringBuffer();
        for (String s : titles) {
            sb.append((char)(s.charAt(0)-32));
            sb.append(s.substring(1,s.length()));
        }
        return sb.toString();
    }
}
