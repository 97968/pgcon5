import java.io.BufferedInputStream;

public class Main{
    public static void main(String[] args)throws Exception{
        BufferedInputStream in = new BufferedInputStream(System.in);
        
        int i;
        StringBuilder num = new StringBuilder();
        while((i = in.read()) != -1){
            if(i == 0x0a){
                continue;
            }
            
            int upper4bit = ((i>>4) & 0x0f); // upper 4 bit of i
            int lower4bit = (i & 0x0f);      // lower 4 bit of i
            if(lower4bit == 0x0d || lower4bit == 0x0c) {
                num.append(String.format("%x", upper4bit));
                if(num.charAt(0) == '0'){
                    num.deleteCharAt(0);
                }
                if(lower4bit == 0x0d){
                    num.insert(0, "-");
                }
                System.out.println(num);
                num = new StringBuilder();
            } else {
                num.append(String.format("%02x", i));
            }
        }
    }
}