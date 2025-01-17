package com.example.lab8;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;


//import org.junit.Before;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class CustomListTest {
    private CustomList list;
    /**
     * create a mocklist for my citylist
     * @return
     */
    public CustomList MockCityList(){
        list = new CustomList(null,new ArrayList<>());
        return list;
    }

    /**
     * get the size of the list
     * increase the list by adding a new city
     * check if our current size matches the initial size
     plus one
     */
    @Test
    public void addCityTest(){
        list = MockCityList();
        int listSize = list.getCount();
        list.addCity(new City("Estevan", "SK"));
        assertEquals(list.getCount(),listSize + 1);
    }
    @Test
    public void hasCity(){
        list = MockCityList();
        City city = new City("Charlottetown", "Prince Edward Island");
        list.addCity(city);
        assertTrue(list.hasCity(city));
    }
    @Test
    void testDeleteCity() {
        list = MockCityList();
        City city = new City("Yellowknife", "Northwest Territories");
        City city2 = new City("Calgary", "Alberta");
        City city3 = new City("Charlottetown", "Prince Edward Island");
        list.addCity(city);
        list.delete(city);
        assertThrows(IllegalArgumentException.class, () -> {
            list.delete(city2);
        });
    }
    @Test
    void testCountCities() {
        list = MockCityList();
        City city2 = new City("Charlottetown", "Prince Edward Island");
        City city3 = new City("Calgary", "Alberta");
        list.addCity(city2);
        list.addCity(city3);
        assertEquals(list.countCities(), 2);
    }

}
