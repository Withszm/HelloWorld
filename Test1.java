/**
 * Created by ASUS on 2017/3/3.
 */
import java.util.Random;
import java.util.Scanner;
public class Test1 {
    public static void main (String[] arge){
        System.out.println("请输入答题数：");
        Scanner input =new Scanner(System.in);
        int num = input.nextInt();
        int right=0,fz,fm,gys,gbs;
        String answer="";
        String result="";
        Random r = new Random();
        for(int i=0;i<num;i++){
            int s=r.nextInt(8);
            int a = r.nextInt(9)+1;
            int b = r.nextInt(9)+1;
            int c = r.nextInt(9)+1;
            int d = r.nextInt(9)+1;
            switch(s){
                case 0:System.out.println(a+"+"+b+"=?");result=""+(a+b);break;
                case 1:System.out.println(a+"-"+b+"=?");result =""+(a-b);break;
                case 2:System.out.println(a+"*"+b+"=?");result =""+(a*b);break;
                case 3:System.out.print(a+"/"+b+"=?");System.out.println("（请保留一位小数）");
                    float x=a;float y=b;float z=(float)(Math.round((x/y)*10))/10;
                    result=""+z;break;
                case 4:System.out.println(a+"/"+b+" + "+c+"/"+d+"=?");
                    if(b==d)
                    {
                        fz=a+c;
                        fm=b;
                    }
                    else
                    {
                        gbs=mingbs(b,d);
                        a=gbs/b*a;
                        c=gbs/d*c;
                        fz=a+c;
                        fm=gbs;
                    }
                    gys=maxgys(fz,fm);
                    fz=fz/gys;
                    fm=fm/gys;
                    if(fz==fm) result=""+1;
                    else if(fm==1) result=""+fz;
                    else result=fz+"/"+fm;
                    break;
                case 5:System.out.println(a+"/"+b+" - "+c+"/"+d+"=?");
                    if(b==d)
                    {
                        fz=a-c;
                        fm=b;
                    }
                    else
                    {
                        gbs=mingbs(b,d);
                        a=gbs/b*a;
                        c=gbs/d*c;
                        fz=a-c;
                        fm=gbs;
                    }
                    gys=maxgys(fz,fm);
                    fz=fz/gys;
                    fm=fm/gys;
                    if(fz==fm) result=""+1;
                    else if(fm==1) result=""+fz;
                    else result=fz+"/"+fm;
                    break;
                case 6:System.out.println(a+"/"+b+" * "+c+"/"+d+"=?");
                    fz=a*c;
                    fm=b*d;
                    gys=maxgys(fz,fm);
                    fz=fz/gys;
                    fm=fm/gys;
                    if(fz==fm) result=""+1;
                    else if(fm==1) result=""+fz;
                    else result=fz+"/"+fm;break;
                case 7:System.out.println(a+"/"+b+" / "+c+"/"+d+"=?");
                    int t=c;
                    c=d;
                    d=t;
                    fz=a*c;
                    fm=b*d;
                    gys=maxgys(fz,fm);
                    fz=fz/gys;
                    fm=fm/gys;
                    if(fz==fm) result=""+1;
                    else if(fm==1) result=""+fz;
                    else result=fz+"/"+fm;break;
            }
            answer=input.next();
            if(answer.compareTo(result)==0){
                right++;
                System.out.println("good!");
            }
            else
                System.out.println("wrong!");
        }
        System.out.println("答对"+right+"题，答错"+(num-right)+"题");
        System.out.println("正确率："+(1.0*right/num*100)+"%");
    }
    public static int mingbs(int a1,int b1){
        int r,aa=a1,bb=b1;
        while(b1!=0)
        {
            r=a1%b1;
            a1=b1;
            b1=r;
        }
        int gbs=aa*bb/a1;
        return gbs;
    }
    public static int maxgys(int a1,int b1){
        int r;
        while(b1!=0)
        {
            r=a1%b1;
            a1=b1;
            b1=r;
        }
        return a1;
    }
}
