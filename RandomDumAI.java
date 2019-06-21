import java.util.ArrayList;
import java.util.Random;

public class RandomDumAI implements IOthelloAI {

        public Position decideMove(GameState s) {
            Random random = new Random();
            ArrayList<Position> moves = s.legalMoves();
            if (!moves.isEmpty())
                 return moves.get(random.nextInt(moves.size()));
            else
                return new Position(-1, -1);
        }
    }

