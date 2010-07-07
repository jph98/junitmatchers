package org.example.junitmatchers;

import static org.hamcrest.Matchers.both;
import static org.hamcrest.Matchers.contains;
import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.hamcrest.Matchers.either;
import static org.hamcrest.Matchers.hasProperty;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;
import static org.hamcrest.Matchers.sameInstance;
import static org.junit.Assert.assertThat;
import static org.junit.matchers.JUnitMatchers.everyItem;
import static org.junit.matchers.JUnitMatchers.hasItem;
import static org.junit.matchers.JUnitMatchers.hasItems;

import java.util.Arrays;
import java.util.List;

import org.example.domain.SWFigure;
import org.example.domain.SWVehicle;
import org.junit.BeforeClass;
import org.junit.Test;

public class CollectionMatchers {

    private static SWVehicle vehicle;
    private static SWFigure chewie;
    private static SWFigure wicket;
    private static SWFigure han;
    
    @BeforeClass
    public static void beforeTests() {
        chewie = new SWFigure("Chewbacca", 200);
        wicket = new SWFigure("Wicket", 10);
        han = new SWFigure("Han Solo", 10);
        
        vehicle = new SWVehicle("AT-AT");
        vehicle.setFigures(Arrays.asList(chewie, wicket, han));
    }
    
    @Test
    public void assert_hasItem() {
        assertThat(vehicle.getFigures(), hasItem(chewie));
    }       
    
    @Test
    public void assert_hasItems() {
        assertThat(vehicle.getFigures(), hasItems(chewie, wicket));
    }
    
    @Test
    public void assert_contains() {               
        // Same as above but use contains (horribly based on insertion order with list)
        assertThat("Vehicle contains figures in order", vehicle.getFigures(), contains(chewie, wicket, han));
    }       
    
    @Test
    public void assert_containsInAnyOrder() {               
        assertThat("Vehicle contains figures in order", vehicle.getFigures(), containsInAnyOrder(chewie, han, wicket));
    }    
        
    @Test
    public void assert_hasSize() {
        assertThat(vehicle.getFigures(), hasSize(3));
    }
    
    @Test
    public void assert_everyItem_hasProperty() {
        List<SWFigure> figures = vehicle.getFigures();
        // ?
    }
    
    @Test
    public void assert_either_or() {
        assertThat(vehicle.getFigures(), either(hasItem(chewie)).
                                         or(hasItem(wicket)));
    }
    
    @Test
    public void assert_both_and() {
        assertThat(vehicle.getFigures(), both(hasItem(chewie)).
                                         and(hasItem(wicket)));
    }    
    
    @Test
    public void assert_isSameInstance() {
        SWFigure otherChewie = vehicle.getFigureByName("Chewbacca");
        assertThat(chewie, is(sameInstance(otherChewie)));
    }
    
    
}
