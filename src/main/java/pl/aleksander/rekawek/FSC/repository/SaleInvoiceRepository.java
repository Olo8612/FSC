package pl.aleksander.rekawek.FSC.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import pl.aleksander.rekawek.FSC.entity.SaleInvoice;

public interface SaleInvoiceRepository extends JpaRepository<SaleInvoice, Long> {

}
