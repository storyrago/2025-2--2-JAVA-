package lecture;
import java.util.Scanner;
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
public class PhoneBook {
	private Scanner sc;
	private Phone[] pArray;
	
	PhoneBook(){
		sc = new Scanner(System.in);
	}
	//입력
	void input() {
		System.out.println("입력 인원수: ");
		int n = sc.nextInt();
		//객체 배열 생성
		pArray = new Phone[n];
		for(int i = 0;i<pArray.length;i++) {
			System.out.println("이름과 전화번호를 입력 >> ");
			String name = sc.next();
			String tel = sc.next();
			pArray[i] = new Phone(name,tel);
		}
	}
	//검색
	String search(String name) {
		
		return "test";
	}
	//출력
	
	void run() {
		System.out.println("전화번호부 관리 프로그램");
		input();
		while(true) {
			System.out.println("검색할 이름을 입력 >> ");
			String name = sc.next();
			
			if(name.equals("그만")) break;
			
			String tel = search(name);
			
		}
	}
	public static void main(String[]args) {
		new PhoneBook().run();
	}
}
