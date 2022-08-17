import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.UUID;

public class management {
	
	static Map<String, Object> map = new HashMap<>();

	public static void main(String[] args) {
		System.out.println("================================== ȸ������ ���α׷� ==================================");
		int i = 0;
		do {
			menu();
			try (Scanner sc = new Scanner(System.in)) {
				i = sc.nextInt();
				
				switch (i) {
					case 1: {
						System.out.println();
						System.out.println("��ü ���ڵ带 ��ȸ�մϴ�.");
						read();
						sc.nextLine();	// ���ۿ� �����ִ� ���� ����
						
						if(sc.nextLine()!=null) {
							break;
						};
					}
					case 2: {
						System.out.println();
						System.out.println("key�� ���ڵ带 ��ȸ�մϴ�.");
						System.out.print("�˻��� key�� �Է��ϼ��� > ");
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
						System.out.println("�ű� ���ڵ带 �߰��մϴ�.");
						
						// ������ �Է¹ޱ�
						System.out.print("�̸��� �Է��ϼ��� : ");
						String name = sc.next();
						System.out.print("��ȭ��ȣ�� �Է��ϼ��� (ex) 010-1234-1234 : ");
						String phoneNumber = sc.next();
						sc.nextLine();
						System.out.print("�ּҸ� �Է��ϼ��� : ");
						String address = sc.nextLine();
						
						// �� ������ ����
						insert(name, phoneNumber, address);
						if(sc.nextLine()!=null) {
							break;
						};
					}
					case 4: {
						System.out.println();
						System.out.println("key�� ������� ���ڵ带 �����մϴ�.\n");
						System.out.print("������ ���ڵ��� key�� �Է��ϼ��� > ");
						
						sc.nextLine();
						String key = sc.nextLine();
						key = "".equals(key)?null:key;
						
						// ������ ������ �Է¹ޱ�
						System.out.print("�̸��� �Է��ϼ��� : ");
						String name = sc.nextLine();
						System.out.print("��ȭ��ȣ�� �Է��ϼ��� (ex) 010-1234-1234 : ");
						String phoneNumber = sc.nextLine();
						System.out.print("�ּҸ� �Է��ϼ��� : ");
						sc.nextLine();
						String address = sc.nextLine();
						
						// ������ ������ ����
						update(key, name, phoneNumber, address);
						if(sc.nextLine()!=null) {
							break;
						};
					}
					case 5: {
						System.out.println();
						System.out.println("key�� ������� ���ڵ带 �����մϴ�.\n");
						System.out.print("������ ���ڵ��� key�� �Է��ϼ��� > ");
						
						sc.nextLine();
						String key = sc.nextLine();
						key = "".equals(key)?null:key;
						delete(key);
						break;
					}
					case 0: {
						System.out.println();
						System.out.println("���� ���α׷��� �����մϴ�.");
						break;
					}
					default:
						System.out.println();
						System.out.println("�߸� �Է��Ͽ����ϴ�. �޴��� ���ư��ϴ�.\n");
					}
				
			} catch (Exception e) {
				System.out.println("�߸��� �Է��Դϴ�. ȸ������ �ý����� ����˴ϴ�.");
			}
			
		} while (i != 0);
	}
	
	public static void menu() {
		System.out.println("1) ��ü ��ȸ");
		System.out.println("2) key�� ��ȸ");
		System.out.println("3) �ű� ���ڵ� �߰�");
		System.out.println("4) key�� ������� ����");
		System.out.println("5) key�� ������� ����");
		System.out.print("�Է� > ");
	}
	
	public static void read() {
		System.out.println("|                  id                  |  name  |   phoneNumber   |   address   |");
		System.out.println("================================================================================");
		for (String key: map.keySet()) {
			member value = (member) map.get(key);
			System.out.println("| " + key + " |  " + value.getName() + "  |  " + value.getPhoneNumber() + "  |  " + value.getAddress() + "  |\n");
		}
		System.out.print("���ڵ� ��ȸ �Ϸ�. ���͸� ������ �޴��� ���ư��ϴ�.\n");
	}
	
	public static void readKey(String key) {
		try {
			System.out.println("|                  id                  |  name  |   phoneNumber   |   address   |");
			System.out.println("================================================================================");
			member value = (member) map.get(key);
			System.out.println("| " + key + " |  " + value.getName() + "  |  " + value.getPhoneNumber() + "  |  " + value.getAddress() + "  |");
			System.out.print("���ڵ� ��ȸ �Ϸ�. ���͸� ������ �޴��� ���ư��ϴ�.\n");
		} catch (Exception e) {
			System.out.println("�������� �ʴ� key�Դϴ�. ���͸� ������ �޴��� ���ư��ϴ�.\n");
		} 
	}
	
	public static void insert(String name, String phoneNumber, String address) {
		name = "".equals(name)?null:name;
		phoneNumber = "".equals(phoneNumber)?null:phoneNumber;
		address = "".equals(address)?null:address;
		map.put(UUID.randomUUID().toString(), new member(name, phoneNumber, address));
		System.out.print("���ڵ� ���� �Ϸ�. ���͸� ������ �޴��� ���ư��ϴ�.\n");
	}
	
	public static void delete(String key) {
		try {
			member value = (member) map.remove(key);
			System.out.println("|                  id                  |  name  |   phoneNumber   |   address   |");
			System.out.println("================================================================================");
			System.out.println("| " + key + " |  " + value.getName() + "  |  " + value.getPhoneNumber() + "  |  " + value.getAddress() + "  |");
			System.out.print("�� ���ڵ尡 �����Ǿ����ϴ�. ���͸� ������ �޴��� ���ư��ϴ�.\n");
		} catch (Exception e) {
			System.out.println("�������� �ʴ� key�Դϴ�. ���͸� ������ �޴��� ���ư��ϴ�.\n");
		}
	}
	
	public static void update(String key, String name, String phoneNumber, String address) {
		try {
			member value = (member) map.get(key);
			value.setName("".equals(name)?value.getName():name);
			value.setPhoneNumber("".equals(phoneNumber)?value.getPhoneNumber():phoneNumber);
			value.setAddress("".equals(address)?value.getAddress():address);
			map.replace(key, value);
			System.out.print(key+"�� �ش��ϴ� ���ڵ尡 ���ŵǾ����ϴ�. ���͸� ������ �޴��� ���ư��ϴ�.\n");
		} catch (Exception e) {
			System.out.println("�������� �ʴ� key�Դϴ�. ���͸� ������ �޴��� ���ư��ϴ�.\n");
		}
	}
}
