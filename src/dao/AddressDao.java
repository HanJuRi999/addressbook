package dao;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import dto.AddressDto;
import singleton.Singleton;

public class AddressDao {

	// 데이터를 편집하는 클래스
	
		// composition
		private Scanner sc = new Scanner(System.in);
		
		// private List<AddressDto> addressList = null;
		
		/*
		final int COUNT = 100;
		
		// 주소를 저장할 100개의 객체(instance)
		private AddressDto addressBook[] = new AddressDto[COUNT];
		private int counter;
		*/
		
		public AddressDao() {
			// counter = 0;
			// addressList = new ArrayList<AddressDto>();
		}
		
		
		
		// 데이터 추가
		public void insert() {
			// TODO : insert()
			System.out.println("데이터를 추가합니다.");
			
			System.out.print("이름 = ");
			String name = sc.next();
			
			System.out.print("나이 = ");
			int age = sc.nextInt();
			
			System.out.print("전화번호 = ");
			String phone = sc.next();
			
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));		
			
			System.out.print("주소 = ");
			String address = "";
			try {
				address = br.readLine();
			} catch (IOException e) {			
				e.printStackTrace();
			}
			
			System.out.println("메모 = ");
			String memo = "";
			try {
				memo = br.readLine();
			} catch (IOException e) {			
				e.printStackTrace();
			}
			
			// AddressDto dto = new AddressDto(name, age, phone, address, memo);
			Singleton s = Singleton.getInstance();
			s.addressList.add(new AddressDto(name, age, phone, address, memo));
			
			// addressBook[counter] = new AddressDto(name, age, phone, address, memo);
			// counter++;
		}
		
		// 데이터 삭제
		public void delete() {	// 24 -> 0, "홍길동" -> ""
			// TODO : delete()
			System.out.println("삭제할 지인의 이름 >>");
			String name = sc.next();
			
			// 검색
			/*
			int index = -1;
			for (int i = 0; i < addressBook.length; i++) {
				if(addressBook[i] != null) {
					if(name.equals(addressBook[i].getName())) {
					index = i;
					break;
					}
				}
			}
			*/
			
			int index = search(name);
			
			// 삭제
			if(index == -1) {
				System.out.println("정보를 찾을 수가 없습니다.");
			} else {
				/*
				addressBook[index].setName("");
				addressBook[index].setAge(0);
				addressBook[index].setPhone("");
				addressBook[index].setAddress("");
				addressBook[index].setMemo("");
				*/
				
				Singleton s = Singleton.getInstance();
				s.addressList.remove(index);
				
				System.out.println("정보를 삭제하였습니다.");
			}
		}
		
		// 데이터 검색
		public void select() {	// 이름으로 검색
			// TODO : select()
			System.out.println("검색할 지인의 이름 >>");
			String name = sc.next();
			/*
			int index = -1;
			for (int i = 0; i < addressBook.length; i++) {
				if(addressBook[i] != null) {
					if(name.equals(addressBook[i].getName())) {
						System.out.println(Arrays.toString(addressBook));
					}
				}
			}
			*/
			Singleton s = Singleton.getInstance();
			
			List<AddressDto> findNameList = new ArrayList<AddressDto>();
			
			for (int i = 0; i < s.addressList.size(); i++) {
				AddressDto dto = s.addressList.get(i);
				if(name.equals(dto.getName())) {
					findNameList.add(dto);
				}
			}
			if(findNameList.size() == 0) {
				System.out.println("검색하신 정보가 없습니다.");
				return;
			}
			
			System.out.println("검색 결과 ====== ");
			for (int i = 0; i < findNameList.size(); i++) {
				AddressDto dto = findNameList.get(i);
				System.out.println(dto.toString());
			}
		}
		
		
		// 데이터 수정
		public void update() {
			// TODO : update()
			System.out.println("수정할 지인의 이름 >>");
			String name = sc.next();
			
			// 검색
			int index = search(name);
			if(index == -1) {
				System.out.println("정보를 찾을 수가 없습니다.");
				return;
			} 
			
			// 수정
			System.out.println("전화번호 >> ");
			String phone = sc.next();
			
			System.out.println("주소 >> ");
			String address = sc.next();
			
			System.out.println("메모 >> ");
			String memo = sc.next();
			
			/*
			addressBook[index].setPhone(phone);
			addressBook[index].setAddress(address);
			addressBook[index].setMemo(memo);
			*/
			Singleton s = Singleton.getInstance();
			
//			addressList.get(index).setPhone(phone);
//			addressList.get(index).setAddress(address);
//			addressList.get(index).setMemo(memo);
		
			AddressDto dto = s.addressList.get(index);
			dto.setPhone(phone);
			dto.setAddress(address);			
			dto.setMemo(memo);
			
			System.out.println("수정을 완료했습니다.");
			
		}
		
		public int search(String name) {
			/*
			int index = -1;
			for (int i = 0; i < addressBook.length; i++) {
				if(addressBook[i] != null) {
					if(name.equals(addressBook[i].getName())) {
					index = i;
					break;
					}
				}
				
			}
				*/
					Singleton s = Singleton.getInstance();		
			
					int index = -1;
					for(int i = 0; i < s.addressList.size(); i++) {
						AddressDto dto = s.addressList.get(i);
						if(name.equals(dto.getName())) {
							index = i;
							break;
						}
					}
					return index;
			}
			// return index;
		
		
		
		// 확인
		public void allDataPrint() {
			// TODO : allDataPrint()
			/*
			for (int i = 0; i < addressBook.length; i++) {
				if(addressBook[i] != null) {
					System.out.println(addressBook[i].toString());
				}
			}*/
			
			Singleton s = Singleton.getInstance();
			
			if(s.addressList.isEmpty()) {	// addressList.size() == 0
				System.out.println("데이터가 없습니다.");
				return;
			}
			
			for (int i = 0; i < s.addressList.size(); i++) {
				System.out.println(s.addressList.get(i).toString());
			}
		}

}
