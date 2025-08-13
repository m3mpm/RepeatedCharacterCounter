package org.m3mpm.ver2;


import java.util.Map;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        String str = "Hello World!";
        printMap(countDuplicateCharacters(str));
    }

    // Версия, которая не учитывает Unicode, то есть работает с UTF-16 - используя 16-битный тип char
    public static Map<Character,Long> countDuplicateCharacters(String str){
        Map<Character,Long> result = str.chars().mapToObj(ch -> (char) ch).collect(Collectors.groupingBy(ch -> ch,Collectors.counting()));
        return result;
    }

    // Версия, которая учитывает Unicode, то есть работает с UTF-32
    public static Map<String, Long> countDuplicateCharacters2(String str) {
        Map<String, Long> result = str.codePoints()
                .mapToObj (c -> String.valueOf(Character.toChars (c)))
                .collect(Collectors.groupingBy(c -> c, Collectors.counting()));
        return result;
    }

    public static void printMap(Map<Character,Long> map){
        StringBuilder sb = new StringBuilder("Содержимое Map:\n");
        map.entrySet().stream().
                forEach(entry -> sb.append("Ключ: ").append(entry.getKey()).append(", Значение: ").append(entry.getValue()).append("\n"));
        System.out.println(sb);
    }

}

