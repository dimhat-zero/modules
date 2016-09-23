package com.jianla.faudit.service.impl;

import com.jianla.faudit.dao.OptionDao;
import com.jianla.faudit.dao.QuestionDao;
import com.jianla.faudit.dto.OptionDto;
import com.jianla.faudit.dto.QuestionDto;
import com.jianla.faudit.dto.QuestionType;
import com.jianla.faudit.entity.Option;
import com.jianla.faudit.entity.Question;
import com.jianla.faudit.service.QuestionService;
import com.jianla.model.base.Page;
import com.jianla.util.PageUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author : zwj
 * @data : 2016/9/21
 */
@Service
@Transactional
public class QuestionServiceImpl implements QuestionService {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private QuestionDao questionDao;
    @Autowired
    private OptionDao optionDao;


    @Override
    public void create(Long orgId, String content, Short type, List<String> options) {
        Question question = new Question(content,type,new Date(), orgId);
        questionDao.save(question);
        Long questionId = question.getId();
        logger.debug("create question[{}] success.",questionId);
        for (String optionStr : options) {
            Option option = new Option(optionStr,questionId);
            optionDao.save(option);
        }
    }

    @Override
    public void update(Long id, String content, Short type, List<String> options) {
        Question question = questionDao.getById(id);
        if(question==null) return;
        question.setContent(content);
        question.setType(type);
        //delete old options
        Long questionId = question.getId();
        optionDao.deleteByQuestionId(questionId);
        //insert new options
        for (String optionStr : options) {
            Option option = new Option(optionStr,questionId);
            optionDao.save(option);
        }
    }

    @Override
    public void delete(Long id) {
        Question question = questionDao.getById(id);
        if(question!=null){
            //delete question options
            optionDao.deleteByQuestionId(question.getId());
            //delete self
            questionDao.delete(question);
        }
    }

    @Override
    public Question getById(Long id) {
        Question question = questionDao.getById(id);

        return question;
    }

    @Override
    public QuestionDto getDetailById(Long id) {
        Question question = questionDao.getById(id);
        if(question==null) return null;
        QuestionDto dto  = trans(question);
        //find options
        dto.setOptions(this.findOptionsByQuestionId(question.getId()));
        return dto;
    }

    private List<OptionDto> findOptionsByQuestionId(Long questionId){
        List<Option> options = optionDao.findByQuestionId(questionId);
        List<OptionDto> optionDtos = new ArrayList<>();
        for (Option option : options) {
            OptionDto dto = new OptionDto();
            BeanUtils.copyProperties(option,dto);
            optionDtos.add(dto);
        }
        return optionDtos;
    }


    @Override
    public Page<QuestionDto> find(Page page,QuestionDto question) {

        String hql = "from Question where 1=1";
        List<Object> values= new ArrayList<>();
        hql = addWhere(hql,values,question);

        //add count
        Long count = questionDao.count("select count(*) "+hql, values);
        page.setTotalCount(count);
        if(count==0) return page;
        //add order by
        hql = PageUtil.addOrderBy(hql, page);
        //add list
        List<Question> questions = questionDao.find(hql, values,page.getPageNo(),page.getPageSize());
        page.setResult(trans(questions));
        return page;
    }


    private String addWhere(String hqlStr, List<Object> values, QuestionDto question) {
        StringBuilder hql = new StringBuilder(hqlStr);
        if(question.getId()!=null){
            hql.append(" and id = ?");
            values.add(question.getId());
            return hql.toString();
        }
        if(question.getOrgId()!=null){
            hql.append(" and orgId = ?");
            values.add(question.getOrgId());
        }
        if(question.getContent()!=null){
            hql.append(" and content like ?");
            values.add("%"+question.getContent()+"%");
        }
        if(question.getType()!=null){
            hql.append(" and type = ?");
            values.add(question.getType());
        }
        return hql.toString();
    }


    /*
     trans
     */
    private Question trans(QuestionDto dto) {
        Question question = new Question();
        BeanUtils.copyProperties(dto,question,new String[]{"type"});
        question.setType(dto.getType().getCode());
        return question;
    }

    private QuestionDto trans(Question question) {
        QuestionDto dto= new QuestionDto();
        BeanUtils.copyProperties(question,dto,new String[]{"type"});
        dto.setType(QuestionType.code(question.getType()));
        return dto;
    }

    private List<QuestionDto> trans(List<Question> questions){
        List<QuestionDto> list = new ArrayList<>();
        for (Question question : questions) {
            list.add(trans(question));
        }
        return list;
    }

}
