package com.example.finalprojectapp.mapper;

import com.example.finalprojectapp.dto.InvoiceQuantityDto;
import com.example.finalprojectapp.model.InvoiceQuantity;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface InvoiceQuantityMapper {
    InvoiceQuantityDto modelToDto (InvoiceQuantity invoiceQuantity);
    List<InvoiceQuantityDto> modelToDtos(List<InvoiceQuantity> invoiceQuantities);
    InvoiceQuantity dtoToModel (InvoiceQuantityDto invoiceQuantityDto);
}
