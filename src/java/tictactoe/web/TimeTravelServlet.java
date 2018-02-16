package tictactoe.web;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static tictactoe.web.GameServlet.getGame;

@WebServlet(urlPatterns = {"/time-travel"})
public class TimeTravelServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        // O jogo do usuário atual
        GameApp game = getGame(request);

        // Pula para o número do movimento pedido
        String paramStep = request.getParameter("step");
        game.jumpTo(paramStep);

        // Manda o browser ser redirecionado para "/play-game"
        String contextPath = request.getContextPath();
        response.sendRedirect(contextPath + "/play-game");
    }

}
