package org.carrot2.util.attribute.constraint;

import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationTargetException;

import org.apache.commons.lang.reflect.MethodUtils;
import org.simpleframework.xml.Root;

@Root(name = "passes-value-of")
public class PassesValueOfConstraint extends Constraint
{
    private Class<?> clazz;

    /*
     * 
     */
    PassesValueOfConstraint()
    {
    }

    /*
     * 
     */
    @Override
    protected boolean isMet(Object value)
    {
        if (value != null && value instanceof String)
        {
            try
            {
                MethodUtils.invokeExactStaticMethod(clazz, "valueOf", value);
            }
            catch (NoSuchMethodException e)
            {
                throw new RuntimeException("No valueOf method in class: " + clazz);
            }
            catch (IllegalAccessException e)
            {
                throw new RuntimeException("Illegal access to valueOf in class: " + clazz);
            }
            catch (InvocationTargetException e)
            {
                return false;
            }
        }
        return true;
    }

    @Override
    protected void populateCustom(Annotation annotation)
    {
        this.clazz = ((PassesValueOf) annotation).valueOfClass();
    }
}
