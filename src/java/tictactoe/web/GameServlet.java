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
        // O jogo do usuário atual
        GameApp game = getGame(request);

        // Marca o quadrado clicado com um X
        String paramSquare = request.getParameter("square");
        clickSquare(paramSquare, game);

        // Passa a requisição para outro componente
        RequestDispatcher jsp = request.getRequestDispatcher("/WEB-INF/jsp/game.jsp");
        jsp.forward(request, response);
    }

    private static GameApp getGame(HttpServletRequest request) {
        // A sessão atual do usuário
        HttpSession session = request.getSession();

        // Tenta pegar a variável da sessão
        GameApp game = (GameApp) session.getAttribute("game");

        // Se a variável não existir, cria uma nova
        if (game == null) {
            session.setAttribute("game", game = new GameApp());
        }

        return game;
    }

    private static void clickSquare(String param, GameApp game) {
        if (param != null) {
            int index = Integer.parseInt(param);
            game.setSquare(index);
        }
    }

}
