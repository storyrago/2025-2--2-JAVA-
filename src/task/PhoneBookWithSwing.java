package task;

import java.util.Scanner;
import javax.swing.*;
import java.awt.*;

class PhoneBook{
	private int phoneCount = 0;
	private int MaxElement;
	private Phone[] phones; //Phone Ŭ������ ���� ��Ű�� �� PhoneBookWithConsole �� ����Ʈ ������������ �������־� ���� �ȳ� (����Ʈ ���������� ���� ��Ű���������� ���� ����)
	PhoneBook(int n){
		MaxElement = n;
		this.phones = new Phone[n];
	}
	//��ȭ��ȣ �߰� ���
	void add_phoneNumber(Phone p) {
		if(phoneCount >= MaxElement) {
			System.out.println("��ȭ��ȣ�� ����");
			return;
		}
		phones[phoneCount++] = p;
	}
	String getPhoneMaster(int i) {
		return phones[i].getName();
	}
	String getPhoneInfo(int i) {
		return phones[i].getName() +" "+ phones[i].getTel();
	}
	int getMaxElement() {
		return MaxElement;
	}
}

public class PhoneBookWithSwing extends JFrame{
	private PhoneBook pb;
	private int n;
	private String SearchName;
	private MyPanel panel = new MyPanel();
	PhoneBookWithSwing(PhoneBook pb, String SearchName){
		this.pb = pb;
		this.n = pb.getMaxElement();
		this.SearchName = SearchName;
		setTitle("��ȭ��ȣ ����Ʈ");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setContentPane(panel);
		setSize(300,200);
		setVisible(true);
	}
	
	class MyPanel extends JPanel{
		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			for(int i = 0;i<n;i++) {
				if(SearchName.equals(pb.getPhoneMaster(i))) {
					g.drawString(pb.getPhoneInfo(i), 30, 30*(i+1));
				}
			}
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("������ ��ȭ��ȣ�� ���� �Է�: ");
		int phoneCnt = sc.nextInt();
		PhoneBook pb = new PhoneBook(phoneCnt);
		for(int i = 0;i<phoneCnt;i++) {
			System.out.println("������ �̸��� ��ȣ�� �Է�: ");
			String name = sc.next();
			String tel = sc.next();
			Phone p = new Phone(name,tel);
			pb.add_phoneNumber(p);
		}
		System.out.println("�˻��� �̸� �Է�: ");
		String SearchName = sc.next();
		new PhoneBookWithSwing(pb,SearchName);
	}

}
