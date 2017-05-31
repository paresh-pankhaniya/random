//given string  without repetition of char and rank 

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class RankOfString {
	Scanner sc = new Scanner(System.in);
	String str;
	int lenStr, rank, sum = 0;
	public static void main(String[] args) {
		new RankOfString().getStart();
	}
	private void getStart(){
		ArrayList<Character> str = new ArrayList<>();
		String in = sc.next();
		for(int i =0 ;i<in.length();i++)
			str.add(in.charAt(i));
		rank = Integer.parseInt(sc.next());
		lenStr = str.size();
		int fact = fact(lenStr);
		Collections.sort(str);
		String ans = "";
		for(int i = 0;i<lenStr;i++){
			System.out.println("str :"+str.toString());
			fact /=(lenStr-i);
			System.out.println("fact :"+fact);
			for(int j = 0;j<str.size();j++) {
				if(rank > fact) {
					rank-=fact;
				} else {
					ans+=str.get(j);
					str.remove(j);
					Collections.sort(str);
					System.out.println("ans :"+ans);
					break;
				}
				
			}
		}
		System.out.println(ans);
	}
	private int fact(int n){
		if(n ==0 || n==1){
			return 1;
		}
		return n*fact(n-1);
	}

}
