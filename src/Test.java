import java.util.Scanner;
import java.util.Stack;

public class Test {

	public static void main(String[] args) {
		Stack<Integer> hanoi1=new Stack();
		Stack<Integer> hanoi2=new Stack();
		Stack<Integer> hanoi3=new Stack();
		int disks=0;
		Scanner sc=new Scanner(System.in);
		System.out.print("Please Enter your disks: ");
		disks=sc.nextInt();
		int i=disks;
		while(i>0) {
		hanoi1.push(i);i--;}
		hanoi(1,3,2,disks,hanoi1,hanoi2,hanoi3);
	}
	public static void hanoi(int str,int des,int buff,int disks,Stack<Integer> h1,Stack<Integer> h2,Stack<Integer> h3) {
		if(disks==0) {
			if(!h1.empty()) {System.out.print("top of hanoi1: "+h1.peek()+" ; ");}
			if(!h2.empty()) {System.out.print("top of hanoi2: "+h2.peek()+" ; ");}
			if(!h3.empty()) {System.out.print("top of hanoi3: "+h3.peek()+" ; ");}
			System.out.println();
			return;}
		hanoi(str,buff,des,disks-1,h1,h2,h3);
		if(str==1&&des==2) {h2.push(h1.pop());}
		else if(str==1&&des==3) {h3.push(h1.pop());}
		else if(str==2&&des==1) {h1.push(h2.pop());}
		else if(str==2&&des==3) {h3.push(h2.pop());}
		else if(str==3&&des==1) {h1.push(h3.pop());}
		else if(str==3&&des==2) {h2.push(h3.pop());}
		System.out.printf("#%d from hanoi%d to hanoi%d\n",disks,str,des);
		hanoi(buff,des,str,disks-1,h1,h2,h3);
	}
}
   
