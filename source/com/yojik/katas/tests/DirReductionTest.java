package com.yojik.katas.tests;

import com.yojik.katas.solutions.DirReduction;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;


public class DirReductionTest {

    @Test
    public void testSimpleDirReduc() {
        assertArrayEquals(new String[]{"WEST"}
                ,DirReduction.dirReduc(new String[]{"NORTH", "SOUTH", "SOUTH", "EAST", "WEST", "NORTH", "WEST"})
                ,"\"NORTH\", \"SOUTH\", \"SOUTH\", \"EAST\", \"WEST\", \"NORTH\", \"WEST\"");
        assertArrayEquals(new String[]{}
                ,DirReduction.dirReduc(new String[]{"NORTH","SOUTH","SOUTH","EAST","WEST","NORTH"})
                ,"\"NORTH\",\"SOUTH\",\"SOUTH\",\"EAST\",\"WEST\",\"NORTH\"");
        assertArrayEquals(new String[]{}
                ,DirReduction.dirReduc(new String[]{})
                ,"");

        assertArrayEquals(new String[]{"NORTH", "EAST"}
                ,DirReduction.dirReduc(new String[]{"NORTH", "EAST", "NORTH", "EAST", "WEST", "WEST", "EAST", "EAST", "WEST", "SOUTH"})
                ,"\"NORTH\", \"EAST\", \"NORTH\", \"EAST\", \"WEST\", \"WEST\", \"EAST\", \"EAST\", \"WEST\", \"SOUTH\"");



    }
}
