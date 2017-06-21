import java.util.Scanner;

public class brute_force_string_matching{
  public static void main(String[] args) {
      new brute_force_string_matching().input();
  }
  private void input() {
    Scanner sc = new Scanner(System.in);
    String txt,ptrn;
    txt = sc.nextLine();
    ptrn = sc.nextLine();
    matching(txt,ptrn);
  }
  private void matching(String txt, String ptrn) {
    int n = txt.length();
    int m = ptrn.length();
    int count = 0;
    for(int i=0;i<n;i++){
      count = 0;
      for(int j=0;j<m;j++){
        if(ptrn.charAt(j) == txt.charAt(i+j)) {
          count++;
        } else {
          break;
        }
        if(count == m) {
          System.out.println("pattern '"+ptrn+"' found at position :"+i);
        }
      }
    }
  }
}
