package net.moznion.micro.escape;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * String escaper for HTML.
 */
public class HTMLEscaper {
    private static final Map<Character, String> replaceMap;
    private static final char replacements[][];
    private static final char replacementMax;

    static {
        replaceMap = new HashMap<>(8);
        replaceMap.put('&', "&amp;");
        replaceMap.put('>', "&gt;");
        replaceMap.put('<', "&lt;");
        replaceMap.put('"', "&quot;");
        replaceMap.put('\'', "&#39;");

        // For IE. IE interprets back-quote as valid quoting characters
        // ref: https://rt.cpan.org/Public/Bug/Display.html?id=84971
        replaceMap.put('`', "&#96;");

        // For javascript templates (e.g. AngularJS and such javascript frameworks)
        // ref: https://github.com/angular/angular.js/issues/5601
        replaceMap.put('{', "&#123;");
        replaceMap.put('}', "&#125;");

        // convert to array from map
        replacementMax = Collections.max(replaceMap.keySet());
        replacements = new char[replacementMax + 1][];
        for (char c : replaceMap.keySet()) {
            replacements[c] = replaceMap.get(c).toCharArray();
        }
    }

    /**
     * Escape string for HTML.
     *
     * @param rawString raw string. If you give null, this method returns empty string.
     * @return escaped string.
     */
    public static String escape(final String rawString) {
        if (rawString == null) {
            return null;
        }

        final int length = rawString.length();

        char c;
        for (int i = 0; i < length; i++) {
            c = rawString.charAt(i);
            if (c <= replacementMax) {
                char[] replacedCharacters = replacements[c];
                if (replacedCharacters != null) {
                    // Replacement target character exists, invoke replacing logic!
                    return _escape(rawString, length, i);
                }
            }
        }

        // No replacement target characters. Return raw argument.
        return rawString;
    }

    private static String _escape(String str, int strlen, int cursor) {
        // 6 (== "&quot;".length()) is a magic coefficient for maximum length.
        final char[] buf = new char[strlen * 6];

        int cnt = 0;

        // pack already read string into buffer
        for (char c : str.substring(0, cursor).toCharArray()) {
            buf[cnt] = c;
            cnt++;
        }

        char c;
        for (int i = cursor; i < strlen; i++) {
            c = str.charAt(i);

            if (c > replacementMax) { // When index out of bounds, append raw character
                buf[cnt] = c;
                cnt++;
                continue;
            }

            char[] replacedCharacters = replacements[c];
            if (replacedCharacters != null) { // Append replaced
                for (char replaced : replacedCharacters) {
                    buf[cnt] = replaced;
                    cnt++;
                }
                continue;
            }

            // Append raw character
            buf[cnt] = c;
            cnt++;
        }

        return new String(buf, 0, cnt);
    }
}
