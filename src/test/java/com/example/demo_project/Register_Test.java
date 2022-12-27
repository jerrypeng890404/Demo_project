package com.example.demo_project;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.json.JacksonJsonParser;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.util.Assert;
import org.springframework.web.context.WebApplicationContext;

import com.example.demo_project.entity.Register;
import com.example.demo_project.ifs.RegisterService;
import com.example.demo_project.repository.RegisterDao;
import com.fasterxml.jackson.databind.ObjectMapper;

@WebAppConfiguration
@SpringBootTest(classes = DemoProjectApplication.class)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class Register_Test {

	private static final String CONTENT_TYPE = "application/json;charset=UTF-8";

	@Autowired
	private WebApplicationContext wac;

	private MockMvc mockMvc;

	@BeforeAll
	public void setup() {
		this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();
	}

	@Autowired
	private RegisterService registerService;

	@Autowired
	private RegisterDao registerDao;

	// =======================================================
	@SuppressWarnings("unchecked")
	@Test
	public void registerControllerTest() throws Exception {
		// 如果 Headers 要加的參數有多個可使用以下方式
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		// ==================================================
		// set request_body
		Map<String, Object> map = new LinkedHashMap<>();
		map.put("account", "A99");
		map.put("pwd", "A123456");
		map.put("name", "David");
		map.put("age", 20);
		map.put("city", "Tainan");
		// ==================================================
		// map to String(把"map"轉成字串)
		ObjectMapper objectMapper = new ObjectMapper();
		String mapString = objectMapper.writeValueAsString(map);
		// ==================================================

		ResultActions result = mockMvc.perform(MockMvcRequestBuilders.post("/api/register").contentType(CONTENT_TYPE) // "Headers"
																														// 的參數就只有
																														// "content_type"
																														// 時可直接使用,不須透過
																														// "Headers"
																														// 加入
//				.headers(headers)
				.content(mapString));
		// get response && 內容轉成字串

//		String resString = result.andReturn().getResponse().getContentAsString(); //等於82、83
		MockHttpServletResponse httpResponse = result.andReturn().getResponse();
		String resString = httpResponse.getContentAsString();

		// 將得到的 "response" 字串轉成 Json(map)
		JacksonJsonParser jsonParser = new JacksonJsonParser();
		Map<String, Object> resData = jsonParser.parseMap(resString);
		// 強制轉型
		String rtnMessage = (String) resData.get("message"); // get"key值"對應的value
		System.out.println(rtnMessage);
		Assert.isTrue(rtnMessage.equals("Successful"), "Message error!!");
		Map<String, Object> rtnInfo = (Map<String, Object>) resData.get("register_info");
		Assert.isTrue(((String) rtnInfo.get("account")).equals("A99"), "Account error!!");

		System.out.println(rtnInfo);
		System.out.println(resData);

	}
	// =======================================================

	@Test
	public void registerTest() {
		Register register = registerService.register("A99", "123456789", "Alice", 20, "Taipei");
		Assert.notNull(register, "Result is null!!");
		Assert.isTrue(register.getAccount().equalsIgnoreCase("A99"), "Account Error!!");

		registerDao.delete(register);

		Assert.isTrue(!registerDao.findById("A99").isPresent(), "register is not null!!");

		Assert.isTrue(!registerDao.existsById("A99"), "register is not null!!");

		System.out.println("Register Test!!");

	}

	@Test
	public void activeAccountTest() {
		// register new account
		Register reg = registerService.register("A99", "123456789", "Alice", 20, "Taipei");
		// 預期為false 判斷此參數 為否時印出此訊息
		// (boolean預設) || ||
		Assert.isTrue(!reg.isActive(), "Account is active!!"); // reg.isActive() == false --> !reg.isActive
		// ======================================================
		// active registered account
		registerService.activeAccount("A99");
		Register newReg = registerDao.findById("A99").get();

		Assert.isTrue(newReg.isActive(), "Account is inactive!!"); // reg.isActive() == true --> reg.isActive
		registerDao.delete(newReg);

		System.out.println("Active Account!!");

	}

//	@Test
//	public void addRoleTest() {
//		List<String> rolelist = new ArrayList<>();
//		rolelist.add("SA");
//		rolelist.add("SD");
//		rolelist.add("SA");
//		rolelist.add("SD");
//		registerService.addRole("A01", rolelist);
//
//		System.out.println("Add Role!!");
//	}

	// =============================================================
	@SuppressWarnings("unchecked")
	@Test
	public void addRoleTest() throws Exception {
		// 如果 Headers 要加的參數有多個可使用以下方式
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		// ==================================================
		// set request_body
		List<String> rolelist = new ArrayList<>();
		rolelist.add("SA");
		rolelist.add("SD");
		rolelist.add("SA");
		rolelist.add("SD");
		registerService.addRole("A01", rolelist);
		// ==================================================
		// map to String(把"map"轉成字串)
		ObjectMapper objectMapper = new ObjectMapper();
		String ListString = objectMapper.writeValueAsString(rolelist);
		// ==================================================

		ResultActions result = mockMvc.perform(MockMvcRequestBuilders.post("/api/register").contentType(CONTENT_TYPE) // "Headers"
																														// 的參數就只有
																														// "content_type"
																														// 時可直接使用,不須透過
																														// "Headers"
																														// 加入
//				.headers(headers)
				.content(ListString));
		// get response && 內容轉成字串

//		String resString = result.andReturn().getResponse().getContentAsString(); //等於82、83
		MockHttpServletResponse httpResponse = result.andReturn().getResponse();
		String resString = httpResponse.getContentAsString();

		// 將得到的 "response" 字串轉成 Json(map)
		JacksonJsonParser jsonParser = new JacksonJsonParser();
		Map<String, Object> resData = jsonParser.parseMap(resString);
		// 強制轉型
		String rtnMessage = (String) resData.get("message"); // get"key值"對應的value
		System.out.println(rtnMessage);
		Assert.isTrue(rtnMessage.equals("Successful"), "Message error!!");
		Map<String, Object> rtnInfo = (Map<String, Object>) resData.get("register_info");
		Assert.isTrue(((String) rtnInfo.get("account")).equals("A99"), "Account error!!");

		System.out.println(rtnInfo);
		System.out.println(resData);

	}

	@Test
	public void updateRegisterInfoDaoTest() {
		int result = registerDao.updateRegisterInfo("jjjjj", 22, "新竹", new Date(), "C222");
		System.out.println(result);
	}

	@Test
	public void doQueryTest() throws ParseException {
		String dateStr = "2022-11-10";
		Date date = new SimpleDateFormat("yyyy-MM-dd").parse(dateStr);
		List<Register> result = registerDao.doQueryByExpiredRegTime(date);
		System.out.println(result.size());
		for (Register item : result) {
			System.out.println(item.getAccount());
		}
	}

	@Test
	public void doQueryWithPageSizeTest() throws ParseException {
		String dateStr = "2022-11-10";
		Date date = new SimpleDateFormat("yyyy-MM-dd").parse(dateStr);
		List<Register> result = registerDao.doQueryByExpiredRegTime(date, 2);
		System.out.println(result.size());
		for (Register item : result) {
			System.out.println(item.getAccount());
		}
	}

	@Test
	public void doQueryWithStartPositionTest() throws ParseException {
		String dateStr = "2022-11-10";
		Date date = new SimpleDateFormat("yyyy-MM-dd").parse(dateStr);
		List<Register> result = registerDao.doQueryByExpiredRegTime(date, -1, 2);
		System.out.println(result.size());
		for (Register item : result) {
			System.out.println(item.getAccount());
		}
	}

	@Test
	public void doNativeQueryTest() throws ParseException {
		String dateStr = "2022-11-10";
		Date date = new SimpleDateFormat("yyyy-MM-dd").parse(dateStr);
		List<Register> result = registerDao.doNativeQueryByExpiredRegTime(date, -1, 2);
		System.out.println(result.size());
		for (Register item : result) {
			System.out.println(item.getAccount());
		}
	}

	@Test
	public void doUpdateTest() {
//		int result = registerDao.updateAgeByName("jerry", 1000);
		int result = registerDao.updateAgeByAccount("A123", 1000);
		System.out.println(result);
	}

	@Test
	public void doNativeUpdateTest() {
//		int result = registerDao.updateAgeByName("jerry", 1000);
		int result = registerDao.nativeUpdateAgeByAccount("A123", 10);
		System.out.println(result);
	}

	@Test
	public void doQueryRoleContainsTest() {
		List<String> strList = Arrays.asList("123", "111");
		List<Register> result = registerDao.doQueryRoleContains(strList);
		System.out.println(result);
		System.out.println(result.size());
	}

	@Test
	public void findAllTest() {
		List<Register> result = registerService.findAll();
		System.out.println(result.size());
	}

	@Test
	public void findById() {
		Register resultList = registerService.findById("A123");
		System.out.println(resultList.getAccount());
	}
}
