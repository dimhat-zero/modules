#Field Audit 实地审核

##需求分析
####基本流程
1. 机构在发布服务的时候选择验厂审核业务，并可以添加 自检表。
2. 在用户购买“验厂审核的服务”后，进行填单，跟报检类似（企业信息，业务信息，发票信息）
。然后生成申请表。显示自验单。

##设计
服务增加类别分辨是“报检业务”还是“验厂审核业务”

##表设计
实施有两种方式：
1. 让问卷独立于服务，多个服务可用一个问卷
2. 让问卷附属于服务，一个服务填一份问卷
服务 和 问卷 1对1 还是 多对多
问卷 和 问题 1对多 还是 多对多

    说明：表前缀faudit，容易辨认
###第一部分 验厂
####faudit 实地审核申请表
| 字段名 | 类型 | 说明 |
|---|---|---|
|id | bigint | 主键|
|answer_id|bigint|问卷答案外键|

####service_qn 服务关联问卷表
| 字段名 | 类型 | 说明 |
|---|---|---|
|id | bigint | 主键|
|service_id|bigint|服务外键|
|qn_id|bigint|问卷外键|


###第二部分 问卷
####questionnaire 问卷表
| 字段名 | 类型 | 说明 |
|---|---|---|
|id | bigint | 主键|
|org_id| bigint |外键，必须|
|title|varchar |标题|
|summary|varchar|摘要|
|gmt_create|datatime|创建时间|


####question 问题表
|字段名|类型|说明|
|---|---|---|
|id|bigint|主键|
|qn_id|bigint|问卷外键|
|type|tyint|类型|
|content|varchar|问题陈述|
|gmt_create|datatime|创建时间|

    说明：类型分为：1.单选 2.多选 3.问答 优先支持单选


####option 选项表
|字段名|类型|说明|
|---|---|---|
|id|bigint|主键|
|question_id|bigint|问题外键|
|content|varchar|选项内容|
    如果该选项的内容为空代表让用户自己填写

####answer 答案表
|字段名|类型|说明|
|---|---|---|
|id|bigint|主键|
|qa_id|bigint|问卷外键|
|content|varchar|问卷快照|
|gmt_create|datatime|回答时间|
    问卷快照是json类型，附带version版本号可扩展解析

##问题
用户答完题后，机构修改了问卷？
+ 方案1：不能修改问卷
+ 方案2：答题快照



表xx_
id,questionnaire_id,type(单选，多选，问答）,content

表xx_option 选项表
id,question_id,content

表xx_answer 答案表
id,questionnaire_id,content
用户填完后，你修改了选项？  回答是选项option的id，只能伪删除。

问题完成后不能修改，至少选项不能修改。