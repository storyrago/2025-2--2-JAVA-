package task;
import java.util.Scanner;
class Song{
   private String title;
   private String singer;
   private String lang;
   private String genre;
   private int year;
   
   Song(String title, String singer, int year, String lang, String genre){
      this.title = title;
      this.singer = singer;
      this.year = year;
      this.lang = lang;
      this.genre = genre;
   }
   public String show() {
      return year + "년 " + lang +"의 " + singer +"(이)가 부른 " + title + " 장르: " + genre;
   }
   
   public String getTitle() {
      return this.title;
   }
   public int getYear() {
      return this.year;
   }
   public String getGenre() {
      return this.genre;
   }
}

public class SongEx {
   public static void main(String[] args) {
      Scanner sc = new Scanner(System.in);
      Song []SongList = new Song[100];
      int SongListindex = 0;
      
      int menuNum = 0;
      while(true) {
        System.out.println("현재 곡 개수: " + SongListindex);
         System.out.println("곡 삽입(1), 곡 찾기(2), 전체 곡 출력(3), 곡 삭제(4), 종료(5)");
         menuNum = sc.nextInt();
         switch(menuNum) {
         case 1: //곡 삽입
            if(SongListindex >= 100) {
               System.out.println("저장소 자리가 부족합니다. ");
               continue;
            }
            System.out.println("곡 정보 입력(제목,가수,발행년도, 나라, 장르 순으로 입력)");
            String title = sc.next();
            String singer = sc.next();
            int year = sc.nextInt();
            String lang = sc.next();
            String genre = sc.next();
            
            SongList[SongListindex] = new Song(title, singer, year, lang, genre);
            SongListindex++;
            break;
         case 2: //곡 찾기
           if(SongListindex == 0) {
              System.out.println("곡이 없습니다. 노래를 추가해주세요.");
              break;
           }
            int CategoryNum = 0;
            boolean CategoryNumExcept = true;
            while(CategoryNumExcept) {
               System.out.println("제목으로 찾기(1), 발행년도로 찾기(2), 장르로 찾기(3)");
               CategoryNum = sc.nextInt();
               switch(CategoryNum) {
               case 1: //제목으로 찾기
            	  CategoryNumExcept = false;
                  System.out.println("찾을 곡 제목: ");
                  String WantTitle = sc.next();
                  for(int i = 0;i < SongListindex;i++) {
                     if(WantTitle.equals(SongList[i].getTitle())) {
                        System.out.println((i + 1) + ". " + SongList[i].show());
                     }
                  }
                  break;
               case 2: //년도로 찾기
            	  CategoryNumExcept = false;
                  System.out.println("찾을 곡 발행년도: ");
                  int WantYear = sc.nextInt();
                  for(int i = 0;i < SongListindex;i++) {
                     if(WantYear == SongList[i].getYear()) {
                        System.out.println((i + 1) + ". " + SongList[i].show());
                     }
                  }
                  break;
               case 3: //장르로 찾기
            	  CategoryNumExcept = false;
                  System.out.println("찾을 장르 명: ");
                  String WantGenre = sc.next();
                  for(int i = 0;i < SongListindex;i++) {
                       if(WantGenre.equals(SongList[i].getGenre())) {
                       System.out.println((i + 1) + ". " + SongList[i].show());
                       }
                  }
                  break;
               default: //그 외
                  System.out.println("1-3 사이의 숫자를 입력해주세요.");
                   continue;
               }
            }
            break;
         case 3: //전체 곡 출력
           if(SongListindex == 0) {
               System.out.println("곡이 없습니다. 노래를 추가해 주세요.");
               break;
            }
            for(int i = 0;i < SongListindex;i++) {
               System.out.println((i + 1) + ". " + SongList[i].show());
            }
            break;
         case 4: //곡 삭제
            System.out.println("삭제하려는 곡의 이름을 입력해 주세요.");
            String deleteSong = sc.next();
            for(int i = 0;i < SongListindex;i++) {
               if(deleteSong.equals(SongList[i].getTitle())) {
                  for(int j = i;j<SongListindex;j++) {
                     SongList[j] = SongList[j + 1];
                  }
                  break;
               }
            }
            SongListindex--;
            break;
         case 5: //종료
           System.out.println("프로그램을 종료합니다.");
            System.exit(0);
         default: //그 외
           System.out.println("1-5 사이의 숫자를 입력해주세요.");
            break;
         }
      }
   }
}