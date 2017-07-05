package pl.aleksander.rekawek.FSC.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import pl.aleksander.rekawek.FSC.entity.InvoiceItem;

public interface InvoiceItemRepository extends JpaRepository<InvoiceItem, Long> {
	public List<InvoiceItem> findAllInvoiceItemsByInvoiceId(Long id);
}
