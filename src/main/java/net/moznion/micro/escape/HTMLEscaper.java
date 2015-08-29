package net.moznion.micro.escape;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * String escaper for HTML.
 */
public class HTMLEscaper {
    private static final char[][] REPLACEMENTS;
    private static final char REPLACEMENT_MAX;

    static {
        final Map<Character, String> replaceMap = new HashMap<>(8);
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
        REPLACEMENT_MAX = Collections.max(replaceMap.keySet());
        REPLACEMENTS = new char[REPLACEMENT_MAX + 1][];
        for (char c : replaceMap.keySet()) {
            REPLACEMENTS[c] = replaceMap.get(c).toCharArray();
        }
    }

    /**
     * Escape string for HTML.
     *
     * @param rawString raw string. If you give null, this method returns empty string.
     * @return escaped string.
     */
    public static String escape(final String rawString) {
        final char[][] replacements = REPLACEMENTS;
        final char replacementMax = REPLACEMENT_MAX;

        if (rawString == null) {
            return null;
        }

        final int length = rawString.length();

        int i = 0;
        for (char c : rawString.toCharArray()) {
            c = rawString.charAt(i);
            if (c <= replacementMax && replacements[c] != null) {
                return _escape(rawString, length, i);
            }
            i++;
        }

        // No replacement target characters. Return raw argument.
        return rawString;
    }

    private static String _escape(final String rawString, final int length, int cursor) {
        final char[][] replacements = REPLACEMENTS;
        final char replacementMax = REPLACEMENT_MAX;

        // 6 (== "&quot;".length()) is a magic coefficient for maximum length.
        final char[] buf = new char[length + 100];

        int beginCursor = 0;
        int bufIndex = 0;

        char c;
        char[] replacedCharacters;
        for (; cursor < length; cursor++) {
            c = rawString.charAt(cursor);
            if (c <= replacementMax && (replacedCharacters = replacements[c]) != null) {
                final int lenOfReplaced = replacedCharacters.length;
                final int lenOfCopied = cursor - beginCursor;

                rawString.getChars(beginCursor, cursor, buf, bufIndex);

                bufIndex += lenOfCopied;
                beginCursor = cursor + 1;

                System.arraycopy(replacedCharacters, 0, buf, bufIndex, lenOfReplaced);
                bufIndex += lenOfReplaced;
            }
        }

        if (beginCursor < cursor) {
            rawString.getChars(beginCursor, cursor, buf, bufIndex);
            bufIndex += (cursor - beginCursor);
        }

        return new String(buf, 0, bufIndex);
    }
}
