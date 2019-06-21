import java.util.*;

public class AI implements IOthelloAI {

    private static final int maxDepth = 6;

    public Position decideMove(GameState s) {

        Long beginning = System.currentTimeMillis();

        //System.out.println("dM");

        int alpha = Integer.MIN_VALUE;
        int beta = Integer.MAX_VALUE;

        ArrayList<Position> legalPositions = s.legalMoves();
        if (legalPositions.isEmpty()) return new Position(-1, -1);

        int max = 0;
        int i = 0;
        Position maxPos = null;
        for (Position position : legalPositions) {

            //System.out.println("position " + i);
            i++;

            int depth = 0;

            GameState tmpState = new GameState(s.getBoard(), s.getPlayerInTurn()); // not to change an actual game
            tmpState.insertToken(position);//
            //System.out.println(String.format("MinValue(%s, %s, %s, %s)", tmpState, alpha, beta, depth));
            int minValue = MinValue(tmpState, alpha, beta, depth);
            //System.out.println(String.format("minValue: %s, max: %s", minValue, max));
            if (minValue >= max) {
                max = minValue;
                maxPos = position;
                //alpha = max; //- we are loosing with that
            }
        }

        Long end = System.currentTimeMillis();
        float result = (float)(end-beginning)/1000;
        System.out.println(result);
        return maxPos;


    }

    public int MaxValue(GameState s, int alpha, int beta, int depth) {

        //System.out.println("MV");

        if (depth >= maxDepth || s.isFinished()) return Evaluation(s); //s.countTokens()[1];

        depth++;
        ArrayList<Position> legalPositions = s.legalMoves();

        int max = 0;

        for (Position position : legalPositions) {

            GameState tmpState = new GameState(s.getBoard(), s.getPlayerInTurn());
            tmpState.insertToken(position);
            int minValue = MinValue(tmpState, alpha, beta, depth);
            if (minValue > max) max = minValue;
            if (max >= beta) return max;
            alpha = Math.max(alpha, max);
        }

        return max;
    }

    public int MinValue(GameState s, int alpha, int beta, int depth) {

        //System.out.println("MinV");

        if (depth >= maxDepth || s.isFinished()) return Evaluation(s);
        ;//s.countTokens()[1]
        depth++;

        ArrayList<Position> legalPositions = s.legalMoves();
        int min = Integer.MAX_VALUE;
        //Position minPosition=null;
        for (Position position : legalPositions) {
            GameState tmpState = new GameState(s.getBoard(), s.getPlayerInTurn());
            tmpState.insertToken(position);
            int maxValue = MaxValue(tmpState, alpha, beta, depth);
            if (maxValue < min) min = maxValue;
            if (min <= alpha) return min;
            beta = Math.min(beta, min);
        }

        return min;
    }


    public int Evaluation(GameState s) {
        int[][] currentBoard = s.getBoard();

        int finalValue = 0;


        //corner-case
        //how ot iterate through tokens positions on the board

        for (int i = 0; i < currentBoard.length; i++) {
            for (int j = 0; j < currentBoard.length; j++) {
                if (currentBoard[i][j] == 2) {


//                    int IcornerDistance;
//                    int JcornerDistance;
//
//                    IcornerDistance = i<((currentBoard.length)/2)-1 ? i : currentBoard.length -i;
//                    JcornerDistance = j<((currentBoard.length)/2)-1 ? j : currentBoard.length -j;
//
//
//                    if(IcornerDistance==0 && JcornerDistance==0) finalValue= finalValue +4;


                    //corners
                    if (i == 0 && j == 0) finalValue = finalValue + 5;
                    else if (i == 0 && j == currentBoard.length - 1) finalValue = finalValue + 5;
                    else if (i == currentBoard.length - 1 && j == 0) finalValue = finalValue + 5;
                    else if (i == currentBoard.length - 1 && j == currentBoard.length - 1) finalValue = finalValue + 5;
                    //xs
                    //however for for we can explore entire space instead of using utility...
                    if (currentBoard.length != 4) {
                        //left-upper corner
                        if (i == 0 && j == 1) finalValue = finalValue + 1;
                        else if (i == 1 && j == 1) finalValue = finalValue + 1;
                        else if (i == 1 && j == 0) finalValue = finalValue + 1;
                            //left-bottom corner
                        else if (i == currentBoard.length - 2 && j == 0) finalValue = finalValue + 1;
                        else if (i == currentBoard.length - 2 && j == 1) finalValue = finalValue + 1;
                        else if (i == currentBoard.length - 1 && j == 1) finalValue = finalValue + 1;
                            //right-bottom corner
                        else if (i == currentBoard.length - 1 && j == currentBoard.length - 2)
                            finalValue = finalValue + 1;
                        else if (i == currentBoard.length - 2 && j == currentBoard.length - 2)
                            finalValue = finalValue + 1;
                        else if (i == currentBoard.length - 2 && j == currentBoard.length - 1)
                            finalValue = finalValue + 1;
                            //right-upper corner
                        else if (i == 0 && j == currentBoard.length - 2) finalValue = finalValue + 1;
                        else if (i == 1 && j == currentBoard.length - 2) finalValue = finalValue + 1;
                        else if (i == 1 && j == currentBoard.length - 1) finalValue = finalValue + 1;

                            //sides

                        else if (i > 1 && i < currentBoard.length - 2 && j == 0) finalValue = finalValue + 4;
                        else if (i > 1 && i < currentBoard.length - 2 && j == currentBoard.length - 1)
                            finalValue = finalValue + 4;
                        else if (i == 0 && j > 1 && j < currentBoard.length - 2) finalValue = finalValue + 4;
                        else if (i == currentBoard.length - 1 && j > 1 && j < currentBoard.length - 2)
                            finalValue = finalValue + 4;

                    } else finalValue = finalValue + 2;


                }
//
//
//            }
//
//
//        }


            }
        }
        return finalValue;
//    }
    }
}





