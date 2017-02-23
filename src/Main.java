/**
 * Created by 小成成 on 2017/2/23.
 */
import java.util.Random;
import java.util.Scanner;
public class Main {
    public static int res(double result){
        System.out.println("请输入你的答案：");
        Scanner r = new Scanner(System.in);
        double re = r.nextDouble();
        if(result==re) {
            System.out.println("回答正确！");
            return 1;
        }
        else {
            System.out.println("回答错误！");
            return 0;
        }
    }
    //最大公约数
    public static int gongyue(int m,int n){
        while (m % n != 0) {
            int temp = m % n;
            m = n;
            n = temp;
        }
        return n;
    }
    public static int gongbei(int a,int b){
        int r = a, s = a, t = b;
        if (a < b) {
            r = a;
            a = b;
            b = r;
        }
        while (r != 0) {
            r = a % b;
            a = b;
            b = r;
        }
        return s * t / a;
    }

    public static void main(String[] args) {
        int count = 0;
        double result = 0;
        int fz,fm,gbs,gys;
        int i;
        for(i=0;i<4;i++) {
            System.out.println("请选择要生成的运算方式(共4题)");
            System.out.println("\t1.整数加法\t2.整数减法\t3.整数乘法\t4.整数除法\t5.分数加法\t6.分数减法\t7.分数乘法\t8.分数除法");
            Scanner sj = new Scanner(System.in);
            int p = sj.nextInt();
            Random r = new Random();
            int a = r.nextInt(10);
            int b = r.nextInt(10);
            int c = r.nextInt(10);
            int d = r.nextInt(10);
            switch(p){
                case 1:System.out.println("" + a + " + " + b + " = ?");
                    result = a + b;
                    if(res(result)==1){
                        count++;
                    }
                    else
                        break;
                    break;
                case 2:System.out.println("" + a + " - " + b + " = ?");
                    result = a - b;
                    if(res(result)==1){
                        count++;
                    }
                    else
                        break;
                    break;
                case 3:System.out.println("" + a + " * " + b + " = ?");
                    result = a * b;
                    if(res(result)==1){
                        count++;
                    }
                    else
                        break;
                    break;
                case 4:System.out.println("" + a + " / " + b + " = ?");
                    if (b != 0) {
                        float e = a;
                        float f = b;
                        result = e / f;
                    }
                    else
                        System.out.println("除数为0，不能计算！");
                    if(res(result)==1){
                        count++;
                    }
                    else
                        break;
                    break;
                case 5:
                    System.out.println("" + a + " / " + b + " + " + c +" / "+ d +" = ?");
                    gbs=gongbei(b,d);
                    fm=gbs;
                    fz=a*(gbs/b)+c*(gbs/d);//通分后分子
                    gys=gongyue(fz,fm);
                    fz=fz/gys;
                    fm=fm/gys;
                    if(fz==0)
                    {
                        System.out.println("正确答案是：0");
                    }
                    else if(fm==0){
                        System.out.println("答案不存在！");
                    }
                    else if(fz==fm){
                        System.out.println("正确答案是：1");
                    }
                    else{
                        System.out.println("正确答案是："+ fz + "/" + fm + ".");
                    }
                    break;
                case 6:
                    System.out.println("" + a + " / " + b + " - " + c +" / "+ d +" = ?");
                    gbs=gongbei(b,d);
                    fm=gbs;
                    fz=a*(gbs/b)-c*(gbs/d);//通分后分子
                    gys=gongyue(fz,fm);
                    fz=fz/gys;
                    fm=fm/gys;
                    if(fz==0)
                    {
                        System.out.println("正确答案是：0");
                    }
                    else if(fm==0){
                        System.out.println("答案不存在！");
                    }
                    else if(fz==fm){
                        System.out.println("正确答案是：1");
                    }
                    else{
                        System.out.println("正确答案是："+ fz + "/" + fm + ".");
                    }
                    break;
                case 7:
                    System.out.println("" + a + " / " + b + " - " + c +" / "+ d +" = ?");
                    fz=a*c;
                    fm=b*d;
                    gys=gongyue(fz,fm);
                    fz=fz/gys;
                    fm=fm/gys;
                    if(fz==0)
                    {
                        System.out.println("正确答案是：0");
                    }
                    else if(fm==0){
                        System.out.println("答案不存在！");
                    }
                    else if(fz==fm){
                        System.out.println("正确答案是：1");
                    }
                    else{
                        System.out.println("正确答案是："+ fz + "/" + fm + ".");
                    }
                    break;
                case 8:
                    System.out.println("" + a + " / " + b + " - " + c +" / "+ d +" = ?");
                    fz=a*d;
                    fm=b*c;
                    gys=gongyue(fz,fm);
                    fz=fz/gys;
                    fm=fm/gys;
                    if(fz==0)
                    {
                        System.out.println("正确答案是：0");
                    }
                    else if(fm==0){
                        System.out.println("答案不存在！");
                    }
                    else if(fz==fm){
                        System.out.println("正确答案是：1");
                    }
                    else{
                        System.out.println("正确答案是："+ fz + "/" + fm + ".");
                    }
                    break;
                default:
                    main(null);
            }
        }
        float j = (float) count/4;
        System.out.println("共做对"+count+"题，正确率为"+j*100+"%");
    }
}
