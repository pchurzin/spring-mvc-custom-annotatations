package ru.pchurzin.spring.customannotations;

import org.springframework.web.servlet.mvc.condition.RequestCondition;

import javax.servlet.http.HttpServletRequest;
import java.util.Objects;

public class NoRequestParamsCondition implements RequestCondition<NoRequestParamsCondition> {

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
        Objects.requireNonNull(other);
        return 0;
    }
}