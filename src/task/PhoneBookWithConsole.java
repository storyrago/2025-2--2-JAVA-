package task;
import java.util.Scanner;

class Phone{
	//�ʵ�
	private String name;
	private String tel;
			
	//������
	Phone(String name, String tel){
		this.name = name;
		this.tel = tel;
	}
			
	//�޼ҵ� get���
	String getName() {
		return name;
	}
	String getTel() {
		return tel;
	}	
}


public class PhoneBookWithConsole {
	private Scanner sc;
	private Phone[] pArray;
	
	PhoneBookWithConsole(){
		sc = new Scanner(System.in);
	}
	//�Է�
	void input() {
		System.out.println("�Է� �ο���: ");
		int n = sc.nextInt();
		//��ü �迭 ����
		pArray = new Phone[n];
		for(int i = 0;i<pArray.length;i++) {
			System.out.println("�̸��� ��ȭ��ȣ�� �Է� >> ");
			String name = sc.next();
			String tel = sc.next();
			pArray[i] = new Phone(name,tel);
		}
	}
	//�˻�
	String search(String name) {
		for(int i = 0;i<pArray.length;i++) {
			if(pArray[i].getName().equals(name)) return pArray[i].getTel();
		}
		return null;
	}
	void run() {
		System.out.println("��ȭ��ȣ�� ���� ���α׷�");
		input();
		while(true) {
			System.out.println("�˻��� �̸��� �Է� >> ");
			String name = sc.next();
			
			if(name.equals("stop")) break;
			
			String tel = search(name);
			System.out.println("�˻��� �̸��� ��ȭ��ȣ: " + tel);
		}
	}
	public static void main(String[]args) {
		new PhoneBookWithConsole().run();
	}
}
