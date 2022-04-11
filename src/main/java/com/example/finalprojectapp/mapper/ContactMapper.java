package com.example.finalprojectapp.mapper;

import com.example.finalprojectapp.dto.ContactDto;
import com.example.finalprojectapp.model.Contact;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ContactMapper {
    @Mappings({
            @Mapping(source = "primary",target = "isPrimary")
    })
    ContactDto modelToDto (Contact contact);
    List<ContactDto> modelToDtos(List<Contact> contact);
    @Mappings({
            @Mapping(source = "primary",target = "isPrimary")
    })
    Contact dtoToModel (ContactDto contactDto);
}
