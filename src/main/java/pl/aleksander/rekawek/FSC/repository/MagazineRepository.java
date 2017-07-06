package pl.aleksander.rekawek.FSC.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import pl.aleksander.rekawek.FSC.entity.Magazine;

public interface MagazineRepository extends JpaRepository<Magazine, Long> {

}
