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
					System.out.println("��ü ���ڵ带 ��ȸ�մϴ�.");
					read();
					break;
				}
				case 2: {
					System.out.println("key�� ���ڵ带 ��ȸ�մϴ�.");
					break;
				}
				case 3: {
					System.out.println("�ű� ���ڵ带 �߰��մϴ�.");
					 String name = sc.next();
					 String phoneNumber = sc.next();
					 String address = sc.next();
					 insert(name, phoneNumber, address);
					break;
				}
				case 4: {
					System.out.println("key�� ������� ���ڵ带 �����մϴ�.");
					break;
				}
				case 5: {
					System.out.println("key�� ������� ���ڵ带 �����մϴ�.");
					break;
				}
				case 0: {
					System.out.println("���� ���α׷��� �����մϴ�.");
					break;
				}
				default:
					System.out.println("�߸� �Է��Ͽ����ϴ�. �޴� ȭ������ ���ư��ϴ�.");
				}
			
		} while (i != 0);
	}
	
	public static void menu() {
		System.out.println("1) ��ü ��ȸ");
		System.out.println("2) key�� ��ȸ");
		System.out.println("3) �ű� ���ڵ� �߰�");
		System.out.println("4) key�� ������� ����");
		System.out.println("5) key�� ������� ����");
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
