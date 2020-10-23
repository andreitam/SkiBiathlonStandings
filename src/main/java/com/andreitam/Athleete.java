package com.andreitam;

import java.time.LocalTime;
import java.util.Objects;
/**
 * The class Athleete contains the info from the Standings
 * and calculates the result with method calculateResult().
 * Implements Comparable to sort depending on Result
 *
 * @author  Andrei Tamasanu
 * @version 1.0
 * @since   2020-10-23
 */
public class Athleete implements Comparable<Athleete> {
    private String AthleteNumber;
    private String AthleteName;
    private String CountryCode;
    private String SkiResult; //Minutes:Seconds
    private LocalTime SkiTimeResut;
    private String FirstShootingRange;
    private String SecondShootingRange;
    private String ThirdShootingeRange;
    private LocalTime TimeResult;
    private String Result;

    public String getAthleteNumber() {
        return AthleteNumber;
    }

    public String getAthleteName() {
        return AthleteName;
    }

    public String getCountryCode() {
        return CountryCode;
    }

    public String getSkiResult() {
        return SkiResult;
    }

    public String getFirstShootingRange() {
        return FirstShootingRange;
    }

    public String getSecondShootingRange() {
        return SecondShootingRange;
    }

    public String getThirSdhootingeRange() {
        return ThirdShootingeRange;
    }

    public String getResult() {
        return Result;
    }

    public void setAthleteNumber(String athleteNumber) {
        AthleteNumber = athleteNumber;
    }

    public void setAthleteName(String athleteName) {
        AthleteName = athleteName;
    }

    public void setCountryCode(String countryCode) {
        CountryCode = countryCode;
    }

    public void setSkiResult(String skiResult) {
        SkiResult = skiResult;
    }

    public void setFirstShootingRange(String firstShootingRange) {
        FirstShootingRange = firstShootingRange;
    }

    public void setSecondShootingRange(String secondShootingRange) {
        SecondShootingRange = secondShootingRange;
    }

    public void setThirSdhootingeRange(String thirSdhootingeRange) {
        ThirdShootingeRange = thirSdhootingeRange;
    }

    public void calculateResult() {
        //convert to LocalTime
        String[] tempTime = this.SkiResult.split(":");
        SkiTimeResut = LocalTime.of(0,Integer.parseInt(tempTime[0]), Integer.parseInt(tempTime[1]));
        //evaluate miss shootings
        int miss = countShootings(this.FirstShootingRange) + countShootings(this.SecondShootingRange) + countShootings(this.ThirdShootingeRange);
        TimeResult = SkiTimeResut.plusSeconds(miss*10);
        Result = TimeResult.toString();
    }

    private int countShootings(String shooting) {
        int count=0;
        for(int i=0; i<shooting.length(); i++) {
            if(shooting.charAt(i) == 'o') {
                count++;
            }
        } return count;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Athleete athleete = (Athleete) o;
        return Objects.equals(AthleteNumber, athleete.AthleteNumber) &&
                Objects.equals(AthleteName, athleete.AthleteName) &&
                Objects.equals(CountryCode, athleete.CountryCode) &&
                Objects.equals(SkiResult, athleete.SkiResult) &&
                Objects.equals(SkiTimeResut, athleete.SkiTimeResut) &&
                Objects.equals(FirstShootingRange, athleete.FirstShootingRange) &&
                Objects.equals(SecondShootingRange, athleete.SecondShootingRange) &&
                Objects.equals(ThirdShootingeRange, athleete.ThirdShootingeRange) &&
                Objects.equals(TimeResult, athleete.TimeResult) &&
                Objects.equals(Result, athleete.Result);
    }

    @Override
    public int hashCode() {
        return Objects.hash(AthleteNumber, AthleteName, CountryCode, SkiResult, SkiTimeResut, FirstShootingRange, SecondShootingRange, ThirdShootingeRange, TimeResult, Result);
    }

    @Override
    public int compareTo(Athleete a) {
        return this.Result.compareTo(a.getResult());
    }

    @Override
    public String toString() {
        return AthleteName +" "+Result;
    }
}
