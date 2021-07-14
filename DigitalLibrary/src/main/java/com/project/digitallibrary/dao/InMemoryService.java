package com.project.digitallibrary.dao;

import com.project.digitallibrary.dto.Asset;
import com.project.digitallibrary.dto.AssetInfo;
import com.project.digitallibrary.dto.ConfigDetails;
import com.project.digitallibrary.response.Response;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class InMemoryService implements DbService{
    private static List<Asset> libraryAsset = new ArrayList<>();
    private static int count =1 ;
    static {
        Map<String, String> prop = new HashMap<>();
         prop.put("test", "asdf");
        libraryAsset.add(new Asset(1,"DevelopmentBoard","microprocessordBoard", 1, "RPI", "Rack12", new AssetInfo(true), new ConfigDetails()));
    }

    public Response save(Asset lib){
        if(lib.getId()== null){
              lib.setId(++count);
        }
        libraryAsset.add(lib);
        for (Asset asset: libraryAsset){
        }
        return new Response(count, "created");
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
