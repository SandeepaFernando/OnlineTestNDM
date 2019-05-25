package springbootpayment.dao;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;

import springbootpayment.model.Payment;
import springbootpayment.repository.PaymentRespository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired; 

@Service
public class PaymentDAO {
	@Autowired
	PaymentRespository paymentRespository;
	
	//save a payment
	@Transactional(readOnly = false,isolation = Isolation.READ_COMMITTED)
	public Payment save(Payment payment) {
		return paymentRespository.save(payment);
	}
	
	//get all Payments
	public List<Payment>findAll(){
		return paymentRespository.findAll();
	}
	
	//get payment by id
	public Payment findOne(Long payment_id) {
		Optional<Payment> pay = paymentRespository.findById(payment_id);
		if(pay.isPresent()) {
			return pay.get();
		}
		else {
			return null;
		}
		
	}
	
	//delete a payment
	@Transactional(readOnly = false,isolation = Isolation.READ_COMMITTED)
	public void delete(Long payment_id) {
		paymentRespository.deleteById(payment_id);
	}
	
	

}
