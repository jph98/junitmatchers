package org.example.junitmatchers;

import static org.junit.Assert.assertThat;
import static org.junit.matchers.JUnitMatchers.containsString;

import org.example.domain.SWFigure;
import org.junit.BeforeClass;
import org.junit.Test;

public class TextMatchers {

 private static SWFigure figure;
    
    @BeforeClass
    public static void beforeTests() {
        figure = new SWFigure("Chewbacca", 200);
    }
    
    @Test
    public void assert_containsString() {
        assertThat(figure.getName(), containsString("bacca"));
    }       
}
