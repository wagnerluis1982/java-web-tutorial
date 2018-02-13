package tictactoe.web;

public class GameApp {

    private Character[] squares = new Character[9];
    private char turn = 'X';

    public void clickSquare(String param) {
        if (param != null) {
            int index = Integer.parseInt(param);
            clickSquare(index);
        }
    }

    public void clickSquare(int index) {
        // Modifica uma cópia do array
        Character[] squares = this.squares.clone();
        squares[index] = this.turn;

        // Atualiza o estado do jogo
        this.squares = squares;
        this.turn = (this.turn == 'X') ? 'O' : 'X';
    }

    public Character[] getSquares() {
        return this.squares;
    }

    public char getTurn() {
        return this.turn;
    }

}
