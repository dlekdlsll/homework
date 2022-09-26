package exam_doubleNewDouble;

public class doubleNewDouble {

	public static void main(String[] args) {
		
		long startTime = System.nanoTime();
		Double.parseDouble("10");
		long endTime = System.nanoTime();
		System.out.println(String.format("코드 실행 시간: %20dns", endTime - startTime));
		
		startTime = System.nanoTime();
		new Double("10");
		endTime = System.nanoTime();
		System.out.println(String.format("코드 실행 시간: %20dns", endTime - startTime));

	}

}
