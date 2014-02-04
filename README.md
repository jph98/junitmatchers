JUnitRecipes
============

This project's purpose is to function as a best practices guide to writing JUnit tests
whilst providing a comprehensive set of examples for using Hamcrest matchers with tests.

Hamcrest: http://code.google.com/p/hamcrest/wiki/Tutorial

Simple Matchers
---------------

is:

    assertThat(figure.getAge(), is(200));
  
not:
    assertThat(figure.getAge(), not(300));
    
anyOf:

    assertThat(figure.getName(), is(anyOf(equalTo("Chewie"), equalTo("Chewbacca"))));

allOf:

     assertThat(figure.getAge(), is(allOf(equalTo(200), equalTo(100+100))));

equalTo and notEqualTo:

     assertThat(figure.getName(), is(equalTo("Chewbacca")));
     
notNullValue:

     assertThat(figure.getName(), is(notNullValue()));
     
hasProperty:

     assertThat(figure, hasProperty("name"));
     assertThat(figure, not(hasProperty("num")));

containsString:

     assertThat(figure.getName(), containsString("bacca"));
     
Collection hasItem and hasItems:

    assertThat(vehicle.getFigures(), hasItem(chewie));
    assertThat(vehicle.getFigures(), hasItems(chewie, wicket));
    
containsInOrder:
  
    assertThat("Vehicle contains figures in order", vehicle.getFigures(), contains(chewie, wicket, han));
    
hasSize:

    assertThat(vehicle.getFigures(), hasSize(3));
    
either or:

    assertThat(vehicle.getFigures(), either(hasItem(chewie)).
                                         or(hasItem(wicket)));
                                         
both and:

    assertThat(vehicle.getFigures(), both(hasItem(chewie)).
                                         and(hasItem(wicket)));
