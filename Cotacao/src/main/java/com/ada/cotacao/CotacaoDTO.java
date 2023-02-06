package com.ada.cotacao;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Date;

@Getter
@Setter
public class CotacaoDTO {
    //request body = tipo_moeda
    private String code;
    //request body = valor_cotacao
    private BigDecimal ask;
    //request body = dataSolicitacao
    private Date create_date;

    public CotacaoDTO(String code, BigDecimal ask, Date create_date){
        this.code = code;
        this.ask = ask;
        this.create_date = create_date;

    }
}
