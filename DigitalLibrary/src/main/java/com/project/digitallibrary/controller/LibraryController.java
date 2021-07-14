package com.project.digitallibrary.controller;

import com.project.digitallibrary.dao.InMemoryService;
import com.project.digitallibrary.dto.Asset;
import com.project.digitallibrary.exception.AssetNotFoundException;
import com.project.digitallibrary.response.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class LibraryController {

    @Autowired
    private InMemoryService service;

    @GetMapping("/v1/asset/{id}")
    public Asset retrieveAsset(@PathVariable int id){
        Asset asset = service.findOne(id);
        if (asset == null){
            throw new AssetNotFoundException("Given id doesn't exist");
        }
        return asset;
    }

    @PostMapping("/v1/asset")
    public Response saveAsset(@RequestBody Asset asset){
        return service.save(asset);

    }

    @GetMapping("/v1/asset")
    public List<Asset> getAllAsset() {
        return service.findAll();
    }
}
