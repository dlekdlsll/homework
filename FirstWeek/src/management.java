import java.util.Scanner;

public class management {

	public static void main(String[] args) {
		int i = 0;
		do {
			menu();
			Scanner sc = new Scanner(System.in);
			
			i = sc.nextInt();
			
			switch (i) {
				case 1: {
					System.out.println("��ü ���ڵ带 ��ȸ�մϴ�.");
					break;
				}
				case 2: {
					System.out.println("key�� ���ڵ带 ��ȸ�մϴ�.");
					break;
				}
				case 3: {
					System.out.println("�ű� ���ڵ带 �߰��մϴ�.");
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

}
