package com.example.finalprojectapp.service;

import com.example.finalprojectapp.dto.InvoiceDto;
import com.example.finalprojectapp.exception.InvalidUUIDException;
import com.example.finalprojectapp.exception.InvoiceNotFoundException;
import com.example.finalprojectapp.mapper.InvoiceMapper;
import com.example.finalprojectapp.repository.InvoiceRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;

@Service
@Validated
@RequiredArgsConstructor
public class InvoiceService {
    private final InvoiceRepository invoiceRepository;
    private final InvoiceMapper invoiceMapper;

    public List<InvoiceDto> findAll() {
        return invoiceMapper.modelToDtos(invoiceRepository.findAll());
    }

    public InvoiceDto findById(UUID id){
        return invoiceMapper.modelToDto(invoiceRepository.findById(id).orElseThrow(InvoiceNotFoundException::new));
    }

    public InvoiceDto saveNew(@Valid InvoiceDto invoiceDto) {
        this.checkIfIdIsEmpty(invoiceDto);
        return invoiceMapper.modelToDto(invoiceRepository.save(invoiceMapper.dtoToModel(invoiceDto)));
    }

    public void deleteById(UUID id) {
        this.checkIfManufacturerExists(id);
        invoiceRepository.deleteById(id);
    }

    private void checkIfManufacturerExists(UUID id) {
        this.findById(id);
    }

    private void checkIfIdIsEmpty(InvoiceDto invoiceDto) {
        if (invoiceDto.getId() != null)
            throw new InvalidUUIDException();
    }

    public InvoiceDto saveExisting(@Valid InvoiceDto invoiceDto) {
        this.checkIfManufacturerExists(invoiceDto.getId());
        return invoiceMapper.modelToDto(invoiceRepository.save(invoiceMapper.dtoToModel(invoiceDto)));
    }
}
