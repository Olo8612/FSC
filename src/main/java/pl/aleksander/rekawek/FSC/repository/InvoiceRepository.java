package pl.aleksander.rekawek.FSC.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import pl.aleksander.rekawek.FSC.entity.Invoice;

public interface InvoiceRepository extends JpaRepository<Invoice, Long> {

}
