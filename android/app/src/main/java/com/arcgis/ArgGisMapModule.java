package com.arcgis;

import android.util.Log;
import android.view.View;

import androidx.annotation.NonNull;

import com.esri.android.map.MapView;
import com.esri.core.geometry.GeometryEngine;
import com.esri.core.geometry.Point;
import com.esri.core.geometry.SpatialReference;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.uimanager.SimpleViewManager;
import com.facebook.react.uimanager.ThemedReactContext;

public class ArgGisMapModule extends ReactContextBaseJavaModule {
    private static ReactApplicationContext reactContext;
    MapView mapView;
    ArgGisMapModule(ReactApplicationContext context){
//        super(context);
        reactContext = context;
    }
    @NonNull
    @Override
    public String getName() {
        return "ArgGisMapModule";
    }



    public void setMapView(MapView mapView) {
        this.mapView = mapView;
    }

//    @ReactMethod
//    public void setLevel(float level) {
//        Log.v("ArgGisMapModule", "set level: " + level);
//        // TODO: centerAndZoom is acting as if level was a factor even when the basemap is a TiledLayer
//        // see https://developers.arcgis.com/android/api-reference/reference/com/esri/android/map/MapView.html#centerAndZoom(double,%20double,%20float)
//        if (mapView != null && mapView.getCenter() != null) {
//            mapView.centerAndZoom(
//                    mapView.getCenter().getX(),
//                    mapView.getCenter().getY(),
//                    level
//            );
//        }
//    }

//    @ReactMethod
//    public void setCenterWGS84(float x, float y) {
//        Log.v("ArgGisMapModule", "set center: " + x + ", " + y);
//
//        if (mapView != null) {
//            Point pointWgs = new Point(x, y);
//            Point pointMap = (Point) GeometryEngine.project(
//                    pointWgs,
//                    SpatialReference.create(4326),
//                    mapView.getSpatialReference()
//            );
//            mapView.centerAt(pointMap, true);
//        }
//    }
}
