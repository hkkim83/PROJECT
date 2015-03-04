package kr.co.aegis.patent2.pdf;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.Map;

import kr.co.aegis.patent2.header.ExcelHeader;
import kr.co.aegis.util.DateUtil;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.RectangleReadOnly;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

public class PDF {
	/**
	 * 특허 리스트 PDF로 만들기
	 * @param path
	 * @param fileName
	 * @param list
	 * @return
	 * @throws IOException
	 * @throws DocumentException
	 */
	public String writePdfForPatentList(String path, String fileName, List<Map<String, String>> list) throws IOException, DocumentException {
		
		fileName = fileName+"_"+DateUtil.getDateTimeToString()+".pdf";
		// pdf document 선언....
		Document document = new Document(new RectangleReadOnly(852, 595), 0, 0, 50, 50);
		// pdf 파일을 저장할 공간을 선언... pdf파일을 서버하드에 생성이된다.. 그후 스트림으로 쏜다..
		PdfWriter.getInstance(document, new FileOutputStream(path+"/"+fileName));
		// document를 열어 pdf문서를 쓸수있도록한다..
		document.open();
		// 한글지원폰트 설정..
		BaseFont bf = BaseFont.createFont("HYSMyeongJo-Medium", "UniKS-UCS2-H",
				BaseFont.NOT_EMBEDDED);
		Font font  = new Font(bf, 9, Font.NORMAL);
		Font font2 = new Font(bf, 14, Font.BOLD);
		// 타이틀
		Paragraph title = new Paragraph("특허목록", font2);
		// 중간정렬
		title.setAlignment(Element.ALIGN_CENTER);
		// 문서에 추가
		document.add(title);
		document.add(new Paragraph("\r\n"));
		// 테이블생성 Table객체보다 PdfPTable객체가 더 정교하게 테이블을 만들수있다..
		// 생성자에 컬럼수를 써준다..
		PdfPTable table = new PdfPTable(8);
		// 각각의 컬럼에 width를 정한다..
		table.setWidths(new int[] { 25, 20, 55, 120, 20, 70, 35, 120 });
		// 컬럼 타이틀..
		PdfPCell cellArr[] = new PdfPCell[8];
		String strArr[] = {"연번", "국가", "출원번호", "발명의명칭", "등급", "출원인", "검토자", "검토의견"};
		for(int i=0; i<strArr.length; i++) {
			cellArr[i] = new PdfPCell(new Paragraph(strArr[i], font));
			cellArr[i].setHorizontalAlignment(Element.ALIGN_CENTER);
			cellArr[i].setVerticalAlignment(Element.ALIGN_MIDDLE);
			table.addCell(cellArr[i]);
		}
		
		PdfPCell cell = null;
		String[] headList = ExcelHeader.PATENT_HEADER;
		String str = "";
		for(Map<String, String> map : list) {
			for(int i=0; i<8; i++) {
				cell = new PdfPCell();
				str = map.get(headList[i]);
				if(i==4)
					str += "|"+map.get(headList[8]);
				if(i==7)
					str += "\n"+map.get(headList[9]);
				
				cell.getColumn().addText(new Paragraph(str, font));
				if(i == 3 || i == 5 || i == 7)
					cell.setHorizontalAlignment(Element.ALIGN_LEFT); 
				else 
					cell.setHorizontalAlignment(Element.ALIGN_CENTER); 

				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);	
				table.addCell(cell);
			}
		}
		// 문서에 테이블추가..
		document.add(table);
		// 문서를 닫는다.. 쓰기 종료..
		document.close();
		
		return fileName;
	}
}
