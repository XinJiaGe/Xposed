package com.jiage.xposed;

import com.jiage.xposed.http.InterfaceServer;
import com.jiage.xposed.model.RequestBase;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    @Test
    public void addition_isCorrect() throws Exception {
        assertEquals(4, 2 + 2);
        String resout = new Send().sendGet("http://lovegood.zicp.vip/text_war_exploded/AddNovel",
                "type=3&name=" + "" + "&simple=" + "" + "&content= &label= &thumbnail=" + "" + "&j=0");
    }
}