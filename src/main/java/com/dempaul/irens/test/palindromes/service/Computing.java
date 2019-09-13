package com.dempaul.irens.test.palindromes.service;

import com.dempaul.irens.test.palindromes.entity.ParentNumber;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

@Service
public class Computing {

    public List<String> findPalindromes(ParentNumber parentNumber) {
        List<String> palindromes = new ArrayList<>();
        String stringNumber = parentNumber.getValue();
        int numOfPalindromes = parentNumber.getNumberOfPalindromes();

        String palindrome = findFirstPalindrome(stringNumber);
        while (numOfPalindromes > 0) {
            palindromes.add(palindrome);
            numOfPalindromes--;
            palindrome = getNextPalindrome(String.valueOf(palindrome));
        }
        return palindromes;
    }

    private static String findFirstPalindrome(String string) {
        if (string.length() == 1 || isPalindrome(string)) {
            return string;
        } else {
            String middle = "";
            String tail;
            BigInteger middleNum = new BigInteger("0");
            if (string.length() % 2 == 1) {
                middle = string.substring(string.length() / 2, (string.length() / 2) + 1);
                middleNum = new BigInteger(middle);
                tail = string.substring(string.length() / 2 + 1);
            } else {
                tail = string.substring(string.length() / 2);
            }
            String head = string.substring(0, string.length() / 2);
            BigInteger headNum = new BigInteger(head);
            BigInteger tailNum = new BigInteger(reverse(tail));

            if ((headNum.compareTo(tailNum) < 0) && (middle.equals(""))) {
                headNum = headNum.add(BigInteger.ONE);
            } else if (((headNum.compareTo(tailNum) < 0) && (middle.equals("9")))) {
                middle = "0";
                headNum = headNum.add(BigInteger.ONE);
            } else if ((headNum.compareTo(tailNum) < 0) && (Character.isDigit(middle.charAt(0)))) {
                middleNum = middleNum.add(BigInteger.ONE);
                middle = String.valueOf(middleNum);
            }
            tailNum = headNum;
            return headNum + middle + reverse(String.valueOf(tailNum));
        }
    }

    private static String getNextPalindrome(String palindrome) {
        if (allIsNine(palindrome)) {
            BigInteger firstPart = new BigInteger(palindrome);
            firstPart = firstPart.add(BigInteger.ONE).add(BigInteger.ONE);
            palindrome = String.valueOf(firstPart);
        } else if (palindrome.length() % 2 == 0) {
            BigInteger firstPart = new BigInteger(palindrome.substring(0, palindrome.length() / 2));
            firstPart = firstPart.add(BigInteger.ONE);
            palindrome = String.valueOf(firstPart).concat(reverse(String.valueOf(firstPart)));
        } else {
            BigInteger firstPart = new BigInteger(palindrome.substring(0, (palindrome.length() / 2) + 1));
            firstPart = firstPart.add(BigInteger.ONE);
            palindrome = String.valueOf(firstPart).concat(reverse(String.valueOf(firstPart).substring(0, String.valueOf(firstPart).length() - 1)));
        }

        return palindrome;
    }

    private static boolean isPalindrome(String string) {
        return string.equals(reverse(string));
    }

    private static String reverse(String input) {
        char[] in = input.toCharArray();
        int begin = 0;
        int end = in.length - 1;
        char temp;
        while (end > begin) {
            temp = in[begin];
            in[begin] = in[end];
            in[end] = temp;
            end--;
            begin++;
        }
        return new String(in);
    }

    private static boolean allIsNine(String string) {
        char[] chars = string.toCharArray();
        for (char character : chars) {
            if (character != '9') {
                return false;
            }
        }
        return true;
    }
}
