package com.jianla.faudit.service.impl;

import com.jianla.faudit.service.AnswerService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * 在服务器端进行选择：比较复杂但安全
 * 另一种是在浏览器中处理，返回字符串
 * @author : zwj
 * @data : 2016/9/22
 */
@Service
@Transactional
public class AnswerServiceImpl implements AnswerService {

    /*private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private AnswerDao answerDao;

    @Override
    public Answer submitAnswer(Long fauditId, List<QuestionAnswer> questionAnswers) {

        Answer answer = new Answer();

        return null;
    }

    @Override
    public Answer submitAnswer(Long qnId, List<OptionDto> options, long version) {
//        QuestionnaireDto questionnaireDto = questionnaireService.getDetailById(qnId);
//        if(questionnaireDto==null){
//            throw new FauditException("问卷不存在");
//        }
//        long dbVersion = questionnaireDto.getGmtModify().getTime();
//        if(dbVersion!=version){
//            throw new FauditException("问卷已更新，请刷新页面");
//        }
//        return snapshotAnswer(questionnaireDto,options);
        return null;
    }

    private Answer snapshotAnswer(QuestionnaireDto questionnaireDto, List<OptionDto> options){
//        this.selectOptions(questionnaireDto,options);
//        //保存
//        String snapshotStr = this.snapshot(questionnaireDto);
//        Answer answer = new Answer(questionnaireDto.getId(),snapshotStr,new Date());
//        answerDao.save(answer);
//        return answer;
        return null;
    }

    //自动选择选项
    private void selectOptions(QuestionnaireDto questionnaireDto,List<OptionDto> options){
        //构建选项map
        Map<Long,OptionDto> optionMap = new HashMap<>();
        for (QuestionDto questionDto : questionnaireDto.getQuestions()) {
            for (OptionDto optionDto : questionDto.getOptions()) {
                optionDto.setSelected(false);
                optionDto.setRemark(null);
                optionMap.put(optionDto.getId(),optionDto);
            }
        }
        //选择选项
        for (OptionDto option : options) {
            OptionDto optionDto = optionMap.get(option.getId());
            if(optionDto!=null){
                optionDto.setSelected(true);
                if(optionDto.custom()){
                    optionDto.setRemark(option.getRemark());
                }
            }
        }
    }

    @Override
    public void modifyAnswer(Long id,List<OptionDto> options) {
        Answer answer = answerDao.getById(id);
        QuestionnaireDto questionnaireDto = this.restore(answer.getContent());
        this.selectOptions(questionnaireDto,options);
        //保存
        String snapshotStr = this.snapshot(questionnaireDto);
        answer.setContent(snapshotStr);
        answerDao.update(answer);

    }

    private String snapshot(Object obj){
        return JSON.toJSONString(obj);
    }

    private QuestionnaireDto restore(String snapshotStr){
        QuestionnaireDto questionnaireDto = JSON.parseObject(snapshotStr, QuestionnaireDto.class);
        return questionnaireDto;
    }

    @Override
    public QuestionnaireDto getAnswerById(Long id) {
        Answer answer = answerDao.getById(id);
        return this.restore(answer.getContent());
    }*/
}
