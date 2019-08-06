package me.jastz.common;

import com.google.common.html.HtmlEscapers;
import org.junit.Test;

/**
 * Created by zhiwen on 2017/3/2.
 */
public class Guava {

    @Test
    public void HtmlEscaper() {
        System.out.println(HtmlEscapers.htmlEscaper().escape("      ' \">&<= "));
    }
}
