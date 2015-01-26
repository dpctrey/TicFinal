package edu.jsu.mcis;

import org.junit.*;
import static org.junit.Assert.*;

public class TicTest
{
	@Test
	public void testUserInput()
	{
		TicTacToe test = new TicTacToe();
		for (int r = 0; r < 3; r++)
		{
			for (int c = 0; c < 3; c++)
			{
				String s = test.getField(r, c);
				assertEquals(s, " ");
			}
		}
	}
	
	@Test
	public void markTest()
	{
		TicTacToe testTwo = new TicTacToe();
		testTwo.placeMove(1,1,1);
		String testingField = testTwo.getField(1,1);
		assertEquals(testingField, "X");
	}
	
	@Test
	public void winningTest()
	{
		TicTacToe winTic = new TicTacToe();
		winTic.placeMove(0,0,1);
		winTic.placeMove(0,1,1);
		winTic.placeMove(0,2,1);
		boolean win = winTic.isWinner("X");
		assertEquals(win, true);
		winTic.placeMove(0,0,1);
		winTic.placeMove(1,1,1);
		winTic.placeMove(2,2,1);
		boolean winTwo = winTic.isWinner("X");
		assertEquals(win, true);
		winTic.placeMove(0,0,1);
		winTic.placeMove(1,0,1);
		winTic.placeMove(2,0,1);
		boolean winThree = winTic.isWinner("X");
		assertEquals(win, true);
	}
}