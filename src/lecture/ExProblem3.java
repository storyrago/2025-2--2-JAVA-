package lecture;

import java.util.Scanner;

public class ExProblem3 {
	
	private static void input(int idArr[],int scoreArr[], Scanner sc) {
		System.out.println("�л��� �й��� ������ �Է��ϼ���. : ");
		
		for(int i =0;i<idArr.length;i++) {
			System.out.print((i+1)+ "��° >> ");
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
			System.out.println("1.�й����� �˻�	2.������ �˻�	3.����");
			int num = sc.nextInt();
			switch(num) {
			case 1: //�޼ҵ� ȣ��
				
			case 2: //�޼ҵ� ȣ��
				
			case 3:
				System.out.println("���α׷� ����...");
				System.exit(0);
			default:
				break;
			}
		}
	}
	
}
