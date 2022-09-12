package exam_exception;

public class ExceptionTest {
	
	public static void main(String[] args) {
		try {
			System.out.println("throw 호출 전");
			myException();
			System.out.println("throw 호출 후");
		} catch(Exception e) {
			System.out.println("MyClass에서 예외 발생");
		}
		
		try {
			System.out.println("throws 호출 전");
			myException2();
			System.out.println("throws 호출 후");
		} catch(Exception e) {
			System.out.println("MyClass에서 예외 발생");
		}
	}
	
	static public void myException() {
		try {
			throw new Exception();
		} catch(Exception e) {
			e.printStackTrace();
			System.out.println("MyException에서 예외 발생");
		}
	}
	
	static public void myException2() throws Exception{
		throw new Exception();
	}
}
