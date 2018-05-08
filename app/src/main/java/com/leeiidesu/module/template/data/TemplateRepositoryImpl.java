package com.leeiidesu.module.template.data;


import com.leeiidesu.module.template.data.api.APIService;
import com.leeiidesu.module.template.domain.TemplateRepository;

/**
 * Created by dgg on 2017/11/6.
 */

public class TemplateRepositoryImpl implements TemplateRepository {
    private APIService apiService;

    public TemplateRepositoryImpl(APIService apiService) {

        this.apiService = apiService;
    }
}
