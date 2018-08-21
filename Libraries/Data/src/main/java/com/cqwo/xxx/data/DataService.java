package com.cqwo.xxx.data;

import com.cqwo.xxx.core.cache.CWMCache;
import com.cqwo.xxx.core.config.CWMConfig;
import com.cqwo.xxx.core.data.CWMData;
import com.cqwo.xxx.core.sms.CWMSMS;
import com.cqwo.xxx.core.cache.CWMCache;
import com.cqwo.xxx.core.config.CWMConfig;
import com.cqwo.xxx.core.data.CWMData;
import com.cqwo.xxx.core.sms.CWMSMS;
import com.cqwo.xxx.core.cache.CWMCache;
import com.cqwo.xxx.core.config.CWMConfig;
import com.cqwo.xxx.core.data.CWMData;
import com.cqwo.xxx.core.sms.CWMSMS;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;


@Getter
@Setter
public class DataService {

    @Autowired
    private CWMCache cwmCache;

    @Autowired
    private CWMData cwmData;

    @Autowired
    private CWMSMS cwmSMS;

    @Autowired
    private CWMConfig cwmConfig;


}
