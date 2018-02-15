package tictactoe.web;

import java.util.ArrayList;
import java.util.List;

public class GameApp {

    private List<Character[]> history = new ArrayList<>(1);
    private char turn = 'X';
    private char winner = ' ';

    public GameApp() {
        this.history.add(new Character[9]);
    }

    public void clickSquare(String param) {
        if (param != null) {
            int index = Integer.parseInt(param);
            clickSquare(index);
        }
    }

    public void clickSquare(int index) {
        Character[] squares = this.getSquares();

        // Parando se já tiver um vencedor ou o quadrado já estiver clicado
        if (this.winner != ' ' || squares[index] != null) {
            return;
        }

        // Modifica uma cópia do array
        squares = squares.clone();
        squares[index] = this.turn;

        // Modifica uma cópia do histórico
        List<Character[]> history = new ArrayList<>(this.history);
        history.add(squares);

        // Atualiza o estado do jogo
        this.history = history;
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
        return this.history.get(this.history.size() - 1);
    }

    public char getTurn() {
        return this.turn;
    }

    public char getWinner() {
        return this.winner;
    }

}
