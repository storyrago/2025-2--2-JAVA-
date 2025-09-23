package task;
import java.util.Scanner;
class Song{
	private String title;
	private String singer;
	private int year;
	private String lang;
	
	Song(String title, String singer, int year, String lang){
		this.title = title;
		this.singer = singer;
		this.year = year;
		this.lang = lang;
	}
	public String show() {
		return year + "�� " + lang +"�� " + singer +"(��)�� �θ� " + title;
	}
	
	public String getTitle() {
		return this.title;
	}
	public int getYear() {
		return this.year;
	}
	public Song remakeSong(String singer, int year,String lang) {
		Song temp = new Song(this.title,singer,year,lang);
		return temp;
	}
}

public class SongEx {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Song []SongList = new Song[10];
		int SongListindex = 0;
		
		int menuNum = 0;
		while(true) {
			System.out.println("�� ����(1), �� ã��(2), ��ü �� ���(3), ����(4)");
			menuNum = sc.nextInt();
			switch(menuNum) {
			case 1: //�� ����
				if(SongListindex >= 10) {
					System.out.println("����� �ڸ� ����.");
					continue;
				}
				System.out.println("�� ���� �Է�(����,����,����⵵, ��������� �Է�)");
				String title = sc.next();
				String singer = sc.next();
				int year = sc.nextInt();
				String lang = sc.next();
				
				SongList[SongListindex] = new Song(title, singer, year, lang);
				SongListindex++;
				break;
			case 2: //�� ã��
				System.out.println("�������� ã��(1), ����⵵�� ã��(2)");
				int CategoryNum = 0;
				CategoryNum = sc.nextInt();
				
				switch(CategoryNum) {
				case 1:
					System.out.println("ã�� �� ����: ");
					String WantSongTitle = sc.next();
					for(int i = 0;i<SongListindex;i++) {
						if(WantSongTitle.equals(SongList[i].getTitle())) {
							System.out.println((i+1)+". " + SongList[i].show());
						}
					}
					break;
				case 2:
					System.out.println("ã�� �� ����⵵: ");
					int WantYear = sc.nextInt();
					for(int i = 0;i<SongListindex;i++) {
						if(WantYear == SongList[i].getYear()) {
							System.out.println((i+1)+". " + SongList[i].show());
						}
					}
					break;
				}
				break;
			case 3: //��ü �� ���
				for(int i = 0;i<SongListindex;i++) {
					System.out.println((i+1) + ". " + SongList[i].show());
				}
				break;
			case 4: //����
				System.exit(0);
			default:
				break;
			}
		}
		
		/*Song remakeSong;
		System.out.println("������ũ�� ���� �Է�(����,����⵵, ��������� �Է�)");
		singer = sc.next();
		year = sc.nextInt();
		lang = sc.next();
		remakeSong = originalSong.remakeSong(singer,year,lang);
		
		
		System.out.println("����:");
		originalSong.show();
		System.out.println("������ũ��:");
		remakeSong.show();*/
	}

}
