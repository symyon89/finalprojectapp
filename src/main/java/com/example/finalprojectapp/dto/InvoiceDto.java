package com.example.finalprojectapp.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class InvoiceDto implements Serializable {
    @Schema(description = "id customer", example = "74478911-6424-47a7-911c-0daa262144fa")
    private UUID id;
    @Schema(description = "Customer object, if is null will not associated a customer")
    private CustomerDto customer;
    @Schema(description = "Product object list, if is null will not associated a product")
    private List<ProductDto> products;
    @Schema(description = "Invoice numbere, max length 30", example = "INV0000321")
    @Length(max = 30)
    private String invoiceNumber;

    @Schema(description = "date added modified",pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime dateAdded;

    @Schema(description = "last invoice date modified",pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime lastDateModified;
}
