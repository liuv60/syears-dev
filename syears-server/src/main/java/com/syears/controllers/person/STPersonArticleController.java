package com.syears.controllers.person;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.syears.commons.vo.person.STPersonArticleGroupVO;
import com.syears.commons.vo.person.STPersonArticleGroupVOTemp;
import com.syears.controllers.support.Response;
import com.syears.controllers.support.Responses;
import com.syears.services.person.STPersonArticleGroupService;

import net.sf.json.JSONObject;



@RestController
@RequestMapping(path = "/person/article")
@EnableWebMvc
public class STPersonArticleController {
	
    private static final Logger logger = LoggerFactory.getLogger(STPersonArticleController.class);
	

    @Resource
    private STPersonArticleGroupService personArticleGroupService;

    //获取数据清单
	@RequestMapping(method = RequestMethod.GET, path = "group/list", produces="application/json")
	public Response getPersonArticleGroup()
	{
		try
		{
			List<STPersonArticleGroupVO> list = personArticleGroupService.getPersonArticleGroup();
			
			if (list.size() > 0)
			{

				return Responses.SUCCESS().setPayload(list);
			}
			else
			{
				return Responses.FAILED().setMsg("No Data Found");
			}
			
			
		}catch(Exception e)
		{
			logger.error(e.getMessage());
			return Responses.FAILED();
			
		}
	}
	
	//删除数据(逻辑)
	@RequestMapping(method = RequestMethod.POST,path = "/group/delete/{id}")
	//@Transactional
	public Response deletePersonArticleGroup(@PathVariable final String code)
	{
		Response resp = null;
		try
		{
			int r = personArticleGroupService.deletePersonArticleGroup(code);
			if (r > 0)
			{
				resp = Responses.SUCCESS();
			}
			else
			{
				resp = Responses.FAILED();
			}
		}
		catch(Exception e)
		{
            resp = Responses.FAILED();
            logger.error(e.getMessage());
			
		}
		return resp;
	}

	
	//保存数据
//	@RequestMapping(method = RequestMethod.POST,path = "/group/save", produces = {MediaType.APPLICATION_FORM_URLENCODED_VALUE, MediaType.APPLICATION_JSON_VALUE})
	//@RequestMapping(method = RequestMethod.POST,path = "/group/save", consumes = {MediaType.APPLICATION_FORM_URLENCODED_VALUE, MediaType.APPLICATION_JSON_VALUE})
	//@RequestMapping(method = RequestMethod.POST,path = "/group/save", produces = {MediaType.APPLICATION_FORM_URLENCODED_VALUE, MediaType.APPLICATION_JSON_VALUE})
	//3
	@RequestMapping(method = RequestMethod.POST, path = "/group/save", produces = "application/json")
	//@Transactional
	//2
	//@RequestMapping(method = RequestMethod.POST,path = "/group/save", consumes = {MediaType.APPLICATION_FORM_URLENCODED_VALUE, MediaType.APPLICATION_JSON_VALUE})
	//4
	//@RequestMapping(method = RequestMethod.POST,value = "/group/save", consumes = {MediaType.APPLICATION_FORM_URLENCODED_VALUE, MediaType.APPLICATION_JSON_VALUE})
	public Response createPersonArticleGroup(HttpServletRequest request,  @RequestBody STPersonArticleGroupVOTemp vo){
	Response resp = null;
	{
		System.out.println(request.getParameter("value"));
		  JSONObject jO = JSONObject.fromObject(request.getParameter("value"));  
		STPersonArticleGroupVO stud = (STPersonArticleGroupVO) JSONObject.toBean(jO,STPersonArticleGroupVO.class);  
		STPersonArticleGroupVOTemp studl = (STPersonArticleGroupVOTemp) JSONObject.toBean(jO,STPersonArticleGroupVOTemp.class);  
		/*try
		{
			
			if (vo.getPersonArticleGroupID() != "" && vo.getPersonArticleGroupID() !="0")
			{
				STPersonArticleGroupVO result = personArticleGroupService.createPersonArticleGroup(vo);
				if (result == null)
				{
					resp = Responses.FAILED();
				}
				else
				{
					resp = Responses.SUCCESS();
				}
			}
			else
			{
				int r = personArticleGroupService.editPersonArticleGroup(vo);
				if (r > 0)
				{
					resp = Responses.SUCCESS();
				}
				else
				{
					resp = Responses.FAILED();
				}
			}
			
		}
		catch(Exception e)
		{
			resp = Responses.FAILED();
			logger.error(e.getMessage());
			
		}*/
		return resp;
	}
	}

}
