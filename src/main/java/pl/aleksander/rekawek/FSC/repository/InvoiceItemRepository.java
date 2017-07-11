package pl.aleksander.rekawek.FSC.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import pl.aleksander.rekawek.FSC.entity.InvoiceItem;

public interface InvoiceItemRepository extends JpaRepository<InvoiceItem, Long> {
	public List<InvoiceItem> findAllInvoiceItemsByInvoiceId(Long id);

	@Query(value = "SELECT * FROM invoiceItems WHERE description LIKE '%tarcica%' and woodType LIKE '%sosna%' and invoice_id = ?1", nativeQuery = true)
	public List<InvoiceItem> findInvoiceItemPlainWood(Long id);

	@Query(value = "SELECT * FROM invoiceItems WHERE description LIKE '%gałęzie%' and woodType Like '%sosna%' and invoice_id = ?1", nativeQuery = true)
	public List<InvoiceItem> findInvoiceItemTreePiece(Long id);
}
