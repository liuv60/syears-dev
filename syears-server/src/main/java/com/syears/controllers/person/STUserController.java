package com.syears.controllers.person;


import com.syears.controllers.support.Response;
import com.syears.controllers.support.Responses;
import com.syears.services.person.STUserService;



import javax.annotation.Resource;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import com.syears.commons.vo.MerchantOrderDetailVO;
import com.syears.commons.vo.person.STUserVO;

@RestController
@RequestMapping(path = "/stuser")
public class STUserController {
	
	@Resource
	private STUserService userService;
	
	@RequestMapping(method = RequestMethod.POST, path = "/createUser", produces = {MediaType.APPLICATION_FORM_URLENCODED_VALUE, MediaType.APPLICATION_JSON_VALUE})
	public Response createUser(@RequestBody STUserVO user){
		STUserVO result = userService.createUser(user);
		Response response;
        if (result == null) {
            response = Responses.FAILED();
        } else {
            response = Responses.SUCCESS().setPayload(result);

            // 修改商家菜品余量
            // TODO 米饭问题
//            menuService.conversionRestNum(menuVOList);
            // TODO 若使用优惠券元需要修改优惠券状态
        }

        return response;
	}
	
	
    @RequestMapping(method = RequestMethod.GET, path = "/getUserInfo/{username}/{password}")
    public Response getUserInfo(@PathVariable final String username, @PathVariable final String password) {

        Response response = null;
        try
        {
        	STUserVO user = userService.getUserInfo(username, password);
        	if (user == null)
        	{
        		return response = Responses.FAILED().setMsg("未查询到数据");
        	}
        	response = Responses.SUCCESS().setPayload(user);
	
        }catch (Exception e)
        {

        	response = Responses.FAILED();
        	//logger.error(e.getMessage());
        }
        return response;

    }


}
