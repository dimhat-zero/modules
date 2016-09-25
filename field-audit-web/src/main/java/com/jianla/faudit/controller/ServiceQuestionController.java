package com.jianla.faudit.controller;

import com.jianla.faudit.dto.QuestionDto;
import com.jianla.faudit.model.ServiceQuestionForm;
import com.jianla.faudit.service.AnswerService;
import com.jianla.faudit.service.ServiceQuestionService;
import com.jianla.model.base.JsonResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author : zwj
 * @data : 2016/9/25
 */
@Controller
@RequestMapping("service")
public class ServiceQuestionController {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private ServiceQuestionService serviceQuestionService;
    @Autowired
    private AnswerService answerService;

    //编辑问题
    @RequestMapping(value = "{id}/questions/edit",method = RequestMethod.GET)
    public String edit(@PathVariable("id")Long serviceId, Model model){
        model.addAttribute("serviceId",serviceId);
        return "faudit/questions_select";
    }

    //展现问题
    @RequestMapping(value = "{id}/questions",method = RequestMethod.GET)
    public String list(@PathVariable("id")Long serviceId, Model model){
        model.addAttribute("serviceId",serviceId);
        //回答审核单对应服务的题目
        //answerService.getByFauidId(998L);
        model.addAttribute("fauditId",998L);// FIXME: 2016/9/25 测试数据
        return "faudit/questions_show";
    }

    /*
     * Page and JSON
     */
    @RequestMapping(value = "{id}/questions/edit",method = RequestMethod.POST)
    @ResponseBody
    public JsonResult doEdit(@PathVariable("id")Long serviceId, @RequestBody ServiceQuestionForm form){
        try {
            serviceQuestionService.add(serviceId,form.getQuestionIds());
            return JsonResult.OK;
        } catch (Exception e) {
            logger.error("编辑服务问题错误",e);
            return new JsonResult(false,"编辑服务问题错误");
        }
    }

    @RequestMapping(value = "data/{id}/questions",method = RequestMethod.GET)
    @ResponseBody
    public JsonResult list(@PathVariable("id")Long serviceId){
        try {
            List<QuestionDto> list = serviceQuestionService.findQuestionsByServiceId(serviceId);
            JsonResult result = new JsonResult();
            result.setData(list);
            return result;
        } catch (Exception e) {
            logger.error("查询服务问题错误",e);
            return new JsonResult(false,"查询服务问题错误");
        }
    }

}
