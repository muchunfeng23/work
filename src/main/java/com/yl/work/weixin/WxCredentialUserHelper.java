package com.yl.work.weixin;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 *
 */
@Service
public class WxCredentialUserHelper {
    private Logger logger = LoggerFactory.getLogger(WxCredentialUserHelper.class);

    public void uploadLoginUserCredentialData(String userJsonStr){
        logger.info(userJsonStr);
    }
}
