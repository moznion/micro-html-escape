package net.moznion.micro.escape;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class HTMLEscaperTest {
    @Test
    public void test() {
        assertEquals("&lt;^o^&gt;", HTMLEscaper.escape("<^o^>"));
        assertEquals("&#39;&quot;", HTMLEscaper.escape("'\""));
        assertEquals("\0&gt;", HTMLEscaper.escape("\0>"));
        assertEquals("&#96;~", HTMLEscaper.escape("`~"));
        assertEquals("aあaあaあ&#123;&#125;aあaあaあ", HTMLEscaper.escape("aあaあaあ{}aあaあaあ"));
    }

    @Test
    public void forNull() {
        assertEquals(null, HTMLEscaper.escape(null));
    }
}

