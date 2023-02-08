package com.ada.cotacao;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class CotacaoEconomiaDTO {
    //[{"code":"USD","codein":"BRL","name":"Dólar Americano/Real Brasileiro",
    // "high":"5.2106","low":"5.2106","varBid":"0.0005","pctChange":"0.01",
    // "bid":"5.2101","ask":"5.2111","timestamp":"1675832477",
    // "create_date":"2023-02-08 02:01:17"}]
    private String code;
    private String codein;
    private String name;
    private Double high;
    private Double low;
    private Double varBid;
    private Double pctChange;
    private Double bid;
//    private Double ask;
    private BigDecimal ask;
    private String timestamp;
    private String create_date;

    public CotacaoEconomiaDTO() {
    }

    public CotacaoEconomiaDTO(String code, String codein, String name, Double high, Double low, Double varBid, Double pctChange, Double bid, BigDecimal ask, String timestamp, String create_date) {
        this.code = code;
        this.codein = codein;
        this.name = name;
        this.high = high;
        this.low = low;
        this.varBid = varBid;
        this.pctChange = pctChange;
        this.bid = bid;
        this.ask = ask;
        this.timestamp = timestamp;
        this.create_date = create_date;
    }

}
