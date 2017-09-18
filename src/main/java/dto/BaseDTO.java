package dto;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

import static org.apache.commons.lang3.builder.EqualsBuilder.reflectionEquals;
import static org.apache.commons.lang3.builder.HashCodeBuilder.reflectionHashCode;

public class BaseDTO {

    protected BaseDTO() {
    }

    @Override
    public boolean equals(final Object obj) {
        return reflectionEquals(this, obj);
    }

    @Override
    public int hashCode() {
        return reflectionHashCode(this);
    }

    @Override
    public String toString() {
        return ReflectionToStringBuilder.toString(this);
    }

    String getCheckedField(String field) {
        if (StringUtils.isNotBlank(field)) {
            return field;
        }
        return StringUtils.EMPTY;
    }
}
