package ru.pchurzin.spring.customannotations;

import org.springframework.web.servlet.mvc.condition.RequestCondition;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

import java.lang.reflect.Method;

import static ru.pchurzin.spring.customannotations.NoRequestParamsCondition.NO_PARAMS_CONDITION;

public class CustomRequestMappingHandlerMapping extends RequestMappingHandlerMapping {

    @Override
    protected RequestCondition<?> getCustomMethodCondition(Method method) {
        return method.isAnnotationPresent(NoRequestParams.class) ? NO_PARAMS_CONDITION : null;
    }
}
