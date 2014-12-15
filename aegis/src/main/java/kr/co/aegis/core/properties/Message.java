package kr.co.aegis.core.properties;

public class Message {

	public static final String RESULT_NAME = "RESULT_CD";
	public static final String RESULT_TEXT = "RESULT_MSG";
	

	public static final String SUCC_0001 = "SUCC_0001:정상적으로 처리되었습니다.";
	
	public static final String ERR_0001 = "ERR_0001:실패";
	public static final String ERR_0002 = "ERR_0002:세션이 종료되었습니다.";
	public static final String ERR_0003 = "ERR_0003:올바르지 않은 파라미터";
	public static final String ERR_0004 = "ERR_0004:쿠폰비밀번호가 일치하지 않습니다.";
	public static final String ERR_0005 = "ERR_0005:삭제된 고객입니다.";
	public static final String ERR_0006 = "ERR_0006:이미 등록된 PUSH ID";
	public static final String ERR_0007 = "ERR_0007:존재하지않는 UUID입니다.";
	public static final String ERR_0008 = "ERR_0008:버전이 올바르지 않습니다.";
	public static final String ERR_0009 = "ERR_0009:버전정보가 올바르지 않습니다.";

	public static final String ERR_0011 = "ERR_0011:아이디 혹은 비밀번호가 올바르지 않습니다.";
	public static final String ERR_0012 = "ERR_0012:비밀번호가 올바르지 않습니다.";
	public static final String ERR_0013 = "ERR_0013:필수입력사항 입니다.";
	public static final String ERR_0014 = "ERR_0014:가게아이디가 이미 사용중입니다.";
	public static final String ERR_0015 = "ERR_0015:퇴사한 직원의 계정 입니다.\n관리자에게 문의하세요.";
	public static final String ERR_0016 = "ERR_0016:파일용량 초과입니다.\n최대 #{0} 까지 업르드 가능합니다.";
	public static final String ERR_0017 = "ERR_0017:휴직중인 직원의 계정 입니다.\n관리자에게 문의하세요.";
	public static final String ERR_0018 = "ERR_0018:접근권한이 없는 계정 입니다.";
	public static final String ERR_0019 = "ERR_0019:승인대기중인 계정 입니다.";
	public static final String ERR_0020 = "ERR_0020:일시정지중인 계정 입니다.";
	public static final String ERR_0021 = "ERR_0021:처리할 수 없는 상태입니다.";
	public static final String ERR_0022 = "ERR_0022:비밀번호를 변경하세요.";
	public static final String ERR_0023 = "ERR_0023:중복데이터 입니다.";
	public static final String ERR_0024 = "ERR_0024:데이터 정합성 오류입니다.\n계속해서 문제가 발생하면\n관리자에게 문의하세요.";
	public static final String ERR_0025 = "ERR_0025:가게이름이 이미 사용중입니다.";
	public static final String ERR_0026 = "ERR_0026:JPEG(.jpg) 파일만 업로드해 주세요.";
	public static final String ERR_0027 = "ERR_0027:#{0} 사이즈의 이미지를 업로드해 주세요.";
	public static final String ERR_0028 = "ERR_0028:삭제된 쿠폰입니다.";
	public static final String ERR_0029 = "ERR_0029:이미 사용한 쿠폰입니다.";
	public static final String ERR_0030 = "ERR_0030:비정상 접근";
	public static final String ERR_0031 = "ERR_0031:파일이 존재하지 않습니다.";
	public static final String ERR_0032 = "ERR_0032:파일 형식이 맞지 않습니다.";
	public static final String ERR_0033 = "ERR_0033:파일을 업로드할 수 없습니다.";
	public static final String ERR_0034 = "ERR_0034:아이디가 존재하지 않습니다.\n관리자에게 문의하세요.";
	
	public static final String ERR_9996 = "ERR_9996:No Data.";
	public static final String ERR_9997 = "ERR_9997:시스템 에러입니다.\n 관리자에게 문의하세요.";
	public static final String ERR_9998 = "ERR_9998:접근권한이 없습니다.";
	public static final String ERR_9999 = "ERR_9999:로그인이 필요한 서비스입니다.";
	
	
	
	public static String getCode(String message){
		String[] arrMessage = message.split(":");
		return arrMessage[0];
	}
	

	public static String getMessage(String message, String[] args){
		String resultMessage = "";
		String[] arrMessage = message.split(":");
		if(args == null){
			return arrMessage[1];
		}
		for(int i=0; i<args.length; i++){
			resultMessage = arrMessage[1].replaceAll("#[{]"+i+"[}]", args[i]);
		}
		return resultMessage;
	}

	
	public static String getMessage(String message){
		String[] arrMessage = message.split(":");
		return arrMessage[1];
	}
}
