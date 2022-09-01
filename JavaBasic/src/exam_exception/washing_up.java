package exam_exception;

public class washing_up {

	public static void main(String[] args) {
		int dishes = 100;
		
		while (dishes != 0) {
			try {
				myTurn(dishes);
			} catch (Exception e) {
				
			}
		}
	}
	
	
	public static int dishwasherTurn(int dishes) {
		System.out.println("식기세척기가 설거지를 합니다.");
		int dishwasher = 100;
		dishes -= 10;
		dishwasher -= 10;
		return dishes;
	}
	
	public static void washing(int dishes1) {
		if (dishes1 == 0) {
			throw new ~~Exception("더이상 설거지를 할 수 없습니다. 그릇이 없어요.");
		}
	}

}
