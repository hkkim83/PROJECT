package kr.co.aegis;

import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;
import java.util.Map;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.RectangleReadOnly;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

public class DocTest {

	/**
	 * @param args
	 */
	public static void main(String[] asdf) throws Exception {
		// pdf document 선언....
		Document document = new Document(new RectangleReadOnly(852, 595), 0, 0, 50, 50);
		// pdf 파일을 저장할 공간을 선언... pdf파일을 서버하드에 생성이된다.. 그후 스트림으로 쏜다..
		PdfWriter.getInstance(document, new FileOutputStream("C:/Java/project/patentDir/ccc.pdf"));
		// document를 열어 pdf문서를 쓸수있도록한다..
		document.open();
		// 한글지원폰트 설정..
		BaseFont bf = BaseFont.createFont("HYSMyeongJo-Medium", "UniKS-UCS2-H",
				BaseFont.NOT_EMBEDDED);
		Font font = new Font(bf, 9, Font.NORMAL);
		Font font2 = new Font(bf, 14, Font.BOLD);
		// 타이틀
		Paragraph title = new Paragraph("2009년도 기술개발 접수현황", font2);
		// 중간정렬
		title.setAlignment(Element.ALIGN_CENTER);
		// 문서에 추가
		document.add(title);
		document.add(new Paragraph("\r\n"));
		// 테이블생성 Table객체보다 PdfPTable객체가 더 정교하게 테이블을 만들수있다..
		// 생성자에 컬럼수를 써준다..
		PdfPTable table = new PdfPTable(6);
		// 각각의 컬럼에 width를 정한다..
		table.setWidths(new int[] { 15, 55, 100, 55, 35, 55 });
		// 컬럼 타이틀..
		PdfPCell title1 = new PdfPCell(new Paragraph("순번", font));
		PdfPCell title2 = new PdfPCell(new Paragraph("기술분류", font));
		PdfPCell title3 = new PdfPCell(new Paragraph("과제명", font));
		PdfPCell title4 = new PdfPCell(new Paragraph("회사", font));
		PdfPCell title5 = new PdfPCell(new Paragraph("책임자", font));
		PdfPCell title6 = new PdfPCell(new Paragraph("연락처", font));
		// 컬럼 바탕색
		title1.setBackgroundColor(BaseColor.GRAY);
		title2.setBackgroundColor(BaseColor.GRAY);
		title3.setBackgroundColor(BaseColor.GRAY);
		title4.setBackgroundColor(BaseColor.GRAY);
		title5.setBackgroundColor(BaseColor.GRAY);
		title6.setBackgroundColor(BaseColor.GRAY);
		// 가로정렬
		title1.setHorizontalAlignment(Element.ALIGN_CENTER);
		title2.setHorizontalAlignment(Element.ALIGN_CENTER);
		title3.setHorizontalAlignment(Element.ALIGN_CENTER);
		title4.setHorizontalAlignment(Element.ALIGN_CENTER);
		title5.setHorizontalAlignment(Element.ALIGN_CENTER);
		title6.setHorizontalAlignment(Element.ALIGN_CENTER);
		// 세로정렬
		title1.setVerticalAlignment(Element.ALIGN_MIDDLE);
		title2.setVerticalAlignment(Element.ALIGN_MIDDLE);
		title3.setVerticalAlignment(Element.ALIGN_MIDDLE);
		title4.setVerticalAlignment(Element.ALIGN_MIDDLE);
		title5.setVerticalAlignment(Element.ALIGN_MIDDLE);
		title6.setVerticalAlignment(Element.ALIGN_MIDDLE);
		// 테이블에 추가..
		table.addCell(title1);
		table.addCell(title2);
		table.addCell(title3);
		table.addCell(title4);
		table.addCell(title5);
		table.addCell(title6);
		// /////////////////////////////////////////////////////
		// 테스트를위해 임시로 데이터를 만든다....
		List<Map<String, String>> list = new ArrayList<Map<String, String>>();
		Map<String, String> aaa = new HashMap<String, String>();
		aaa.put("aa", "1");
		aaa.put("bb", "한글테스트테스트");
		aaa.put("cc", "한글이름한글이름한글이름한글");
		Map<String, String> aaa2 = new HashMap<String, String>();
		aaa2.put("aa", "2");
		aaa2.put("bb", "프로젝트이름");
		aaa2.put("cc", "이름테스트");
		Map<String, String> bbb = new HashMap<String, String>();
		bbb.put("aa", "3");
		bbb.put("bb", "프로젝트름");
		bbb.put("cc", "이테스트");
		Map<String, String> ccc = new HashMap<String, String>();
		ccc.put("aa", "5");
		ccc.put("bb", "이테dd스트");
		ccc.put("cc", "프로젝aa트름프로젝aa트름프로젝aa트름프로젝aa트름프로젝aa트름프로젝aa트름");
		list.add(aaa);
		list.add(aaa2);
		list.add(bbb);
		list.add(ccc);
		// 임시데이터만들기끝..
		// /////////////////////////////////////////////////////////
		// 데이터가 없을때..
		if (list == null || list.size() <= 0) {
			PdfPCell cell2 = new PdfPCell(new Paragraph("검색된 데이터가 없습니다.", font));
			cell2.setColspan(6);
			cell2.setHorizontalAlignment(Element.ALIGN_CENTER);
			table.addCell(cell2);
		} else {
			PdfPCell cell3 = null;
			PdfPCell cell4 = null;
			PdfPCell cell5 = null;
			PdfPCell cell6 = null;
			PdfPCell cell7 = null;
			PdfPCell cell8 = null;
			int count = 1;
			for (int i = 0; i < list.size(); i++) {
				Map dmap = (Map) list.get(i);
				// 컬럼의 로우.. setRowspan 에 들어간다..
				int row = Integer.parseInt((String) dmap.get("aa"));

				// /////////////////////////////////////////////////////
				// 테스트를위해 임시로 데이터를 만든다....
				List mlist = new ArrayList();
				Map aaa3 = new HashMap();
				aaa3.put("admin", "한글이름");
				aaa3.put("nm", "홍길동");
				aaa3.put("phone", "(042)111-1111");
				mlist.add(aaa3);
				if (i >= 1) {
					Map aaa4 = new HashMap();
					aaa4.put("admin", "한이름");
					aaa4.put("nm", "김김김");
					aaa4.put("phone", "(042)333-2222");
					mlist.add(aaa4);
					if (i >= 2) {
						Map aaa5 = new HashMap();
						aaa5.put("admin", "ASDFasdf");
						aaa5.put("nm", "니네집");
						aaa5.put("phone", "000-0000-0000");
						mlist.add(aaa5);
					}
					if (i == 3) {
						Map aaa6 = new HashMap();
						aaa6.put("admin", "한이름");
						aaa6.put("nm", "정정정");
						aaa6.put("phone", "(042)333-2222");
						mlist.add(aaa6);
						Map aaa7 = new HashMap();
						aaa7.put("admin", "ASDFasdf");
						aaa7.put("nm", "박박박");
						aaa7.put("pphone", "(042)555-5555");
						mlist.add(aaa7);
					}
				}
				// 임시데이터만들기끝..
				// /////////////////////////////////////////////////

				for (int z = 0; z < mlist.size(); z++) {
					Map mp = (Map) mlist.get(z);
					if (z == 0) {
						// 순번
						cell3 = new PdfPCell(new Paragraph(count++ + "", font));
						// 기술분류
						cell4 = new PdfPCell(new Paragraph(
								(String) dmap.get("bb"), font));
						// 과제명
						cell5 = new PdfPCell(new Paragraph(
								(String) dmap.get("cc"), font));
						cell3.setHorizontalAlignment(Element.ALIGN_CENTER);
						cell4.setHorizontalAlignment(Element.ALIGN_CENTER);
						cell5.setHorizontalAlignment(Element.ALIGN_LEFT);
						cell3.setVerticalAlignment(Element.ALIGN_MIDDLE);
						cell4.setVerticalAlignment(Element.ALIGN_MIDDLE);
						cell5.setVerticalAlignment(Element.ALIGN_MIDDLE);
						cell3.setRowspan(row);
						cell4.setRowspan(row);
						cell5.setRowspan(row);
						table.addCell(cell3);
						table.addCell(cell4);
						table.addCell(cell5);
					}
					// 회사
					cell6 = new PdfPCell(new Paragraph(
							(String) mp.get("admin"), font));
					// 책임자
					cell7 = new PdfPCell(new Paragraph((String) mp.get("nm"),
							font));
					// 연락처
					cell8 = new PdfPCell(new Paragraph(
							(String) mp.get("phone"), font));
					cell6.setHorizontalAlignment(Element.ALIGN_LEFT);
					cell7.setHorizontalAlignment(Element.ALIGN_LEFT);
					cell8.setHorizontalAlignment(Element.ALIGN_LEFT);
					cell6.setVerticalAlignment(Element.ALIGN_MIDDLE);
					cell7.setVerticalAlignment(Element.ALIGN_MIDDLE);
					cell8.setVerticalAlignment(Element.ALIGN_MIDDLE);
					table.addCell(cell6);
					table.addCell(cell7);
					table.addCell(cell8);
				}
			} // for
		} // else
		// 문서에 테이블추가..
		document.add(table);
		// 문서를 닫는다.. 쓰기 종료..
		document.close();
	}
}
