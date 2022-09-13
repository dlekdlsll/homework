package exam_interface;

public class run {

	public static void main(String[] args) {
		codeLogic coder = new codeLogic();
		
		String encodeStr = coder.encode("1234");
		System.out.println(encodeStr);
		
		System.out.println(coder.decode(encodeStr));
	}

}
