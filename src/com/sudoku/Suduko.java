package com.sudoku;

import sun.rmi.runtime.Log;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * Created by Dayanithi on 08-Jul-17.
 */

public class Suduko {
    static int initialI = 0, inirialJ = 0;

    static Set<Integer> set = new HashSet<>();
    static int[][] board =
            {{6, 3, 2, 7, 8, 1, 9, 4, 5},
                    {4, 8, 7, 5, 9, 6, 2, 1, 3},
                    {5, 1, 9, 2, 4, 3, 8, 7, 6},
                    {8, 6, 4, 3, 5, 2, 7, 9, 1},
                    {7, 5, 1, 9, 6, 8, 3, 2, 4},
                    {2, 9, 3, 1, 7, 4, 6, 5, 8},
                    {9, 4, 5, 6, 3, 7, 1, 8, 2},
                    {1, 7, 6, 8, 2, 5, 4, 3, 9},
                    {3, 2, 8, 4, 1, 9, 5, 6, 7}};

    public static void main(String args[]) {


        if (isValidSudokuDaya(board)) {
            System.out.println("valid");
        } else {
            System.out.println("not valid");
        }
    }


    public static boolean isValidSudokuDaya(int[][] board) {
//check for row
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (j != 8) {
                    if (board[i][j] == board[i][j + 1]) {
                        System.out.print("invalid row"+i+","+j);
                        return false;
                    }
                } else if (j == 8) {
                    if (board[i][j] == board[i][7]) {
                        System.out.print("invalid row"+i+","+j);

                        return false;
                    }
                } else {
                    return true;
                }
            }
        }
        //check for coloumn
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (i != 8) {
                    if (board[i][j] == board[i+1][j]) {
                        System.out.print("invalid col"+i+","+j);

                        return false;
                    }
                } else if (i == 8) {
                    if (board[i][j] == board[7][j]) {
                        System.out.print("invalid col"+i+","+j);

                        return false;
                    }
                } else {
                    return true;
                }
            }
        }
        if (checkForMatrix(board)) {
            return true;
        } else {
            return false;
        }

    }

    private static boolean checkForMatrix(int[][] board) {
        for (int i=initialI; i < initialI + 3; i++) {
            for (int j = inirialJ; j < inirialJ + 3; j++) {
                if (set.contains(board[j][i])) {
                    System.out.print("invalid col"+i+","+j);
                    return false;
                } else {
                    set.add(board[j][i]);

                }
            }
        }
        if (inirialJ <= 8) {
            inirialJ = inirialJ + 2;
            set.clear();
            checkForMatrix(board);
        } else if (initialI <= 8) {
            inirialJ = 0;
            initialI = initialI + 2;
            set.clear();
            checkForMatrix(board);
        } else {
            return true;
        }

        return true;

    }
}
