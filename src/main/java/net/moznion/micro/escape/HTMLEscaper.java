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

        int i = 0;
        for (char c : rawString.toCharArray()) {
            if (c <= replacementMax && replacements[c] != null) {
                return _escape(rawString, i);
            }
            i++;
        }

        // No replacement target characters. Return raw argument.
        return rawString;
    }

    private static String _escape(final String rawString, int cursor) {
        final char[][] replacements = REPLACEMENTS;
        final char replacementMax = REPLACEMENT_MAX;

        final char[] rawChars = rawString.toCharArray();
        final int length = rawChars.length;

        int bufsize = 1024; // XXX magic number!!
        char[] buf = new char[bufsize];

        int beginCursor = 0;
        int bufIndex = 0;

        char c;
        char[] replacedCharacters;
        char[] copybuf;
        int sizeNeeded;
        int lenOfReplaced;
        int lenOfCopied;
        for (; cursor < length; cursor++) {
            c = rawChars[cursor];
            if (c <= replacementMax && (replacedCharacters = replacements[c]) != null) {
                lenOfReplaced = replacedCharacters.length;
                lenOfCopied = cursor - beginCursor;

                if ((sizeNeeded = bufIndex + lenOfCopied + lenOfReplaced) > bufsize) {
                    bufsize = sizeNeeded + (length - cursor) * 4;

                    copybuf = new char[bufsize];
                    System.arraycopy(buf, 0, copybuf, 0, bufIndex);
                    buf = copybuf;
                }
                System.arraycopy(rawChars, beginCursor, buf, bufIndex, lenOfCopied);

                bufIndex += lenOfCopied;
                beginCursor = cursor + 1;

                System.arraycopy(replacedCharacters, 0, buf, bufIndex, lenOfReplaced);
                bufIndex += lenOfReplaced;
            }
        }

        if (beginCursor < cursor) {
            lenOfCopied = cursor - beginCursor;
            if ((sizeNeeded = bufIndex + lenOfCopied) > bufsize) {
                copybuf = new char[sizeNeeded];
                System.arraycopy(buf, 0, copybuf, 0, bufIndex);
                buf = copybuf;
            }
            System.arraycopy(rawChars, beginCursor, buf, bufIndex, cursor - beginCursor);
            bufIndex += lenOfCopied;
        }

        return new String(buf, 0, bufIndex);
    }
}

