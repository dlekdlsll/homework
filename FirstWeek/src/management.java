import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.UUID;

public class management {
	
	static Map<String, Object> map = new HashMap<>();

	public static void main(String[] args) {
		System.out.println("================================== 회원관리 프로그램 ==================================");
		int i = 0;
		do {
			menu();
			try (Scanner sc = new Scanner(System.in)) {
				i = sc.nextInt();
				
				switch (i) {
					case 1: {
						System.out.println();
						System.out.println("전체 레코드를 조회합니다.");
						read();
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
						String name = sc.nextLine();
						System.out.print("전화번호를 입력하세요 (ex) 010-1234-1234 : ");
						String phoneNumber = sc.nextLine();
						System.out.print("주소를 입력하세요 : ");
						sc.nextLine();
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
						key = "".equals(key)?null:key;
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
				
			} catch (Exception e) {
				System.out.println("잘못된 입력입니다. 회원관리 시스템이 종료됩니다.");
			}
			
		} while (i != 0);
	}
	
	public static void menu() {
		System.out.println("1) 전체 조회");
		System.out.println("2) key로 조회");
		System.out.println("3) 신규 레코드 추가");
		System.out.println("4) key를 기반으로 갱신");
		System.out.println("5) key를 기반으로 삭제");
		System.out.print("입력 > ");
	}
	
	public static void read() {
		System.out.println("|                  id                  |  name  |   phoneNumber   |   address   |");
		System.out.println("================================================================================");
		for (String key: map.keySet()) {
			member value = (member) map.get(key);
			System.out.println("| " + key + " |  " + value.getName() + "  |  " + value.getPhoneNumber() + "  |  " + value.getAddress() + "  |\n");
		}
		System.out.print("레코드 조회 완료. 엔터를 누르면 메뉴로 돌아갑니다.\n");
	}
	
	public static void readKey(String key) {
		try {
			System.out.println("|                  id                  |  name  |   phoneNumber   |   address   |");
			System.out.println("================================================================================");
			member value = (member) map.get(key);
			System.out.println("| " + key + " |  " + value.getName() + "  |  " + value.getPhoneNumber() + "  |  " + value.getAddress() + "  |");
			System.out.print("레코드 조회 완료. 엔터를 누르면 메뉴로 돌아갑니다.\n");
		} catch (Exception e) {
			System.out.println("존재하지 않는 key입니다. 엔터를 누르면 메뉴로 돌아갑니다.\n");
		} 
	}
	
	public static void insert(String name, String phoneNumber, String address) {
		name = "".equals(name)?null:name;
		phoneNumber = "".equals(phoneNumber)?null:phoneNumber;
		address = "".equals(address)?null:address;
		map.put(UUID.randomUUID().toString(), new member(name, phoneNumber, address));
		System.out.print("레코드 저장 완료. 엔터를 누르면 메뉴로 돌아갑니다.\n");
	}
	
	public static void delete(String key) {
		try {
			member value = (member) map.remove(key);
			System.out.println("|                  id                  |  name  |   phoneNumber   |   address   |");
			System.out.println("================================================================================");
			System.out.println("| " + key + " |  " + value.getName() + "  |  " + value.getPhoneNumber() + "  |  " + value.getAddress() + "  |");
			System.out.print("위 레코드가 삭제되었습니다. 엔터를 누르면 메뉴로 돌아갑니다.\n");
		} catch (Exception e) {
			System.out.println("존재하지 않는 key입니다. 엔터를 누르면 메뉴로 돌아갑니다.\n");
		}
	}
	
	public static void update(String key, String name, String phoneNumber, String address) {
		try {
			member value = (member) map.get(key);
			value.setName("".equals(name)?value.getName():name);
			value.setPhoneNumber("".equals(phoneNumber)?value.getPhoneNumber():phoneNumber);
			value.setAddress("".equals(address)?value.getAddress():address);
			map.replace(key, value);
			System.out.print(key+"에 해당하는 레코드가 갱신되었습니다. 엔터를 누르면 메뉴로 돌아갑니다.\n");
		} catch (Exception e) {
			System.out.println("존재하지 않는 key입니다. 엔터를 누르면 메뉴로 돌아갑니다.\n");
		}
	}
}
