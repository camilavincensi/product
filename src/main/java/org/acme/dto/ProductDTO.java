package org.acme.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.jackson.Jacksonized;

import java.math.BigDecimal;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Jacksonized //eese objeto pode ser representado por um json
public class ProductDTO { //objeto de transferencia de dados, serve para trsnaferir o objeto criado de uma classe para outra

    private Long id;
    private String name;
    private String description;
    private String category;
    private String model;
    private BigDecimal price;
}
