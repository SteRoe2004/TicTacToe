package de.main;

public class TTT {


  private char[][] board;
    private char currentPlayerMark;

    // Funktionen
    public TTT() {
    board = new char[3][3];
    currentPlayerMark ='x';
    initializeBoard();
}

    public void initializeBoard() {
        //Schleife, die drei Spalten in drei Zeilen initialisiert
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = '-';
            }
        }
    }

    // Schleife: Initialisierung der Laufvariablen i, Bedeingung der Schleife, Nachaktion (was soll nach Schleifendurchlauf passieren)
    // Nach kompletter Ausführung der inneren Schleife wird die äußere Schleife angepasst
    public void printBoard() {
        System.out.println("-------------");
        for (int i = 0; i < 3; i++) {
            System.out.print("| ");     // <- das passiert
            for (int j = 0; j < 3; j++) {
                System.out.print(board[i][j] + " | ");
            }
            System.out.println();
            System.out.println("-------------");        // bis hier geht in innnere Bearbeitung
        }
    }

    public boolean isBoardFull() {
        boolean isFull = true;

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == '-') {
                    isFull = false;
                }
            }
        }

        return isFull;
    }

    public boolean checkForWin() {
        return checkRowsForWin() || checkColumnsForWin() || checkDiagonalsForWin(); // || = oder
    }

    // Hilfsmethoden, die nicht nach außen sichtbar werden
    public boolean checkRowsForWin() {
        for (int i = 0; i < 3; i++) {
            if (checkRowCol(board[i][0], board[i][1], board[i][2])) { // Methode zum prüfen wo wir sind
                return true;
            }
        }
        return false;
    }

    private boolean checkColumnsForWin() {
        for (int j = 0; j < 3; j++) {
            if (checkRowCol(board[0][j], board[1][j], board[2][j])) { // Methode zum prüfen wo wir sind
                return true;
            }
        }
        return false;
    }

    private boolean checkDiagonalsForWin() {
        return (checkRowCol(board[0][0], board[1][1], board[2][2])) || checkRowCol(board[0][2], board[1][1], board[2][0]);
    }

    // Hilfsmethode, auf die die oberen Hilfsmethoden zurückgreifen, um einen Sieg festzustellen
    private boolean checkRowCol(char c1, char c2, char c3) {
        if (c1 != '-') { // wenn erste bedingung nciht erfüllt wurde geht es ohnehin nicht weiter
            if (c1 == c2) {
                if (c2 == c3) {
                    return true;
                }
            }
        }
        return false; // Methode zum Prüfen des Sieges
        // Alle Hilfsmethiden beidienen sich dieser zum prüfen der verschiedenen Siegbedingungen --> keine Zuweisung zu Zeilen, Spalten, Diagonale
    }

    public void changePlayer() { // neue Methode für Spielerwechsel
        if (currentPlayerMark == 'x') {
            currentPlayerMark = 'o';
        } else {
            currentPlayerMark = 'x';
        }
    }

    public boolean placeMark(int row, int col) {
        if ((row < 3) && (row >= 0)) {
            if ((col < 3) && (col >=0)){
                if (board[row][col] == '-') {
                    board[row][col] = currentPlayerMark;
                    return true;

                }
            }
        }
        return false;
    }
    public char getCurrentPlayerMark(){
        return currentPlayerMark;
    }

  public char[][] getBoard() {
    return board;
  }

  public void setBoard(char[][] board) {
    this.board = board;
  }
}

