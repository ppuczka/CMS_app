package pl.coderslab.validator;


import pl.coderslab.entity.Category;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.List;

public class CategoryValidator implements ConstraintValidator<SizeLimit, List<Category>> {
    Integer sizeLimit;
    @Override
    public void initialize(SizeLimit constraintAnnotation) {
        this.sizeLimit = constraintAnnotation.limit();

    }

    @Override
    public boolean isValid(List<Category> categories, ConstraintValidatorContext constraintValidatorContext) {
        return categories.size() < sizeLimit ;
    }
}
