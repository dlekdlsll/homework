package exam_interface;

public class codeLogic implements code {
	
	@Override
	public String encode(String str) {
		for (int i = 0; i < 3; i++)
			str += str;
		return str;
	}

	@Override
	public String decode(String str) {
		str = str.substring(0, 4);
		return str;
	}

}
