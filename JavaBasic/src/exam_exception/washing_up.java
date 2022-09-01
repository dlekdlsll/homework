package exam_exception;

public class washing_up {

	public static void main(String[] args) {
		int dishes = 100;
		
		while (dishes != 0) {
			try {
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
	

}
