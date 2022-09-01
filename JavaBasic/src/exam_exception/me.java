package exam_exception;

public class me {
	static int dishes = 20;
	
	public void washing(int dishes) {
		System.out.println("내가 설거지를 합니다.");
		if (this.dishes < 0) {
			try {
				throw new Exception();
			} catch (Exception e) {
				System.out.println("힘들어서 더이상 설거지를 못합니다.");
			}
		}
	}
	
	public static void throwExample() throws Exception {
		throw new Exception();
	}
}
