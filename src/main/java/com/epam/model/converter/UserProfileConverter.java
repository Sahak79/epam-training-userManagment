package com.epam.model.converter;

import com.epam.model.lcp.UserProfile;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

/**
 * Created by Sahak_Babayan on 3/31/2016.
 */
@Converter(autoApply = true)
public class UserProfileConverter implements AttributeConverter<UserProfile, Integer> {

    @Override
    public Integer convertToDatabaseColumn(UserProfile attribute) {
        return attribute.getValue();
    }

    @Override
    public UserProfile convertToEntityAttribute(Integer dbData) {
        return UserProfile.valueOf(dbData);
    }
}
