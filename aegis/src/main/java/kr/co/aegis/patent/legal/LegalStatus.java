package kr.co.aegis.patent.legal;

import java.io.IOException;

public interface LegalStatus {
	/**
	 * 법적상태 가져오기
	 * @return
	 * @throws IOException
	 */
	public String getLegalStatus() throws IOException;
}
