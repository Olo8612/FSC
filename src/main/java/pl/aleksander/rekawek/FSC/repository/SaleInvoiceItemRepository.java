package pl.aleksander.rekawek.FSC.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import pl.aleksander.rekawek.FSC.entity.SaleInvoiceItem;

public interface SaleInvoiceItemRepository extends JpaRepository<SaleInvoiceItem, Long> {
	public List<SaleInvoiceItem> findAllSaleInvoiceItemsBySaleInvoiceId(Long id);
}
