import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

public class Reciever {
    
    public void recieve_number(int data, long d, long n){
        int x = (int)pow_mod(data, d, n);
        System.out.println("recieve:"+x);
    }

    public void recieve_char(int data, long d, long n){
        int x = (int)pow_mod(data, d, n);
        System.out.println("recieve:"+(char)x);
    }

    public void recieve_file(ArrayList<Integer[]> data_list, long d, long n){
        StringBuffer sb = new StringBuffer();
        for(Integer[] data : data_list){
            byte[] x = new byte[data.length];
            for(int i=0;i<data.length;i++){
                x[i] = (byte)pow_mod(data[i], d, n);
            }
            try {
                sb.append(new String(x, "UTF-8"));
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
        }
        System.out.println(sb);
    }

    //y^d % nを求める
    private long pow_mod(int y, long d, long n){
        long ans=1;
        for(long i=0;i<d;i++){
            ans *= (long)y;
            ans %= n;
        }
        return ans;
    }

}
