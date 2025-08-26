package org.m3mpm;


import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        String str = "Hello World!";
        String strUni = "Привет мир! Привет!";
        printMap(countDuplicateCharacters2(strUni));
    }

    // Версия, которая не учитывает Unicode, то есть работает с UTF-16 - используя 16-битный тип char
    public static Map<Character,Integer> countDuplicateCharacters1(String str){
        Map<Character,Integer> result = new HashMap<>();
        for(int i = 0; i < str.length(); i++){
            char ch = str.charAt(i);
            result.compute(ch,(k,v) -> v==null ? 1 : ++v);
        }
        return result;
    }

    public static Map<Character,Long> countDuplicateCharactersStream1(String str){
        Map<Character,Long> result = str.chars().mapToObj(ch -> (char) ch).collect(Collectors.groupingBy(ch -> ch,Collectors.counting()));
        return result;
    }

    // Версия, которая учитывает Unicode, то есть работает с UTF-32
    public static Map<String, Integer> countDuplicateCharacters2(String str) {
        Map<String, Integer> result = new HashMap<>();
        for (int i = 0; i < str.length(); i++) {
            int cp = str.codePointAt(i);
            String ch = String.valueOf(Character.toChars(cp));
            if (Character.charCount(cp) == 2) { // 2 означает суррогатную пару
                i++;
            }
            result.compute(ch, (k, v) -> (v == null) ? 1 : ++v);
        }
        return result;
    }

    public static Map<String, Long> countDuplicateCharactersStream2(String str) {
        Map<String, Long> result = str.codePoints()
                .mapToObj (c -> String.valueOf(Character.toChars (c)))
                .collect(Collectors.groupingBy(c -> c, Collectors.counting()));
        return result;
    }

    public static void printMap(Map<?,?> map){
        StringBuilder sb = new StringBuilder("Содержимое Map:\n");
        for(Map.Entry<?,?> entry: map.entrySet()){
            sb.append("Ключ: ").append(entry.getKey()).append(", Значение: ").append(entry.getValue()).append("\n");
        }
        System.out.println(sb);
    }

}

