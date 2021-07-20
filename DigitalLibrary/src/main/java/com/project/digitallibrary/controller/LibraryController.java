package com.project.digitallibrary.controller;

import com.project.digitallibrary.dao.InMemoryService;
import com.project.digitallibrary.dto.Asset;
import com.project.digitallibrary.exception.AssetNotFoundException;
import com.project.digitallibrary.response.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1")
public class LibraryController {

    @Autowired
    private InMemoryService service;

    @GetMapping("/asset/{id}")
    public Asset retrieveAsset(@PathVariable int id){
        Asset asset = service.findOne(id);
        if (asset == null){
            throw new AssetNotFoundException("Given id doesn't exist");
        }
        return asset;
    }

    @PostMapping("/asset")
    public Response saveAsset(@RequestBody Asset asset){
        return service.save(asset);

    }

    @GetMapping("/asset")
    public List<Asset> getAllAsset() {
        return service.findAll();
    }

    @PostMapping("/asset/list")
    public List<Asset> queryAsset(@RequestBody Asset asset){
        return service.findMany(asset);
    }

    @DeleteMapping("/asset/{id}")
    public Response deleteAsset(@PathVariable int id){
        return service.delete(id);
    }
}
