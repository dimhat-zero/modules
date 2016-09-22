package com.jianla.faudit.controller;

import com.jianla.faudit.dto.QuestionaireDto;
import com.jianla.faudit.entity.Questionaire;
import com.jianla.faudit.model.QuestionaireForm;
import com.jianla.faudit.service.QuestionaireService;
import com.jianla.model.base.JsonResult;
import com.jianla.model.base.SessionInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @author : zwj
 * @data : 2016/9/22
 */
@Controller
@RequestMapping("questionaire")
public class QuestionaireController {

    @Autowired
    private QuestionaireService questionaireService;

    @RequestMapping(value = "add",method = RequestMethod.GET)
    public String add(Model model){
        return "questionaire/add";
    }

    @RequestMapping(value = "{id}/edit",method = RequestMethod.GET)
    public String edit(@PathVariable("id")Long id){
        return "questionaire/edit";
    }

    @RequestMapping(value = "",method = RequestMethod.GET)
    public String list(){
        return "questionaire/list";
    }

    //用户页面
    @RequestMapping(value = "{id}",method = RequestMethod.GET)
    public String detail(){
        return "questionaire/detail";
    }

    /*
     * Page and Json
     */

    @RequestMapping(value = "add",method = RequestMethod.POST)
    @ResponseBody
    public JsonResult doAdd(SessionInfo sessionInfo, QuestionaireForm form){
        try {
            questionaireService.create(sessionInfo.getOrgnizationId(), form.getTitle(), form.getSummary(), form.getQuestions());
            return JsonResult.OK;
        }catch (Exception e){
            return new JsonResult(false,e.getMessage());
        }
    }


    @RequestMapping(value = "{id}/edit",method = RequestMethod.POST)
    @ResponseBody
    public JsonResult doEdit(@PathVariable("id")Long id,QuestionaireForm form){
        try {
            questionaireService.update(id,form.getTitle(),form.getSummary(),form.getQuestions());
            return JsonResult.OK;
        } catch (Exception e) {
            return new JsonResult(false,e.getMessage());
        }
    }

    @RequestMapping(value = "{id}/delete",method = {RequestMethod.DELETE,RequestMethod.POST})
    @ResponseBody
    public JsonResult doDelete(@PathVariable("id")Long id){
        try {
            questionaireService.delete(id);
            return JsonResult.OK;
        } catch (Exception e) {
            return new JsonResult(false,e.getMessage());
        }
    }


    @RequestMapping(value = "list",method = RequestMethod.GET)
    @ResponseBody
    public JsonResult doList(SessionInfo sessionInfo){
        try {
            List<Questionaire> list = questionaireService.findByOrgId(sessionInfo.getOrgnizationId());
            JsonResult result = new JsonResult();
            result.setData(list);
            return result;
        }catch (Exception e){
            return new JsonResult(false,e.getMessage());
        }
    }

    @RequestMapping(value = "{id}",method = RequestMethod.GET)
    @ResponseBody
    public JsonResult doDetail(@PathVariable("id")Long id){
        try {
            QuestionaireDto questionaireDto = questionaireService.getDetailById(id);
            if(questionaireDto==null){
                return new JsonResult(false,"questionnaire object not find");
            }
            JsonResult result = new JsonResult();
            result.setData(questionaireDto);
            return result;
        }catch (Exception e){
            return new JsonResult(false,e.getMessage());
        }
    }
}
