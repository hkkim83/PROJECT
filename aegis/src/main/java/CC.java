import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class CC {
	
	private Map<String, String> AA;
	
	public CC(Map<String, String> map) { AA = map; }
	
	public void setAA(String str) {AA.put("abc", str);}
	public Map<String, String> getAA() { return AA; }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String AA = "EP02562026A1";
//		System.out.println(AA.substring(4,6));
//		System.out.println(AA.substring(2,AA.length()));
//		System.out.println(StringUtil.subStr(AA, AA.length()-2));	// 뒤 2자리 자르기 
//		String BB = "2014US017380";
//		String str[] = BB.split("[A-z]{2}");
//		for(String abc : str)
//			System.out.println(abc);
		
//		String CC = "JP08186905A";
//		String result = CC.replaceAll("[A-z]", "");	// 영문삭제후 숫자만 남은 공개번호
//		String year = StringUtil.subStr(result, 4);
//		int iYY = Integer.parseInt(year);			
//		if(result.length() == 10) {
//			if(iYY <= 1988) {	// 1988년 이하일 경우 
//				iYY -= 1925;
//				
//			} else {				// 1988년 초과일 경우 
//				iYY -= 1988;
//			}
//			year = StringUtil.lpad(String.valueOf(iYY), 2, "0");
//			result = year + StringUtil.subStr(result, -6);
//		} 
//		System.out.println(result);
		
		String ubc = "12345";
		System.out.println(Integer.valueOf(ubc));
		
		Map<String, String> map = new HashMap<String, String>();
		map.put("num", "567");
		CC c = new CC(map);
		c.setAA("efg");
//		System.out.println(c.getAA());
//		System.out.println(map);
		
		String abc = "snake, bat, dog, bobcat,";
		Matcher matcher1 = Pattern.compile("\\b(?:(?!cat)\\w)+\\b").matcher(abc);
		while(matcher1.find())
			System.out.println(matcher1);
		
		String str = "aab*AP=[((alal+unmo+nco))]*(uludf)*IN=[slslfeu+eufo+ncofeuo]*(TL=[(abc+efu+cegf)]+AB=[lalal+uefu+fjou]+CL=[nuueo+noue+eiufkl.+alau]+TL=[ufufleufo++daof++alfueo])";
//		str = "IPC=[H04N+H04L]*TL=[(imag+video+camera+영상+비디오+비데오+카메라)]*(object+target+body+대상+목표+타켓+물체)*(인식+인지+트래킹+트랙+검출+디텍터)*(보안+감시+탐지)";
//		Matcher matcher = Pattern.compile(".+?=\\[").matcher(str);
//		Matcher matcher = Pattern.compile("\\w{2}=\\[.+?\\]").matcher(str);
//		Matcher matcher = Pattern.compile("([^(TL|AB|CL)]{2})=\\[.+?\\]").matcher(str);
		Matcher matcher = Pattern.compile("\\b(?:(?!TL))=\\[.+?\\]").matcher(str);

		while(matcher.find()) {
			System.out.println(matcher);
//			String arr[] = str1.split("=");
// 			if(!arr[0].startsWith("TL") && !arr[0].startsWith("AB") && !arr[0].startsWith("CL")) {
//				System.out.println("str1:::::"+str1+":::::"+str.replaceAll("\\["+str1+"\\]", ""));
//				str.replaceAll(str1, "");
//			}
		}
		
		Map<String, String> temp = new HashMap<String, String>();
		temp.put("abc", "12354");
        int abc1 = Integer.valueOf(temp.get("abc"));
        int abc2 = Integer.parseInt(temp.get("abc"));		
		
	}

}
