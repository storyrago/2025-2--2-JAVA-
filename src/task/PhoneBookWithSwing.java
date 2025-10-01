package task;

import java.util.Scanner;
import javax.swing.*;
import java.awt.*;


class Phone{
	//필드
	private String name;
	private String tel;			
	//생성자
	Phone(String name, String tel){
		this.name = name;
		this.tel = tel;
	}	
	//메소드 get기능
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
	//전화번호 추가 기능
	void add_phoneNumber(Phone p) {
		if(phoneCount >= MaxElement) {
			System.out.println("전화번호부 꽉참");
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
		setTitle("전화번호 리스트");
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
		Phone p1 = new Phone("천자민","010-1234-5679");
		pb.add_phoneNumber(p1);
		Phone p2 = new Phone("누군가","010-1434-5679");
		pb.add_phoneNumber(p2);
		
		new PhoneBookWithSwing(pb);
	}

}
