import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;
import java.util.UUID;

public class management {
	
	static Set<HashMap<String, Object>> set = new HashSet<HashMap<String, Object>>();

	public static void main(String[] args) {
	
		Scanner sc = new Scanner(System.in);
		int i = 0;
		do {
				menu();
				i = sc.nextInt();
				
				switch (i) {
				case 1: {
					System.out.println();
					System.out.println("전체 레코드를 조회합니다.");
					read(set);
					sc.nextLine();	// 버퍼에 남아있는 공백 제거
					
					if(sc.nextLine()!=null) {
						break;
					};
				}
				case 2: {
					System.out.println();
					System.out.println("key로 레코드를 조회합니다.");
					System.out.print("검색할 key를 입력하세요 > ");
					sc.nextLine();
					String key = sc.nextLine();
					key = "".equals(key)?null:key;
					readKey(key);
					if(sc.nextLine()!=null) {
						break;
					};
				}
				case 3: {
					System.out.println();
					System.out.println("신규 레코드를 추가합니다.");
					
					// 데이터 입력받기
					System.out.print("이름을 입력하세요 : ");
					String name = sc.next();
					System.out.print("전화번호를 입력하세요 (ex) 010-1234-1234 : ");
					String phoneNumber = sc.next();
					sc.nextLine();
					System.out.print("주소를 입력하세요 : ");
					String address = sc.nextLine();
					
					// 새 데이터 저장
					insert(name, phoneNumber, address);
					if(sc.nextLine()!=null) {
						break;
					};
				}
				case 4: {
					System.out.println();
					System.out.println("key를 기반으로 레코드를 갱신합니다.\n");
					System.out.print("수정할 레코드의 key를 입력하세요 > ");
					
					sc.nextLine();
					String key = sc.nextLine();
					key = "".equals(key)?null:key;
					
					// 변경할 데이터 입력받기
					System.out.print("이름을 입력하세요 : ");
					String name = sc.next();
					System.out.print("전화번호를 입력하세요 (ex) 010-1234-1234 : ");
					String phoneNumber = sc.next();
					sc.nextLine();
					System.out.print("주소를 입력하세요 : ");
					String address = sc.nextLine();
					
					// 갱신할 데이터 저장
					update(key, name, phoneNumber, address);
					if(sc.nextLine()!=null) {
						break;
					};
				}
				case 5: {
					System.out.println();
					System.out.println("key를 기반으로 레코드를 삭제합니다.\n");
					System.out.print("삭제할 레코드의 key를 입력하세요 > ");
					
					sc.nextLine();
					String key = sc.nextLine();
					key = "".equals(key)?null:"["+key+"]";
					delete(key);
					break;
				}
				case 0: {
					System.out.println();
					System.out.println("관리 프로그램을 종료합니다.");
					break;
				}
				default:
					System.out.println();
					System.out.println("잘못 입력하였습니다. 메뉴로 돌아갑니다.\n");
				}
		} while (i != 0);
		
		sc.close();
	}
	
	public static void menu() {
		System.out.println("================================ 회원관리 프로그램 ================================");
		System.out.println("숫자를 입력하여 메뉴를 선택하세요.");
		System.out.println("1) 전체 조회");
		System.out.println("2) key로 조회");
		System.out.println("3) 신규 레코드 추가");
		System.out.println("4) key를 기반으로 갱신");
		System.out.println("5) key를 기반으로 삭제");
		System.out.print("입력 > ");
	}
	
	public static void header() {
		System.out.println("|                  id                  |  name  |   phoneNumber   |   address  |");
		System.out.println("================================================================================");
	}
	
	public static void insert(String name, String phoneNumber, String address) {
		
		HashMap<String, Object> map = new HashMap<String, Object>();
		
		name = "".equals(name)?null:name;
		phoneNumber = "".equals(phoneNumber)?null:phoneNumber;
		address = "".equals(address)?null:address;
		
		map.put("key", UUID.randomUUID().toString());
		map.put("name", name);
		map.put("phoneNumber", phoneNumber);
		map.put("address", address);
		set.add(map);
		
		System.out.print("레코드 저장 완료. 엔터를 누르면 메뉴로 돌아갑니다.");
	}
	
//	public static void read(Set<HashMap<String, Object>> set) {
//		header();
//		Iterator<HashMap<String, Object>> it = set.iterator();
//		while (it.hasNext()) {
//			HashMap<String, Object> record = it.next();
//			System.out.println("| " + record.get("key") + " |  " + record.get("name") + "  |  " + record.get("phoneNumber") + "  |  " + record.get("address") + "  |");
//		}
//		System.out.print("레코드 조회 완료. 엔터를 누르면 메뉴로 돌아갑니다.");
//	}
	
	public static void read(Set<HashMap<String, Object>> set) {
		header();
		set.stream().forEach(System.out::println);
	}
	
	public static void readKey(String key) {
		header();
		Iterator<HashMap<String, Object>> it = set.iterator();
		while (it.hasNext()) {
			HashMap<String, Object> record = it.next();
			if (record.get("key").equals(key)) {
				System.out.println("| " + record.get("key") + " |  " + record.get("name") + "  |  " + record.get("phoneNumber") + "  |  " + record.get("address") + "  |");
			}
		}
		System.out.print("레코드 조회 완료. 엔터를 누르면 메뉴로 돌아갑니다.");
	}
	
	public static void update(String key, String name, String phoneNumber, String address) {
		Iterator<HashMap<String, Object>> it = set.iterator();
		HashMap<String, Object> map = new HashMap<String, Object>();
		try {
			while (it.hasNext()) {
				HashMap<String, Object> record = it.next();
				map.put("key", key);
				map.put("name", name);
				map.put("phoneNumber", phoneNumber);
				map.put("address", address);
				set.add(map);
				if (record.get("key").equals(key)) {
					set.remove(record);
					set.add(map);
					System.out.println("레코드 수정 완료. 엔터를 누르면 메뉴로 돌아갑니다.");
				} else {
					System.out.println("레코드가 수정되지 않았습니다.");
				}
			}
			System.out.print("엔터를 누르면 메뉴로 돌아갑니다.\n");
		} catch (Exception e) {
			System.out.println("존재하지 않는 key입니다. 엔터를 누르면 메뉴로 돌아갑니다.\n");
		}
	}
	
	public static void delete(String key) {
		Iterator<HashMap<String, Object>> it = set.iterator();
		while (it.hasNext()) {
			HashMap<String, Object> record = it.next();
			if (record.get("key").equals(key)) {
				set.remove(record);
				System.out.println("레코드 삭제 완료. 엔터를 누르면 메뉴로 돌아갑니다.");
			}
		}
	}
}
