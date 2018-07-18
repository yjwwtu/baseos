package com.link510.softgateway.data;

import com.link510.softgateway.core.cache.CWMCache;
import com.link510.softgateway.core.config.CWMConfig;
import com.link510.softgateway.core.data.CWMData;
import com.link510.softgateway.core.sms.CWMSMS;
import com.link510.softgateway.core.cache.CWMCache;
import com.link510.softgateway.core.config.CWMConfig;
import com.link510.softgateway.core.data.CWMData;
import com.link510.softgateway.core.sms.CWMSMS;
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
