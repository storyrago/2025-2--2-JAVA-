package task;

import java.util.Scanner;
import javax.swing.*;
import java.awt.*;

class PhoneBook{
	private int phoneCount = 0;
	private int MaxElement;
	private Phone[] phones; //Phone 클래스가 같은 패키지 내 PhoneBookWithConsole 에 디폴트 접근지정으로 설정돼있어 오류 안남 (디폴트 접근지정은 같은 패키지내에서만 접근 가능)
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
				if(SearchName.equals(pb.getPhoneMaster(i))) {
					g.drawString(pb.getPhoneInfo(i), 30, 30*(i+1));
				}
			}
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("저장할 전화번호부 개수 입력: ");
		int phoneCnt = sc.nextInt();
		PhoneBook pb = new PhoneBook(phoneCnt);
		for(int i = 0;i<phoneCnt;i++) {
			System.out.println("저장한 이름과 번호를 입력: ");
			String name = sc.next();
			String tel = sc.next();
			Phone p = new Phone(name,tel);
			pb.add_phoneNumber(p);
		}
		System.out.println("검색할 이름 입력: ");
		String SearchName = sc.next();
		new PhoneBookWithSwing(pb,SearchName);
	}

}
