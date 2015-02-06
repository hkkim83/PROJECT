import java.util.HashMap;
import java.util.Map;


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
		
		Map<String, String> map = new HashMap<String, String>();
		map.put("num", "567");
		CC c = new CC(map);
		c.setAA("efg");
		System.out.println(c.getAA());
		System.out.println(map);
	}

}
