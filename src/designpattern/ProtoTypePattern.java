package designpattern;

import java.util.HashMap;
import java.util.Map;
/*
Prototype allows us to hide the complexity of making new instances from the client.
The concept is to copy an existing object rather than creating a new instance from scratch,
something that may include costly operations. The existing object acts as a prototype and contains
 the state of the object. The newly copied object may change same properties only if required.
 This approach saves costly resources and time, especially when the object creation is a heavy process.

The prototype pattern is a creational design pattern. Prototype patterns is required,
 when object creation is time consuming, and costly operation, so we create object with
  existing object itself. One of the best available way to create object from existing objects
   are clone() method. Clone is the simplest approach to implement prototype pattern.
    However, it is your call to decide how to copy existing object based on your business model.
 */
public class ProtoTypePattern {
    static abstract class Color implements Cloneable
    {

        protected String colorName;

        abstract void addColor();

        public Object clone()
        {
            Object clone = null;
            try
            {
                clone = super.clone();
            }
            catch (CloneNotSupportedException e)
            {
                e.printStackTrace();
            }
            return clone;
        }
    }

    static class blueColor extends Color
    {
        public blueColor()
        {
            this.colorName = "blue";
        }

        @Override
        void addColor()
        {
            System.out.println("Blue color added");
        }

    }

    static class blackColor extends Color{

        public blackColor()
        {
            this.colorName = "black";
        }

        @Override
        void addColor()
        {
            System.out.println("Black color added");
        }
    }

   static class ColorStore {

        private static Map<String, Color> colorMap = new HashMap<String, Color>();

        static
        {
            colorMap.put("blue", new blueColor());
            colorMap.put("black", new blackColor());
        }

        public static Color getColor(String colorName)
        {
            return (Color) colorMap.get(colorName).clone();
        }
    }

    public static void main (String[] args)
    {
        ColorStore.getColor("blue").addColor();
        ColorStore.getColor("black").addColor();
        ColorStore.getColor("black").addColor();
        ColorStore.getColor("blue").addColor();
    }
}
