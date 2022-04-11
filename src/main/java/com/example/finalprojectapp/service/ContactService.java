package com.example.finalprojectapp.service;

import com.example.finalprojectapp.dto.ContactDto;
import com.example.finalprojectapp.exception.ContactNotFoundException;
import com.example.finalprojectapp.exception.InvalidUUIDException;
import com.example.finalprojectapp.mapper.ContactMapper;
import com.example.finalprojectapp.repository.ContactRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;

@Service
@Validated
@RequiredArgsConstructor
public class ContactService {
    private final ContactRepository contactRepository;
    private final ContactMapper contactMapper;



    public List<ContactDto> findAll() {
        return contactMapper.modelToDtos(contactRepository.findAll());
    }

    public ContactDto findById(UUID id) {
        return contactMapper.modelToDto(contactRepository.findById(id).orElseThrow(ContactNotFoundException::new));
    }

    public ContactDto saveNew(@Valid ContactDto contactDto) {
        this.checkIfIdIsEmpty(contactDto);
        return contactMapper.modelToDto(contactRepository.save(contactMapper.dtoToModel(contactDto)));
    }

    public void deleteById(UUID id) {
        this.checkIfVatExists(id);
        contactRepository.deleteById(id);
    }

    private void checkIfVatExists(UUID id) {
        this.findById(id);
    }

    private void checkIfIdIsEmpty(ContactDto contactDto) {
        if (contactDto.getId() != null)
            throw new InvalidUUIDException();
    }

    public ContactDto saveExisting(@Valid ContactDto contactDto) {
        this.checkIfVatExists(contactDto.getId());
        return contactMapper.modelToDto(contactRepository.save(contactMapper.dtoToModel(contactDto)));
    }
}
