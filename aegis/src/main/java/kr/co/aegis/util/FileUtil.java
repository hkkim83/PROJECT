package kr.co.aegis.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.web.multipart.MultipartFile;

public class FileUtil {
	public static String IMAGE_PATH = "uploadDir";
	
	/**
	 * 파일명 가져오기
	 * @param rootPath
	 * @param userId
	 * @return
	 */
	public static String getFilePath(String rootPath, String userId) {
		File filePath = new File(rootPath+"/"+userId);
		if(!filePath.exists()) filePath.mkdir();
		return filePath.getPath();
	}
	
	/**
	 * 파일명 가져오기
	 * @param fileName
	 * @return
	 */
	public static String getFileName(String fileName){
		StringBuffer sb = new StringBuffer();

		int posExt = fileName.lastIndexOf(".");
		sb.append(fileName.substring(0, posExt));
		sb.append("_");
		String ext = "";
		if(posExt>0){
			ext = fileName.substring(posExt+1);
		}

		long nowmills = System.currentTimeMillis();
			    
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
		String now = sdf.format(new Date(nowmills));
		sb.append(now);
		sb.append(".");
		sb.append(ext);
		return sb.toString();
	}
	
	/**
	 * 이미지 경로 생성
	 * @param rootPath
	 * @return
	 */
	public static String getImagePath(String rootPath){
		
    	String sYear = DateUtil.getStringByPattern("yyyy");
    	String sMonthDay = DateUtil.getStringByPattern("MMdd");
    	StringBuffer sbImagePath = new StringBuffer();

    	File filePath = null;
    	sbImagePath.append(IMAGE_PATH);
    	filePath = new File(rootPath + sbImagePath.toString());
		if(!filePath.exists()) filePath.mkdir();
		
		sbImagePath.append("/"+sYear);
    	filePath = new File(rootPath + sbImagePath.toString());
		if(!filePath.exists()) filePath.mkdir();
		
		sbImagePath.append("/"+sMonthDay);
    	filePath = new File(rootPath + sbImagePath.toString());
		if(!filePath.exists()) filePath.mkdir();

		return sbImagePath.toString();
	}
	
	/**
	 * 이미지 경로 생성
	 * @param rootPath
	 * @return
	 */
	public static String getFilePath(String rootPath){
		
    	String sYear = DateUtil.getStringByPattern("yyyy");
    	String sMonthDay = DateUtil.getStringByPattern("MMdd");
    	StringBuffer sbImagePath = new StringBuffer();

    	File filePath = null;
		
		sbImagePath.append("/"+sYear);
    	filePath = new File(rootPath + sbImagePath.toString());
		if(!filePath.exists()) filePath.mkdir();
		
		sbImagePath.append("/"+sMonthDay);
    	filePath = new File(rootPath + sbImagePath.toString());
		if(!filePath.exists()) filePath.mkdir();

		return sbImagePath.toString();
	}
	
	/**
	 * 파일 업로드
	 * @param formFile
	 * @param svrFile
	 * @return
	 */
    public static boolean uploadFormFile(MultipartFile formFile, File svrFile) throws FileNotFoundException, IOException{
    	boolean returnValue = false;
    	// 파일관련 변수 선언
        InputStream inStream = null;
        OutputStream outStream = null;
        try {
			if (!svrFile.exists()) {  
				svrFile.createNewFile();  
			}
        	
        	inStream = formFile.getInputStream();
            
        	outStream = new FileOutputStream(svrFile);
            int read = 0;
            byte[] bytes = new byte[1024];
			while ((read = inStream.read(bytes)) != -1) {  
				outStream.write(bytes, 0, read);  
			}  
            returnValue = true;
        } catch (FileNotFoundException ex) {
            throw ex;
        } catch (IOException ex) {
            throw ex;
        }finally{
			try{if(inStream!=null) inStream.close();}catch(Exception ex){}
			try{if(outStream!=null) outStream.close();}catch(Exception ex){}
        }
        return returnValue;
    }
    /**
     * 파일 삭제
     * @param path
     * @param fileName
     */
    public static boolean deleteFile(File file) throws Exception{
    	boolean returnValue = false;
        try {
        	if(file.exists()){
        		if(file.delete()){
        			returnValue = true;	
        		}else{
        			throw new Exception("File delete Error");
        		}
        		
        	}else{
        		throw new FileNotFoundException(file.getPath());
        	}
        } catch (Exception ex) {
            throw ex;
        }
        return returnValue;
    }
    
    /**
     * 디렉토리 삭제
     * @param path
     * @return
     */
    public static boolean deleteDirectory(File path) { 
        if(!path.exists()) { 
            return false; 
        } 
          
        File[] files = path.listFiles(); 
        for (File file : files) { 
            if (file.isDirectory()) { 
                deleteDirectory(file); 
            } else { 
                file.delete(); 
            } 
        } 
          
        return path.delete(); 
    } 
    
    /**
     * 파일 복사
     * @param inFileName
     * @param outFileName
     */
    public static void fileCopy(String inFileName, String outFileName) {
     try {
      FileInputStream fis = new FileInputStream(inFileName);
      FileOutputStream fos = new FileOutputStream(outFileName);
      
      int data = 0;
      while((data=fis.read())!=-1) {
       fos.write(data);
      }
      fis.close();
      fos.close();
      
     } catch (IOException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
     }
    }
}