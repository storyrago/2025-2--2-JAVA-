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
		return year + "년 " + lang +"의 " + singer +"(이)가 부른 " + title;
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
			System.out.println("곡 삽입(1), 곡 찾기(2), 전체 곡 출력(3), 종료(4)");
			menuNum = sc.nextInt();
			switch(menuNum) {
			case 1: //곡 삽입
				if(SongListindex >= 10) {
					System.out.println("저장소 자리 부족.");
					continue;
				}
				System.out.println("곡 정보 입력(제목,가수,발행년도, 나라순으로 입력)");
				String title = sc.next();
				String singer = sc.next();
				int year = sc.nextInt();
				String lang = sc.next();
				
				SongList[SongListindex] = new Song(title, singer, year, lang);
				SongListindex++;
				break;
			case 2: //곡 찾기
				System.out.println("제목으로 찾기(1), 발행년도로 찾기(2)");
				int CategoryNum = 0;
				CategoryNum = sc.nextInt();
				
				switch(CategoryNum) {
				case 1:
					System.out.println("찾을 곡 제목: ");
					String WantSongTitle = sc.next();
					for(int i = 0;i<SongListindex;i++) {
						if(WantSongTitle.equals(SongList[i].getTitle())) {
							System.out.println((i+1)+". " + SongList[i].show());
						}
					}
					break;
				case 2:
					System.out.println("찾을 곡 발행년도: ");
					int WantYear = sc.nextInt();
					for(int i = 0;i<SongListindex;i++) {
						if(WantYear == SongList[i].getYear()) {
							System.out.println((i+1)+". " + SongList[i].show());
						}
					}
					break;
				}
				break;
			case 3: //전체 곡 출력
				for(int i = 0;i<SongListindex;i++) {
					System.out.println((i+1) + ". " + SongList[i].show());
				}
				break;
			case 4: //종료
				System.exit(0);
			default:
				break;
			}
		}
		
		/*Song remakeSong;
		System.out.println("리메이크곡 정보 입력(가수,발행년도, 나라순으로 입력)");
		singer = sc.next();
		year = sc.nextInt();
		lang = sc.next();
		remakeSong = originalSong.remakeSong(singer,year,lang);
		
		
		System.out.println("원곡:");
		originalSong.show();
		System.out.println("리메이크곡:");
		remakeSong.show();*/
	}

}
