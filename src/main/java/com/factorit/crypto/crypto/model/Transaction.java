package com.factorit.crypto.crypto.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
public class Transaction {

	@Id
	@SequenceGenerator(name = "seq_id_transaction", sequenceName = "seq_id_transaction")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_id_transaction")
	@Column(name = "id_transaction")
	private Long idTransaction;

	private String asset;

	private String exchange;

	@Column(name = "total_cost")
	private Double totalCost;

	private Double commission;

	@Column(name = "unit_price")
	private Double unitPrice;

	@Column(name = "unit_price_x_amount")
	private Double unitPriceXamount;

}
