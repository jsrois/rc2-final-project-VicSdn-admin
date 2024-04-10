package org.cangascup.backend.controllers;

import org.cangascup.backend.models.Analitycs;
import org.cangascup.backend.services.AnalitycsService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class AnalitycsControllerTest {

    @Mock
    private AnalitycsService analitycsService;

    @InjectMocks
    private AnalitycsController analitycsController;

    @Before
    public void setUp() {
    }

    @Test
    public void testGetAllAnalitycs() {
        List<Analitycs> mockAnalitycs = Arrays.asList(new Analitycs(), new Analitycs());
        when(analitycsService.getAllAnalitycs()).thenReturn(mockAnalitycs);
        List<Analitycs> result = analitycsController.getAllAnalitycs();
        assertEquals(2, result.size());
    }

    @Test
    public void testAddAnalitycs() {
        Analitycs analitycs = new Analitycs();
        when(analitycsService.addAnalitycs(analitycs)).thenReturn(analitycs);
        Analitycs result = analitycsController.addAnalitycs(analitycs);
        assertEquals(analitycs, result);
    }

    @Test
    public void testEditAnalitycs() {
        int id = 1;
        Analitycs analitycs = new Analitycs();
        when(analitycsService.editAnalitycs(id, analitycs)).thenReturn(analitycs);
        Analitycs result = analitycsController.editAnalitycs(id, analitycs);
        assertEquals(analitycs, result);
    }

    @Test
    public void testDeleteAnalitycs() {
        analitycsController.deleteAnalitycs(1);
        verify(analitycsService, times(1)).deleteAnalitycs(1);
    }
}
