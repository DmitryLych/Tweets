package com.company.reports;

import com.company.interfaces.IReport;
import com.company.stringClasses.Coordinates;
import com.company.stringClasses.State;
import org.omg.PortableServer.POA;

import javax.swing.*;
import java.awt.*;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Shows the staff from which the maximum number of tweets was sent
 */
public class Report3 implements IReport<List<State>>{
 public static List<List<Polygon>> polygon(List<State> states) throws FileNotFoundException {
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
       double longitude = Double.parseDouble(coordinates.getLongitude()) * 1000000;
       double latitude = Double.parseDouble(coordinates.getLatitude()) * 1000000;
       x[z] = (int) longitude;
       y[z] = (int) latitude;
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
       double longitude = Double.parseDouble(coordinates.getLongitude()) * 1000000;
       double latitude = Double.parseDouble(coordinates.getLatitude()) * 1000000;
       x[z] = (int) longitude;
       y[z] = (int) latitude;
      }
      Polygon polygon = new Polygon(x, y, x.length);
      list2Polygon.add(polygon);
      break;
     }


    }
   }
   listsPolygon.add(list2Polygon);
  }
  return listsPolygon;
 }
@Override
 public void report(List<State> states) throws FileNotFoundException {
  List<List<Polygon>> listPolygon = polygon(states);
  BufferedReader in;
  int []array=new int[52];
  String s;
  try {
   in = new BufferedReader(new FileReader("Report3.txt"));
   while ((s = in.readLine()) != null) {
    String[] stroka = s.split(" ");
    double longitude=Double.parseDouble(stroka[1])*1000000;
    double latitude=Double.parseDouble(stroka[2])*1000000;
    for(int i=0;i<listPolygon.size();i++)
    {

     for (int j=0;j<listPolygon.get(i).size();j++) {
      Polygon polygon=new Polygon();
      polygon = listPolygon.get(i).get(j);
      if (polygon.contains((int) longitude, (int) latitude)) {
       array[i]++;
       break;
      }
     }
    }
   }
  } catch (IOException e) {
   e.printStackTrace();
  }
  int max=array[0];
  int index=0;
  for (int i=0;i<array.length;i++)
  {
     if(array[i]>max)
     {
      max=array[i];
      index=i;
     }
  }
  State state=new State();
  state=states.get(index);
  System.out.println(state.getWord());
 }
}