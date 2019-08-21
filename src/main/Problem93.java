package main;

import java.util.*;

import math.Combination;

public class Problem93 {
	//a, b, c, d
	//ab+c-d*
	//_ _ . _ . _ .
	//_ _ _ . _ . .
	//_ _ _ . . _ .
	//_ _ _ . . . _
	//_ _ _ _ . . .
	//4!*4^3 = 1536 per abcd set
	//7*8*9*10 = 5040

	public static void main(String[] args) {

		//int n = Problem93.getNRepresent(1, 2, 3, 4);
		//System.out.println(n);


		allABCDCombo();

	}


	public static final char[] operators= new char[]{'+','-','*','/'};

	public static void allABCDCombo(){
		int maxN = -1;
		List<Integer> bestDigitList = null;
		for(int a=0;a<=6;a++){
			for(int b=a+1;b<=7;b++){
				for(int c=b+1;c<=8;c++){
					for(int d=c+1;d<=9;d++){
						List<Integer> digitList =new ArrayList<Integer>();
						digitList.add(a);
						digitList.add(b);
						digitList.add(c);
						digitList.add(d);
						int n = getN(digitList);
						//System.out.println(digitList+" : "+n);
						if(n>maxN){
							maxN = n;
							bestDigitList = digitList;
						}
					}
				}
			}
		}
		System.out.println(bestDigitList);
	}

	public static int getN(List<Integer> digitList){
		Set<Integer> evals = new HashSet<>();
		allexpr(0,0,new StringBuilder(), digitList,evals);

		int n;
		for(n=0;;n++){
			if(!evals.contains(n+1)){
				break;
			}
		}

		return n;
	}
	public static void allexpr(int numDigits, int numOps, StringBuilder strConstruct, List<Integer> digitList,Set<Integer> possibleEvalSet){
		if(strConstruct.length()==7){
			int eval = evaluate(strConstruct.toString());
			if(eval>=0){
				possibleEvalSet.add(eval);
			}
			return;
		}


		//_ _ _ . . . _ ********
		//needs number if length is 0,1,3,5

		//numOrOp = 0;// 0 for number, 1 for op, 2 for either

		boolean numAllow=true, opAllow = true;
		if(numDigits==4){
			numAllow = false;
		}
		if(numDigits-numOps<2){
			opAllow = false;
		}

		//number
		if(numAllow){
			for(int i=0;i<digitList.size();i++){
				int digit = digitList.get(i);
				strConstruct.append(digit);
				digitList.remove(i);

				allexpr(numDigits+1,numOps,strConstruct, digitList, possibleEvalSet);

				strConstruct.deleteCharAt(strConstruct.length()-1);
				digitList.add(i,digit);
			}
		}
		//operator
		if(opAllow){
			for(char op:operators){
				strConstruct.append(op);
				allexpr(numDigits,numOps+1,strConstruct,digitList, possibleEvalSet);
				strConstruct.deleteCharAt(strConstruct.length()-1);
			}
		}

	}
	public static int evaluate(String str){

		try {
			Stack<Double> evalStack = new Stack<Double>();

			for (char c : str.toCharArray()) {
				if (c >= '0' && c <= '9') {
					//is number
					evalStack.push((double) (c - '0'));
				} else if (c == '+') {
					evalStack.push(evalStack.pop() + evalStack.pop());
				} else if (c == '-') {
					evalStack.push(evalStack.pop()-evalStack.pop());
				} else if (c == '*') {
					evalStack.push(evalStack.pop() * evalStack.pop());
				} else if (c == '/') {
					double a = evalStack.pop(), b = evalStack.pop();
					if (b == 0.0) {
						//System.out.println(str);
						return -1;
					}
					evalStack.push(a / b);
				}
			}
			double ansD = evalStack.pop();
			int ans = -1;
			if(ansD%1==0){
				ans = (int) ansD;
			}
			//System.out.println(str+" = "+ans);
			return ans;
		}catch (EmptyStackException e){
			System.err.println("crash");
			return -1;
		}
	}


}
