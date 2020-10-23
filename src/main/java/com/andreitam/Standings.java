package com.andreitam;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
/**
 * The class Standings contains static methods to read .csv and return a List of Athleete.
 *
 * @author  Andrei Tamasanu
 * @version 1.0
 * @since   2020-10-23
 */
public class Standings {
    /**
     * Method for reading a .csv file with Biathlon standings
     * and returning a list of strings with athleete and their data
     *
     * @param file - the path of the .csv file
     * @return List<String> filled with athleete data
     */
    public static List<String> getAthleetsFromCsv(Path file) {
        List<String> stringAthleets = new ArrayList<>();
        Charset charset = Charset.forName("UTF8");
        try (BufferedReader reader = Files.newBufferedReader(file, charset)) {
            String line = null;
            while ((line = reader.readLine()) != null) {
                stringAthleets.add(line);

            }
        } catch (IOException x) {
            System.err.println("IOException: "+ x);
        }
        return stringAthleets;
    }
    /**
     * Method for mapping athleete data to a Athleete instance
     *
     * @param athleeteString - String with athleete data
     * @return Athleete an instance with fields containg athleete data
     */
    public static Athleete convertStringToAthleete(String athleeteString) {
        String[] athleeteProperties = athleeteString.split(",");
        Athleete athleete = new Athleete();
        athleete.setAthleteNumber(athleeteProperties[0]);
        athleete.setAthleteName(athleeteProperties[1]);
        athleete.setCountryCode(athleeteProperties[2]);
        athleete.setSkiResult(athleeteProperties[3]);
        athleete.setFirstShootingRange(athleeteProperties[4]);
        athleete.setSecondShootingRange(athleeteProperties[5]);
        athleete.setThirSdhootingeRange(athleeteProperties[6]);
        return athleete;
    }
    /**
     * Takes a List<String> with athleete data from the .csv file
     * and writes a List<Athleete> with athleets objects.
     *
     * @param list<String> list - parsed from the .csv file
     * @return List<Athleete> returned list with athleete objects
     */
    public static List<Athleete> convertToAthleetesList(List<String> list) {
        List<Athleete> athleets = new ArrayList<>();
        for (String s: list) {
            athleets.add(convertStringToAthleete(s));
        }
        return athleets;
    }
}
