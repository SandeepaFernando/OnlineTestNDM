package springbootpayment.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import springbootpayment.dao.PaymentDAO;
import springbootpayment.model.Payment;

@RestController
public class PaymentController {
	
	@Autowired
	PaymentDAO paymentDAO;
	
	//save a payment
	@PostMapping("/payments")
	public Payment createPayemnt(@Valid @RequestBody Payment pay) {
		return paymentDAO.save(pay);
	}
	
	//get all payments
	@GetMapping("/payments")
	public List<Payment> getAllPayments(){
		return paymentDAO.findAll();
		
	}
	
	//get payment by id
	@GetMapping("/payments/{payment_id}")
	public ResponseEntity<Payment> getPaymentById(@PathVariable(value="payment_id") Long payment_id){ 
		Payment pay = paymentDAO.findOne(payment_id);
		
		if(pay == null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok().body(pay);
	}
	
	//update payment by id
	@PutMapping("/payments/{payment_id}")
	public ResponseEntity<Payment> updatePayment(@PathVariable(value="payment_id") Long payment_id, @Valid @RequestBody Payment payDetails){ 
		Payment pay = paymentDAO.findOne(payment_id);
		if(pay == null) {
			return ResponseEntity.notFound().build();
		}
		pay.setUser_id(payDetails.getUser_id());
		pay.setFullAmount(payDetails.getFullAmount());
		pay.setDate(payDetails.getDate());
		pay.setOrder_id(payDetails.getOrder_id());
		pay.setPayment_id(payDetails.getPayment_id());
		
		Payment upPayment = paymentDAO.save(pay);
		
		return ResponseEntity.ok().body(upPayment);
		
	}
	
	//delete an payment
	@DeleteMapping("/payments/{payment_id}")
	public ResponseEntity<Payment> deletePayment(@PathVariable(value="payment_id") Long payment_id){
		Payment pay = paymentDAO.findOne(payment_id);
		if(pay == null) {
			return ResponseEntity.notFound().build();
		}
		paymentDAO.delete(payment_id);
		return ResponseEntity.ok().build();
		
	}
	
}
