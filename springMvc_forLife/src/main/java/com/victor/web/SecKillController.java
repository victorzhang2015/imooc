package com.victor.web;

import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.victor.dto.Exposer;
import com.victor.dto.SecKillExecution;
import com.victor.dto.SecKillResult;
import com.victor.entity.SecKill;
import com.victor.enums.SecKillStatusEnum;
import com.victor.exception.RepeatKillException;
import com.victor.exception.SecKillCloseException;
import com.victor.service.SecKillService;

@Controller
@RequestMapping("/seckill")//模块
public class SecKillController {
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired
	private SecKillService seckillService;
	@RequestMapping(value="/list",method=RequestMethod.GET)//模块
	public String list(Model model){
		List<SecKill> list =seckillService.getSeckillList();
		model.addAttribute("list", list);
		return "list";
	}
	@RequestMapping(value="/{seckillId}/detail",method=RequestMethod.GET)//模块
	public String detail(@PathVariable("seckillId")Long seckillId,Model model){
		if(seckillId==null){
			return "redirect:/seckill/list";
		}
		SecKill seckill =seckillService.getById(seckillId);
		if(seckill==null){
			return "forward:/seckill/list";
		}
		model.addAttribute("seckill", seckill);
		return "detail";
	}
	//ajax json
	@RequestMapping(value="/{seckillId}/exposer",method=RequestMethod.POST,
			produces={"application/json;charset=UTF-8"})//模块
	@ResponseBody//spring 将结果封装为json
	public SecKillResult<Exposer> exposer(@PathVariable("seckillId")Long seckillId){
		SecKillResult<Exposer> result;
		try{
		Exposer exposer =seckillService.exportSecKillUrl(seckillId);
		result = new SecKillResult<Exposer>(true,exposer);
		}catch(Exception e){
			logger.error(e.getMessage());
			result = new SecKillResult<Exposer>(false,e.getMessage());
		}
		return result;
	}
	@RequestMapping(value="/{seckillId}/{md5}/execution",method=RequestMethod.POST,
			produces={"application/json;charset=UTF-8"})//模块
	@ResponseBody//spring 将结果封装为json
	public SecKillResult<SecKillExecution> execute(@PathVariable("seckillId")Long seckillId,@PathVariable("md5")String md5,
								@CookieValue(value="killPhone",required=false)Long userphone){
		if(userphone ==null){
			return new  SecKillResult<SecKillExecution>(false,"未注册");
		}
		SecKillResult<SecKillExecution> result;
		try{
		SecKillExecution secKillExecution=seckillService.executeSeckill(seckillId, userphone, md5);
		return new SecKillResult<SecKillExecution>(true,secKillExecution);
		}catch(RepeatKillException e){
			SecKillExecution secKillExecution=new SecKillExecution(seckillId,SecKillStatusEnum.REPEAT_KILL);
			result = new SecKillResult<SecKillExecution>(false,e.getMessage());
		}catch(SecKillCloseException e){
			SecKillExecution secKillExecution=new SecKillExecution(seckillId,SecKillStatusEnum.END);
			result = new SecKillResult<SecKillExecution>(false,e.getMessage());
		}catch(Exception e){
			SecKillExecution secKillExecution=new SecKillExecution(seckillId,SecKillStatusEnum.INNER_ERROR);
			result = new SecKillResult<SecKillExecution>(false,e.getMessage());
		}
		return result;
	}
	@RequestMapping(value="/time/now",method=RequestMethod.GET)
	public SecKillResult<Long> time(){
		Date now = new Date();
		Long time=now.getTime();
		return new SecKillResult<Long>(true,time);
	}
}
