import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.UUID;

public class management {
	
	static Map<String, Object> map = new HashMap<>();

	public static void main(String[] args) {
		int i = 0;
		
		do {
			menu();
			Scanner sc = new Scanner(System.in);
			
			i = sc.nextInt();
			
			switch (i) {
				case 1: {
					System.out.println("전체 레코드를 조회합니다.");
					read();
					break;
				}
				case 2: {
					System.out.println("key로 레코드를 조회합니다.");
					break;
				}
				case 3: {
					System.out.println("신규 레코드를 추가합니다.");
					 String name = sc.next();
					 String phoneNumber = sc.next();
					 String address = sc.next();
					 insert(name, phoneNumber, address);
					break;
				}
				case 4: {
					System.out.println("key를 기반으로 레코드를 갱신합니다.");
					break;
				}
				case 5: {
					System.out.println("key를 기반으로 레코드를 삭제합니다.");
					break;
				}
				case 0: {
					System.out.println("관리 프로그램을 종료합니다.");
					break;
				}
				default:
					System.out.println("잘못 입력하였습니다. 메뉴 화면으로 돌아갑니다.");
				}
			
		} while (i != 0);
	}
	
	public static void menu() {
		System.out.println("1) 전체 조회");
		System.out.println("2) key로 조회");
		System.out.println("3) 신규 레코드 추가");
		System.out.println("4) key를 기반으로 갱신");
		System.out.println("5) key를 기반으로 삭제");
	}
	
	public static void read() {
		System.out.println("|                  id                  |  name  |   phoneNumber   |  address  |");
		System.out.println("==============================================================================");
		for (String key: map.keySet()) {
			member value = (member) map.get(key);
			System.out.println("| " + key + " |  " + value.getName() + "  |  " + value.getPhoneNumber() + "  |  " + value.getAddress() + "  |");
		}
	}
	
	public static void insert(String name, String phoneNumber, String address) {
		map.put(UUID.randomUUID().toString(), new member(name, phoneNumber, address));
	}

}
