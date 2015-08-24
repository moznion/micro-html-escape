package net.moznion.micro.escape;

/**
 * String escaper for HTML.
 */
public class HTMLEscaper {
    /**
     * Escape string for HTML.
     *
     * @param rawString raw string. If you give null, this method returns empty string.
     * @return escaped string.
     */
    public static String escape(final String rawString) {
        if (rawString == null) {
            return "";
        }

        // 6 (== "&quot;".length()) is a magic coefficient for performance!
        final StringBuilder sb = new StringBuilder(rawString.length() * 6);

        for (char c : rawString.toCharArray()) {
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
