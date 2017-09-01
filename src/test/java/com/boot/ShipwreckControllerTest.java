package com.boot;

import com.boot.controller.ShipwreckController;
import com.boot.model.Shipwreck;
import com.boot.repository.ShipwreckRepository;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.junit.Before;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.*;
import org.mockito.MockitoAnnotations;

import static org.junit.Assert.assertEquals;


/**
 * Created by Prabhas_Harlapur on 8/31/2017.
 */
public class ShipwreckControllerTest {

    @InjectMocks
    private ShipwreckController shipwreckController;

    @Mock
    private ShipwreckRepository shipwreckRepository;

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }


    @Test
    public void testShipwreckGet() {

        //Wrong Way
//        ShipwreckController sc = new ShipwreckController();
//        Shipwreck wreck = shipwreckController.get(1L);
//        assertEquals(1L,wreck.getId().longValue());


        //Right Way
        Shipwreck shipwreck = new Shipwreck();
        shipwreck.setId(1L);
        when(shipwreckRepository.findOne(1L)).thenReturn(shipwreck);

        Shipwreck wreck = shipwreckController.get(1L);


        verify(shipwreckRepository).findOne(1L);
        //assertEquals(1L,wreck.getId().longValue());

        assertThat(wreck.getId(),is(1L));

    }
}
