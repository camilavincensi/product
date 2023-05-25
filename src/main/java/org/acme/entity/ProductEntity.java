package org.acme.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;


@Entity
@Table(name = "product")
@Data
@AllArgsConstructor
@NoArgsConstructor

public class ProductEntity { //essa classe é a representação de uma tabela do banco de dados

    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String description;
    private String category;
    private String model;
    private BigDecimal price;

}
