package ru.pchurzin.spring.customannotations;

import org.springframework.web.servlet.mvc.condition.AbstractRequestCondition;

import javax.servlet.http.HttpServletRequest;
import java.util.Collection;
import java.util.Collections;

public class NoRequestParamsCondition extends AbstractRequestCondition<NoRequestParamsCondition> {

    public final static NoRequestParamsCondition NO_PARAMS_CONDITION = new NoRequestParamsCondition();

    @Override
    protected Collection<?> getContent() {
        return Collections.singleton("no params");
    }

    @Override
    protected String getToStringInfix() {
        return "";
    }

    @Override
    public NoRequestParamsCondition combine(NoRequestParamsCondition other) {
        return this;
    }

    @Override
    public NoRequestParamsCondition getMatchingCondition(HttpServletRequest request) {
        if (request.getParameterMap().isEmpty()) {
            return this;
        }
        return null;
    }

    @Override
    public int compareTo(NoRequestParamsCondition other, HttpServletRequest request) {
        return 0;
    }
}