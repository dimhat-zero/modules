package com.jianla.faudit.controller;

import com.jianla.faudit.dto.QuestionDto;
import com.jianla.faudit.entity.Question;
import com.jianla.faudit.model.QuestionForm;
import com.jianla.faudit.service.QuestionService;
import com.jianla.faudit.service.ServiceQuestionService;
import com.jianla.faudit.util.AuthUtil;
import com.jianla.model.base.JsonResult;
import com.jianla.model.base.Page;
import com.jianla.model.base.SessionInfo;
import com.jianla.util.ParseUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @author : zwj
 * @data : 2016/9/23
 */
@Controller
@RequestMapping("question")
public class QuestionController {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private QuestionService questionService;
    @Autowired
    private ServiceQuestionService serviceQuestionService;

    @RequestMapping(value = "",method = RequestMethod.GET)
    public String listPage(){
        return "faudit/question_list";
    }

    @RequestMapping(value = "add",method = RequestMethod.GET)
    public String add(){
        return "faudit/question_add";
    }

    @RequestMapping(value="{id}/edit",method = RequestMethod.GET)
    public String edit(@PathVariable("id")Long id){
        return "faudit/question_edit";
    }

    /*
     * Page and Json
     */
    @RequestMapping(value = "data",method=RequestMethod.GET)
    @ResponseBody
    public JsonResult list(SessionInfo sessionInfo, Page<QuestionDto> page,QuestionDto question){
        question.setOrgId(sessionInfo.getOrgnizationId());
        page = questionService.find(page, question);
        JsonResult result = new JsonResult();
        result.setData(page);
        return result;
    }

    @RequestMapping(value = "data/{id}",method=RequestMethod.GET)
    @ResponseBody
    public JsonResult detail(@PathVariable("id")Long id,SessionInfo sessionInfo){
        try {
            QuestionDto questionDto = questionService.getDetailById(id);
            AuthUtil.assertEqual(sessionInfo.getOrgnizationId(),questionDto.getOrgId());

            JsonResult result = new JsonResult();
            result.setData(questionDto);
            return result;
        } catch (Exception e) {
            logger.error("查询问题出错",e);
            return new JsonResult(false,"查询问题出错");
        }
    }

    @RequestMapping(value="add",method = RequestMethod.POST)
    @ResponseBody
    public JsonResult doAdd(SessionInfo sessionInfo, QuestionForm form){
        try {
            questionService.create(sessionInfo.getOrgnizationId(),form.getContent(),form.getType(),form.getOptions());
            return JsonResult.OK;
        } catch (Exception e) {
            logger.error("增加问题出错",e);
            return new JsonResult(false,"增加问题出错");
        }
    }

    @RequestMapping(value = "{id}/edit",method = RequestMethod.POST)
    @ResponseBody
    public JsonResult doEdit(SessionInfo sessionInfo,@PathVariable("id")Long id,QuestionForm form){
        try {
            Question question = questionService.getById(form.getId());
            AuthUtil.assertEqual(sessionInfo.getOrgnizationId(),question.getOrgId());

            questionService.update(id,form.getContent(),form.getType(),form.getOptions());
            return JsonResult.OK;
        } catch (Exception e) {
            logger.error("更新问题出错",e);
            return new JsonResult(false,"更新问题出错");
        }
    }

    /*
     * // FIXME: 2016/9/23 删除前进行服务关联检查
     */
    @RequestMapping(value = "{id}/delete",method = RequestMethod.POST)
    @ResponseBody
    public JsonResult doDelete(@PathVariable("id") Long id,SessionInfo sessionInfo){

        try {
            Question question = questionService.getById(id);
            AuthUtil.assertEqual(sessionInfo.getOrgnizationId(),question.getOrgId());

            List<Long> serviceIds = serviceQuestionService.findServiceIdByQuestionId(id);
            if(serviceIds.size()!=0){
                return new JsonResult(false,"无法删除问题，下列服务引用【"+ ParseUtil.toString(serviceIds)+"】");
            }

            questionService.delete(id);
            return JsonResult.OK;
        } catch (Exception e) {
            logger.error("删除问题出错",e);
            return new JsonResult(false,"删除问题出错");
        }
    }


}
