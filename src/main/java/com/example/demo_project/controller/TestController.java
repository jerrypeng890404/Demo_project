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
//	        peoples.add(new Person("001","�v���Q",20));
//	        peoples.add(new Person("002","����",28));
//	        peoples.add(new Person("003","���ܮ�",35));
//	  
//	  try (InputStream is = this.getClass().getClassLoader().getResourceAsStream("test1.xlsx")) {
//	            //�]�m���Y��T �s�X
//	            String fileName = URLEncoder.encode("���ժ�", "UTF-8");
//	            response.setHeader("Content-Disposition", "attachment; filename=" +
//	                    new String(fileName.getBytes("UTF-8"), "ISO-8859-1") + ".xlsx");
//	            response.setContentType("application/vnd.ms-excel;charset=utf8");
//	            
//	            OutputStream os = response.getOutputStream();
//	            Context context = new Context();
//	            context.putVar("pers", peoples); //�W�ٹ���excel��items
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
