package com.example.finalprojectapp.mapper;

import com.example.finalprojectapp.dto.InvoiceDto;
import com.example.finalprojectapp.model.Invoice;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface InvoiceMapper {
    InvoiceDto modelToDto (Invoice invoice);
    List<InvoiceDto> modelToDtos(List<Invoice> invoices);
    Invoice dtoToModel (InvoiceDto invoiceDto);
}
