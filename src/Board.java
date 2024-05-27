public class Board {
    Integer size1;
    PieceType[][]board;
    Board(Integer size1){
        this.size1=size1;
       this.board=new PieceType[size1][size1];
       for(int i=0;i<size1;i++){
           for(int j=0;j<size1;j++) this.board[i][j]=null;
       }
    }
    public void displayBoard(){
        for(int i=0;i<size1;i++){
            for(int j=0;j<size1;j++) {
                if(board[i][j]!=null) {
                    System.out.print(board[i][j] + " ");
                }
                else {
                    System.out.print("E ");
                }
            }
            System.out.println();
        }
    }
    public Boolean addPiece(int x,int y,PieceType piece){
        if(board[x][y]!=null || x<0 || y<0 || x>=size1 || y>=size1) return false;
        board[x][y]=piece;
        return true;
    }

}
