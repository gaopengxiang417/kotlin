package com.gao;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * User: wangchen
 * Date: 2017/4/7
 * Time: 14:42
 */
public interface InterfaceA {

    public static void main(String[] args) {

        List<String> phrases = Arrays.asList(
            "1 5",
            "3 6",
            "2 5",
            "2");

        List<Integer> uniqueWords = phrases
            .stream()
            .flatMap(phrase -> Stream.of(phrase.split(" +")))
            .map(s -> Integer.valueOf(s))
            .sorted()
            .collect(Collectors.toList());
        System.out.println("Unique words: " + uniqueWords);
    }
}
