/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.adriens.colisnc.api.controller;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.adriens.colisnc.api.model.StepsCounter;
import com.adriens.colisnc.api.service.ColisService;
import com.adriens.github.colisnc.colisnc.ColisDataRow;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author 3004SAL
 */
@Path("/colis")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ColisController {
    
    @Inject
    private ColisService colisService;
    
    private final Logger log = LoggerFactory.getLogger(ColisController.class);
    
    @GET
    @Path("/{itemId}")
    public List<ColisDataRow> getColisRows(@PathParam("itemId") String itemId) throws Exception {
        try{
            System.out.println("x");
            return colisService.getColisRows(itemId);
        }
        catch(Exception ex){
            log.error("Impossible de récupérer les détails du colis <"+ itemId + ">");
            throw ex;
        }
    }
    
    @GET
    @Path("/{itemId}/latest")
    public ColisDataRow getLatest(@PathParam("itemId") String itemId) throws Exception {
        try{
            return colisService.getLatestRow(itemId);
        }
        catch(Exception ex){
            log.error("Impossible de récupérer les derniers détails du colis <"+ itemId + ">");
            throw ex;
        }
    }
    
    
    @GET
    @Path("/{itemId}/count")
    public StepsCounter getNbSteps(@PathParam("itemId") String itemId) throws Exception {
        try{
            return colisService.getNbSteps(itemId);
        }
        catch(Exception ex){
            log.error("Impossible de récupérer les derniers détails du colis <"+ itemId + ">");
            throw ex;
        }
    }

    @POST
    @Path("/list/latest")
    public List<ColisDataRow> getLastStatusFromColisList(List<String> itemsId) throws Exception {
        try{
            return colisService.getLatestStatusForColisList(itemsId);
        }
        catch(Exception ex){
            log.error("Impossible de récupérer les derniers états pour les colis de la liste : <"+ itemsId.toString() + ">");
            throw ex;
        }
    }
    

}
