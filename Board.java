import java.util.*;
public class Board{
    public static String state = "";
    public static boolean error = false;
    private String[] a = new String[9];
    List<Integer> done = new ArrayList<Integer>();

    public Board(){
        for(int i = 0; i < 9; i++)
        {
            a[i] = i+1 + "";
        }
        state = this.setState();
    }
    public void recordMove(String move, int pos){
        if(pos<1 || pos>9 || done.indexOf(pos)!=-1){
            System.out.println("Enter a valid number");
            error=true;
        }
        else
        {
            a[pos-1]=move;
            this.setState();
            done.add(pos);
        }
    }
    public String setState(){
        state = " " + a[0] + " | " + a[1] + " | "+ a[2] + "\n";
        state += "__________" + "\n";
        state += " " + a[3] + " | " + a[4] + " | "+ a[5] + "\n";
        state += "__________" + "\n";
        state += " " + a[6] + " | " + a[7] + " | "+ a[8] + "\n";
        return state;
    }
    public int checkForWin()
    {
        // 28-39 checks rows
        if(a[0].equals(a[1]) && a[0].equals(a[2])){
            if(a[0].equals("X"))    return 1;
            else if(a[0].equals("O")) return 2;
        }
        if(a[3].equals(a[4]) && a[3].equals(a[5])){
            if(a[3].equals("X"))    return 1;
            else if(a[3].equals("O")) return 2;
        }
        if(a[6].equals(a[7]) && a[6].equals(a[8])){
            if(a[6].equals("X"))    return 1;
            else if(a[6].equals("O")) return 2;
        }
        // 41-52 checks cols
        if(a[0].equals(a[3]) && a[0].equals(a[6])){
            if(a[0].equals("X"))    return 1;
            else if(a[0].equals("O")) return 2;
        }
        if(a[1].equals(a[4]) && a[1].equals(a[7])){
            if(a[1].equals("X"))    return 1;
            else if(a[1].equals("O")) return 2;
        }
        if(a[2].equals(a[5]) && a[2].equals(a[8])){
            if(a[2].equals("X"))    return 1;
            else if(a[2].equals("O")) return 2;
        }
        // 54-61 checks diag
        if(a[0].equals(a[4]) && a[0].equals(a[8])){
            if(a[0].equals("X"))    return 1;
            else if(a[0].equals("O")) return 2;
        }
        if(a[2].equals(a[4]) && a[2].equals(a[6])){
            if(a[2].equals("X"))    return 1;
            else if(a[2].equals("O")) return 2;
        }
        return 0;
    }
    public void printState(){
        System.out.println(state);
    }
}