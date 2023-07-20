package com.seabox.module.system.dal.mysql.mail;

import com.seabox.framework.common.pojo.PageResult;
import com.seabox.framework.mybatis.core.mapper.BaseMapperX;
import com.seabox.framework.mybatis.core.query.LambdaQueryWrapperX;
import com.seabox.module.system.controller.admin.mail.vo.account.MailAccountPageReqVO;
import com.seabox.module.system.dal.dataobject.mail.MailAccountDO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MailAccountMapper extends BaseMapperX<MailAccountDO> {

    default PageResult<MailAccountDO> selectPage(MailAccountPageReqVO pageReqVO) {
        return selectPage(pageReqVO, new LambdaQueryWrapperX<MailAccountDO>()
                .likeIfPresent(MailAccountDO::getMail, pageReqVO.getMail())
                .likeIfPresent(MailAccountDO::getUsername , pageReqVO.getUsername()));
    }

}
