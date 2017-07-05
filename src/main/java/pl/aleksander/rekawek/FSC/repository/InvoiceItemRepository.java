package pl.aleksander.rekawek.FSC.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import pl.aleksander.rekawek.FSC.entity.InvoiceItem;

public interface InvoiceItemRepository extends JpaRepository<InvoiceItem, Long> {

}
