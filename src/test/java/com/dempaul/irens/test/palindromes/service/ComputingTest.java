package com.dempaul.irens.test.palindromes.service;

import com.dempaul.irens.test.palindromes.entity.ParentNumber;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class ComputingTest {

    private Computing computing = new Computing();

    private ParentNumber parentNumber1 = new ParentNumber("1", 3);
    private ParentNumber parentNumber2 = new ParentNumber("9", 4);
    private ParentNumber parentNumber3 = new ParentNumber("100", 12);
    private ParentNumber parentNumber4 = new ParentNumber("9880", 20);
    private ParentNumber parentNumber5 = new ParentNumber("980", 5);

    @Test
    public void testFirstFindPalindromes() {
        List<String> expected = Arrays.asList("1", "2", "3");

        List<String> actual = computing.findPalindromes(parentNumber1);
        assertThat(actual, is(expected));
    }

    @Test
    public void testSecondFindPalindromes() {
        List<String> expected = Arrays.asList("9", "11", "22", "33");

        List<String> actual = computing.findPalindromes(parentNumber2);
        assertThat(actual, is(expected));
    }

    @Test
    public void testThirdFindPalindromes() {
        List<String> expected = Arrays.asList(
                "101", "111", "121", "131", "141", "151",
                "161", "171", "181", "191", "202", "212");

        List<String> actual = computing.findPalindromes(parentNumber3);
        assertThat(actual, is(expected));
    }

    @Test
    public void testFourthFindPalindromes() {
        List<String> expected = Arrays.asList(
                "9889", "9999", "10001", "10101", "10201",
                "10301", "10401", "10501", "10601", "10701",
                "10801", "10901", "11011", "11111", "11211",
                "11311", "11411", "11511", "11611", "11711");

        List<String> actual = computing.findPalindromes(parentNumber4);
        assertThat(actual, is(expected));
    }

    @Test
    public void testFifthFindPalindromes() {
        List<String> expected = Arrays.asList(
                "989", "999", "1001", "1111", "1221");

        List<String> actual = computing.findPalindromes(parentNumber5);
        assertThat(actual, is(expected));
    }
}