package org.example.junitmatchers;

import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.anyOf;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasProperty;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.not;
import static org.hamcrest.Matchers.notNullValue;
import static org.junit.Assert.assertThat;

import org.example.domain.SWFigure;
import org.junit.BeforeClass;
import org.junit.Test;

public class SimpleMatchers {

    private static SWFigure figure;
    
    @BeforeClass
    public static void beforeTests() {
        figure = new SWFigure("Chewbacca", 200);
    }       
    
    @Test
    public void assert_anyof() {
        assertThat(figure.getName(), is(anyOf(equalTo("Chewie"), equalTo("Chewbacca"))));
    }
    
    @Test
    public void assert_allof() {
        // stupid example
        assertThat(figure.getAge(), is(allOf(equalTo(200), equalTo(100+100))));
    }
    
    @Test
    public void assert_is() {
        assertThat(figure.getAge(), is(200));
    }
    
    @Test
    public void assert_not() {
        assertThat(figure.getAge(), not(300));
    }
    
    @Test
    public void assert_isEqualTo() {
        assertThat(figure.getName(), is(equalTo("Chewbacca")));
    }
    
    @Test
    public void assert_isNotEqualTo() {
        assertThat(figure.getName(), is(not(equalTo("Han Solo"))));
    }
    
    @Test
    public void assert_isNotNullValue() {
        assertThat(figure.getName(), is(notNullValue()));
    }
    
    @Test
    public void assert_hasProperty() {
        assertThat(figure, hasProperty("name"));
        assertThat(figure, hasProperty("age"));
        assertThat(figure, not(hasProperty("num")));
    }
    
    @Test
    public void assert_hasToString() {
        //? 
    }
        
}
