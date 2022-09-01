package exam_interface;

public class codeLogic2 implements code {
	
	@Override
	public String encode(String str) {
		str  = str + "##" + str;
		return str;
	}

	@Override
	public String decode(String str) {
		str = str.substring(0, 4);
		return str;
	}

}
