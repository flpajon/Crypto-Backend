package com.factorit.crypto.crypto.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class TransactionDTO {
	private String asset;
	private String exchange;
	private Double totalCost;
	private Double commission;
	private Double unitPrice;
	private Double unitPriceXamount;
	private String user;
}
