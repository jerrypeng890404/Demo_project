//package com.example.demo_project.controller;
//
//import java.io.IOException;
//import java.io.InputStream;
//import java.io.OutputStream;
//import java.net.URLEncoder;
//import java.util.ArrayList;
//import java.util.List;
//
//import javax.servlet.http.HttpServletResponse;
//
//import org.jxls.common.Context;
//import org.jxls.util.JxlsHelper;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import com.example.demo_project.entity.Person;
//
//@RestController
//public class TestController {
//	 @GetMapping("/feedbackListtoExcel")
//	 public void exportToExcel(HttpServletResponse response) throws IOException {
//	  List<Person>peoples = new ArrayList<>();
//	        peoples.add(new Person("001","史丹利",20));
//	        peoples.add(new Person("002","瑪莉",28));
//	        peoples.add(new Person("003","布萊恩",35));
//	  
//	  try (InputStream is = this.getClass().getClassLoader().getResourceAsStream("test1.xlsx")) {
//	            //設置檔頭資訊 編碼
//	            String fileName = URLEncoder.encode("測試表", "UTF-8");
//	            response.setHeader("Content-Disposition", "attachment; filename=" +
//	                    new String(fileName.getBytes("UTF-8"), "ISO-8859-1") + ".xlsx");
//	            response.setContentType("application/vnd.ms-excel;charset=utf8");
//	            
//	            OutputStream os = response.getOutputStream();
//	            Context context = new Context();
//	            context.putVar("pers", peoples); //名稱對應excel的items
//	            JxlsHelper.getInstance().setEvaluateFormulas(true).processTemplate(is, os, context);
//	            os.flush();
//	            os.close();
//	
//	        } catch (IOException e) {
//	            e.printStackTrace();
//	        }
//	 }
//	
//}
