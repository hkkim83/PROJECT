package kr.co.aegis.util;

import java.io.UnsupportedEncodingException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class StringUtil {
	/**
	 * @param value
	 * @param default_value
	 * @return
	 */
	public static long parseLong(String value, long default_value) {
		long return_value = 0l;
		try {
			if (value != null) {
				return_value = Long.parseLong(value.replaceAll(",", ""));
			}
		} catch (Exception ex) {
			return_value = default_value;
		}
		return return_value;
	}

	/**
	 * @param value
	 * @param default_value
	 * @return
	 */
	public static float parseFloat(String value, float default_value) {
		float return_value = 0l;
		try {
			if (value != null) {
				return_value = Float.parseFloat(value.replaceAll(",", ""));
			}
		} catch (Exception ex) {
			return_value = default_value;
		}
		return return_value;
	}

	/**
	 * @param value
	 * @param default_value
	 * @return
	 */
	public static double parseDouble(String value, double default_value) {
		double return_value = 0l;
		try {
			if (value != null && !value.trim().equals("")) {
				return_value = Double.parseDouble(value.replaceAll(",", ""));
			}
		} catch (Exception ex) {
			return_value = default_value;
		}
		return return_value;
	}

	/**
	 * @param value
	 * @param default_value
	 * @return
	 */
	public static int parseInt(String value, int default_value) {
		int return_value = 0;
		try {
			if (value != null) {
				return_value = Integer.parseInt(value.replaceAll(",", ""));
			}
		} catch (Exception ex) {
			return_value = default_value;
			// log.logError(ex.getMessage(), ex);
		}
		return return_value;
	}

	/**
	 * @return
	 */
	public static String[] sort(String[] strValue) {
		String sTemp = null;
		for (int idx = 0; idx < strValue.length; idx++) {
			for (int jdx = 0; jdx < strValue.length; jdx++) {
				if (strValue[idx].compareTo(strValue[jdx]) > 0) {
					sTemp = strValue[jdx];
					strValue[jdx] = strValue[idx];
					strValue[idx] = sTemp;
				}
			}
		}
		return strValue;
	}

	/**
	 * 문자열 파싱
	 * 
	 * @param sData
	 * @param size
	 * @return
	 */
	public static String[] splitData(String sData, String SeParator) {
		String[] result = null;
		try {
			ArrayList<String> arrayList = new ArrayList<String>();
			int idx = 0;
			int iPosStart = 0;
			int iPosEnd = -1;
			//
			for (idx = 0; idx < sData.length(); idx++) {
				if (sData.substring(idx, idx + 1).equals(SeParator)) {
					iPosEnd = idx;
					if (iPosStart <= iPosEnd) {
						arrayList.add(sData.substring(iPosStart, iPosEnd));
					}
					iPosStart = idx + 1;
				}
			}
			if (iPosStart < idx) {
				if (iPosStart < sData.length()) {
					arrayList.add(sData.substring(iPosStart, sData.length()));
				}
			}
			result = new String[arrayList.size()];
			for (idx = 0; idx < arrayList.size(); idx++) {
				result[idx] = arrayList.get(idx);
			}
		} catch (Exception ex) {
		}

		return result;
	}

	/**
	 * 빈값 체크
	 * @param str
	 * @return
	 */
	public static boolean isNull(String str) {
		if(str == null) str = "";
		else str = str.trim();
		return (str.length() == 0);
	}

	/**
	 * 인코딩 변경
	 * @param str
	 * @return
	 */
	public static String convertKorToUTF(String str) {
		try {
			return new String(str.getBytes("8859_1"), "UTF-8");
		} catch (UnsupportedEncodingException ex) {
		}
		return "";
	}

	/**
	 * 인코딩 변경
	 * @param str
	 * @return
	 */
	public static String convertUTFToKor(String str) {
		try {
			return new String(str.getBytes("UTF-8"), "8859_1");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "";
	}

	/**
	 * rpad
	 * @param str
	 * @param len
	 * @param addStr
	 * @return
	 */
	public static String rpad(String str, int len, String addStr) {
		String result = str;
        int templen   = len - result.length();

        for (int i = 0; i < templen; i++){
              result = result + addStr;
        }
        
        return result;
	}

	/**
	 * lpad
	 * @param str
	 * @param len
	 * @param addStr
	 * @return
	 */
	public static String lpad(String str, int len, String addStr) {
		String result = str;
        int templen   = len - result.length();

        for (int i = 0; i < templen; i++){
              result = addStr + result;
        }
        
        return result;
	}
	
	/**
	 * 문자열 자르기
	 * @param str
	 * @param beginIndex
	 * @param endIndex
	 * @return
	 */
	public static String subStr(String str, int beginIndex, int endIndex) {
		String result = "";
		if(isNull(str)) return result;
		if(beginIndex > -1)
			result = str.substring(beginIndex, endIndex);
		else 
			result = str.substring(str.length()+endIndex, str.length()+beginIndex);
		return result;
	}
	
	/**
	 * 글자열 자르기
	 * @param str
	 * @param endIndex
	 * @return
	 */
	public static String subStr(String str, int endIndex) {
		String result = "";
		if(isNull(str)) return result;		
		if(endIndex > -1)
			result = subStr(str, 0, endIndex);
		else 
			result = subStr(str, str.length()+endIndex, str.length());
		return result;
	}

	
	/**
	 * 글자열 자르기
	 * @param str
	 * @param endIndex
	 * @return
	 */
	public static String subStr2(String str, int endIndex) {
		String result = "";
		if(isNull(str)) return result;		
		if(endIndex > -1)
			result = subStr(str, 0, endIndex);
		else 
			result = subStr(str, 0, str.length()+endIndex);
		return result;
	}
	
	/**
	 * 우선번호, 우선권국가, 우선권적용일 파싱
	 * @param str
	 * @param regex
	 * @return
	 */
	public static String parsePriority(String str, String regex) {
		StringBuffer sb = new StringBuffer();
		Pattern pattern = Pattern.compile(regex);
		Matcher match = pattern.matcher(str.toString());
		while(match.find()) {
			sb.append(match.group().trim()).append(", ");
		}
		if(StringUtil.isNull(sb.toString()))
			return sb.toString();
		else 
			return subStr(sb.toString(), 0, sb.length()-2);
	}
	
	/**
	 * 대표청구항 파싱
	 * @param str
	 * @return
	 */
	public static String parseClaim(String str) {
		StringBuffer sb = new StringBuffer();
		String arr[] = str.split("[\\[]");
		for(String s : arr) {
			if(!isNull(s) && s.indexOf("]삭제") == -1) {
				sb.append("[").append(s);
				break;
			}
		}
		return sb.toString();
	}
	
	/**
	 * 줄바꿈
	 * @param src
	 * @return
	 */
	public static  String makeSentence(String src) {
		src = src.replaceAll("\n\n", "\n");
		src = src.replaceAll("\n", "");
		src = src.replaceAll("; and", "\\@1");
		src = src.replaceAll("\\@1", "\\@1\n");
		src = src.replaceAll("1\\:", "\\@3");
		src = src.replaceAll("청구항 1항", "\\@3");
		src = src.replaceAll("1\\.1\\.", "\\@3");
		src = src.replaceAll("있어서\\,", "있어서\\,\n");
		src = src.replaceAll("wherein", "\nwherein");
		src = src.replaceAll("\\;및", "\\; 및");
		src = src.replaceAll("\\; 및", "\\@2");
		src = src.replaceAll("\\@2", "\\@2\n");
		src = src.replaceAll("\\:", "\\:\n");
		src = src.replaceAll("\\.", "\\.\n");
		src = src.replaceAll("\\,", "\\,\n");
		src = src.replaceAll("\\@1", "\\; and");
		src = src.replaceAll("\\@2", "\\; 및");
		src = src.replaceAll("\\@3", "1\\.");
		return src;
	}
	
	/**
	 * 콤마찍기
	 * @param num
	 * @return
	 */
	public static String comma(int num) {
		DecimalFormat df = new DecimalFormat("#,##0");
		return df.format(num);
	}
	
	/**
	 * 콤마찍기
	 * @param num
	 * @return
	 */
	public static String comma(long num) {
		DecimalFormat df = new DecimalFormat("#,##0");
		return df.format(num);
	}
	
	/**
	 * 콤마찍기
	 * @param num
	 * @return
	 */
	public static String comma(String data) {
		DecimalFormat df = new DecimalFormat("#,##0");
		return df.format(Integer.parseInt(data));
	}
	
	/**
	 * 콤마제거
	 * @param data
	 * @return
	 */
	public static String uncomma(String data) {
		return data.replaceAll("\\,", "");
	}
	
	/**
	 * 문자교체 
	 * @param str
	 * @param regex
	 * @param replacement
	 * @return
	 */
	public static String replaceString(String str, String regex, String replacement) {
		if(isNull(str)) return "";
		String[] arr = str.split("\\s");
		return isNull(arr[0]) ? "" : arr[0].replaceAll(regex, replacement);
	}
	
	/**
	 * 개행 <br>
	 * 로 변경
	 * 
	 * @param str
	 * @return
	 */
	public static void convertToBr(Map<String, String> map, String key) {
	    String value = map.get(key);
	    if(isNull(value)) return;
	    System.out.println("before::::::"+value);
	    value = value.replace(", Inc", "");
	    value = value.replace(",", "<br>");
	    value = value.replace("|", "<br>");
	    System.out.println("after::::::"+value);
	    map.put(key, value);
	}
}
