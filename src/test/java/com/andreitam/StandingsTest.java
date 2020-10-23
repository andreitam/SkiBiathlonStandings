package com.andreitam;

import org.junit.Test;

import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.*;

public class StandingsTest {

    @Test
    public void testStandings() {
        //get path
        Path file = FileSystems.getDefault().getPath("Standings.csv");
        //parse .csv from path
        List<String> athleets = Standings.getAthleetsFromCsv(file);
        for (String s: athleets) {
            System.out.println(s);
        }
        System.out.println(" ");
        //test we have 4 entries
        assertEquals(athleets.size(), 4);

        //convert to list of athleets and calculate results for each athleete object
        List<Athleete> athleetsObjects = Standings.convertToAthleetesList(athleets);
        for (Athleete a: athleetsObjects) {
            a.calculateResult();
            System.out.println(a.toString());
        }
        System.out.println(" ");
        //sort the list depending on result
        Collections.sort(athleetsObjects);
        for (Athleete a: athleetsObjects) {
            System.out.println(a.toString());
        }
        //test List is sorted in correct order and winner
        assertEquals(athleetsObjects.get(0).toString(), "Piotr Smitzer 00:30:10");
        assertEquals(athleetsObjects.get(1).toString(), "Jimmy Smiles 00:30:15");
        assertEquals(athleetsObjects.get(2).toString(), "Umar Jorgson 00:30:57");
        assertEquals(athleetsObjects.get(3).toString(), "Andrei Tamasanu 00:32:11");
    }
}