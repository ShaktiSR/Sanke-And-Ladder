import java.util.*;

class Game{
    private HashMap<Integer,Integer> snake = new HashMap<>();
    private HashMap<Integer,Integer> ladder = new HashMap<>();

    public Game() {
        //Initialize Snakes in the game
        //snake.put(snakeBiteAtPosition,positionDecreaseBy)
        snake.put(17, 10);
        snake.put(54, 20);
        snake.put(62, 33);
        snake.put(64, 4);
        snake.put(87, 42);
        snake.put(93, 15);
        snake.put(95, 80);
        snake.put(98, 64);

        //Initialize Ladders in the game
        //snake.put(latterStartAtPosition,positionIncreaseBy)
        ladder.put(2,21);
        ladder.put(8,26);
        ladder.put(20,57);
        ladder.put(32,36);
        ladder.put(41,42);
        ladder.put(74,14);
        ladder.put(85,10);
    }

    public int diceRoll(){
        Random random = new Random();
        return random.nextInt(6)+1;
    }

    public int newPosition(int currentPosition){
        if(snake.containsKey(currentPosition)){
            System.out.println("SNAKE... MOVE TO THE POSITION "+ (currentPosition - snake.get(currentPosition)));
            return currentPosition - snake.get(currentPosition);
        }
        else if(ladder.containsKey(currentPosition)){
            System.out.println("LADDER... MOVE TO THE POSITION "+ (currentPosition + ladder.get(currentPosition)));
            return currentPosition + ladder.get(currentPosition);
        }
        return currentPosition;
    }

}

public class SnakeAndLadder {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Game game = new Game();
        int numberOfPlayers = 0;
        while(true) {
            System.out.println("ENTER NUMBER OF PLAYERS BETWEEN 1 TO 4: ");
            numberOfPlayers = scanner.nextInt();
            if(numberOfPlayers>0 && numberOfPlayers <5){
                break;
            }
        }
        //Creating coupon for each player with initial position at 0
        int[] players = new int[numberOfPlayers];
        Arrays.fill(players,0);

        int currentChance = 1;
        System.out.println("GAME START");
        while(true){
            //Position of current players coupon
            int co =players[currentChance-1];
            System.out.println("Player "+currentChance+"   PressEnter to roll dice.....");
            scanner.nextLine();
            int throwDice = game.diceRoll();
            System.out.println("Dice :" + throwDice);
            co += throwDice;
            System.out.println("New Position at: "+co);
            co= game.newPosition(co);
            players[currentChance-1]=co;
            //check if board is cleared
            if(co>=100){
                break;
            }
            //Get the chance to next player
            if(currentChance==numberOfPlayers){
                currentChance=1;
            }
            else {
                currentChance++;
            }
            System.out.println();
        }
        System.out.println("Player "+currentChance+" won the game.");
        System.out.println("GAME END");
    }

}
