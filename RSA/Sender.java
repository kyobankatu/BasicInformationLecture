import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Random;

public class Sender {

    private static long p,q,n,e,d;
    private static ArrayList<Long> prime_number = new ArrayList<>();

    static{
        File txt = new File("./resources/PrimeNumber.txt");
		try (BufferedReader br = new BufferedReader(new FileReader(txt))) {
            String str;
			while ((str = br.readLine()) != null) {
				prime_number.add(Long.parseLong(str));
			}

            //p,q,nを定める
            Random rand = new Random();
            p = prime_number.get(rand.nextInt(prime_number.size()));
            do{
                q = prime_number.get(rand.nextInt(prime_number.size()));
            }while(p==q);
            n = p*q;

            //e,dを定める
            int i=0;
            long tmp = (p-1)*(q-1);
            do{
                e = prime_number.get(i);
                i++;
            }while(tmp % e ==0);
            d = get_d(e,tmp);
            System.out.println("p="+p+",q="+q+",n="+n+",e="+e+",d="+d);
		} catch (IOException ioex) {
			ioex.printStackTrace();
		}
    }

    public void send_number(Reciever reciever, int num){
        System.out.println("send:"+num);
        int y = (int)pow_mod(num, e, n);
        reciever.recieve_number(y, d, n);
        System.out.println("第３者が見える情報：y="+y+",d="+d+",n="+n);
    }

    public void send_char(Reciever reciever, char c){
        System.out.println("send:"+c);
        int num = (int)c;
        int y = (int)pow_mod(num, e, n);
        reciever.recieve_char(y, d, n);
        System.out.println("第３者が見える情報：y="+y+",d="+d+",n="+n);
    }

    public void send_file(Reciever reciever, File file) throws Exception{
        BufferedReader br = new BufferedReader(new FileReader(file));
        String str;
        ArrayList<Integer[]> data = new ArrayList<>();
        while ((str = br.readLine()) != null) {
            for(String c : str.split("")){
                byte[] bytes = c.getBytes("UTF-8");
                Integer[] y = new Integer[bytes.length];
                for(int i=0;i<bytes.length;i++){
                    y[i] = (int)pow_mod(bytes[i], e, n);
                }
                data.add(y);
            }
        }
        reciever.recieve_file(data, d, n);
    }

    //一次不定方程式ax+by=1のxの解の内、0<=x<bとなるものを１つを返す
    public static long get_d(long a, long b){
        long prevx = 1L;
        long nextx = 0L;
        long prevy = 0L;
        long nexty = 1L;
        long b_origin = b;
        while(b>0){
            long quotient = (long) (a/b);
            long tmp = nextx;
            nextx = prevx - quotient * nextx;
            prevx = tmp;
            tmp = nexty;
            nexty = prevy - quotient * nexty;
            prevy = tmp;
            tmp = a;
            a= b;
            b = tmp % b;
        }
        while(prevx<0 || b_origin<=prevx ){
            if(prevx<0){
                prevx += b_origin;
            }else{
                prevx -= b_origin;
            }
        }
        return prevx;
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
