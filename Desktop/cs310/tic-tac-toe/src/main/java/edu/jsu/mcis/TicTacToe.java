package edu.jsu.mcis;

import java.util.*;

public class TicTacToe 
{   
    public static final int playerOne = 1;
    public static final int playerTwo = 2;
    public static final String emptyField = " ";
    public static final int sizeOfBoard = 3;
    public final String[][] boardArray = new String[sizeOfBoard][sizeOfBoard];
    public static boolean xTurn = true;
    
    public TicTacToe()
    {
       initBoard();
    }
	
	public boolean winX()
	{
		placeMove(1,1,1);
		placeMove(0,1,2);
		placeMove(0,0,1);
		placeMove(0,2,2);
		placeMove(2,2,1);
		boolean result = isWinner("X");
		return result;
	}
    
	public boolean winO(){
		placeMove(1,1,1);
		placeMove(2,0,2);
		placeMove(0,0,1);
		placeMove(2,2,2);
		placeMove(0,2,1);
		placeMove(2,1,2);
		boolean resultTwo = isWinner("O");
		return resultTwo;
	}
	
	public boolean forceTie()
	{
		boolean b;
		placeMove(1,1,1);
		placeMove(0,0,2);
		placeMove(2,0,1);
		placeMove(0,2,2);
		placeMove(0,1,1);
		placeMove(2,1,2);
		placeMove(1,2,2);
		placeMove(1,0,2);
		placeMove(2,2,0);
		if ((theBoardIsFull()) && (!isWinner("O")) && (!isWinner("X")))
		{
			b = true;
		}
		else
		{
			b = false;
		}
		return b;
	}
	
    public void initBoard()
    {
        System.out.println("CS310 IP1 : TicTacToe");
        for (int i = 0; i < sizeOfBoard; i++)
        {
            for (int j = 0; j < sizeOfBoard; j++)
            {
                boardArray[i][j] = emptyField;
            }
        }
    }
    
    public void printBoard()
    {
        System.out.println("-------");
        for (int i = 0; i < sizeOfBoard; i++)
        {
            System.out.print("|");
            for (int j = 0; j < sizeOfBoard; j++)
            {
                System.out.print(boardArray[i][j] + "|");
            }
            System.out.println();
            System.out.println("-------");
        }
    }
    
    public boolean theBoardIsFull() 
    {
        for (int i = 0; i < sizeOfBoard; i++)
        {
            for (int j = 0; j < sizeOfBoard; j++)
            {
                if (" ".equals(boardArray[i][j]))
                {
                    return false;
                }
            }
        }
        return true;
    }
	
	public boolean isWinner(String turn)
	{
		boolean hasWon = false;
		if ((boardArray[0][0] == turn) && (boardArray[0][1] == turn)
				&& (boardArray[0][2] == turn))
				{
					hasWon = true;	
					System.out.println("Winner is: " + turn);
				}
		if ((boardArray[0][0] == turn) && (boardArray[1][1] == turn)
				&& (boardArray[2][2] == turn))
				{
					hasWon = true;		
					System.out.println("Winner is: " + turn);
				}
		if ((boardArray[0][0] == turn) && (boardArray[1][0] == turn)
				&& (boardArray[2][0] == turn))
				{
					hasWon = true;	
					System.out.println("Winner is: " + turn);
				}
		if ((boardArray[0][2] == turn) && (boardArray[1][1] == turn)
				&& (boardArray[2][0] == turn))
				{
					hasWon = true;
					System.out.println("Winner is: " + turn);
				}
		if ((boardArray[1][0] == turn) && (boardArray[1][1] == turn)
				&& (boardArray[1][2] == turn))
				{
					hasWon = true;	
					System.out.println("Winner is: " + turn);
				}
		if ((boardArray[0][1] == turn) && (boardArray[1][1] == turn)
				&& (boardArray[2][1] == turn))
				{
					hasWon = true;
					System.out.println("Winner is: " + turn);
				}
		if ((boardArray[2][0] == turn) && (boardArray[2][1] == turn)
				&& (boardArray[2][2] == turn))
				{
					hasWon = true;
					System.out.println("Winner is: " + turn);
				}
		if ((boardArray[0][2] == turn) && (boardArray[2][2] == turn)
				&& (boardArray[2][2] == turn))
				{
					hasWon = true;	
					System.out.println("Winner is: " + turn);
				}
		return hasWon;
		
	}
    
    public boolean openField(int row, int column)
    {
        if (" ".equals(boardArray[row][column]))
        {
            return true;
        }
        else 
        {
            return false;
        }
    }
    
    public void placeMove(int row, int column, int whosTurn)
    {
        if (whosTurn == playerOne)
        {
            if (openField(row, column))
            {
            boardArray[row][column] = "X";
            whosTurn = playerTwo;
            }
        }
        if (whosTurn == playerTwo)
        {
            if (openField(row, column))
            {
            boardArray[row][column] = "O";
            whosTurn = playerOne;
            }
        }
    }
	
	public String getField(int r, int c){
		String s = boardArray[r][c];
		return s;
	}
    
    public void getSelection()
    {
        int row, column;
        Scanner scan = new Scanner(System.in);
        if (xTurn)
        {
            System.out.println("Player One (X)'s turn. Please select a row: ");
            row = scan.nextInt();
            System.out.println("Player One (X)'s turn. Please select a column: ");
            column = scan.nextInt();
            if (openField(row, column)){
            placeMove(row, column, playerOne);
            xTurn = false;
            printBoard();
            }
        }
        else
        {
            System.out.println("Player Two (O)'s turn. Please select a row: ");
            row = scan.nextInt();
            System.out.println("Player Two (O)'s turn. Please select a column: ");
            column = scan.nextInt();
            if (openField(row, column)){
            placeMove(row, column, playerTwo);
            xTurn = true;
            printBoard();
            }
        }
    }
    
    
    public static void main(String[] args) 
    {
        TicTacToe ttt = new TicTacToe();
        ttt.printBoard();
        while (!ttt.theBoardIsFull())
        {
			if(!ttt.isWinner("X"))
			{
				ttt.getSelection();
			}
			if(!ttt.isWinner("O"))
			{
				ttt.getSelection();
			}
        }
		System.out.println("The game is over!");
    }
}
