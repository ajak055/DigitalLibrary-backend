package com.project.digitallibrary.dao;

import com.project.digitallibrary.dto.Asset;
import com.project.digitallibrary.dto.AssetInfo;
import com.project.digitallibrary.dto.ConfigDetails;
import com.project.digitallibrary.exception.InvalidIdException;
import com.project.digitallibrary.exception.NoDataFoundException;
import com.project.digitallibrary.response.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class InMemoryService implements DbService{

    private static final Logger logger = LoggerFactory.getLogger(InMemoryService.class);

    private static List<Asset> libraryAsset = new ArrayList<>();

    private static int count =1 ;

    static {
        Map<String, Object> prop = new HashMap<>();
        prop.put("test", "asdf");
        libraryAsset.add(new Asset(1,"DevelopmentBoard","microprocessorBoard", 1, "RPI", "Rack12", new AssetInfo(true), prop));
    }

    public Response save(Asset lib){
        if(lib.getId()== null) {
            lib.setId(++count);

            libraryAsset.add(lib);

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

    public List<Asset> findMany(Asset qAsset) {
        try {
            List<Asset> resultAsset = new ArrayList<>();
            for (Asset asset : libraryAsset) {
                if (asset.getCategory().equals(qAsset.getCategory()) || asset.getName().equals(qAsset.getName()) || asset.getSubCategory().equals(qAsset.getSubCategory()) ||
                        asset.getLocation().equals(qAsset.getLocation()) || asset.getQuantity().equals(qAsset.getQuantity()))
                {
                    resultAsset.add(asset);
                }
            }
            if (resultAsset.isEmpty()) {
                throw new NoDataFoundException("Queried result not found");
            }
            return resultAsset;
        }catch (NullPointerException e){
            logger.error("error in findMany ", e);
            throw new NoDataFoundException("No data found");
        }
    }

    public Response delete(int id){
        for(Asset asset: libraryAsset){
            if(asset.getId()== id){
                libraryAsset.remove(asset);
                return new Response(id, "Asset deleted");
            }
        }
        return new Response(id, "Asset not available for deletion");
    }
}