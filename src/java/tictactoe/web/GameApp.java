package tictactoe.web;

public class GameApp {

    private Character[] squares = new Character[9];
    private char turn = 'X';
    private char winner = ' ';

    public void clickSquare(String param) {
        if (param != null) {
            int index = Integer.parseInt(param);
            clickSquare(index);
        }
    }

    public void clickSquare(int index) {
        // Parando se já tiver um vencedor ou o quadrado já estiver clicado
        if (this.winner != ' ' || this.squares[index] != null) {
            return;
        }

        // Modifica uma cópia do array
        Character[] squares = this.squares.clone();
        squares[index] = this.turn;

        // Atualiza o estado do jogo
        this.squares = squares;
        this.turn = (this.turn == 'X') ? 'O' : 'X';
        this.winner = calculateWinner(squares);
    }

    private static char calculateWinner(Character[] squares) {
        // Posições que se marcadas, significa vitória
        int[][] lines = new int[][]{
            {0, 1, 2},
            {3, 4, 5},
            {6, 7, 8},
            {0, 3, 6},
            {1, 4, 7},
            {2, 5, 8},
            {0, 4, 8},
            {2, 4, 6},
        };

        // Processa o tabuleiro para identificar um vencedor
        for (int[] line : lines) {
            int a = line[0],
                b = line[1],
                c = line[2];
            if (squares[a] != null && squares[a] == squares[b] && squares[a] == squares[c]) {
                return squares[a];
            }
        }

        // Ainda sem um vencedor
        return ' ';
    }

    public Character[] getSquares() {
        return this.squares;
    }

    public char getTurn() {
        return this.turn;
    }

    public char getWinner() {
        return this.winner;
    }

}
