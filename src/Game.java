
import java.util.*;

public class Game {
    Deque<Player>players;
    Board newboard;
    Integer playerCount;
    Game(Board board,int playercount,Deque<Player>players){
         this.newboard=board;
         this.playerCount=playercount;
           this.players=new LinkedList<Player>(players);
    }
    public void Play(){
        Scanner sc=new Scanner(System.in);
        Integer counter=0;
        while(true){
            newboard.displayBoard();
            Player player=players.removeFirst();
            players.addLast(player);
            System.out.println("Player "+counter+" "+player.name+" turn");
            int curx=sc.nextInt();
            int cury=sc.nextInt();
            while(!newboard.addPiece(curx,cury,player.piece.type)){
                System.out.println("Invalid move try again");
                newboard.displayBoard();
                 curx=sc.nextInt();
                 cury=sc.nextInt();
            }
            if(winOrNot(curx,cury,newboard)){
                System.out.println(player.name+" wins");
                break;
            }
            if(isFilled(newboard)){
                System.out.println("Game ends no result");
                break;
            }
            counter=(counter+1)%playerCount;
        }
    }
    public Boolean isFilled(Board newboard){
        int size1=newboard.size1;
        for(int i=0;i<size1;i++){
            for(int j=0;j<size1;j++){
                if(newboard.board[i][j]==null) return false;
            }
        }
            return true;
    }
    public Boolean winOrNot(Integer x,Integer y,Board bd){
         int length=newboard.size1;
        PieceType whichType = newboard.board[x][y];
        int size1=bd.size1;
        int flag=0;
         for(int i=0;i<size1;i++){
             if(newboard.board[i][y]!=whichType){
                 flag=1;
                 break;
             }
         }
         if(flag==0) return true;
         flag=0;
         for(int j=0;j<size1;j++){
             if(newboard.board[x][j]==null || newboard.board[x][j]!=whichType){
                 flag=1;
                 break;
             }
         }
         if(flag==0) return true;
         flag=0;
         int i=0,j=0;
         whichType=newboard.board[0][0];
         while(i<size1 && j<size1){
             if(newboard.board[i][j]==null || newboard.board[i][j]!=whichType){
                 flag=1;
                 break;
             }
             i++;
             j++;
         }
         if(flag==0) return true;
        i=0;
        j=size1-1;
        flag=0;
         whichType=newboard.board[i][j];
         while(i<size1 && j>=0){
             if(newboard.board[i][j]==null || newboard.board[i][j]!=whichType){
                 flag=1;
                 break;
             }
             j--;
             i++;
         }
         if(flag==0) return true;
         return false;
    }
}
