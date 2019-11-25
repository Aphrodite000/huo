import java.util.*;

public class Main {
    //s1是等待入栈的火车
    static Stack<String> s1=new Stack<String>();
    //s2是栈中火车
    static Stack<String> s2=new Stack<String>();
    //list来存放整个结果集，里面用字符串存着所有的出站可能
    static List<String> list=new ArrayList<String>();
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        while(sc.hasNext()){
            int N=Integer.parseInt(sc.nextLine());
            String s11=sc.nextLine();
            String[] a=s11.split(" ");
            //把进栈的火车编号按顺序给入栈
            for(int i=a.length-1;i>=0;i--){
                s1.push(a[i]);
            }
            pp("");
            Collections.sort(list);
            for(String h:list){
                System.out.println(h);
            }
        }
    }

    private static void pp(String m) {
        while(s1.isEmpty()&&s2.isEmpty()){
            //一个字符串，其值是此字符串，除去任何前导和尾随空格，或者如果该字符串没有前导或尾随的空格，则为
            list.add(m.trim());
            return;
        }
        if(!s2.isEmpty()){
            String mm=s2.pop();
            pp(m+" "+mm);
            //删了再放回去
            s2.push(mm);
        }
        if(!s1.isEmpty()){
            String mm=s1.pop();
            s2.push(mm);
            pp(m);
            s2.pop();
            s1.add(mm);
        }
    }
}
