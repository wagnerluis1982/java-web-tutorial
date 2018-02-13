package tictactoe.web;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(urlPatterns = {"/play-game"})
public class GameServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // A sessão atual do usuário
        HttpSession session = request.getSession();

        // Tenta pegar a variável da sessão
        Character[] squares = (Character[]) session.getAttribute("gameSquares");

        // Se a variável não existir, cria uma nova
        if (squares == null) {
            session.setAttribute("gameSquares", squares = new Character[9]);
        }

        // Marca o quadrado clicado com um X
        String paramSquare = request.getParameter("square");
        if (paramSquare != null) {
            int index = Integer.parseInt(paramSquare);
            // Modifica uma cópia do array e o coloca na sessão, no lugar do anterior.
            Character[] squaresCopy = squares.clone();
            squaresCopy[index] = 'X';
            session.setAttribute("gameSquares", squaresCopy);
        }

        // Passa a requisição para outro componente
        RequestDispatcher jsp = request.getRequestDispatcher("/WEB-INF/jsp/game.jsp");
        jsp.forward(request, response);
    }

}
