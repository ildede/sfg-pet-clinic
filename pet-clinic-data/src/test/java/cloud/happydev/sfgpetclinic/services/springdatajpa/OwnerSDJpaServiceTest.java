package cloud.happydev.sfgpetclinic.services.springdatajpa;

import cloud.happydev.sfgpetclinic.model.Owner;
import cloud.happydev.sfgpetclinic.repositories.OwnerRepository;
import cloud.happydev.sfgpetclinic.repositories.PetRepository;
import cloud.happydev.sfgpetclinic.repositories.PetTypeRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class OwnerSDJpaServiceTest {

    public static final String LAST_NAME = "Smith";
    public static final long OWNER_ID = 1L;
    @Mock
    OwnerRepository ownerRepository;

    @Mock
    PetRepository petRepository;

    @Mock
    PetTypeRepository petTypeRepository;

    @InjectMocks
    OwnerSDJpaService service;

    @BeforeEach
    void setUp() {
    }

    @Test
    void findByLastName() {
        Owner returnOwner = Owner.builder().id(OWNER_ID).lastName(LAST_NAME).build();
        when(service.findByLastName(any())).thenReturn(returnOwner);

        Owner owner = service.findByLastName(LAST_NAME);

        assertEquals(LAST_NAME, owner.getLastName());
        verify(ownerRepository).findByLastName(any());
    }

    @Test
    void findAll() {
        Set<Owner> returnOwnersSet = Set.of(Owner.builder().id(1L).build(), Owner.builder().id(2L).build());
        when(ownerRepository.findAll()).thenReturn(returnOwnersSet);

        Set<Owner> owners = service.findAll();

        assertNotNull(owners);
        assertEquals(2, owners.size());
    }

    @Test
    void findById() {
        Owner returnOwner = Owner.builder().id(OWNER_ID).lastName(LAST_NAME).build();
        when(ownerRepository.findById(anyLong())).thenReturn(Optional.of(returnOwner));

        Owner owner = service.findById(OWNER_ID);

        assertNotNull(owner);
    }

    @Test
    void findByIdNotFount() {
        when(ownerRepository.findById(anyLong())).thenReturn(Optional.empty());

        Owner owner = service.findById(OWNER_ID);

        assertNull(owner);
    }

    @Test
    void save() {
        Owner returnOwner = Owner.builder().id(OWNER_ID).lastName(LAST_NAME).build();
        when(ownerRepository.save(any())).thenReturn(returnOwner);

        Owner ownerToSave = Owner.builder().id(OWNER_ID).build();
        Owner savedOwner = service.save(ownerToSave);

        assertNotNull(savedOwner);
    }

    @Test
    void delete() {
        Owner returnOwner = Owner.builder().id(OWNER_ID).lastName(LAST_NAME).build();
        service.delete(returnOwner);

        verify(ownerRepository).delete(any());
    }

    @Test
    void deleteById() {
        service.deleteById(OWNER_ID);

        verify(ownerRepository).deleteById(anyLong());
    }
}