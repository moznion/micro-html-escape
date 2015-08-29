import me.geso.nanobench.Benchmark;
import com.google.common.html.HtmlEscapers;
import org.apache.commons.lang3.StringEscapeUtils;
import net.moznion.micro.escape.HTMLEscaper;

public class BasicBench {
    public static void main(String... args) throws Exception {
        new Benchmark(new EscapingBench()).warmup(1000).run(100000).timethese().cmpthese();
    }

    public static class EscapingBench {
        private static final String target = "<body>\n"
                + "<div>\n"
                + "    <h1>Example Domain</h1>\n"
                + "    <p>This domain is established to be used for illustrative examples in documents. You may use this\n"
                + "    domain in examples without prior coordination or asking for permission.</p>\n"
                + "    <p><a href=\"http://www.iana.org/domains/example\">More information...</a></p>\n"
                + "</div>\n"
                + "</body>";

        @Benchmark.Bench
        public void commonsLangStringEscapeUtils() {
            StringEscapeUtils.escapeHtml4(target);
        }

        @Benchmark.Bench
        public void microHTMLEscaper() {
            HTMLEscaper.escape(target);
        }

        @Benchmark.Bench
        public void guavaHtmlEscapers() {
            HtmlEscapers.htmlEscaper().escape(target);
        }
    }
}
