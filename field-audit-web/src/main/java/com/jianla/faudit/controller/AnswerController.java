package com.jianla.faudit.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.jianla.faudit.dto.AnswerDto;
import com.jianla.faudit.model.AnswerForm;
import com.jianla.faudit.model.QuestionAnswer;
import com.jianla.faudit.service.AnswerService;
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
@RequestMapping("answer")
public class AnswerController {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private AnswerService answerService;

    //答案快照页
    @RequestMapping(value = "{id}",method = RequestMethod.GET)
    public String detail(@PathVariable("id")Long answerId,Model model){
        model.addAttribute("answerId",answerId);
        return "faudit/answer_show";
    }

    /*
     * Page and JSON
     */

    /**
     * 如果400，就是参数json转对象失败
     * FIXME: 2016/9/25 用AnswerForm作为参数就是不行
     */

    @RequestMapping(value = "submit",method = RequestMethod.POST)
    @ResponseBody
    public JsonResult doSubmit(@RequestBody JSONObject jsonObject){
        logger.debug("begin submit");
        try {
            String formJSON = jsonObject.toJSONString();
            logger.debug("form json :{}",formJSON);
            AnswerForm form = JSON.parseObject(formJSON,AnswerForm.class);
            //回答了问题的答案
            String jsonStr = JSON.toJSONString(form.getQuestions());
            logger.debug("questions json {}",jsonStr);
            if(form.getId()==null){
                answerService.submit(form.getFauditId(),jsonStr);
            }else{
                answerService.modify(form.getId(),jsonStr);
            }
            return JsonResult.OK;
        } catch (Exception e) {
            logger.error("提交答案失败",e);
            return new JsonResult(false,"提交答案失败");
        }
    }

    @RequestMapping(value = "data/{id}",method = RequestMethod.GET)
    @ResponseBody
    public JsonResult getDetail(@PathVariable("id")Long id){
        try {
            AnswerDto dto = answerService.getById(id);
            String content = dto.getContent();
            logger.debug("content : {}",content);
            List<QuestionAnswer> questions = JSON.parseArray(content, QuestionAnswer.class);
            JsonResult result = new JsonResult();
            result.setData(questions);
            return result;
        } catch (Exception e) {
            logger.error("查询答案失败",e);
            return new JsonResult(false,"查询答案失败");
        }
    }

}
