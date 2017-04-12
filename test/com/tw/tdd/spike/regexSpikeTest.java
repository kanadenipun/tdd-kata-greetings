package com.tw.tdd.spike;

import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class RegexSpikeTest {

    RegexSpike regexSpike = new RegexSpike();

    @Test
    public void shouldReturnNullStringIfInputIsNull() throws Exception {
        String expectedResult = "NULL";
        String nullString = null;
        String actualResult = regexSpike.nullTest(nullString);
        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void shouldMatchAnyCharacter() throws Exception {
        assertEquals(true,  regexSpike.matchersTest( "."    , "a"     ));
        assertEquals(true,  regexSpike.matchersTest( ".."   , "ab"    ));
        assertEquals(true,  regexSpike.matchersTest( "..."  , "xyz"   ));
        assertEquals(true,  regexSpike.matchersTest( ".*"   , "abczx" ));
        assertEquals(false, regexSpike.matchersTest( "..."  , "a"     ));
    }

    @Test
    public void shouldMatchDigits() throws Exception {
        assertEquals(true,  regexSpike.matchersTest("\\d",       "1"     ));
        assertEquals(true,  regexSpike.matchersTest("\\d\\d",    "12"    ));
        assertEquals(true,  regexSpike.matchersTest("\\dA\\d",   "1A3"   ));
        assertEquals(true,  regexSpike.matchersTest("\\d.\\d",   "1a3"   ));
        assertEquals(true,  regexSpike.matchersTest("\\d.*\\d",  "1aacf3"));
        assertEquals(false, regexSpike.matchersTest("\\d.*\\d", "1aacf" ));
    }

    @Test
    public void shouldMatchSpecificCharacters() throws Exception {
        assertEquals(true,  regexSpike.matchersTest( "[c]an",   "can"));
        assertEquals(true,  regexSpike.matchersTest( "[cm]an",  "man"));
        assertEquals(true,  regexSpike.matchersTest( "[cmf]an", "fan"));
        assertEquals(false, regexSpike.matchersTest("[cmf]an", "dan"));
    }

    @Test
    public void shouldExcludeSpecificCharacters() throws Exception {
        assertEquals(true,  regexSpike.matchersTest( "[^drp]an",  "can"));
        assertEquals(true,  regexSpike.matchersTest( "[^drp]an",  "man"));
        assertEquals(true,  regexSpike.matchersTest( "[^drp]an",  "fan"));
        assertEquals(false, regexSpike.matchersTest("[^drp]an",  "dan"));
    }

    @Test
    public void shouldMatchRangeOfAlphabets() throws Exception {
        assertEquals(true,  regexSpike.matchersTest( "[a-z]bc",          "abc"));
        assertEquals(true,  regexSpike.matchersTest( "[a-z][a-z]c",      "abc"));
        assertEquals(true,  regexSpike.matchersTest( "[a-z][a-z][a-z]",  "abc"));
        assertEquals(false, regexSpike.matchersTest( "[a-z][a-z][a-z]",  "aBc"));
        assertEquals(true,  regexSpike.matchersTest( "[a-z][A-Z][a-z]",  "aBc"));
        assertEquals(false, regexSpike.matchersTest( "[a-z][A-Z][a-z]",  "a.c"));
    }

    @Test
    public void shouldMatchRepeatingCharacters() throws Exception {
        assertEquals(true,  regexSpike.matchersTest( "wa.{1,10}up", "wazup"));
        assertEquals(false, regexSpike.matchersTest( "wa.{2,3}up",  "wazup"));
        assertEquals(true,  regexSpike.matchersTest( "wa.{1,10}up", "wazzzzzup"));
        assertEquals(true,  regexSpike.matchersTest( "qa\\d{6}A", "qa111222A"));
        assertEquals(true,  regexSpike.matchersTest( "qa\\d{6}A", "qa333444A"));
        assertEquals(true,  regexSpike.matchersTest( "qa\\d{1,6}A", "qa333444A"));
    }

    @Test
    public void shouldMatchOneOrMoreOccurances() throws Exception {
        assertEquals(true,  regexSpike.matchersTest( "wa[z]+up", "wazzzzzup"));
        assertEquals(false, regexSpike.matchersTest( "wa[z]+up", "waup"));
    }

    @Test
    public void shouldMatchZeroOrMoreOccurances() throws Exception {
        assertEquals(true,  regexSpike.matchersTest( "wa[z]*up", "wazzzzzup"));
        assertEquals(true,  regexSpike.matchersTest( "wa[z]*up", "waup"));
    }

    @Test
    public void shouldSkipOptionalOccurances() throws Exception {
        assertEquals(true,  regexSpike.matchersTest( "files?", "file"));
        assertEquals(true,  regexSpike.matchersTest( "files?", "files"));

        assertEquals(true,  regexSpike.matchersTest("\\d+ files? found\\?", "1 file found?"));
        assertEquals(true,  regexSpike.matchersTest("\\d+ files? found\\?", "10 files found?"));
        assertEquals(true,  regexSpike.matchersTest("\\d+ files? found\\?", "24 files found?"));
        assertEquals(false, regexSpike.matchersTest("\\d+ files? found\\?", "No files found?"));
    }

    @Test
    public void shouldSkipWhiteSpaces() throws Exception {
        assertEquals(true,  regexSpike.matchersTest( "\\d+\\.\\s+Hello", "1. Hello"));
        assertEquals(true,  regexSpike.matchersTest( "\\d+\\.\\s+Hello", "10. Hello"));
        assertEquals(true,  regexSpike.matchersTest( "\\d+\\.\\s+Hello", "100. Hello"));
        assertEquals(true,  regexSpike.matchersTest( "\\d+\\.\\s+Hello", "100.  Hello"));
        assertEquals(true,  regexSpike.matchersTest( "\\d+\\.\\s+Hello", "100.           Hello"));
        assertEquals(false, regexSpike.matchersTest( "\\d+\\.\\s+Hello", "100.Hello"));
        assertEquals(true,  regexSpike.matchersTest( "\\d+\\.\\s*Hello", "100.Hello"));
    }

    @Test
    public void shouldMatchRegexInStartOfString() throws Exception {
        assertEquals(true,  regexSpike.matchersTest("\\w*Hello World", "Hello World"));
        assertEquals(true,  regexSpike.matchersTest("\\w*Hello World", "otHello World"));

        assertEquals(true,  regexSpike.matchersTest("^Hello World", "Hello World"));
        assertEquals(false, regexSpike.matchersTest("^Hello World", "otHello World"));
    }

    @Test
    public void shouldCaptureGroups() throws Exception {
        ArrayList<String> output = (ArrayList<String>) regexSpike.groupTest("([a-z]*)","file_record_transcript.pdf");
        System.out.println("length : " + output.size());
        for(String s:output)
            System.out.println(s);
    }

}