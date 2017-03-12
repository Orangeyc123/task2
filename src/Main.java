/**
 * Created by 小成成 on 2017/3/3.
 */
import java.util.Random;
import java.util.Scanner;
import java.lang.Object;
import static java.lang.System.exit;

public class Main {
    static int count=0;
    //公约数,辗转相除法
    public static int CommonDivisor(int m,int n){
        if(m<n){
            int temp1;
            temp1=m;
            m=n;
            n=temp1;
        }
        while (m % n != 0) {
            int temp = m % n;
            m = n;
            n = temp;
        }
        return n;
    }
    //求最小公倍数的方法：两数相乘除以两数的最大公约数
    public static int CommonMultiple(int num2,int num4 ){
        return ((num2*num4)/CommonDivisor(num2,num4));
    }
    //判断真分数加减乘除运算
    public static void judge4(int num1,int num2,int num3,int num4,int UserChoice){
        int ComMul,up,down,flag=0;//flag标记负数
        System.out.print("请输入你的答案：");
        Scanner input4 = new Scanner(System.in);
        String UserResult2 = input4.next();
        if(UserChoice==5||UserChoice==6){
            ComMul=CommonMultiple(num2,num4);
            num1=num1*(ComMul/num2);
            num3=num3*(ComMul/num4);
            if(UserChoice==5){
                up=num1+num3;
                judge2(up,ComMul,UserResult2,flag);
            }
            else{
                up=num1-num3;
                if(up<0){
                    up=-up;
                    flag=1;
                }
                judge2(up,ComMul,UserResult2,flag);
            }
        }
        else if(UserChoice==7||UserChoice==8){
            if(num1==0||num3==0||(num1==0&&num3==0)){
                if(UserResult2.equals("0")){
                    System.out.println("正确答案是0,回答正确！");
                    count++;
                }
                else{
                    System.out.println("正确答案是0,回答错误！");
                }
                return ;
            }
            if(UserChoice==7){
                up=num1*num3;
                down=num2*num4;
                judge2(up,down,UserResult2,flag);
            }
            else{
                up=num1*num4;
                down=num2*num3;
                judge2(up,down,UserResult2,flag);
            }
        }
    }
    //整数加减乘法的计算结果及其判断
    public static void judge1(int result){
        String Sresult = String.valueOf(result);
        System.out.print("请输入你的答案：");
        Scanner input2 = new Scanner(System.in);
        String UserResult = input2.next();
        if (Sresult.equals(UserResult)) {
            System.out.println("正确答案是" + result + ",回答正确！");
            count=count+1;
        } else {
            System.out.println("正确答案是" + result + ",回答错误！");
        }
    }
    //整数除法计算结果及其判断
    public static void judge2(int num1,int num2,String UserResult,int flag){
        int ComDiv;//最大公约数
        ComDiv=CommonDivisor(num1,num2);
        String DivResult;
        num1=num1/ComDiv;
        num2=num2/ComDiv;

        if(num2==1){
            if(flag==0)
                DivResult=String.valueOf(num1);
            else
                DivResult=String.valueOf("-"+num1);
        }
        else{
            if(flag==0)
                DivResult=String.valueOf(num1+"/"+num2);
            else
                DivResult=String.valueOf("-"+num1+"/"+num2);
        }
        if(UserResult.equals(DivResult)){
            System.out.println("正确答案是" + DivResult + ",回答正确！");
            count++;
        } else {
            System.out.println("正确答案是" + DivResult + ",回答错误！");
        }
    }
    //保证分母不为0，也不出现类似5/5的算式
    public static int num2judge(int num1,int num2){
        if(num1==num2||num2==0){
            num2++;
        }
        return num2;
    }
    public static int num4judge(int num3,int num4){
        if(num3==num4||num4==0){
            num4++;
        }
        return num4;
    }
    public static void main(String[] args){
        int result = 0;//整数加减乘法
        double right;
        int i;//循环次数
        for(i=1;i<11;i++) {
            System.out.println("请选择要生成的运算方式(共10题)");
            System.out.println("\t1.整数加法\t2.整数减法\t3.整数乘法\t4.整数除法\t5.真分数加法\t6.真分数减法\t7.真分数乘法\t8.真分数除法\t9.退出");
            Scanner input1 = new Scanner(System.in);
            int UserChoice = input1.nextInt();
            Random number = new Random();//随机生成随机数
            int num1 = number.nextInt(10);//分子
            int num2 = number.nextInt(10);//分母
            int num3 = number.nextInt(10);//分子
            int num4 = number.nextInt(10);//分母
            switch(UserChoice) {
                case 1:
                    System.out.println("第"+i+"题："+ num1 + " + " + num2 + " = ?");
                    result = num1 + num2;//得到随机数a,b相加的结果.
                    judge1(result);
                    break;
                case 2:
                    System.out.println("第"+i+"题："+ num1 + " - " + num2 + " = ?");
                    result = num1 - num2;//得到随机数a,b相加的结果.
                    judge1(result);
                    break;
                case 3:
                    System.out.println("第"+i+"题："+ num1 + " × " + num2 + " = ?");
                    result = num1 * num2;//得到随机数a,b相加的结果.
                    judge1(result);
                    break;
                case 4:
                    System.out.println("第"+i+"题："+ num1 + " ÷ " + (num2+1) + " = ?");//num2+1防止分母为0
                    System.out.print("请输入你的答案：");
                    Scanner input3 = new Scanner(System.in);
                    String UserResult1 = input3.next();
                    judge2(num1,num2+1,UserResult1,0);
                    break;
                case 5:
                    num2=num2judge(num1,num2);
                    num4=num4judge(num3,num4);
                    if(num2==1&&num4!=1){
                        System.out.println("第"+i+"题："+ num1 + " + " + " ( " + num3 + " / " + num4 + " ) = ?");
                    }
                    else if(num2!=1&&num4==1){
                        System.out.println("第"+i+"题："+ " ( " + num1 + " / " + num2 + " ) +" + num3 + " = ?");
                    }
                    else if(num2==1&&num4==1){
                        System.out.println("第"+i+"题："+ num1 + " + " + num3 + " = ?");
                    }
                    else{
                        System.out.println("第"+i+"题："+" ( " + num1 + " / " + num2 + " ) + " + " ( " + num3 + " / " + num4 + " ) = ?");
                    }
                    judge4(num1,num2,num3,num4,UserChoice);
                    break;
                case 6://除法
                    num2=num2judge(num1,num2);
                    num4=num4judge(num3,num4);
                    if(num2==1&&num4!=1){
                        System.out.println("第"+i+"题："+num1 + " - " + " ( " + num3 + " / " + num4 + " ) = ?");
                    }
                    else if(num2!=1&&num4==1){
                        System.out.println("第"+i+"题："+" ( " + num1 + " / " + num2 + " ) -" + num3 + " = ?");
                    }
                    else if(num2==1&&num4==1){
                        System.out.println("第"+i+"题："+num1 + " - " + num3 + " = ?");
                    }
                    else{
                        System.out.println("第"+i+"题："+" ( " + num1 + " / " + num2 + " ) - " + " ( " + num3 + " / " + num4 + " ) = ?");
                    }
                    judge4(num1,num2,num3,num4,UserChoice);
                    break;
                case 7:
                    num2=num2judge(num1,num2);
                    num4=num4judge(num3,num4);
                    if(num2==1&&num4!=1){
                        System.out.println("第"+i+"题："+num1 + " * " + " ( " + num3 + " / " + num4 + " ) = ?");
                    }
                    else if(num2!=1&&num4==1){
                        System.out.println("第"+i+"题："+" ( " + num1 + " / " + num2 + " ) *" + num3 + " = ?");
                    }
                    else if(num2==1&&num4==1){
                        System.out.println("第"+i+"题："+num1 + " * " + num3 + " = ?");
                    }
                    else{
                        System.out.println("第"+i+"题："+" ( " + num1 + " / " + num2 + " ) * " + " ( " + num3 + " / " + num4 + " ) = ?");
                    }
                    judge4(num1,num2,num3,num4,UserChoice);
                    break;
                case 8:
                    num2=num2judge(num1,num2);
                    num4=num4judge(num3,num4);
                    if(num2==1&&num4!=1){
                        System.out.println("第"+i+"题："+num1 + " ÷ " + " ( " + num3 + " / " + num4 + " ) = ?");
                    }
                    else if(num2!=1&&num4==1){
                        System.out.println("第"+i+"题："+" ( " + num1 + " / " + num2 + " ) ÷" + num3 + " = ?");
                    }
                    else if(num2==1&&num4==1){
                        System.out.println("第"+i+"题："+num1 + " ÷ " + num3 + " = ?");
                    }
                    else{
                        System.out.println("第"+i+"题："+" ( " + num1 + " / " + num2 + " ) ÷ " + " ( " + num3 + " / " + num4 + " ) = ?");
                    }
                    judge4(num1,num2,num3,num4,UserChoice);
                    break;
                case 9:
                    right=(double)count/(double)(i-1)*100;
                    System.out.println("你已做完"+(i-1)+"道，做对"+count+"道，正确率为："+right+"%");
                    exit(0);
            }
            if(i==10){
                right=(double)count/(double)i*100;
                System.out.println("你已做完"+i+"道，做对"+count+"道，正确率为："+right+"%");
            }
        }
    }
}
