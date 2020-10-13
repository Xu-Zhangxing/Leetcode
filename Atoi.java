public class Atoi{
    public int myAtoi(String s) {
        if(s.equals("")) return 0;
       int n = s.length();
       int count=0;
       char ch1 = '0';
       char ch2 = '9';
       char ch3 = '-';
       char ch4 = '+';
       int i1 = (int)ch1;
       int i9 = (int)ch2;
       int ix = (int)ch3;
       int iy = (int)ch4;
       String signal = "";
       boolean flag = false;
       int res = 0;
       while(true){
           char temp = s.charAt(count);
           if(flag){
               if((int)temp>=i1&&(int)temp<=i9){
                   int k = Integer.parseInt(""+temp);
                   if(res>(Integer.MAX_VALUE-k)/10){
                       if(signal.equals("")||signal.equals("+")){
                           return Integer.MAX_VALUE;
                       }else{
                           return Integer.MIN_VALUE;
                       }
                   }
                   res = res*10 + k;
               }else{
                   break;
               }
           }else{
               if((int)temp>=i1&&(int)temp<=i9){
                   int k = Integer.parseInt(""+temp);
                   res=k;
                   flag = true;
               }else if((int)temp==ix||(int)temp==iy){
                   signal+=temp;
                   flag = true;
               }else if((int)temp==(int)' '){

               }else{
                   return 0;
               }
           }
           count++;
           if(count==n) break;
       }
       if(signal.equals("")||signal.equals("+")){
            return res;
        }else{
            return res*(-1);
        }
    }
}
