package net.moznion.micro.escape;

/**
 * String escaper for HTML.
 */
public class HTMLEscaper {
    /**
     * 
     * @param rawString
     * @return
     */
    public static String escape(String rawString) {
        final StringBuilder sb = new StringBuilder();

        final int len = rawString.length();
        for (int i = 0; i < len; i++) {
            final char c = rawString.charAt(i);
            switch (c) {
                case '&':
                    sb.append("&amp;");
                    break;
                case '>':
                    sb.append("&gt;");
                    break;
                case '<':
                    sb.append("&lt;");
                    break;
                case '"':
                    sb.append("&quot;");
                    break;
                case '\'':
                    sb.append("&#39;");
                    break;
                case '`':
                    sb.append("&#96;");
                    break;
                case '{':
                    sb.append("&#123;");
                    break;
                case '}':
                    sb.append("&#125;");
                    break;
                default:
                    sb.append(c);
            }
        }

        return sb.toString();
    }
}
