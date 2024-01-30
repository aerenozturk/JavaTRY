package KurwaCoTam;

public class SoccerGame {
    public static void main(String[] args) {
        Player player1 = new Player("Player1");
        Player player2 = new Player("Player2");

        player1.setNextPlayer(player2);
        player2.setNextPlayer(player1);

        Thread thread1 = new Thread(player1);
        Thread thread2 = new Thread(player2);

        thread1.start();
        thread2.start();
    }    
}
class Player implements Runnable {
    private String name;
    private Player nextPlayer;
    private boolean hasBall;

    public Player(String name) {
        this.name = name;
    }

    public void setNextPlayer(Player nextPlayer) {
        this.nextPlayer = nextPlayer;
    }

    public synchronized void startGame() {
        hasBall = true;
        System.out.println(name + " starts the game!");
        notify(); // Oyun başladığında diğer oyuncuyu uyandır
    }

    public synchronized void passBall() {
        while (!hasBall) {
            try {
                wait(); // Topu alana kadar beklet
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }

        System.out.println(name + " passes the ball to " + nextPlayer.getName());
        nextPlayer.receiveBall();
        hasBall = false;
        notify(); // Topu pasladıktan sonra diğer oyuncuyu uyandır
    }

    public synchronized void receiveBall() {
        while (hasBall) {
            try {
                wait(); // Topu alana kadar beklet
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }

        System.out.println(name + " receives the ball.");
        hasBall = true;
        notify(); // Topu aldıktan sonra diğer oyuncuyu uyandır
    }

    public String getName() {
        return name;
    }

    @Override
    public void run() {
        startGame();
        while (true) {
            passBall();
        }
    }
}

