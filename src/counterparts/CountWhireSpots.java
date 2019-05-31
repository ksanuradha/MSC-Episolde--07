/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package counterparts;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.opencv.core.Mat;
import org.opencv.core.Point;
import org.opencv.core.Scalar;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.imgproc.Imgproc;

public class CountWhireSpots {

    public void drawALine(HashMap<Integer, ArrayList<Double>> avegXYCordinates) {
        Mat image = Imgcodecs.imread(".\\src\\com\\edu\\sliit\\img\\dilate.jpg", 3);
        Iterator hmIterator = avegXYCordinates.entrySet().iterator();
        int a = 0;
        while (hmIterator.hasNext()) {
            Map.Entry mapElement = (Map.Entry) hmIterator.next();
            ArrayList<Double> cordinates = ((ArrayList<Double>) mapElement.getValue());
            if (a == 0) {
                for (int i = 0; i < cordinates.size(); i++) {
                    //System.out.println("cordinates.get(i) : "+i+" "+cordinates.get(i));
                    Point pt1 = new Point(cordinates.get(i), 0);
                    Point pt2 = new Point(cordinates.get(i), 707);
                    Imgproc.line(image, pt1, pt2, new Scalar(0, 255, 0), 1);
                }
            } else {
                for (int i = 0; i < cordinates.size(); i++) {
                    //System.out.println("cordinates.get(i) : "+i+" "+cordinates.get(i));
                    Point pt1 = new Point(0, cordinates.get(i));
                    Point pt2 = new Point(664, cordinates.get(i));
                    Imgproc.line(image, pt1, pt2, new Scalar(0, 255, 0), 1);
                }
            }
            a++;
        }

        Imgcodecs.imwrite(".\\src\\com\\edu\\sliit\\img\\XYCordinates6.jpg", image);
        //new File(".\\src\\com\\edu\\sliit\\img\\Adooo.jpg").delete(); 
    }

    public void drawALine2() {

        Mat image = Imgcodecs.imread(".\\src\\com\\edu\\sliit\\img\\dilate.jpg", 3);
        Point pt1 = new Point(0, 27);
        Point pt2 = new Point(664, 27);
        int start = 27;
        Imgproc.line(image, pt1, pt2, new Scalar(0, 255, 0), 1);
        for (int i = 0; i < 28; i++) {
            for (int j = 0; j < 2; j++) {
                start = start + 6;
                pt1 = new Point(0, start);
                pt2 = new Point(664, start);
                Imgproc.line(image, pt1, pt2, new Scalar(0, 255, 0), 1);
            }
            start = start + 13;
            if (i != 27) {
                pt1 = new Point(0, start);
                pt2 = new Point(664, start);
                Imgproc.line(image, pt1, pt2, new Scalar(0, 255, 0), 1);
            }
        }

//        Point pt1 = new Point(0, 64);
//        Point pt2 = new Point(664, 64);
        // Imgproc.line(image, pt1, pt2, new Scalar(0, 255, 0), 1);
        Imgcodecs.imwrite(".\\src\\com\\edu\\sliit\\img\\fullY2.jpg", image);
    }

}
