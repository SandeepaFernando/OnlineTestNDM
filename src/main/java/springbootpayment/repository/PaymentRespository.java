package springbootpayment.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import springbootpayment.model.Payment;

public interface PaymentRespository extends JpaRepository<Payment, Long> {

}
