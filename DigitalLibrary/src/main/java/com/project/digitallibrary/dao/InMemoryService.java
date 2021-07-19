package com.project.digitallibrary.dao;

import com.project.digitallibrary.dto.Asset;
import com.project.digitallibrary.dto.AssetInfo;
import com.project.digitallibrary.dto.ConfigDetails;
import com.project.digitallibrary.exception.InvalidIdException;
import com.project.digitallibrary.response.Response;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class InMemoryService implements DbService{
    private static List<Asset> libraryAsset = new ArrayList<>();
    private static int count =1 ;
    static {
        Map<String, Object> prop = new HashMap<>();
        prop.put("test", "asdf");
        libraryAsset.add(new Asset(1,"DevelopmentBoard","microprocessorBoard", 1, "RPI", "Rack12", new AssetInfo(true), new ConfigDetails(prop)));
    }

    public Response save(Asset lib){
        if(lib.getId()== null) {
            lib.setId(++count);

            libraryAsset.add(lib);
            for (Asset asset : libraryAsset) {
            }
            return new Response(count, "created");
        }
        else{
            throw new InvalidIdException("Invalid Id");
        }
    }

    public Asset findOne(int id){
        for(Asset asset: libraryAsset){
            if(asset.getId()== id){
                return asset;
            }
        }
        return null;
    }

    public List<Asset> findAll(){
        return libraryAsset;
    }

}
