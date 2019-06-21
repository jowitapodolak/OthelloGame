//import java.util.*;
//
//public class IntelligentAI implements IOthelloAI {
//
//
//
//
//
//    public IntelligentAI() {
//    }
//
//    /**
//     * Calculates the move to make for the given game state.
//     * @param s The current state of the game in which it should be the AI's turn.
//     * @return the position where the AI wants to put its token.
//     * Is only called when a move is possible, but feel free to return
//     * e.g. (-1, -1) if no moves are possible.
//     */
//
//    public Position decideMove(GameState s){
//
//        //but here we have a list of all possible moves. We need moves for the given state s that result in the state of largest number of discs for 2
//        // state -> action (position - with insertToken() -> newState - how many tokens of 2 we have here? (countTokens)
//        ArrayList<Position> possibleMoves = s.legalMoves(); //all the positions we can put on  = all actions we can do on a given state
//
//        if(!possibleMoves.isEmpty()) {
//            //here we need to take a move that captures max number of discs.
//
//            //Should we make a comparator to compare number of tokens of white for each state
//            //therefore states would be compared based on the number of white tokens on the board
//            //and we could make this map a treemap and have GameState with highrs num of white on the top
//
//            //maps states that results from the given positons put on state s
//            // (state s -> position (performed as an action with insertTokes() -> new state)
//            Map<GameState, Position> positionToState = getStates(s, possibleMoves);
//
//            for(Position position: possibleMoves)
//            {
//                MinValue(s, position);
//            }
//
//            //now take all of those possible states that results from those positions and choose one that gives higher number of white(2) tokens
//
//            //MinValue(s, positionToState);
//            //iterate through states and choose one that has max number of white
//            int max = 0;
//            GameState maxState = null;
//
//            for (GameState state : positionToState.keySet()) {
//                int[] result = state.countTokens();
//                int numOfWhiteTokens = result[1];
//                if (numOfWhiteTokens > max) {
//                    max = numOfWhiteTokens;// if number of tokens in max is smaller then update max with a new number
//                    maxState = state;// state with max value of white tokens on the board.
//                }
//            }
//
//            return positionToState.get(maxState);
//
//
//            //now how does it work with MINIMAX?!
//
//
//           // MinValue(s, positionToState); // sent to min current state and a map of going from current state with possible actions and their resultant states
//
//
//        } else
//            return new Position(-1,-1);
//
//    }
//
//    public int MaxValue(GameState s, Map<GameState, Position> positionToState ){
//        //This is a choice for player 2 - white, artificial intelligence
//
//        int[] result =s.countTokens();
//
//        if(s.isFinished()) return result[1]; //exactly same line in minValue :/
//
//
//        //I can take max value from game states
//        int max = 0;
//        GameState maxState = null;
//
//        for (GameState state : positionToState.keySet()) {
//            int[] newResult = state.countTokens();
//            int numOfWhiteTokens = newResult[1];
//            if (numOfWhiteTokens > max) {
//                max = numOfWhiteTokens;// if number of tokens in max is smaller then update max with a new number
//                maxState = state;// state with max value of white tokens on the board.
//            }
//        }
//
//
//
//
//    }
//
//    public int MinValue(GameState s, Map <GameState, Position> positionToState) {
//        //minimize values for IA, max for 1 (?)
//        int[] result = s.countTokens();
//
//        if (s.isFinished()) return result[1];
//
//        //iterate through values and choose  and return position for this value
//
//        for(Position position:
////        MaxValue(s,positionToState);
////        int min = 0;
////        GameState minState = null;
////
////        for (GameState state : positionToState.keySet()) {
////            int[] newResult = state.countTokens();
////            int numOfWhiteTokens = newResult[1];
////            if (numOfWhiteTokens < min) {
////                min = numOfWhiteTokens;// if number of tokens in max is smaller then update max with a new number
////                minState = state;// state with max value of white tokens on the board.
////
////            }
////        }
////        return minState.countTokens()[1]; // is it legit? minState.countTokens returns array
//
//    }
//
//    //getStates method is finding states for the given actions and maping then states to those actions
//    //is my state a whole class or just a current board (with numbers of players)
//    public Map<GameState, Position> getStates(GameState s, ArrayList<Position> possibleMoves){
//
//        Map<GameState, Position> StateToPosition= new HashMap<>();
//
//        GameState startingState = s;
//
//
//        for(Position position: possibleMoves)
//        {
//            GameState newState = startingState;
//            newState.insertToken(position); // the only change for the new state is to insert a token into given position
//            StateToPosition.put(newState, position);
//        }
//
//        return StateToPosition;
//    }
//
//
//
//
//
//
//
//
//
//
//
////    //getActions - gets list of positions and a returns a list of possible game states
////
////    public Map<GameState, Position> getActions(List<Position> legalMoves, GameState s){
////
////        ArrayList<Position> possibleMoves = s.legalMoves();
////        Map<Position,GameState> gamestatesToPosition = new HashMap<>();
////        for(Position position: possibleMoves)
////        {
////            GameState state = new GameState(s.getBoard(), s.getPlayerInTurn());
////            state.insertToken(position);
////            gamestatesToPosition.put(position,state);
////        }
////
////
////        //return
////    }
//}
