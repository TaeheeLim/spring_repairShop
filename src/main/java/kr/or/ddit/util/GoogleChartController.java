package kr.or.ddit.util;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kr.or.ddit.util.service.UtilService;

//만약.. JSON을 return하는 method가 있을 경우
//RestController 어노테이션을 사용하면 됨
//또는 메소드 위에 ResponseBody 어노테이션을 사용해도 됨.
@RestController
public class GoogleChartController {
	@Autowired
	UtilService utilService;
	
	
	// /chart/chart02
	@RequestMapping("/chart/chart02_money")
	public JSONObject chart02_money() throws Exception {
		return this.utilService.cartMoney();
	}
}





