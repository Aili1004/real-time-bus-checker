package ita;

import java.io.*;

import org.apache.tomcat.util.http.fileupload.FileItem;

public class AttachedFile {
	private FileItem fileItem;
	private FileUploadHelper helper;
	
	public AttachedFile(FileItem fileItem, FileUploadHelper helper) {
		this.fileItem = fileItem;
		this.helper = helper;
	}
	
	public void setFileItem(FileItem fileItem) {
		this.fileItem = fileItem;
	}
	
	public boolean saveAs(String folderName, String fileName) {
		return saveAs(folderName, fileName, true); 
	}
	
	public boolean saveAs(String folderName, String fileName, boolean isWebFolder) {
		folderName = (isWebFolder ? helper.getRealPath(folderName) : folderName);
		
		File dir = new File(folderName);
		if (!dir.exists()) {
			if (!dir.mkdirs())
				return false;
		}
		
		File filePath = new File(folderName + File.separator + fileName);
		
		try {
			fileItem.write(filePath);
		} catch (Exception e) {
			System.out.println("[AttachedFile.saveAs]" + e.getMessage());
			return false;
		}
		
		return true;
	}
	
	public long getSize() {
		return fileItem.getSize();
	}
	
	public String getFileName() {
			String clientPath = new String(FileUploadHelper.toEucKr(fileItem.getName()));
			return clientPath.substring(clientPath.lastIndexOf(File.separator) + 1);
	}
}
