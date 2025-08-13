package org.m3mpm.ver1;


import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        String str = "Hello World!";
        printMap(countDuplicateCharacters(str));
    }

    // Версия, которая не учитывает Unicode, то есть работает с UTF-16 - используя 16-битный тип char
    public static Map<Character,Integer> countDuplicateCharacters(String str){
        Map<Character,Integer> result = new HashMap<>();
        for(int i = 0; i < str.length(); i++){
            char ch = str.charAt(i);
            result.compute(ch,(k,v) -> v==null ? 1 : ++v);
        }
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

    public static void printMap(Map<Character,Integer> map){
        StringBuilder sb = new StringBuilder("Содержимое Map:\n");
        for(Map.Entry<Character,Integer> entry: map.entrySet()){
            sb.append("Ключ: ").append(entry.getKey()).append(", Значение: ").append(entry.getValue()).append("\n");
        }
        System.out.println(sb);
    }
}

