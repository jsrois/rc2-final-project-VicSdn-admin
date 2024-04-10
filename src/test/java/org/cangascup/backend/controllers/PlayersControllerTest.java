package org.cangascup.backend.controllers;

import org.cangascup.backend.models.Players;
import org.cangascup.backend.services.PlayersService;
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
public class PlayersControllerTest {

    @Mock
    private PlayersService playersService;

    @InjectMocks
    private PlayersController playersController;

    @Before
    public void setUp() {
    }

    @Test
    public void testGetAllPlayers() {
        List<Players> mockPlayers = Arrays.asList(new Players(), new Players());
        when(playersService.getAllPlayers()).thenReturn(mockPlayers);
        List<Players> result = playersController.getAllPlayers();
        assertEquals(2, result.size());
    }

    @Test
    public void testAddPlayer() {
        Players player = new Players();
        when(playersService.addPlayer(player)).thenReturn(player);
        Players result = playersController.addPlayer(player);
        assertEquals(player, result);
    }

    @Test
    public void testEditPlayer() {
        int id = 1;
        Players playerDetails = new Players();
        when(playersService.editPlayer(id, playerDetails)).thenReturn(playerDetails);
        Players result = playersController.editPlayer(id, playerDetails);
        assertEquals(playerDetails, result);
    }

    @Test
    public void testDeletePlayer() {
        int id = 1;
        playersController.deletePlayer(id);
        verify(playersService, times(1)).deletePlayer(id);
    }

    @Test
    public void testSearchPlayersByName() {
        String name = "John";
        List<Players> mockPlayers = Arrays.asList(new Players(), new Players());
        when(playersService.searchPlayersByName(name)).thenReturn(mockPlayers);
        List<Players> result = playersController.searchPlayersByName(name);
        assertEquals(2, result.size());
    }
}
