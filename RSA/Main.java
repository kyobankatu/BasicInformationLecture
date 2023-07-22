import java.io.File;
import java.util.Scanner;

public class Main{
    public static void main( String[] args ){
        Sender sender = new Sender();
        Reciever reciever = new Reciever();
        Scanner sc = new Scanner(System.in);
        String[] line = sc.nextLine().split(" ");
        try{
            switch(Integer.parseInt(line[0])){
                case 0:
                    sender.send_number(reciever, Integer.parseInt(line[1]));
                    break;
                case 1:
                    sender.send_char(reciever, line[1].toCharArray()[0]);
                    break;
                case 2:
                    sender.send_file(reciever, new File(line[1]));
                    break;
                default:
                    System.out.println("入力値が不正です。");
                    break;
            }
            sc.close();
        }catch (Exception e) {
            System.out.println("入力値が不正です。");
            sc.close();
        }
    }
}