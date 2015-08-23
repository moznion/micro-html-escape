package net.moznion.micro.escape;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class HTMLEscaperTest {
    @Test
    public void test() {
        assertEquals("&lt;^o^&gt;", HTMLEscaper.escape("<^o^>"));
        assertEquals("&#39;&quot;", HTMLEscaper.escape("'\""));
        assertEquals("\0&gt;", HTMLEscaper.escape("\0>"));
        assertEquals("&#96;", HTMLEscaper.escape("`"));
        assertEquals("&#123;&#125;", HTMLEscaper.escape("{}"));
    }
}

