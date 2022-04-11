package com.example.finalprojectapp.mapper;

import com.example.finalprojectapp.dto.ContactDto;
import com.example.finalprojectapp.model.Contact;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ContactMapper {
    ContactDto modelToDto (Contact contact);
    List<ContactDto> modelToDtos(List<Contact> contact);
    Contact dtoToModel (ContactDto contactDto);
}
