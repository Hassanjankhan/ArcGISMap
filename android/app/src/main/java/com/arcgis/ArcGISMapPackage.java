package com.arcgis;

import android.util.Log;

import androidx.annotation.NonNull;

import com.facebook.react.ReactPackage;
import com.facebook.react.bridge.NativeModule;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.uimanager.ViewManager;

import java.util.ArrayList;
import java.util.Arrays;

import java.util.List;

public class ArcGISMapPackage implements ReactPackage {
    private ArgGisMapModule arcGISMapModule;
    @NonNull
    @Override
    public List<NativeModule> createNativeModules(@NonNull ReactApplicationContext reactApplicationContext) {
        Log.v("ArcGISMapPackage", "createNativeModules");
        List<NativeModule> modules = new ArrayList<>();
        modules.add(new ArgGisMapModule(reactApplicationContext));
        Log.v("ArcGISMapPackage", "test");
        return modules;
    }

//    public List<Class<? extends JavaScriptModule>> createJSModules() {
//        return Collections.emptyList();
//    }
    @NonNull
    @Override
    public List<ViewManager> createViewManagers(@NonNull ReactApplicationContext reactApplicationContext) {
        Log.v("createViewManagers", "createNativeModules");
        // Create the module now as createViewManagers is called before createNativeModules
        arcGISMapModule = new ArgGisMapModule(reactApplicationContext);
        Log.v("createViewManagers", "createNativeModulescreateNativeModules");

        return Arrays.<ViewManager>asList(
                new ArcGISMapManager(arcGISMapModule)
        );
//        return Collections.emptyList();
    }

}
