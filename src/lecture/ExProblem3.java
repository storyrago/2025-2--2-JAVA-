package lecture;

import java.util.Scanner;

public class ExProblem3 {
	
	private static void input(int idArr[],int scoreArr[], Scanner sc) {
		System.out.println("학생의 학번과 점수를 입력하세요. : ");
		
		for(int i =0;i<idArr.length;i++) {
			System.out.print((i+1)+ "번째 >> ");
			int id = sc.nextInt();
			int score = sc.nextInt();
			idArr[i] = id;
			scoreArr[i] = score;
		}
	}
	
	
	public static void main(String[] args) {
		int idArr[] = new int[10];
		int scoreArr[] = new int[10];
		Scanner sc = new Scanner(System.in);
		
		
		input(idArr,scoreArr, sc);
		while(true) {
			System.out.println("1.학번으로 검색	2.점수로 검색	3.종료");
			int num = sc.nextInt();
			switch(num) {
			case 1: //메소드 호출
				
			case 2: //메소드 호출
				
			case 3:
				System.out.println("프로그램 종료...");
				System.exit(0);
			default:
				break;
			}
		}
	}
	
}
