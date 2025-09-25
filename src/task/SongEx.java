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
      return year + "�� " + lang +"�� " + singer +"(��)�� �θ� " + title + " �帣: " + genre;
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
        System.out.println("���� �� ����: " + SongListindex);
         System.out.println("�� ����(1), �� ã��(2), ��ü �� ���(3), �� ����(4), ����(5)");
         menuNum = sc.nextInt();
         switch(menuNum) {
         case 1: //�� ����
            if(SongListindex >= 100) {
               System.out.println("����� �ڸ��� �����մϴ�. ");
               continue;
            }
            System.out.println("�� ���� �Է�(����,����,����⵵, ����, �帣 ������ �Է�)");
            String title = sc.next();
            String singer = sc.next();
            int year = sc.nextInt();
            String lang = sc.next();
            String genre = sc.next();
            
            SongList[SongListindex] = new Song(title, singer, year, lang, genre);
            SongListindex++;
            break;
         case 2: //�� ã��
           if(SongListindex == 0) {
              System.out.println("���� �����ϴ�. �뷡�� �߰����ּ���.");
              break;
           }
            int CategoryNum = 0;
            boolean CategoryNumExcept = true;
            while(CategoryNumExcept) {
               System.out.println("�������� ã��(1), ����⵵�� ã��(2), �帣�� ã��(3)");
               CategoryNum = sc.nextInt();
               switch(CategoryNum) {
               case 1: //�������� ã��
            	  CategoryNumExcept = false;
                  System.out.println("ã�� �� ����: ");
                  String WantTitle = sc.next();
                  for(int i = 0;i < SongListindex;i++) {
                     if(WantTitle.equals(SongList[i].getTitle())) {
                        System.out.println((i + 1) + ". " + SongList[i].show());
                     }
                  }
                  break;
               case 2: //�⵵�� ã��
            	  CategoryNumExcept = false;
                  System.out.println("ã�� �� ����⵵: ");
                  int WantYear = sc.nextInt();
                  for(int i = 0;i < SongListindex;i++) {
                     if(WantYear == SongList[i].getYear()) {
                        System.out.println((i + 1) + ". " + SongList[i].show());
                     }
                  }
                  break;
               case 3: //�帣�� ã��
            	  CategoryNumExcept = false;
                  System.out.println("ã�� �帣 ��: ");
                  String WantGenre = sc.next();
                  for(int i = 0;i < SongListindex;i++) {
                       if(WantGenre.equals(SongList[i].getGenre())) {
                       System.out.println((i + 1) + ". " + SongList[i].show());
                       }
                  }
                  break;
               default: //�� ��
                  System.out.println("1-3 ������ ���ڸ� �Է����ּ���.");
                   continue;
               }
            }
            break;
         case 3: //��ü �� ���
           if(SongListindex == 0) {
               System.out.println("���� �����ϴ�. �뷡�� �߰��� �ּ���.");
               break;
            }
            for(int i = 0;i < SongListindex;i++) {
               System.out.println((i + 1) + ". " + SongList[i].show());
            }
            break;
         case 4: //�� ����
            System.out.println("�����Ϸ��� ���� �̸��� �Է��� �ּ���.");
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
         case 5: //����
           System.out.println("���α׷��� �����մϴ�.");
            System.exit(0);
         default: //�� ��
           System.out.println("1-5 ������ ���ڸ� �Է����ּ���.");
            break;
         }
      }
   }
}