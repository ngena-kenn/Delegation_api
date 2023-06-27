package fr.sacem.api.controller;


import fr.sacem.api.model.DelegationsSaref;
import fr.sacem.api.service.DelegationsService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Api(tags = "delegations")
@RestController
public class DelegationsController {

    @Autowired
    private DelegationsService delegationsService;

    @ApiOperation(value = "liste des delegations", tags = "delegations")
    @GetMapping("/delegations")
    public List<DelegationsSaref> getDelegations(){
        List<DelegationsSaref> delegationsSarefs = delegationsService.getDelegation();

        return delegationsSarefs;

    }
    @ApiOperation(value = "telecharger la liste des delegations au format json", tags = "delegations")
    @GetMapping("/downloadDelegations")
    public ResponseEntity downloadFile(){
        List<DelegationsSaref> delegations = delegationsService.getDelegation();

        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment;filename=alimentation-delegations.json" )
                .contentType(MediaType.APPLICATION_JSON)
                .body(delegations);

    }


}