package com.project.digitallibrary.dao;

import com.project.digitallibrary.dto.Asset;
import com.project.digitallibrary.response.Response;

import java.util.List;

public interface DbService {

    public Response save(Asset asset);

    public Asset findOne(int id);

    public List<Asset> findAll();

    public List<Asset> findMany(Asset asset);

}
