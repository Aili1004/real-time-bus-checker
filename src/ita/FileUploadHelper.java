package ita;

import java.io.*;
import java.util.*;

import javax.servlet.http.*;

import org.apache.tomcat.util.http.fileupload.FileItem;
import org.apache.tomcat.util.http.fileupload.FileUploadException;
import org.apache.tomcat.util.http.fileupload.disk.DiskFileItemFactory;
import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;

public class FileUploadHelper {
	private Map<String, ArrayList<String>> formFields = new HashMap<String, ArrayList<String>>();
	private Map<String, ArrayList<AttachedFile>> uploadItems = new HashMap<String, ArrayList<AttachedFile>>();
	private DiskFileItemFactory factory;
	private ServletFileUpload upload;
	private HttpServletRequest request;
	
	@SuppressWarnings("unchecked")
	public FileUploadHelper(HttpServletRequest request) {
		if (!ServletFileUpload.isMultipartContent(request)) {
			System.out.println("[?§Î•ò!] <form enctype=\"multpart/form-data\">Î°??§Ï†ï?òÏñ¥ ?àÎäîÏß??ïÏù∏?òÏÑ∏??");
		}
		
		this.request = request;
			
		factory = new DiskFileItemFactory();
		upload = new ServletFileUpload(factory);
		List<FileItem> items;
		
		try {
			items = (List<FileItem>)upload.parseRequest(request);
			
			for(FileItem item : items) {
				String fieldName = item.getFieldName();
				
				if (item.isFormField()) {
					String fieldValue = item.getString();
					
					if (formFields.containsKey(fieldName)) {
						ArrayList<String>values = (ArrayList<String>)formFields.get(fieldName);
						values.add(fieldValue);
					} else {
						ArrayList<String> values = new ArrayList<String>();
						values.add(fieldValue);
						formFields.put(fieldName, values);
					}
				} else {
					AttachedFile attachedFile = new AttachedFile(item, this);
					
					if (uploadItems.containsKey(fieldName)) {
						ArrayList<AttachedFile> values = (ArrayList<AttachedFile>)uploadItems.get(fieldName);
						values.add(attachedFile);
					} else {
						ArrayList<AttachedFile> values = new ArrayList<AttachedFile>();
						values.add(attachedFile);
						uploadItems.put(fieldName, values);
					}
				}			}
		} catch (FileUploadException e) {
			e.printStackTrace();
		}
	}
	
	public String getParameter(String fieldName) {
		ArrayList<String>values = (ArrayList<String>)formFields.get(fieldName);
		
		if (values != null)
				return toEucKr(values.get(0));
		else
			return null;
	}
	
	public String[] getParameterValues(String fieldName) {
		ArrayList<String>values = (ArrayList<String>)formFields.get(fieldName);
		
		if (values != null) {
			String[] arr = new String[values.size()];
			values.toArray(arr);
			
			return arr;
		} else
			return null;
	}
	
	public AttachedFile getAttachedFile(String fieldName) {
		ArrayList<AttachedFile> values = (ArrayList<AttachedFile>)uploadItems.get(fieldName);
		
		if (values != null) {
			return values.get(0);
		} else
			return null;
	}
	
	public AttachedFile[] getAttachedFileArray(String fieldName) {
		ArrayList<AttachedFile> values = (ArrayList<AttachedFile>)uploadItems.get(fieldName);
		
		if (values != null) {
			AttachedFile[] arr = new AttachedFile[values.size()];
			values.toArray(arr);
			
			return arr;
		} else
			return null;
	}
	
	public boolean deleteFile(String filePath) {
		return deleteFile(filePath, true);
	}
	
	public boolean deleteFile(String filePath, boolean isWebFolder) {
		boolean deleteSuccess = false;
		
		filePath = (isWebFolder ? getRealPath(filePath) : filePath);
		
		File file = new File(filePath);
		
		if (file.exists() && file.isFile())
			deleteSuccess =  file.delete();
		
		return deleteSuccess;
	}
	
	public boolean deleteFolder(String folderName) {
		return deleteFolder(folderName, true);
	}
	
	public boolean deleteFolder(String folderName, boolean isWebFolder) {
		boolean deleteSuccess = true;
		
		folderName = (isWebFolder ? getRealPath(folderName) : folderName);
		
		File dir = new File(folderName);
		
		if (dir.exists() && dir.isDirectory()) {
			File[] files = dir.listFiles();
			
			for(File f : files) {
				deleteSuccess = f.delete();
			}
		} else
			deleteSuccess = false;
		
		return deleteSuccess;
	}
	
	public String getRealPath(String folderName) {
		return request.getSession().getServletContext().getRealPath(folderName);
	}
	
	public static String toEucKr(String value) {
		if (value != null)
			try {
				return new String(value.getBytes("8859_1"), "euc-kr") ;
			} catch (UnsupportedEncodingException e) {
				return null;
			}
		else
			return null;		
	}
}