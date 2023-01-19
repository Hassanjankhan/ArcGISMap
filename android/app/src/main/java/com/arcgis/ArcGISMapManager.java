package com.arcgis;

import android.util.Log;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;


import com.esri.android.map.MapView;
import com.esri.android.map.ags.ArcGISFeatureLayer;
import com.esri.android.map.ags.ArcGISTiledMapServiceLayer;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.uimanager.SimpleViewManager;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.annotations.ReactProp;

public class ArcGISMapManager extends SimpleViewManager<MapView>
{
    public static final String REACT_CLASS = "ArcGISMap";

    private MapView mapView;
    private ArgGisMapModule arcGISMapModule;
    private static final String DEFAULT_LAYER = "http://services.arcgisonline.com/ArcGIS/rest/services/World_Street_Map/MapServer";

    @NonNull
    @Override
    public String getName() {
        return REACT_CLASS;
    }
    public ArcGISMapManager(ArgGisMapModule arcGISMapModule) {
        this.arcGISMapModule = arcGISMapModule;
    }

    @NonNull
    @Override
    protected MapView createViewInstance(@NonNull ThemedReactContext themedReactContext) {
        Log.v(REACT_CLASS, "createViewInstance");

        mapView = new MapView(themedReactContext);

        // Give the module a reference to MapView
        arcGISMapModule.setMapView(mapView);

        return mapView;
    }

    @ReactProp(name = "layers")
    public void setLayers(MapView view, @Nullable ReadableArray layers) {
        Log.v(REACT_CLASS, "set layers");

        if (layers == null || layers.size() < 1) {
            Log.v(REACT_CLASS, "set layers: adding default layer");
            mapView.addLayer(new ArcGISTiledMapServiceLayer(DEFAULT_LAYER));
        } else {
            mapView.removeAll();
            for (int i = 0; i < layers.size(); i++) {
                ReadableMap layer = layers.getMap(i);
                String type = layer.getString("type");
                String url = layer.getString("url");

                if (!url.equals("")) {
                    if (type.equals("ArcGISTiledMapServiceLayer")) {
                        Log.v(REACT_CLASS, "set layers: adding ArcGISTiledMapServiceLayer:" + url);
                        mapView.addLayer(new ArcGISTiledMapServiceLayer(url));
                    } else if (type.equals("ArcGISFeatureLayer")) {
                        Log.v(REACT_CLASS, "set layers: adding ArcGISFeatureLayer:" + url);
                        mapView.addLayer(new ArcGISFeatureLayer(url, ArcGISFeatureLayer.MODE.SNAPSHOT));
                    } else {
                        Log.v(REACT_CLASS, "set layers: unrecognized layer: " + type);
                    }
                } else {
                    Log.v(REACT_CLASS, "set layers: invalid url:" + url);
                }
            }
        }
    }

}
