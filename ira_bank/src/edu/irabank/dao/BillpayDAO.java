package edu.irabank.dao;

import java.util.List;





import edu.irabank.dto.BillPayDTO;
import edu.irabank.dto.RequestDetailsDTO;



public interface BillpayDAO {
	
	
	Boolean BillpaySave(BillPayDTO billpayDTO);
	public List<BillPayDTO> showbillpayInfo();
	boolean Billpayupdatestatus(Integer billlid, String status);
	boolean BillpayMerchantupdatekey(Integer billid, String merchanthashedkey);
	boolean Billpayupdatekey(Integer billlid, String hashedkey);
	String gethashedKey(Integer billId);
	String getmerchanthashedKey(Integer billId);

}
