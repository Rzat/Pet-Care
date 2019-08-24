package com.springframework.petcare.services.springdatajpa;

import com.springframework.petcare.model.Owner;
import com.springframework.petcare.repositories.OwnerRepository;
import com.springframework.petcare.repositories.PetRepository;
import com.springframework.petcare.repositories.PetTypeRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class OwnerSDJpaServiceTest {

    @Mock
    OwnerRepository ownerRepository;
    @Mock
    PetRepository petRepository;
    @Mock
    PetTypeRepository petTypeRepository;

    @InjectMocks
    OwnerSDJpaService ownerSDJpaService;

    final String lastName = "Roman Reigns";

    Owner returnOwner;

    @BeforeEach
    void setUp() {
        //given
        returnOwner = Owner.builder().id(1L).lastName(lastName).build();
    }

    @Test
    void findByLastName() {
        //when                                      //then
        when(ownerRepository.findByLastName(any())).thenReturn(returnOwner);

        Owner lastNameOwner = ownerSDJpaService.findByLastName(lastName);
        assertEquals(lastName, lastNameOwner.getLastName());
    }

    @Test
    void findAll() {
        //given
        Set<Owner> returnedOwner = new HashSet<>();
        returnedOwner.add(Owner.builder().id(2L).build());
        returnedOwner.add(Owner.builder().id(3L).build());

        //when                              //then
        when(ownerRepository.findAll()).thenReturn(returnedOwner);

        Set<Owner> owners = ownerSDJpaService.findAll();
        assertNotNull(owners);
        assertEquals(2, owners.size());
    }

    @Test
    void findById() {
        when(ownerRepository.findById(anyLong())).thenReturn(Optional.of(returnOwner));
        Owner owner = ownerSDJpaService.findById(1L);
        assertNotNull(owner);
    }

    @Test
    void save() {
        //given
        Owner ownerSave = Owner.builder().id(4L).lastName(lastName).build();

        //when                              //then
        when(ownerRepository.save(any())).thenReturn(ownerSave);

        Owner owner = ownerSDJpaService.save(ownerSave);
        assertNotNull(owner);
        verify(ownerRepository).save(any());

    }

    @Test
    void deleteById() {
        ownerSDJpaService.deleteById(1L);
        //default is 1 time
        verify(ownerRepository,times(1)).deleteById(any());
    }

    @Test
    void delete() {
        ownerSDJpaService.delete(returnOwner);
        verify(ownerRepository).delete(any());
    }
}