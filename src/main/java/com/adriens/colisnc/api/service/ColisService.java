/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.adriens.colisnc.api.service;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;

import com.adriens.colisnc.api.model.StepsCounter;
import com.adriens.github.colisnc.colisnc.ColisCrawler;
import com.adriens.github.colisnc.colisnc.ColisDataRow;
/**
 *
 * @author 3004SAL
 */

@ApplicationScoped
public class ColisService {
    
    public List<ColisDataRow> getColisRows(String itemId) throws Exception {
        return ColisCrawler.getColisRows(itemId);
    }
    
    public ColisDataRow getLatestRow(String itemId) throws Exception {
        return ColisCrawler.getLatest(itemId);
    }
    public ColisDataRow getOldestRow(String itemId) throws Exception {
        return ColisCrawler.getOldest(itemId);
    }
    
    public StepsCounter getNbSteps(String itemId) throws Exception {
        return new StepsCounter(ColisCrawler.getColisRows(itemId).size());
    }

    public List<ColisDataRow> getLatestStatusForColisList(List<String> itemsId) throws Exception {
        return ColisCrawler.getLatestStatusForColisList(itemsId);
    }

}
