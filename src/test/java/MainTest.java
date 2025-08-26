import org.junit.jupiter.api.Test;
import org.m3mpm.Main;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MainTest {

    @Test
    public void testCountDuplicateCharacters() {
        String input = "Hello World!";

        Map<Character, Integer> expected1 = Map.of(
                'H', 1,
                'e', 1,
                'l', 3,
                'o', 2,
                ' ', 1,
                'W', 1,
                'r', 1,
                'd', 1,
                '!', 1
        );

        Map<Character, Long> expected2 = Map.of(
                'H', 1L,
                'e', 1L,
                'l', 3L,
                'o', 2L,
                ' ', 1L,
                'W', 1L,
                'r', 1L,
                'd', 1L,
                '!', 1L
        );



        Map<Character, Integer> result1 = Main.countDuplicateCharacters1(input);
        assertEquals(expected1, result1);
        Map<Character, Long> result2 = Main.countDuplicateCharactersStream1(input);
        assertEquals(expected2, result2);

    }

    @Test
    public void testCountDuplicateCharactersWithUnicode() {
        String input = "Привет мир! Привет!";

        Map<String, Integer> expected1= Map.of(
                "П", 2,
                "р", 3,
                "и", 3,
                "в", 2,
                "е", 2,
                "т", 2,
                " ", 2,
                "м", 1,
                "!", 2
        );

        Map<String, Long> expected2 = Map.of(
                "П", 2L,
                "р", 3L,
                "и", 3L,
                "в", 2L,
                "е", 2L,
                "т", 2L,
                " ", 2L,
                "м", 1L,
                "!", 2L
        );

        Map<String, Integer> result1 = Main.countDuplicateCharacters2(input);
        assertEquals(expected1, result1);
        Map<String,Long> result2 = Main.countDuplicateCharactersStream2(input);
        assertEquals(expected2, result2);

    }

    @Test
    public void testCountDuplicateCharactersEmptyString(){
        String input = "";

        Map<Character, Integer> expected1 = Map.of();
        Map<Character, Long> expected2 = Map.of();
        Map<String, Integer> expected3 = Map.of();
        Map<String, Long> expected4 = Map.of();

        Map<Character, Integer> result1 = Main.countDuplicateCharacters1(input);
        assertEquals(expected1, result1);
        Map<Character, Long> result2 = Main.countDuplicateCharactersStream1(input);
        assertEquals(expected2, result2);
        Map<String, Integer> result3 = Main.countDuplicateCharacters2(input);
        assertEquals(expected3, result3);
        Map<String,Long> result4 = Main.countDuplicateCharactersStream2(input);
        assertEquals(expected4, result4);
    }

    @Test
    public void testCountDuplicateCharactersSingleCharacter() {
        String input = "A";
        Map<Character, Integer> expected1 = Map.of('A', 1);
        Map<Character, Long> expected2 = Map.of('A', 1L);

        Map<Character, Integer> result1 = Main.countDuplicateCharacters1(input);
        assertEquals(expected1, result1);
        Map<Character, Long> result2 = Main.countDuplicateCharactersStream1(input);
        assertEquals(expected2, result2);
    }

    @Test
    public void testCountDuplicateCharactersSingleCharacterUnicode() {
        String input = "В";
        Map<String, Integer> expected1 = Map.of("В", 1);
        Map<String, Long> expected2 = Map.of("В", 1L);

        Map<String, Integer> result1 = Main.countDuplicateCharacters2(input);
        assertEquals(expected1, result1);
        Map<String,Long> result2 = Main.countDuplicateCharactersStream2(input);
        assertEquals(expected2, result2);
    }

    @Test
    public void testCountDuplicateCharactersWithSpecialCharacters() {
        String input = "!!!@@@###";

        Map<Character, Integer> expected1 = Map.of(
                '!', 3,
                '@', 3,
                '#', 3
        );

        Map<Character, Long> expected2 = Map.of(
                '!', 3L,
                '@', 3L,
                '#', 3L
        );

        Map<String, Integer> expected3 = Map.of(
                "!", 3,
                "@", 3,
                "#", 3
        );

        Map<String, Long> expected4 = Map.of(
                "!", 3L,
                "@", 3L,
                "#", 3L
        );

        Map<Character, Integer> result1 = Main.countDuplicateCharacters1(input);
        assertEquals(expected1, result1);
        Map<Character, Long> result2 = Main.countDuplicateCharactersStream1(input);
        assertEquals(expected2, result2);
        Map<String, Integer> result3 = Main.countDuplicateCharacters2(input);
        assertEquals(expected3, result3);
        Map<String,Long> result4 = Main.countDuplicateCharactersStream2(input);
        assertEquals(expected4, result4);
    }

}
