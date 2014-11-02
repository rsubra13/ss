package edu.irabank.form;
/**
 * @author Rakesh Subramanian
 *
 */

public class InternalTransactionFormBean {
	private String to_account;
	private String from_account;
	private Double amount;

	public String getFrom_account() {
		return from_account;
	}

	public void setFrom_account(String from_account) {
		this.from_account = from_account;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public String getTo_account() {
		return to_account;
	}

	public void setTo_account(String to_account) {
		this.to_account = to_account;
	}
	

}
