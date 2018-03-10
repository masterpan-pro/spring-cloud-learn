package com.github.pengpan.hystric;

import com.github.pengpan.fegin.SchedualServiceHi;
import org.springframework.stereotype.Component;

/**
 * @author pengpan
 */
@Component
public class SchedualServiceHiHystric implements SchedualServiceHi {

    @Override
    public String sayHiFromClientOne(String name) {
        return "sorry " + name;
    }
}
