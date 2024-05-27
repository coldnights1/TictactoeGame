import java.util.*;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        //dynamically allocating data
        while(true) {
            Deque<Player>dq=new LinkedList<Player>();
            int arr[]=new int[4];
            for(int i=0;i<4;i++) arr[i]=0;
            System.out.println("Welcome to Tic Tac Toe");
            System.out.println("Enter the number of players who want to play");
            int countofPlayers=sc.nextInt();
            while(countofPlayers>4){
                System.out.println("Only 4 players are allowed Try Again");
                countofPlayers=sc.nextInt();
            }
            for(int i=1;i<=countofPlayers;i++){
                System.out.println("Enter player "+i+" name");
                String name=sc.next();
                System.out.println("Enter the playing piece 1.X 2.O 3.D 4.I");
                int value=sc.nextInt();
                while(arr[value]==1){
                    System.out.println("Already taken Try Again");
                    value=sc.nextInt();
                }
                arr[value]=1;
                PlayingPiece curpiece;
                if(value==1){
                    curpiece=new PlayingPiece(PieceType.X);
                }
                else if(value==2){
                    curpiece=new PlayingPiece(PieceType.O);
                }
                else if(value==3){
                    curpiece=new PlayingPiece(PieceType.D);
                }
                else {
                    curpiece=new PlayingPiece(PieceType.I);
                }
                Player player=new Player(name,curpiece);
                dq.addLast(player);
            }
            System.out.println("Enter the board size ");
            int boardsize=sc.nextInt();
            Board cboard=new Board(boardsize);
            Game game=new Game(cboard,boardsize,dq);
            game.Play();
          System.out.println("Want to play again?? 1.Yes 2.No");
          int isEnd=sc.nextInt();
          if(isEnd==2){
              System.out.println("visit again Thank you");
              break;
          }
        }
    }
}