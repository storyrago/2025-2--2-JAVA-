package task;

import java.util.Scanner;
import javax.swing.*;
import java.awt.*;


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
class PhoneBook{
	private int phoneCount = 0;
	private int MaxElement;
	private Phone[] phones;
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
	String getPhoneInfo(int i) {
		return phones[i].getName() +" "+ phones[i].getTel();
	}
	int getMaxElement() {
		return MaxElement;
	}
}

public class PhoneBookWithSwing extends JFrame{
	private Scanner sc;
	private PhoneBook pb;
	private int n;
	private MyPanel panel = new MyPanel();
	PhoneBookWithSwing(PhoneBook pb){
		this.pb = pb;
		this.n = pb.getMaxElement();
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
				g.drawString(pb.getPhoneInfo(i), 30, 30*(i+1));
			}
		}
	}
	
	public static void main(String[] args) {
		PhoneBook pb = new PhoneBook(2);
		Phone p1 = new Phone("õ�ڹ�","010-1234-5679");
		pb.add_phoneNumber(p1);
		Phone p2 = new Phone("������","010-1434-5679");
		pb.add_phoneNumber(p2);
		
		new PhoneBookWithSwing(pb);
	}

}
