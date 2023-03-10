package com.victory.biz.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.victory.biz.model.ResultVo;
import com.victory.biz.model.TestVo;
import com.victory.system.util.HttpUrlConnectUtil;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;

@Tag(name = "Test", description = "get,post apiconnection Test")
@Slf4j
@RestController
public class TestController {

	@Autowired
	HttpUrlConnectUtil apiCon;


	@Operation(summary = "Map return")
	@PostMapping(value = "/test", produces = MediaType.APPLICATION_JSON_VALUE)
	public Map<String, Object> test(@RequestBody @Parameter Map<String, Object> param) throws Exception {

		log.debug("param : " +  param);
		Map<String, Object> result = new HashMap<>();

		result.put("resultKey","resultValue");

		return result;

	}

	@Operation(summary = "Vo return")
	@PostMapping(value = "/testVo")
	public TestVo testVo(@RequestBody @Parameter TestVo param) throws Exception {

		log.debug("param : ", param);

		TestVo tv = TestVo.builder().test("returnVal").test2("returnVal2").test3("returnVal3").test4(1).build();

		log.debug("return vo : ", tv);

		return tv;

	}

	@Operation(summary = "Vo return (post)")
	@PostMapping(value = "/testResultVoPost")
	public ResultVo testResultVoPost(@RequestBody @Parameter Map<String, Object> param) throws Exception {

		log.debug("param : ", param);

		ResultVo tv = ResultVo.builder().result("resultasd0").resultMsg("resultMsggasdasd").build();

		log.debug("return vo : ", tv);

		return tv;

	}

	@Operation(summary = "Vo return (get)")
	@GetMapping(value = "/testResultVoGet")
	public ResultVo testResultVoGet(@RequestParam @Parameter Map<String, Object> param) throws Exception {

		log.debug("param : ", param);

		ResultVo tv = ResultVo.builder().result("resultasd0").resultMsg("resultMsggasdasd").build();

		log.debug("return vo : {}", tv);

		return tv;

	}

	@Operation(summary = "api connection(Map post)", description = "{\"port\":\"8090\",\"url\" : \"testVo\"}")
	@PostMapping(value = "/apiConPost")
	public TestVo apiConPost(@RequestBody @Parameter Map<String, Object> param,
			@RequestHeader Map<String, Object> requestHeader) throws Exception {

		String url = param.get("url").toString();
		String port = param.get("port").toString();
		String resulturl = "http://127.0.0.1:" + port + "/" + url;

		TestVo forObject = new TestVo();
		try {

			forObject = apiCon.apiPost(resulturl, param, requestHeader, TestVo.class);
			log.info("###end-point`s return value : ", forObject);

		} catch (Exception e) {
			e.printStackTrace();
		}

		return forObject;
	}

	@Operation(summary = "api connection(Vo post)", description = "{\"test\" : \"8090\", \"test2\":\"testVo\"}")
	@PostMapping(value = "/apiConPostVo")
	public ResultVo apiConPostVo(@RequestBody @Parameter TestVo param, @RequestHeader Map<String, Object> requestHeader)
			throws Exception {

		String resulturl = "http://127.0.0.1:" + param.getTest() + "/" + param.getTest2();

		ResultVo forObject = new ResultVo();
		try {

			forObject = apiCon.apiPost(resulturl, param, requestHeader, ResultVo.class);
			log.info("###end-point`s return value : ", forObject);

		} catch (Exception e) {
			e.printStackTrace();
		}

		return forObject;
	}

	@Operation(summary = "api connection(Vo get)", description = "{\"url\" : \"testVo\", \"port\":\"8090\"}")
	@PostMapping(value = "/apiConGet")
	public TestVo apiConGet(@RequestBody @Parameter Map<String, Object> param,
			@RequestHeader Map<String, Object> requestHeader) throws Exception {

		String url = param.get("url").toString();
		String port = param.get("port").toString();
		String resulturl = "http://127.0.0.1:" + port + "/" + url;

		TestVo forObject = new TestVo();
		try {

			forObject = apiCon.apiGet(resulturl, param, requestHeader, TestVo.class);
			log.info("###end-point`s return value : {}", forObject);

		} catch (Exception e) {
			e.printStackTrace();
		}

		return forObject;
	}

	@Operation(summary = "api connection(Vo get)", description = "{\"test\" : \"8090\", \"test2\":\"testVo\"}")
	@PostMapping(value = "/apiConGetVo")
	public TestVo apiConGetVo(@RequestBody @Parameter TestVo param, @RequestHeader Map<String, Object> requestHeader)
			throws Exception {

		String resulturl = "http://127.0.0.1:" + param.getTest() + "/" + param.getTest2();

		TestVo forObject = new TestVo();
		try {

			forObject = apiCon.apiGet(resulturl, param, requestHeader, TestVo.class);
			log.info("###end-point`s return value : {}", forObject);

		} catch (Exception e) {
			e.printStackTrace();
		}

		return forObject;
	}
}
