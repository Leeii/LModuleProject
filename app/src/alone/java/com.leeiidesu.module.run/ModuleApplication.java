package com.leeiidesu.module.run;

import com.leeiidesu.lib.component.ComponentApplication;
import com.leeiidesu.module.template.BuildConfig;

/**
 * Created by iilee on 2018/5/8.
 */

public class ModuleApplication extends ComponentApplication {
    @Override
    protected String getGlobalBaseUrl() {
        return BuildConfig.MODULE_HOST;
    }
}
