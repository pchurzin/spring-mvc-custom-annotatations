package ru.pchurzin.spring.customannotations;

import org.springframework.web.servlet.mvc.condition.RequestCondition;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

import java.lang.reflect.Method;

public class CustomRequestMappingHandlerMapping extends RequestMappingHandlerMapping {

    @Override
    protected RequestCondition<?> getCustomMethodCondition(Method method) {
        return method.isAnnotationPresent(NoRequestParams.class) ? new NoRequestParamsCondition() : null;
    }
}
