package com.kocirfan.product.domain;

public enum MoneyTypes {

        USD("Dolar", "$"),
        EUR("Euro", "E"),
        TL("Turk Lirası", "T");

        private String label; // dolar
        private String symbol; //$

        MoneyTypes(String label, String symbol){
            this.label = label;
            this.symbol = symbol;
        }
}


