import de.main.TTT;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class winTests {


  //public static TTT game;
  public static de.main.TTT game;

  public static char[][]  board;

  @BeforeClass
  public static void initTestField(){
      game  = new TTT();
}

  @Test
  public void testRowsAllEmpty(){
    game.setBoard(new char[][]{{'-','-','-'},{'-','-','-'},{'-','-','-'}});
    Assert.assertFalse(game.checkRowsForWin());

  }

  @Test
  public void testRowsSomeEmpty(){
    game.setBoard(new char[][]{{'x','-','-'},{'x','-','-'},{'-','-','-'}});
    Assert.assertFalse(game.checkRowsForWin());
  }

  @Test
  public void testCheckRowsWinnerRow(){
    game.setBoard(new char[][]{{'x','x','x'},{'-','-','-'},{'x','-','-'}});
    Assert.assertTrue(game.checkRowsForWin());

  }

}
