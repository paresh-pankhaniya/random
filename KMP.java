import java.util.Scanner;
public class KMP {
	public static void main(String arg[]) {
		new KMP().input();
	}
	private void input(){
		String txt,ptrn;
		Scanner sc = new Scanner(System.in);
		txt = sc.nextLine();
		ptrn = sc.nextLine();
		int ptrnLen = ptrn.length();
		int arr[] = new int[ptrnLen];
		preCompute(ptrn, arr);
		kmpSearch(ptrn,txt,arr);
	}
	private void kmpSearch(String ptrn, String txt, int arr[]) {
		int m = txt.length();
		int n = ptrn.length();
		int i=0, j =0 ;

		while(i < m) {
			if(ptrn.charAt(j) == txt.charAt(i)) {
				i++;
				j++;
			}
			if(j == n ) {
				 System.out.println("pattern fount at position "+(i-j));
				 j = arr[j-1];
			} else if(i < m && ptrn.charAt(j) != txt.charAt(i)) {
				if(j!=0) {
					j = arr[j-1];
				} else {
					i++;
				}
			}
		}
	}
	private void preCompute(String ptrn, int arr[]) {
		int len = 0;
		int i = 1;
		arr[0] = 0;
		while(i < ptrn.length()) {
			if(ptrn.charAt(i) == ptrn.charAt(len)) {
				len++;
				arr[i] = len;
				i++;
			} else {
				if(len != 0) {
					len = arr[len -1];
				} else {
					arr[i] = len;
					i++;
				}
			}
		}
	}
}
