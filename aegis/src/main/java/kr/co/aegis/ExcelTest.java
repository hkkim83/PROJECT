package kr.co.aegis;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import org.apache.poi.hssf.usermodel.HSSFClientAnchor;
import org.apache.poi.hssf.usermodel.HSSFPatriarch;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;


public class ExcelTest {

    /**
     * @param args
     * @throws IOException 
     */
    public static void main(String[] args) throws IOException {
        // TODO Auto-generated method stub

    	FileInputStream fs = new FileInputStream(new File("C:/Java/project/patentDir/sample/patentDetail.xls"));
    	HSSFWorkbook    wb      = new HSSFWorkbook(fs);
        HSSFSheet       sheet   = wb.getSheetAt(0);

        drawSheet5( sheet, wb );

        // Write the file out.
        FileOutputStream fileOut = new FileOutputStream("C:/Java/project/patentDir/sample/img_work.xls"); // 이미지 삽입된엑셀파일
        wb.write(fileOut);
        fileOut.close();
    }

    private static void drawSheet5( HSSFSheet sheet, HSSFWorkbook wb ) throws IOException {
        // Create the drawing patriarch.  This is the top level container for
        // all shapes. This will clear out any existing shapes for that sheet.
        HSSFPatriarch patriarch = sheet.createDrawingPatriarch();

        HSSFClientAnchor anchor;
        anchor = new HSSFClientAnchor(0,0,0,255,(short)1,4,(short)2,4); // 이미지 크기조절은 여기서..
        anchor.setAnchorType( 2 );
        patriarch.createPicture(anchor, loadPicture( "http://www.google.co.kr/intl/ko/images/logos/translate_logo_sm.gif", wb )); // 삽입 할 이미지
    }

    private static int loadPicture( String path, HSSFWorkbook wb ) throws IOException {
    	
    	URL voImageURL = new URL(path);
        int pictureIndex = 0;
        InputStream is = null;
        FileInputStream fis = null;
        FileOutputStream fos = null;
        BufferedInputStream bis = null;
        ByteArrayOutputStream bos = null;

        HttpURLConnection voImageReponse = (HttpURLConnection) voImageURL  
                .openConnection(); 
        if (voImageReponse.getResponseCode() == HttpURLConnection.HTTP_OK) {  
        	is = voImageReponse.getInputStream();  
        	  
            //응답 코드를 C:\1.jpg에 저장  
            bis = new BufferedInputStream(is);  
            bos = new ByteArrayOutputStream( );
              
            //응답 코드를 1024바이트 단위로 저장  
            int len = 0;  
            byte[] buf = new byte[1024];  
            while ((len = bis.read(buf, 0, 1024)) != -1) {  
                bos.write(buf, 0, len);  
            } 
            pictureIndex = wb.addPicture( bos.toByteArray(), HSSFWorkbook.PICTURE_TYPE_JPEG  );
        }
        if (is != null) is.close();
        if (bis != null) bis.close();
        if (bos != null) bos.close();
        
//        try {
//            fis = new FileInputStream( path);
//            bos = new ByteArrayOutputStream( );
//            int c;
//            while ( (c = fis.read()) != -1) {
//                bos.write( c );
//            }
//            pictureIndex = wb.addPicture( bos.toByteArray(), HSSFWorkbook.PICTURE_TYPE_JPEG  );
//        } finally {
//            if (fis != null) fis.close();
//            if (bos != null) bos.close();
//        }
        return pictureIndex;
    }
}