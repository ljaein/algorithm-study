package study0601;

import java.util.Scanner;
import java.util.Stack;

public class Main_4949_균형잡힌세상 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(true){
			String s = sc.nextLine();
			if(s.equals("."))
				break;
			char[] c = s.toCharArray();
			boolean ok = true;
            Stack<Integer> stack = new Stack<>();
            for(int i=0;i<c.length;i++){
                if(c[i]=='('){
                    stack.push(0);
                }else if(c[i]=='['){
                    stack.push(1);
                }else if(c[i]==')'){
                	if(stack.size()==0){
                		ok=false;
                		break;
                	}
                    int num = stack.pop();
                    if(num!=0){
                        ok = false;
                        break;
                    }
                }else if(c[i]==']'){
                	if(stack.size()==0){
                		ok=false;
                		break;
                	}
                    int num = stack.pop();
                    if(num!=1){
                        ok = false;
                        break;
                    }
                }else{
                    continue;
                }
            }
            if(stack.size()!=0)
            	ok = false;
            System.out.println(ok?"yes":"no");
		}
	}

}
