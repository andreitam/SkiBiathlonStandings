package com.andreitam;

import org.junit.Test;

import static org.junit.Assert.*;

public class AthleeteTest {

    @Test
    public void calculateResultTest() {
        Athleete athleete = new Athleete();
        athleete.setAthleteName("Umar Jorgson");
        athleete.setSkiResult("30:27");
        athleete.setFirstShootingRange("xxxox");
        athleete.setSecondShootingRange("xxxxx");
        athleete.setThirSdhootingeRange("xxoxo");
        athleete.calculateResult();
        assertEquals("00:30:57", athleete.getResult());
    }
}