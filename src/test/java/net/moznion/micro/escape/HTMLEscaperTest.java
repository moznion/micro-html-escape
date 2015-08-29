package net.moznion.micro.escape;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class HTMLEscaperTest {
    @Test
    public void test() {
        assertEquals("&lt;^o^&gt;", HTMLEscaper.escape("<^o^>"));
        assertEquals("&#39;&quot;", HTMLEscaper.escape("'\""));
        assertEquals("~\0&gt;", HTMLEscaper.escape("~\0>"));
        assertEquals("&#96;~", HTMLEscaper.escape("`~"));
        assertEquals("aあaあaあ&#123;aあaあaあ&#125;aあaあaあ", HTMLEscaper.escape("aあaあaあ{aあaあaあ}aあaあaあ"));
    }

    @Test
    public void forNull() {
        assertEquals(null, HTMLEscaper.escape(null));
    }

    @Test
    public void testForBound() {
        // XXX fragile test!

        String str = "";
        for (int i = 0; i < 1025; i++) {
            str += "a";
        }

        final String origin = str + ">";
        final String expected = str + "&gt;";
        assertEquals(expected, HTMLEscaper.escape(origin));
    }
}
