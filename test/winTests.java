import de.main.TTT;                 //class muss importiert weren, um erreichbar zu sein --> package im src-ordner
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;              //junit importiren, um Testen zu ermöglichen


public class winTests {


    //public static TTT game;
    public static de.main.TTT game;


    @BeforeClass
    public static void initTestField() {
        game = new TTT();
    }

    @Test
    public void testRowsAllEmpty() {
        game.setBoard(new char[][]{{'-', '-', '-'}, {'-', '-', '-'}, {'-', '-', '-'}});
        Assert.assertFalse(game.checkRowsForWin());

    }

    @Test
    public void test1Rowfull() {
        game.setBoard(new char[][]{{'-', 'o', '-'}, {'o', '-', 'o'}, {'x', 'x', 'x'}});
        Assert.assertTrue(game.checkRowsForWin());
    }


    @Test
    public void testRowsSomeEmpty() {
        game.setBoard(new char[][]{{'x', '-', '-'}, {'x', '-', '-'}, {'-', '-', '-'}});
        Assert.assertFalse(game.checkRowsForWin());
    }

    @Test
    public void testRowsfewEmpty() {
        game.setBoard(new char[][]{{'x', 'x', 'x'}, {'o', 'o', 'o'}, {'x', '-', '-'}});
        Assert.assertTrue(game.checkRowsForWin());
    }                                                   //Anzahl egal --> wird nicht erfasst, der erste Gewinner zählt --> dann Abbruch

    @Test
    public void testCheckRowsWinnerRow() {
        game.setBoard(new char[][]{{'x', 'x', 'x'}, {'-', '-', '-'}, {'x', '-', '-'}});
        Assert.assertTrue(game.checkRowsForWin());

    }

    @Test
    public void testCollumnsAllEmpty() {
        game.setBoard(new char[][]{{'-', '-', '-'}, {'-', '-', '-'}, {'-', '-', '-'}});
        Assert.assertFalse(game.checkColumnsForWin());

    }

    @Test
    public void testCheckCollumnsWinner() {
        game.setBoard(new char[][]{{'-', 'o', '-'}, {'-', 'o', '-'}, {'-', 'o', '-'}});
        Assert.assertTrue(game.checkColumnsForWin());
    }

    @Test
    public void testDiagonalsWinner() {
        game.setBoard(new char[][]{{'x', 'o', '-'}, {'-', 'x', 'o'}, {'-', 'o', 'x'}});
        Assert.assertTrue(game.checkDiagonalsForWin());
    }

    @Test
    public void testDiagonalsWinner2() {
        game.setBoard(new char[][]{{'o', 'x', 'x'}, {'x', 'o', 'x'}, {'x', 'o', 'o'}});
        Assert.assertTrue(game.checkDiagonalsForWin());
    }

    @Test
    public void testDiagonalsFail() {
        game.setBoard(new char[][]{{'o', 'x', 'x'}, {'x', 'o', 'o'}, {'x', 'o', 'x'}});
        Assert.assertFalse(game.checkDiagonalsForWin());

    }

    @Test
    public void testBoardFullandWinner() {
        game.setBoard(new char[][]{{'x', 'o', 'x'}, {'x', 'o', 'o'}, {'o', 'o', 'x'}});
        Assert.assertTrue(game.isBoardFull() && game.checkColumnsForWin());   //Am besten immer einzeln testen
    }

    @Test
    public void gameOver() {
        game.setBoard(new char[][]{{'x', 'o', 'x'}, {'x', 'x', 'o'}, {'x', 'o', 'o'}});
        Assert.assertTrue(game.isBoardFull());
        Assert.assertTrue(game.checkForWin());
        Assert.assertTrue(TTT.gameOver(game));
    }

    @Test
    public void gamenotOver() {
        game.setBoard(new char[][]{{'x', 'o', '-'}, {'x', 'x', 'o'}, {'-', 'o', 'o'}});

        Assert.assertFalse(TTT.gameOver(game));
    }

    @Test
    public void gameOverbutnotFull() {
        game.setBoard(new char[][]{{'x', 'o', '-'}, {'x', 'x', 'o'}, {'x', 'o', 'o'}});

        Assert.assertTrue(TTT.gameOver(game));
    }

    @Test
    public void checkPlayerswitch() {
        Assert.assertEquals('x', game.getCurrentPlayerMark());
        game.changePlayer();
        Assert.assertEquals('o', game.getCurrentPlayerMark());
    }

/*    @Test
    public void checkPlayerswitch2(){
        Assert.assertEquals('x',game.getCurrentPlayerMark());
        game.changePlayer();
        Assert.assertEquals('n', game.getCurrentPlayerMark());    //change Player funktioniert

    }
    */
}