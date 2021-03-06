package com.conflux.killer.client.ui;

import com.conflux.killer.client.dom.Character;
import com.conflux.killer.client.dom.ObjectCenter;
import com.conflux.killer.core.map.SceneData;

import java.awt.*;

public class SceneRenderImpl implements SceneRender {
    private SceneData sceneData;
    private ObjectCenter objectCenter;

    public SceneRenderImpl(SceneData sceneData, ObjectCenter objectCenter) {
        this.sceneData = sceneData;
        this.objectCenter = objectCenter;
    }

    @Override
    public void renderScene(Graphics g) {
        Character me = objectCenter.getMe();
        if (me == null) {
            return;
        }
        Point p = me.position;

        int[][] map = sceneData.getView();

        int i = p.x;
        int j = p.y;

        int minI = i - 6;
        int minJ = j - 6;
        int maxI = i + 5;
        int maxJ = j + 5;

        for (j = minJ; j < maxJ; j ++) {
            for(i = minI; i < maxI; i ++) {
                if (i >= 0 && i < map.length && j >= 0 && j < map[i].length){
                    g.drawImage(Images.background.get(0), (i - minI) * 60, (j - minJ)  * 60, null);
                    if (map[i][j] == 1) {
                        g.drawImage(Images.background.get(1), (i - minI) * 60, (j - minJ)  * 60, null);
                    }
                }
            }
        }
    }
}
