package com.company;

import com.company.stringClasses.Coordinates;
import com.company.stringClasses.State;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class MapStates extends JFrame{
    private static final String title = "States";
    private static final boolean visible = true;
    private static final int width = 1366;
    private static final int height = 768;
    private List<State> states;

    public MapStates(List<State> states){
        super(title);
        this.setSize(width,height);
        this.setVisible(visible);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.states = states;
    }
    public void paint(Graphics g){
        List<List<Polygon>> listsPolygon = new ArrayList<>();

        for (int i = 0; i < states.size(); i++) {
            List<List<List<Coordinates>>> listCoordinates = new ArrayList<>();
            State state = new State();
            state = states.get(i);
            listCoordinates = state.getCoordinates();
            List<Polygon> list2Polygon = new ArrayList<>();
            for (int j = 0; j < listCoordinates.size(); j++) {
                List<List<Coordinates>> list1Coordinates = new ArrayList<>();
                list1Coordinates = listCoordinates.get(j);
                for (int q = 0; q < list1Coordinates.size(); q++) {
                    List<Coordinates> list2Coordinates = new ArrayList<>();
                    list2Coordinates = list1Coordinates.get(q);
                    if(list2Coordinates.size()!=1) {

                        int[] x = new int[list2Coordinates.size()];
                        int[] y = new int[list2Coordinates.size()];
                        for (int z = 0; z < list2Coordinates.size(); z++) {
                            Coordinates coordinates = new Coordinates();
                            coordinates = list2Coordinates.get(z);
                            double longitude = Double.parseDouble(coordinates.getLongitude())*10;
                            double latitude = Double.parseDouble(coordinates.getLatitude())*10;
                            x[z] = (int) longitude+1700;
                            y[z] = (int) latitude*(-1)+800;
                        }
                        Polygon polygon = new Polygon(x, y, x.length);
                        list2Polygon.add(polygon);
                    }
                    else if(list2Coordinates.size()==1) {
                        int[] x = new int[list1Coordinates.size()];
                        int[] y = new int[list1Coordinates.size()];
                        for (int z = 0; z < list1Coordinates.size(); z++) {
                            Coordinates coordinates = new Coordinates();
                            coordinates = list1Coordinates.get(z).get(0);
                            double longitude = Double.parseDouble(coordinates.getLongitude())*10;
                            double latitude = Double.parseDouble(coordinates.getLatitude())*10;
                            x[z] = (int) longitude+1700;
                            y[z] = (int) latitude*(-1)+800;
                        }
                        Polygon polygon = new Polygon(x, y, x.length);
                        list2Polygon.add(polygon);
                        break;
                    }


                }
            }
            listsPolygon.add(list2Polygon);

        }
        int i = 0;
        for (int q=0;q<listsPolygon.size();q++){
            for (int j=0;j<listsPolygon.get(i).size();j++){
                Polygon polygon=listsPolygon.get(i).get(j);
                g.setColor(new Color(255 - i*5,0,0));
                g.fillPolygon(polygon);
            }
            i++;

        }
    }

}


