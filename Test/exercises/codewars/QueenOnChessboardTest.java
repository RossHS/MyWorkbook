package exercises.codewars;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author Ross Khapilov
 * @version 1.0 created on 29.04.2018
 */
class QueenOnChessboardTest {

    @Test
    void incorrectTest() {
        assertEquals(QueenOnChessboard.availableMoves(null), new ArrayList<String>());
        assertEquals(QueenOnChessboard.availableMoves("work?"), new ArrayList<String>());
        assertEquals(QueenOnChessboard.availableMoves("A10"), new ArrayList<String>());
        assertEquals(QueenOnChessboard.availableMoves("B0"), new ArrayList<String>());
        assertEquals(QueenOnChessboard.availableMoves("2"), new ArrayList<String>());
    }

    @Test
    void Test() {
        assertEquals(QueenOnChessboard.availableMoves("A1"), Arrays.asList("A2", "A3", "A4", "A5", "A6", "A7",
                "A8", "B1", "B2", "C1", "C3", "D1", "D4", "E1", "E5", "F1", "F6", "G1", "G7", "H1", "H8"));

        assertEquals(QueenOnChessboard.availableMoves("C5"), Arrays.asList("A3", "A5", "A7", "B4", "B5", "B6",
                "C1", "C2", "C3", "C4", "C6", "C7", "C8", "D4", "D5", "D6", "E3", "E5", "E7", "F2", "F5", "F8",
                "G1", "G5", "H5"));

        assertEquals(QueenOnChessboard.availableMoves("H3"), Arrays.asList("A3", "B3", "C3", "C8", "D3", "D7",
                "E3", "E6", "F1", "F3", "F5", "G2", "G3", "G4", "H1", "H2", "H4", "H5", "H6", "H7", "H8"));

    }
}