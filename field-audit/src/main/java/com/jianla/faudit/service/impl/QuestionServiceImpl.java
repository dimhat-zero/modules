package com.jianla.faudit.service.impl;

import com.jianla.faudit.dao.OptionDao;
import com.jianla.faudit.dao.QuestionDao;
import com.jianla.faudit.dto.QuestionDto;
import com.jianla.faudit.entity.Option;
import com.jianla.faudit.entity.Question;
import com.jianla.faudit.service.QuestionService;
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
    public void create(Long orgId,String content, Short type, List<String> options) {
        Question question = new Question(content,type,new Date(),orgId);
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
        optionDao.deleteByQuestionid(questionId);
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
            this.delete(question);
        }
    }

    @Override
    public void delete(Question question) {
        questionDao.delete(question);
        //delete question options
        optionDao.deleteByQuestionid(question.getId());
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
        QuestionDto dto = new QuestionDto();
        BeanUtils.copyProperties(question,dto);
        dto.setType(question.getType());
        //find options
        List<String> optionContents = optionDao.findContentByQuestionId(question.getId());
        dto.setOptions(optionContents);
        return dto;
    }

    @Override
    public List<Question> findByOrgId(Long orgId) {
        return questionDao.find("from Question where orgId = ?",new Object[]{orgId});
    }

    @Override
    public List<QuestionDto> findDetailByIds(List<Long> questionIds) {
        List<QuestionDto> list = new ArrayList<>();
        for (Long questionId : questionIds) {
            list.add(this.getDetailById(questionId));
        }
        return list;
    }
}
