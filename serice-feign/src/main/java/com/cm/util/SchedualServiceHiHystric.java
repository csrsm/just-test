package com.cm.util;

import com.cm.service.SchedualServiceHi;
import org.springframework.stereotype.Component;

/**
 * Created by zytc001 on 2018/6/5.
 */
@Component
public class SchedualServiceHiHystric implements SchedualServiceHi{
    @Override
    public String sayHiFromClientOne(String name) {
        return "sorry "+name;
    }
}
