package guru.springframework.sfgpetclinic.services.springdatajpa;

import guru.springframework.sfgpetclinic.model.Specialty;
import guru.springframework.sfgpetclinic.repositories.SpecialtyReposiotry;
import guru.springframework.sfgpetclinic.services.SpecialtyService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
@Profile("springdatajpa")
public class SpecialtySDJpaService implements SpecialtyService {
    private final SpecialtyReposiotry specialtyReposiotry;

    public SpecialtySDJpaService(SpecialtyReposiotry specialtyReposiotry) {
        this.specialtyReposiotry = specialtyReposiotry;
    }

    @Override
    public Set<Specialty> findAll() {
        Set<Specialty> specialties = new HashSet<>();
        specialtyReposiotry.findAll().forEach(specialties::add);
        return specialties;
    }

    @Override
    public Specialty findById(Long aLong) {
        return specialtyReposiotry.findById(aLong).orElse(null);
    }

    @Override
    public Specialty save(Specialty object) {
        return specialtyReposiotry.save(object);
    }

    @Override
    public void delete(Specialty object) {
        specialtyReposiotry.delete(object);
    }

    @Override
    public void deleteById(Long aLong) {
        specialtyReposiotry.deleteById(aLong);
    }
}
