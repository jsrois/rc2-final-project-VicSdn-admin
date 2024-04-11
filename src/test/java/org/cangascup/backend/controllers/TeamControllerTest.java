package org.cangascup.backend.controllers;

import org.cangascup.backend.models.Team;
import org.cangascup.backend.services.TeamsService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class TeamControllerTest {

    @Mock
    private TeamsService teamsService;

    @InjectMocks
    private TeamsController teamsController;

    @Before
    public void setUp() {

    }

    @Test
    public void testGetAllTeams() {
        List<Team> mockTeams = Arrays.asList(new Team(), new Team());
        when(teamsService.getAllTeams()).thenReturn(mockTeams);

        List<Team> result = teamsController.getAllTeams();

        assertEquals(2, result.size());
    }

    @Test
    public void testGetTeamsByGroup() {
        Map<Integer, List<Team>> mockMap = new HashMap<>();
        when(teamsService.getTeamsByGroup_id()).thenReturn(mockMap);

        Map<Integer, List<Team>> result = teamsController.getTeamsByGroup();

        assertEquals(mockMap, result);
    }

    @Test
    public void testGetTeamsByLocation() {
        Map<String, List<Team>> mockMap = new HashMap<>();
        when(teamsService.getTeamsByLocation()).thenReturn(mockMap);

        Map<String, List<Team>> result = teamsController.getTeamsByLocation();

        assertEquals(mockMap, result);
    }

    @Test
    public void testAddTeam() {
        Team team = new Team();
        when(teamsService.addTeam(team)).thenReturn(team);

        ResponseEntity<Team> responseEntity = teamsController.addTeam(team);

        assertEquals(HttpStatus.CREATED, responseEntity.getStatusCode());
        assertEquals(team, responseEntity.getBody());
    }

    @Test
    public void testDeleteTeam() {
        ResponseEntity<Void> responseEntity = teamsController.deleteTeam(1);

        assertEquals(HttpStatus.NO_CONTENT, responseEntity.getStatusCode());
    }

    @Test
    public void testUpdateTeam() {
        Team team = new Team();
        when(teamsService.updateTeam(1, team)).thenReturn(team);

        ResponseEntity<Team> responseEntity = teamsController.updateTeam(1, team);

        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals(team, responseEntity.getBody());
    }
}
