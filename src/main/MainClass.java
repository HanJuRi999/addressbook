package main;

import java.util.Scanner;

import dao.AddressDao;
import file.FileProc;

public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);		
		AddressDao dao = new AddressDao();		
		FileProc fp = new FileProc("addressbook");
				
		// 메뉴
		fp.read();

		while(true) {
			System.out.println("");
			System.out.println("address book menu ==========================");
			System.out.println("1. 주소추가");
			System.out.println("2. 주소삭제");
			System.out.println("3. 주소검색");
			System.out.println("4. 주소수정");
			System.out.println("5. 전체보기");
			System.out.println("6. 파일저장");
			System.out.println("7. 종료");
			
			System.out.println("menu number >> ");
			int menuNumber = sc.nextInt();
			
			switch(menuNumber) {
				case 1:
					dao.insert();					
					break;
				case 2:
					dao.delete();
					break;
				case 3:
					dao.select();
					break;
				case 4:
					dao.update();
					break;
				case 5:
					dao.allDataPrint();
					break;
				case 6:
					fp.write();
					break;
			}
		}
	}

}
