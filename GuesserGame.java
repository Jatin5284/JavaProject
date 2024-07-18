// number of classes --guesser,player,umpire
// guesser--1method
// player--1method
// umpire--3method--1compare--1player--1guesser
import java.util.*;
class guesser{
    int guesserNum;
    public int takeNumberGuesser(){
        System.out.println("Guesser guess a Number");
        Scanner scan=new Scanner(System.in);
        guesserNum=scan.nextInt();
        return guesserNum;
    }
}
class player {
    int playerNum;
    public int takeNumberPlayer(int i){
        System.out.println("Player"+i+" guess a Number");
        Scanner scan=new Scanner(System.in);
        playerNum=scan.nextInt();
        return playerNum;
    }
}
class umpire{
    int numFromGuesser;
    int numFromPlayer1;
    int numFromPlayer2;
    int numFromPlayer3;
    void collectFromGuesser(){
        guesser g=new guesser();
        numFromGuesser=g.takeNumberGuesser();
    }
    void collectFromPlayer(){
        player p1=new player();
        numFromPlayer1=p1.takeNumberPlayer(1);

        player p2=new player();
        numFromPlayer2=p2.takeNumberPlayer(2);

        player p3=new player();
        numFromPlayer3=p3.takeNumberPlayer(3);
    }
    void compare(){
        if(numFromPlayer1==numFromGuesser){
            if(numFromPlayer2==numFromGuesser&&numFromPlayer3==numFromGuesser) {
                System.out.println("All Players won the Game");
            } else if(numFromPlayer2==numFromGuesser){
                System.out.println("Only Player1 and Player2 won the game");
            }else if (numFromPlayer3==numFromGuesser){
                System.out.println("Only Player1 and Player3 won the game");
            }
            else {
                System.out.println("Only Player1 won the game");
            }
        }else if(numFromPlayer2==numFromGuesser){
            if (numFromPlayer3==numFromGuesser){
                System.out.println("Only Player2 and Player 3 won the game");
            }
            else {
                System.out.println("Only Player2 won the game");
            }
        }else if (numFromPlayer3==numFromGuesser){
            System.out.println("Only Player3 won the game");
        }else {
            System.out.println("No Player won thw game");
        }
    }
}

public class GuesserGame {
    public static  void main (String[] args){
        umpire u=new umpire();
        u.collectFromGuesser();
        u.collectFromPlayer();
        u.compare();
    }
}
