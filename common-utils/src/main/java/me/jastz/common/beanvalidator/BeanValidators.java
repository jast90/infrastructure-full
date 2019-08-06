package me.jastz.common.beanvalidator;

import com.google.common.collect.Lists;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.validation.Validator;
import java.util.List;
import java.util.Set;

/**
 * JSR303 Validator(Hibernate Validator)工具类.
 * Created by zhiwen on 2017/2/7.
 */
public class BeanValidators {

    /**
     * 调用JSR303的validate方法，验证失败时抛出ConstraintViolationException
     *
     * @param validator
     * @param object
     * @param groups
     * @throws ConstraintViolationException
     */
    public static void validateWithException(Validator validator, Object object, Class<?>... groups)
            throws ConstraintViolationException {
        Set constraintViolations = validator.validate(object, groups);
        if (!constraintViolations.isEmpty()) {
            throw new ConstraintViolationException(constraintViolations);
        }

    }

    /**
     * 提取异常中的属性及对应的错误信息
     *
     * @param e
     * @param separator
     * @return
     */
    public static List<String> extractPropertyAndMessageAsList(ConstraintViolationException e, String separator) {
        return extractPropertyAndMessageAsList(e.getConstraintViolations(), separator);
    }

    public static List<String> extractPropertyAndMessageAsList(Set<? extends ConstraintViolation> constraintViolations
            , String separator) {
        List errorMessage = Lists.newArrayList();
        for (ConstraintViolation constraintViolation : constraintViolations) {
            errorMessage.add(constraintViolation.getPropertyPath() + separator + constraintViolation.getMessage());
        }
        return errorMessage;
    }
}
