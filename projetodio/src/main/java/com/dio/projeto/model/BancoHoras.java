package com.dio.projeto.model;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Builder
@Entity
public class BancoHoras {

    @AllArgsConstructor
    @NoArgsConstructor
    @EqualsAndHashCode
    @Embeddable
    public class BancoHoradId implements Serializable{
        private Long idBancoHoras;
        private Long idMovimento ;
        private Long idUsuario;
    }

    @Id
    @EmbeddedId
    private BancoHoradId id;
    private LocalDateTime dataTrabalhada;
    private BigDecimal quantidadeTrabalhadas;
    private BigDecimal saldoHoras;



}
