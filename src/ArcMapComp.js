import React, {
    View,
    StyleSheet,
    requireNativeComponent,
} from 'react-native';
var LAYERS = [
    {
        type: 'ArcGISTiledMapService',
        url: 'https://services.gisqatar.org.qa/server/rest/services/Vector/Qatar_StreetMap_Hybrid_E/MapServer'
    },
];
const ArcGISMap = requireNativeComponent("ArcGISMap");

const ArcMapComp = () => {
    return (
        <View >
            <ArcGISMap
                // only implemented on Android
                layers={LAYERS}
                style={styles.map} />
        </View>
    )
}
const styles = StyleSheet.create({
    map: {
        flex: 1,
        height: 300,
        width: 300
    }
});

export default ArcMapComp;
