package com.jl.utils;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.lang.reflect.Method;
import java.util.List;
import java.util.UUID;

public class FileUploadUtil {
	private static final String CHARSET="UTF-8";
	private static final String IMAGEPATH="images/";
	private static final String FinalPath="E:/";

	public static <T> T paraseRequest(HttpServletRequest request,Class<T> cls) throws Exception{
		DiskFileItemFactory factory=new DiskFileItemFactory();
		ServletFileUpload upload=new ServletFileUpload(factory);
		List<FileItem> items=upload.parseRequest(request);
		T t=cls.newInstance();
		Method []methods=cls.getDeclaredMethods();
		for(FileItem item:items){
			if(item.isFormField()){//判断是否为普通表单元素
				//普通表单元素
				String name=item.getFieldName();
				String value=item.getString(CHARSET);
				for(Method m:methods){
					if (("set"+name).equalsIgnoreCase(m.getName())) {
						String typeName=m.getParameterTypes()[0].getName();
						if ("java.lang.Integer".equals(typeName)) {
							m.invoke(t, Integer.parseInt(value));
						}else if ("java.lang.Double".equals(typeName)) {
							m.invoke(t, Double.parseDouble(value));
						}else if ("java.lang.Float".equals(typeName)) {
							m.invoke(t, Float.parseFloat(value));
						}else if ("java.lang.String".equals(typeName)) {
							m.invoke(t, value);
						}else if ("java.lang.Long".equals(typeName)) {
							m.invoke(t,value);
						}else{

						}
						break;
					}
				}
				System.out.println(name+"--"+value);
			}else{
				String fieldName=item.getFieldName();//获取表单的Name属性值
				//获取文件名称
				String name=item.getName();
				//文件存在服务器的那个位置
				String path=request.getServletContext().getRealPath("/");
				//文件重名问题
				UUID uuid=UUID.randomUUID();
				String fileName=uuid.toString()+""+name;
				//如果把图片存到项目的目录下，但是当我重起服务器后项目下上传的图片就消失
				//服务器webapps目录创建一个名为images的文件夹，就相当于是一个文件项目
				//文件如何写入到指定位置  项目下
				//创建文件对象
				File file=new File(FinalPath,IMAGEPATH+fileName);
				item.write(file);//文件项目中文件数据写入目标文件
				//获取存储后的文件路径    如何处理  存储到image_path
				String image_path=FinalPath+IMAGEPATH+fileName;
//				System.out.println(image_path);
				for(Method m:methods){
					System.out.println(fieldName);
					if (("set"+fieldName).equalsIgnoreCase(m.getName())) {
						m.invoke(t, image_path);

					}
				}
			}
		}
		return t;
	}
}
