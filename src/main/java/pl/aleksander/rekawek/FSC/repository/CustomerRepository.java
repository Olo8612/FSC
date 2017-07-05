package pl.aleksander.rekawek.FSC.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import pl.aleksander.rekawek.FSC.entity.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

}
