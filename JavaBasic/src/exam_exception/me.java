package exam_exception;

public class me {
	static int dishes = 20;
	
	public int washing(int dishes) {
		System.out.println("내가 설거지를 합니다.");
		
		try {
				this.dishes -= 1;
				dishes -= 1;
			} catch (nodishesException e) {
				
			}
	}
}
