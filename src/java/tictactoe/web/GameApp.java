package tictactoe.web;

public class GameApp {

    private Character[] squares = new Character[9];

    public void clickSquare(String param) {
        if (param != null) {
            int index = Integer.parseInt(param);
            clickSquare(index);
        }
    }

    public void clickSquare(int index) {
        // Modifica uma cópia do array
        Character[] squares = this.squares.clone();
        squares[index] = 'X';

        // Atualiza o estado do jogo
        this.squares = squares;
    }

    public Character[] getSquares() {
        return this.squares;
    }

}
